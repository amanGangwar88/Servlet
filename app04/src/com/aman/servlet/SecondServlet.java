package com.aman.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletConfig config=getServletConfig();
		ServletContext context=getServletContext();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("a---->"+context.getInitParameter("a")+"<br>");
		out.println("b---->"+context.getInitParameter("b")+"<br>");
		out.println("c---->"+config.getInitParameter("c")+"<br>");
		out.println("d---->"+config.getInitParameter("d")+"<br>");
		out.println("e---->"+config.getInitParameter("e")+"<br>");
		out.println("f---->"+config.getInitParameter("f")+"<br>");
		out.println("</h1></body></html>");
	}

}
  