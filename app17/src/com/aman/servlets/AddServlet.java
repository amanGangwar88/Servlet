package com.aman.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.dto.StudentDto;
import com.aman.service.StudentService;
 
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 String sid=request.getParameter("sid");
		 String sname=request.getParameter("sname");
		 String saddr=request.getParameter("saddr");
		 
		 StudentDto sto=new StudentDto();
		 sto.setSid(sid);
		 sto.setSname(sname);
		 sto.setSaddr(saddr);
		 
		 StudentService stdService=new StudentService();
		 stdService.addStudent(sto);
		 
		 List<StudentDto> std_List=stdService.getAllStudents();
		 out.println("<html><body>");
		 out.println("<table border='1'>");
		 out.println("<tr><th>SID</th><th>SNAME</th><th>SADDR</th></tr>");
         for(StudentDto stdTo:std_List) {
        	out.println("<tr>");
        	out.println("<td>"+stdTo.getSid()+"</td>");
        	out.println("<td>"+stdTo.getSname()+"</td>");
        	out.println("<td>"+stdTo.getSaddr()+"</td>");
        	out.println("</tr>");
        	
        }
        out.println("</table><hr></body></html>");
        RequestDispatcher reqDispatcher=request.getRequestDispatcher("std_add_form.html");
        reqDispatcher.include(request, response);
	}
	

}
