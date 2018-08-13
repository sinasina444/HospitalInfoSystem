package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.beans.PatientUser;

public class PatientAuthenticationSuccessResponse extends Response{
	private PatientUser patientUser;
	public PatientAuthenticationSuccessResponse(boolean success,int code, String message, PatientUser patientUser) {
		super(success,code,message);
		this.patientUser = patientUser;
	}
	public PatientUser getPatientUser() {
		return patientUser;
	}
	public void setPatientUser(PatientUser patientUser) {
		this.patientUser = patientUser;
	}
	
}
