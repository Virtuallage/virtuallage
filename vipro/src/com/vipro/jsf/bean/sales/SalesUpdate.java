package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

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
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name="salesUpdate")
@SessionScoped
public class SalesUpdate extends CommonBean implements Serializable{

	private List<Project> projects;
	private List<ProjectInventory> inventories;
	private List<Account> accounts;
	private List<SelectItem> listProject;
	private List<SelectItem> purchaseTypes;
	private List<SelectItem> bankNames;
	private List<SelectItem> spaSolicitorId;
	private List<SelectItem> laSolicitorId;

	private ProjectInventory inventory;
	private Long projectId;
	private Project project;

	private String customerNames;
	private List<Customer> customers;
	private Account account;
	private Long accountId;
	private UserProfile attendedBy;
	
	@PostConstruct
	public void init() {
		purchaseTypes = CodeUtil.getCodes("PCTY");
		bankNames = CodeUtil.getCodes("BANK");
		spaSolicitorId = CodeUtil.getCodes("SPSL");
		laSolicitorId = CodeUtil.getCodes("LASL");
		
	}
	
	public List<SelectItem> getPurchaseTypes() {
		return purchaseTypes;
	}

	public void setPurchaseTypes(List<SelectItem> purchaseTypes) {
		this.purchaseTypes = purchaseTypes;
	}
	
	public List<SelectItem> getBankNames() {
		return bankNames;
	}

	public void setBankNames(List<SelectItem> bankNames) {
		this.bankNames = bankNames;
	}
	
	public List<SelectItem> getSpaSolicitorId() {
		return spaSolicitorId;
	}

	public void setSpaSolicitorId(List<SelectItem> spaSolicitorId) {
		this.spaSolicitorId = spaSolicitorId;
	}
	
	public List<SelectItem> getLaSolicitorId() {
		return laSolicitorId;
	}

	public void setLaSolicitorId(List<SelectItem> laSolicitorId) {
		this.laSolicitorId = laSolicitorId;
	}
	
	public List<SelectItem> getListProject() {
		listProject = CodeUtil.getProjectAsItems();
		return listProject;
	}

	public void setListProject(List<SelectItem> listProject) {
		this.listProject = listProject;
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
	
	
	public List<Account> getAccounts() {
		return this.accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
	public Account getAccount() {
		return account;
	}
	
	
	public Long getAccountId() {
		return accountId;
	}


	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		project = projectService.findById(projectId);

		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());
		inventories = inventoryService.getInventories(projectId);

		//return "updateSelectUnit";
		return "updatePropertyList";
	}
	
	public String listAccounts(){
		listProject = CodeUtil.getProjectAsItems();
		
		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());
		inventories = inventoryService.getInventories(projectId);
		
		AccountService accountService = (AccountService) SpringBeanUtil
				.lookup(AccountService.class.getName());

		accounts = new ArrayList<Account>();
		
		for(ProjectInventory projectInventory: inventories)
		{
			List<Account> dataList = accountService.findByProjectInventoryId(projectInventory.getInventoryId());
			if(dataList != null && dataList.size() > 0) {
				accounts.addAll(dataList);
			}
		}
		
		return "updatePropertyList";
	}
	
	public String selectAcount() {
		
		return "salesProgressUpdate";
	}
	
	public String update() {
		
		if (account != null) {
			AccountService accountService=  (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			accountService.update(account);
			addInfoMessage("Sales Update", "Updated Successfully.");
			return listAccounts();
		} else {
			addInfoMessage("Sales Update", "Failed to update.");
			return "salesProgressUpdate";
		}
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

		//return "update";
		return "salesProgressUpdate";
	}

	
}
