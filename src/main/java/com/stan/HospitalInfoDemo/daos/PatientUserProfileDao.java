package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.PatientUserProfile;

public interface PatientUserProfileDao extends JpaRepository<PatientUserProfile,Integer>{

}
