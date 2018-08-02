package com.stan.HospitalInfoDemo.services;

import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.http.Response;

public interface PatientUserService {
	Response addPatientUser(PatientUser patientUser);
}
