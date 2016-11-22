package ChangePassword;

import Data.UserDB;
import User.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/changePassword"})
public class ChangePasswordServlet extends HttpServlet {
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);       
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/Account_activity.jsp";
        String message = "";
        
        //Getting a session
        HttpSession session = request.getSession();
        //Getting user from session
        User user = (User) session.getAttribute("user");
        //If user doesn't exist, create one
        if(user == null)
        {
            url = "/new_customer.jsp"; 
        }
             
        //Get password from the form
        String password = request.getParameter("password");
   
        //Will redirect back to reset password page if any fields are blank
        if(password.isEmpty())
        {
            //Direct back to form if any fields are blank.
            message = "Please fill in all fields";
            url = "/passwordReset.jsp";   
        }
        
        //Change the password on the user object
        if(user != null)
        {
            user.setPassword(password);
            UserDB.update(user);
        }
        
        //Error message to be displayed if needed
        request.setAttribute("message", message);

        //Setting user object again w/ the new password
        session.setAttribute("user", user);
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);    
    }   
}
