package com.stan.HospitalInfoDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Response register(@RequestBody DoctorUser doctorUser) {
		return doctorUserService.register(doctorUser);
	}
	
	@GetMapping
	public List<DoctorUser> getAllUsers() {
		return doctorUserDao.findAll();
	}
	
	@PutMapping
	public Response changePassword(@RequestBody DoctorUser doctorUser,Authentication authentication) {
		return doctorUserService.changePassword(doctorUser, authentication);
	}
	
	@DeleteMapping
	public Response deleteUser(int id) {
		return doctorUserService.deleteUser(id);
	}
	
	@GetMapping("/heihei")
	public String hello() {
		System.out.println("this is heihei!");
		return "heihei";
	}
}
