package com.jspider.ems.Employee_Management.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspider.ems.Employee_Management.Employee;
import com.jspider.ems.Employee_Management.PermanentEmployee;
import com.jspider.ems.Employee_Management.dao.EmployeeDAO;
import com.jspider.ems.Employee_Management.dao.IDao;

@WebServlet("/addPermanentEmployee")
public class AddPermanentEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String EmpNo = request.getParameter("empNo");
		String empName = request.getParameter("empName");
		String sempSal = request.getParameter("empSal");
		String empDept = request.getParameter("empDept");
		String DateOfJoining = request.getParameter("empJoinDate");
		String JDateValues[]= DateOfJoining.split("-");
		String DateOfBirth = request.getParameter("empBirthDate");
		String[] bDateValues=DateOfBirth.split("-");
		
		//Converting from String to corresponding types
		
		int empNo=Integer.parseInt(EmpNo);
		float empSal=Float.parseFloat(sempSal);
		 float empDa=empSal*10.0f/100.0f;//Da is 10% of basic salary
		float empHra=empSal*7.5f/100.0f;//Hra is 7.5% of Basic
		LocalDate joinDate = StringToLocalDate(DateOfJoining);
		LocalDate birthDate =StringToLocalDate(DateOfBirth);
		PermanentEmployee permEmp = new PermanentEmployee(empNo, empName, empSal, empDept, joinDate, birthDate, empDa, empHra);

	    IDao<Employee ,Integer> idao = new EmployeeDAO();
	    try {
	    	idao.add(permEmp);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    RequestDispatcher rd = request.getRequestDispatcher("showMenu.jsp");
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<h3>Record added successfully<h3>");
	    rd.include(request, response);
	}
	public LocalDate StringToLocalDate(String dtr) {
		LocalDate date=null;
		try {//MM-dd-yyyy  
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
			java.util.Date input=dateFormat.parse(dtr);
			date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
			}

}
