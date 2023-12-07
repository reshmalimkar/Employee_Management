package com.jspider.ems.Employee_Management;

import java.time.LocalDate;

public class ContractEmployee extends Employee {
	private int contractPeriod;
	private String contractor;
	private float incentives;
	public ContractEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}public ContractEmployee(Integer empNo, String empName, float empSal, String empDept,
			LocalDate joinDate, LocalDate birthDate, int empContractPeriod, float empIncentives) {
		super(empNo, empName, empSal, empDept, joinDate, birthDate);
    this.incentives=empIncentives;
//    this.contractor=contractor;
    this.contractPeriod=empContractPeriod;
	}
	
	public ContractEmployee(Integer empNo, String empName, float empSal, String empDept, LocalDate empJoinDate,
			LocalDate empBirthDate, float empIncentives, int empContractPeriod, String empContractor) {
		//super(empContractPeriod, empName, empSal, empContractor, empJoinDate, empBirthDate);
		super(empNo, empName, empSal, empDept, empJoinDate, empBirthDate);
		this.incentives=empIncentives;
	    this.contractor=empContractor;
	    this.contractPeriod=empContractPeriod;
	}
	
	
	public int getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getContractor() {
		return contractor;
	}
	public void setContractor(String contractor) {
		this.contractor = contractor;
	}
	public float getIncentives() {
		return incentives;
	}
	public void setIncentives(float incentives) {
		this.incentives = incentives;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + contractPeriod;
		result = prime * result + ((contractor == null) ? 0 : contractor.hashCode());
		result = prime * result + Float.floatToIntBits(incentives);
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
		ContractEmployee other = (ContractEmployee) obj;
		if (contractPeriod != other.contractPeriod)
			return false;
		if (contractor == null) {
			if (other.contractor != null)
				return false;
		} else if (!contractor.equals(other.contractor))
			return false;
		if (Float.floatToIntBits(incentives) != Float.floatToIntBits(other.incentives))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ContractEmployee [contractPeriod=" + contractPeriod + ", contractor=" + contractor + ", incentives="
				+ incentives + "]";
	}
	@Override
	public float processSalary() {
		// TODO Auto-generated method stub
		float empSal=getEmpSal();
		float sal=empSal+incentives;
		return sal;
	}
	

}
