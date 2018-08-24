package com.stan.HospitalInfoDemo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="doctorinfo")
public class DoctorInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "DOCTORINFO_SEQ_GEN")
	@SequenceGenerator(name = "DOCTORINFO_SEQ_GEN", sequenceName = "DOCTORINFO_SEQ", allocationSize = 1)
	int id;
	@JoinColumn(name="login_id")
	@OneToOne(cascade = CascadeType.DETACH)
	@JsonIgnoreProperties("doctorInfo")
	DoctorUser doctorUser;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column
	int sex;
	@Column
	int cellphone;
	@Column
	String address;
//	@OneToOne(mappedBy="doctorInfo",cascade=CascadeType.ALL)
//	@JsonIgnoreProperties("doctorInfo")
//	Doctor doctor;

	public DoctorInfo(){
		super();
	}

	public DoctorInfo(String firstName, String lastName, int sex, int cellphone, String address, Doctor doctor) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.cellphone = cellphone;
		this.address = address;
		//this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DoctorUser getDoctorUser() {
		return doctorUser;
	}

	public void setDoctorUser(DoctorUser doctorUser) {
		this.doctorUser = doctorUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getCellphone() {
		return cellphone;
	}

	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}
//	
//	public Doctor getDoctor() {
//		return doctor;
//	}



	@Override
	public String toString() {
		return "DoctorInfo [id=" + id + ", doctorUser=" + doctorUser + ", firstName=" + firstName + ", lastName="
				+ lastName + ", sex=" + sex + ", cellphone=" + cellphone + ", address=" + address 
				+ "]";
	}
	
}
