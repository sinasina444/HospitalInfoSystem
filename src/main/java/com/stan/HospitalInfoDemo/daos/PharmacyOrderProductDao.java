package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.PharmacyOrderProduct;

public interface PharmacyOrderProductDao extends JpaRepository<PharmacyOrderProduct,Integer>{

}
