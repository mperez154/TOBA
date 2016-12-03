package Reports;

import Data.UserDB;
import User.User;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

@WebServlet(name = "ReportsDownload", urlPatterns = {"/ReportsDownload"})
public class ReportsDownload extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Create the workbook, worksheet and title row
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("User Table");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("New Users - Last Month");
        //Merge first row which contains title
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
        Row row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("First Name");
        row2.createCell(1).setCellValue("Last Name");
        row2.createCell(2).setCellValue("Username");
        
        //widen columns to make all content visible
        sheet.setDefaultColumnWidth(15);
        
        
        try{
            List resultsFromQuery = UserDB.selectAllUsers();
            LinkedList<User> linkedList = new LinkedList<>(resultsFromQuery);

            ArrayList<User> allUsers = new ArrayList<>();
            allUsers.addAll(resultsFromQuery);
            request.setAttribute("allUsers", allUsers);            
            
            int i = 2;
            //Iterator<User> iterator = resultsFromQuery.iterator();
		//while (iterator.hasNext()) {
			//System.out.println(iterator.next().getUserName());
                        //row = sheet.createRow(i);
                        //row.createCell(0).setCellValue(iterator.next().getUserName()); 
                        //i++;
		//} 
            ListIterator<User> listIterator = linkedList.listIterator();
            while(listIterator.hasNext()){
                //System.out.println("TEST: " + listIterator.next().getUserName());
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(listIterator.next().getFirstName()); 
                row.createCell(1).setCellValue(listIterator.previous().getLastName());
                row.createCell(2).setCellValue(listIterator.next().getUserName());
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
