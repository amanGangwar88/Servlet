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

 
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			response.setContentType("text/html");
			 PrintWriter out=response.getWriter();
			 
			 int eno=Integer.parseInt(request.getParameter("eno"));
			 String ename=request.getParameter("ename");
			 float esal=Float.parseFloat(request.getParameter("esal"));
			 String eaddr=request.getParameter("eaddr");
			 
			 Employee emp=new Employee();
			 emp.setEno(eno);
			 emp.setEname(ename);
			 emp.setEsal(esal);
			 emp.setEaddr(eaddr);
			 
			 EmployeeService empservice=new EmployeeService();
			 String status=empservice.update(emp);
			 
			 out.println("<html>");
			 out.println("<body>");
			 out.println("<h2>Durga Software Solution</h2>");
			 out.println("<h3>Employee Updation Status</h3>");
			 out.println("<font color='red' size='6'>");
			 out.println("<b>");
			 if(status.equals("success")) {
				 out.println("Empployee Updation Success");
			 }else {
				 out.println("Employee Updation Failure");
			 }
			 out.println("</b></font>");
			 out.println("<h3>");
			 out.println("<a href='./updateform.html'>|Update Form|</a>");
			 out.println("</h3></body></html>");
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		 
	}

}
