package com.aman.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   	 response.setContentType("text/html");
	   	 PrintWriter out=response.getWriter();
	   	 
	   	 out.println("<html><body>");
	   	out.println("<font color='red' size='6'>");
	   	out.println("<b>Welcome TO Eclips-GlassFish5 Server</b>");
	   	out.println("</font></body</html>");
	}

}
