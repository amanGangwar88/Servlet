package com.aman.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.dto.Employee;
import com.aman.service.EmployeeService;
 
@WebServlet("/edit")
public class EditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
			response.setContentType("text/html");
			  PrintWriter out=response.getWriter();
			  int eno=Integer.parseInt(request.getParameter("eno"));
			  EmployeeService empService=new EmployeeService(); 
			  Employee emp=empService.getEmployee(eno);
			  
			  if(emp==null) {
			     out.println("<html>");
			     out.println("<body>");
			     out.println("<h2>Durga Software Solution</h2>");
			     out.println("<h3>Employee Updation Status</h3>");
			     out.println("<font color='red' size='6'>");
			     out.println("<b>Employee Not Existed</b>");
			     out.println("</font>");
			     out.println("<h3>");
			     out.println("<a href='./updateform.html'>|Update Form|</a>");
			     out.println("</body></html>");
			  }else {
				  out.println("<html>");
				     out.println("<body>");
				     out.println("<h2>Durga Software Solution</h2>");
				     out.println("<h3>Employee Edit Form</h3>");
				     out.println("<form method='POST' action='./update'>");
				     out.println("<table>");
				     out.println("<tr><td>Employee Number</td><td>:"+emp.getEno()+"</td></tr>");
				     out.println("<input type='hidden' name='eno' value='"+emp.getEno()+"'/>");
				     out.println("<tr><td>Employee Name</td><td><input type='text' name='ename' value='"+emp.getEname()+"'/></td></tr>");
				     out.println("<tr><td>Employee Salary</td><td><input type='text' name='esal' value='"+emp.getEsal()+"'/></td></tr>");
				     out.println("<tr><td>Employee Address</td><td><input type='text' name='eaddr' value='"+emp.getEaddr()+"'/></td></tr>");
				     out.println("<tr><td><input type='submit' value='Update' </td></tr>");
				     out.println("</table></form></body></html>");
			  }
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		  
		  
	}

}
