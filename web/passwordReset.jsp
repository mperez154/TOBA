<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />

<main>
<h2>Banking made easy, register today!</h2>
<img src="styles/bank.jpg" alt="bank vault" width="320" height="250">
<p><span class="resort">Titan Banks</span> online service offers a modern banking experience on our Hi-Tech application developed in house.
  Login or create an online profile today to start using the Titan Online Banking Application.</p>
<p id="errorMessage"><i>${message}</i></p>
<form method="post" action="changePassword">
<input type="hidden" name="myFName" id="myFName" value="${fName}">
<input type="hidden" name="myLName" id="myLName" value="${lName}" >
<input type="hidden" name="myEmail" value="${eMail}" id="myEmail" >
<input type="hidden" value="${phone}" name="myPhone" id="myPhone">
<input type="hidden" name="address" id="address" value="${address}" ></textarea>
<input name="city" value="${city}" id="city" type="hidden">
<input name="state" value="${state}" id="state" type="hidden">
<input name="zip" value="${zip}" id="zip" type="hidden">
<label for="userName">User Name:</label><input type="text" name="userName" id="userName" value="${userName}">
<label for="password">New Password:</label><input type="text" name="password" id="myLName" value="${password}" >
<label><input type="submit" id="mySubmit" name="submit" value="Change"></label>
</form>
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

