package com.stan.HospitalInfoDemo.beans;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="outpatient_emr")
public class OutPatient_EMR {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "OUTPATIENT_EMR_SEQ_GEN")
	@SequenceGenerator(name = "OUTPATIENT_EMR_SEQ_GEN", sequenceName = "OUTPATIENT_EMR_SEQ", allocationSize = 1)
	int id;
	@JoinColumn(name="pid",referencedColumnName="id")
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	private PatientInfo patientInfo;
	@JoinColumn(name="doctor_id",referencedColumnName="id")
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JsonIgnoreProperties("doctorInfo")
	private Doctor doctor;
	@JoinColumn(name="department_id",referencedColumnName="id")
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JsonIgnoreProperties("doctors")
	private Department department;
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="drugorder_id")
	@JsonIgnoreProperties("outPatient_EMR")
	private DrugOrder drugOrder;
	@Column
	private String description;
	@Column
	private String diagnosis;
	@Column(name="testdate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date testDate;
	
	public OutPatient_EMR(){
		super();
	}

	public OutPatient_EMR(PatientInfo patientInfo, Doctor doctor, Department department, DrugOrder drugOrder,
			String description, String diagnosis, Date testDate) {
		super();
		this.patientInfo = patientInfo;
		this.doctor = doctor;
		this.department = department;
		this.drugOrder = drugOrder;
		this.description = description;
		this.diagnosis = diagnosis;
		this.testDate = testDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PatientInfo getPatientInfo() {
		return patientInfo;
	}

	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public DrugOrder getDrugOrder() {
		return drugOrder;
	}

	public void setDrugOrder(DrugOrder drugOrder) {
		this.drugOrder = drugOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	@Override
	public String toString() {
		return "OutPatient_EMR [id=" + id + ", patientInfo=" + patientInfo + ", doctor=" + doctor + ", department="
				+ department + ", drugOrder=" + drugOrder + ", description=" + description + ", diagnosis=" + diagnosis
				+ ", testDate=" + testDate + "]";
	}
	
	
}
