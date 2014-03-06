package com.vipro.jsf.bean.setup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.model.StreamedContent;
import org.primefaces.component.inputtext.InputText;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CommonConst;
import com.vipro.constant.CustomerTypeConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.data.Institution;
import com.vipro.data.UserProfile;
import com.vipro.data.Address;
import com.vipro.data.BusinessPartner;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AddressService;
import com.vipro.service.CustomerService;
import com.vipro.service.DocumentReferenceService;
import com.vipro.service.BusinessPartnerService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.util.StringUtils;

@ManagedBean(name="businessPartner")
@SessionScoped
public class BusinessPartnerSetup extends CommonBean implements Serializable{

	
	private String partnerType;
	private Long editAddressId;
	private Long userId;
	
	private BusinessPartner businessPartnerFld;
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
	
	public Long getEditAddressId() {
		return editAddressId;
	}

	public void setEditAddressId(Long editAddressId) {
		this.editAddressId = editAddressId;
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
		
		editAddressId = businessPartnerFld.getAddressId();

		if(editAddressId==null) {
			address = new Address();
		} else {
			try {
				AddressService addressService = (AddressService) SpringBeanUtil
						.lookup(AddressService.class.getName());
				address = addressService.findById(editAddressId);
				} catch (Throwable t) {
					addErrorMessage(t.getClass().getName(), t.getMessage());
				}
		}
		return "editBusinessPartner";
	}
	
	public String NewBusinessPartner() {
		
		address = new Address();
		businessPartnerFld = new BusinessPartner();
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
			String companyname = businessPartnerFld.getCompanyName();
			businessPartnerFld.setCompanyName(companyname.toUpperCase());
			String companycode = businessPartnerFld.getCompanyCode();
			businessPartnerFld.setCompanyCode(companycode.toUpperCase());

			businesspartner.update(businessPartnerFld);

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			String address1 = address.getAddressLine1();
			address.setAddressLine1(address1.toUpperCase());
			String address2 = address.getAddressLine2();
			address.setAddressLine2(address2.toUpperCase());
			String address3 = address.getAddressLine3();
			address.setAddressLine3(address3.toUpperCase());
			String address4 = address.getAddressLine4();
			address.setAddressLine4(address4.toUpperCase());
			String city = address.getCity();
			address.setCity(city.toUpperCase());

			addressService.update(address);

			businessPartnerFld.setAddressId(address.getAddressId());
			businesspartner.update(businessPartnerFld);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Edit Business Partner", t.getMessage());
			return null;
		}

		addInfoMessage("Record Saved", "Business Partner information updated successfully.");
		
		return "editBusinessPartner";
	}

	public String InsertBusinessPartner() {
		try {
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
			System.out.println(institutionId);
			
			
			BusinessPartnerService businesspartner = (BusinessPartnerService) SpringBeanUtil
					.lookup(BusinessPartnerService.class.getName());
			String companyname = businessPartnerFld.getCompanyName();
			businessPartnerFld.setCompanyName(companyname.toUpperCase());
			String companycode = businessPartnerFld.getCompanyCode();
			businessPartnerFld.setCompanyCode(companycode.toUpperCase());

			businessPartnerFld.setInstitutionId(institutionId);
			
			businesspartner.insert(businessPartnerFld);

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			String address1 = address.getAddressLine1();
			address.setAddressLine1(address1.toUpperCase());
			String address2 = address.getAddressLine2();
			address.setAddressLine2(address2.toUpperCase());
			String address3 = address.getAddressLine3();
			address.setAddressLine3(address3.toUpperCase());
			String address4 = address.getAddressLine4();
			address.setAddressLine4(address4.toUpperCase());
			String city = address.getCity();
			address.setCity(city.toUpperCase());

			addressService.insert(address);

			businessPartnerFld.setAddressId(address.getAddressId());
			businesspartner.update(businessPartnerFld);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add New Business Partner", t.getMessage());
			return null;
		}

		addInfoMessage("Record Saved", "Business Partner information saved successfully.");
		
		return "InsertBusinessPartner";
	}
	
}
