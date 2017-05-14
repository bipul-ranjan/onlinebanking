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
                <li><a href="BankDetail?input=fundtrans" class="selected" >FundTransfer</a></li>
                <li><a href="BankDetail?input=transaction">Transactions</a></li>
                <li><a href="BankDetail?input=servreq" >Service Request</a></li>
                <li><a  href="login.jsp" >Log-Out</a></li>
            </ul>
        </nav>
      
      
<form  name = "servreqform" method = "post" action="BankDetail">
		<div style="color: #FF0000;">${errorMessage}</div>

			<table class="table2" >
				<tr>
					<th colspan="2"> Fund Transfer	</th>
				</tr>
				
				<tr>
						<td class="column1"> From Account Number:</td>
						<td class="column2"> 
							<select name = "fromacctnum">	
							<%int iCount = 0; %>
								<c:forEach items="${acctdetails}" var="acctdetail">													
											<option value = "${acctdetail.accountnumber}" >${acctdetail.accountnumber}</option>									
								</c:forEach>
							</select>
						</td>
				</tr>	
				<tr>
					<td class="column1">To Account Number:</td>
					<td class="column2"> 
						<select name = "toacctnum">
							 <c:forEach items="${acctdetails}" var="acctdetail">
								<option value = "${acctdetail.accountnumber}" >${acctdetail.accountnumber}</option>
							 </c:forEach>
						</select>
					</td>
					
				</tr>					
				<tr>
					<td class="column1">Amount:</td>
					<td class="column2"><input class="text1" type= "text" name = "amount"/> </td>
				</tr>
				
				<tr>
					<td class="column4" colspan="2"><input name="submit" type = "submit"  value= 'Transfer Fund'/></td>					
				</tr>				
			</table>
		</form>
</body>
</html>