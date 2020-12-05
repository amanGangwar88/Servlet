package com.aman.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       ServletConfig config=getServletConfig();
       String lname=config.getServletName();
       String driver_Class=config.getInitParameter("driver_Class");
       String driver_URL=config.getInitParameter("driver_URL");
       String db_User_Name=config.getInitParameter("db_User_Name");
       String db_Password=config.getInitParameter("db_Password");
       Enumeration<String> e=config.getInitParameterNames();
       String init_Param_Names= "";
       while(e.hasMoreElements()){
    	   init_Param_Names=init_Param_Names +e.nextElement()+" <br>";
       }
       
       out.println("<html><body>");
       out.println("<table border='1'>");
       out.println("<tr><th colspan='2'><font color='red' size='6'>Servlet Configuration Details </font></th><tr>");
       out.println("<tr><th>Logical Name</th><td>"+lname+"</td></tr>");
       out.println("<tr><th>driver_Class</th><td>"+driver_Class+"</td></tr>");
       out.println("<tr><th>driver_URL</th><td>"+driver_URL+"</td></tr>");
       out.println("<tr><th>db_User_Name</th><td>"+db_User_Name+"</td></tr>");
       out.println("<tr><th>db_Password</th><td>"+db_Password+"</td></tr>");
       out.println("<tr><th>Parameters Names</th><td>"+init_Param_Names +"</td></tr>");

       out.println("</table></body></html>");
    
	}

}
