package com.vipro.dto;

import java.io.Serializable;

import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;

public class PropertyUnitDetailsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3424234264365765724L;
	private ProjectInventory projectInvetory = new ProjectInventory();
	private Project project = new Project();
	private Customer customer = new Customer();
	private Account account = new Account();
	private Address address = new Address();
	
	
	public PropertyUnitDetailsDTO() {
		super();
	}
	public PropertyUnitDetailsDTO(ProjectInventory projectInvetory,
			Project project, Customer customer, Account account, Address adrs) {
		super();
		this.projectInvetory = projectInvetory;
		this.project = project;
		this.customer = customer;
		this.account = account;
		this.address = adrs;
	}
	public ProjectInventory getProjectInvetory() {
		return projectInvetory;
	}
	public void setProjectInvetory(ProjectInventory projectInvetory) {
		this.projectInvetory = projectInvetory;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "PropertyUnitDetailsDTO ["
				
				+ (project != null ? "\n\n------------project=" + project.getProjectName() + ", " : "")
				+ (account != null ? "\n\n------------account=" + account.getAccountId(): "")
				+ (customer != null ? "\n\n------------customer=" + customer.getFullName() + ", " : "")
				+ (projectInvetory != null ? "\n\n------------projectInvetory="
						+ projectInvetory + ", " : "")
				+ (address != null ? "\n\n------------Address=" + address.toString() + ", " : "")
				 + "]";
	}
	public Address getAddress() {
		if(address == null){
			address = new Address();
		}
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
