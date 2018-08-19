package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.daos.PatientUserDao;
import com.stan.HospitalInfoDemo.jms.DoctorMqService;

@RestController
@RequestMapping("/stanDomain/doctorMq")
public class MqDoctorController {
	@Autowired
	PatientUserDao patientUserDao;
	@Autowired
	DoctorMqService doctorMqService;
	
	@GetMapping
	String getPatientUsername() {
//		PatientUser patientUser = patientUserDao.findById(id).get();
//		String patientUsername = patientUser.getUsername();
		String res = doctorMqService.startRetrive();
		System.out.println("res=" + res);
		return res;
	}
	
}
