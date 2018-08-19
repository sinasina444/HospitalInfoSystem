package com.stan.HospitalInfoDemo.services;

import java.util.List;

import com.stan.HospitalInfoDemo.beans.Doctor;
import com.stan.HospitalInfoDemo.http.Response;

public interface DoctorService {
	Response addDoctorByUsername(String username, Doctor doctor);
	Doctor getDoctorByUsername(String username);
	Doctor getDoctorByDoctorInfoId(int id);
	List<Doctor> getAllDoctor();
	Response updateDoctor(Doctor doctor);
	
}
