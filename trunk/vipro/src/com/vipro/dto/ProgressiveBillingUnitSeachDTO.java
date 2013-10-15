package com.vipro.dto;

import java.io.Serializable;

import com.vipro.data.Address;
import com.vipro.data.Account;
import com.vipro.data.Customer;
import com.vipro.data.ProgressiveBilling;
import com.vipro.data.*;
import com.vipro.data.ProjectInventory;

public class ProgressiveBillingUnitSeachDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3424234264365765724L;
	private ProjectInventory projectInvetory = new ProjectInventory();
	private Project project = new Project();
	private Customer customer = new Customer();
	private Account account = new Account();
	private Address address = new Address();
//	private BillingModel billingModel = new BillingModel();
	private ProgressiveBilling progressiveBilling = new ProgressiveBilling();
	private String stageNo = "0";
	private String statusDesc = "";
	
	
	public ProgressiveBillingUnitSeachDTO() {
		super();
	}
	
	
	public ProgressiveBillingUnitSeachDTO(ProjectInventory projectInvetory,
			Project project, Customer customer, Account account) {
		super();
		this.projectInvetory = projectInvetory;
		this.project = project;
		this.customer = customer;
		this.account = account;
	}

	public ProgressiveBillingUnitSeachDTO(ProjectInventory projectInvetory,
			Project project, Customer customer, Account account, String stage, String statusDesc) {
		super();
		this.projectInvetory = projectInvetory;
		this.project = project;
		this.customer = customer;
		this.account = account;
		this.stageNo = stage;
		this.statusDesc = statusDesc;
	}

	public ProgressiveBillingUnitSeachDTO(ProjectInventory projectInvetory,
			Project project, Customer customer, Account account, ProgressiveBilling progressiveBilling) {
		super();
		this.projectInvetory = projectInvetory;
		this.project = project;
		this.customer = customer;
		this.account = account;
		this.progressiveBilling = progressiveBilling;
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
		return "ProgressiveBillingUnitSearchDTO ["
				
				+ (project != null ? "\n\n------------project=" + project.getProjectName() + ", " : "")
				+ (account != null ? "\n\n------------account=" + account.getAccountId(): "")
				+ (customer != null ? "\n\n------------customer=" + customer.getFullName() + ", " : "")
				+ (projectInvetory != null ? "\n\n------------projectInvetory="
						+ projectInvetory + ", " : "")
				 + "]";
	}
	public ProgressiveBilling getProgressiveBilling() {
		return progressiveBilling;
	}
	public void setProgressiveBilling(ProgressiveBilling progressiveBilling) {
		this.progressiveBilling = progressiveBilling;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


	public String getStageNo() {
		return stageNo;
	}


	public void setStageNo(String stageNo) {
		this.stageNo = stageNo;
	}


	public String getStatusDesc() {
		return statusDesc;
	}


	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	
}
