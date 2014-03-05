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
import com.vipro.constant.CustomerTypeConst;
import com.vipro.constant.PropertyUnitStatusConst;
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
	private BusinessPartner businessPartnerFld;
	private Address address;
	private List<SelectItem> listPartnerType;
	private List<SelectItem> listStatus;
	private List<SelectItem> listTitle;
	
	private List<BusinessPartner> searchBusinessPartnerList;
	
	
		@PostConstruct
	public void init() {
		listPartnerType = CodeUtil.getCodes("PR");
		listStatus = CodeUtil.getCodes("SS");
		listTitle = CodeUtil.getCodes("TT");
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

	public String EditBusinessPartner() {
		try {
			editAddressId = businessPartnerFld.getAddressId();

			AddressService addressService = (AddressService) SpringBeanUtil
					.lookup(AddressService.class.getName());
			address = addressService.findById(editAddressId);
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "editBusinessPartner";
	}
	
	public String backTosearchBusinessPartner() {
		return "searchBusinessPartner";
	}

	public String editBusinessPartner() {
		try {
						
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Edit Business Partner", t.getMessage());
			return null;
		}

		addInfoMessage("Record Saved", "Business Partner information updated successfully.");
		
		return "editBusinessPartner";
	}

	
}
