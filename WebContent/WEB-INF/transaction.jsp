<%@ page import="com.itbank.object.*,java.util.*" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>IT-Bank</title>
 <link rel="stylesheet" href="stylesheets/default.css" />
</head>
<body>
	<div id="logoTxt">
	   <h1><span></span></h1>
	   <h2><span></span></h2>
	</div>
	<section id="mainRight" class="clear">
	        <header>
	            <h1><span>Grow in safe hands.</span></h1>
	        </header>
	</section>
	 <nav>
            <ul>
                <li><a href="BankDetail?input=acctdetail">Account Detail</a></li>
                <li><a href="BankDetail?input=fundtrans" >FundTransfer</a></li>
                <li><a href="BankDetail?input=transaction" class="selected">Transactions</a></li>
                <li><a href="BankDetail?input=servreq" >Service Request</a></li>
                <li><a  href="login.jsp" >Log-Out</a></li>
            </ul>
        </nav>
      
      <table class="table1" >
	    <tr>
	        <th>Account Number</th>
	        <th>Transaction Method</th>
	        <th>Transaction Amount</th>
	        <th>Type</th>
	        <th>Transaction date</th>
	    </tr>
	    <c:forEach items="${transdetail}" var="transaction">
	        <tr>
	            <td>${transaction.acctnum}</td>
	            <td>${transaction.method}</td>
	            <td>${transaction.amt}</td>
	            <td>${transaction.type}</td>
	            <td>${transaction.date}</td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>