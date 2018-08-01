package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.DoctorUser;

public class DoctorUserResponse extends Response{
	private DoctorUser doctorUser;

	public DoctorUserResponse(boolean success,DoctorUser doctorUser) {
		super(success);
		this.doctorUser = doctorUser;
	}

	public DoctorUser getDoctorUser() {
		return doctorUser;
	}

	public void setDoctorUser(DoctorUser doctorUser) {
		this.doctorUser = doctorUser;
	}
	
	
	
}
