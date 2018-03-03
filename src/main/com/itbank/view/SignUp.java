package main.com.itbank.view;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.com.itbank.object.*;
import main.com.itbank.controller.*;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		objSignUp signup = new objSignUp();
		CSignUp csignup = new CSignUp();
		int user_id = 0;
		request.setAttribute("errorMessage","");
		
		signup.user_name = request.getParameter("un");
		signup.password = request.getParameter("pwd");  
		signup.confpassword = request.getParameter("confpwd");
		signup.firstname=request.getParameter("fname");
		signup.middlename=request.getParameter("mname");
		signup.lastname=request.getParameter("lname");
		signup.email=request.getParameter("email");
		signup.phonenum=request.getParameter("phone");
		signup.add=request.getParameter("add");
		signup.accttype=request.getParameter("accttype");
		
		user_id = csignup.getUserid(signup.user_name);
		
		boolean error= false;
		
		if (user_id > 0)
		{
			request.setAttribute("errorMessage","User Name already exist");
			error= true;
		}
			
		if (signup.user_name.trim().length() == 0 || signup.password.trim().length() == 0)
		{
			request.setAttribute("errorMessage","Please insert the Username and Password");
			error= true;
			
		}
		
		else if ( signup.password.compareTo(signup.confpassword) != 0) {
			request.setAttribute("errorMessage","Passwords don't match!");
			error= true;
		}
	
		else if (signup.firstname.trim().length()==0 || signup.lastname.trim().length()==0)
		{
			request.setAttribute("errorMessage","First Name and last Name is mandatory ");
			error= true;
		}
		else if (signup.add.trim().length() == 0)
		{
			request.setAttribute("errorMessage","Address is mandatory");
			error= true;	
		}
		
		if (error){
			rd = request.getRequestDispatcher("signup.jsp");
		}		
		
		else{
			csignup.createCustomer(signup);
			request.setAttribute("errorMessage","Your New Account has been created. Login with your userid and password");
			rd = request.getRequestDispatcher("login.jsp");
		}
		
		rd.forward(request, response);
	}

}
