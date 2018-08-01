package com.stan.HospitalInfoDemo.services;

import com.stan.HospitalInfoDemo.beans.Pharmacy;
import com.stan.HospitalInfoDemo.http.Response;

public interface PharmacyService {
	Response addDrugInPharmacy(Pharmacy pharmacy);
}
