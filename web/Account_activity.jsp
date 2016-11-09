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
<img src="styles/bank.jpg" alt="bank vault" width="320" height="250">
<p><span class="resort">Titan Banks</span> online service offers a modern banking experience on our Hi-Tech application developed in house.
  This is a place holder for the Account Activity Page.</p>
<p>
<span>First Name: ${user.firstName}<br></span>
<span>Last Name: ${user.lastName}<br></span>
<span>Email: ${user.email}<br></span>
<span>Phone: ${user.phone}<br><br></span>
</p>
  <div class="clear">Titan Bank<br>
        5555 Limerick Drive<br>
        Tampa, FL &nbsp;33610<br>
  <br> 
  <a id="mobile" href="tel:888-555-5555">888-555-5555</a> <span id="desktop">888-555-5555</span>
  <br>
  <br>
  </div>
</main>
<c:import url="/includes/footer.jsp" />
