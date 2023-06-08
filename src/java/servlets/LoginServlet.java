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
       
       
        
        

                 
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // use / before WEB
    
    
        
       
   }
   
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   

        String username = request.getParameter("username");
        String password = request.getParameter("password");
   
        
        if (username == null || password == null || username.equals("") || password.equals("")) {
            
                     request.setAttribute("username", username);
                     request.setAttribute("password", password);
                     request.setAttribute("error", "invalid username or passsword");
                     getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return;
        }
        
   
                 AccountService  acount = new AccountService();
          
                 User user =  acount.userLogin(username, password); 
        
                 HttpSession session = request.getSession();
        
                  
                    session.setAttribute("user", user);
                    
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
        
 
       
    
         getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
         
   
      
        
   }
   
  
}
