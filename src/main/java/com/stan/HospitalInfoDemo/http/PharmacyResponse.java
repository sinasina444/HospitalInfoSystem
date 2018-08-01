package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.Pharmacy;

public class PharmacyResponse extends Response{
	private Pharmacy pharmacy;
	public PharmacyResponse(boolean success,Pharmacy pharmacy){
		super(success);
		this.pharmacy = pharmacy;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	
	
}
