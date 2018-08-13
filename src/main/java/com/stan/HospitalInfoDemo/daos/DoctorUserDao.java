package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stan.HospitalInfoDemo.beans.DoctorUser;

public interface DoctorUserDao extends JpaRepository<DoctorUser,Integer>{
//	@Query("select d from doctorUser d where d.username = :username")
//	DoctorUser findByUsername(@Param("username") String username);
	DoctorUser findByUsername(String username);
}
