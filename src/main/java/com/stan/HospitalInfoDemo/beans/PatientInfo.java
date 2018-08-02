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
@Table(name="patientinfo")
public class PatientInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PATIENTINFO_SEQ_GEN")
	@SequenceGenerator(name = "PATIENTINFO_SEQ_GEN", sequenceName = "PATIENTINFO_SEQ", allocationSize = 1)
	int id;
	@JoinColumn(name="login_id")
	@OneToOne
	PatientUser patientUser;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column
	int age;
	@Column
	int sex;
	@Column
	int cellphone;
	@Column
	String id_card;
	@Column
	String address;
	
	public PatientInfo(){
		super();
	}
	
	public PatientInfo(PatientUser patientUser, String firstName, String lastName, int age, int sex, int cellphone,
			String id_card, String address) {
		super();
		this.patientUser = patientUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		this.cellphone = cellphone;
		this.id_card = id_card;
		this.address = address;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PatientUser getPatientUser() {
		return patientUser;
	}
	public void setPatientUser(PatientUser patientUser) {
		this.patientUser = patientUser;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PatientInfo [id=" + id + ", patientUser=" + patientUser + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", sex=" + sex + ", cellphone=" + cellphone + ", id_card=" + id_card
				+ ", address=" + address + "]";
	}
	
	
}
