package com.vipro.jsf.bean.customerservice;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.springframework.util.StringUtils;

import com.vipro.constant.CustomerTypeConst;
import com.vipro.constant.JasperConst;
import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.datamodel.CustomerDataModel;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AddressService;
import com.vipro.service.CustomerService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.JasperUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "customerRegister")
@SessionScoped
public class CustomerRegister extends CommonBean implements Serializable {

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

	private List<Customer> customers;
	private CustomerDataModel customerDataModel;
	private Account account;

	private TabView salesRegTabView;
	private Tab registrationTab;

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
			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
			individual.setCustomerCategory(CustomerTypeConst.INDIVIDUAL);
			customerService.insert(individual);

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address.setCustomer(individual);
			addressService.insert(address);

			individual.setAddressId(address.getAddressId());

			customerService.update(individual);
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Individual", t.getMessage());
			return null;
		}

		return "individualRegistration";
	}

	public String saveCompany() {
		try {
			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
			company.setCustomerCategory(CustomerTypeConst.COMPANY);
			company.setIdentityType("");
			customerService.insert(company);

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address.setCustomer(company);
			addressService.insert(address);

			company.setAddressId(address.getAddressId());
			customerService.update(company);
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Company", t.getMessage());
			return null;
		}

		return "companyRegistration";
	}
	
	public String backIndividual() {
		return "individualRegistration";
	}
	
	public String backCompany() {
		return "companyRegistration";
	}
}
