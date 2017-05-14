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
                <li><a href="BankDetail?input=transaction" >Transactions</a></li>
                <li><a href="BankDetail?input=servreq" class="selected">Service Request</a></li>
                <li><a  href="login.jsp" >Log-Out</a></li>
            </ul>
        </nav>
      
      
      <table class="table1" >
	    <tr>
	        <th>Request ID</th>
	        <th>Account Number</th>
	        <th>Description</th>
	        <th>Date Raised</th>
	    </tr>
	    <c:forEach items="${servrequests}" var="servrequest">
	        <tr>
	            <td>${servrequest.requestid}</td>
	            <td>${servrequest.acctnum}</td>
	            <td>${servrequest.description}</td>
	            <td>${servrequest.date}</td>
	        </tr>
	    </c:forEach>
	</table>
      <br>
      <br>
      <form  name = "servreqform" method = "post" action="BankDetail">
		<div style="color: #FF0000;">${message}</div>
			<table class="table2" >
				<tr>
					<th colspan="2"> Create Service Request		</th>
				</tr>
				
				<tr>
					<td class="column1"> Account Number:</td>
					<td class="column2"> 
						<select name = "acctnum">
							 <c:forEach items="${acctdetails}" var="acctdetail">
								<option value = "${acctdetail.accountnumber}" >${acctdetail.accountnumber}</option>
							 </c:forEach>
						</select>
					</td>
				</tr>				
				<tr>
					<td class="column3">Description:</td>
					<td class="column2"><textarea id="txtArea" rows="5" cols="20" name = "description"> </textarea></td>
				</tr>
				
				<tr>
					<td class="column4" colspan="2"><input name="submit" type = "submit"  value= 'Create Request'/></td>					
				</tr>				
			</table>
		</form>
</body>
</html>