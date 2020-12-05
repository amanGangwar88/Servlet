package com.aman.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 ///Application for only getting headers data
@WebServlet("/headers")
public class HeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       Enumeration<String> enumeration=request.getHeaderNames();
       out.println("<html>");
       out.println("<body>");
       out.println("<font color='red' size='6'><b>Request Headres Data</b></font>");
       out.println("<table border='1'>");
       out.println("<tr><th>Headres Names</th><th>Headres Vlaues</th></tr>");
       while(enumeration.hasMoreElements()) {
    	   String header_Name=enumeration.nextElement();
    	   String header_Value=request.getHeader(header_Name);
    	   out.println("<tr><td>"+header_Name+"</td><td>"+header_Value+"</td></tr>");
       }
      out.println("</table></body></httml>");
	}

}
