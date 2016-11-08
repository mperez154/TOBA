package ChangePassword;

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
        
        //Getting a session
        HttpSession session = request.getSession();
        //Getting user from session
        User user = (User) session.getAttribute("user");
        //If user doesn't exist, create one
        if(user == null)
        {
            user = new User();       
        }
        
        String url = "/Account_activity.jsp";
             
        //Get the username and password from the form
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        //Change the password on the user object
        user.setPassword(password);
        
        String message = "";
        
        //Will redirect back to reset password page if any fields are blank
        if(userName.isEmpty() || password.isEmpty())
        {
            //Direct back to form if any fields are blank.
            message = "Please fill in all fields";
            url = "/passwordReset.jsp";   
        }
        
        //Error message to be displayed if needed
        request.setAttribute("message", message);

        //Setting session attributes
        session.setAttribute("userName", userName);
        session.setAttribute("password", password);
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        
        
    }
    
}
