package com.stan.HospitalInfoDemo.services;

//import org.springframework.security.core.Authentication;

import com.stan.HospitalInfoDemo.beans.DrugOrder;
import com.stan.HospitalInfoDemo.http.Response;

public interface DrugOrderService {
	Response addDrugOrder(DrugOrder drugOrder);
	//Response addDrugOrder(DrugOrder drugOrder,Authentication authentication);

}
