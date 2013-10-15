package com.vipro.dto;

import java.io.Serializable;

import com.vipro.data.Address;
import com.vipro.data.Customer;

public class ChangeAddressDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3424234262324546664L;
	private Customer customer = new Customer();
	private Address address = new Address();
	private boolean isCorrAddress = false;
	private String stateName = "";
	
	
	
	public ChangeAddressDTO(boolean isCorrAddress) {
		super();		
		this.isCorrAddress = isCorrAddress;
	}


	public ChangeAddressDTO() {
		super();
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public boolean isCorrAddress() {
		return isCorrAddress;
	}


	public void setCorrAddress(boolean isCorrAddress) {
		this.isCorrAddress = isCorrAddress;
	}


	public String getStateName() {
		if(address != null && address.getAddressId() != null){
			address.getState();
		}
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	
	
}
