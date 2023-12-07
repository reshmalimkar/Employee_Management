<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<h2>Welcome To Employee Management System</h2>
	
	<a href="addPermanentEmployee.jsp">Create Permanent Employee</a>  <br>
	<a href=" addContractEmployee.jsp">Create Contract Employee</a> <br> 
	<a href="searchEmployee.jsp">Search Employee</a> <br>
	<a href="updateSalary.jsp">Update Salary</a> <br>
	<a href="updateDept.jsp">Update Department</a> <br>
	<form action="LogOut" method="post">
	<br>
	<input type="submit" value="Log Out">
	</form>
</body>
</html>