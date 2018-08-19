package com.stan.HospitalInfoDemo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class DoctorProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(String message) {
		jmsTemplate.convertAndSend(message);
	}
}
