package com.vipro.jsf.bean;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;

import com.vipro.auth.AuthUser;
import com.vipro.dao.UserProfileDao;
import com.vipro.data.CaseLink;
import com.vipro.data.CodeDet;
import com.vipro.data.Customer;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.mydesk.CaseAlert;
import com.vipro.jsf.bean.mydesk.MyDesk;
import com.vipro.service.CaseLinkService;
import com.vipro.service.CodeService;
import com.vipro.service.CustomerService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.SpringBeanUtil;
import com.vipro.constant.*;

public class CommonBean {

	public String getDateFormat(){
		return CommonConst.DATE_FROMAT;
	}
	
	public String getTimeZone(){
		return CommonConst.TIME_ZONE;
	}
	
	public String getCodeDesc(String codeType, String code) {
		CodeService codeService = (CodeService) SpringBeanUtil.lookup(CodeService.class.getName());
		List<CodeDet> list = codeService.getCodeDetailList(codeType);
		

		for (CodeDet d : list) {
			if (d.getId().getCode().equals(code)) {
				return d.getDescription();
			}
		}
		
		return code;
	}
	
	public String getUserName(Long userId){
		if(userId == 0)
			return "";
		
		UserProfileService userProfile = (UserProfileService) SpringBeanUtil
				.lookup(UserProfileService.class.getName());
		UserProfile user = userProfile.findById(userId);
		
		return user.getName();
	}
	
	public String getCustName(Long custId) {
		CustomerService custService = (CustomerService) SpringBeanUtil.lookup(CustomerService.class.getName());
		Customer cust = custService.findByCustId(custId);
		
		String fullName = cust.getFullName();
		
		return fullName;
	}
	
	public String getCaseLink(String caseType, Long projectId, Long accountId, String caseStatus) {
		CaseLinkService caseLinkService = (CaseLinkService) SpringBeanUtil.lookup(CaseLinkService.class.getName());
		List<CaseLink> list = caseLinkService.getCaseLinkList(caseType, caseStatus);

		AuthUser user = getCurrentUser();
		CaseAlert caseAlert = new CaseAlert();
		caseAlert.openCase(caseType, projectId, accountId,
				user.getUserProfile(), "CSOPN");
		for (CaseLink d : list) {
			if (d.getCaseType().equals(caseType)) {
				return d.getCaseLink();
			}
		}
		
		
		
		return caseType;
	}

	public static AuthUser getCurrentUser() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		UserProfileDao userService = (UserProfileDao) SpringBeanUtil.lookup(UserProfileDao.class.getName());
		SecurityContextImpl ctx = (SecurityContextImpl) session.get("SPRING_SECURITY_CONTEXT");
		if (ctx!=null) {
			Authentication auth = ctx.getAuthentication();
			if (auth!=null) {
				AuthUser authUser = (AuthUser) auth.getPrincipal();
				return authUser;
			}
		}
		return null;
	}
	
	public static void addInfoMessage(String summary, String message) {
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, summary, message));
	}
	
	public static void addErrorMessage(String summary, String message) {
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, message));
		
	}
	
	public String getFileType(String filename) {
		
		if (filename==null) {
			return null;
		}
		
		if (filename.toLowerCase().endsWith(".pdf")) {
			return "adobe/pdf";
		} else if (filename.toLowerCase().endsWith(".doc") || filename.toLowerCase().endsWith(".docx")) {
			return "doc";
		} else if (filename.toLowerCase().endsWith(".jpg")) {
			return "image/jpeg";
		}
		
		return null;
	}
	
}
