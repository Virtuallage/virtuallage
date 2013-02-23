package com.vipro.jsf.bean.mydesk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.util.StringUtils;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CaseStatus;
import com.vipro.data.Case;
import com.vipro.data.CaseActivity;
import com.vipro.data.Customer;
import com.vipro.data.Email;
import com.vipro.data.MobilePhone;
import com.vipro.data.UserProfile;
import com.vipro.service.CaseService;
import com.vipro.service.CustomerService;
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

	private List<Customer> searchCustList;
	private String searchIdNo;
	private String searchName;

	private Customer selectedCustomer;

	private CaseActivity activity;
	private List<SelectItem> actionType;
	
	private List<CaseActivity> histories;

	public MyDesk() {
		caseService = (CaseService) SpringBeanUtil.lookup(CaseService.class
				.getName());
	}

	public List<CaseActivity> getHistories() {
		return histories;
	}

	public void setHistories(List<CaseActivity> histories) {
		this.histories = histories;
	}

	public CaseActivity getActivity() {
		return activity;
	}

	public void setActivity(CaseActivity activity) {
		this.activity = activity;
	}

	
	public List<SelectItem> getActionType() {
		return actionType;
	}

	public void setActionType(List<SelectItem> actionType) {
		this.actionType = actionType;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
		newCase.setCustomer(selectedCustomer);
		newCase.setName(selectedCustomer.getFullName());

	
		newCase.setMobileNo(selectedCustomer.getMobileNo());
		

	
		newCase.setEmail(selectedCustomer.getEmail());
		

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
		actionType = CodeUtil.getCodes("ACTION");

	}

	public String listCases() {
		refreshMyCases();
		return "listCase";
	}

	private void refreshMyCases() {
		AuthUser user = FacesUtil.getCurrentUser();
		UserProfile userProfile = user.getUserProfile();
		myCases = caseService.findByAssigneeId(userProfile.getUserId());
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

			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil
					.lookup(UserProfileService.class.getName());
			UserProfile toUserProfile = userProfileService.findById(Long
					.parseLong(toUserId));

			newCase.setAssignee(toUserProfile);

			newCase.setStatus(CaseStatus.NEW);

			caseService.insert(newCase);
			
			toUserId=null;
			existingCustomer=null;
			
			
			refreshMyCases();
			FacesUtil.addInfoMessage("My Work Queue", "Case is created.");

		} catch (Throwable e) {
			FacesUtil.addErrorMessage("My Work Queue", "Error Saving Case. "
					+ e.getMessage());
			return null;
		}
		return "listCase";
	}

	public String updateCase() {
		
		AuthUser authUser = FacesUtil.getCurrentUser();
		UserProfile currentUserProfile = authUser.getUserProfile();
		
		UserProfileService userProfileService = (UserProfileService) SpringBeanUtil
				.lookup(UserProfileService.class.getName());
		UserProfile toUserProfile = userProfileService.findById(Long
				.parseLong(toUserId));

		newCase.setAssignee(toUserProfile);
		
		caseService.update(newCase);
		activity.setActionTime(new Date());
		activity.setActionBy(currentUserProfile);
		caseService.insertActivity(activity);
		
		toUserId=null;
		existingCustomer=null;
		
		refreshMyCases();
		FacesUtil.addInfoMessage("My Work Queue", "Case is updated.");
		return "listCase";
	}

	public String openCase() {
		setNewCase(getSelectedCase());
		CaseActivity act = new CaseActivity();
		act.setCase(getSelectedCase());
		setActivity( act );
		
		activity.setOldDueDate( newCase.getDueDate() );
		
		Case c = caseService.findById(newCase.getCaseId());
		Set<CaseActivity> hists = c.getCaseActivities();
		
		histories = new ArrayList<CaseActivity>();
		for(CaseActivity ca : hists) {
			histories.add(ca);
		}
		
		return "openCase";
	}

	public String cancel() {
		return "listCase";
	}

	public String searchCustomer() {
		if (!StringUtils.hasText(searchIdNo)
				&& !StringUtils.hasText(searchName)) {
			FacesUtil.addErrorMessage("Search Customer",
					"Please enter customer name or Id No.");
			return null;
		}

		CustomerService customerService = (CustomerService) SpringBeanUtil
				.lookup(CustomerService.class.getName());
		if (StringUtils.hasText(searchIdNo)) {
			setSearchCustList(customerService.findByIdNo(searchIdNo));
		}

		if (StringUtils.hasText(searchName)) {
			setSearchCustList(customerService.findByName(searchName));
		}

		return null;
	}
	


}
