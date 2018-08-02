package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.PharmacyOrderProduct;

public class PharmacyOrderProductResponse extends Response{
	private PharmacyOrderProduct pharmacyOrderProduct;
	public PharmacyOrderProductResponse(boolean success,PharmacyOrderProduct pharmacyOrderProduct){
		super(success);
		this.pharmacyOrderProduct = pharmacyOrderProduct;
	}
	public PharmacyOrderProduct getPharmacyOrderProduct() {
		return pharmacyOrderProduct;
	}
	public void setPharmacyOrderProduct(PharmacyOrderProduct pharmacyOrderProduct) {
		this.pharmacyOrderProduct = pharmacyOrderProduct;
	}
	
	
}
