package com.chapter06.direct.persistence.layer.example.entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;

@Entity
public class Vendor {

	// Primary key is the vendor's name
	// This assumes that the vendor's name is
	// unique in the database.
	@PrimaryKey
	private String vendorName;
	private String address;
	private String bizPhoneNumber;
	private String city;
	private String repName;
	private String repPhoneNumber;
	private String state;
	private String zipcode;
	private String businessPhoneNumber;
	
	
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getBusinessPhoneNumber() {
		return businessPhoneNumber;
	}
	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		this.businessPhoneNumber = businessPhoneNumber;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendor) {
		this.vendorName = vendor;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBizPhoneNumber() {
		return bizPhoneNumber;
	}
	public void setBizPhoneNumber(String bizPhoneNumber) {
		this.bizPhoneNumber = bizPhoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRepName() {
		return repName;
	}
	public void setRepName(String repName) {
		this.repName = repName;
	}
	public String getRepPhoneNumber() {
		return repPhoneNumber;
	}
	public void setRepPhoneNumber(String repPhoneNumber) {
		this.repPhoneNumber = repPhoneNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
	
}
