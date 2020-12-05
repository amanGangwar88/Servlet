package com.aman.controller;
 
import java.awt.Button;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.factory.StudentServiceFactory;
import com.aman.service.StudentService;
import com.aman.to.StudentTO;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object button;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 String sid=request.getParameter("sid");
		 String sname=request.getParameter("sname");
		 String saddr=request.getParameter("saddr");
		 
		 StudentTO sto=new StudentTO();
		 sto.setSid(sid);
		 sto.setSname(sname);
		 sto.setSaddr(saddr);  
		 
		 StudentService stdService=StudentServiceFactory.getStudentService();
		 String status = stdService.addStudent(sto);
		 
		 if(status.equals("success")) {
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("success.html");
			 requestDispatcher.forward(request, response);
		 }
		 if(status.equals("failure")) {
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("failure.html");
			 requestDispatcher.forward(request, response);
		 }
		 if(status.equals("existed")) {
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("existed.html");
			 requestDispatcher.forward(request, response);
		 }
	   
		 stdService =StudentServiceFactory.getStudentService();
	     sto=stdService.searchStudent(sid);
			 if(sto==null) {
				 RequestDispatcher requestDispatcher=request.getRequestDispatcher("notexisted.html");
				 requestDispatcher.forward(request, response);
			 }else {
				 out.println("<html><body bgcolor='lightblue'><center><br><br><br><table border='1'>");
				 out.println("<tr><th>Student ID</th><td>"+sto.getSid()+"</td></tr>");
				 out.println("<tr><th>Student Name</th><td>"+sto.getSname()+"</td></tr>");
				 out.println("<tr><th>Student Address</th><td>"+sto.getSaddr()+"</td></tr>");
				 out.println("</table></center></body></html>");
			 }	  
	     }
  }	 

