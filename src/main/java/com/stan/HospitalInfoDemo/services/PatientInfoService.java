package com.stan.HospitalInfoDemo.services;

import com.stan.HospitalInfoDemo.beans.PatientInfo;
import com.stan.HospitalInfoDemo.http.Response;

public interface PatientInfoService {
	public Response addPatientInfo(PatientInfo patientInfo);
	public PatientInfo getPatInfoByUsername(String username);
	public Response updatePatientInfo(PatientInfo patientInfo);
}
