package com.vipro.jsf.bean.customerservice;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.springframework.util.StringUtils;

import com.vipro.auth.AuthUser;
import com.vipro.constant.BusinessPartnerTypeConst;
import com.vipro.constant.CommonConst;
import com.vipro.constant.CustomerTypeConst;
import com.vipro.constant.JasperConst;
import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.Discount;
import com.vipro.data.ProjectInventory;
import com.vipro.data.SalesCommission;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.datamodel.CustomerDataModel;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.AddressService;
import com.vipro.service.CustomerService;
import com.vipro.service.DiscountService;
import com.vipro.service.ProjectService;
import com.vipro.service.SalesCommissionService;
import com.vipro.service.TransactionHistoryService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.JasperUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "customerRegister")
@SessionScoped
public class CustomerRegister extends CommonBean implements Serializable {

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
	private List<SelectItem> listSpecial = null;
	private List<SelectItem> listCategory = null;
	private List<SelectItem> listFinancier = null;	

	private List<Customer> customers;
	private CustomerDataModel customerDataModel;
	private Account account;
	private UserProfile attendedBy;
	
	private TabView salesRegTabView;
	private Tab registrationTab;

	/**
	 * search customer dialog
	 */

	private String searchIdNo;
	private String searchName;
	private List<Customer> searchCustList;
	private Customer customer;
	private long editAddressId;
	private Customer delCustomer;
	private Long currentUserId = null;
	
	/**
	 * add customer
	 */
	private Customer individual;
	private Customer company;
	private Address address;

	/**
	 * property listing 
	 */
	private List<Account> accountList;
	private String header;
	private List<TransactionHistory> billHistory;
	private List<TransactionHistory> paidHistory;

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
		listSpecial = CodeUtil.getCodes("SH");
		listCategory = CodeUtil.getCodes("CC");
		listFinancier = CodeUtil.getBusinessPartnerAsItems(BusinessPartnerTypeConst.BANK);
		
		AuthUser user = getCurrentUser();
		if (user != null) {
			attendedBy = user.getUserProfile();
			setCurrentUserId(attendedBy.getUserId());
		}
		
		searchName = "";
		searchIdNo = "";
		setSearchCustList(null);
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

	public UserProfile getAttendedBy() {
		return attendedBy;
	}

	public void setAttendedBy(UserProfile attendedBy) {
		this.attendedBy = attendedBy;
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
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Long getEditAddressId() {
		return editAddressId;
	}

	public void setEditAddressId(long editAddressId) {
		this.editAddressId = editAddressId;
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

	public String searchIndividual() {
		if (!StringUtils.hasText(searchIdNo)
				&& !StringUtils.hasText(searchName)) {
			setSearchCustList(null);
			addErrorMessage("Search Customer",
					"Please enter customer name or Id No.");
			return null;
		}

		CustomerService customerService = (CustomerService) SpringBeanUtil
				.lookup(CustomerService.class.getName());

		if (StringUtils.hasText(searchName) || StringUtils.hasText(searchIdNo)) {
			setSearchCustList(customerService.findByIdNoNameCategory(searchIdNo, searchName, CustomerTypeConst.INDIVIDUAL));
		}

		individual = new Customer();
		company = new Customer();
		address = new Address();

		return null;
	}
	
	public String searchCompany() {
		if (!StringUtils.hasText(searchIdNo)
				&& !StringUtils.hasText(searchName)) {
			setSearchCustList(null);
			addErrorMessage("Search Customer",
					"Please enter customer name or Id No.");
			return null;
		}

		CustomerService customerService = (CustomerService) SpringBeanUtil
				.lookup(CustomerService.class.getName());

		if (StringUtils.hasText(searchName) || StringUtils.hasText(searchIdNo)) {
			setSearchCustList(customerService.findByIdNoNameCategory(searchIdNo, searchName, CustomerTypeConst.COMPANY));
		}

		individual = new Customer();
		company = new Customer();
		address = new Address();

		return null;
	}

	public String searchPurchaser() {
		if (!StringUtils.hasText(searchIdNo)
				&& !StringUtils.hasText(searchName)) {
			setSearchCustList(null);
			addErrorMessage("Search Customer",
					"Please enter customer name or Id No.");
			return null;
		}

		CustomerService customerService = (CustomerService) SpringBeanUtil
				.lookup(CustomerService.class.getName());

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
		
		return "customerRegistration";
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
			individual.setCreatedBy(getCurrentUserId());
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

		addInfoMessage("Record Created", "Purchaser information created successfully.");
		
		return "individualRegistration";
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
			company.setCreatedBy(getCurrentUserId());
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

		addInfoMessage("Record Created", "Company information created successfully.");
		
		return "companyRegistration";
	}
	
	public String toEditIndividual() {
		try {
			editAddressId = individual.getAddressId();

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address = addressService.findById(editAddressId);
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "editIndividual";
	}

	public String toEditCompany() {
		try {
			editAddressId = company.getAddressId();

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address = addressService.findById(editAddressId);
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "editCompany";
	}
	
	public String toPurchaserDetails() {
		try {
			editAddressId = customer.getAddressId();

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address = addressService.findById(editAddressId);
			
			AccountService accountService = (AccountService) SpringBeanUtil
					.lookup(AccountService.class.getName());
			setAccountList(accountService.findByCustomerId(customer.getCustomerId()));
				
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "purchaserDetails";
	}
	
	public String getAccountType(Customer cust){
		if(cust.getCustomerId().equals(customer.getCustomerId()))
			return "Main";
		else
			return "Join";
	}
	
	public String toPurchaserProperty(Customer cust) {
		editAddressId = cust.getAddressId();
		setHeader("Property Unit Account Inquiry for " + cust.getFullName());
		
		AddressService addressService = (AddressService) SpringBeanUtil
				.lookup(AddressService.class.getName());
		address = addressService.findById(editAddressId);
		
		AccountService accountService = (AccountService) SpringBeanUtil
				.lookup(AccountService.class.getName());
		accountService.findByCustomerId(cust.getCustomerId());	
		
		TransactionHistoryService trnxHistory = (TransactionHistoryService) SpringBeanUtil
				.lookup(TransactionHistoryService.class.getName());
		billHistory = trnxHistory.findTransactionHistoryByAccountIdAndTcode(account.getAccountId(), "500001", "510001", "500002");
		paidHistory = trnxHistory.findByAccountId(account.getAccountId());
				
		return "purchaser_property_information";
	}
	
	public String editIndividual() {
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
			customerService.update(individual);

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
			addressService.update(address);

			individual.setAddressId(address.getAddressId());
			customerService.update(individual);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Individual", t.getMessage());
			return null;
		}

		addInfoMessage("Record Saved", "Purchaser information updated successfully.");
		
		return "individualRegistration";
	}

	public String editCompany() {
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
			customerService.update(company);

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
			addressService.update(address);

			company.setAddressId(address.getAddressId());
			customerService.update(company);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Company", t.getMessage());
			return null;
		}

		addInfoMessage("Record Saved", "Company information updated successfully.");
		
		return "companyRegistration";
	}

	public String backIndividual() {
		return "individualRegistration";
	}
	
	public String backCompany() {
		return "companyRegistration";
	}
	
	public String backPurchaser() {
		return "/secured/customer_service/inquiry/purchaser_information.xhtml";
	}
	
	public String backPurchaserDetails() {
		return "/secured/customer_service/inquiry/purchaserDetails.xhtml";
	}

	public List<SelectItem> getListSpecial() {
		return listSpecial;
	}

	public void setListSpecial(List<SelectItem> listSpecial) {
		this.listSpecial = listSpecial;
	}

	public Long getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Long currentUserId) {
		this.currentUserId = currentUserId;
	}

	public List<SelectItem> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<SelectItem> listCategory) {
		this.listCategory = listCategory;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<TransactionHistory> getBillHistory() {
		return billHistory;
	}

	public void setBillHistory(List<TransactionHistory> billHistory) {
		this.billHistory = billHistory;
	}

	public List<TransactionHistory> getPaidHistory() {
		return paidHistory;
	}

	public void setPaidHistory(List<TransactionHistory> paidHistory) {
		this.paidHistory = paidHistory;
	}

	public List<SelectItem> getListFinancier() {
		return listFinancier;
	}

	public void setListFinancier(List<SelectItem> listFinancier) {
		this.listFinancier = listFinancier;
	}
}
