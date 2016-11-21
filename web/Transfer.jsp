<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />
        <div id="wrapper">

<main>
<h2>Transfer Options</h2>

<form method="post" action="Account_activity">
<label for="Savings">From:</label><input type="text" name="from" id="from" value="${userName}">
<label for="Checking">To:</label><input type="text" name="To" value="${password}" id="To">
<label><input type="submit" id="transfer" name="transfer" value="Transfer"></label>
</form>

<br><br>

</main>
<c:import url="/includes/footer.jsp" />
