package com.stan.HospitalInfoDemo.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="drugorder")
public class DrugOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "DRUGORDER_SEQ_GEN")
	@SequenceGenerator(name = "DRUGORDER_SEQ_GEN", sequenceName = "DRUGORDER_SEQ", allocationSize = 1)
	private int id;
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date order_date;
	
	@OneToMany(mappedBy = "drugOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PharmacyOrderProduct> pharmacyOrderProduct;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name = "pid")
	@JsonIgnoreProperties("drugOrder")
	PatientInfo patientInfo;
	@OneToOne(mappedBy="drugOrder",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private OutPatient_EMR outPatient_EMR;
	
	public DrugOrder() {
		super();
	}
	public DrugOrder(Date order_date, List<PharmacyOrderProduct> pharmacyOrderProduct) {
		super();
		this.order_date = order_date;
		this.pharmacyOrderProduct = pharmacyOrderProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public List<PharmacyOrderProduct> getPharmacyOrderProduct() {
		return pharmacyOrderProduct;
	}

	public void setPharmacyOrderProduct(List<PharmacyOrderProduct> pharmacyOrderProduct) {
		this.pharmacyOrderProduct = pharmacyOrderProduct;
	}

	public PatientInfo getPatientInfo() {
		return patientInfo;
	}

	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}

	@Override
	public String toString() {
		return "DrugOrder [id=" + id + ", order_date=" + order_date + ", pharmacyOrderProduct=" + pharmacyOrderProduct
				+ ", patientInfo=" + patientInfo + "]";
	}
	
	
}
