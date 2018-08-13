package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.PatientUser;

public interface PatientUserDao extends JpaRepository<PatientUser,Integer>{
	PatientUser findByUsername(String username);
}
