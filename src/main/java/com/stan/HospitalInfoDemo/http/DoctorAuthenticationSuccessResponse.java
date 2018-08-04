package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.DoctorUser;

public class DoctorAuthenticationSuccessResponse extends Response{
	private DoctorUser doctorUser;
	public DoctorAuthenticationSuccessResponse(boolean success,int code, String message, DoctorUser doctorUser) {
		super(success,code,message);
		this.doctorUser = doctorUser;
	}
	public DoctorUser getDoctorUser() {
		return doctorUser;
	}
	public void setDoctorUser(DoctorUser doctorUser) {
		this.doctorUser = doctorUser;
	}

	
	
}
