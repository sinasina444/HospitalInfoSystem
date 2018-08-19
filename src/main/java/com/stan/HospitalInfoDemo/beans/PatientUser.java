package com.stan.HospitalInfoDemo.beans;

import java.util.ArrayList;
import java.util.Collection;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="patientuser")
public class PatientUser implements UserDetails{
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
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade=CascadeType.DETACH)
	@JoinTable(name = "patientuser_and_profile", joinColumns = {
			@JoinColumn(name = "patient_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "patient_profile_id", referencedColumnName = "id") })
	private List<PatientUserProfile> patientUserProfiles = new ArrayList<PatientUserProfile>();
	
	public PatientUser(){
		super();
	}
	public PatientUser(String username) {
		super();
		this.username = username;
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
	
	
	public List<PatientUserProfile> getPatientUserProfiles() {
		return patientUserProfiles;
	}
	public void setPatientUserProfiles(List<PatientUserProfile> patientUserProfiles) {
		this.patientUserProfiles = patientUserProfiles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return patientUserProfiles;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
