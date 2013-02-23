package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.util.StringUtils;

import com.vipro.auth.AuthUser;
import com.vipro.constant.AccountStatusConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.UserProfile;
import com.vipro.service.AccountService;
import com.vipro.service.AddressService;
import com.vipro.service.CustomerService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "salesRegister")
@SessionScoped
public class SalesRegister implements Serializable {

	private List<SelectItem> listCountry = null;
	private List<SelectItem> listCity = null;
	private List<SelectItem> listState = null;
	private List<SelectItem> listIdType = null;
	private List<SelectItem> listTitle = null;
	private List<SelectItem> listGender = null;
	private List<SelectItem> listMaritalStatus = null;
	private List<SelectItem> listBumi = null;
	private List<SelectItem> listLanguage = null;
	private List<SelectItem> listRace = null;

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

	/**
	 * add customer
	 */
	private Customer individual;
	private Customer company;
	private Address address;

	@PostConstruct
	public void init() {
		listCountry = CodeUtil.getCodes("COUNTRY");
		listCity = CodeUtil.getCodes("CITY");
		listIdType = CodeUtil.getCodes("IDTYPE");
		listTitle = CodeUtil.getCodes("CONTACT_TITLE");
		listGender = CodeUtil.getCodes("SEX");
		listMaritalStatus = CodeUtil.getCodes("MARITAL");
		listBumi = CodeUtil.getCodes("BUMI");
		listLanguage = CodeUtil.getCodes("LANGUAGE");
		listRace = CodeUtil.getCodes("RACE");
		listState = CodeUtil.getCodes("STATE");
	}

	public List<SelectItem> getListState() {
		return listState;
	}

	public void setListState(List<SelectItem> listState) {
		this.listState = listState;
	}

	public List<SelectItem> getListRace() {
		return listRace;
	}

	public void setListRace(List<SelectItem> listRace) {
		this.listRace = listRace;
	}

	public List<SelectItem> getListCountry() {
		return listCountry;
	}

	public void setListCountry(List<SelectItem> listCountry) {
		this.listCountry = listCountry;
	}

	public List<SelectItem> getListCity() {
		return listCity;
	}

	public void setListCity(List<SelectItem> listCity) {
		this.listCity = listCity;
	}

	public List<SelectItem> getListIdType() {
		return listIdType;
	}

	public void setListIdType(List<SelectItem> listIdType) {
		this.listIdType = listIdType;
	}

	public List<SelectItem> getListTitle() {
		return listTitle;
	}

	public void setListTitle(List<SelectItem> listTitle) {
		this.listTitle = listTitle;
	}

	public List<SelectItem> getListGender() {
		return listGender;
	}

	public void setListGender(List<SelectItem> listGender) {
		this.listGender = listGender;
	}

	public List<SelectItem> getListMaritalStatus() {
		return listMaritalStatus;
	}

	public void setListMaritalStatus(List<SelectItem> listMaritalStatus) {
		this.listMaritalStatus = listMaritalStatus;
	}

	public List<SelectItem> getListBumi() {
		return listBumi;
	}

	public void setListBumi(List<SelectItem> listBumi) {
		this.listBumi = listBumi;
	}

	public List<SelectItem> getListLanguage() {
		return listLanguage;
	}

	public void setListLanguage(List<SelectItem> listLanguage) {
		this.listLanguage = listLanguage;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer getIndividual() {
		return individual;
	}

	public void setIndividual(Customer individual) {
		this.individual = individual;
	}

	public Customer getCompany() {
		return company;
	}

	public void setCompany(Customer company) {
		this.company = company;
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
		customers = new ArrayList<Customer>();
		account = new Account();
		account.setDatePurchased(new Date());

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

		individual = new Customer();
		company = new Customer();
		address = new Address();

		return "registration";
	}

	public String saveRegister() {
		try {

			if (customers.size() <= 0) {
				FacesUtil.addInfoMessage("Sales Registration",
						"Please select a customer");
				return null;
			}

			AccountService accountService = (AccountService) SpringBeanUtil
					.lookup(AccountService.class.getName());
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());

			/**
			 * support max 5 customers per account only
			 */
			account.setCustomer(null);
			account.setCustomer2(null);
			account.setCustomer3(null);
			account.setCustomer4(null);
			account.setCustomer5(null);
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

		individual = new Customer();
		company = new Customer();
		address = new Address();

		return null;
	}

	public String deleteCustomer() {

		customers.remove(delCustomer);
		return "registration";
	}

	public String toAddIndividual() {
		individual = new Customer();
		address = new Address();
		return "addIndividual";
	}

	public String toAddCompany() {
		company = new Customer();
		address = new Address();
		return "addCompany";
	}

	public String saveIndividual() {
		try {
			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
			customerService.insert(individual);
			
			AddressService addressService = (AddressService) SpringBeanUtil.lookup(AddressService.class.getName());
			address.setCustomer(individual);
			addressService.insert(address);
			
			individual.setAddressId(address.getAddressId());
			
			customerService.update(company);
		} catch (Throwable t) {
			FacesUtil.addErrorMessage("Add Individual", t.getMessage());
			return null;
		}
		return "registration";
	}

	public String saveCompany() {
		try {
			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
			customerService.insert(company);
			
			AddressService addressService = (AddressService) SpringBeanUtil.lookup(AddressService.class.getName());
			address.setCustomer(company);
			addressService.insert(address);
			
			company.setAddressId(address.getAddressId());
			customerService.update(company);
		} catch (Throwable t) {
			FacesUtil.addErrorMessage("Add Company", t.getMessage());
			return null;
		}
		return "registration";
	}

	public String backToRegistration() {
		return "registration";
	}
}
