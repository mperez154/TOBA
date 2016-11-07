<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />
        <div id="wrapper">

            
<main>
<h2>Login</h2>
<form method="post" action="Account_activity">
<label for="userName">Username:</label><input type="text" name="userName" id="userName" required="required">
<label for="password">Password:</label><input type="password" name="password" id="password" required="required">
<label><input type="submit" id="mySubmit" name="submit" value="Login"></label>
</form><br>

<p>A variety of luxury yurt packages are available. Choose a package below and contact us to begin your reservation. We're happy to build a custom package just for you!</p>

</main>
<c:import url="/includes/footer.jsp" />
