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
	private Doctor doctor;
	@JoinColumn(name="department_id",referencedColumnName="id")
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	private Department department;
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="drugorder_id")
	private DrugOrder drugOrder;
	@Column
	private String description;
	@Column
	private String diagnosis;
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date testDate;
}
