<%@page import="java.awt.geom.Path2D"%>
<%@ page import="com.jspider.ems.Employee_Management.Employee"%>
<%@ page import="com.jspider.ems.Employee_Management.PermanentEmployee"%>
<%@ page import="com.jspider.ems.Employee_Management.ContractEmployee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Showing employee details</h2>

	<h3>Name:${requestScope.FoundEmployee.empName}</h3>
	<h3>Gross Salary Rs.:${requestScope.FoundEmployee.empSal}</h3>
	<h3>Department: ${requestScope.FoundEmployee.department}</h3>
	<h3>Joining Date: ${requestScope.FoundEmployee.dateofJoining }</h3>
	<h3>Birth Date: ${requestScope.FoundEmployee.dateofBirth }</h3> 
	<%
	Employee emp = (Employee) request.getAttribute("FoundEmployee");
	
	
	if (emp instanceof PermanentEmployee) {
		out.println("<h3>Employee Type:Permanent</h2>");
	} else if (emp instanceof ContractEmployee) {
		ContractEmployee ce = (ContractEmployee) emp;
		out.println("<h3>Employee Type: Contract</h3>");
		out.println("<h3>Contract Period: " + ce.getContractPeriod() + "Month</h3>");
		out.println("<h3>Contractor: " + ce.getContractor() + "Months</h3>");
	}
	%>
	<h3>
		<a href="showMenu.jsp">Main Page</a>
	</h3>
</body>
</html>