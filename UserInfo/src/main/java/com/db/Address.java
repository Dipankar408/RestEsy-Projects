package com.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	private long pincode;
	private String city;
	private String district;
	private String state;
	
//	private Customer cst;

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

//	public Customer getCst() {
//		return cst;
//	}
//
//	public void setCst(Customer cst) {
//		this.cst = cst;
//	}
	
	
}
