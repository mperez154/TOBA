<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />
        <div id="wrapper">

            
<main>
<h2>Login</h2>
<form method="post" action="Account_activity.jsp">
<label for="userName">Username:</label><input type="text" name="userName" id="userName" value="${userName}" required="required">
<label for="password">Password:</label><input type="password" name="password" value="${password}" id="password" required="required">
<label><input type="submit" id="mySubmit" name="submit" value="Login"></label>
</form>
<br><br>
<a href="passwordReset.jsp">Reset</a>
<br>

<p>If you are unable to login, click <a href="passwordReset.jsp">reset password</a> or click the reset button below.</p>

</main>
<c:import url="/includes/footer.jsp" />
