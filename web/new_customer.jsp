<%-- 
    Document   : new_customer
    Created on : Oct 23, 2016, 2:37:35 PM
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA: New Customer</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/pacific.css">
        <!--[if lt IE 9]>
        <script src=" http://html5shim.googlecode.com/svn/trunk/html5.js ">
        </script>
        <![endif]-->
    </head>
    <body>
         <div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>
<nav>
<ul>
  <li><a href="index.html">Home</a></li>
  <li><a href="login.html">Login</a></li>
  <li><a href="new_customer.jsp">Register</a></li>
</ul>
</nav>
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
<footer>Copyright &copy; 2014 Titan Online Banking<br>
<a href="mailto:mperez40@live.spcollege.edu">mperez40@live.spcollege.edu</a>
</footer>
</div>
    </body>
</html>
