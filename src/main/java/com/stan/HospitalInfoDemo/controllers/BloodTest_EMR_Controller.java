package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.BloodTest_EMR;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.BloodTest_EMR_Service;

@RestController
@RequestMapping("/stanDomain/bloodTestEMR")
public class BloodTest_EMR_Controller {
	@Autowired
	BloodTest_EMR_Service bloodTestService;
	
	@PostMapping
	Response addBloodTestEMR(@RequestBody BloodTest_EMR bloodTest_EMR){
		return bloodTestService.AddBloodTest_EMR(bloodTest_EMR);
	}
}
