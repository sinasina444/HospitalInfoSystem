package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.jms.PatientMqService;

@RestController
@RequestMapping("/stanDomain/patientMq")
public class MqPatientController {
	@Autowired
	PatientMqService patientMqService;
	
	@PostMapping
	String sendPatient(@RequestBody PatientUser patientUser) {
		System.out.println("111");
		patientMqService.sendUsername(patientUser.getUsername());
		return "222";
	}
}
