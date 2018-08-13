package com.stan.HospitalInfoDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.HospitalInfoDemo.beans.DrugOrder;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.DrugOrderService;

@RestController
@RequestMapping("/stanDomain/drugOrders")
public class DrugOrderController {
	@Autowired
	DrugOrderService drugOrderService;
	
	@PostMapping
	public Response addDrugOrder(@RequestBody DrugOrder drugOrder) {
		return drugOrderService.addDrugOrder(drugOrder);
	}
}
