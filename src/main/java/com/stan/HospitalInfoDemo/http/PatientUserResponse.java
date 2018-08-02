package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.PatientUser;

public class PatientUserResponse extends Response{
	private PatientUser patientUser;
	public PatientUserResponse(boolean success,PatientUser patientUser){
		super(success);
		this.patientUser = patientUser;
	}
	public PatientUser getPatientUser() {
		return patientUser;
	}
	public void setPatientUser(PatientUser patientUser) {
		this.patientUser = patientUser;
	}
	
}
