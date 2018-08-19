package com.stan.HospitalInfoDemo.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "DEPARTMENT_SEQ_GEN")
	@SequenceGenerator(name = "DEPARTMENT_SEQ_GEN", sequenceName = "DEPARTMENT_SEQ", allocationSize = 1)
	int id;
	@Column(name="departmentname")
	private String departmentName;
	@Column(name="departmentinfo")
	private String departmentInfo;
	@OneToMany(mappedBy="department",fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
	private List<Doctor> doctors;
	
	public Department(){
		super();
	}
	
	public Department(int id) {
		super();
		this.id = id;
	}
	public Department(String departmentName, String departmentInfo) {
		super();
		this.departmentName = departmentName;
		this.departmentInfo = departmentInfo;
	}
	
	public Department(String departmentName, String departmentInfo, List<Doctor> doctors) {
		super();
		this.departmentName = departmentName;
		this.departmentInfo = departmentInfo;
		this.doctors = doctors;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentInfo() {
		return departmentInfo;
	}

	public void setDepartmentInfo(String departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", departmentInfo=" + departmentInfo
				+ ", doctors=" + doctors + "]";
	}
	
}
