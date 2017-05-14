<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IT Bank Sign Up Page</title>
</head>
<body>
<div align ="center"><h1>Welcome to IT Bank</h1></div>
<form action="DirectLogin.do" method = "post">
<div align= "justify">Existing customers: <input type="submit" value= "Login" name = "loginbutton" /></div><br/>
</form>

<div align ="justify">New Customers! Signup</div><br/>
<form  name = "signupform" method = "post" action="SignUp">
<div align="justify"> User Name: <input type= "text" name = "un"/></div><br/>
<div align="justify">Password: <input type = "password" name = "pwd"/></div><br/>
<div align="justify">Confirm Password: <input type = "password"  name = "confpwd"/></div><br/>
<div align="justify"> First Name: <input type= "text" name = "fname"/></div><br/>
<div align="justify"> Middle Name: <input type= "text" name = "mname"/></div><br/>
<div align="justify"> Last Name: <input type= "text" name = "lname"/></div><br/>
<div align="justify"> Email-id: <input type= "text" name = "email"/></div><br/>
<div align="justify"> Phone-Number: <input type= "text" name = "phone"/></div><br/>
<div align="justify"><textarea id="txtArea" rows="5" cols="70" name = "add"> Address:</textarea></div><br/>

<div align="justify">Account Type: <select name = "accttype">
<option value = "null">[Select One]</option>
<option value = "checking">Checking</option>
<option value = "savings"> Savings</option>
<option value = "creditcard"> Credit Card</option>
<option value = "loans">Loans</option> 
</select></div><br/><br/>

<input type = "submit" value= 'Sign Up!'/>
 


</form>
</body>
</html>