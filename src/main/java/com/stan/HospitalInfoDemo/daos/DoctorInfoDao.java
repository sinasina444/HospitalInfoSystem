package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;

public interface DoctorInfoDao extends JpaRepository<DoctorInfo,Integer>{
}
