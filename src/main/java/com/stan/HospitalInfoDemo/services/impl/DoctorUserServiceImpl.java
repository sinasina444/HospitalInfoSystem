package com.stan.HospitalInfoDemo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.Doctor;
import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.beans.DoctorUserProfile;
import com.stan.HospitalInfoDemo.daos.DoctorUserDao;
import com.stan.HospitalInfoDemo.http.DoctorUserResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.jms.EmailProducer;
import com.stan.HospitalInfoDemo.security.DoctorSecurityUtils;
import com.stan.HospitalInfoDemo.services.DoctorUserService;

@Service
public class DoctorUserServiceImpl implements DoctorUserService{
	@Autowired
	DoctorUserDao doctorUserDao;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmailProducer emailProducer;

	@Override
	public Response addDoctorUser(DoctorUser doctorUser) {
		doctorUser.setPassword(passwordEncoder.encode(doctorUser.getPassword()));
		DoctorInfo doctorInfo = doctorUser.getDoctorInfo();
		Doctor doctor = doctorInfo.getDoctor();
		List<DoctorUserProfile> doctorUserProfiles = doctorUser.getDoctorUserProfiles();
		//doctorUserProfiles.forEach(action);
		doctorUser.setDoctorUserProfiles(doctorUserProfiles);
		doctorInfo.setDoctorUser(doctorUser);
		doctor.setDoctorInfo(doctorInfo);
		//doctorUser.setDoctorInfo(doctorInfo);
		return new DoctorUserResponse(true,doctorUserDao.save(doctorUser));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DoctorUser doctorUser = doctorUserDao.findByUsername(username);
		if(doctorUser == null) {
			throw new UsernameNotFoundException("DoctorUser: " + username + " was not found in the database");
		}
		return doctorUser;
	}

	@Override
	public Response register(DoctorUser doctorUser) {
		return addDoctorUser(doctorUser);
	}

	@Override
	public Response changePassword(DoctorUser doctorUser, Authentication authentication) {
		if(doctorUser.getUsername().equals(authentication.getName()) || 
				DoctorSecurityUtils.isAdmin(authentication.getAuthorities())) {
			DoctorUser doctorLocal = doctorUserDao.findByUsername(doctorUser.getUsername());
			doctorLocal.setPassword(passwordEncoder.encode(doctorUser.getPassword()));
			doctorUserDao.save(doctorLocal);
		}else {
			//TODO: Not authorize to update password if not current loggedin user or admin.
			return new DoctorUserResponse(false,doctorUser);
		}
		return new DoctorUserResponse(true,doctorUser);
	}

	@Override
	public Response deleteUser(int id) {
		if(doctorUserDao.findById(id).get() != null){
			doctorUserDao.deleteById(id);
			return new Response(true,"delete complete!");
		}else {
			return new Response(false,"Doctor doesn't exist! Delete fail!");
		}
	}
	
}
