package com.aman.servlet;

import java.io.IOException;
import java.io.PrintWriter;

 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  
		  String uemail=request.getParameter("uemail");
		  String umobile=request.getParameter("umobile");
			 
			 HttpSession hs=request.getSession(false);
			 String uname =(String)hs.getAttribute("uname");
			 String upwd =(String)hs.getAttribute("upwd");
			 String uprof=(String)hs.getAttribute("uprof");
			 String uaddr=(String)hs.getAttribute("uaddr");
			 
			 out.println("<html><body<h2>Durga Software Solution</h2>");
			 out.println("<h3>User Registration Details</h3>");
			 out.println("<table border='1'>");
			 out.println("<tr><td>User Name</td><td>"+uname+"</td></tr>");
			 out.println("<tr><td>User Password</td><td>"+upwd+"</td></tr>");
			 out.println("<tr><td>User Profssion</td><td>"+uprof+"</td></tr>");
			 out.println("<tr><td>User Address</td><td>"+uaddr+"</td></tr>");
			 out.println("<tr><td>User Email Id</td><td>"+uemail+"</td></tr>");
			 out.println("<tr><td>User Mobile Number</td><td>"+umobile+"</td></tr>");
			 
			 out.println("<tr><td>Session Id</td><td>"+hs.getId()+"</td></tr>");
			 out.println("</table></body></html>");
	}

}
