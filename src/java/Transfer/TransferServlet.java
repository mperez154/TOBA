package Transfer;

import Account.Account;
import User.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.AccountDB;

@WebServlet(urlPatterns = {"/TransferServlet"})
public class TransferServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Getting/Creating a session
        HttpSession session = request.getSession();
        
        String url = "/Account_activity.jsp";
        String message = "";
        
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String amount = request.getParameter("amount");
        User user = (User) session.getAttribute("user");
        Account checking = (Account) session.getAttribute("checking");
        Account savings = (Account) session.getAttribute("savings");
        
        if(from == null || from.isEmpty() || to == null || to.isEmpty() || amount == null || amount.isEmpty())
        {
            //Direct back to form if any fields are blank.
            message = "Please fill in all fields";
            url = "/Transfer.jsp";   
        }
        else
        {
            //Somewhat working, currently writing to all rows in DB, need it to write only to 1
            checking.setBalance(Double.parseDouble(amount));
            savings.setBalance(100.00);
                       
            AccountDB.update(checking);
            AccountDB.update(savings);
            url = "/Account_activity.jsp";
            message = "Successful";
            
        }
        
        session.setAttribute("user" , user);
        Account account = AccountDB.selectChecking(user.getUserName(), "Checking");
        session.setAttribute("account", account);
        Account account2 = AccountDB.selectSavings(user.getUserName(), "Savings");
        session.setAttribute("account2", account2);
        
      
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response); 
    }
    
}
