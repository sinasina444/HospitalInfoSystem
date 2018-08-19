package com.stan.HospitalInfoDemo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientMqService {
	@Autowired
	PatientProducer patientProducer;
	
	public void sendUsername (String username) {
		patientProducer.send(username);
	}
}
