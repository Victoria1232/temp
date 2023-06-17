/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 * Description handles all authentication and creation/ destruction of sessions 
 * @author mfgperez
 */
public class LoginServlet extends HttpServlet {

  
   @Override // displays login form , responsible for loging out the user 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  // on start up
       
               
        
          HttpSession session = request.getSession();
          String logout = request.getParameter("logout"); 
          String username = (String) session.getAttribute("username"); 
          
     
          
      
             if (logout != null) {

              request.setAttribute("logoutMessage", "You have been logged out");
              session.invalidate();
              session = request.getSession();
             
              getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // use / before WEB
              return;

        }

             
            
    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // use / before WEB
    return;
        
       
   }
   
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   

        String username = request.getParameter("username");
        String password = request.getParameter("password");
   
        AccountService  acount = new AccountService();
        User newUser;
        HttpSession session = request.getSession();
        
        // if username or password is not null 
        if (username != null && password != null)  {
            
              // call login method 
          User user =  acount.login(username, password ); 
                 // if username is abe or barb send them to the home page , the nset attribute user name to username 
                 if (user.getUserName().equals("abe") || user.getUserName().equals("barb"))  {
              
                    session.setAttribute("username", username);
                    
                    request.setAttribute("username" , username);
                    // redirect to home page 
                  getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
               
                    // add - /home to MyLogin
             }
                 
        }
        else { // ellse throw error 
              request.setAttribute("error", "invalid username or passsword");
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             return; 
        }
        
            
              
               
        
      
        
   }
   
  
}
