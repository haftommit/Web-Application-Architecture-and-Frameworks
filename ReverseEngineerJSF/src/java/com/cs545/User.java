package com.cs545;
import java.io.Serializable; 
import javax.inject.Named;

/**
 *
 * @author Haftom Alemayehu <Haftom Alemayehu>
 */

 
public class User implements Serializable
{
    private boolean error = false;
    private String name;
    private int age;
    private String password;
    
    private int wrongAttemptCount = 0;
 
    
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
        return error;
    }
    
    public void setError(boolean error){
        this.error = error;
    } 
    
    public void setWrongAttemptCount(int wrongAttemptCount) {
        this.wrongAttemptCount = wrongAttemptCount;
    }

    public int getWrongAttemptCount() {
        return wrongAttemptCount;
    }
  
}