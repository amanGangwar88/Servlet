package com.aman.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext context=getServletContext();
        String lname=context.getServletContextName();
        String driver_Class=context.getInitParameter("driver_Class");
        String driver_URL=context.getInitParameter("driver_URL");
        String db_User_Name=context.getInitParameter("db_User_Name");
        String db_Password=context.getInitParameter("db_Password");
        String contextParamName ="";
        Enumeration<String> e= context.getInitParameterNames();
        while(e.hasMoreElements()) {
        	contextParamName=contextParamName +e.nextElement() +"<br>";
        }
        context.setAttribute("cricket", "sachin");
        context.setAttribute("football", "Butia");
        context.setAttribute("badminton", "sindhu");
        context.setAttribute("hockey", "Dhyanchand");
        
        String cricketplayer=(String)context.getAttribute("cricket");
        String footballplayer=(String)context.getAttribute("football");
        String badmintonplayer=(String)context.getAttribute("badminton");
        String hockeyplayer=(String)context.getAttribute("hockey");
	   
        e=context.getAttributeNames();
        String contextAttributeName ="";
        while(e.hasMoreElements()) {
        	contextAttributeName=contextAttributeName +e.nextElement() +"<br>";
        }
        out.println("<html><body><center><font size='6' color='red'><b>Servlet COntext Details</b></font>");
        out.println("<table border='1'>");
        out.println("<tr><th>Logical Name</th><td>"+lname+"</td></tr>");
        out.println("<tr><th colspan='2'><font size='5' color='blue'><b>Context Parameter</b></font></th></tr>");
        out.println("<tr><th>driver_Class</th><td>"+driver_Class+"</td></tr>");
        out.println("<tr><th>driver_URL</th><td>"+driver_URL+"</td></tr>");
        out.println("<tr><th>db_User_Name</th><td>"+db_User_Name+"</td></tr>");
        out.println("<tr><th>db_Password</th><td>"+db_Password+"</td></tr>");
        out.println("<tr><th>Context Parameter Name</th><td>"+contextParamName+"</td></tr>");
        out.println("<tr><th colspan='2'><font size='5' color='blue'><b>Context Attribute Data</b></font></th></tr>");
        out.println("<tr><th>Cricket Player</th><td>"+cricketplayer+"</td></tr>");
        out.println("<tr><th>Football Player</th><td>"+footballplayer+"</td></tr>");
        out.println("<tr><th>Badminton Player</th><td>"+badmintonplayer+"</td></tr>");
        out.println("<tr><th>Hockey Player</th><td>"+hockeyplayer+"</td></tr>");
        out.println("<tr><th>Context Attribute Name</th><td>"+contextAttributeName+"</td></tr>");
        out.println("</table></center></body></html>");
	}

}
