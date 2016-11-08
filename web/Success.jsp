<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />
        <div id="wrapper">

<main>
<h2>Success!</h2>
<p>Thank you ${user.firstName}, your account has been created. Please save your account details below and click on the Login link to login to the site.</p>
<span>${user.firstName}</span>
<span>${user.lastName}<br></span>
<span>${user.email}<br></span>
<span>${user.phone}<br></span>
<span>${user.address}<br></span>
<span>${user.city},</span>
<span>${user.state},</span>
<span>${user.zip}<br><br></span>
<span>Username: ${user.userName}<br></span>
<span>Password: ${user.password}</span>


</main>
<c:import url="/includes/footer.jsp" />
