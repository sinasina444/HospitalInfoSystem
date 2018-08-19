package com.stan.HospitalInfoDemo.services.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.Department;
import com.stan.HospitalInfoDemo.beans.Doctor;
import com.stan.HospitalInfoDemo.beans.DrugOrder;
import com.stan.HospitalInfoDemo.beans.OutPatient_EMR;
import com.stan.HospitalInfoDemo.beans.PatientInfo;
import com.stan.HospitalInfoDemo.daos.DepartmentDao;
import com.stan.HospitalInfoDemo.daos.DoctorDao;
import com.stan.HospitalInfoDemo.daos.DrugOrderDao;
import com.stan.HospitalInfoDemo.daos.OutPatient_EMRDao;
import com.stan.HospitalInfoDemo.daos.PatientInfoDao;
import com.stan.HospitalInfoDemo.http.OutPatient_EMRResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.OutPatient_EMR_Serivce;

@Service
public class OutPatient_EMR_ServiceImpl implements OutPatient_EMR_Serivce{
	@Autowired
	OutPatient_EMRDao outPatientDao;
	@Autowired
	PatientInfoDao patientInfoDao;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	DrugOrderDao drugOrderDao;
	
	@Override
	public Response addOutPatientEMR(OutPatient_EMR outPatient_EMR) {
		try{
			Doctor doctor = doctorDao.findById(outPatient_EMR.getDoctor().getId()).get();
			Department department = doctor.getDepartment();
			outPatient_EMR.setDoctor(doctor);
			//outPatient_EMR.setDepartment(department);
			outPatient_EMR.setDepartment(new Department(2));
			//patientInfo
			PatientInfo patientInfo = patientInfoDao.findById(outPatient_EMR.getPatientInfo().getId()).get();
			outPatient_EMR.setPatientInfo(patientInfo);
			
			//Date
			Date currentDate = new Date();
			outPatient_EMR.setTestDate(currentDate);
			
			//DrugOrder
			int drugOrderId = outPatient_EMR.getDrugOrder().getId();
			Optional<DrugOrder> drugOrderOptional = drugOrderDao.findById(drugOrderId);
			if(drugOrderOptional.isPresent()){
				DrugOrder drugOrder = drugOrderDao.findById(drugOrderId).get();
				outPatient_EMR.setDrugOrder(drugOrder);
				outPatientDao.save(outPatient_EMR);
			}else{
				return new Response(false,"Drug Order does not exist!");
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			return new OutPatient_EMRResponse(false,outPatient_EMR);
		}
		return new OutPatient_EMRResponse(true,outPatient_EMR);
	}

}
