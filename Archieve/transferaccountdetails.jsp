<%@ page import=" java.io.BufferedReader, java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Account Details</title>
</head>
<body>
<form method="post" action="ShowDetails">
Account Numbers<select name= 'acctnumber'>
 
 <%
 	BufferedReader br = new BufferedReader(new FileReader("D:\\Dev-Ops\\Sample-Application\\Online_Banking_Application\\bankdata.txt"));
 	String line = null;
 	while( (line= br.readLine())!=null){
 		String []arr= line.split(";");
 		if(!arr[4].equals((request.getAttribute("acctno")).toString())){
 			out.println("<option value='"+arr[4]+"'>" +arr[4]+ "</option>");
 		}
 		
 	}
 	br.close();

 %>
</select><br/>
<input type= "submit" value= 'Show Details' name='showdetails'/>
</form>

</body>
</html>