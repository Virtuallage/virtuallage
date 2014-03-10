package com.vipro.jsf.bean.mydesk;

import java.util.Date;
import java.util.List;

import com.vipro.constant.CaseStatus;
import com.vipro.constant.ClaimStatusConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.data.Case;
import com.vipro.data.CaseActivity;
import com.vipro.data.CaseLink;
import com.vipro.data.CaseRoute;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.CaseService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.SpringBeanUtil;

public class CaseAlert extends CommonBean{
	private Case newCase;
	private CaseActivity caseActivity;
	private CaseService caseService;

	public void insertCase(String caseType, Long projectId, 
			Long accountId, UserProfile currentUser,  
			Customer customer, String status, UserProfile assignee, String groupId) {
		try {
			caseService = (CaseService) SpringBeanUtil.lookup(CaseService.class
					.getName());

			newCase = new Case();
			newCase.setCaseType(caseType);
			newCase.setProjectId(projectId);
			newCase.setAccountId(accountId);
			newCase.setCreator(currentUser);
			newCase.setSender(currentUser);
//			newCase.setCustomer(customer);
			newCase.setcustomerId(customer.getCustomerId());
			newCase.setStatus(status);
			newCase.setCreationDate(new Date());
			newCase.setDueDate(new Date());
			newCase.setNotification(false);

			if(assignee!=null)
				newCase.setAssignee(assignee);

			if(groupId!=null)
				newCase.setGroupId(groupId);

			if(assignee==null && groupId==null){
				CaseRoute cr = caseService.getCaseRoute(caseType, status, projectId, 
						currentUser.getUserGroup().getGroupId(), currentUser.getUserId());

				if(cr.gettUserId()!=null){
					UserProfileService userProfileService = (UserProfileService) SpringBeanUtil
							.lookup(UserProfileService.class.getName());
					UserProfile toUserProfile = userProfileService.findById(cr.gettUserId());
					newCase.setAssignee(toUserProfile);
				}
				newCase.setGroupId(cr.gettGroupId());
			}

			caseService.insert(newCase);
			
			caseActivity = new CaseActivity();
			caseActivity.setCase(newCase);
			caseActivity.setActionBy(currentUser);
			caseActivity.setActionCode(caseType);
			caseActivity.setActionTime(new Date());
			caseActivity.setAction(status);
			caseService.insertActivity(caseActivity);
			
		} catch (Throwable e) {
			addErrorMessage("My Work Queue", "Error Saving Case. "
					+ e.getMessage());
		}
	}

	public void cancelCase(String caseType, Long projectId, 
			Long accountId, UserProfile currentUser,  
			String status, UserProfile assignee, String groupId) {
		try {
			caseService = (CaseService) SpringBeanUtil.lookup(CaseService.class
					.getName());

			newCase = caseService.findByProject(caseType, projectId, accountId);
			
			if(newCase.getStatus() != CaseStatus.CLOSED){
				newCase.setStatus(status);

				caseActivity = new CaseActivity();
				caseActivity.setCase(newCase);
				caseActivity.setActionBy(currentUser);
				caseActivity.setActionCode(caseType);
				caseActivity.setActionTime(new Date());
				caseActivity.setAction(status);
				caseService.insertActivity(caseActivity);

				caseService.update(newCase);
			}
			
		} catch (Throwable e) {
			addErrorMessage("My Work Queue", "Error cancel Case. "
					+ e.getMessage());
		}
	}

	public void openCase(String caseType, Long projectId, 
			Long accountId, UserProfile currentUser,  
			String status) {
		try {
			caseService = (CaseService) SpringBeanUtil.lookup(CaseService.class
					.getName());

			newCase = caseService.findByProject(caseType, projectId, accountId);

			if(newCase.getStatus().equalsIgnoreCase(CaseStatus.SUBMITTED)){

				newCase.setStatus(CaseStatus.OPEN);

				caseActivity = new CaseActivity();
				caseActivity.setCase(newCase);
				caseActivity.setActionBy(currentUser);
				caseActivity.setActionCode(caseType);
				caseActivity.setActionTime(new Date());
				caseActivity.setAction(CaseStatus.OPEN);
				caseService.insertActivity(caseActivity);

				caseService.update(newCase);
			}
			
		} catch (Throwable e) {
			addErrorMessage("My Work Queue", "Error cancel Case. "
					+ e.getMessage());
		}
	}
	
	public void updateCase(String caseType, Long projectId, 
			Long accountId, UserProfile currentUser,  
			String status, UserProfile assignee, String groupId) {
		try {
			caseService = (CaseService) SpringBeanUtil.lookup(CaseService.class
					.getName());

			newCase = caseService.findByProject(caseType, projectId, accountId);
			if(newCase==null){
				newCase = new Case();
			}else{
				caseActivity = new CaseActivity();
				caseActivity.setCase(newCase);
				caseActivity.setActionBy(currentUser);
				caseActivity.setActionCode(caseType);
				caseActivity.setActionTime(new Date());
				caseActivity.setAction(status);
				caseService.insertActivity(caseActivity);
			}

			newCase.setProjectId(projectId);
			newCase.setAccountId(accountId);

			if(assignee!=null){
				newCase.setAssignee(assignee);

			}else if (groupId!=null){
				newCase.setGroupId(groupId);

			}else{
				CaseRoute cr = caseService.getCaseRoute(caseType, status, projectId, 
						currentUser.getUserGroup().getGroupId(), currentUser.getUserId());

				if(cr.gettUserId()!=null){
					UserProfileService userProfileService = (UserProfileService) SpringBeanUtil
							.lookup(UserProfileService.class.getName());
					UserProfile toUserProfile = userProfileService.findById(cr.gettUserId());
					newCase.setAssignee(toUserProfile);
				}else{
					newCase.setAssignee(null);
				}
				
				newCase.setGroupId(cr.gettGroupId());

				if(status!=null)
					newCase.setStatus(status);
				else
					newCase.setStatus(cr.getNextAction());

				if(status.equalsIgnoreCase(CaseStatus.REJECTED))
					newCase.setAssignee(newCase.getSender());
			}

			newCase.setCreator(currentUser);

			caseService.update(newCase);
		} catch (Throwable e) {
			addErrorMessage("My Work Queue", "Error Update Case. "
					+ e.getMessage());
		}
	}
}
