package com.jspider.ems.Employee_Management.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspider.ems.Employee_Management.Employee;
import com.jspider.ems.Employee_Management.dao.EmployeeDAO;
import com.jspider.ems.Employee_Management.dao.IDao;

@WebServlet("/updateSalary")
public class updateSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean success=false;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String EmpNo = request.getParameter("empNO");
		int empNO = Integer.parseInt(EmpNo);
		String newSal = request.getParameter("empSal");
		IDao<Employee, Integer> dao = new EmployeeDAO();
		try {
			success=dao.updateById(empNO, "salary", newSal);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(success) {
			out.println("<h3>Salary updated successfully</h3>");
		}
		else {
			out.println("<h3>Employee does not exit.</h3>");
		}
		request.getRequestDispatcher("showMenu.jsp").include(request, response);

	}

}
