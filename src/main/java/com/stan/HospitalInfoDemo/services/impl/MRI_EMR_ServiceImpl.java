package com.stan.HospitalInfoDemo.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.Department;
import com.stan.HospitalInfoDemo.beans.Doctor;
import com.stan.HospitalInfoDemo.beans.MRI_EMR;
import com.stan.HospitalInfoDemo.beans.PatientInfo;
import com.stan.HospitalInfoDemo.daos.DepartmentDao;
import com.stan.HospitalInfoDemo.daos.DoctorDao;
import com.stan.HospitalInfoDemo.daos.MRI_EMRDao;
import com.stan.HospitalInfoDemo.daos.PatientInfoDao;
import com.stan.HospitalInfoDemo.http.MRI_EMRResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.MRI_EMR_Service;

@Service
public class MRI_EMR_ServiceImpl implements MRI_EMR_Service{

	@Autowired
	MRI_EMRDao mri_EMRDao;
	@Autowired
	PatientInfoDao patientInfoDao;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	DepartmentDao departmentDao;
	
	@Override
	public Response addMRI_EMR(MRI_EMR mri_EMR) {
		try{
			Doctor doctor = doctorDao.findById(mri_EMR.getDoctor().getId()).get();
			Department department = doctor.getDepartment();
			mri_EMR.setDoctor(doctor);
			mri_EMR.setDepartment(department);
			//patientInfo
			PatientInfo patientInfo = patientInfoDao.findById(mri_EMR.getPatientInfo().getId()).get();
			mri_EMR.setPatientInfo(patientInfo);
			
			//Date
			Date currentDate = new Date();
			mri_EMR.setTestDate(currentDate);
			
			mri_EMRDao.save(mri_EMR);
		
		} catch (Exception e) {
			e.printStackTrace();
			return new MRI_EMRResponse(false,mri_EMR);
		}
		return new MRI_EMRResponse(true,mri_EMR);
		
	}

}
