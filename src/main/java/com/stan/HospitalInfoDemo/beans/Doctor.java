package com.stan.HospitalInfoDemo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "DOCTOR_SEQ_GEN")
	@SequenceGenerator(name = "DOCTOR_SEQ_GEN", sequenceName = "DOCTOR_SEQ", allocationSize = 1)
	int id;
	@JoinColumn(name="doctorinfo_id")
	@OneToOne
	DoctorInfo doctorInfo;
	@JoinColumn(name="department_id")
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JsonIgnoreProperties("doctors")
	private Department department;
	@Column
	private String position;
	@Column
	private double salary;
	
	public Doctor() {
		super();
	};
	
	public Doctor(DoctorInfo doctorInfo, Department department, String position, double salary) {
		super();
		this.doctorInfo = doctorInfo;
		this.department = department;
		this.position = position;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DoctorInfo getDoctorInfo() {
		return doctorInfo;
	}
	public void setDoctorInfo(DoctorInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorInfo=" + doctorInfo + ", department=" + department + ", position="
				+ position + ", salary=" + salary + "]";
	}
	
	
}
