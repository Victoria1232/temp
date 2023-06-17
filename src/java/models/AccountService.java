/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author mfgperez
 */
public class AccountService {
    
       private User abe = new User("abe", "password");
       private User barb = new User("barb", "password");
    
    public User login(String username , String password) {
        
       
        if (abe.getPassword().equals( password )  && abe.getUserName().equals(username) ) {
            
             abe.setPassword(null);
             return  abe; 
        }
        else if (barb.getPassword().equals( password)  && barb.getUserName().equals(username)) {
            
              barb.setPassword(null);
              return  barb; 
        }
       // else {
          // return  new User("" , "");
        //}
           
        return null;
        
    }
}
