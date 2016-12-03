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
                <th>Current Balance</th>
            </tr>
            <tr>
                <td>${checking.type}</td>
                <td>$${checking.balance}</td>
            </tr>
            <tr>
                <td>${savings.type}</td>
                <td>$${savings.balance}</td>
            </tr>  
        </table>
            <br>
            <H3>Recent Transactions</h3>
        <c:if test="${show}">  
        <table>
            <tr>               
                <th>From Account</th>
                <th>To Account</th>
                <th>Amount</th>
                
            </tr>        
             <c:forEach items="${allTransfers}" var="transfer">
                 <tr>
                     <td>${transfer.getFrom()}</td>
                     <td>${transfer.getToAccount()}</td>
                     <td>$${transfer.getAmount()}</td> 
                 </tr>
             </c:forEach>            
        </table>
</c:if>
               
  <div class="clear">
  
  </div>
</main>
<c:import url="/includes/footer.jsp" />
