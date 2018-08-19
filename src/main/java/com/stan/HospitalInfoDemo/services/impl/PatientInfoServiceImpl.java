package com.stan.HospitalInfoDemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.PatientInfo;
import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.daos.PatientInfoDao;
import com.stan.HospitalInfoDemo.daos.PatientUserDao;
import com.stan.HospitalInfoDemo.http.PatientInfoResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.PatientInfoService;

@Service
public class PatientInfoServiceImpl implements PatientInfoService {
	@Autowired
	PatientUserDao patientUserDao;
	@Autowired
	PatientInfoDao patientInfoDao;
	
	
	@Override
	public Response addPatientInfo(PatientInfo patientInfo) {
		return new PatientInfoResponse(true,patientInfoDao.save(patientInfo));
	}

	@Override
	public PatientInfo getPatInfoByUsername(String username) {
		PatientUser patientUser = patientUserDao.findByUsername(username);
		return patientUser.getPatientInfo();
	}

	@Override
	public Response updatePatientInfo(PatientInfo patientInfo) {
		PatientInfo thispatientInfo = patientInfoDao.findById(patientInfo.getId()).get();
		patientInfo.setPatientUser(thispatientInfo.getPatientUser());
		return new PatientInfoResponse(true,patientInfoDao.save(patientInfo));
	}

}
