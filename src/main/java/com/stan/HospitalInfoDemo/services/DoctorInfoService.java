package com.stan.HospitalInfoDemo.services;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.http.Response;

public interface DoctorInfoService {
	public Response addDoctorInfo(DoctorInfo doctorInfo);
	public DoctorInfo getDocInfoByUsername(String username);
	public Response updateDoctorInfo(DoctorInfo doctorInfo);
}
