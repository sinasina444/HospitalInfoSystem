package com.stan.HospitalInfoDemo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="doctoruser")
public class DoctorUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "DOCTORUSER_SEQ_GEN")
	@SequenceGenerator(name = "DOCTORUSER_SEQ_GEN", sequenceName = "DOCTORUSER_SEQ", allocationSize = 1)
	int id;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="password",nullable=false)
	private String password;
	@OneToOne(mappedBy="doctorUser",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("doctorUser")
	DoctorInfo doctorInfo;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "doctoruser_and_profile", joinColumns = {
			@JoinColumn(name = "doctor_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "doctor_profile_id", referencedColumnName = "id") })
	private List<DoctorUserProfile> doctorUserProfiles = new ArrayList<DoctorUserProfile>();
	
	public DoctorUser() {
		super();
	}

	public DoctorUser(String username,String password, DoctorInfo doctorInfo){
		super();
		this.username = username;
		this.password = password;
		this.doctorInfo = doctorInfo;
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
	
	public DoctorInfo getDoctorInfo() {
		return doctorInfo;
	}
	
	public void setDoctorInfo(DoctorInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
	}
	
	
	

	public List<DoctorUserProfile> getDoctorUserProfiles() {
		return doctorUserProfiles;
	}

	public void setDoctorUserProfiles(List<DoctorUserProfile> doctorUserProfiles) {
		this.doctorUserProfiles = doctorUserProfiles;
	}

	@Override
	public String toString() {
		return "DoctorUser [id=" + id + ", username=" + username + ", password=" + password + ", doctorInfo="
				+ doctorInfo + ", doctorUserProfiles=" + doctorUserProfiles + "]";
	}

	

	
	
	
}
