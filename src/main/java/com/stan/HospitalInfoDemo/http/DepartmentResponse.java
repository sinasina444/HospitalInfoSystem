package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.Department;

public class DepartmentResponse extends Response{
	private Department department;

	public DepartmentResponse(boolean success, Department department) {
		super(success);
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
