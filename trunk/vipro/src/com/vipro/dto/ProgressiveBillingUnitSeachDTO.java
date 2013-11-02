package com.vipro.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.Project;
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
	private List<BillingModelStageDTO> stageDtoList = new ArrayList<BillingModelStageDTO>();
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


	public List<BillingModelStageDTO> getStageDtoList() {
		return stageDtoList;
	}


	public void setStageDtoList(List<BillingModelStageDTO> stageDtoList) {
		this.stageDtoList = stageDtoList;
	}
	
}
