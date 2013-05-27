package com.vipro.utils.spring;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.data.BusinessPartner;
import com.vipro.data.CodeDet;
import com.vipro.data.CodeHeader;
import com.vipro.data.Institution;
import com.vipro.data.Project;
import com.vipro.data.UserProfile;
import com.vipro.service.BusinessPartnerService;
import com.vipro.service.CodeService;
import com.vipro.service.InstitutionService;
import com.vipro.service.ProjectService;
import com.vipro.service.UserProfileService;

public final class CodeUtil {
	
	public static CodeHeader getCodeHeader(String codeHeaderId) {
		CodeService codeService = (CodeService) SpringBeanUtil.lookup(CodeService.class.getName());
		return codeService.findById(codeHeaderId);
	}
	
	public static List<SelectItem> getCodeHeaders() {
		CodeService codeService = (CodeService) SpringBeanUtil.lookup(CodeService.class.getName());
		return codeService.getCodeHeaders();
	}
	
	public static List<SelectItem> getCodes(String codeId) {
		CodeService codeService = (CodeService) SpringBeanUtil.lookup(CodeService.class.getName());
		return codeService.getCodes(codeId);
	}
	
	public static List<CodeDet> getCodeDetailList(String codeId) {
		CodeService codeService = (CodeService) SpringBeanUtil.lookup(CodeService.class.getName());
		return codeService.getCodeDetailList(codeId);
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
	
	public static List<SelectItem> getProjectAsItems() {
		ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());
		List<Project> project = projectService.findAllProjects();
		List<SelectItem> projItems = new ArrayList<SelectItem>();
		projItems.add( new SelectItem(null, "Select One"));
		for (Project p : project) {
			projItems.add( new SelectItem(p.getProjectId(), p.getProjectName()) );
		}
		
		return projItems;
	}
	
	
	public static List<SelectItem> getUsersAsItems() {
		UserProfileService userService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
		List<UserProfile> users = userService.findAll();
		
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add( new SelectItem(null, "Select One"));
		if (users!=null) {
			for (UserProfile u : users) {
				items.add( new SelectItem( u.getUserId().toString(), u.getName()));
			}
		}
		
		return items;
	}

	public static List<SelectItem> getPropertyStatusAsItems() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add( new SelectItem(PropertyUnitStatusConst.STATUS_ACTIVE, "Available") );
		list.add( new SelectItem(PropertyUnitStatusConst.STATUS_DISABLED, "Not Available"));
		list.add( new SelectItem(PropertyUnitStatusConst.STATUS_IN_PROGRESS, "In Progress"));
		list.add( new SelectItem(PropertyUnitStatusConst.STATUS_BOOKED, "Booked") );
		list.add( new SelectItem(PropertyUnitStatusConst.STATUS_SOLD, "Sold"));
		
		return list;
	}
	
	public static List<SelectItem> getBusinessPartnerAsItems(String partnerType) {
		BusinessPartnerService partnerService = (BusinessPartnerService) 
				SpringBeanUtil.lookup(BusinessPartnerService.class.getName());
		List<BusinessPartner> partners = partnerService.findByPartnerType(partnerType);
		
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add( new SelectItem(null, "Select One"));
		if (partners!=null) {
			for (BusinessPartner u : partners) {
				items.add( new SelectItem( u.getPartnerId(), u.getCompanyName()));
			}
		}
		
		return items;
	}

}
