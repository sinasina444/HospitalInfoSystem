package com.stan.HospitalInfoDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.Doctor;
import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.daos.DoctorDao;
import com.stan.HospitalInfoDemo.daos.DoctorInfoDao;
import com.stan.HospitalInfoDemo.daos.DoctorUserDao;
import com.stan.HospitalInfoDemo.http.DoctorInfoResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.DoctorService;

@RestController
@RequestMapping("/stanDomain/doctors")
public class DoctorController {
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	DoctorUserDao doctorUserDao;
	@Autowired
	DoctorInfoDao doctorInfoDao;
	@Autowired
	DoctorService doctorService;
	

	
	@GetMapping("/{username}")
	public Doctor getDoctorByUsername(@PathVariable String username) {
		return doctorService.getDoctorByUsername(username);
	}
	
	@GetMapping("/id/{id}")
	public Doctor getDoctorById(@PathVariable int id) {
		return doctorDao.findById(id).get();
	}
	
	@GetMapping
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctor();
	}
	
	@GetMapping("/doctorInfo/{id}")
	public Doctor getDoctorByDoctorInfoId(@PathVariable int id) {
		return doctorService.getDoctorByDoctorInfoId(id);
	}
	
	
	@PostMapping
	public Response addDoctor( @RequestParam String username, @RequestBody Doctor doctor) {
		return doctorService.addDoctorByUsername(username, doctor);
	}
	
	@PutMapping
	public Response updateDoctor(@RequestBody Doctor doctor) {
		return doctorService.updateDoctor(doctor);
	}
	
	@PutMapping("/doctorInfo")
	public Response updateDoctorInfo(@RequestParam DoctorInfo doctorInfo) {
		DoctorInfo newDocInfo = doctorInfoDao.findById(doctorInfo.getId()).get();
		if(newDocInfo == null) {
			return new Response(false,"Doctor Information does not exist!");
		}
		newDocInfo.setFirstName(doctorInfo.getFirstName());
		newDocInfo.setLastName(doctorInfo.getLastName());
		newDocInfo.setSex(doctorInfo.getSex());
		newDocInfo.setCellphone(doctorInfo.getCellphone());
		newDocInfo.setAddress(doctorInfo.getAddress());
		return new DoctorInfoResponse(true,newDocInfo);
	}
	
}
