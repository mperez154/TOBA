package newCustomer;

import User.User;
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
@WebServlet(urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {   
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
        String url = "/Success.jsp";
        
        String fName = request.getParameter("myFName");
        String lName = request.getParameter("myLName");
        String eMail = request.getParameter("myEmail");
        String phone = request.getParameter("myPhone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String userName = request.getParameter("myLName") + request.getParameter("zip");
        String password = "welcome1";
        
        String message = "";
        
        //Creating a user object
        User user = new User(fName, lName, eMail, phone, address, city, state, zip, userName, password);
        request.setAttribute("user", user);
        
        if(fName == null || fName.isEmpty() || lName == null || lName.isEmpty() || eMail == null || eMail.isEmpty()
                || phone == null || phone.isEmpty() || address == null || address.isEmpty() || city == null
                || city.isEmpty() || state == null || state.isEmpty() || zip == null || zip.isEmpty())
        {
            //Direct back to form if any fields are blank.
            message = "Please fill in all fields";
            url = "/new_customer.jsp";   
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
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        
    }
}
