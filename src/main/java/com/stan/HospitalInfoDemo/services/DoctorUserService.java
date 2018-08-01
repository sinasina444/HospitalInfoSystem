package com.stan.HospitalInfoDemo.services;

import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.http.Response;

public interface DoctorUserService {
	public Response addDoctorUser(DoctorUser doctorUser);
}
