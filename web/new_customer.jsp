<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />
         <div id="wrapper">

             
<main>
<h2>Create a profile to view account activity</h2>

<h3>New Profile</h3>
<p id="errorMessage"><i>${message}</i></p>
<form method="post" action="Sign_up">
<label for="myFName">First Name:</label><input type="text" name="myFName" id="myFName" value="${fName}">
<label for="myLName">Last Name:</label><input type="text" name="myLName" id="myLName" value="${lName}" >
<label for="myEmail">E-mail:</label><input type="email" name="myEmail" value="${eMail}" id="myEmail" >
<label for="myPhone">Phone:</label><input type="tel" value="${phone}" name="myPhone" id="myPhone">
<label>Address:</label><input name="address" id="address" value="${address}" ></textarea>
<label>City:</label><input name="city" value="${city}" id="city" type="text">
<label>State:</label><input name="state" value="${state}" id="state" type="text">
<label>Zip:</label><input name="zip" value="${zip}" id="zip" type="text">
<label><input type="submit" id="mySubmit" name="submit" value="Submit"></label>
</form>


  
</main>
<c:import url="/includes/footer.jsp" />
