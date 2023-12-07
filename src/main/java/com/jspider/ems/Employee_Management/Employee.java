package com.jspider.ems.Employee_Management;

import java.time.LocalDate;
import java.util.Objects;


/**
 * Hello world!
 *
 */
public abstract class Employee 
{
	private int empNO;
	private String empName;
	private float empSal;
	private String department;
	private LocalDate dateofJoining;
	private LocalDate dateofBirth;
	//Contract
	//private int contractPeriod;
	//private String contractor;
	//private float incentives;
	//Perment
	//private float da
	//private float hra;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNO, String empName, float empSal, String department, LocalDate dateofJoining,
			LocalDate dateofBirth) {
		super();
		this.empNO = empNO;
		this.empName = empName;
		this.empSal = empSal;
		this.department = department;
		this.dateofJoining = dateofJoining;
		this.dateofBirth = dateofBirth;
		
		
	}

	public int getEmpNO() {
		return empNO;
	}

	public void setEmpNO(int empNO) {
		this.empNO = empNO;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSal() {
		return empSal;
	}

	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getDateofJoining() {
		return dateofJoining;
	}

	public void setDateofJoining(LocalDate dateofJoining) {
		this.dateofJoining = dateofJoining;
	}

	public LocalDate getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateofBirth, dateofJoining, department, empNO, empName, empSal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dateofBirth, other.dateofBirth) && Objects.equals(dateofJoining, other.dateofJoining)
				&& Objects.equals(department, other.department) && empNO == other.empNO
				&& Objects.equals(empName, other.empName)
				&& Float.floatToIntBits(empSal) == Float.floatToIntBits(other.empSal);
	}

	@Override
	public String toString() {
		return "Employee [empNO=" + empNO + ", empName=" + empName + ", empSal=" + empSal + ", department=" + department
				+ ", dateofJoining=" + dateofJoining + ", dateofBirth=" + dateofBirth + "]";
	}

	public abstract float processSalary();
}


