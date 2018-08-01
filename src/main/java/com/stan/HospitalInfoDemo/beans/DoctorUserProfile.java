package com.stan.HospitalInfoDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="doctoruser_profile")
public class DoctorUserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "DOCTORUSER_PROFILE_SEQ_GEN")
	@SequenceGenerator(name = "DOCTORUSER_PROFILE_SEQ_GEN", sequenceName = "DOCTORUSER_PROFILE_SEQ", allocationSize = 1)
	private int id;
	@Column
	private String type;
	
	public DoctorUserProfile(){
		super();
	}
	
	public DoctorUserProfile(int id) {
		super();
		this.id = id;
		this.type = "ROLE_GUEST";
	}
	
	public DoctorUserProfile(int id,String type) {
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
		return "DoctorUserProfile [id=" + id + ", type=" + type + "]";
	}
	
	
}
