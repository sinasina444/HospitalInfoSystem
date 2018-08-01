package com.stan.HospitalInfoDemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.daos.DoctorInfoDao;
import com.stan.HospitalInfoDemo.services.DoctorInfoService;

public class DoctorInfoServiceImpl implements DoctorInfoService{
	@Autowired
	DoctorInfoDao doctorInfoDao;
	
	
	public void addDoctorInfo(DoctorInfo doctorInfo) {
		doctorInfoDao.save(doctorInfo);
	}
}
