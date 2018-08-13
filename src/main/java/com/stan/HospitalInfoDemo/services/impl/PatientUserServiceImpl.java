package com.stan.HospitalInfoDemo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.PatientInfo;
import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.beans.PatientUserProfile;
import com.stan.HospitalInfoDemo.daos.PatientUserDao;
import com.stan.HospitalInfoDemo.daos.PatientUserProfileDao;
import com.stan.HospitalInfoDemo.http.PatientUserResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.jms.EmailProducer;
import com.stan.HospitalInfoDemo.security.PatientSecurityUtils;
import com.stan.HospitalInfoDemo.services.PatientUserService;

@Service
public class PatientUserServiceImpl implements PatientUserService {
	@Autowired
	PatientUserDao patientUserDao;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmailProducer emailProducer;
	@Autowired
	PatientUserProfileDao patientUserProfileDao;

	@Override
	public Response addPatientUser(PatientUser patientUser) {
		patientUser.setPassword(passwordEncoder.encode(patientUser.getPassword()));
		PatientInfo patientInfo = patientUser.getPatientInfo();
		List<PatientUserProfile> patientUserProfiles = patientUser.getPatientUserProfiles();
		List<PatientUserProfile> newPatientUserProfiles = new ArrayList<>();
		if(patientUserProfiles.isEmpty()) {
			newPatientUserProfiles.add(patientUserProfileDao.findByType("ROLE_GUEST"));
			
		}else{
			patientUserProfiles.forEach((patientUserProfile)->{
				newPatientUserProfiles.add(patientUserProfileDao.findByType(patientUserProfile.getType()));
			});
		}
		patientUser.setPatientUserProfiles(newPatientUserProfiles);
		patientInfo.setPatientUser(patientUser);
		return new PatientUserResponse(true,patientUserDao.save(patientUser));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("*************loadPatientUsername: " + username);
		PatientUser patientUser = patientUserDao.findByUsername(username);
		if(patientUser == null) {
			throw new UsernameNotFoundException("PatientUser: " + username + " was not found in the database");
		}
		return patientUser;
	}

	@Override
	public Response register(PatientUser patientUser) {
		return addPatientUser(patientUser);
	}

	@Override
	public Response changePassword(PatientUser patientUser, Authentication authentication) {
		if(patientUser.getUsername().equals(authentication.getName()) ||
				PatientSecurityUtils.isAdmin(authentication.getAuthorities())) {
			PatientUser patientLocal = patientUserDao.findByUsername(patientUser.getUsername());
			patientLocal.setPassword(passwordEncoder.encode(patientUser.getPassword()));
			patientUserDao.save(patientLocal);
		}else {
			return new PatientUserResponse(false,patientUser);
		}
		return new PatientUserResponse(true,patientUser);
		
	}

	@Override
	public Response deleteUser(int id) {
		if(patientUserDao.findById(id).get() != null) {
			patientUserDao.deleteById(id);
			return new Response(true,"delete patientUser Success!");
		}else {
			return new Response(false,"delete patientUser failed!");
		}
	}

}
