/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mum.cs545;

/**
 *
 * @author Haftom Alemayehu <Haftom Alemayehu>
 */

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("usr")
@SessionScoped
public class User implements Serializable
{
    private boolean bError = false;
    private String name;
    private int age;
    private String password;
    
    private int wrongAttemptCount = 0;
    private boolean lockedOut = false;
    
    // value="#{user.name}"
    public String getName()
    {
        return name;
    }
    public void setName(String newValue)
    {
        name = newValue;
    }
     
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int age){
       this.age = age;
    }
    // value="#{user.password}"
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String newValue)
    {
        password = newValue;
    }
 
    // rendered="#{user.error}"
    public boolean isError()
    {
        return bError;
    }
    
    // rendered="#{user.lockedOut}"
    public boolean isLockedOut(){
        return lockedOut;
    }
 
    // action="#{user.onLogin}"
    // As we shall see, the return value indicates what the next page will be
    public String onLogin()
    {
        if(lockedOut){ 
            return "login";
        }
        
        bError = !password.equals("apple");
        if (bError){
            wrongAttemptCount++;
            if(wrongAttemptCount == 3){
                bError = false;
                lockedOut = true;
            }
            return "login";  // redisplay login.xhtml so that user can reenter the password
        }
        else{
            
            return "welcome";  // display welcome.xhtml
            
        }
    }
}