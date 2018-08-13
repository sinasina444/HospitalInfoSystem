package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.DoctorUserProfile;

public interface DoctorUserProfileDao extends JpaRepository<DoctorUserProfile,Integer>{
	DoctorUserProfile findByType(String type);
}
