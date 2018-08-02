package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.MRI_EMR;

public class MRI_EMRResponse extends Response{
	private MRI_EMR mri_EMR;
	public MRI_EMRResponse(boolean success,MRI_EMR mri_EMR) {
		super(success);
		this.mri_EMR = mri_EMR;
	}
	public MRI_EMR getMri_EMR() {
		return mri_EMR;
	}
	public void setMri_EMR(MRI_EMR mri_EMR) {
		this.mri_EMR = mri_EMR;
	}
	
}
