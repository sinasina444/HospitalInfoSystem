package com.stan.HospitalInfoDemo.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.http.Response;

public interface PatientUserService extends UserDetailsService{
	public Response addPatientUser(PatientUser patientUser);
	public Response register(PatientUser patientUser);
	public Response changePassword(PatientUser patientUser, Authentication authentication);
	public Response deleteUser(int id);
}
