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
                <li><a href="login.jsp" class="selected">Login</a></li>
                <li><a href="signup.jsp">Sign-Up</a></li>
            </ul>
        </nav>
      <form  method = "post" action="LogIn.do">
      		<div style="color: #FF0000;">${errorMessage}</div>
			User Name: <input type= "text" name = "un"/><br/><br/>
			Password: <input type = "password" name = "pwd"/><br/><br/>
			<input type="submit" value ='Log In'/>
	</form>
</body>
</html>