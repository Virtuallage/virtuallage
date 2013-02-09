package com.vipro.jsf.bean.mydesk;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.vipro.auth.AuthUser;
import com.vipro.data.Case;
import com.vipro.data.UserProfile;
import com.vipro.service.CaseService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

import static com.vipro.jsf.bean.PageConst.MAIN;

@ManagedBean(name = "myDesk")
@SessionScoped
public class MyDesk implements Serializable {
	private CaseService caseService;
	private List<Case> myCases;
	private Case selectedCase;
	private Case newCase;
	private List<SelectItem> toUserList;
	private List<SelectItem> caseType;

	private String toUserId;
	private String existingCustomer;

	public MyDesk() {
		caseService = (CaseService) SpringBeanUtil.lookup(CaseService.class
				.getName());
	}

	public String getExistingCustomer() {
		return existingCustomer;
	}

	public void setExistingCustomer(String existingCustomer) {
		this.existingCustomer = existingCustomer;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public List<SelectItem> getCaseType() {
		return caseType;
	}

	public void setCaseType(List<SelectItem> caseType) {
		this.caseType = caseType;
	}

	public List<SelectItem> getToUserList() {
		return toUserList;
	}

	public void setToUserList(List<SelectItem> toUserList) {
		this.toUserList = toUserList;
	}

	public List<Case> getMyCases() {
		return myCases;
	}

	public void setMyCases(List<Case> myCases) {
		this.myCases = myCases;
	}

	public Case getSelectedCase() {
		return selectedCase;
	}

	public void setSelectedCase(Case selectedCase) {
		this.selectedCase = selectedCase;
	}

	@PostConstruct
	public void init() {
		toUserList = CodeUtil.getUsersAsItems();
		caseType = CodeUtil.getCodes("CASE_TYPE");
	}

	public Case getNewCase() {
		return newCase;
	}

	public void setNewCase(Case newCase) {
		this.newCase = newCase;
	}

	public String toNewCase() {
		setNewCase(new Case());
		getNewCase().setSender(FacesUtil.getCurrentUser().getUserProfile());
		getNewCase().setCreationDate(new Date());
		getNewCase().setDueDate(new Date());
		return "newCase";
	}

	public String insertCase() {
		try {
			AuthUser user = FacesUtil.getCurrentUser();
			UserProfile currentUser = user.getUserProfile();
			newCase.setCreator(currentUser);
			
			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
			UserProfile toUserProfile = userProfileService.findById( Long.parseLong(toUserId) );
			
			newCase.setAssignee(toUserProfile);
			
			caseService.insert(newCase);
			FacesUtil.addInfoMessage("My Work Queue", "Case is created.");
			
		} catch (Throwable e) {
			FacesUtil.addErrorMessage("My Work Queue", "Error Saving Case. " + e.getMessage() );
			return null;
		}
		return "listCase";
	}

	public String updateCase() {
		FacesUtil.addInfoMessage("My Work Queue", "Case is updated.");
		return "listCase";
	}

	public String openCase() {
		return "openCase";
	}

	public String cancel() {
		return "listCase";
	}

}
