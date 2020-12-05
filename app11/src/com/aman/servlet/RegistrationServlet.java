package com.aman.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.service.UserService;
 
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 String uname=request.getParameter("uname");
		 String upwd=request.getParameter("upwd");
		 String uemail=request.getParameter("uemail");
		 String umobile=request.getParameter("umobile");
		 
		 UserService userService = new UserService();
		 String status=userService.registration(uname, upwd, uemail, umobile);
		 
		 out.println("<html>");
		 out.println("<body bgcolor='lightblue'>");
		 out.println("<center>");
		 out.println("<br><br>");
		 out.println("<font color='red' size='6'>");
		 out.println("<b>");
		 if(status.equals("success")) {
			 out.println("Registration Success");
		 }if(status.equals("failure")) {
			 out.println("Registration Failure");
		 }if(status.equals("existed")) {
			 out.println("User Existed Already");
		 }
		 out.println("</b></font></center></body></html>");
	}

}
