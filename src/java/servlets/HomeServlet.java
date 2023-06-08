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
import models.User;

/**
 *
 * @author mfgperez
 */
public class HomeServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
       
        HttpSession session = request.getSession();
     
        User user = (User) session.getAttribute("user");
        
    
        request.setAttribute("username", user.getUserName());
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response); // use / before WEB
    
    
       
   }
   
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
 
  
       /*PARAMITERS*/
 
         String action = request.getParameter("action"); 
           
        HttpSession session = request.getSession();
        
       if (action != null && action.equals("Logout"))  {
           
           session.invalidate();
           
           session = request.getSession();
            request.setAttribute("error", "invalid username or passsword");
           
       }


       
    
         getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
         
   
      
        
   }
}
