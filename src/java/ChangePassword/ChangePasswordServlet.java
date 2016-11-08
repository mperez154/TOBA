package ChangePassword;

import User.User;
import User.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        
        String fName = request.getParameter("myFName");
        String lName = request.getParameter("myLName");
        String eMail = request.getParameter("myEmail");
        String phone = request.getParameter("myPhone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        
        
        String message = "";
        
        User user = new User(fName, lName, eMail, phone, address, city, state, zip, userName, password);
        request.setAttribute("user", user);
        //user.setPassword(password);
        
        
        if(userName.isEmpty() || password.isEmpty())
        {
            //Direct back to form if any fields are blank.
            message = "Please fill in all fields";
            url = "/passwordReset.jsp";   
        }
        
        request.setAttribute("message", message);
        request.setAttribute("fName", fName);
        request.setAttribute("lName", lName);
        request.setAttribute("eMail", eMail);
        request.setAttribute("phone", phone);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("zip", zip);
        request.setAttribute("userName", userName);
        request.setAttribute("password", password);
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        
        
    }
    
}
