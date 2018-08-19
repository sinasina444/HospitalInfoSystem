package com.stan.HospitalInfoDemo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorMqService {
	@Autowired
	DoctorConsumer doctorConsumer;
	
	public void startWorking() {
		
	}
	
	public void clearPatientUsername() {
		if(!doctorConsumer.getPatientUsername().isEmpty()) {
			doctorConsumer.setPatientUsername(null);
		}
	}
	
	public void stopRetrive() {
		doctorConsumer.setbRecStop(true);
	}
	
	public String startRetrive() {
		doctorConsumer.setbRecStop(false);
		return doctorConsumer.getPatientUsername();
	}
	
//	public String nextRetrive() {
//		doctorConsumer.setPatientUsername(null);
//		return doctorConsumer.getPatientUsername();
//	}
}
