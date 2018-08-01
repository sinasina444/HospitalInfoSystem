package com.stan.HospitalInfoDemo.http;
import com.stan.HospitalInfoDemo.beans.DoctorInfo;

public class DoctorInfoResponse extends Response{
	private DoctorInfo doctorInfo;

	public DoctorInfoResponse(boolean success, DoctorInfo doctorInfo) {
		super(success);
		this.doctorInfo = doctorInfo;
	}

	public DoctorInfo getDoctorInfo() {
		return doctorInfo;
	}

	public void setDoctorInfo(DoctorInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
	}
}
