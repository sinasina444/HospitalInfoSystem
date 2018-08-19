package com.stan.HospitalInfoDemo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.stan.HospitalInfoDemo.beans.PatientUser;

@Component
public class DoctorConsumer {
	private String patientUsername;
	private boolean bRecStop;
	public DoctorConsumer(){
		super();
		bRecStop = false;
	}
	
	@JmsListener(destination = "outPatientQueue", containerFactory = "patientContainer")
    public void receive(String patientUsername){
		if(!bRecStop){
			this.patientUsername = patientUsername;
			System.out.println("this is receive: " + this.patientUsername);
		}

//		while(!this.patientUsername.isEmpty() && !bRecStop) {
//			try {
//				Thread.sleep(4500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
    }
	public boolean isbRecStop() {
		return bRecStop;
	}
	public void setbRecStop(boolean bRecStop) {
		this.bRecStop = bRecStop;
	}
	public String getPatientUsername() {
		return patientUsername;
	}
	public void setPatientUsername(String patientUsername) {
		this.patientUsername = patientUsername;
	}
	@Override
	public String toString() {
		return "DoctorConsumer [patientUsername=" + patientUsername + "]";
	}
	
}
