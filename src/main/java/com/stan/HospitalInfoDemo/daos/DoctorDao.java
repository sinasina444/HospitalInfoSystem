package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.Doctor;

public interface DoctorDao extends JpaRepository<Doctor,Integer>{

}
