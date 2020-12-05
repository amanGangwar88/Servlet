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
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uprof=request.getParameter("uprof");
		 String uaddr=request.getParameter("uaddr");
		 
		 HttpSession hs=request.getSession(false);
		 hs.setAttribute("uprof", uprof);
		 hs.setAttribute("uaddr", uaddr);
		 
		 RequestDispatcher reqDisp=request.getRequestDispatcher("form3.html");
		 reqDisp.forward(request, response);
	}

}
