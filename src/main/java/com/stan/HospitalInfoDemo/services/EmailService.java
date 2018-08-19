package com.stan.HospitalInfoDemo.services;

public interface EmailService {
	void sendSimpleMessage(String to, String subject, String text);
}
