package com.stan.HospitalInfoDemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.daos.DoctorInfoDao;
import com.stan.HospitalInfoDemo.daos.DoctorUserDao;
import com.stan.HospitalInfoDemo.services.DoctorInfoService;

public class DoctorInfoServiceImpl implements DoctorInfoService{
	@Autowired
	DoctorUserDao doctorUserDao;
	@Autowired
	DoctorInfoDao doctorInfoDao;
	
	@Override
	public void addDoctorInfo(DoctorInfo doctorInfo) {
		doctorInfoDao.save(doctorInfo);
	}
	
	@Override
	public DoctorInfo getDocInfoByUsername(String username) {
		DoctorUser doctorUser = doctorUserDao.findByUsername(username);
		return doctorUser.getDoctorInfo();
	}
}
