package com.jspider.ems.Employee_Management;

import java.time.LocalDate;
import java.util.Objects;



public class PermanentEmployee  extends Employee{
	private float da,hra;

	public PermanentEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PermanentEmployee(int empNo, String empName, float empSal, String empDept, LocalDate joinDate,
			LocalDate birthDate, float empDa, float empHra) {
		// TODO Auto-generated constructor stub
		super(empNo, empName, empSal, empDept, joinDate, birthDate);
		this.da=empDa;
		this.hra=empHra;
	}

	


	public float getDa() {
		return da;
	}

	public void setDa(float da) {
		this.da = da;
	}

	public float getHra() {
		return hra;
	}

	public void setHra(float hra) {
		this.hra = hra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(da, hra);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermanentEmployee other = (PermanentEmployee) obj;
		return Float.floatToIntBits(da) == Float.floatToIntBits(other.da)
				&& Float.floatToIntBits(hra) == Float.floatToIntBits(other.hra);
	}

	@Override
	public String toString() {
		return "PermanentEmployee [da=" + da + ", hra=" + hra + "]";
	}

	@Override
	public float processSalary() {
		// TODO Auto-generated method stub
		float empSal=getEmpSal();
		float sal=empSal+da+hra;
		
		return sal;
	}

}
