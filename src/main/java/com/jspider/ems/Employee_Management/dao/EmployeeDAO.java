package com.jspider.ems.Employee_Management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.jspider.ems.Employee_Management.ContractEmployee;
import com.jspider.ems.Employee_Management.Employee;
import com.jspider.ems.Employee_Management.PermanentEmployee;
import com.jspider.ems.Employee_Management.helper.DBUtils;

public class EmployeeDAO implements IDao<Employee, Integer> {

	@Override
	public void add(Employee emp) throws Exception {
		String sqlQuery = null;
		String empType = null;
		Connection con = DBUtils.getConnection();
		if (emp instanceof PermanentEmployee) {
			sqlQuery = "insert into employee_management.employee_master (emp_no, emp_name, emp_sal, emp_dept, emp_join_date, emp_birth_date, emp_type, emp_perm_da, emp_perm_hra) values  (?,?,?,?,?,?,?,?,?)";
			PermanentEmployee pe = (PermanentEmployee) emp;
			int empNo = pe.getEmpNO();
			String empName = pe.getEmpName();
			float empSal = pe.getEmpSal();
			String empDept = pe.getDepartment();
			LocalDate empJoinDate = pe.getDateofJoining();
			LocalDate empBirthDate = pe.getDateofBirth();
			empType = "PERMANENT";
			float empDa = pe.getDa();
			float empHra = pe.getHra();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, empNo);
			ps.setString(2, empName);
			ps.setFloat(3, empSal);
			ps.setString(4, empDept);
			ps.setDate(5, java.sql.Date.valueOf(empJoinDate));
			ps.setDate(6, java.sql.Date.valueOf(empBirthDate));
			ps.setString(7, empType);
			ps.setFloat(8, empDa);
			ps.setFloat(9, empHra);
			ps.executeUpdate();

		} else if (emp instanceof ContractEmployee) {
			sqlQuery = "INSERT INTO employee_management.employee_master ( emp_no ,  emp_name ,  emp_sal ,  emp_dept ,  emp_join_date ,  emp_birth_date ,  emp_type , emp_cont_incentives,emp_cont_period,emp_cont_contractor )  VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ContractEmployee ce = (ContractEmployee) emp;
			int empNO = ce.getEmpNO();
			String empName = ce.getEmpName();
			float empSal = ce.getEmpSal();
			String empDept = ce.getDepartment();
			LocalDate empJoinDate = ce.getDateofJoining();
			LocalDate empBirthDate = ce.getDateofBirth();
			empType = "CONTRACT";
			float empIncentives = ce.getIncentives();
			int getContractPeriod = ce.getContractPeriod();
			String empContractor = ce.getContractor();

			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, empNO);
			ps.setString(2, empName);
			ps.setFloat(3, empSal);
			ps.setString(4, empDept);
			ps.setDate(5, java.sql.Date.valueOf(empJoinDate));
			ps.setDate(6, java.sql.Date.valueOf(empBirthDate));
			ps.setString(7, empType);
			ps.setFloat(8, empIncentives);
			ps.setInt(9, getContractPeriod);
			ps.setString(10, empContractor);

			int executeUpdate = ps.executeUpdate();
			if (executeUpdate == 1) {
				System.out.println("Record Added Successfully");
			} else {
				System.out.println("Record Added Not Successfully");
			}

		}

	}

	@Override
	public Employee getById(Integer empNo) throws Exception {
		// TODO Auto-generated method stub
		Employee emp = null;
		String sqlQuery = "select * from employee_master where emp_no=?";
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setInt(1, empNo);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String empName = rs.getString(2);
			float empSal = rs.getFloat(3);
			String empDept = rs.getString(4);
			LocalDate empJoinDate = rs.getDate(5).toLocalDate();
			LocalDate empBirthDate = rs.getDate(6).toLocalDate();
			String empType = rs.getString(7);
			if (empType.equals("PERMANENT")) {
				float empDa = rs.getFloat(8);
				float empHra = rs.getFloat(9);
				emp = new PermanentEmployee(empNo, empName, empSal, empDept, empJoinDate, empBirthDate, empDa, empHra);
				return emp;
			} else if (empType.equals("CONTRACT")) {
				float empIncentives = rs.getFloat(10);
				int empContractPeriod = rs.getInt(11);
				String empContractor = rs.getString(12);
//				String empContractor = rs.getString(12);
				emp = new ContractEmployee(empNo, empName, empSal, empDept, empJoinDate, empBirthDate, empIncentives,
						empContractPeriod, empContractor);
				return emp;
			}
		}
		return emp;

	}

	public static void main(String[] args) throws Exception {
		IDao<Employee, Integer> dao = new EmployeeDAO();
		Employee emp = dao.getById(104);
		System.out.println(emp.getClass().getName());
	}

	@Override
	public boolean updateById(Integer key, String fieldName, String val) throws Exception {
		boolean SUCCESS = false;
		String empType = null;
		Connection con = DBUtils.getConnection();
		String sqlQuery = "select emp_type from employee_master where emp_no=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setInt(1, key);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			SUCCESS = true;
			empType = rs.getString(1);

		}
		// rs.close();
		// ps.close();
		if (SUCCESS) {
			if (fieldName.equals("salary")) {
				float newSal = Float.parseFloat(val);
				if (empType.equals("PERMANENT")) {
					float newDa = newSal * 10.0f / 100.0f;
					float newHra = newSal * 7.5f / 100.0f;
					ps = con.prepareStatement(
							"update employee_master set emp_sal=?,emp_perm_da=?,emp_perm_Hra=? where emp_no=?");
					ps.setFloat(1, newSal);
					ps.setFloat(2, newDa);
					ps.setFloat(3, newHra);
					ps.setInt(4, key);
					ps.executeUpdate();
				} else {
					float newIncentives = newSal * 11.75f / 100.0f;
					ps = con.prepareStatement(
							"update employee_master set emp_sal=?,emp_cont_incentives=? where emp_no=?");
					ps.setFloat(1, newSal);
					ps.setFloat(2, newIncentives);
					ps.setInt(3, key);
					ps.executeUpdate();
				}
			} else if (fieldName.equals("department")) {
				ps = con.prepareStatement("update employee_master set emp_dept=? where emp_no=?");
				ps.setString(1, val);
				ps.setInt(2, key);
				ps.executeUpdate();

			}
		}
		return SUCCESS;
	}

}
