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

/**
 * Description handles all authentication and creation/ destruction of sessions 
 * @author mfgperez
 */
public class LoginServlet extends HttpServlet {

  
   @Override // displays login form , responsible for loging out the user 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
       
       
  
       
       
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // use / before WEB
    
    
       
   }
   
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
 
  
       /*PARAMITERS*/
 
        // get path 
        //String path = getServletContext().getRealPath("/WEB-INF/note.txt");
       
        //String newTitle = request.getParameter("title");
       // String newContents = request.getParameter("contents");
        
      
        

        
       
    
         getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
         
   
      
        
   }
   
  
}
