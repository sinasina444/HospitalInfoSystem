package com.stan.HospitalInfoDemo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="patientuser")
public class PatientUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PATIENTUSER_SEQ_GEN")
	@SequenceGenerator(name = "PATIENTUSER_SEQ_GEN", sequenceName = "PATIENTUSER_SEQ", allocationSize = 1)
	int id;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="password",nullable=false)
	private String password;
	@OneToOne(mappedBy="patientUser",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("patientUser")
	PatientInfo patientInfo;
	
	public PatientUser(){
		super();
	}
	public PatientUser(String username,String password, PatientInfo patientInfo){
		super();
		this.username = username;
		this.password = password;
		this.patientInfo = patientInfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PatientInfo getPatientInfo() {
		return patientInfo;
	}
	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}
	@Override
	public String toString() {
		return "PatientUser [id=" + id + ", username=" + username + ", password=" + password + ", patientInfo="
				+ patientInfo + "]";
	}
	
	
	
}
