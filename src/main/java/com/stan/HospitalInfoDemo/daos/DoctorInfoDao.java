package com.stan.HospitalInfoDemo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.beans.DoctorUser;

public interface DoctorInfoDao extends JpaRepository<DoctorInfo,Integer>{
//	@Query("select di from DoctorInfo di where di.loginId = :loginId")
//	DoctorInfo findByLoginId(@Param("loginId") int id);
	DoctorInfo findByDoctorUser(DoctorUser doctorUser);
	List<DoctorInfo> findByAddress(String address);
}
