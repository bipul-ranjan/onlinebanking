package com.itbank.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDetails
 */
public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	String acno= null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String othername= null;
		PrintWriter out= response.getWriter();
		
		if(request.getParameter("acctnumber")!=null)
		{
			BufferedReader br = new BufferedReader(new FileReader("D:\\Dev-Ops\\Sample-Application\\Online_Banking_Application\\bankdata.txt"));
			String line = null;
			
			while( (line= br.readLine())!=null){
				String []arr= line.split(";");
				if(arr[4].equals((request.getParameter("acctnumber")).toString())){
					othername= arr[0];
					break;
				}
				request.setAttribute("othername", othername);
			}
			br.close();
		
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/transferaccountdetails.jsp");
//			rd.include(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/otherpartydetails.jsp");
			rd.forward(request, response);
		}
		
}
}

