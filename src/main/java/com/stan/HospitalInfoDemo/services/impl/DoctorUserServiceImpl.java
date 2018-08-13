package com.stan.HospitalInfoDemo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.beans.DoctorUserProfile;
import com.stan.HospitalInfoDemo.daos.DoctorUserDao;
import com.stan.HospitalInfoDemo.daos.DoctorUserProfileDao;
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
	@Autowired
	DoctorUserProfileDao doctorUserProfileDao;


	@Override
	public Response addDoctorUser(DoctorUser doctorUser) {
		doctorUser.setPassword(passwordEncoder.encode(doctorUser.getPassword()));
		DoctorInfo doctorInfo = doctorUser.getDoctorInfo();
		List<DoctorUserProfile> doctorUserProfiles = doctorUser.getDoctorUserProfiles();
		List<DoctorUserProfile> newDoctorUserProfiles = new ArrayList<>();
		if(doctorUserProfiles.isEmpty()) {
			newDoctorUserProfiles.add(doctorUserProfileDao.findByType("ROLE_GUEST"));
		}else {
			doctorUserProfiles.forEach((doctorUserProfile)->{
				newDoctorUserProfiles.add(doctorUserProfileDao.findByType(doctorUserProfile.getType()));
			});
		}
		//doctorUserProfiles.forEach(action);
		doctorUser.setDoctorUserProfiles(newDoctorUserProfiles);
		doctorInfo.setDoctorUser(doctorUser);
		return new DoctorUserResponse(true,doctorUserDao.save(doctorUser));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("*************loadUsername: " + username);
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
