package com.vipro.jsf.bean.setup;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.vipro.constant.CodeConst;
import com.vipro.data.Institution;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.jsf.bean.PageConst;
import com.vipro.service.InstitutionService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean
@RequestScoped
public class InstitutionInfoBean extends CommonBean implements PageConst {

	private Institution institution;
	private List<SelectItem> contactTitleList;
	private List<SelectItem> cityList;
	private List<SelectItem> stateList;
	private List<SelectItem> countryList;
	private List<SelectItem> departments;


	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<SelectItem> getContactTitleList() {
		return contactTitleList;
	}

	public void setContactTitleList(List<SelectItem> contactTitleList) {
		this.contactTitleList = contactTitleList;
	}

	public List<SelectItem> getCityList() {
		return cityList;
	}

	public void setCityList(List<SelectItem> cityList) {
		this.cityList = cityList;
	}

	public List<SelectItem> getStateList() {
		return stateList;
	}

	public void setStateList(List<SelectItem> stateList) {
		this.stateList = stateList;
	}

	public List<SelectItem> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<SelectItem> countryList) {
		this.countryList = countryList;
	}

	@PostConstruct
	public void init() {
		institution = new Institution();
		contactTitleList = CodeUtil.getCodes(CodeConst.CONTACT_TITLE);
		cityList = CodeUtil.getCodes(CodeConst.CITY);
		stateList = CodeUtil.getCodes(CodeConst.STATE);
		countryList = CodeUtil.getCodes(CodeConst.COUNTRY);
	}
	
	public String onEdit() {
		try {
			InstitutionService service = (InstitutionService) SpringBeanUtil.lookup(InstitutionService.class.getName());
			service.update(institution);
			addInfoMessage("Biz Param", "Institution Info is updated");
		} catch (Throwable th) {
			addErrorMessage("Biz Param", "Error saving details. " + th.getMessage());
			return null;
		}
		
		return MAIN;
	}
	
	public String onSave() {
		try {
			InstitutionService service = (InstitutionService) SpringBeanUtil.lookup(InstitutionService.class.getName());
			service.insert(institution);
			addInfoMessage("Biz Param", "Institution Info is inserted");
		} catch (Throwable th) {
			addErrorMessage("Biz Param", "Error saving details. " + th.getMessage());
			return null;
		}
		
		return MAIN;
	}
	
	public String onCancel() {
		return MAIN;
	}

}
