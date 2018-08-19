package com.stan.HospitalInfoDemo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.stan.HospitalInfoDemo.beans.PatientUser;

@Component
public class PatientProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(String message) {
		jmsTemplate.convertAndSend(message);
	}
	
//	public void send(String destination, PatientUser patientUser) {
//		System.out.println(patientUser);
//		jmsTemplate.convertAndSend(destination, patientUser);
//	}
}
