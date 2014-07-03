package com.vipro.jsf.bean.customerservice;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.springframework.util.StringUtils;
import com.vipro.auth.AuthUser;
import com.vipro.constant.CommonConst;
import com.vipro.constant.CustomerTypeConst;
import com.vipro.data.Institution;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.UserProfile;
import com.vipro.datamodel.CustomerDataModel;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AddressService;
import com.vipro.service.CustomerService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "potentialRegister")
@SessionScoped
public class PotentialRegister extends CommonBean implements Serializable {

	private List<SelectItem> listCountry = null;
	private List<SelectItem> listCity = null;
	private List<SelectItem> listState = null;
	private List<SelectItem> listIdType = null;
	private List<SelectItem> listTitle = null;
	private List<SelectItem> listGender = null;
	private List<SelectItem> listMaritalStatus = null;
	private List<SelectItem> listRace = null;
	private List<SelectItem> listCategory = null;
	private List<SelectItem> listAgeGroup = null;
	private List<SelectItem> listIncomeGroup = null;
	private List<SelectItem> listMarketingCode = null;
	
	private List<Customer> customers;
	private CustomerDataModel customerDataModel;
	private UserProfile attendedBy;
	private Boolean pdpaCheck = false;
	private Institution institution;	
	
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
	private Address address;

	@PostConstruct
	public void init() {
		listCountry = CodeUtil.getCodes("CT");
		listCity = CodeUtil.getCodes("CI");
		listIdType = CodeUtil.getCodes("ID");
		listTitle = CodeUtil.getCodes("TT");
		listGender = CodeUtil.getCodes("SX");
		listMaritalStatus = CodeUtil.getCodes("MS");
		listRace = CodeUtil.getCodes("RC");
		listState = CodeUtil.getCodes("ST");
		listCategory = CodeUtil.getCodes("CC");
		listAgeGroup = CodeUtil.getCodes("AG");
		listIncomeGroup = CodeUtil.getCodes("IG");
		listMarketingCode = CodeUtil.getCodes("MC");
		
		AuthUser user = getCurrentUser();
		if (user != null) {
			attendedBy = user.getUserProfile();
			setCurrentUserId(attendedBy.getUserId());
			setInstitution(attendedBy.getInstitution());
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


	public List<SelectItem> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<SelectItem> listCategory) {
		this.listCategory = listCategory;
	}

	public List<SelectItem> getListAgeGroup() {
		return listAgeGroup;
	}

	public void setListAgeGroup(List<SelectItem> listAgeGroup) {
		this.listAgeGroup = listAgeGroup;
	}

	public List<SelectItem> getListIncomeGroup() {
		return listIncomeGroup;
	}

	public void setListIncomeGroup(List<SelectItem> listIncomeGroup) {
		this.listIncomeGroup = listIncomeGroup;
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

	public String searchPotential() {
		if (!StringUtils.hasText(searchIdNo)
				&& !StringUtils.hasText(searchName)) {
			setSearchCustList(null);
			addErrorMessage("Search",
					"Please enter name or Id No.");
			return null;
		}

		CustomerService customerService = (CustomerService) SpringBeanUtil
				.lookup(CustomerService.class.getName());

		if (StringUtils.hasText(searchName) || StringUtils.hasText(searchIdNo)) {
			setSearchCustList(customerService.findByIdNoNameCategory(searchIdNo, searchName, CustomerTypeConst.POTENTIAL));
		}

		individual = new Customer();
		address = new Address();

		return null;
	}
	
	public String toAddIndividual() {
		individual = new Customer();
		address = new Address();
		return "addPotential";
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
			
			if (pdpaCheck.equals(true)) {
				individual.setPdpaDisclaimer("Y");
			} else {
				individual.setPdpaDisclaimer("N");
				addErrorMessage("WARNING!",
						"Please agreed and checked the Disclaimer before save.");
				return null;
			}
			
			String fname = individual.getFullName();
			individual.setFullName(fname.toUpperCase());
			
			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
			individual.setCustomerCategory(CustomerTypeConst.POTENTIAL);
			individual.setCustomerStatus(CommonConst.STATUS_NEW);		
			individual.setDateCreated(new Date());
			individual.setCreatedBy(getCurrentUserId());
			individual.setInstitution(getInstitution());
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
			addErrorMessage("Add Potential", t.getMessage());
			return null;
		}

		addInfoMessage("INFORMATION", "Potential Purchaser information created successfully.");
		
		return "potentialSearch";
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
		return "editPotential";
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

			if (individual.getPdpaDisclaimer().equalsIgnoreCase("Y")) {
				pdpaCheck = true;
			} else {
				pdpaCheck = false;
			}
			
			String fname = individual.getFullName();
			individual.setFullName(fname.toUpperCase());
			CustomerService customerService = (CustomerService) SpringBeanUtil
					.lookup(CustomerService.class.getName());
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
			addErrorMessage("Edit Potential Purchaser", t.getMessage());
			return null;
		}

		addInfoMessage("INFORMATION", "Purchaser information saved successfully.");
		
		return backIndividual();
	}

	public String backIndividual() {
		return "/secured/customer_service/potential/potentialSearch.xhtml";
	}

	public Long getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Long currentUserId) {
		this.currentUserId = currentUserId;
	}

	public List<SelectItem> getListMarketingCode() {
		return listMarketingCode;
	}

	public void setListMarketingCode(List<SelectItem> listMarketingCode) {
		this.listMarketingCode = listMarketingCode;
	}

	public Boolean getPdpaCheck() {
		return pdpaCheck;
	}

	public void setPdpaCheck(Boolean pdpaCheck) {
		this.pdpaCheck = pdpaCheck;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
