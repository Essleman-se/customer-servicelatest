package com.customer.service.com.customer.serviceApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//@AllArgsConstructor
public class Customer {
	
	private String custId;
	private String fName;
	private String lName;
	private String email;
	private String mobile;
	private String status;
	private String category;
	
	
	
	public Customer(String custId, String fName, String lName, String email, String mobile, String status,
			String category) {
		super();
		this.custId = custId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.category = category;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
	

}
