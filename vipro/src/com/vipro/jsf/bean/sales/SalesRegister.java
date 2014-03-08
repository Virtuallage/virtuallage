package com.vipro.jsf.bean.sales;

import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.util.StringUtils;

import com.vipro.auth.AuthUser;
import com.vipro.constant.AccountStatusConst;
import com.vipro.constant.CaseStatus;
import com.vipro.constant.CodeConst;
import com.vipro.constant.CommonConst;
import com.vipro.constant.CustomerTypeConst;
import com.vipro.constant.JasperConst;
import com.vipro.constant.JasperReportTypeConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.TransactionCode;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.datamodel.CustomerDataModel;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.jsf.bean.mydesk.CaseAlert;
import com.vipro.service.AccountService;
import com.vipro.service.AddressService;
import com.vipro.service.CustomerService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.TransactionHistoryService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.JasperUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "salesRegister")
@SessionScoped
public class SalesRegister extends CommonBean implements Serializable {

	private static final Object arg0 = null;
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
	private List<SelectItem> listProject = null;
	private List<SelectItem> listSpecial = null;
	private List<SelectItem> listLayoutType = null;
	
	private List<SelectItem> listBank = null;
	private List<SelectItem> listPaymentMethod = null;
	private List<SelectItem> listMediaSource = null;
	private List<SelectItem> listSalesPersons = null;	

	private List<Project> projects;
	private List<ProjectInventory> inventories;
	private ProjectInventory inventory;
	private Long projectId;
	private String unitNo;
	private Project project;
	private List<Customer> customers;
	private CustomerDataModel customerDataModel;
	private Account account;
	private UserProfile attendedBy;
	private List<ProjectInventory> lockedUnit;
	private Long currentUserId;
	private ProjectInventory lockedInventory;
	private long editAddressId;

	private TabView salesRegTabView;
	private Tab selectionTab;
	private Tab registrationTab;
	private Tab payBookingTab;
	private CommandButton saveButton;
	private CommandButton payButton;
	private CommandButton previewButton;
	private CommandButton submitButton;
	private CommandButton receiptButton;
	private CommandButton addPurchaserButton;
	private CommandButton editButton;
	private CommandButton confirmButton;
	private CommandButton deleteButton;
//	private InputText payBookingFields;
	
//	public InputText getPayBookingFields() {
//		return payBookingFields;
//	}

//	public void setPayBookingFields(InputText payBookingFields) {
//		this.payBookingFields = payBookingFields;
//	}

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
	private Customer purchaser;
	private Address address;

	/**
	 * booking fee
	 */
	private TransactionHistory trx;
	
	private StreamedContent registrationForm;
	private StreamedContent receipt;

	@PostConstruct
	public void init() {
		listCountry = CodeUtil.getCodes("CT");
		listCity = CodeUtil.getCodes("CI");
		listIdType = CodeUtil.getCodes("ID");
		listTitle = CodeUtil.getCodes("TT");
		listGender = CodeUtil.getCodes("SX");
		listMaritalStatus = CodeUtil.getCodes("MS");
		listBumi = CodeUtil.getCodes("BM");
		listLanguage = CodeUtil.getCodes("LG");
		listRace = CodeUtil.getCodes("RC");
		listState = CodeUtil.getCodes("ST");
		listMediaSource = CodeUtil.getCodes("ME");
		listProject = CodeUtil.getProjectAsItems();
		listSpecial = CodeUtil.getCodes("SH");		
		listLayoutType = CodeUtil.getCodes("LT");		
		listBank = CodeUtil.getCodes("BK");
		listPaymentMethod = CodeUtil.getCodes("PM");
		listSalesPersons = CodeUtil.getActiveUsersAsItems();
	}

	public Tab getRegistrationTab() {
		return registrationTab;
	}

	public CommandButton getPayButton() {
		return payButton;
	}

	public void setPayButton(CommandButton payButton) {
		this.payButton = payButton;
	}

	public CommandButton getPreviewButton() {
		return previewButton;
	}

	public void setPreviewButton(CommandButton previewButton) {
		this.previewButton = previewButton;
	}

	public void setRegistrationTab(Tab registrationTab) {
		this.registrationTab = registrationTab;
	}

	public TabView getSalesRegTabView() {
		return salesRegTabView;
	}

	public void setSalesRegTabView(TabView salesRegTabView) {
		this.salesRegTabView = salesRegTabView;
	}

	public List<SelectItem> getListProject() {
		listProject = CodeUtil.getProjectAsItems();
		return listProject;
	}

	public void setListProject(List<SelectItem> listProject) {
		this.listProject = listProject;
	}

	public List<SelectItem> getListBank() {
		return listBank;
	}

	public void setListBank(List<SelectItem> listBank) {
		this.listBank = listBank;
	}

	public List<SelectItem> getListPaymentMethod() {
		return listPaymentMethod;
	}

	public void setListPaymentMethod(List<SelectItem> listPaymentMethod) {
		this.listPaymentMethod = listPaymentMethod;
	}

	public TransactionHistory getTrx() {
		return trx;
	}

	public void setTrx(TransactionHistory trx) {
		this.trx = trx;
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

	public Customer getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Customer purchaser) {
		this.purchaser = purchaser;
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
	}
	
	public void addSelectedCustomer() {
		boolean duplicate = false;
		String identity = selectedCustomer.getIdentityNo();
		String type = selectedCustomer.getIdentityType();
		for(int i = 0; i < customers.size(); i++) {
			if(identity.equalsIgnoreCase(customers.get(i).getIdentityNo()) 
					&& type.equalsIgnoreCase(customers.get(i).getIdentityType())) {
				duplicate = true;
				i = customers.size();
			}
		}
		
		if (!duplicate) {
			customers.add(selectedCustomer);
		} else {
			addInfoMessage("Select Purchaser",
					"Purchaser has already been selected.");	
		}
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
	
	public CustomerDataModel getCustomerDataModel() {
		return customerDataModel;
	}

	public void setCustomerDataModel(CustomerDataModel customerDataModel) {
		this.customerDataModel = customerDataModel;
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
	
	public List<SelectItem> getListMediaSource() {
		return listMediaSource;
	}

	public void setListMediaSource(List<SelectItem> listMediaSource) {
		this.listMediaSource = listMediaSource;
	}
	
	public Tab getPayBookingTab() {
		return payBookingTab;
	}

	public void setPayBookingTab(Tab payBookingTab) {
		this.payBookingTab = payBookingTab;
	}

	public String listProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projects = projectService.findAllProjects();
		return "selectProject";
	}

	public String listPropertyUnitsBack() {

		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		project = projectService.findById(projectId);
		
		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());

		// update the status back to Available
		if (inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_LOCKED)) {
				inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_AVAILABLE);		
				inventory.setStatusChangeDate(new Date());
				inventory.setChangeUserId(attendedBy.getUserId());
				inventoryService.update(inventory);	
		}

		if (StringUtils.hasText(unitNo)) {
			inventories = inventoryService.getInventories(projectId, unitNo);
		} else {
			inventories = inventoryService.getInventories(projectId);
		}

		salesRegTabView.setActiveIndex(0);
		selectionTab.setDisabled(false);
		registrationTab.setDisabled(true);
		payBookingTab.setDisabled(true);
		
		return "salesRegistration";

	}
	
	public String listPropertyUnits() {
		
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		project = projectService.findById(projectId);

		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());

		if (StringUtils.hasText(unitNo)) {
			inventories = inventoryService.getInventories(projectId, unitNo);
		} else {
			inventories = inventoryService.getInventories(projectId);
		}
		
		salesRegTabView.setActiveIndex(0);
		selectionTab.setDisabled(false);
		registrationTab.setDisabled(true);
		payBookingTab.setDisabled(true);
		
		return "salesRegistration";
	}

	public String selectInventoryBack() {

		salesRegTabView.setActiveIndex(1);
		return "salesRegistration";
	}
	
	public String selectInventory() {
		
		AuthUser user = getCurrentUser();
		if (user != null) {
			attendedBy = user.getUserProfile();
			setCurrentUserId(attendedBy.getUserId());
		}

		// reset tables and fields for new registration
		if (inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_AVAILABLE)) {
			customers = new ArrayList<Customer>();
			account = new Account();
			account.setDatePurchased(new Date());
			account.setSalesPersonId(currentUserId);
//			account.setSalesPerson(user.getName());
		}

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

			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
			selectedCustomer = customerService.findByCustId(account.getCorrAddrCustId());
		}
		
		customerDataModel = new CustomerDataModel(customers);
		individual = new Customer();
		company = new Customer();
		address = new Address();
		
		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());
		
		Long vInventoryId = inventory.getInventoryId();
		inventory = inventoryService.getInventoryById(vInventoryId);
		
		if (inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_LOCKED)) {
			if (inventory.getChangeUserId().equals(user.getUserProfile().getUserId())){
				salesRegTabView.setActiveIndex(1);
				addPurchaserButton.setStyle("");
				saveButton.setStyle("");
				submitButton.setStyle("");
				previewButton.setStyle("display: none");
				payButton.setStyle("display: none");
				receiptButton.setStyle("display: none");
				editButton.setStyle("display: none");
				confirmButton.setStyle("display: none");
				deleteButton.setStyle("");
//				payBookingFields.setDisabled(false);
				inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_LOCKED);		
				inventory.setStatusChangeDate(new Date());
				inventory.setChangeUserId(attendedBy.getUserId());
				inventoryService.update(inventory);	
			} else {
				selectionTab.setDisabled(false);
				addInfoMessage(
						"Unit Locked!",
						"This unit is still under Locked by another user." + inventory.getUnitNo());
				return listPropertyUnits();
			}			
		} else {
			salesRegTabView.setActiveIndex(0);
			selectionTab.setDisabled(false);
			registrationTab.setDisabled(true);
//			payBookingFields.setDisabled(true);
			
			lockedUnit = inventoryService.getLockedUnit(project.getProjectId(), getCurrentUserId());
			if (lockedUnit.size() > 0) {
				setLockedInventory(lockedUnit.set(0, getInventory())); 
				addInfoMessage(
						"Warning: You Have Locked Unit No " + lockedInventory.getUnitNo(),
						"Please unlock this unit before procedding.");
				return null;
			}
		}
		
		selectionTab.setDisabled(true);
		registrationTab.setDisabled(false);
//		payBookingFields.setDisabled(true);

		if (inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_AVAILABLE)) {
			salesRegTabView.setActiveIndex(1);
			addPurchaserButton.setStyle("");
			saveButton.setStyle("");
			submitButton.setStyle("");
			previewButton.setStyle("display: none");
			payButton.setStyle("display: none");
			receiptButton.setStyle("display: none");
			editButton.setStyle("display: none");
			confirmButton.setStyle("display: none");
			deleteButton.setStyle("");
//			payBookingFields.setDisabled(false);
			inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_LOCKED);		
			inventory.setStatusChangeDate(new Date());
			inventory.setChangeUserId(attendedBy.getUserId());
			inventoryService.update(inventory);			
		}
		
		else if (inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_IN_PROGRESS)) {
			salesRegTabView.setActiveIndex(1);
			addPurchaserButton.setStyle("display: none");
			saveButton.setStyle("display: none");
			submitButton.setStyle("");
			previewButton.setStyle("display: none");
			payButton.setStyle("");
			receiptButton.setStyle("display: none");
			editButton.setStyle("display: none");
			confirmButton.setStyle("display: none");
			deleteButton.setStyle("display: none");
//			payBookingFields.setDisabled(false);
		}

		else if (inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_BOOKED)) {
			salesRegTabView.setActiveIndex(1);
			addPurchaserButton.setStyle("display: none");
			saveButton.setStyle("display: none");
			submitButton.setStyle("display: none");
			previewButton.setStyle("display: none");
			payButton.setStyle("display: none");
			receiptButton.setStyle("display: none");
			editButton.setStyle("");
			confirmButton.setStyle("");
			deleteButton.setStyle("display: none");
//			payBookingFields.setDisabled(false);
			payBookingTab.setDisabled(false);
		}
		
		else if (inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_SOLD)) {
			salesRegTabView.setActiveIndex(1);
			addPurchaserButton.setStyle("display: none");
			saveButton.setStyle("display: none");
			submitButton.setStyle("display: none");
			previewButton.setStyle("");
			payButton.setStyle("display: none");
			receiptButton.setStyle("");
			editButton.setStyle("display: none");
			confirmButton.setStyle("display: none");
			deleteButton.setStyle("display: none");
//			payBookingFields.setDisabled(false);
			payBookingTab.setDisabled(false);
		}
		
		else if (inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_CANCELLING)) {
			salesRegTabView.setActiveIndex(1);
			addPurchaserButton.setStyle("display: none");
			saveButton.setStyle("display: none");
			submitButton.setStyle("display: none");
			previewButton.setStyle("");
			payButton.setStyle("display: none");
			receiptButton.setStyle("");
			editButton.setStyle("display: none");
			confirmButton.setStyle("display: none");
			deleteButton.setStyle("display: none");
//			payBookingFields.setDisabled(false);
			payBookingTab.setDisabled(false);
		}
		
		else if (inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_RESERVED)) {
			salesRegTabView.setActiveIndex(1);
			addPurchaserButton.setStyle("");
			saveButton.setStyle("display: none");
			submitButton.setStyle("");
			previewButton.setStyle("display: none");
			payButton.setStyle("");
			receiptButton.setStyle("display: none");
			editButton.setStyle("");
			confirmButton.setStyle("display: none");
			deleteButton.setStyle("display: none");
//			payBookingFields.setDisabled(false);
		}
		
		return "salesRegistration";
	}

	public String saveRegister() {
		try {

			if (customers.size() <= 0) {
				addInfoMessage("Sales Registration",
						"Please select a purchaser");
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
			account.setAccountStatus(AccountStatusConst.STATUS_NEW);
			account.setDateChanged(new Date());
			account.setChangedBy(attendedBy.getUserId());
			account.setPurchasePrice(inventory.getPurchasePrice());

			// ***  default account type to individual first. Should check for 1st purchaser type for this.
			// *** to set account type from customer category
			account.setAccountType(selectedCustomer.getCustomerCategory());
			account.setCorrAddrCustId(selectedCustomer.getCustomerId());

			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
			UserProfile salesProfile = userProfileService.findById(account.getSalesPersonId());
			if(salesProfile != null) {
				account.setSalesPerson(salesProfile.getName());
			}
// BILL Removed	the calculation and replace with fee from Project Table		
//			BigDecimal regFee = inventory.getPurchasePrice().multiply(new BigDecimal(0.002d));
//			regFee = regFee.setScale(2, BigDecimal.ROUND_HALF_UP);
//			
//			account.setRegistrationFee(regFee);

			accountService.insert(account);

			inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_IN_PROGRESS);		
			inventory.setStatusChangeDate(new Date());
			inventory.setChangeUserId(attendedBy.getUserId());
			
			inventoryService.update(inventory);
			
			saveButton.setStyle("display: none");
			addPurchaserButton.setStyle("display: none");
			payButton.setStyle("");
			editButton.setStyle("display: none");
			deleteButton.setStyle("display: none");
			
			addInfoMessage(
					"INFORMATION!",
					"Sales Registration Saved Successfully. Registration No is "
							+ account.getAccountId());
			
//BILL 18/6/13 Move this to after paying the booking fee.		
//BILL		HashMap<String, Object> hm = new HashMap<String, Object>();
//BILL		hm.put("account_id", Long.toString(account.getAccountId()));
			
//BILL		String report = JasperConst.SALES_REG_FORM;
//BILL		JasperUtil.generateReport(hm, report, account, JasperReportTypeConst.REGISTRATION_FILE);
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Sales Registration", t.getMessage());
		}
		
		return null;
	}

	public String searchCustomer() {
		if (!StringUtils.hasText(searchIdNo)
				&& !StringUtils.hasText(searchName)) {
			setSearchCustList(null);
			addErrorMessage("Info",
					"Please enter either customer name or Id No for search.");
			return null;
		}

		CustomerService customerService = (CustomerService) SpringBeanUtil.lookup(CustomerService.class.getName());
//		if (StringUtils.hasText(searchIdNo)) {
//			setSearchCustList(customerService.findByIdNo(searchIdNo));
//		}

		if (StringUtils.hasText(searchName) || StringUtils.hasText(searchIdNo)) {
			setSearchCustList(customerService.findByIdNoName(searchIdNo, searchName));
		}

		individual = new Customer();
		company = new Customer();
		address = new Address();

		return null;
	}

	public String deleteCustomer() {

		customers.remove(delCustomer);
		salesRegTabView.setActiveIndex(1);
		registrationTab.setDisabled(false);
		
		return "salesRegistration";
	}

	public String editPurchaser() {
		try {
			editAddressId = purchaser.getAddressId();

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address = addressService.findById(editAddressId);
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
			return null;
		}
		
		if (purchaser.getCustomerCategory().equalsIgnoreCase(CustomerTypeConst.COMPANY)) {
			return "editCompanyReg";
		}
		else {
			return "editIndividualReg";
		}
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
			if (address.getCountry().equals(CommonConst.MALAYSIA)) {
				if (!StringUtils.hasText(address.getCity())) {
					addErrorMessage("WARNING!",
							"Please enter a City Name in Malaysia");
					return null;
				}
				if (!StringUtils.hasText(address.getState())) {
					addErrorMessage("WARNING!",
							"Please select a valid State in Malaysia.");
					return null;
				}
			}
			
			String fname = individual.getFullName();
			individual.setFullName(fname.toUpperCase());
			
			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
			individual.setCustomerCategory(CustomerTypeConst.INDIVIDUAL);
			individual.setCustomerStatus(CommonConst.STATUS_NEW);		
			individual.setDateCreated(new Date());
			individual.setCreatedBy(attendedBy.getUserId());
			customerService.insert(individual);

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address.setCustomer(individual);
			String aline1 = address.getAddressLine1();
			address.setAddressLine1(aline1.toUpperCase());
			String aline2 = address.getAddressLine2();
			address.setAddressLine2(aline2.toUpperCase());
			String aline3 = address.getAddressLine3();
			address.setAddressLine3(aline3.toUpperCase());
			String aline4 = address.getAddressLine4();
			address.setAddressLine4(aline4.toUpperCase());
			String acity = address.getCity();
			address.setCity(acity.toUpperCase());
			addressService.insert(address);
			
			individual.setAddressId(address.getAddressId());
			customerService.update(individual);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Individual", t.getMessage());
			return null;
		}
		salesRegTabView.setActiveIndex(1);
		registrationTab.setDisabled(false);
		
		setSelectedCustomer(individual);
		addSelectedCustomer();
		
		return "salesRegistration";
	}

	public String saveCompany() {
		try {
			if (address.getCountry().equals(CommonConst.MALAYSIA)) {
				if (!StringUtils.hasText(address.getCity())) {
					addErrorMessage("WARNING!",
							"Please enter a City Name in Malaysia");
					return null;
				}
				if (!StringUtils.hasText(address.getState())) {
					addErrorMessage("WARNING!",
							"Please select a valid State in Malaysia.");
					return null;
				}
			}
			
			String fname = company.getFullName();
			company.setFullName(fname.toUpperCase());
			
			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
			company.setCustomerCategory(CustomerTypeConst.COMPANY);
			company.setIdentityType(CustomerTypeConst.BUSINESSREGISTRATION);
			company.setCustomerStatus(CommonConst.STATUS_NEW);		
			company.setDateCreated(new Date());
			company.setCreatedBy(attendedBy.getUserId());
			customerService.insert(company);

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address.setCustomer(company);
			String aline1 = address.getAddressLine1();
			address.setAddressLine1(aline1.toUpperCase());
			String aline2 = address.getAddressLine2();
			address.setAddressLine2(aline2.toUpperCase());
			String aline3 = address.getAddressLine3();
			address.setAddressLine3(aline3.toUpperCase());
			String aline4 = address.getAddressLine4();
			address.setAddressLine4(aline4.toUpperCase());
			String acity = address.getCity();
			address.setCity(acity.toUpperCase());			
			addressService.insert(address);

			company.setAddressId(address.getAddressId());
			customerService.update(company);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Company", t.getMessage());
			return null;
		}
		salesRegTabView.setActiveIndex(1);
		registrationTab.setDisabled(false);
		
		setSelectedCustomer(company);
		addSelectedCustomer();
		
		return "salesRegistration";
	}


	public String savePurchaser() {
		try {
			if (address.getCountry().equals(CommonConst.MALAYSIA)) {
				if (!StringUtils.hasText(address.getCity())) {
					addErrorMessage("WARNING!",
							"Please enter a City Name in Malaysia");
					return null;
				}
				if (!StringUtils.hasText(address.getState())) {
					addErrorMessage("WARNING!",
							"Please select a valid State in Malaysia.");
					return null;
				}
			}
			
			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
			customerService.update(purchaser);

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address.setCustomer(purchaser);
			String aline1 = address.getAddressLine1();
			address.setAddressLine1(aline1.toUpperCase());
			String aline2 = address.getAddressLine2();
			address.setAddressLine2(aline2.toUpperCase());
			String aline3 = address.getAddressLine3();
			address.setAddressLine3(aline3.toUpperCase());
			String aline4 = address.getAddressLine4();
			address.setAddressLine4(aline4.toUpperCase());
			String acity = address.getCity();
			address.setCity(acity.toUpperCase());	
			addressService.update(address);

			purchaser.setAddressId(address.getAddressId());
			customerService.update(purchaser);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Change Purchaser Information", t.getMessage());
			return null;
		}
		salesRegTabView.setActiveIndex(1);
		registrationTab.setDisabled(false);
		
		setSelectedCustomer(purchaser);
		// addSelectedCustomer();
		
		addInfoMessage("Saved", "Purchaser information successfully saved.");
		
		return "salesRegistration";
	}	
	
	
	public String backToRegistration() {
		return "registration";
	}

	public String toPay() {
		try {
			if (account==null || account.getAccountId()==null) {
				addErrorMessage("Warning", "Please save before proceed with booking payment.");
				return null;
			}
			
			trx = new TransactionHistory();
			if (account != null && account.getAccountId() != null) {
				TransactionHistoryService trxService = (TransactionHistoryService) SpringBeanUtil
						.lookup(TransactionHistoryService.class.getName());
				List<TransactionHistory> list = trxService
						.findByAccountId(account.getAccountId());
				if (list != null && list.size() > 0) {
					for (TransactionHistory t : list) {
						if (TransactionCodeConst.BOOK_FEE.equals(t
								.getTransactionCode().getTransactionCode())) {
							trx = t;
							break;
						}
					}
				}
			}

		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Booking Fee", t.getMessage());
			return null;
		}

		salesRegTabView.setActiveIndex(2);
		payBookingTab.setDisabled(false);
		
		return "salesRegistration";
	}

	public String payBooking() {
		if (!account.getBookPymtMethod().equalsIgnoreCase(CommonConst.CASH)) {
			if (account.getBookPymtCardChqNo().equalsIgnoreCase("") && account.getBookPymtBank().equalsIgnoreCase("")) {
				addErrorMessage("Invalid Fields",
						"Please Enter Card/Cheque No & Bank Name for non-cash payment!");
				return null;
			}
			if (account.getBookPymtCardChqNo().equalsIgnoreCase("") && !account.getBookPymtBank().equalsIgnoreCase("")) {
				addErrorMessage("Invalid Field",
						"Please Enter Card/Cheque No!");
				return null;
			}
			if (!account.getBookPymtCardChqNo().equalsIgnoreCase("") && account.getBookPymtBank().equalsIgnoreCase("")) {
				addErrorMessage("Invalid Field",
						"Please Select a Bank Name!");
				return null;
			}
		}

		try {
			TransactionCode code = new TransactionCode();
			code.setTransactionCode(TransactionCodeConst.BOOK_FEE);

			TransactionHistoryService trxService = (TransactionHistoryService) SpringBeanUtil
					.lookup(TransactionHistoryService.class.getName());
			trx.setTransactionCode(code);
			trx.setTransactionDate(new Date());
			trx.setAccount(account);
			trx.setTransactionDescription("BOOKING FEE");
			trx.setStatus(TransactionStatusConst.PENDING);
			trx.setAmount(account.getBookPymtAmount());
			trx.setBank(account.getBookPymtBank());
			trx.setCardChequeNo(account.getBookPymtCardChqNo());
			trx.setPaymentMethod(account.getBookPymtMethod());

			trxService.insert(trx);
			
			// for payBooking details
			AccountService accountService = (AccountService) SpringBeanUtil
					.lookup(AccountService.class.getName());
			
			// new update disc & nett amount into account plus other account fields
			account.setDiscountedAmount(inventory.getDiscountAmount());
			account.setNetPrice(account.getPurchasePrice().subtract(account.getDiscountedAmount()));
// Bill			account.setTotalPaymentTodate(account.getBookPymtAmount());
			account.setRegistrationFee(account.getBookPymtAmount());
			// account.setAccountBalance(account.getPurchasePrice().subtract(account.getBookPymtAmount()));
			
			// update commission amount from project file
			account.setCommissionAmount(project.getSalesCommission());
			account.setLatePymtIntRate(project.getLatePymtIntRate());
			
			accountService.insert(account);
			
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());
			inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_BOOKED);
			inventory.setStatusChangeDate(new Date());
			if (!inventory.getNetPrice().equals(account.getNetPrice())) {
				inventory.setNetPrice(account.getNetPrice());
			}
			
			AuthUser user = getCurrentUser();
			inventory.setChangeUserId(user.getUserProfile().getUserId());
			
			inventoryService.update(inventory);
			
			// show & hide buttons
			confirmButton.setStyle("");
			editButton.setStyle("");
			payButton.setStyle("display: none");
			submitButton.setStyle("display: none");
			deleteButton.setStyle("display: none");
			addPurchaserButton.setStyle("display: none");
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Booking Fee", t.getMessage());
			return null;
		}
		
		addInfoMessage("Saved", "Booking Fee Transaction Created Successfully.");
		salesRegTabView.setActiveIndex(1);

		CaseAlert caseAlert = new CaseAlert();
		caseAlert.insertCase(CaseStatus.PAID_BOOKING_FEE, projectId, account.getAccountId(),
				attendedBy, selectedCustomer, CaseStatus.SUBMITTED, null, null);
		
		return "salesRegistration";
	//	return selectInventory();
	}
	
	public String toConfirm() {
		
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
		
		if (account.getCustomer()==null) {
			addErrorMessage("Warning",
					"Invalid Purchaser! You need at least 1 purchaser for sales registration.");
			return null;
		}

		UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
		UserProfile salesProfile = userProfileService.findById(account.getSalesPersonId());
		if(salesProfile != null) {
			account.setSalesPerson(salesProfile.getName());
		}

		account.setDateChanged(new Date());
		account.setChangedBy(getCurrentUserId());
		accountService.update(account);
		
		// update inventory status to SOLD confirmation.
		inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_SOLD);
		inventory.setStatusChangeDate(new Date());
		inventory.setChangeUserId(getCurrentUserId());
		inventoryService.update(inventory);

		// generate receipt
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("account_id", Long.toString(account.getAccountId()));
		
		// check to print which receipt format
		if (account.getAccountType().equalsIgnoreCase(CommonConst.INDIVIDUAL)) {
			if (account.getBookPymtMethod().equalsIgnoreCase(CommonConst.CASH)) {
				String report = JasperConst.SALES_REG_RECEIPT;
				JasperUtil.generateReport(hm, report, account, JasperReportTypeConst.RECEIPT_FILE);
			} else {
				String report = JasperConst.SALES_REG_RECEIPT2;
				JasperUtil.generateReport(hm, report, account, JasperReportTypeConst.RECEIPT_FILE);
			}
		} else {
			if (account.getBookPymtMethod().equalsIgnoreCase(CommonConst.CASH)) {
				String report = JasperConst.SALES_REG_RECEIPT3;
				JasperUtil.generateReport(hm, report, account, JasperReportTypeConst.RECEIPT_FILE);
			} else {
				String report = JasperConst.SALES_REG_RECEIPT4;
				JasperUtil.generateReport(hm, report, account, JasperReportTypeConst.RECEIPT_FILE);
			}
		}
					
		// BILL Check if there is 2nd purchaser, cash payment or company, all use different form.
		
		HashMap<String, Object> hm2 = new HashMap<String, Object>();
		hm2.put("account_id", Long.toString(account.getAccountId()));
		
		if (account.getAccountType().equalsIgnoreCase(CommonConst.INDIVIDUAL)) {
			if (account.getCustomer2()==null) {
				if (account.getBookPymtMethod().equalsIgnoreCase(CommonConst.CASH)) {
					String report = JasperConst.SALES_REG_FORM3;
					JasperUtil.generateReport(hm2, report, account, JasperReportTypeConst.REGISTRATION_FILE);
				} else {
					String report = JasperConst.SALES_REG_FORM;
					JasperUtil.generateReport(hm2, report, account, JasperReportTypeConst.REGISTRATION_FILE);
				} 
			}
			if (account.getCustomer2()!=null) {
				if (account.getBookPymtMethod().equalsIgnoreCase(CommonConst.CASH)) {
					String report = JasperConst.SALES_REG_FORM4;
					JasperUtil.generateReport(hm2, report, account, JasperReportTypeConst.REGISTRATION_FILE);
				} else {
					String report = JasperConst.SALES_REG_FORM2;
					JasperUtil.generateReport(hm2, report, account, JasperReportTypeConst.REGISTRATION_FILE);
				}			
			}
		} else {
			if (account.getBookPymtMethod().equalsIgnoreCase(CommonConst.CASH)) {
				String report = JasperConst.SALES_REG_FORM6;
				JasperUtil.generateReport(hm2, report, account, JasperReportTypeConst.REGISTRATION_FILE);
			} else {
				String report = JasperConst.SALES_REG_FORM5;
				JasperUtil.generateReport(hm2, report, account, JasperReportTypeConst.REGISTRATION_FILE);
			} 
		}

		confirmButton.setStyle("display: none");
		editButton.setStyle("display: none");
		addPurchaserButton.setStyle("display: none");
		previewButton.setStyle("");
		receiptButton.setStyle("");
		
		addInfoMessage("Generated", "Registration Form & Receipt Generated.");
		
		return "salesRegistration";
	}
	
	public CommandButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(CommandButton saveButton) {
		this.saveButton = saveButton;
	}

	public CommandButton getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(CommandButton submitButton) {
		this.submitButton = submitButton;
	}

	public CommandButton getReceiptButton() {
		return receiptButton;
	}

	public void setReceiptButton(CommandButton receiptButton) {
		this.receiptButton = receiptButton;
	}
	
	public StreamedContent getRegistrationForm() {  
		String fileName = JasperReportTypeConst.REGISTRATION_FILE;
		String path ="/reports/" + account.getAccountId() + "/" + fileName;
		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);  
        registrationForm = new DefaultStreamedContent(stream, fileName, fileName); 
        
        return registrationForm;  
    } 
	
	public StreamedContent getReceipt() {  
		String fileName = JasperReportTypeConst.RECEIPT_FILE;
		String path ="/reports/" + account.getAccountId() + "/" + fileName;
		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);  
        receipt = new DefaultStreamedContent(stream, fileName, fileName); 
        
        return receipt;  
    }

	public Tab getSelectionTab() {
		return selectionTab;
	}

	public void setSelectionTab(Tab selectionTab) {
		this.selectionTab = selectionTab;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public CommandButton getAddPurchaserButton() {
		return addPurchaserButton;
	}

	public void setAddPurchaserButton(CommandButton addPurchaserButton) {
		this.addPurchaserButton = addPurchaserButton;
	}

	public CommandButton getEditButton() {
		return editButton;
	}

	public void setEditButton(CommandButton editButton) {
		this.editButton = editButton;
	}

	public CommandButton getConfirmButton() {
		return confirmButton;
	}

	public void setConfirmButton(CommandButton confirmButton) {
		this.confirmButton = confirmButton;
	}

	public CommandButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(CommandButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public Long getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Long currentUserId) {
		this.currentUserId = currentUserId;
	}

	public ProjectInventory getLockedInventory() {
		return lockedInventory;
	}

	public void setLockedInventory(ProjectInventory lockedInventory) {
		this.lockedInventory = lockedInventory;
	}

	public long getEditAddressId() {
		return editAddressId;
	}

	public void setEditAddressId(long editAddressId) {
		this.editAddressId = editAddressId;
	}

	public List<SelectItem> getListSpecial() {
		return listSpecial;
	}

	public void setListSpecial(List<SelectItem> listSpecial) {
		this.listSpecial = listSpecial;
	}

	public List<SelectItem> getListLayoutType() {
		return listLayoutType;
	}

	public void setListLayoutType(List<SelectItem> listLayoutType) {
		this.listLayoutType = listLayoutType;
	}

	public List<SelectItem> getListSalesPersons() {
		return listSalesPersons;
	}

	public void setListSalesPersons(List<SelectItem> listSalesPersons) {
		this.listSalesPersons = listSalesPersons;
	}
}
