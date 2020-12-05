package com.aman.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 //Example on request Parameter and Attributes
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  int eno=Integer.parseInt(request.getParameter("eno")); 
	  String ename=request.getParameter("ename");
	  float esal=Float.parseFloat(request.getParameter("esal"));
	  String eaddr=request.getParameter("eaddr");
	  Enumeration<String> enumeration1=request.getParameterNames();
	  String param_Names="";
	  while(enumeration1.hasMoreElements()) {
		  param_Names=param_Names +enumeration1.nextElement() +"<br>";
	  }
	  request.setAttribute("accNo", "abc123");
	  request.setAttribute("accHolderName", "AMAN");
	  request.setAttribute("accType", "Savings");
	  request.setAttribute("balance", 25000);
	  
	  String accNo=(String)request.getAttribute("accNo");
	  String accHolderName=(String)request.getAttribute("accHolderName");
	  String accType=(String)request.getAttribute("accType");
	  int balance= (Integer)request.getAttribute("balance");
	  
	  Enumeration<String> enumeration2=request.getAttributeNames();
	  String attr_Names="";
	  while(enumeration2.hasMoreElements()) {
		  attr_Names=attr_Names +enumeration2.nextElement() +"<br>";
	  }
	  out.println("<html>");
	  out.println("<body>");
	  out.println("<font color='red' size='6'><b>"); 
	  out.println("Request Parameter And Attribute Data");
	  out.println("</b></font>");
	 
	  out.println("<table border='1'>");
	  out.println("<tr><th colspan='2'>Request Parameter Data</th></tr>");
	  out.println("<tr><th>Parameter Name</th><th>Parameter Vlaue</th></tr>");
	  out.println("<tr><td>eno</td><td>"+eno+"</td></tr>");
	  out.println("<tr><td>ename</td><td>"+ename+"</td></tr>");
	  out.println("<tr><td>esal</td><td>"+esal+"</td></tr>");
	  out.println("<tr><td>eaddr</td><td>"+eaddr+"</td></tr>");
	  out.println("<tr><th>Parameter Names</th><td>"+param_Names+"</td></tr>");

	  out.println("<tr><th colspan='2'>Request Attribute Data</th></tr>");
	  out.println("<tr><th>Attribute Name</th><th>Attribute Vlaue</th></tr>");
	  out.println("<tr><td>accNo</td><td>"+accNo+"</td></tr>");
	  out.println("<tr><td>accHolderName</td><td>"+accHolderName+"</td></tr>");
	  out.println("<tr><td>accType</td><td>"+accType+"</td></tr>");
	  out.println("<tr><td>balance</td><td>"+balance+"</td></tr>");
	  out.println("<tr><th>Attribute Names</td><td>"+attr_Names+"</td></tr>");
	  
	  out.println("</table></body></html>");
	}
}
