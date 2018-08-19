package com.stan.HospitalInfoDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.PatientInfo;
import com.stan.HospitalInfoDemo.daos.PatientInfoDao;
import com.stan.HospitalInfoDemo.daos.PatientUserDao;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.PatientInfoService;
import com.stan.HospitalInfoDemo.services.PatientUserService;

@RestController
@RequestMapping("/stanDomain/patientInfo")
public class PatientInfoController {
	@Autowired
	PatientUserService patientUserService;
	@Autowired
	PatientInfoService patientInfoService;
	@Autowired
	PatientInfoDao patientInfoDao;
	@Autowired
	PatientUserDao patientUserDao;
	
	@GetMapping
	List<PatientInfo> getAllPatientInfo(){
		return patientInfoDao.findAll();
	}
	
	@GetMapping("/{id}")
	PatientInfo getPatientInfoById(@PathVariable int id) {
		return patientInfoDao.findById(id).get();
	}
	
	@GetMapping("/username")
	PatientInfo getPatientInfoByUsername(@RequestParam String username) {
		return patientInfoService.getPatInfoByUsername(username);
	}
	
	@PutMapping
	Response updatePatientInfo(@RequestBody PatientInfo patientInfo) {
		return patientInfoService.updatePatientInfo(patientInfo);
	}
	
	
	
}
