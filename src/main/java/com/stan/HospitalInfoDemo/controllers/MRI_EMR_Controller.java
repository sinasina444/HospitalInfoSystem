package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.MRI_EMR;
import com.stan.HospitalInfoDemo.daos.MRI_EMRDao;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.MRI_EMR_Service;

@RestController
@RequestMapping("/stanDomain/MRI_EMR")
public class MRI_EMR_Controller {
	@Autowired
	MRI_EMRDao mriDao;
	@Autowired
	MRI_EMR_Service mriService;
	
	@PostMapping
	Response addMRI_EMR(@RequestBody MRI_EMR mriEMR) {
		return mriService.addMRI_EMR(mriEMR);
	}
}
