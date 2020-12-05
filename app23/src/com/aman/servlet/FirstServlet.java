package com.aman.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uname=request.getParameter("uname");
		 String upwd=request.getParameter("upwd");
		 
		 HttpSession hs=request.getSession();
		 hs.setAttribute("uname", uname);
		 hs.setAttribute("upwd", upwd);
		 
		 RequestDispatcher reqDisp=request.getRequestDispatcher("form2.html");
		 reqDisp.forward(request, response);
	}

}
 