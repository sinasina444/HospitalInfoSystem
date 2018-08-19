package com.stan.HospitalInfoDemo.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.Department;
import com.stan.HospitalInfoDemo.beans.OutPatient_EMR;
import com.stan.HospitalInfoDemo.daos.DoctorDao;
import com.stan.HospitalInfoDemo.daos.DoctorInfoDao;
import com.stan.HospitalInfoDemo.daos.DrugOrderDao;
import com.stan.HospitalInfoDemo.daos.PatientInfoDao;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.jms.PatientProducer;
import com.stan.HospitalInfoDemo.services.OutPatient_EMR_Serivce;

@RestController
@RequestMapping("/stanDomain/OutPatientEMR")
public class OutPatient_EMR_Controller {
	@Autowired
	OutPatient_EMR_Serivce outPatientService;
	@Autowired
	PatientProducer patientProducer;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	DoctorInfoDao doctorInfoDao;
	@Autowired
	PatientInfoDao patientInfoDao;
	@Autowired
	DrugOrderDao drugOrderDao;
	
	@PostMapping
	public Response addOutPatient_EMR(@RequestBody OutPatient_EMR outPatientEMR){
		outPatientEMR.setDepartment(new Department(2));
		outPatientEMR.setDoctor(doctorDao.findById(101).get());
		outPatientEMR.setPatientInfo(patientInfoDao.findById(outPatientEMR.getPatientInfo().getId()).get());
		outPatientEMR.setTestDate(new Date());
		return outPatientService.addOutPatientEMR(outPatientEMR);
	}
}
