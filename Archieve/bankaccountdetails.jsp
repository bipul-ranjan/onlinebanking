<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Account Details</title>
</head>
<body>

<div align= 'center'>IT Bank Account Details</div><br/> <br/>
<div align= 'right'>Hi,<%= request.getAttribute("un").toString() %>!</div>
Your A/C Number is : <%= request.getAttribute("acctno").toString() %><br/>
Your Current Balance is:  $<%= request.getAttribute("bal").toString() %><br/><br/>


<form action="Transfer" method = "post">
<%="<input type='hidden' name='AccountNo' value='"+request.getAttribute("acctno").toString()+"'/>"
%>
<div align = "center"><input type="submit" value="Third Party Transfers"/></div><br/>
</form>

</body>
</html>