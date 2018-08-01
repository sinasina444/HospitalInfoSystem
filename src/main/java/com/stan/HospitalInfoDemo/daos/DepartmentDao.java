package com.stan.HospitalInfoDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stan.HospitalInfoDemo.beans.Department;

public interface DepartmentDao extends JpaRepository<Department,Integer>{

}
