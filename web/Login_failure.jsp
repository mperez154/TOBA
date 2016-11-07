<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />


<main>
<h2>Login Failure!</h2>

<p>The login username or password is incorrect. Please click back to try again. Note that 3 failed logins will lock the account.</p>

</main>
<c:import url="/includes/footer.jsp" />
