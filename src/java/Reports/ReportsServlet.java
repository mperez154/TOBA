package Reports;

import Data.UserDB;
import User.User;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

@WebServlet(name = "ReportsServlet", urlPatterns = {"/ReportsServlet"})
public class ReportsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Create the workbook, worksheet and title row
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("User Table");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("The User Table");
        
        try{
            List resultsFromQuery = UserDB.selectAllUsers();
            int i = 2;
            Iterator<User> iterator = resultsFromQuery.iterator();
		while (iterator.hasNext()) {
			//System.out.println(iterator.next().getUserName());
                        row = sheet.createRow(i);
                        row.createCell(0).setCellValue(iterator.next().getUserName());                   
                        i++;
		}      
        }
        catch(Exception e)
        {
            this.log(e.toString());
            System.out.println("Msg 1029: Unable to complete request");
        }
        
        //set the response headers
        response.setHeader("content-disposition", "attachment; filename=users.xls");
        response.setHeader("cash-control", "no-cache");
        
        //get the output stream and send the workbook to the browser
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); 
    }

}
