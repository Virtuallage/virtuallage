package com.vipro.dto;

import java.io.Serializable;

import com.vipro.data.Account;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;

public class LoanCancellationDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3106304230169649126L;
	private ProjectInventory projectInvetory = new ProjectInventory();
	private Project project = new Project();
	private Customer customer = new Customer();
	private Account account = new Account();
	private String verifiedBy = "";
	
	
	public LoanCancellationDTO() {
		super();
	}
	public LoanCancellationDTO(ProjectInventory projectInvetory,
			Project project, Customer customer, Account account, String verifiedBy) {
		super();
		this.projectInvetory = projectInvetory;
		this.project = project;
		this.customer = customer;
		this.account = account;
		this.verifiedBy = verifiedBy;
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
				+ (verifiedBy != null ? "\n\n------------verifiedBy=" + verifiedBy.toString() + ", " : "")
				 + "]";
	}
	public String getVerifiedBy() {
		return verifiedBy;
	}
	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}
	
}
