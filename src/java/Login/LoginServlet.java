package Login;

import Account.Account;
import Data.AccountDB;
import Data.UserDB;
import User.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
                
        String url = "/Account_activity.jsp";
        
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
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
//        if(user != null && userName.equals(user.getUserName()) && password.equals(user.getPassword()))
//        {
//            //Direct to account activity page if username and password are correct...
//            url = "/Account_activity.jsp";   
//            //UserDB.selectUsers(userName);
//        }
//        else
//        {
//            //Direct to login_failure page if either username or password is incorrect
//            url = "/Login_failure.jsp";          
//        }
        
        if(UserDB.userExists(userName)){
            url = "/Account_activity.jsp";
            user = UserDB.selectUsers(userName);
            session.setAttribute("user" , user);
            Account checking = AccountDB.selectChecking(userName, "Checking");
            session.setAttribute("checking", checking);
            Account savings = AccountDB.selectSavings(userName, "Savings");
            session.setAttribute("savings", savings);
        }
        else {
            url = "/Login_failure.jsp";
            
        }
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        
    }
}
