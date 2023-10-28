package com.shop.storeApp.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerName;
	private String phoneNum;
	private String location;
	/*
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "customer")
	private List<Products> products = new ArrayList<>();

	/*
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
	@Column(nullable = false)
	private Date purchaseDate;
    */

	public Customers() {
		super();
	}

	public Customers(int customerId, String customerName, String phoneNum, /*Date purchaseDate ,*/String location) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNum = phoneNum;
		this.location = location;
		//this.purchaseDate = purchaseDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/*
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
    */


}
