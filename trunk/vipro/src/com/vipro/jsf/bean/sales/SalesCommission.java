package com.vipro.jsf.bean.sales;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import com.vipro.auth.AuthUser;
import com.vipro.constant.AccountStatusConst;
import com.vipro.constant.DocumentTypeConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.data.Account;
import com.vipro.data.SalesCommissionHistory;
import com.vipro.data.Customer;
import com.vipro.data.DocumentReference;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.SalesCancellationHistory;
import com.vipro.data.TransactionCode;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.data.ProgressiveBilling;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.SalesCommissionHistoryService;
import com.vipro.service.DocumentReferenceService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.SalesCancellationService;
import com.vipro.service.TransactionHistoryService;
import com.vipro.service.UserProfileService;
import com.vipro.service.ProgressiveBillingService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;


@ManagedBean(name = "salesCommission")
@SessionScoped
public class SalesCommission extends CommonBean implements Serializable{

	private List<Project> projects;
	private List<ProjectInventory> inventories;
	private List<Account> accounts;
	private List<Account> salesCommissionAccounts;
	private List<ProgressiveBilling> progressiveBillings;

	private ProjectInventory inventory;
	private Long projectId;
	private Project project;
	private Account account;
	private Long accountId;
	private BigDecimal totalClaimAmount;

	@PostConstruct
	public void init() {
		
	}
	
	public List<ProgressiveBilling> getProgressiveBillings() {
		return progressiveBillings;
	}

	public void setProgressiveBillings(List<ProgressiveBilling> progressiveBillings) {
		this.progressiveBillings = progressiveBillings;
	}
				
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<ProjectInventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<ProjectInventory> inventories) {
		this.inventories = inventories;
	}

	public ProjectInventory getInventory() {
		return inventory;
	}

	public void setInventory(ProjectInventory inventory) {
		this.inventory = inventory;
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

	public List<Account> getSalesCommissionAccounts() {
		return this.salesCommissionAccounts;
	}

	public void setSalesCommissionAccounts(List<Account> salesCommissionAccounts) {
		this.salesCommissionAccounts = salesCommissionAccounts;
	}

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public List<Account> getAccounts() {
		listAccounts();
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public BigDecimal getTotalClaimAmount() {
		return totalClaimAmount;
	}

	public void setTotalClaimAmount(BigDecimal totalClaimAmount) {
		this.totalClaimAmount = totalClaimAmount;
	}

	public String listAccounts(){
		AccountService accountService = (AccountService) SpringBeanUtil
				.lookup(AccountService.class.getName());

		accounts = accountService.findAll();
				
		return "salesCommission";
	}
	
	public String submit() {
		
		ProgressiveBillingService progressiveBillingService = (ProgressiveBillingService) SpringBeanUtil
				.lookup(ProgressiveBillingService.class.getName());

		salesCommissionAccounts = new ArrayList<Account>();
		for(Account account: accounts) {
			if(account.getSpaStampedDate() !=null) {
				if(account.getLaStampedDate() !=null) {
					salesCommissionAccounts.add(account);
				} else {
					Date dateBilled = null;
					List<ProgressiveBilling> records = progressiveBillingService.getProgressiveBilling(account.getProjectInventory().getInventoryId());
					for (ProgressiveBilling record : records) {
						dateBilled = record.getDateBilled();
					}
					if(dateBilled != null) {
						salesCommissionAccounts.add(account);
					}
				}
			}
		}
		
		if (salesCommissionAccounts == null || salesCommissionAccounts.size() <= 0) {
			addInfoMessage("Sales Commission", "There is nothing to claim.");
			return listAccounts();
		}
		
		return "salesCommissionConfirmation";
	}
	
	public String confirm() {
		
		if (salesCommissionAccounts != null) {
			SalesCommissionHistoryService salesCommissionHistoryService =  (SalesCommissionHistoryService) SpringBeanUtil.lookup(SalesCommissionHistoryService.class.getName());
			
			for(Account account: salesCommissionAccounts) {
				SalesCommissionHistory salesCommissionHistory = new SalesCommissionHistory();
				salesCommissionHistory.setAccount(account);
			
				salesCommissionHistoryService.update(salesCommissionHistory);
			}
			
			addInfoMessage("Sales Commission", "Claim submited.");
			return listAccounts();
		} else {
			addInfoMessage("Sales Commission", "Failed to submit.");
			return "salesCommissionConfirmation";
		}
	}
	
}
