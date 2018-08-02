package com.stan.HospitalInfoDemo.http;

import com.stan.HospitalInfoDemo.beans.DrugOrder;

public class DrugOrderResponse extends Response{
	private DrugOrder drugOrder;
	public DrugOrderResponse(boolean success,DrugOrder drugOrder) {
		super(success);
		this.drugOrder = drugOrder;
	}
	public DrugOrder getDrugOrder() {
		return drugOrder;
	}
	public void setDrugOrder(DrugOrder drugOrder) {
		this.drugOrder = drugOrder;
	}
	
	
}
