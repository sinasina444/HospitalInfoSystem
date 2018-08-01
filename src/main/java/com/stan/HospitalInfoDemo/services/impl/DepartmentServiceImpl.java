package com.stan.HospitalInfoDemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.Department;
import com.stan.HospitalInfoDemo.daos.DepartmentDao;
import com.stan.HospitalInfoDemo.http.DepartmentResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentDao departmentDao;
	@Override
	public Response addDepartment(Department department) {
		return new DepartmentResponse(true,departmentDao.save(department));
	}
	
}
