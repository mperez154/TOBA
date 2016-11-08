<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />
        <div id="wrapper">

<main>
<h2>Transaction Options</h2>

<h3>Check</h3>
<p>Click here to initiate a check request that we can mail out.</p>
<h3>Wire</h3>
<p>Click here to initiate a wire. Must be submitted before 2pm for same day processing.</p>
<h3>ACH</h3>
<p>Click here to initiate an ACH. Processing varies, can take up to 3 business days.</p>
<h3>Internal Transfer</h3>
<p>Click here to initiate a transfer to another internal Titan Bank account holder (funds from these transactions are available immediately).</p>



</main>
<c:import url="/includes/footer.jsp" />
