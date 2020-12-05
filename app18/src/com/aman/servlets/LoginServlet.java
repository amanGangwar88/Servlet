package com.aman.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
	 PrintWriter out=response.getWriter();
	 
	 String uname=request.getParameter("uname");
	 String upwd=request.getParameter("upwd");
	 
	 if(uname.equals("durga") && upwd.equals("durga")) {
		 RequestDispatcher reqDispatcher=request.getRequestDispatcher("home.html");
		 reqDispatcher.forward(request, response);
	 }else {
		 RequestDispatcher requestDispatcher=request.getRequestDispatcher("loginform.html");
		 requestDispatcher.include(request, response);
		 out.println("<html><body>");
		 out.println("<font color='red' size='5'>");
		 out.println("<b>");
		 out.println("* Incorrect User Name /Password");
		 out.println("</b></font></body></html>");
	 }
	}

}
