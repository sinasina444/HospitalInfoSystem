package com.stan.HospitalInfoDemo.services.impl;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.Department;
import com.stan.HospitalInfoDemo.beans.Doctor;
import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.daos.DepartmentDao;
import com.stan.HospitalInfoDemo.daos.DoctorDao;
import com.stan.HospitalInfoDemo.daos.DoctorInfoDao;
import com.stan.HospitalInfoDemo.daos.DoctorUserDao;
import com.stan.HospitalInfoDemo.http.DoctorResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	DoctorUserDao doctorUserDao;
	@Autowired
	DoctorInfoDao doctorInfoDao;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	DepartmentDao departmentDao;


	@Override
	public Response addDoctorByUsername(String username, Doctor doctor) {
		DoctorUser doctorUser = doctorUserDao.findByUsername(username);
		DoctorInfo doctorInfo = doctorInfoDao.findByDoctorUser(doctorUser);
		Department department = departmentDao.findById(doctor.getDepartment().getId()).get();
		doctor.setDepartment(department);
		doctor.setDoctorInfo(doctorInfo);
		doctorDao.save(doctor);
		return new DoctorResponse(true,doctor);
	}
	
	@Override
	public Doctor getDoctorByUsername(String username) {
		DoctorUser doctorUser = doctorUserDao.findByUsername(username);
		if(doctorUser == null) {
			return null;
		}
		DoctorInfo doctorInfo = doctorUser.getDoctorInfo();
		return  doctorDao.findByDoctorInfo(doctorInfo);
	}
	
	@Override
	public Doctor getDoctorByDoctorInfoId(int id) {
		Optional<DoctorInfo> optionDoctorInfo = doctorInfoDao.findById(id);
		if(!optionDoctorInfo.isPresent()) {
			return null;
		}
		DoctorInfo doctorInfo = optionDoctorInfo.get();
		Doctor doctor = doctorDao.findByDoctorInfo(doctorInfo);
		if(doctor == null) {
			return null;
		}
		return doctor;
		
	}
	
	@Override
	public List<Doctor> getAllDoctor(){
		return doctorDao.findAll();
	}
	
	
}
