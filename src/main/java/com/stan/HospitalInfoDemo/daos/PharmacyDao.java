package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.Pharmacy;

public interface PharmacyDao extends JpaRepository<Pharmacy, Integer> {
	
}
