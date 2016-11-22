<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<c:import url="/includes/navigation.html" />
        <div id="wrapper">

<main>
<h2>Transfer Options</h2>

 <table>
            <tr>
                <th>Account</th>
                <th>Balance</th>
            </tr>
            <tr>
                <td>${checking.type}</td>
                <td>$${checking.balance}0</td>
            </tr>
            <tr>
                <td>${savings.type}</td>
                <td>$${savings.balance}0</td>
            </tr>  
        </table>
            
            <br><br>

            <p id="errorMessage"><i>${message}</i></p>
<form method="post" action="Transfer">
    <label for="From">From:</label>
    <select type="text" name="from" id="from">
        <option value="Savings">Savings</option>
        <option value="Checking">Checking</option>
    </select><br><br>
    <label for="to">To:</label>
    <select type="text" name="to" id="to" ">
        <option value="Savings">Savings</option>
        <option value="Checking">Checking</option>
    </select><br><br>
    <label for="amount">Amount:</label><input type="amount" name="amount" id="amount"></input>
<label><input type="submit" id="transfer" name="transfer" value="Transfer"></label>
</form>

<br><br>

</main>
<c:import url="/includes/footer.jsp" />
