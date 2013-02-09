package com.vipro.utils.spring;

import java.util.Map;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;

import com.vipro.auth.AuthUser;
import com.vipro.dao.UserProfileDao;

/**
 * 
 * @author cvl
 *
 */
public final class FacesUtil {

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
}
