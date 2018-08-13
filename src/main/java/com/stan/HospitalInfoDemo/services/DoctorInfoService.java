package com.stan.HospitalInfoDemo.services;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;

public interface DoctorInfoService {
	public void addDoctorInfo(DoctorInfo doctorInfo);
	public DoctorInfo getDocInfoByUsername(String username);
}
