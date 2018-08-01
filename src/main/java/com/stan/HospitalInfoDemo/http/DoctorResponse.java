package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.Doctor;

public class DoctorResponse extends Response{
	private Doctor doctor;

	public DoctorResponse(boolean success,Doctor doctor) {
		super(success);
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	
}
