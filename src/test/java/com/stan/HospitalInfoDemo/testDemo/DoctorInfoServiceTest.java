package com.stan.HospitalInfoDemo.testDemo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stan.HospitalInfoDemo.beans.DoctorInfo;
import com.stan.HospitalInfoDemo.daos.DoctorInfoDao;
import com.stan.HospitalInfoDemo.services.DoctorInfoService;
import com.stan.HospitalInfoDemo.services.impl.DoctorInfoServiceImpl;

import junit.framework.Assert;

public class DoctorInfoServiceTest {
	//@Autowired
	@Mock
	DoctorInfoDao doctorInfoDao;
	@InjectMocks
	DoctorInfoServiceImpl doctorInfoService;

	@Before
	public void createMock() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testUpdateDoctorInfo() {
		System.out.println(doctorInfoDao == null);
		if(doctorInfoDao == null) {
			return;
		}
		System.out.println(doctorInfoDao.findById(164));
		DoctorInfo doctorInfo = doctorInfoDao.findById(164).get();
		//Doctor(DoctorInfo doctorInfo, Department department, String position, double salary) {
		String strAddress = new String("new Address Avenue");
		doctorInfo.setAddress(strAddress);
		doctorInfoService.updateDoctorInfo(doctorInfo);
		Assert.assertEquals(strAddress, doctorInfoDao.findById(164).get());
	}

}
