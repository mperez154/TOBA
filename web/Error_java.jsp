<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />


<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />

<main>
<h2>Java Error</h2>

<p>Sorry, Java has thrown an exception.</p>
<p>To continue, click the back back button.</p>

<h3>Details</h3>
<p>Type: {pageContext.exception["class"]}</p>
<p>Message: {pageContext.exception.message}</p>

</main>
<c:import url="/includes/footer.jsp" />
