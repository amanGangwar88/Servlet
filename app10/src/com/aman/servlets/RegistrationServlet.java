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
		 PrintWriter out=response.getWriter();
		 String sname=request.getParameter("sname");
		 String[] quals=request.getParameterValues("squal");
		 String squal="";
		 for(String str:quals) {
			 squal=squal + str + " ";
		 }
		 String sgender=request.getParameter("sgender");
		 String [] course_List=request.getParameterValues("scourses");
		 String scourses="";
		 for(String str:course_List) {
			 scourses = scourses +str+ " ";
		 }
		 String branch =request.getParameter("durga_branch");
		 String  saddr=request.getParameter("saddr");
		 
		 out.println("<html>");
		 out.println("<body>");
		 out.println("<h2>Durga Software Solution</h2>");
		 out.println("<h3>Student Course Registration Details</h3>");
		 out.println("<table border='1'>");
		 out.println("<tr><td>Student Name</td><td>"+sname+"</td></tr>");
		 out.println("<tr><td>Student Qualifiction</td><td>"+squal+"</td></tr>");
		 out.println("<tr><td>Student Gender</td><td>"+sgender+"</td></tr>");
		 out.println("<tr><td>Student Courses</td><td>"+scourses+"</td></tr>");
		 out.println("<tr><td>Student Branch</td><td>"+branch+"</td></tr>");
		 out.println("<tr><td>Student Address</td><td>"+saddr+"</td></tr>");
		 out.println("</table></body></html>");
	}

}
