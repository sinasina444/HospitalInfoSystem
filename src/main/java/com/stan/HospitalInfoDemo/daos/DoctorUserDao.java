package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.DoctorUser;

public interface DoctorUserDao extends JpaRepository<DoctorUser,Integer>{
	DoctorUser findByUsername(String username);
}
