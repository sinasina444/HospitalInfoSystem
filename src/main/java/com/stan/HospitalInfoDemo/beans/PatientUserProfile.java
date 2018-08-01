package com.stan.HospitalInfoDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="patientuser_profile")
public class PatientUserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PATIENTUSER_PROFILE_SEQ_GEN")
	@SequenceGenerator(name = "PATIENTUSER_PROFILE_SEQ_GEN", sequenceName = "PATIENTUSER_PROFILE_SEQ", allocationSize = 1)
	private int id;
	@Column
	private String type;
	
	public PatientUserProfile(){
		super();
	}
	public PatientUserProfile(int id) {
		super();
		this.id = id;
	}
	public PatientUserProfile(int id,String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PatientUserProfile [id=" + id + ", type=" + type + "]";
	}
	
	
	
}
