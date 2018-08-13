package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.Department;
import com.stan.HospitalInfoDemo.daos.DepartmentDao;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.DepartmentService;

@RestController()
@RequestMapping("/stanDomain/departments")
public class DepartmentController {
	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping
	Response addDepartment(@RequestBody Department department){
		return departmentService.addDepartment(department);
	}
}
