package com.stan.HospitalInfoDemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.daos.DoctorInfoDao;
import com.stan.HospitalInfoDemo.daos.DoctorUserDao;
import com.stan.HospitalInfoDemo.http.DoctorInfoResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.DoctorInfoService;

@Service
public class DoctorInfoServiceImpl implements DoctorInfoService{
	@Autowired
	DoctorUserDao doctorUserDao;
	@Autowired
	DoctorInfoDao doctorInfoDao;
	
	@Override
	public Response addDoctorInfo(DoctorInfo doctorInfo) {
		return new DoctorInfoResponse(true,doctorInfoDao.save(doctorInfo));
	}
	
	@Override
	public DoctorInfo getDocInfoByUsername(String username) {
		DoctorUser doctorUser = doctorUserDao.findByUsername(username);
		return doctorUser.getDoctorInfo();
	}

	@Override
	public Response updateDoctorInfo(DoctorInfo doctorInfo) {
		DoctorInfo thisDoctorInfo = doctorInfoDao.findById(doctorInfo.getId()).get();
		doctorInfo.setDoctorUser(thisDoctorInfo.getDoctorUser());
//		thisDoctorInfo.setFirstName(doctorInfo.getFirstName());
//		thisDoctorInfo.setLastName(doctorInfo.getLastName());
//		thisDoctorInfo.setSex(doctorInfo.getSex());
//		thisDoctorInfo.setAddress(doctorInfo.getAddress());
//		thisDoctorInfo.setCellphone(doctorInfo.getCellphone());
		//return new DoctorInfoResponse(true,doctorInfoDao.save(thisDoctorInfo));
		return new DoctorInfoResponse(true,doctorInfoDao.save(doctorInfo));
	}
}
