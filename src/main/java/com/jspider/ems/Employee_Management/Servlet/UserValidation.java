package com.jspider.ems.Employee_Management.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class UserValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserValidation() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		RequestDispatcher rd=null;
		if(userName.equals("admin")&& password.equals("hrAdmin")) {
			rd=request.getRequestDispatcher("showMenu.jsp");
			rd.forward(request, response);
			}
		else {
			rd=request.getRequestDispatcher("login.jsp");
			out.println("<h2> Invalid username or password.please try again..<h2>");
			rd.include(request, response);
		}
	}

}
