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
import Data.TransferDB;
import TransferClass.Transfer;
import java.util.ArrayList;
import java.util.List;

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
        
        String url = "/Account_activity.jsp";
        String message = "";
                
        //Getting/Creating a session
        HttpSession session = request.getSession();
        
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String amount = request.getParameter("amount");
        User user = (User) session.getAttribute("user");
        Account checking = (Account) session.getAttribute("checking");
        Account savings = (Account) session.getAttribute("savings");
        Transfer transfer = new Transfer();
        
        
        if(from == null || from.isEmpty() || to == null || to.isEmpty() || amount == null || amount.isEmpty())
        {
            //Direct back to form if any fields are blank.
            message = "Please fill in all fields";
            url = "/Transfer.jsp";   
        }
        else
        {
            if(to.equals("Checking"))
            {
                checking.credit(Double.parseDouble(amount));
                savings.debit(Double.parseDouble(amount));
                transfer.setAmount(Double.parseDouble(amount));
                transfer.setFrom(from);
                transfer.setToAccount(to);
                transfer.setUser(user);
            }
            else
            {
                savings.credit(Double.parseDouble(amount));
                checking.debit(Double.parseDouble(amount));
                transfer.setAmount(Double.parseDouble(amount));
                transfer.setFrom(from);
                transfer.setToAccount(to);
                transfer.setUser(user);
            }
                                 
            AccountDB.update(checking);
            AccountDB.update(savings);
            TransferDB.insert(transfer);
            url = "/Account_activity.jsp";
            message = "Transfer was successful";          
        }
        
        try{
            //Retrieve users from DB
            List resultsFromQuery = TransferDB.selectAllTransfers();         
            
            //Create an arrayList of all Users
            ArrayList<Transfer> allTransfers = new ArrayList<>();
            allTransfers.addAll(resultsFromQuery);
                  
            boolean show = true;
            //Set all attributes
            session.setAttribute("allTransfers", allTransfers);
            session.setAttribute("show", show);
            
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
}