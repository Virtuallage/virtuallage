package com.vipro.jsf.bean.setup;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CodeConst;
import com.vipro.data.Institution;
import com.vipro.jsf.bean.PageConst;
import com.vipro.service.InstitutionService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean
@RequestScoped
public class InstitutionInfoBean implements PageConst {

	private Institution institution;
	private List<SelectItem> contactTitleList;
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

	
	@PostConstruct
	public void init() {
		AuthUser user = FacesUtil.getCurrentUser();
//		setUserProfile(user.getUserProfile());
		
		
		setContactTitleList( CodeUtil.getCodes(CodeConst.CONTACT_TITLE) );
	}

	
	
	public String edit() {
		try {
			InstitutionService service = (InstitutionService) SpringBeanUtil.lookup(InstitutionService.class.getName());
			service.update(institution);
			FacesUtil.addInfoMessage("Biz Param", "Institution Info is updated");
		} catch (Throwable th) {
			FacesUtil.addErrorMessage("Biz Param", "Error saving details. " + th.getMessage());
			return null;
		}
		
		return MAIN;
	}
	
	public String save() {
		try {
			InstitutionService service = (InstitutionService) SpringBeanUtil.lookup(InstitutionService.class.getName());
			service.insert(institution);
			FacesUtil.addInfoMessage("Biz Param", "Institution Info is inserted");
		} catch (Throwable th) {
			FacesUtil.addErrorMessage("Biz Param", "Error saving details. " + th.getMessage());
			return null;
		}
		
		return MAIN;
	}
	
	public String cancel() {
		return MAIN;
	}

}
