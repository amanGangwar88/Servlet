package com.aman.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out= response.getWriter();
		 
		 String sname=request.getParameter("sname");
		 String scourse=request.getParameter("scourse");
		 String squal=request.getParameter("squal");
		 String semail=request.getParameter("semail");
		 String smobile=request.getParameter("smobile");
		 
		 if(squal.equals("BSC")) {
			 response.sendError(515, "Sorry"+sname+"!, You are not eligible to learn "+scourse);
			 }else {
				 out.println("<html>");
				 out.println("<body>");
				 out.println("<h2>Durga Software Solution</h2>");
				 out.println("<h3>Student Course Registation Details</h3>");
				 out.println("<table border='1'>");
				 out.println("<tr><td>Student Name</td><td>"+sname+"</td></tr>");
				 out.println("<tr><td>Student Course</td><td>"+scourse+"</td></tr>");
				 out.println("<tr><td>Student Qualification</td><td>"+squal+"</td></tr>");
				 out.println("<tr><td>Student Email Address</td><td>"+semail+"</td></tr>");
				 out.println("<tr><td>Student Mobile Number</td><td>"+smobile+"</td></tr>");
				 out.println("</table></body></html>");
			 }
	} 

}
