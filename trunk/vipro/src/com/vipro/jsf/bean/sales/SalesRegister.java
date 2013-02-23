package com.vipro.jsf.bean.sales;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vipro.auth.AuthUser;
import com.vipro.data.Account;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.UserProfile;
import com.vipro.service.AccountService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "salesRegister")
@SessionScoped
public class SalesRegister {

	private List<Project> projects;
	private List<ProjectInventory> inventories;
	private ProjectInventory inventory;
	private Long projectId;
	private Project project;
	private List<Customer> customers;
	private Account account;
	private UserProfile attendedBy;

	@PostConstruct
	public void init() {
		
		
	}
	
	public UserProfile getAttendedBy() {
		return attendedBy;
	}

	public void setAttendedBy(UserProfile attendedBy) {
		this.attendedBy = attendedBy;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<ProjectInventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<ProjectInventory> inventories) {
		this.inventories = inventories;
	}

	public ProjectInventory getInventory() {
		return inventory;
	}

	public void setInventory(ProjectInventory inventory) {
		this.inventory = inventory;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String listProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projects = projectService.findAllProjects();
		return "selectProject";
	}

	public String listPropertyUnits() {
		if (project != null) {
			projectId = project.getProjectId();
		}

		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());
		inventories = inventoryService.getInventories(projectId);

		return "selectUnit";
	}
	
	public String selectInventory() {
		AuthUser user = FacesUtil.getCurrentUser();
		if (user!=null) attendedBy = user.getUserProfile();
		
		
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
		UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
		
		List<Account> accounts =  accountService.findByProjectInventoryId(inventory.getInventoryId());
		/**
		 * support only one account as per one property unit.
		 */
		for (Account a : accounts) {
			account = a;
			if (account.getAttendedBy()!=null) {
				UserProfile up = userProfileService.findById(account.getAttendedBy());
				attendedBy = up;
			}
		}
		
		
		return "registration";
	}
	
	public String saveRegister() {
		try {
			AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			/**
			 * support max 5 customers per account only
			 */
			for (int i=0; i<customers.size(); i++) {
				Customer c = customers.get(i);
				switch (i) {
				case 0:
					account.setCustomer(c);
					break;
				case 1:
					account.setCustomer2(c);
					break;
				case 2:
					account.setCustomer3(c);
					break;
				case 3:
					account.setCustomer4(c);
					break;
				case 4:
					account.setCustomer5(c);
					break;
				}
			}
			account.setProjectInventory(inventory);
			account.setAttendedBy(attendedBy.getUserId());
			accountService.insert(account);
			FacesUtil.addInfoMessage("Sales Registration", "Sales Registration Saved. Registration No is " + account.getAccountId() );
		} catch (Throwable t) {
			FacesUtil.addErrorMessage("Sales Registration", t.getMessage());
		}
		return listPropertyUnits();
	}
}
