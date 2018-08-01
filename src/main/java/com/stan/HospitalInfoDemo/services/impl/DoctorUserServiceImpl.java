package com.stan.HospitalInfoDemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.Doctor;
import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.daos.DoctorUserDao;
import com.stan.HospitalInfoDemo.http.DoctorUserResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.DoctorUserService;

@Service
public class DoctorUserServiceImpl implements DoctorUserService{
	@Autowired
	DoctorUserDao doctorUserDao;

	@Override
	public Response addDoctorUser(DoctorUser doctorUser) {
		DoctorInfo doctorInfo = doctorUser.getDoctorInfo();
		Doctor doctor = doctorInfo.getDoctor();
		doctorInfo.setDoctorUser(doctorUser);
		doctor.setDoctorInfo(doctorInfo);
		//doctorUser.setDoctorInfo(doctorInfo);
		return new DoctorUserResponse(true,doctorUserDao.save(doctorUser));
	}
	
}
