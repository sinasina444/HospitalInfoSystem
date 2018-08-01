package com.stan.HospitalInfoDemo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="pharmacyorderproduct")
public class PharmacyOrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PHARMACYORDERPRODUCT_SEQ_GEN")
	@SequenceGenerator(name = "PHARMACYORDERPRODUCT_SEQ_GEN", sequenceName = "PHARMACYORDERPRODUCT_SEQ", allocationSize = 1)
	private int id;
	@Column
	private int qty;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name = "drugorder_id")
	@JsonIgnoreProperties("pharmacyOrderProduct")
	private DrugOrder drugOrder;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name = "drug_id")
	@JsonIgnoreProperties("pharmacyOrderProduct")
	private Pharmacy pharmacy;
	
	public PharmacyOrderProduct(){
		super();
	}

	public PharmacyOrderProduct(int qty, Pharmacy pharmacy) {
		super();
		this.qty = qty;
		this.pharmacy = pharmacy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public DrugOrder getDrugOrder() {
		return drugOrder;
	}

	public void setDrugOrder(DrugOrder drugOrder) {
		this.drugOrder = drugOrder;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	@Override
	public String toString() {
		return "PharmacyOrderProduct [id=" + id + ", qty=" + qty + ", drugOrder=" + drugOrder + ", pharmacy=" + pharmacy
				+ "]";
	}
	
	
}
