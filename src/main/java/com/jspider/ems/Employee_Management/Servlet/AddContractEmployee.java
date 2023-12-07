package com.jspider.ems.Employee_Management.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspider.ems.Employee_Management.ContractEmployee;
import com.jspider.ems.Employee_Management.Employee;
import com.jspider.ems.Employee_Management.dao.EmployeeDAO;
import com.jspider.ems.Employee_Management.dao.IDao;

@WebServlet("/addContractEmployee")
public class AddContractEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String EmpNo = request.getParameter("empNo");
		String empName = request.getParameter("empName");
		String sempSal = request.getParameter("empSal");
		String empDept = request.getParameter("empDept");
		String DateOfJoining = request.getParameter("empJoinDate");
		String JDateValues[] = DateOfJoining.split("-");
		String DateOfBirth = request.getParameter("empBirthDate");
		String[] bDateValues = DateOfBirth.split("-");
		String empContractor = request.getParameter("contractor");
		String ContractPeriod = request.getParameter("contractPeriod");

		// conversion from String to corresponding types

		int empNo = Integer.parseInt(EmpNo);
		float empSal = Float.parseFloat(sempSal);
		LocalDate joinDate = convertStringToLocalDate(DateOfJoining);//LocalDate.of(Integer.parseInt(JDateValues[0]), Integer.parseInt(JDateValues[1]),
				//Integer.parseInt(JDateValues[2]));
		LocalDate birthDate =convertStringToLocalDate(DateOfBirth); //LocalDate.of(Integer.parseInt(bDateValues[0]), Integer.parseInt(bDateValues[1]),
				//Integer.parseInt(bDateValues[2]));
		int empContractPeriod = Integer.parseInt(ContractPeriod);

		float empIncentives = empSal * 11.75f / 100.0f;// incentives 11.75% of basic
		ContractEmployee contEmp = new ContractEmployee(empNo, empName, empSal, empDept, joinDate, birthDate,
				empContractPeriod, empIncentives);

		IDao<Employee, Integer> idao = new EmployeeDAO();
		try {
			idao.add(contEmp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("showMenu.jsp");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Record added successfully<h3>");
		rd.include(request, response);
	}

	public LocalDate convertStringToLocalDate(String dtr)

	{
		LocalDate date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date input = sdf.parse(dtr);
			System.out.println(input);
			date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;

	}
}
