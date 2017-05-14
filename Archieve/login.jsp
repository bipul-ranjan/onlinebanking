<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Login Page</title>
</head>
<body>
<%

	
	
/* 	Cookie[] ck= request.getCookies();
	if ( ck!= null  && ck.length!=0 ){
		for ( Cookie c:ck){
			if (c.getValue().equals("username",UserName)){
				request.setAttribute("un", c.getValue());
				RequestDispathcher rd = request.getRequestDispatcher("WEB-INF/bankaccountdetails.jsp");
				rd.forward(request,response); 
				
			}
			
		}
	}
 */
 
 
%>

<form  method = "post" action="LogIn.do">
User Name: <input type= "text" name = "un"/><br/>
Password: <input type = "password" name = "pwd"/><br/>
<input type="submit" value ='Log In'/>
</form>

</body>
</html>