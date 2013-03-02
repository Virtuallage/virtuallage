package com.vipro.jsf.bean.login;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CodeConst;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.jsf.bean.PageConst;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean
@RequestScoped
public class MyUserProfile extends CommonBean implements PageConst {
	private UserProfile userProfile;
	private List<SelectItem> institutions;
	private List<SelectItem> departments;


	public List<SelectItem> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(List<SelectItem> institutions) {
		this.institutions = institutions;
	}

	public List<SelectItem> getDepartments() {
		return departments;
	}

	public void setDepartments(List<SelectItem> departments) {
		this.departments = departments;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	
	@PostConstruct
	public void init() {
		AuthUser user = getCurrentUser();
		setUserProfile(user.getUserProfile());
		
		
		setInstitutions( CodeUtil.getInstitutionAsItems() );
		setDepartments( CodeUtil.getCodes(CodeConst.DEPARTMENT) );
	}

	
	
	public String save() {
		try {
			UserProfileService service = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
			service.update(userProfile);
			addInfoMessage("My Profile", "User Profile is updated");
		} catch (Throwable th) {
			addErrorMessage("My Profile", "Error saving details. " + th.getMessage());
			return null;
		}
		
		return MAIN;
	}

}
