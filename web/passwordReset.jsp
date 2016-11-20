<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />

<main>
<h2>Banking made easy, register today!</h2>
<img src="styles/bank.jpg" alt="bank vault" width="320" height="250">
<p><span class="resort">Titan Banks</span> online password reset tool allows you to change your password.
  Simply enter you user ID and  your new password, then click the change button.</p>
<p id="errorMessage"><i>${message}</i></p>
<form method="post" action="ChangePassword">
<label for="userName">User Name:</label><input type="text" name="userName" id="userName" value="${userName}">
<label for="password">New Password:</label><input type="text" name="password" id="myLName" value="${password}" >
<label><input type="submit" id="mySubmit" name="submit" value="Change"></label>
</form>
  <div class="clear">
  </div>
</main>
<c:import url="/includes/footer.jsp" />

