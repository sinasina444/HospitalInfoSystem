package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.Pharmacy;
import com.stan.HospitalInfoDemo.daos.PharmacyDao;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.PharmacyService;

@RestController()
@RequestMapping("/stanDomain/pharmacy")
public class PharmacyController {
	@Autowired
	PharmacyDao pharmacyDao;
	@Autowired
	PharmacyService pharmacyService;
	
	@PostMapping
	public Response addDrugInPhamacy(@RequestBody Pharmacy pharmacy){
		return pharmacyService.addDrugInPharmacy(pharmacy);
	}
}
