<%-- 
    Document   : login
    Created on : Apr 25, 2016, 8:50:28 PM
    Author     : Haftom Alemayehu <Haftom Alemayehu>
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.cs545.User" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="POST">
            <h3>Please enter your name and password.</h3>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" required="true"/></td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td>
                        <input type="number" min="10" max="125" name="age" required="true"/> 
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>  
            
            <div>${error}</div> 
            
            <p><input type="submit" value="Login">
            <form>
      <body>
  </html>
