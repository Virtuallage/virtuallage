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
import java.util.Calendar;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

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

import com.sun.org.apache.xml.internal.serializer.ToUnknownStream;
import com.vipro.auth.AuthUser;
import com.vipro.constant.AccountStatusConst;
import com.vipro.constant.CaseStatus;
import com.vipro.constant.DocumentTypeConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.constant.PurchaseTypeConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.constant.ClaimStatusConst;
import com.vipro.constant.UserGroupConst;
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
import com.vipro.jsf.bean.mydesk.CaseAlert;
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
	private List<SelectItem> listProject;
	private List<ProjectInventory> inventories;
	private List<Account> accounts;
	private List<Account> salesCommissionAccounts;
	private List<Account> claim50PercentAccounts;
	private List<ProgressiveBilling> progressiveBillings;
	private List<SalesCommissionHistory> salesCommissionHistorys;

	private ProjectInventory inventory;
	private Long projectId;
	private Project project;
	private Account account;
	private Long accountId;
	private Customer accountCust;
	private BigDecimal totalClaimAmount;
	private UserProfile currentUser;
	
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
	
	public List<SelectItem> getListProject() {
		listProject = CodeUtil.getProjectAsItems();
		return listProject;
	}

	public void setListProject(List<SelectItem> listProject) {
		this.listProject = listProject;
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
	
	public String listProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projects = projectService.findAllProjects();
		
		return "salesCommission";
	}

	public String listAccounts(){
		listProject = CodeUtil.getProjectAsItems();
		
		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
		SalesCommissionHistoryService salesCommissionHistoryService = (SalesCommissionHistoryService) SpringBeanUtil.lookup(SalesCommissionHistoryService.class.getName());
		UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
		
		inventories = inventoryService.getAvailableInventories(projectId);

		AuthUser user = getCurrentUser();
		Long userId = user.getUserProfile().getUserId();
		UserProfile userProfile = userProfileService.findById(userId);
		
		/*for(ProjectInventory projectInventory: inventories)
		{
			List<Account> dataList = accountService.findByProjectInventoryId(projectInventory.getInventoryId());
			if(dataList != null && dataList.size() > 0) {
				if(userProfile.getUserGroup().getGroupId().equalsIgnoreCase(UserGroupConst.SALES_PIC) ||
						userProfile.getUserGroup().getGroupId().equalsIgnoreCase(UserGroupConst.ADMIN))
				{
					accounts.addAll(dataList);
				}
				else
				{
					for(Account data: dataList) {
						if(data.getAttendedBy().equals(userId))
						{
							accounts.add(data);
						}
					}
				}
			}
		}*/
		
		accounts = new ArrayList<Account>(); 
		List<Account> accountList = new ArrayList<Account>();
		if(userProfile.getUserGroup().getGroupId().equalsIgnoreCase(UserGroupConst.SALES_PIC) ||
				userProfile.getUserGroup().getGroupId().equalsIgnoreCase(UserGroupConst.ADMIN))
		{
			accountList = accountService.findAllAvailable();
		}
		else
		{
			accountList = accountService.findByAvailableUserId(userId);
		}
		
		for(ProjectInventory projectInventory: inventories)
		{
			List<Account> dataList = accountService.findByProjectInventoryId(projectInventory.getInventoryId());
			for(Account dl: dataList) {
				for(Account al: accountList) {
					if(dl.equals(al)) {
						accounts.add(al);
					}
					
				}
			}
		}
		

		salesCommissionHistorys = salesCommissionHistoryService.findAll();
				
		return "salesCommission";
	}
	
	public String GetFontColorByAttendedBy(String attendedByStr) {
		String fontColor = "Black";
		try {
			long attendedBy = Long.valueOf(attendedByStr);
			
			AuthUser user = getCurrentUser();
			long userId = user.getUserProfile().getUserId();
			
			if(attendedBy != userId){
				fontColor = "Grey";
			}
		} catch (Exception ex){
		}
		return fontColor;
	}
	
	public String GetClaimPercentByAccountId(String idStr){
		String percent = "100";
		try
		{
			Long id = Long.valueOf(idStr.trim());
			for (Account claim50PercentAccount : claim50PercentAccounts) {
				if(claim50PercentAccount.getAccountId().equals(id))
				{
					percent = "50";
					break;
				}
			}
		} 
		catch (Exception ex)
		{
		}
		return percent;
	}

	public String GetClaimAmountByPercent(String idStr, String totalCommission)
	{
		String output = "0.00";
		float amount = 0;
		try
		{
			String claimPercent = GetClaimPercentByAccountId(idStr);
			if(claimPercent != null && claimPercent.length() > 0) {
				float percent = Float.valueOf(claimPercent);
				float total = Float.valueOf(totalCommission);
				amount = total * percent / 100;
			} else {
				amount = Integer.valueOf(totalCommission);
			}

			output = amount + "";
			//DecimalFormat myFormatter = new DecimalFormat("###,###,###,###.00");
			//output = myFormatter.format(amount);
			
			float totalAmount = Float.valueOf(totalClaimAmount.toString());
			totalAmount += amount;
			totalClaimAmount = new BigDecimal(totalAmount);
			
		} 
		catch (Exception ex)
		{
		}
		
		return output;
	}
	
	public String GetClaimStatusByAccountId(String idStr) {
		String status = "New";

		Long id = Long.valueOf(idStr.trim());
		for(SalesCommissionHistory salesCommissionHistory: salesCommissionHistorys) {
			if(salesCommissionHistory.getAccount().getAccountId().equals(id)) {
				status = getCodeDesc("CO", salesCommissionHistory.getClaimStatus());
				/*if(salesCommissionHistory.getClaimStatus().equals(ClaimStatusConst.STATUS_SUBMITTED)) {
					status = "Submitted";
				}*/
				break;
			}
		}
		
		return status;
	}
	
	public String PriceDecimalFormat(String value) {
		String output = "";
		try
		{
			float fValue = Float.valueOf(value);
			DecimalFormat myFormatter = new DecimalFormat("###,###,###,##0.00");
			output = myFormatter.format(fValue);
		} 
		catch (Exception ex)
		{
		}
		return output;
	}
	
	public int DaysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	public String submit() {
		
		ProgressiveBillingService progressiveBillingService = (ProgressiveBillingService) SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
		
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
		AuthUser user = getCurrentUser();
		Long userId = user.getUserProfile().getUserId();
		
		salesCommissionAccounts = new ArrayList<Account>();
		claim50PercentAccounts = new ArrayList<Account>();
		totalClaimAmount = new BigDecimal(0);
		
		/*for(Account account: accounts) {
			String status = GetClaimStatusByAccountId(account.getAccountId().toString());
			if(status.equalsIgnoreCase("New")) {
				Date dateBilled = null;
				List<ProgressiveBilling> records = progressiveBillingService.getProgressiveBilling(account.getAccountId());
				for (ProgressiveBilling record : records) {
					dateBilled = record.getDateBilled();
				}
				if(dateBilled != null) {
					salesCommissionAccounts.add(account);
				} else {
					if(account.getSpaSignedDate() !=null && account.getSpaVerifiedBy() != null ) {
						if(account.getPurchaseType().equals(PurchaseTypeConst.CASH)) {
							salesCommissionAccounts.add(account);
						} else {
							if(account.getLaSignedDate() !=null && account.getLaVerifiedBy() != null) {
								salesCommissionAccounts.add(account);
							}
						}
					}
				}
			}
		}*/
		accounts = accountService.findByAvailableUserId(userId);
		for(Account account: accounts) {
			String status = GetClaimStatusByAccountId(account.getAccountId().toString());
			if(status.equalsIgnoreCase("New")) {
				if(account.getPurchaseType() != null && account.getPurchaseType().equals(PurchaseTypeConst.CASH)) {
					if(account.getSpaSignedDate() != null && account.getPurchaseType() != null) {
						Date secondBillingDatePaid = null;
						List<ProgressiveBilling> records = progressiveBillingService.getProgressiveBilling(account.getAccountId());
						/*int seqNo = 0;
						for (ProgressiveBilling record : records) {
							seqNo++;
							if(seqNo == 2) {
								secondBillingDatePaid = record.getDatePaid();
								break;
							}
						}
						if(records.size() >= 2 && secondBillingDatePaid != null)
						{
							salesCommissionAccounts.add(account);
						}*/
						if(records.size() >= 1) {
							secondBillingDatePaid = records.get(0).getDatePaid();
							if(secondBillingDatePaid != null)
							{
								salesCommissionAccounts.add(account);
							}
						}
					}
				} else {
					if(account.getSpaSignedDate() != null && account.getLaSignedDate() != null && account.getLoSignedDate() != null && 
					   account.getPurchaseType() != null && account.getPanelBankId() != null && account.getLoanAmount() != null) {
						/*Date secondBillingDatePaid = null;
						List<ProgressiveBilling> records = progressiveBillingService.getProgressiveBilling(account.getAccountId());*/
						salesCommissionAccounts.add(account);
						/*if(records.size() >= 0) {
							secondBillingDatePaid = records.get(0).getDatePaid();
							if(secondBillingDatePaid != null)
							{
								salesCommissionAccounts.add(account);
						}*/
					}
				}
			}
		}

		for(Account salesCommissionAccount: salesCommissionAccounts) {
			Date currentDate = new Date(); 
			if(salesCommissionAccount.getSpaSignedDate() != null && salesCommissionAccount.getLoSignedDate() != null) {
				if(salesCommissionAccount.getSpaSignedDate().before(salesCommissionAccount.getLoSignedDate())) {
					currentDate = salesCommissionAccount.getSpaSignedDate();
				} else {
					currentDate = salesCommissionAccount.getLoSignedDate(); 
				}
			} else if(salesCommissionAccount.getSpaSignedDate() != null) {
				currentDate = salesCommissionAccount.getSpaSignedDate();
			} else if(salesCommissionAccount.getLoSignedDate() != null) {
				currentDate = salesCommissionAccount.getSpaSignedDate();
			}
			
			Date purchasedDate = salesCommissionAccount.getDatePurchased();
			Calendar currentCal = Calendar.getInstance();
			currentCal.setTime(currentDate);
	        Calendar purchasedCal = Calendar.getInstance();
	        purchasedCal.setTime(purchasedDate);
	        
			if(DaysBetween(purchasedCal.getTime(), currentCal.getTime()) > 90) {
				claim50PercentAccounts.add(salesCommissionAccount);
			}
		}

		if (salesCommissionAccounts == null || salesCommissionAccounts.size() <= 0) {
			addInfoMessage("Warning!", "No Sales Commission is availeble to claim.");
			return listAccounts();
		}

		return "salesCommissionConfirmation";
	}
	
	public String confirm() {
		
		if (salesCommissionAccounts != null) {
			SalesCommissionHistoryService salesCommissionHistoryService =  (SalesCommissionHistoryService) SpringBeanUtil.lookup(SalesCommissionHistoryService.class.getName());
			SimpleDateFormat fmt = new SimpleDateFormat("yyMMddHHmmss");
			
			for(Account account: salesCommissionAccounts) {
				SalesCommissionHistory salesCommissionHistory = new SalesCommissionHistory();
				salesCommissionHistory.setAccount(account);
				salesCommissionHistory.setClaimStatus(ClaimStatusConst.STATUS_SUBMITTED);
				salesCommissionHistory.setDateSubmitted(new Date());
				try
				{
					String batchNo = account.getAttendedBy() + fmt.format(new Date());
					salesCommissionHistory.setBatchNo(Long.valueOf(batchNo));
				}
				catch(Exception ex){
				
				}
				
				BigDecimal claimPercent = new BigDecimal(100);
				String percent = GetClaimPercentByAccountId(account.getAccountId().toString());
				if(percent.equals("50")) {
					claimPercent = new BigDecimal(50);
				}
				salesCommissionHistory.setClaimPercent(claimPercent);
				
				BigDecimal claimAmount = new BigDecimal(0);
				String amount = GetClaimAmountByPercent(account.getAccountId().toString(), account.getCommissionAmount().toString());
				try
				{
					if(amount != null && amount.length() > 0) {
						claimAmount = new BigDecimal(amount);
					}
				}
				catch (Exception ex)
				{
				}
				salesCommissionHistory.setClaimAmount(claimAmount);

				AuthUser user = getCurrentUser();
				currentUser = user.getUserProfile();
				if (user != null)
					salesCommissionHistory.setSubmittedBy(user.getUserProfile().getUserId());
				
				salesCommissionHistory.setPurchasePrice(account.getPurchasePrice());
				salesCommissionHistory.setProjectId(projectId);
				salesCommissionHistoryService.update(salesCommissionHistory);
				
				accountId = account.getAccountId();
				accountCust = account.getCustomer();
				
				ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());
				ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
				UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
				AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
				
				project = projectService.findById(projectId);
				
				UserProfile toUserProfile = userProfileService.findById(project.getPicId());

				CaseAlert caseAlert = new CaseAlert();
				caseAlert.insertCase(CaseStatus.COMMISSION_CLAIM, projectId, accountId,
						currentUser, accountCust, "CSSMT", toUserProfile, null);
			}
			
			addInfoMessage("Sales Commission", "Submitted Successful.");

			return listAccounts();
		} else {
			addInfoMessage("Sales Commission", "Failed to submit.");
			return "salesCommissionConfirmation";
		}
	}
	
}
