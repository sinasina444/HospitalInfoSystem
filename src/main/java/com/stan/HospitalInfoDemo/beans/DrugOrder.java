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
	@Column(name="orderdate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date orderDate;
	
	@OneToMany(mappedBy = "drugOrder", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("drugOrder")
	private List<PharmacyOrderProduct> pharmacyOrderProduct;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name = "pid")
	@JsonIgnoreProperties("drugOrder")
	PatientInfo patientInfo;
//	@OneToOne(mappedBy="drugOrder",fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
//	private OutPatient_EMR outPatient_EMR;
	
	public DrugOrder() {
		super(); 
	}

	public DrugOrder(Date orderDate, List<PharmacyOrderProduct> pharmacyOrderProduct) {
		super();
		this.orderDate = orderDate;
		this.pharmacyOrderProduct = pharmacyOrderProduct;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
		return "DrugOrder [id=" + id + ", orderDate=" + orderDate + ", pharmacyOrderProduct=" + pharmacyOrderProduct
				+ ", patientInfo=" + patientInfo + "]";
	}


	
	
}
