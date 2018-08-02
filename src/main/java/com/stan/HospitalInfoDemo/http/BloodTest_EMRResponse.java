package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.BloodTest_EMR;

public class BloodTest_EMRResponse extends Response{
	private BloodTest_EMR bloodTest_EMR;
	public BloodTest_EMRResponse(boolean success,BloodTest_EMR bloodTest_EMR) {
		super(success);
		this.bloodTest_EMR = bloodTest_EMR;
	}
	public BloodTest_EMR getBloodTest_EMR() {
		return bloodTest_EMR;
	}
	public void setBloodTest_EMR(BloodTest_EMR bloodTest_EMR) {
		this.bloodTest_EMR = bloodTest_EMR;
	}
	
}
