package com.vipro.utils.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;


import com.vipro.data.Institution;
import com.vipro.data.UserProfile;
import com.vipro.service.CodeService;
import com.vipro.service.InstitutionService;
import com.vipro.service.UserProfileService;

public final class CodeUtil {
	
	public static List<SelectItem> getCodes(String codeId) {
		CodeService codeService = (CodeService) SpringBeanUtil.lookup(CodeService.class.getName());
		return codeService.getCodes(codeId);
	}
	
	public static List<SelectItem> getInstitutionAsItems() {
		InstitutionService institutionService = (InstitutionService) SpringBeanUtil.lookup(InstitutionService.class.getName());
		List<Institution> ins = institutionService.findAllActive();
		List<SelectItem> insItems = new ArrayList<SelectItem>();
		insItems.add( new SelectItem(null, "Select One"));
		for (Institution i : ins) {
			insItems.add( new SelectItem(i.getInstitutionId().toString(), i.getInstitutionName()) );
		}
		
		return insItems;
	}
	
	
	public static List<SelectItem> getUsersAsItems() {
		UserProfileService userService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
		List<UserProfile> users = userService.findAll();
		
		List<SelectItem> items = new ArrayList<SelectItem>();
		if (users!=null) {
			for (UserProfile u : users) {
				items.add( new SelectItem( u.getUserId().toString(), u.getName()));
			}
		}
		
		return items;
	}

}
