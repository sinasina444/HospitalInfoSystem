package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.OutPatient_EMR;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.OutPatient_EMR_Serivce;

@RestController
@RequestMapping("/stanDomain/OutPatientEMR")
public class OutPatient_EMR_Controller {
	@Autowired
	OutPatient_EMR_Serivce outPatientService;
	
	@PostMapping
	public Response addOutPatient_EMR(@RequestBody OutPatient_EMR outPatientEMR){
		return outPatientService.addOutPatientEMR(outPatientEMR);
	}
}
