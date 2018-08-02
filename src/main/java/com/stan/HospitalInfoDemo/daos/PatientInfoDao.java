package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.PatientInfo;

public interface PatientInfoDao extends JpaRepository<PatientInfo,Integer>{

}
