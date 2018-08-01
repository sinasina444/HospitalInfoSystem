package com.stan.HospitalInfoDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pharmacy")
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PHARMACY_SEQ_GEN")
	@SequenceGenerator(name = "PHARMACY_SEQ_GEN", sequenceName = "PHARMACY_SEQ", allocationSize = 1)
	int id;
	@Column
	private double price;
	@Column(name="drugname")
	private String drugName;
	@Column
	private int stock;
	@Column
	private String description;
	
	public Pharmacy(){
		super();
	}
	public Pharmacy( String drugName, double price,int stock, String description) {
		super();
		this.price = price;
		this.drugName = drugName;
		this.stock = stock;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Pharmacy [id=" + id + ", price=" + price + ", drugName=" + drugName + ", stock=" + stock
				+ ", description=" + description + "]";
	}
	
	
}
