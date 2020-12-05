package com.aman.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		 
		 out.println("<html>");
		 out.println("<body>");
		 out.println("<h2>Durga Software Solution</h2>");
		 out.println("<h3>User Login Status</h3>");
		 out.println("<font color='red' size='5'><b>");
		 if(uname.equals("durga") && upwd.equals("durga")) {
			 out.println("Login Status :SUCCESS");
		 }else {
			 out.println("Login Status :Failure");
		 }
		 out.println("<br>");
		 out.println("</b></font>");
		 out.println("<h3>");
		 out.println("<a href='./loginform.html'>|Login Page|</a>");
		 out.println("</h3></body></html>");
	}

}
