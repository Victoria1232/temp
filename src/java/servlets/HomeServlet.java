
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
 * @author Victo
 */
public class HomeServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
       
        HttpSession session = request.getSession();
         String username = (String) session.getAttribute("username");
        
        if (username != null)  {
            
             request.setAttribute("username", username);
             getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response); // use / before WEB
             return;
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // use / before WEB
        return;
        }
       
        
    
       
        
   
       
   }
   
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
 
  
       /*PARAMITERS*/
 

       
    
         getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
         return;
         
   
      
        
   }
}
