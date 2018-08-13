package com.stan.HospitalInfoDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.daos.DoctorDao;
import com.stan.HospitalInfoDemo.daos.DoctorInfoDao;
import com.stan.HospitalInfoDemo.daos.DoctorUserDao;
import com.stan.HospitalInfoDemo.services.DoctorService;

@RestController
@RequestMapping("/stanDomain/doctorInfo")
public class DoctorInfoController {
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	DoctorUserDao doctorUserDao;
	@Autowired
	DoctorInfoDao doctorInfoDao;
	@Autowired
	DoctorService doctorService;
	
	@GetMapping
	List<DoctorInfo> getAllDoctorInfo(){
		return doctorInfoDao.findAll();
	}
	
	@GetMapping("/username/{username}")
	public DoctorInfo getDoctorInfoByUsername(@PathVariable String username) {
		DoctorUser doctorUser = doctorUserDao.findByUsername(username);
		return doctorUser.getDoctorInfo();
	}
	
	@GetMapping("/{id}")
	public DoctorInfo getDoctorInfoById(@PathVariable int id) {
		DoctorInfo doctorInfo = doctorInfoDao.findById(id).get();
		return doctorInfo;
	}
}
