package com.stan.HospitalInfoDemo.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.http.Response;

public interface DoctorUserService extends UserDetailsService{
	//Spring Security
	public Response register(DoctorUser doctorUser);
	public Response changePassword(DoctorUser doctorUser, Authentication authentication);
	public Response deleteUser(int id);
	
	
	
	
	public Response addDoctorUser(DoctorUser doctorUser);
}

