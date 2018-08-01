package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.Doctor;

public class DoctorAuthenticationSuccessResponse extends Response{
	private Doctor doctor;
	public DoctorAuthenticationSuccessResponse(boolean success,int code, String message, Doctor doctor) {
		super(success,code,message);
		this.doctor = doctor;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
