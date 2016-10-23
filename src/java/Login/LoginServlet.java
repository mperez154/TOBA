package Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco
 */

public class LoginServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doPost(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String url = "/login.html";
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        if("jsmith@toba.com".equals(userName) && "letmein".equals(password))
        {
            //Direct to account activity page if username and password are correct...
            url = "/Account_activity.html";   
        }
        else
        {
            //Direct to login_failure page if either username or password is incorrect
            url = "/Login_failure.html";          
        }
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        
    }
}
