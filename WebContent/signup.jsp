<%@ page language="java" pageEncoding="UTF-8"%>
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
                <li><a href="services.jsp" >Services</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="contact.jsp">Contact</a></li>
                <li><a href="login.jsp" >Login</a></li>
                <li><a href="signup.jsp" class="selected">Sign-Up</a></li>
            </ul>
        </nav>
		<form  name = "signupform" method = "post" action="SignUp">
		<div style="color: #FF0000;">${errorMessage}</div>
			<table class="table2" >
				<tr>
					<th colspan="2">			New Customers! Signup		</th>
				</tr>
				
				<tr>
					<td class="column1"> User Name:</td>
					<td class="column2"> <input class="text1" type= "text" name = "un"/></td>
				</tr>
				<tr>
					<td class="column1"> Password:</td>
					<td class="column2"><input class="text1" type = "password" name = "pwd"/></td>
				</tr>
				<tr>
					<td class="column1"> Confirm Password:</td>
					<td class="column2"> <input class="text1" type = "password"  name = "confpwd"/></td>
				</tr>
				<tr>
					<td class="column1"> First Name:</td>
					<td class="column2"> <input class="text1" type= "text" name = "fname"/></td>
				</tr>
				<tr>
					<td class="column1"> Middle Name:</td>
					<td class="column2"> <input class="text1" type= "text" name = "mname"/></td>
				</tr>
				<tr>
					<td class="column1">Last Name:</td>
					<td class="column2"> <input class="text1"  type= "text" name = "lname"/></td>
				</tr>
				<tr>
					<td class="column1"> Email-id:</td>
					<td class="column2"> <input class="text1" type= "text" name = "email"/></td>
				</tr>
				<tr>
					<td class="column1">Phone-Number:</td>
					<td class="column2"><input class="text1" type= "text" name = "phone"/></td>
				</tr>
				<tr>
					<td class="column3">Address:</td>
					<td class="column2"><textarea id="txtArea" rows="5" cols="20" name = "add"> </textarea></td>
				</tr>
				
				<tr>
					<td class="column1">Account Type:</td>
					<td class="column2"><select name = "accttype">
							<option value = "null">[Select One]</option>
							<option value = "Checking">Checking</option>
							<option value = "Savings"> Savings</option>
							<option value = "Creditcard"> Credit Card</option>
							<option value = "Loans">Loans</option> 
						</select>
					</td>
				</tr>
				<tr>
					<td class="column4" colspan="2"><input type = "submit" value= 'Sign Up!'/></td>					
				</tr>				
			</table>
		</form>
</body>
</html>