package main.com.itbank.view;


import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.com.itbank.controller.*;
import main.com.itbank.object.*;

/**
 * Servlet implementation class LogIn
 */
public class BankDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String strAction;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankDetail() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		strAction = request.getParameter("input");

		CBankDetail cbankdetail = new CBankDetail();
		
		Cookie ck[]=request.getCookies();  
		int userid = Integer.parseInt(cbankdetail.getCookieVal(ck,"userid"));
		
		RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
		
		if(strAction.matches("acctdetail"))
		{
			AccountDetails[] acctdetail = cbankdetail.getAccountDetails(userid);
			request.setAttribute("acctdetails", acctdetail);
			rd = request.getRequestDispatcher("WEB-INF/bankaccountdetails.jsp");
			System.out.println("String Action....:"+strAction);
		}
		else if (strAction.matches("transaction"))
		{
			System.out.println("String Action.in..method.:"+strAction);
			objTransaction[] transaction = cbankdetail.getTransactionDetails(userid);
			request.setAttribute("transdetail", transaction);
			rd = request.getRequestDispatcher("WEB-INF/transaction.jsp");
			
			System.out.println("String Action....:"+strAction);
		}
		else if(strAction.matches("servreq"))
		{
			AccountDetails[] acctdetail = cbankdetail.getAccountDetails(userid);
			request.setAttribute("acctdetails", acctdetail);
			objServiceRequest [] servreqs = cbankdetail.getServReq(userid);
			request.setAttribute("servrequests",servreqs);
			rd = request.getRequestDispatcher("WEB-INF/servicerequest.jsp");
			System.out.println("String Action....:"+strAction);
		}
		else if(strAction.matches("fundtrans"))
		{
			AccountDetails[] acctdetail = cbankdetail.getAccountDetails(userid);
			request.setAttribute("acctdetails", acctdetail);
			rd = request.getRequestDispatcher("WEB-INF/fundtransfer.jsp");
			System.out.println("String Action....:"+strAction);
		}
		System.out.println("String Action....:"+strAction);
		System.out.println("userid....:"+userid);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");		 
		
		CBankDetail cbankdetail = new CBankDetail();
		
		Cookie ck[]=request.getCookies(); 
		int userid = Integer.parseInt(cbankdetail.getCookieVal(ck,"userid"));
		
		
		strAction = request.getParameter("submit");
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		
		AccountDetails[] acctdetail = cbankdetail.getAccountDetails(userid);
		request.setAttribute("acctdetails", acctdetail);
		
		if(strAction.matches("Create Request"))
		{
			String acctnum = request.getParameter("acctnum");
			String description = request.getParameter("description");
			objServiceRequest servreq = new objServiceRequest();
			boolean error= false;
			
			if(acctnum.equals(null))
			{
				request.setAttribute("message","Select Account Number!");
				error= true;
			}
			else if (description.trim().length()==0)
			{
				request.setAttribute("message","Please put description!");
				error= true;
			}
			
			if(!error)
			{
				servreq.acctnum = Integer.parseInt(acctnum);
				servreq.description = description;
				servreq.userid=userid;
				cbankdetail.createServReq(servreq);
			
				objServiceRequest [] servreqs = cbankdetail.getServReq(userid);
				request.setAttribute("servrequests",servreqs);
				request.setAttribute("message","Your Service Request Created");
			}
			rd = request.getRequestDispatcher("WEB-INF/servicerequest.jsp");
		}
		else if (strAction.matches("Transfer Fund"))
		{
			String fromacctnum = request.getParameter("fromacctnum");
			String toacctnum = request.getParameter("toacctnum");
			String amount = request.getParameter("amount");
			String errormsg = new String();
			boolean error = false;
			
			System.out.println("length of account: "+acctdetail.length);
			
			if (fromacctnum.matches(toacctnum))
			{
				errormsg = "Please select different account number.";
				error = true;
			}
			else if (!cbankdetail.isNumeric(amount))
			{
				errormsg = "Please select numeric amount.";
				error = true;
			}
			else if (Double.parseDouble(amount) <= 0)
			{
				errormsg = "Amount must be greater than zero";
				error = true;
			}
			else if (Double.parseDouble(amount) > cbankdetail.getAcctBalance(acctdetail, Integer.parseInt(fromacctnum)))
			{
				errormsg = "Amount is greater than balance";
				error = true;
			}
			
			if (error)
			{
				request.setAttribute("errorMessage",errormsg);
				rd = request.getRequestDispatcher("WEB-INF/fundtransfer.jsp");
			}
			else
			{
				cbankdetail.doFundTransfer(userid,fromacctnum,toacctnum,amount);
				objTransaction[] transaction = cbankdetail.getTransactionDetails(userid);
				request.setAttribute("transdetail", transaction);
				rd = request.getRequestDispatcher("WEB-INF/transaction.jsp");
				
			}
			
		}
		
		rd.forward(request, response);
	}

	
}
