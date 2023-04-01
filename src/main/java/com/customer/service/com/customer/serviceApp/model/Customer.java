package com.customer.service.com.customer.serviceApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//@AllArgsConstructor
@Entity
//@Table(name="CUSTOMERS")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="COSTOMER_ID")
	private String custid;
	@Column(name="FIRST_NAME")
	private String fname;
	@Column(name="LAST_NAME")
	private String lname;
	private String email;
	private String mobile;
	private String status;
	private String category;
	
	public Customer() {
		
	}

	public Customer(String custid, String fname, String lname, String email,
					String mobile, String status, String category) {
		this.custid = custid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.category = category;
	}
	@JsonCreator
	public Customer(@JsonProperty("id") Integer id, @JsonProperty("custid") String custid, @JsonProperty("fname") String fname, @JsonProperty("lname") String lname, @JsonProperty("email") String email, @JsonProperty("mobile") String mobile, @JsonProperty("status") String status,
					@JsonProperty("category") String category) {
		this.id = id;
		this.custid = custid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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
