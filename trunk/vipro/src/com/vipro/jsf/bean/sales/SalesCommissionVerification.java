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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.vipro.data.Project;
import com.vipro.auth.AuthUser;
import com.vipro.constant.BusinessPartnerTypeConst;
import com.vipro.constant.DocumentTypeConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.constant.ClaimStatusConst;
import com.vipro.data.Account;
import com.vipro.data.Customer;
import com.vipro.data.DocumentReference;
import com.vipro.data.SalesCommissionHistory;
import com.vipro.data.TransactionCode;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.DocumentReferenceService;
import com.vipro.service.ProjectService;
import com.vipro.service.SalesCommissionHistoryService;
import com.vipro.service.TransactionHistoryService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;


@ManagedBean(name = "salesCommissionVerification")
@SessionScoped
public class SalesCommissionVerification extends CommonBean implements Serializable{

	private List<Account> salesCommissionAccounts;
	private List<SalesCommissionHistory> salesCommissionHistorys;
	private List<DocumentReference> documentReferences;

	private Project project;
	private BigDecimal totalClaimAmount;
	private Account salesCommissionAccount;
	private SalesCommissionHistory salesCommissionHistory;
	private List<Customer> availableCustomers;
	private DocumentReference documentReference;
	private StreamedContent file;
	
	private List<SelectItem> purchaseTypes;
	private List<SelectItem> propertyTypes;
	private List<SelectItem> listSolicitors = null;
	private List<SelectItem> listPanelBanks = null;

	@PostConstruct
	public void init() {
		
		purchaseTypes = CodeUtil.getCodes("PU");
		propertyTypes = CodeUtil.getCodes("PT");
		listSolicitors = CodeUtil.getBusinessPartnerAsItems(BusinessPartnerTypeConst.SOLICITOR);
		listPanelBanks = CodeUtil.getBusinessPartnerAsItems(BusinessPartnerTypeConst.BANK);
	}
	
	public List<SelectItem> getPurchaseTypes() {
		return purchaseTypes;
	}

	public void setPurchaseTypes(List<SelectItem> purchaseTypes) {
		this.purchaseTypes = purchaseTypes;
	}
	
	public List<SelectItem> getPropertyTypes() {
		return propertyTypes;
	}

	public void setPropertyTypes(List<SelectItem> propertyTypes) {
		this.propertyTypes = propertyTypes;
	}
	
	public List<SelectItem> getListPanelBanks() {
		return listPanelBanks;
	}

	public void setListPanelBanks(List<SelectItem> listPanelBanks) {
		this.listPanelBanks = listPanelBanks;
	}
	
	public List<SelectItem> getListSolicitors() {
		return listSolicitors;
	}

	public void setListSolicitors(List<SelectItem> listSolicitors) {
		this.listSolicitors = listSolicitors;
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
	
	public List<SalesCommissionHistory> getSalesCommissionHistorys() {
		listAccounts();
		return this.salesCommissionHistorys;
	}
	
	public Account getSalesCommissionAccount() {
		return this.salesCommissionAccount;
	}

	public void setSalesCommissionAccount(Account salesCommissionAccount) {
		this.salesCommissionAccount = salesCommissionAccount;
	}

	public void setSalesCommissionHistorys(List<SalesCommissionHistory> salesCommissionHistorys) {
		this.salesCommissionHistorys = salesCommissionHistorys;
	}
	
	public SalesCommissionHistory getSalesCommissionHistory() {
		return this.salesCommissionHistory;
	}

	public void setSalesCommissionHistory(SalesCommissionHistory salesCommissionHistory) {
		this.salesCommissionHistory = salesCommissionHistory;
	}
	
	public List<Customer> getAvailableCustomers() {
		return availableCustomers;
	}

	public void setAvailableCustomers(List<Customer> availableCustomers) {
		this.availableCustomers = availableCustomers;
	}
	
	public BigDecimal getTotalClaimAmount() {
		return totalClaimAmount;
	}

	public void setTotalClaimAmount(BigDecimal totalClaimAmount) {
		this.totalClaimAmount = totalClaimAmount;
	}
	
	public List<DocumentReference> getDocumentReferences() {
		return this.documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}
	
	public DocumentReference getDocumentReference() {
		return this.documentReference;
	}

	public void setDocumentReference(DocumentReference documentReference) {
		this.documentReference = documentReference;
	}
	
	public StreamedContent getFile() {  
		
		String path ="/accounts/" + salesCommissionAccount.getAccountId() + "/" + documentReference.getDocType() + "/" + documentReference.getFilename();
		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);  
        file = new DefaultStreamedContent(stream, documentReference.getFilename(), documentReference.getFilename()); 
        
        return file;  
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
			SalesCommissionHistoryService salesCommissionHistoryService = (SalesCommissionHistoryService) SpringBeanUtil.lookup(SalesCommissionHistoryService.class.getName());
			List<SalesCommissionHistory> historyList = salesCommissionHistoryService.findByAccountId(id);
			if(historyList.size() > 0)
			{
				if(historyList.get(0).getClaimPercent().toString().equalsIgnoreCase("50") || historyList.get(0).getClaimPercent().toString().equalsIgnoreCase("50.00"))
				{
					percent = "50";
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

			float totalAmount = Float.valueOf(totalClaimAmount.toString());
			totalAmount += amount;
			totalClaimAmount = new BigDecimal(totalAmount);
			
		} 
		catch (Exception ex)
		{
		}
		
		return output;
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
	
	public String verifyByUserId(String userIdStr) {
		String verified = userIdStr;
		try
		{
			Long userId = Long.valueOf(userIdStr);
			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
			UserProfile userProfie = userProfileService.findById(userId);
			if(userProfie != null) {
				verified = userProfie.getName();
			}
		} catch (Exception ex)
		{
		}
		return verified;
	}
	
	public void listSPADocumentType() {
		DocumentReferenceService documentReferenceService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		documentReferences = documentReferenceService.findByAccountIdAndDocType(salesCommissionAccount.getAccountId(), DocumentTypeConst.SPA);
	}
	
	public void listLODocumentType() {
		DocumentReferenceService documentReferenceService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		documentReferences = documentReferenceService.findByAccountIdAndDocType(salesCommissionAccount.getAccountId(), DocumentTypeConst.LO);
	}
	
	public void listLADocumentType() {
		DocumentReferenceService documentReferenceService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		documentReferences = documentReferenceService.findByAccountIdAndDocType(salesCommissionAccount.getAccountId(), DocumentTypeConst.LA);
	}
	
	public String listAccounts(){
		salesCommissionHistorys = new ArrayList<SalesCommissionHistory>();
		
		SalesCommissionHistoryService salesCommissionHistoryService = (SalesCommissionHistoryService) SpringBeanUtil.lookup(SalesCommissionHistoryService.class.getName());
		List<SalesCommissionHistory> historyList = salesCommissionHistoryService.findAll();
		List<Long> batchNoList = new ArrayList<Long>();
		for(SalesCommissionHistory history: historyList)
		{
			if(!batchNoList.contains(history.getBatchNo()))
			{
				batchNoList.add(history.getBatchNo());
			}
		}
		
		for(Long batchNo: batchNoList)
		{
			List<SalesCommissionHistory> historyBatchNoList = salesCommissionHistoryService.findByBatchNo(batchNo);
			if(historyBatchNoList != null && historyBatchNoList.size() > 0)
			{
				float totalPurchasePrice = 0;
				float totalClaimAmount = 0;
				boolean isSubmitted = false;
				SalesCommissionHistory historyBatchNo = new SalesCommissionHistory();
				for(int x=0; x< historyBatchNoList.size(); x++)
				{
					historyBatchNo = historyBatchNoList.get(x);
					totalPurchasePrice = totalPurchasePrice + Float.valueOf(historyBatchNo.getPurchasePrice().toString());
					historyBatchNo.setPurchasePrice(new BigDecimal(totalPurchasePrice));
					
					totalClaimAmount = totalClaimAmount + Float.valueOf(historyBatchNo.getClaimAmount().toString());
					historyBatchNo.setClaimAmount(new BigDecimal(totalClaimAmount));
					
					if(historyBatchNo.getClaimStatus().equals(ClaimStatusConst.STATUS_SUBMITTED)) {
						isSubmitted = true;
					}
				}
				
				if(isSubmitted) {
					salesCommissionHistorys.add(historyBatchNo);
				}
			}
		}
			
		return "salesCommissionVerification";
	}
	
	public String selectAccount() {
		
		availableCustomers = new ArrayList<Customer>();
		
		if (salesCommissionAccount.getCustomer() != null) {
			availableCustomers.add(salesCommissionAccount.getCustomer());
		}
		if (salesCommissionAccount.getCustomer2() != null) {
			availableCustomers.add(salesCommissionAccount.getCustomer2());
		}
		if (salesCommissionAccount.getCustomer3() != null) {
			availableCustomers.add(salesCommissionAccount.getCustomer3());
		}
		if (salesCommissionAccount.getCustomer4() != null) {
			availableCustomers.add(salesCommissionAccount.getCustomer4());
		}
		if (salesCommissionAccount.getCustomer5() != null) {
			availableCustomers.add(salesCommissionAccount.getCustomer5());
		}
		
		ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());
		project = projectService.findById(salesCommissionAccount.getProjectInventory().getProject().getProjectId());

		return "salesCommissionUpdate";
	}
	
	public String submit() {

		salesCommissionAccounts = new ArrayList<Account>();
		totalClaimAmount = new BigDecimal(0);
		
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
		SalesCommissionHistoryService salesCommissionHistoryService = (SalesCommissionHistoryService) SpringBeanUtil.lookup(SalesCommissionHistoryService.class.getName());
		List<SalesCommissionHistory> historyList = salesCommissionHistoryService.findByBatchNo(salesCommissionHistory.getBatchNo());
		
		for(SalesCommissionHistory history: historyList) {
			Long accountId = history.getAccount().getAccountId();
			Account account = accountService.findById(accountId);
			
			if(history.getClaimStatus().equalsIgnoreCase(ClaimStatusConst.STATUS_SUBMITTED)) {
				salesCommissionAccounts.add(account);
			}
		}
		
		if (salesCommissionAccounts == null || salesCommissionAccounts.size() <= 0) {
			addInfoMessage("Sales Commission Approval", "There is nothing claim to approve.");
			return listAccounts();
		}
		
		return "salesCommissionConfirmationVerification";
	}
	
	public String back() {
		return "salesCommissionConfirmationVerification";
	}
	
	public String reject() {
		
		if (salesCommissionAccount != null) {
			Date currentDate = new Date();
			AuthUser user = getCurrentUser();
			Long userId = user.getUserProfile().getUserId();
			SalesCommissionHistoryService salesCommissionHistoryService = (SalesCommissionHistoryService) SpringBeanUtil.lookup(SalesCommissionHistoryService.class.getName());
			List<SalesCommissionHistory> historys = salesCommissionHistoryService.findByAccountId(salesCommissionAccount.getAccountId());
			
			if(historys != null && historys.size() > 0)
			{
				SalesCommissionHistory history = historys.get(historys.size() - 1);
				history.setChangedBy(userId);
				history.setDateChanged(currentDate);
				history.setClaimStatus(ClaimStatusConst.STATUS_REJECTED);
				
				salesCommissionHistoryService.update(history);
				
				addInfoMessage("Sales Commission Verification", "Commission Rejected.");
				return listAccounts();
			}
		}
		
		addInfoMessage("Sales Commission Verification", "Failed to reject commission.");
		return listAccounts();
	}
	
	public String approve() {
		
		if (salesCommissionAccount != null) {
			Date currentDate = new Date();
			AuthUser user = getCurrentUser();
			Long userId = user.getUserProfile().getUserId();
			SalesCommissionHistoryService salesCommissionHistoryService = (SalesCommissionHistoryService) SpringBeanUtil.lookup(SalesCommissionHistoryService.class.getName());
			List<SalesCommissionHistory> historys = salesCommissionHistoryService.findByAccountId(salesCommissionAccount.getAccountId());
			
			if(historys != null && historys.size() > 0)
			{
				SalesCommissionHistory history = historys.get(historys.size() - 1);
				history.setApprovedBy(userId);
				history.setDateApproved(currentDate);
				history.setChangedBy(userId);
				history.setDateChanged(currentDate);
				history.setClaimStatus(ClaimStatusConst.STATUS_VERIFIED);
				
				salesCommissionHistoryService.update(history);
				addInfoMessage("Sales Commission Verification", "Commission Approved.");
				return listAccounts();
			}

		}
		
		addInfoMessage("Sales Commission Verification", "Failed to approve commission.");
		return listAccounts();
	}

}
