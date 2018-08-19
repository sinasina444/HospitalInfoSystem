package com.stan.HospitalInfoDemo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.Department;
import com.stan.HospitalInfoDemo.beans.MRI_EMR;
import com.stan.HospitalInfoDemo.daos.DoctorDao;
import com.stan.HospitalInfoDemo.daos.DoctorInfoDao;
import com.stan.HospitalInfoDemo.daos.MRI_EMRDao;
import com.stan.HospitalInfoDemo.daos.PatientInfoDao;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.jms.PatientProducer;
import com.stan.HospitalInfoDemo.services.MRI_EMR_Service;

@RestController
@RequestMapping("/stanDomain/doctorMRIEMR")
public class MRI_EMR_Controller {
	@Autowired
	MRI_EMRDao mriDao;
	@Autowired
	MRI_EMR_Service mriService;
	@Autowired
	PatientProducer patientProducer;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	DoctorInfoDao doctorInfoDao;
	@Autowired
	PatientInfoDao patientInfoDao;
	
	@PostMapping
	Response addMRI_EMR(@RequestBody MRI_EMR mriEMR) {
		System.out.println("jdskjflskdjflks");
		mriEMR.setDepartment(new Department(2));
		mriEMR.setDoctor(doctorDao.findById(101).get());
		mriEMR.setPatientInfo(patientInfoDao.findById(mriEMR.getPatientInfo().getId()).get());
		mriEMR.setImage("https://s3.us-east-2.amazonaws.com/msi-dev-stan/cat.jpg");
		mriEMR.setTestDate(new Date());
		return mriService.addMRI_EMR(mriEMR);
	}
	
	@GetMapping("/{id}")
	MRI_EMR getMRI_EMRByPatientId(@PathVariable int id) {
		List<MRI_EMR> emrs = mriDao.findAll();
		int tempid = 0;
		for(MRI_EMR temp: emrs) {
			if(id == temp.getPatientInfo().getId()) {
				tempid = temp.getId();
			}
		}
		return mriDao.findById(tempid).get();
	}
	

	
//	@PostMapping("/user")
//	String sendPatient(@RequestBody PatientUser patientUser) {
//		System.out.println("111");
//		patientProducer.send("outPatientQueue", patientUser);
//		return "222";
//	}
}
