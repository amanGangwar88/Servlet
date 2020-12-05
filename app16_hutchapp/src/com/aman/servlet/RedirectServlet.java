package com.aman.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/hutch")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//This is type one of Request Redirection using Hyper Links
	  
	 /* response.setContentType("text/html");
	  PrintWriter out= response.getWriter();
	  
	  out.println("<html>");
	  out.println("<body><center><br><br><br><h2>");
	  out.println("To Get Services from Hutch Comm<br>");
	  out.println("Click on <br>");
	  out.println("<a href='http://localhost:5555/vodafoneapp/welcome.html'>cc@vodafone.com</a>");
	  out.println("</h2></center></body></html>");
	 */ 
	  
	  //This is type Two of Request Redirection using setting Response Header
   /*     response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("location", "http://localhost:5555/vodafoneapp/welcome.html");
		
	*/	
		
		//This is Type Three ofRequest Redirection using Send Redirection Mechanism
		response.sendRedirect("http://localhost:5555/vodafoneapp/welcome.html");
		
	}

}
