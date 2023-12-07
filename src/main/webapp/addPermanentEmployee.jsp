<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<h2>Peramanent Employee Creation</h2>
<form action="addPermanentEmployee" method="post">
<pre>
Employee No:                 <input type="text" name="empNo">
Name:                        <input type="text" name="empName">
Basic Salary :               <input type="text" name="empSal">
Department :                 <input type="text" name="empDept">
Date of Joining(mm-dd-yyyy): <input type="text" name="empJoinDate" >
Date of Birth(mm-dd-yyyy) :  <input type="text" name="empBirthDate" >
<input type="submit" value="Submit">
</pre>

</form>
<h3>a<a href="showMenu.jsp">Back</a></h3>
</body>
</html>