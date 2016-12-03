package Reports;

import Data.UserDB;
import User.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ReportsServlet", urlPatterns = {"/ReportsServlet"})
public class ReportsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/admin/reports.jsp";
        
        //Getting/Creating a session
        HttpSession session = request.getSession();
        
        try{
            //Retrieve users from DB
            List resultsFromQuery = UserDB.selectAllUsers();         
            
            //Create an arrayList of all Users
            ArrayList<User> allUsers = new ArrayList<>();
            allUsers.addAll(resultsFromQuery);
                  
            boolean show = true;
            //Set all attributes
            request.setAttribute("allUsers", allUsers);
            request.setAttribute("show", show);
            
        }
        catch(Exception e)
        {
            this.log(e.toString());
            System.out.println("Msg 1029: Unable to complete request");
        }
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response); 
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); 
    }

}
