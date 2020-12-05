package com.aman;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="helloServlet", 
            loadOnStartup=1, 
            urlPatterns= {"/hello1", "/hello2"},
            initParams= {@WebInitParam(name="a", value="AAA"),@WebInitParam(name="b", value="BBB") }
            )
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
          static {
        	  System.out.println("**************Servlet Loading ********");
          }
          public HelloServlet() {
        	  System.out.println("*********************Servlet Instantiation*************");
          }
          public void init() {
        	  System.out.println("*********************Servlet Intialization******************");
          }
          
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  ServletConfig config=getServletConfig();
	  String lname=config.getServletName();
	  String a=config.getInitParameter("a");
	  String b=config.getInitParameter("b");
	  out.println("<html>");
	  out.println("<body>");
	  out.println("<h1>Hello Client!, This is HelloServlet With Annotation</h1>");
	  out.println("<h2>");
	  out.println("Servlet Logical Name  :"+lname+"<br>");
	  out.println("a------------>"+a+"<br>");
	  out.println("b------------>"+b+"<br>");
	  out.println("</body></html>");
	  System.out.println("**************************Request Processing*******************");
	}
     public void destroy() {
	System.out.println("*****************Servlet Deinstantiation**********************");
}
}
