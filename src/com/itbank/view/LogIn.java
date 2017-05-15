package com.itbank.view;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itbank.controller.*;
import com.itbank.object.*;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
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
		
		String UserName = request.getParameter("un");
		String Password = request.getParameter("pwd");
		CLogin clogin = new CLogin();
		request.setAttribute("errorMessage","");
		
		System.out.println(UserName+":"+Password);
		int user_id = clogin.matchPassword(UserName, Password);
		RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
				
		
		if (user_id >0 ){
			Cookie ck_user = new Cookie("userid", Integer.toString(user_id));
			response.addCookie(ck_user);
			
			AccountDetails[] acctdetail = clogin.getAccountDetails(user_id);
			request.setAttribute("acctdetails", acctdetail);
			System.out.println("AfterSetAttribute");
			System.out.println(acctdetail.toString()+":"+acctdetail.length);
			rd = request.getRequestDispatcher("WEB-INF/bankaccountdetails.jsp");			
			
		}
		else if (user_id <0) {
			request.setAttribute("errorMessage","Invalid User ID");
			//out.println("Invalid User ID");
			rd = request.getRequestDispatcher("login.jsp");
			
		}
		else {
			request.setAttribute("errorMessage","Incorrect Password");
			//out.println("Incorrect Password");
			rd = request.getRequestDispatcher("login.jsp");		
			
		}
		rd.forward(request, response);
	}

}
