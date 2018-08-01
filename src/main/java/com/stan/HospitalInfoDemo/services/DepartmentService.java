package com.stan.HospitalInfoDemo.services;

import com.stan.HospitalInfoDemo.beans.Department;
import com.stan.HospitalInfoDemo.http.Response;

public interface DepartmentService {
	public Response addDepartment(Department department);
}
