<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>
<c:import url="http://localhost:8080/TOBA/includes/navigation.html" />
<main>
<h3>Admin Console: <a href="http://localhost:8080/TOBA/Download">Download Spreadsheet Report</a></h3>
            
<h3>Users created last month</h3>
            <form action="http://localhost:8080/TOBA/ReportsView" method="post">      
            <input type="submit" value="Retreive Data" class="margin_left">
        </form>
<!--USING THIS IF TAG TO HIDE TABLE BEFORE CLICKING RETRIEVE DATA-->
<c:if test="${show}">  
        <table>
            <tr>               
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                
            </tr>        
             <c:forEach items="${allUsers}" var="users">
                 <tr>
                     <td>${users.getFirstName()}</td>
                     <td>${users.getLastName()}</td>
                     <td>${users.getUserName()}</td> 
                 </tr>
             </c:forEach>            
        </table>
</c:if>
               
  <div class="clear">
  
  </div>
</main>
<c:import url="/includes/footer.jsp" />
