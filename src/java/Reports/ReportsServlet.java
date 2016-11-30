package Reports;

import Data.ConnectionPool;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM user ORDER BY lastname";
            ResultSet results = statement.executeQuery(query);
            
            //Enter data into spreadsheet
            int i = 2;
            while(results.next()){
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(results.getInt("username"));
                row.createCell(1).setCellValue(results.getInt("address"));
                row.createCell(2).setCellValue(results.getInt("city"));
                row.createCell(3).setCellValue(results.getInt("email"));
                row.createCell(4).setCellValue(results.getInt("firstname"));
                row.createCell(5).setCellValue(results.getInt("lastname"));
                row.createCell(6).setCellValue(results.getInt("password"));
                row.createCell(7).setCellValue(results.getInt("phone"));
                row.createCell(8).setCellValue(results.getInt("salt"));
                row.createCell(9).setCellValue(results.getInt("state"));
                row.createCell(10).setCellValue(results.getInt("zip"));
                i++;
            }
            results.close();
            statement.close();
            connection.close();         
        }
        catch(SQLException e)
        {
            this.log(e.toString());
            System.out.println("Didn't Work");
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
        doPost(request, response); 
    }

}
