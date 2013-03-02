package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vipro.auth.AuthUser;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.data.Account;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name="salesUpdate")
@SessionScoped
public class SalesUpdate extends CommonBean implements Serializable{

	private List<Project> projects;
	private List<ProjectInventory> inventories;

	private ProjectInventory inventory;
	private Long projectId;
	private Project project;

	private String customerNames;
	private List<Customer> customers;
	private Account account;
	private UserProfile attendedBy;
	
	@PostConstruct
	public void init() {
		
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


	public String getCustomerNames() {
		return customerNames;
	}


	public void setCustomerNames(String customerNames) {
		this.customerNames = customerNames;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public UserProfile getAttendedBy() {
		return attendedBy;
	}


	public void setAttendedBy(UserProfile attendedBy) {
		this.attendedBy = attendedBy;
	}


	public String listProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projects = projectService.findAllProjects();
		return "updateSelectProject";
	}

	public String listPropertyUnits() {
		if (project != null) {
			projectId = project.getProjectId();
		}

		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());
		inventories = inventoryService.getInventories(projectId);

		return "updateSelectUnit";
	}
	

	public String selectInventory() {
		try {
			customers = new ArrayList<Customer>();
		
			account = null;
	
			AuthUser user = getCurrentUser();
			if (user != null)
				attendedBy = user.getUserProfile();
	
			AccountService accountService = (AccountService) SpringBeanUtil
					.lookup(AccountService.class.getName());
			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil
					.lookup(UserProfileService.class.getName());
	
			List<Account> accounts = accountService
					.findByProjectInventoryId(inventory.getInventoryId());
			/**
			 * support only one account as per one property unit.
			 */
			for (Account a : accounts) {
				account = a;
				if (account.getAttendedBy() != null) {
					UserProfile up = userProfileService.findById(account
							.getAttendedBy());
					attendedBy = up;
				}
				customers = new ArrayList<Customer>();
				StringBuffer names = new StringBuffer();
				if (account.getCustomer() != null) {
					customers.add(account.getCustomer());
					names.append(account.getCustomer().getFullName()).append(", ");
				}
				if (account.getCustomer2() != null) {
					customers.add(account.getCustomer2());
					names.append(account.getCustomer().getFullName()).append(", ");
				}
				if (account.getCustomer3() != null) {
					customers.add(account.getCustomer3());
					names.append(account.getCustomer3().getFullName()).append(", ");
				}
				if (account.getCustomer4() != null) {
					customers.add(account.getCustomer4());
					names.append(account.getCustomer4().getFullName()).append(", ");
				}
				if (account.getCustomer5() != null) {
					customers.add(account.getCustomer5());
					names.append(account.getCustomer5().getFullName()).append(", ");
				}
				customerNames = names.toString();
			}
			
			
			
			
			if ( account==null) {
				addInfoMessage("Sales Update", "This property Unit has no sales transaction. There is nothing to update.");
				return listPropertyUnits();
			}
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Error opening sales", t.getMessage());
			return listPropertyUnits();
		}
		
		
		return "update";
	}
	
	
}
