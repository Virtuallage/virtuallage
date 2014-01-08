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

import org.primefaces.component.commandbutton.CommandButton;

import com.vipro.data.Project;
import com.vipro.auth.AuthUser;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.constant.ClaimStatusConst;
import com.vipro.data.Account;
import com.vipro.data.SalesCommissionHistory;
import com.vipro.data.TransactionCode;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.jsf.bean.mydesk.CaseAlert;
import com.vipro.service.AccountService;
import com.vipro.service.ProjectService;
import com.vipro.service.SalesCommissionHistoryService;
import com.vipro.service.TransactionHistoryService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.SpringBeanUtil;


@ManagedBean(name = "salesCommissionApproval")
@SessionScoped
public class SalesCommissionApproval extends CommonBean implements Serializable{

	private List<Account> salesCommissionAccounts;
	private List<SalesCommissionHistory> salesCommissionHistorys;

	private BigDecimal totalClaimAmount;
	private SalesCommissionHistory salesCommissionHistory;
	private UserProfile currentUser;
	//private CommandButton approveButton;

	@PostConstruct
	public void init() {
		//approveButton = new CommandButton();
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

	public void setSalesCommissionHistorys(List<SalesCommissionHistory> salesCommissionHistorys) {
		this.salesCommissionHistorys = salesCommissionHistorys;
	}
	
	public SalesCommissionHistory getSalesCommissionHistory() {
		return this.salesCommissionHistory;
	}

	public void setSalesCommissionHistory(SalesCommissionHistory salesCommissionHistory) {
		this.salesCommissionHistory = salesCommissionHistory;
	}

	/*public CommandButton getApproveButton() {
		return approveButton;
	}

	public void setApproveButton(CommandButton approveButton) {
		this.approveButton = approveButton;
	}*/
	
	public BigDecimal getTotalClaimAmount() {
		return totalClaimAmount;
	}

	public void setTotalClaimAmount(BigDecimal totalClaimAmount) {
		this.totalClaimAmount = totalClaimAmount;
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
	
	public String GetProjectNameBy(String projectId) {
		String result = "";
		
		try {
			long id = Long.valueOf(projectId);
			result = GetProjectNameBy(id);
		} catch (Exception ex) {}
		
		return result;
	}
	
	public String GetProjectNameBy(Long projectId) {
		String result = "";
		
		ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());
		Project project = projectService.findById(projectId);
		
		if(project != null) {
			result = project.getProjectName();
		}
		
		return result;
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
				boolean isVerified = false;
				SalesCommissionHistory historyBatchNo = new SalesCommissionHistory();
				for(int x=0; x< historyBatchNoList.size(); x++)
				{
					historyBatchNo = historyBatchNoList.get(x);
					if(historyBatchNo.getClaimStatus().equalsIgnoreCase(ClaimStatusConst.STATUS_VERIFIED)) {
						isVerified = true;
						totalPurchasePrice = totalPurchasePrice + Float.valueOf(historyBatchNo.getPurchasePrice().toString());
						historyBatchNo.setPurchasePrice(new BigDecimal(totalPurchasePrice));
						
						totalClaimAmount = totalClaimAmount + Float.valueOf(historyBatchNo.getClaimAmount().toString());
						historyBatchNo.setClaimAmount(new BigDecimal(totalClaimAmount));
					}
				}
				if(isVerified) {
					salesCommissionHistorys.add(historyBatchNo);
				}
			}
		}
			
		return "salesCommissionApproval";
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
			
			if(history.getClaimStatus().equalsIgnoreCase(ClaimStatusConst.STATUS_VERIFIED)) {
				salesCommissionAccounts.add(account);
			}
		}
		
		/*if(salesCommissionHistory.getClaimStatus().equalsIgnoreCase(ClaimStatusConst.STATUS_VERIFIED))
		{
			approveButton.setStyle("");
		}
		else
		{
			approveButton.setStyle("display: none");
		}*/
		
		if (salesCommissionAccounts == null || salesCommissionAccounts.size() <= 0) {
			addInfoMessage("Sales Commission Approval", "There is nothing claim to approve.");
			return listAccounts();
		}
		
		return "salesCommissionConfirmationApproval";
	}
	
	public String confirm() {
		
		if (salesCommissionAccounts != null) {
			Long accountId = null;
			Date currentDate = new Date();
			for(Account salesCommissionAccount: salesCommissionAccounts)
			{
				AuthUser user = getCurrentUser();
				currentUser = user.getUserProfile();
				Long userId = user.getUserProfile().getUserId();
				accountId = salesCommissionAccount.getAccountId();
				SalesCommissionHistoryService salesCommissionHistoryService = (SalesCommissionHistoryService) SpringBeanUtil.lookup(SalesCommissionHistoryService.class.getName());
				List<SalesCommissionHistory> historys = salesCommissionHistoryService.findByAccountId(salesCommissionAccount.getAccountId());
				if(historys != null && historys.size() > 0)
				{
					SalesCommissionHistory history = historys.get(0);
					history.setApprovedBy(userId);
					history.setDateApproved(currentDate);
					history.setChangedBy(userId);
					history.setDateChanged(currentDate);
					history.setClaimStatus(ClaimStatusConst.STATUS_APPROVED);
					
					salesCommissionHistoryService.update(history);
					
					TransactionHistoryService transactionHistoryService = (TransactionHistoryService) SpringBeanUtil.lookup(TransactionHistoryService.class.getName());
					TransactionHistory transactionHistory = new TransactionHistory();
					TransactionCode code = new TransactionCode();
					code.setTransactionCode(TransactionCodeConst.COMMISSION_FEE);
					transactionHistory.setTransactionCode(code);
					transactionHistory.setTransactionDate(currentDate);
					transactionHistory.setTransactionDescription("Commission Fee");
					transactionHistory.setStatus(TransactionStatusConst.PENDING);
					transactionHistory.setAmount(totalClaimAmount);
					transactionHistory.setAccount(salesCommissionAccount);
					transactionHistory.setRefNo(salesCommissionHistory.getBatchNo().toString());
					transactionHistoryService.insert(transactionHistory);
				}

				CaseAlert caseAlert = new CaseAlert();
				caseAlert.updateCase("CYCOM", salesCommissionHistory.getProjectId(), accountId,	
						currentUser, "CSAPP", null, null);
			}
			
			addInfoMessage("Sales Commission", "Commission Approved.");
			return "salesCommissionApproval";
			
		} else {
			addInfoMessage("Sales Commission", "Failed to approve commission.");
			return "salesCommissionConfirmationApproval";
		}
	}
	
}
