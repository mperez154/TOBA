package Login; 
 
 import Account.Account; 
 import Data.AccountDB; 
 import Data.TransferDB; 
 import Data.UserDB; 
 import PWUtil.PasswordUtil; 
 import TransferClass.Transfer; 
 import User.User; 
 import java.io.IOException; 
 import java.security.NoSuchAlgorithmException; 
 import java.util.ArrayList; 
 import java.util.List; 
 import javax.servlet.ServletException; 
 import javax.servlet.http.HttpServlet; 
 import javax.servlet.http.HttpServletRequest; 
 import javax.servlet.http.HttpServletResponse; 
 import javax.servlet.http.HttpSession; 
 
 public class LoginServlet extends HttpServlet { 
     
     @Override 
     protected void doGet(HttpServletRequest request, HttpServletResponse response) 
             throws ServletException, IOException { 
          
         doPost(request, response); 
     } 
      
     @Override 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) 
             throws ServletException, IOException { 
          
         String url = "/Account_activity.jsp"; 
          
         //Getting a session 
         HttpSession session = request.getSession(); 
               
          //Get password from the form         
         String userName = request.getParameter("userName"); 
         String password = request.getParameter("password"); 
 
         if(UserDB.userExists(userName)){ 
             //Create instance of User 
             User dbUser = UserDB.selectUsers(userName); 
             session.setAttribute("user" , dbUser); 
             Account checking = AccountDB.selectChecking(userName, "Checking"); 
             session.setAttribute("checking", checking); 
             Account savings = AccountDB.selectSavings(userName, "Savings"); 
             session.setAttribute("savings", savings);  
                  
             //List<Transfer> allTransfers = TransferDB.selectAllTransactions(userName); 
             //session.setAttribute("allTransfers", allTransfers);                
         } 
         else { 
             url = "/Login_failure.jsp";             
         } 
          
         try{ 
             //Retrieve users from DB 
             List resultsFromQuery = TransferDB.selectAllTransactions();          
              
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
