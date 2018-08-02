package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.DoctorUserProfile;

public class DoctorUserProfileResponse extends Response{
	private DoctorUserProfile doctorUserProfile;
	public DoctorUserProfileResponse(boolean success,DoctorUserProfile doctorUserProfile) {
		super(success);
		this.doctorUserProfile = doctorUserProfile;
	}
	public DoctorUserProfile getDoctorUserProfile() {
		return doctorUserProfile;
	}
	public void setDoctorUserProfile(DoctorUserProfile doctorUserProfile) {
		this.doctorUserProfile = doctorUserProfile;
	}
	
}
