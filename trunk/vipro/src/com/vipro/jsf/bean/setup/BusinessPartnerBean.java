package com.vipro.jsf.bean.setup;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

//import com.vipro.constant.CodeConst;
//import com.vipro.constant.BusinessPartnerConst;
//import com.vipro.data.Institution;
import com.vipro.data.BusinessPartner;
import com.vipro.data.BusinessPartnerId;

import com.vipro.jsf.bean.CommonBean;
import com.vipro.jsf.bean.PageConst;

//import com.vipro.service.InstitutionService;
//import com.vipro.service.BusinessPartnerService;

import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;
//import com.vipro.service.BusinessPartnerService;


@ManagedBean
@RequestScoped
public class BusinessPartnerBean extends CommonBean implements PageConst {

	private BusinessPartnerId BusinessPartnerId;
	private List<SelectItem> partnerTypeList;



	public BusinessPartnerId getInstitution() {
		return BusinessPartnerId;
	}

	public void setInstitution(BusinessPartnerId institution) {
		this.BusinessPartnerId = institution;
	}

	public List<SelectItem> getPartnerTypeList() {
		return partnerTypeList;
	}

	public void setPartnerTypeList(List<SelectItem> contactTitleList) {
		this.partnerTypeList = contactTitleList;
	}



	@PostConstruct
	public void init() {
		BusinessPartnerId = new BusinessPartnerId();
		//partnerTypeList = CodeUtil.getCodes(BusinessPartnerConst.BUSINESS_TYPE);
	}
	
/*	public String onEdit() {
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
	*/
	public String onCancel() {
		return MAIN;
	}

}
