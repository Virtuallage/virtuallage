package com.vipro.jsf.bean;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;

import com.vipro.auth.AuthUser;
import com.vipro.dao.UserProfileDao;
import com.vipro.data.CodeDet;
import com.vipro.service.CodeService;
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
