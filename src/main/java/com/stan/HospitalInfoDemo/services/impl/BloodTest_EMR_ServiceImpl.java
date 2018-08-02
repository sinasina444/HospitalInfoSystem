package com.stan.HospitalInfoDemo.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.BloodTest_EMR;
import com.stan.HospitalInfoDemo.beans.Department;
import com.stan.HospitalInfoDemo.beans.Doctor;
import com.stan.HospitalInfoDemo.daos.BloodTest_EMRDao;
import com.stan.HospitalInfoDemo.daos.DepartmentDao;
import com.stan.HospitalInfoDemo.daos.DoctorDao;
import com.stan.HospitalInfoDemo.daos.PatientInfoDao;
import com.stan.HospitalInfoDemo.http.BloodTest_EMRResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.BloodTest_EMR_Service;

@Service
public class BloodTest_EMR_ServiceImpl implements BloodTest_EMR_Service {
	@Autowired
	BloodTest_EMRDao bloodTest_EMRDao;
	@Autowired
	PatientInfoDao patientInfoDao;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	DepartmentDao departmentDao;

	@Override
	public Response AddBloodTest_EMR(BloodTest_EMR bloodTest_EMR) {
		try{
			//Doctor and Department
			Doctor doctor = doctorDao.findById(bloodTest_EMR.getDoctor().getId()).get();
			Department department = doctor.getDepartment();
			bloodTest_EMR.setDoctor(doctor);
			bloodTest_EMR.setDepartment(department);
			
			//Date
			Date currentDate = new Date();
			bloodTest_EMR.setTestDate(currentDate);
			
			bloodTest_EMRDao.save(bloodTest_EMR);
		
		} catch (Exception e) {
			e.printStackTrace();
			return new BloodTest_EMRResponse(false,bloodTest_EMR);
		}
		return new BloodTest_EMRResponse(true,bloodTest_EMR);
	}

}
