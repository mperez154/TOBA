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
               <th>Description</th>
               <th>Amount</th>
               <th>Balance</th>
            </tr>
            <tr>
                <td>McDonalds, Tampa</td>
                <td>$7.99</td>
                <td>$1099.99</td>
            </tr>
            <tr>
                <td>Target, Brandon</td>
                <td>$17.99</td>
                <td>$1099.99</td>
            </tr>
            <tr>
                <td>Home Depot, Tampa</td>
                <td>$102.99</td>
                <td>$1099.99</td>
            </tr>
            <tr>
                <td>Publix, Tampa</td>
                <td>$107.99</td>
                <td>$1099.99</td>
            </tr>
            <tr>
                <td>SPC, Clearwater</td>
                <td>$745.55</td>
                <td>$1099.99</td>
            </tr>
            
        </table>
        
        <p><br>*Table above is a place holder until we get data<br></p>
        <!--<span>First Name: ${user.firstName}<br></span>
<span>Last Name: ${user.lastName}<br></span>
<span>Email: ${user.email}<br></span>
<span>Phone: ${user.phone}<br><br></span>
</p>-->
  <div class="clear">
  
  </div>
</main>
<c:import url="/includes/footer.jsp" />
