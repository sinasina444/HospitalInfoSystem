package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.Doctor;
import com.stan.HospitalInfoDemo.beans.DoctorInfo;

public interface DoctorDao extends JpaRepository<Doctor,Integer>{
	Doctor findByDoctorInfo(DoctorInfo doctorInfo);
}
