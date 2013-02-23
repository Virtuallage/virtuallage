package com.vipro.jsf.bean.sales;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.util.StringUtils;

import com.vipro.auth.AuthUser;
import com.vipro.constant.AccountStatusConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.data.Account;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.UserProfile;
import com.vipro.service.AccountService;
import com.vipro.service.CustomerService;
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

	/**
	 * search customer dialog
	 */

	private String searchIdNo;
	private String searchName;
	private List<Customer> searchCustList;
	private Customer selectedCustomer;
	private Customer delCustomer;

	@PostConstruct
	public void init() {

	}

	public Customer getDelCustomer() {
		return delCustomer;
	}

	public void setDelCustomer(Customer delCustomer) {
		this.delCustomer = delCustomer;
	}

	public String getSearchIdNo() {
		return searchIdNo;
	}

	public void setSearchIdNo(String searchIdNo) {
		this.searchIdNo = searchIdNo;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public List<Customer> getSearchCustList() {
		return searchCustList;
	}

	public void setSearchCustList(List<Customer> searchCustList) {
		this.searchCustList = searchCustList;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
		customers.add(selectedCustomer);
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
			if (account.getCustomer() != null)
				customers.add(account.getCustomer());
			if (account.getCustomer2() != null)
				customers.add(account.getCustomer2());
			if (account.getCustomer3() != null)
				customers.add(account.getCustomer3());
			if (account.getCustomer4() != null)
				customers.add(account.getCustomer4());
			if (account.getCustomer5() != null)
				customers.add(account.getCustomer5());
		}

		if (customers == null) {
			customers = new ArrayList<Customer>();
		}

		if (account == null) {
			account = new Account();
		}

		return "registration";
	}

	public String saveRegister() {
		try {
			AccountService accountService = (AccountService) SpringBeanUtil
					.lookup(AccountService.class.getName());
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());

			/**
			 * support max 5 customers per account only
			 */
			for (int i = 0; i < customers.size(); i++) {
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
			account.setAccountStatus(AccountStatusConst.STATUS_ACTIVE);
			accountService.insert(account);

			inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_SOLD);
			inventoryService.update(inventory);

			FacesUtil.addInfoMessage(
					"Sales Registration",
					"Sales Registration Saved. Registration No is "
							+ account.getAccountId());
		} catch (Throwable t) {
			FacesUtil.addErrorMessage("Sales Registration", t.getMessage());
		}
		return listPropertyUnits();
	}

	public String searchCustomer() {
		if (!StringUtils.hasText(searchIdNo)
				&& !StringUtils.hasText(searchName)) {
			FacesUtil.addErrorMessage("Search Customer",
					"Please enter customer name or Id No.");
			return null;
		}

		CustomerService customerService = (CustomerService) SpringBeanUtil
				.lookup(CustomerService.class.getName());
		if (StringUtils.hasText(searchIdNo)) {
			setSearchCustList(customerService.findByIdNo(searchIdNo));
		}

		if (StringUtils.hasText(searchName)) {
			setSearchCustList(customerService.findByName(searchName));
		}

		return null;
	}
	
	public String deleteCustomer() {
		
		customers.remove(delCustomer);
		return "registration";
	}
}
