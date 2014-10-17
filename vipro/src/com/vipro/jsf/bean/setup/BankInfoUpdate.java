package com.vipro.jsf.bean.setup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.model.StreamedContent;
import org.primefaces.component.inputtext.InputText;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CommonConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.data.Project;
import com.vipro.data.BankAccount;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.BankAccountService;
import com.vipro.service.ProjectService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.util.StringUtils;

@ManagedBean(name="bankInfoUpdate")
@SessionScoped
public class BankInfoUpdate extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6876397449143136685L;
	private List<Project> projects;
	private List<BankAccount> bankAccounts;
	private List<SelectItem> listProject;
	private List<SelectItem> statusList;
	
	private BankAccount bankAccount;
	private Long projectId;
	private Project project;
		
	@PostConstruct
	public void init() {
		statusList = CodeUtil.getCodes("SS");
	}
	

	public String listProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projects = projectService.findAllProjects();
		
		return "unitList";
	}

	public String listBankInfo(){
		listProject = CodeUtil.getProjectAsItems();

		ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());	
		BankAccountService bankAccountService = (BankAccountService) SpringBeanUtil.lookup(BankAccountService.class.getName());	
		
		project = projectService.findById(projectId);
		
		if(project != null){
			bankAccounts = bankAccountService.findByProjectId(projectId);
		}
		
		return "bankInfoList";
	}
	
	public String selectBankInfo() {

		
		return "editBankInfo";
		
	}
	
	public String saveBankInfo() {

		if (!bankAccount.getBillTo().equalsIgnoreCase("F")) {
			if (!bankAccount.getBillTo().equalsIgnoreCase("P")) {
				addErrorMessage("WARNING!",	"Please key in either P or F.");
				return selectBankInfo();
			}
		}
		
		String tempBillTo = bankAccount.getBillTo();
		bankAccount.setBillTo(tempBillTo.toUpperCase());
		
		BankAccountService bankAccountService = (BankAccountService) SpringBeanUtil.lookup(BankAccountService.class.getName());			

		AuthUser user = getCurrentUser();
		bankAccount.setChangedBy(user.getUserProfile().getUserId());
		bankAccount.setDateChanged(new Date());
		bankAccountService.update(bankAccount);

		addInfoMessage("INFORMATION", "Billing Account Information Updated Successfully.");
		return listBankInfo();
		
	}
	
	public List<SelectItem> getstatusList() {
		return statusList;
	}

	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}
	
	public List<SelectItem> getListProject() {
		listProject = CodeUtil.getProjectAsItems();
		return listProject;
	}

	public void setListProject(List<SelectItem> listProject) {
		this.listProject = listProject;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
