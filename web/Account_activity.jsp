<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />

<main>
<h2>Account Activity</h2>
<!-- Displaying welcome message if user is logged in-->
<c:choose>
    <c:when test="${user != null}">
        <p><i>Welcome, ${user.firstName} ${user.lastName}</i></p>
    </c:when>
    <c:otherwise>
        <p><i>Not logged in</i></p>
    </c:otherwise>
</c:choose>
        <table>
            <tr>
                <th>Account</th>
                <th>Balance</th>
            </tr>
            <tr>
                <td>${checking.type}</td>
                <td>$${checking.balance}0</td>
            </tr>
            <tr>
                <td>${savings.type}</td>
                <td>$${savings.balance}0</td>
            </tr>  
        </table>
            <br>
            <H3>This will eventually hold transaction info</h3>
            <p><a href="Download">Download Spreadsheet Report</a></p>
        <table>
            <tr>
                <th>Account</th>
                <th>Balance</th>
            </tr>
            <tr>
                <td>${checking.type}</td>
                <td>$${checking.balance}0</td>
            </tr>
            <tr>
                <td>${savings.type}</td>
                <td>$${savings.balance}0</td>
            </tr>  
        </table>
        
        <p><br>*Table above is a place holder until we get data<br></p>
       
  <div class="clear">
  
  </div>
</main>
<c:import url="/includes/footer.jsp" />
