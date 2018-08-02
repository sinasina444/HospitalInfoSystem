package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.daos.PatientUserDao;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.PatientUserService;

@RestController
@RequestMapping("/patientUsers")
public class PatientUserController {
	@Autowired
	PatientUserDao patientUserDao;
	@Autowired
	PatientUserService patientUserService;
	
	@PostMapping
	Response addPatientUser(@RequestBody PatientUser patientUser) {
		return patientUserService.addPatientUser(patientUser);
	}
	
}
