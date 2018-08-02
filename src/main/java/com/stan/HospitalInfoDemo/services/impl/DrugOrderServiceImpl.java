package com.stan.HospitalInfoDemo.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stan.HospitalInfoDemo.beans.DrugOrder;
import com.stan.HospitalInfoDemo.beans.PatientInfo;
import com.stan.HospitalInfoDemo.beans.Pharmacy;
import com.stan.HospitalInfoDemo.beans.PharmacyOrderProduct;
import com.stan.HospitalInfoDemo.daos.DrugOrderDao;
import com.stan.HospitalInfoDemo.daos.PatientInfoDao;
import com.stan.HospitalInfoDemo.daos.PharmacyDao;
import com.stan.HospitalInfoDemo.daos.PharmacyOrderProductDao;
import com.stan.HospitalInfoDemo.http.DrugOrderResponse;
import com.stan.HospitalInfoDemo.http.Response;
import com.stan.HospitalInfoDemo.services.DrugOrderService;

@Service
public class DrugOrderServiceImpl implements DrugOrderService{
	@Autowired
	DrugOrderDao drugOrderDao;
	@Autowired
	PharmacyOrderProductDao pharmacyOrderProductDao;
	@Autowired
	PharmacyDao pharmacyDao;
	@Autowired
	PatientInfoDao patientInfoDao;

	@Override
	public Response addDrugOrder(DrugOrder drugOrder) {
		//save drugOrder without Outpatient_EMR info
		if(!patientInfoDao.findById(drugOrder.getPatientInfo().getId()).isPresent()){
			return new Response(false,"Patient Information doesn't exist! Please check pid!");
		}else {
			PatientInfo patientInfo = patientInfoDao.findById(drugOrder.getPatientInfo().getId()).get();
			drugOrder.setPatientInfo(patientInfo);
		}
		try{
			//Date current_date = new java.sql.Date(new java.util.Date().getTime());
			Date currentDate = new Date();
			drugOrder.setOrderDate(currentDate);
			
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			simpleDateFormat.format(current_date.getTime());
			//drugOrder.setOrder_date(simpleDateFormat.format(current_date.getTime()));		
			List<PharmacyOrderProduct> pharmacyOrderProducts = drugOrder.getPharmacyOrderProduct();
			pharmacyOrderProducts.forEach((pharmacyOrderProduct)->{
				//Pharmacy pharmacy = pharmacyDao.findById(pharmacyOrderProduct.getPharmacy().getId()).get();
				int tempid = pharmacyOrderProduct.getPharmacy().getId();
				Pharmacy pharmacy =pharmacyDao.findById(tempid).get();
				pharmacyOrderProduct.setPharmacy(pharmacy);
				pharmacyOrderProduct.setDrugOrder(drugOrder);
				//pharmacyOrderProductDao.save(pharmacyOrderProduct);
			});
			//drugOrder.setPharmacyOrderProduct(null);
			drugOrderDao.save(drugOrder);
			
			pharmacyOrderProducts.forEach((pharmacyOrderProduct)->{
				pharmacyOrderProductDao.save(pharmacyOrderProduct);
			});
			
			

		}catch(Exception e) {
			e.printStackTrace();
			return new DrugOrderResponse(false,drugOrder);
		}
		return new DrugOrderResponse(true,drugOrder);
	}

}
