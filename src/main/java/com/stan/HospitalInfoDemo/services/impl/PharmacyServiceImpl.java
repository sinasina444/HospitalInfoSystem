package com.stan.HospitalInfoDemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.Pharmacy;
import com.stan.HospitalInfoDemo.daos.PharmacyDao;
import com.stan.HospitalInfoDemo.http.PharmacyResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService{
	@Autowired
	PharmacyDao pharmacyDao;
	
	@Override
	public Response addDrugInPharmacy(Pharmacy pharmacy) {
		return new PharmacyResponse(true,pharmacyDao.save(pharmacy));
	}

}
