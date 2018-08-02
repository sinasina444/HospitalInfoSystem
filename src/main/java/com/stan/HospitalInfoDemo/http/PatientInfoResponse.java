package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.PatientInfo;

public class PatientInfoResponse extends Response{
	private PatientInfo patientInfo;
	public PatientInfoResponse(boolean success,PatientInfo patientInfo) {
		super(success);
		this.patientInfo = patientInfo;
	}
	public PatientInfo getPatientInfo() {
		return patientInfo;
	}
	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}
	
	
}
