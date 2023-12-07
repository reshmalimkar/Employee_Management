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

@WebServlet("/searchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String EmpNo = request.getParameter("empNo");
		int empNo=Integer.parseInt(EmpNo);
		IDao<Employee,Integer> dao = new EmployeeDAO();
		Employee emp=null;
	   try {
		emp=dao.getById(empNo);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   if(emp!=null) {
		   request.setAttribute("FoundEmployee", emp);
		   request.getRequestDispatcher("showEmployee.jsp").forward(request, response);
	   }
	   else {
		   out.println("<h3>employee does not exit...</h3>");
		   request.getRequestDispatcher("showMenu.jsp").include(request, response);
	   }
	}

}
