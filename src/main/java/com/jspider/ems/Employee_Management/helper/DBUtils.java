package com.jspider.ems.Employee_Management.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("connection created");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "root");
		return con;
	}
}
