package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.DrugOrder;

public interface DrugOrderDao extends JpaRepository<DrugOrder,Integer>{

}
