package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.daos.DoctorUserDao;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.DoctorUserService;

@RestController()
@RequestMapping("/doctorUsers")
public class DoctorUserController {
	@Autowired
	DoctorUserDao doctorUserDao;
	@Autowired
	DoctorUserService doctorUserService;
	
	@PostMapping
	public Response addDoctorUser(@RequestBody DoctorUser doctorUser) {
		return doctorUserService.addDoctorUser(doctorUser);
	}
	
	@GetMapping("/heihei")
	public String hello() {
		System.out.println("this is heihei!");
		return "heihei";
	}
}
