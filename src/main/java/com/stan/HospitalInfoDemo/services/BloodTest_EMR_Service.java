package com.stan.HospitalInfoDemo.services;

import com.stan.HospitalInfoDemo.beans.BloodTest_EMR;
import com.stan.HospitalInfoDemo.http.Response;

public interface BloodTest_EMR_Service {
	Response AddBloodTest_EMR(BloodTest_EMR bloodTest_EMR);
	//Response AddBloodTest_EMR(BloodTest_EMR bloodTest_EMR,Authentication authentication);
}
