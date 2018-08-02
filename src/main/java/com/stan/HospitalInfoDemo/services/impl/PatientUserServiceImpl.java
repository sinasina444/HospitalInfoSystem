package com.stan.HospitalInfoDemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.PatientInfo;
import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.daos.PatientUserDao;
import com.stan.HospitalInfoDemo.http.PatientUserResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.PatientUserService;

@Service
public class PatientUserServiceImpl implements PatientUserService {
	@Autowired
	PatientUserDao patientUserDao;

	@Override
	public Response addPatientUser(PatientUser patientUser) {
		PatientInfo patientInfo = patientUser.getPatientInfo();
		patientInfo.setPatientUser(patientUser);
		return new PatientUserResponse(true,patientUserDao.save(patientUser));
	}

}
