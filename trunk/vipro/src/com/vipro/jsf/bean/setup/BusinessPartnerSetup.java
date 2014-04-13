package com.vipro.jsf.bean.setup;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CommonConst;
import com.vipro.data.BusinessPartnerId;
import com.vipro.data.Institution;
import com.vipro.data.UserProfile;
import com.vipro.data.Address;
import com.vipro.data.BusinessPartner;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AddressService;
import com.vipro.service.BusinessPartnerService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

import org.springframework.util.StringUtils;

@ManagedBean(name="businessPartner")
@SessionScoped
public class BusinessPartnerSetup extends CommonBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3302659604952459781L;
	private String partnerType;
	private Long userId;
	
	private BusinessPartner businessPartnerFld;
	private BusinessPartner businessPartner1;
	private Address address;
	private UserProfile userProfileFld;
	private Institution institution;
	
	private List<SelectItem> listPartnerType;
	private List<SelectItem> listStatus;
	private List<SelectItem> listTitle;
	private List<SelectItem> listState;
	private List<SelectItem> listCountry;
	
	private List<BusinessPartner> searchBusinessPartnerList;
	
	@PostConstruct
	public void init() {
		listPartnerType = CodeUtil.getCodes("PR");
		listStatus = CodeUtil.getCodes("SS");
		listTitle = CodeUtil.getCodes("TT");
		listState = CodeUtil.getCodes("ST");
		listCountry = CodeUtil.getCodes("CT");
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}
	
	public BusinessPartner getBusinessPartnerFld() {
		return businessPartnerFld;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setBusinessPartnerFld(BusinessPartner businessPartnerFld) {
		this.businessPartnerFld = businessPartnerFld;
	}

	public List<SelectItem> getListPartnerType() {
		return listPartnerType;
	}

	public void setListPartnerType(List<SelectItem> listPartnerType) {
		this.listPartnerType = listPartnerType;
	}

	public List<SelectItem> getListStatus() {
		return listStatus;
	}

	public void setListStatus(List<SelectItem> listStatus) {
		this.listStatus = listStatus;
	}

	public List<SelectItem> getListTitle() {
		return listTitle;
	}

	public void setListTitle(List<SelectItem> listTitle) {
		this.listTitle = listTitle;
	}

	public List<SelectItem> getListState() {
		return listState;
	}

	public void setListState(List<SelectItem> listState) {
		this.listState = listState;
	}

	public List<SelectItem> getListCountry() {
		return listCountry;
	}

	public void setListCountry(List<SelectItem> listCountry) {
		this.listCountry = listCountry;
	}

	public List<BusinessPartner> getSearchBusinessPartnerList() {
		return searchBusinessPartnerList;
	}

	public void setSearchBusinessPartnerList(
			List<BusinessPartner> searchBusinessPartnerList) {
		this.searchBusinessPartnerList = searchBusinessPartnerList;
	}

	public String searchBusinessPartner() {
		if (!StringUtils.hasText(partnerType))
		{
			setSearchBusinessPartnerList(null);
			addErrorMessage("Search Business Partner",
					"Please enter Partner type.");
			return null;
		}
		
		BusinessPartnerService businesspartner = (BusinessPartnerService) SpringBeanUtil
				.lookup(BusinessPartnerService.class.getName());

		if (StringUtils.hasText(partnerType)) {
			setSearchBusinessPartnerList(businesspartner.findByPartnerType(partnerType));
		}

		return "searchBusinessPartner";
	}

	public String LoadBusinessPartner() {
		
		return "editBusinessPartner";
	} 
	
	public String NewBusinessPartner() {
		address = new Address();
		businessPartnerFld = new BusinessPartner();
		businessPartnerFld.setAddress(address);
		businessPartnerFld.setStatus(CommonConst.STATUS_ACTIVE);
		return "addBusinessPartner";
	}

	public String backTosearchBusinessPartner() {
		return "searchBusinessPartner";
	}

	public String UpdateBusinessPartner() {
		try {
			BusinessPartnerService businesspartner = (BusinessPartnerService) SpringBeanUtil
					.lookup(BusinessPartnerService.class.getName());
			String cperson = businessPartnerFld.getContactPersonName();
			businessPartnerFld.setContactPersonName(cperson.toUpperCase()); 
			String companyname = businessPartnerFld.getCompanyName();
			businessPartnerFld.setCompanyName(companyname.toUpperCase());
			String companycode = businessPartnerFld.getCompanyCode();
			businessPartnerFld.setCompanyCode(companycode.toUpperCase());

			businesspartner.update(businessPartnerFld);

			address = new Address();
			AddressService addressService = (AddressService) SpringBeanUtil
						.lookup(AddressService.class.getName());
			address.setAddressId(businessPartnerFld.getAddress().getAddressId());
			String address1 = businessPartnerFld.getAddress().getAddressLine1();
			address.setAddressLine1(address1.toUpperCase());
			String address2 = businessPartnerFld.getAddress().getAddressLine2();
			address.setAddressLine2(address2.toUpperCase());
			String address3 = businessPartnerFld.getAddress().getAddressLine3();
			address.setAddressLine3(address3.toUpperCase());
			String address4 = businessPartnerFld.getAddress().getAddressLine4();
			address.setAddressLine4(address4.toUpperCase());
			String city = businessPartnerFld.getAddress().getCity();
			address.setCity(city.toUpperCase());
			address.setPostcode(businessPartnerFld.getAddress().getPostcode());
			address.setState(businessPartnerFld.getAddress().getState());
			address.setCountry(businessPartnerFld.getAddress().getCountry());
				
			addressService.update(address);

		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("WARNING", t.getMessage());
			return null;
		}

		addInfoMessage("SUCCESSFUL", "Business Partner information updated successfully.");

		return "searchBusinessPartner";
//		return "editBusinessPartner";
	}

	public String InsertBusinessPartner() {
		try {
			businessPartner1 = new BusinessPartner();
			BusinessPartnerService businesspartner = (BusinessPartnerService) SpringBeanUtil
					.lookup(BusinessPartnerService.class.getName());
			
			String cperson = businessPartnerFld.getContactPersonName();
			businessPartnerFld.setContactPersonName(cperson.toUpperCase()); 
			String companyname = businessPartnerFld.getCompanyName();
			businessPartnerFld.setCompanyName(companyname.toUpperCase());
			String companycode = businessPartnerFld.getCompanyCode();
			businessPartnerFld.setCompanyCode(companycode.toUpperCase());
			
			// Check if Company Code exists
			businessPartner1 = businesspartner.findByCompanyCode(companycode.toUpperCase());


			if (businessPartner1 != null) {
				String bpName = businessPartner1.getCompanyName();
				addErrorMessage("Add New Business Partner",
						"Initial : " + companycode.toUpperCase() + " already existed." );
				return null;
	        }

			AuthUser user = getCurrentUser();
			if (user != null) {
				userProfileFld = user.getUserProfile();
				userId = userProfileFld.getUserId();
			}
			
			UserProfileService userprofile = (UserProfileService) SpringBeanUtil
					.lookup(UserProfileService.class.getName());
			userProfileFld = userprofile.findById(userId);
		
			institution = userProfileFld.getInstitution();
			Long institutionId = institution.getInstitutionId();
			
			businessPartnerFld.setInstitution(institution);
			
			address = new Address();
			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());

			String address1 = businessPartnerFld.getAddress().getAddressLine1();
			address.setAddressLine1(address1.toUpperCase());
			String address2 = businessPartnerFld.getAddress().getAddressLine2();
			address.setAddressLine2(address2.toUpperCase());
			String address3 = businessPartnerFld.getAddress().getAddressLine3();
			address.setAddressLine3(address3.toUpperCase());
			String address4 = businessPartnerFld.getAddress().getAddressLine4();
			address.setAddressLine4(address4.toUpperCase());
			String city = businessPartnerFld.getAddress().getCity();
			address.setCity(city.toUpperCase());
			address.setPostcode(businessPartnerFld.getAddress().getPostcode());
			address.setState(businessPartnerFld.getAddress().getState());
			address.setCountry(businessPartnerFld.getAddress().getCountry());
			address.setCreatedBy(userProfileFld.getUsername());
			address.setCreatedOn(new Date());

			addressService.insert(address);

			businessPartnerFld.setAddress(address);
			
			businesspartner.insert(businessPartnerFld);

		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("WARNING", t.getMessage());
			return null;
		}

		addInfoMessage("SUCCESSFUL", "Business Partner information added successfully.");

		return "searchBusinessPartner";		
//		return "addBusinessPartner";
	}
	
}
