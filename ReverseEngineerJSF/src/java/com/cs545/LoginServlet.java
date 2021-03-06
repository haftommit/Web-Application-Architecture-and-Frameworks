package com.cs545;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Haftom Alemayehu <Haftom Alemayehu>
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet{

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        User user = new User();
        Object obj = session.getAttribute("user");
        if (obj != null) {
            user = (User) obj;
        }else{ 
            session.setAttribute("user", user);
        }

        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setAge(Integer.parseInt(request.getParameter("age")));


        UserManager userManager = new UserManager();
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        switch (userManager.performLoginAction(user)) {
            case APPROVED:
                dispatcher = request.getRequestDispatcher("welcome.jsp");
                break;
            case FAILED:
                request.setAttribute("error", "Bad password"); 
                break;
            case LOCKEDOUT:
                request.setAttribute("error", "Sorry, You Attempted morethan 3 times."); 
                break;
        } 
        dispatcher.forward(request, response); 
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
