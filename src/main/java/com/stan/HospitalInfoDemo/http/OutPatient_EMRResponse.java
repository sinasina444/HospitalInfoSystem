package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.OutPatient_EMR;

public class OutPatient_EMRResponse extends Response{
	private OutPatient_EMR outPatient_EMR;
	public OutPatient_EMRResponse (boolean success,OutPatient_EMR outPatient_EMR) {
		super(success);
		this.outPatient_EMR = outPatient_EMR;
	}
	public OutPatient_EMR getOutPatient_EMR() {
		return outPatient_EMR;
	}
	public void setOutPatient_EMR(OutPatient_EMR outPatient_EMR) {
		this.outPatient_EMR = outPatient_EMR;
	}
	
	
}
