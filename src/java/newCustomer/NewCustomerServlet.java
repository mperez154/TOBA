package newCustomer;

import Account.Account;
import Data.AccountDB;
import User.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.UserDB;
import PWUtil.PasswordUtil;
import java.security.NoSuchAlgorithmException;

@WebServlet(urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {   
    
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
        
        String url = "/Success.jsp";
        
        String fName = request.getParameter("myFName");
        String lName = request.getParameter("myLName");
        String eMail = request.getParameter("myEmail");
        String phone = request.getParameter("myPhone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String userName = lName + zip;
        String password = "welcome1";
        String tempPassword = "welcome1";
        
        //Variables for hashing/salting password
        String hashedPassword = "";
        String salt = "";
        String saltedAndHashedPassword = "";
        
        String message = "";
        
        if(fName == null || fName.isEmpty() || lName == null || lName.isEmpty() || eMail == null || eMail.isEmpty()
                || phone == null || phone.isEmpty() || address == null || address.isEmpty() || city == null
                || city.isEmpty() || state == null || state.isEmpty() || zip == null || zip.isEmpty())
        {
            //Direct back to form if any fields are blank.
            message = "Please fill in all fields";
            url = "/new_customer.jsp";   
        }
        
        //Creating a user object
        User user = new User(fName, lName, eMail, phone, address, city, state, zip, userName, password, salt);
        
        if(UserDB.emailExists(eMail)){
            message="This email address already exists.<br>" +
                    "Please enter another email address.";
            url = "/index.jsp";
        }
        else {
            message = ""; 
            url = "/Success.jsp";
            
            //Hash and salt the password before inserting into DB
            try{
                hashedPassword = PasswordUtil.hashPassword(password);
                salt = PasswordUtil.getSalt();
                saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);
                                
            } catch(NoSuchAlgorithmException ex){
                hashedPassword = ex.getMessage();
                saltedAndHashedPassword = ex.getMessage();
            }      
            
            //Update user password before storing in DB
            user.setPassword(saltedAndHashedPassword);
            user.setSalt(salt);
            
            //Insert user into User DB
            UserDB.insert(user);
            
            //Annonomoysly creating two new accounts
            AccountDB.insert(new Account(10.00, "Checking", userName));
            AccountDB.insert(new Account(25.00, "Savings", userName));           
        }
        user.setPassword(tempPassword); //Set user password in session to tempPassword (unhashed)
        
        session.setAttribute("user", user);
        
        request.setAttribute("message", message);
        request.setAttribute("fName", fName);
        request.setAttribute("lName", lName);
        request.setAttribute("eMail", eMail);
        request.setAttribute("phone", phone);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("zip", zip);

        
        //Set request attribute for password
        request.setAttribute("hashedPassword", hashedPassword);
        request.setAttribute("salt", salt);
        request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);
        
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response); 
    }
}