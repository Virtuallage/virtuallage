package com.vipro.jsf.bean.sales;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.util.StringUtils;

import com.vipro.auth.AuthUser;
import com.vipro.constant.AccountStatusConst;
import com.vipro.constant.CaseStatus;
import com.vipro.constant.CommonConst;
import com.vipro.constant.DocumentTypeConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.constant.CancelStatusConst;
import com.vipro.data.AdjHeader;
import com.vipro.data.AdjLog;
import com.vipro.data.Account;
import com.vipro.data.SalesCancellationHistory;
import com.vipro.data.Customer;
import com.vipro.data.DocumentReference;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.TransactionCode;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.jsf.bean.mydesk.CaseAlert;
import com.vipro.service.AdjHeaderService;
import com.vipro.service.AdjLogService;
import com.vipro.service.AccountService;
import com.vipro.service.SalesCancellationService;
import com.vipro.service.DocumentReferenceService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.TransactionHistoryService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;


@ManagedBean(name = "salesCancelApproval")
@SessionScoped
public class SalesCancelApproval extends CommonBean implements Serializable{

	private List<SelectItem> cancelReasons;
	private List<Project> projects;
	private List<ProjectInventory> inventories;
	private List<SelectItem> listProject;
	private List<DocumentReference> documentReferences;

	private ProjectInventory inventory;
	private Long projectId;
	private Project project;

	private String customerNames;
	private List<Customer> customers;
	private Account account;
	private UserProfile attendedBy;
	private DocumentReference documentReference;
	private SalesCancellationHistory salesCancellationHistory;
	private AdjHeader adjHeader;
	private List<AdjHeader> adjHeaders;
	private AdjLog adjLog;
	private String dialogConfirmationName;
		
	private double TaxCharge = 0.02;
	private double AdminFee = 500;
	
	private BigDecimal totalAdjustedAmount = new BigDecimal(0);

	private StreamedContent file;  
	private CommandButton approveButton;
	private UserProfile currentUser;
	
	@PostConstruct
	public void init() {
		approveButton = new CommandButton();
		cancelReasons = CodeUtil.getCodes("CR");
	}

	public List<SelectItem> getListProject() {
		listProject = CodeUtil.getProjectAsItems();
		return listProject;
	}

	public void setListProject(List<SelectItem> listProject) {
		this.listProject = listProject;
	}

	public List<SelectItem> getCancelReasons() {
		return cancelReasons;
	}

	public void setCancelReasons(List<SelectItem> cancelReasons) {
		this.cancelReasons = cancelReasons;
	}
	
	public String getCustomerNames() {
		return customerNames;
	}

	public void setCustomerNames(String customerNames) {
		this.customerNames = customerNames;
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

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public SalesCancellationHistory getSalesCancellationHistory() {
		return salesCancellationHistory;
	}

	public void setSalesCancellationHistory(SalesCancellationHistory salesCancellationHistory) {
		this.salesCancellationHistory = salesCancellationHistory;
	}
	
	public AdjHeader getAdjHeader() {
		return adjHeader;
	}

	public void setAdjHeader(AdjHeader adjHeader) {
		this.adjHeader = adjHeader;
	}
	
	public List<AdjHeader> getAdjHeaders() {
		return adjHeaders;
	}

	public void setAdjHeaders(List<AdjHeader> adjHeaders) {
		this.adjHeaders = adjHeaders;
	}
	
	public AdjLog getAdjLog() {
		return adjLog;
	}

	public void setAdjLog(AdjLog adjLog) {
		this.adjLog = adjLog;
	}
	
	public String getDialogConfirmationName() {
		return dialogConfirmationName;
	}

	public void setDialogConfirmationName(String dialogConfirmationName) {
		this.dialogConfirmationName = dialogConfirmationName;
	}

	public UserProfile getAttendedBy() {
		return attendedBy;
	}

	public void setAttendedBy(UserProfile attendedBy) {
		this.attendedBy = attendedBy;
	}
	
	public BigDecimal getTotalAdjustedAmount() {
		return this.totalAdjustedAmount;
	}
	
	public void setTotalAdjustedAmount(BigDecimal totalAdjustedAmount) {
		this.totalAdjustedAmount = totalAdjustedAmount;
	}
	
	public StreamedContent getFile() {  
		
		String path ="/accounts/" + account.getAccountId() + "/" + documentReference.getDocType() + "/" + documentReference.getFilename();
		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);  
        file = new DefaultStreamedContent(stream, documentReference.getFilename(), documentReference.getFilename()); 
        
        return file;  
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
	
	public void listCANCDocumentType() {
		documentReferences = new ArrayList<DocumentReference>();
		if(account != null) {
			DocumentReferenceService documentReferenceService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
			documentReferences = documentReferenceService.findByAccountIdAndDocType(account.getAccountId(), DocumentTypeConst.CANCEL);
		}
	}
	
	public CommandButton getApproveButton() {
		return approveButton;
	}

	public void setApproveButton(CommandButton approveButton) {
		this.approveButton = approveButton;
	}
	
	public String listProject() {
		try
		{		
			ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());
			projects = projectService.findAllProjects();
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		
		return "cancelPropertyListApproval";
	}

	public String listPropertyUnits() {
		listProject = CodeUtil.getProjectAsItems();
		ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());
		project = projectService.findById(projectId);
		
		inventories = new ArrayList<ProjectInventory>();
		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
		SalesCancellationService salesCancellationService = (SalesCancellationService) SpringBeanUtil.lookup(SalesCancellationService.class.getName());
		List<SalesCancellationHistory> salesCancellationHistorys = salesCancellationService.findAll();
		
		for(SalesCancellationHistory salesCancellationHistory: salesCancellationHistorys)
//		{
//			ProjectInventory projectInventory = inventoryService.getInventoryById(salesCancellationHistory.getProjectInventory().getInventoryId());
//			if(projectInventory!= null)
//			{
//				inventories.add(projectInventory);
//			}
//		}

		inventories = inventoryService.getCancellingInventories(projectId);
		
		return "cancelPropertyListApproval";
	}
	
	public String GetFontColorByInvertoryId(String idStr) {
		String fontColor = "Black";
		try
		{
			long attendedBy = -1;
			Long id = Long.valueOf(idStr);
			AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			List<Account> accounts = accountService.findByProjectInventoryId(id);
			for (Account account : accounts) {
				attendedBy = account.getAttendedBy();
			}
			
			AuthUser user = getCurrentUser();
			long userId = user.getUserProfile().getUserId();
			
			if(attendedBy != userId)
			{
				fontColor = "Grey";
			}
		} catch (Exception ex)
		{
		}
		return fontColor;
	}
	
	public String GetAttendedByByInventoryId(Long id){
		String attendedBy = "";
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
		List<Account> accounts = accountService.findByProjectInventoryId(id);
		for (Account account : accounts) {
			attendedBy = account.getAttendedBy().toString();
		}
		return attendedBy;
	}
		
	public String GetCustomerNameByInventoryId(String idStr){
		String customerName = "";
		try
		{
			Long id = Long.valueOf(idStr);
			customerName = GetCustomerNameByInventoryId(id);
		} catch (Exception ex)
		{
		}
		return customerName;
	}
	
	public String GetCustomerNameByInventoryId(Long id){
		String customerName = "";
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
		List<Account> accounts = accountService.findByProjectInventoryId(id);
		for (Account account : accounts) {
			customerName = account.getCustomer().getFullName();
		}
		return customerName;
	}
	
	public String GetCancelStatusByInventoryId(String idStr) {
		String status = "";
		try
		{
			Long id = Long.valueOf(idStr.trim());
			SalesCancellationService salesCancellationService = (SalesCancellationService) SpringBeanUtil.lookup(SalesCancellationService.class.getName());
			List<SalesCancellationHistory> salesCancellationHistorys = salesCancellationService.findByInventoryId(id);
			
			for(SalesCancellationHistory salesCancellationHistory: salesCancellationHistorys)
			{
				if(salesCancellationHistory.getStatus().equals(CancelStatusConst.SUBMIT_CANCEL))
				{
					status = "Cancelling";
				}
				else
				{
					status = getCodeDesc("CX", salesCancellationHistory.getStatus());
				}
			}
		} catch (Exception ex)
		{
		}
		
		return status;
	}
	
	public void updateCancelTax() {
		if(account.getBookPymtMethod().equals(CommonConst.CREDIT_CARD)) {
			double regFee = account.getRegistrationFee()!=null ? account.getRegistrationFee().doubleValue() : 0.0d;
			double cancelTax = regFee * TaxCharge;
			salesCancellationHistory.setCancelTax(new BigDecimal(cancelTax));
		} else {
			salesCancellationHistory.setCancelTax(new BigDecimal(0));
		}
		
	}
	
	public void updateCancelFee() {
		DocumentReferenceService docService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		List<DocumentReference> docs = docService.findByAccountIdAndDocType(account.getAccountId(), DocumentTypeConst.CANCEL);
		if(docs.size() > 0){
			salesCancellationHistory.setCancelFee(new BigDecimal(0));
		} else {
			double regFee = account.getRegistrationFee()!=null ? account.getRegistrationFee().doubleValue() : 0.0d;
			double cancelTax = salesCancellationHistory.getCancelTax()!=null ? salesCancellationHistory.getCancelTax().doubleValue() : 0.0d;
			double cancelFee = regFee;
			if(regFee + cancelTax > AdminFee) {
				cancelFee = AdminFee;
			}
			salesCancellationHistory.setCancelFee(new BigDecimal(cancelFee));
		}
		
	}
	
	public String updateNetRefund() {
		
		double regFee = account.getRegistrationFee()!=null ? account.getRegistrationFee().doubleValue() : 0.0d;
		double cancelFee = salesCancellationHistory.getCancelFee()!=null ? salesCancellationHistory.getCancelFee().doubleValue() : 0.0d;
		double cancelTax = salesCancellationHistory.getCancelTax()!=null ? salesCancellationHistory.getCancelTax().doubleValue() : 0.0d;
		double netAmount = regFee - (cancelFee + cancelTax);
		salesCancellationHistory.setCancelNetRefundAmt(new BigDecimal(netAmount));
		
		return "salesCancellationApproval";
	}
	
	public String updateNettPrice() {
		
		if(adjLog != null) {
			double purchasePriceAft = adjLog.getPurchasePriceAft()!=null ? adjLog.getPurchasePriceAft().doubleValue() : 0.0d;
			//double discountRateAft = adjLog.getDiscountRateAft()!=null ? adjLog.getDiscountRateAft().doubleValue() : 0.0d;
			double discountRate = project.getDiscountRate() != null ? project.getDiscountRate().doubleValue() : 0.0d;
			
			//double discountAmountAft = purchasePriceAft * discountRateAft / 100;
			double discountAmountAft = purchasePriceAft * discountRate / 100;
			double netAdjAft = purchasePriceAft - discountAmountAft;
			
			adjLog.setDiscountAmountAft(new BigDecimal(discountAmountAft));
			adjLog.setNetAdjAft(new BigDecimal(netAdjAft));
			adjLog.setDiscountRateAft(new BigDecimal(discountRate));
		}
		
		return "salesCancellationApproval";
	}
	
	public String disabledMode() {
		String mode = "true";
		if(salesCancellationHistory != null && salesCancellationHistory.getStatus().equalsIgnoreCase(CancelStatusConst.SUBMIT_CANCEL)) {
			mode = "false";
		}
		
		return mode;
	}

	public String selectInventory() {
		try {
			customers = new ArrayList<Customer>();
			account = null;
			salesCancellationHistory = new SalesCancellationHistory();
			adjHeaders = new ArrayList<AdjHeader>();
			adjHeader = null;
			adjLog = new AdjLog();
			totalAdjustedAmount = new BigDecimal(0);
	
			AuthUser user = getCurrentUser();
			if (user != null)
				attendedBy = user.getUserProfile();
	
			AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
	
			List<Account> accounts = accountService.findByProjectInventoryId(inventory.getInventoryId());
			   
			for (Account a : accounts) {
				account = a;
				if (account.getAttendedBy() != null) {
					UserProfile up = userProfileService.findById(account.getAttendedBy());
					attendedBy = up;
				}
				customers = new ArrayList<Customer>();
				StringBuffer names = new StringBuffer();
				if (account.getCustomer() != null) {
					customers.add(account.getCustomer());
					names.append(account.getCustomer().getFullName());
				}
				if (account.getCustomer2() != null) {
					customers.add(account.getCustomer2());
					names.append(", ");
					names.append(account.getCustomer2().getFullName());
				}
				if (account.getCustomer3() != null) {
					customers.add(account.getCustomer3());
					names.append(", ");
					names.append(account.getCustomer3().getFullName());
				}
				if (account.getCustomer4() != null) {
					customers.add(account.getCustomer4());
					names.append(", ");
					names.append(account.getCustomer4().getFullName());
				}
				if (account.getCustomer5() != null) {
					customers.add(account.getCustomer5());
					names.append(", ");
					names.append(account.getCustomer5().getFullName());
				}
				customerNames = names.toString();
			}
						
			if ( account==null) {
				addInfoMessage("Sales Cancellation Approval", "There is nothing to approve.");
				return listPropertyUnits();
			}
			
			SalesCancellationService salesCancellationService = (SalesCancellationService) SpringBeanUtil.lookup(SalesCancellationService.class.getName());
			List<SalesCancellationHistory> salesCancellationHistorys = salesCancellationService.findByInventoryId(inventory.getInventoryId());
			
			for(SalesCancellationHistory history: salesCancellationHistorys)
			{
				salesCancellationHistory = history;
			}
			
			approveButton.setStyle("display: none");
			if(salesCancellationHistory != null && salesCancellationHistory.getStatus().equalsIgnoreCase(CancelStatusConst.SUBMIT_CANCEL)) {
				approveButton.setStyle("");
			}
			
			dialogConfirmationName = "dlgConfirmationAdjHeader.show()";
			
			AdjHeaderService adjHeaderService = (AdjHeaderService) SpringBeanUtil.lookup(AdjHeaderService.class.getName());
			List<AdjHeader> adjHeaderList = adjHeaderService.findByProjectId(projectId);
			
			double purchasePriceBef = inventory.getPurchasePrice()!=null ? inventory.getPurchasePrice().doubleValue() : 0.0d;
			double discountAmountBef = inventory.getDiscountAmount() != null ? inventory.getDiscountAmount().doubleValue() : 0.0d;
			double netAdjBef = purchasePriceBef - discountAmountBef;

			double adjPurchasePrice = purchasePriceBef;
			double totalAdjPrice = 0;
			for(AdjHeader header: adjHeaderList) {
				if(header.getDateApproved() != null && account.getDatePurchased() != null 
						&& header.getDateApproved().compareTo(account.getDatePurchased()) >= 0) {
					if(header.getAdjAmount() != null) {
						adjPurchasePrice += header.getAdjAmount().doubleValue();
						totalAdjPrice += header.getAdjAmount().doubleValue();
					} else {
						if(header.getAdjPercent() != null) {
							double newAdjAmount = adjPurchasePrice * header.getAdjPercent().doubleValue() / 100;
							header.setAdjAmount(new BigDecimal(newAdjAmount)) ;
							
							adjPurchasePrice += newAdjAmount;
							totalAdjPrice += newAdjAmount;
						}
					}
					adjHeaders.add(header);
				}
			}
			
			totalAdjustedAmount = new BigDecimal(totalAdjPrice);

			adjLog.setProjectInventory(inventory);
			adjLog.setPurchasePriceBef(new BigDecimal(purchasePriceBef));
			adjLog.setDiscountAmountBef(new BigDecimal(discountAmountBef));
			adjLog.setNetAdjBef(new BigDecimal(netAdjBef));
			
			adjLog.setPurchasePriceAft(new BigDecimal(adjPurchasePrice));
			updateNettPrice();
			
			/*for(AdjHeader adj: adjHeaders) {
				adjHeader = adj;
			} 
			
			dialogConfirmationName = "dlgConfirmation.show()";
			if(adjHeader != null) {
				dialogConfirmationName = "dlgConfirmationAdjHeader.show()";
				AdjLogService adjLogService = (AdjLogService) SpringBeanUtil.lookup(AdjLogService.class.getName());
				List<AdjLog> adjLogs = adjLogService.findByAdjHeaderId(adjHeader.getAdjHeaderId());
				
				for(AdjLog log: adjLogs) {
					adjLog = log;
				}
			}*/

		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Error opening sales", t.getMessage());
			return listPropertyUnits();
		}

		return "salesCancellationApproval";

	}
	
	public String approve() {
		
		return "salesCancellationApproval";
	}
	
	public String confirm() {
		
		if (account != null && salesCancellationHistory != null) {
			if (!StringUtils.hasText(salesCancellationHistory.getCancelledReason())) {
				addErrorMessage("Warning!", "Failed to confirm cancellation, please select the reason for cancellation.");
				return "salesCancellationApproval";
			}
			
			Date currentDate = new Date();
			AuthUser user = getCurrentUser();
			currentUser = user.getUserProfile();
			long userId = user.getUserProfile().getUserId();
			
			TransactionHistoryService transactionHistoryService = (TransactionHistoryService) SpringBeanUtil.lookup(TransactionHistoryService.class.getName());
			TransactionHistory transactionHistory = new TransactionHistory();
			
			double netRefundAmt = salesCancellationHistory.getCancelNetRefundAmt()!=null ? salesCancellationHistory.getCancelNetRefundAmt().doubleValue() : 0.0d;
			if(netRefundAmt > 0) {
				transactionHistory = new TransactionHistory();
				TransactionCode codeCancelFeeRefund = new TransactionCode();
				codeCancelFeeRefund.setTransactionCode(TransactionCodeConst.CANCEL_FEE_REV);
				transactionHistory.setTransactionCode(codeCancelFeeRefund);
				transactionHistory.setTransactionDate(currentDate);
				transactionHistory.setTransactionDescription("CANCELLATION REFUND AMOUNT");
				transactionHistory.setStatus(TransactionStatusConst.PENDING);
				transactionHistory.setAmount(salesCancellationHistory.getCancelNetRefundAmt());
				transactionHistory.setAccount(account);
				transactionHistoryService.insert(transactionHistory);
			}
			
			double cancelFee = salesCancellationHistory.getCancelFee()!=null ? salesCancellationHistory.getCancelFee().doubleValue() : 0.0d;
			if(cancelFee > 0) {
				transactionHistory = new TransactionHistory();
				TransactionCode codeCancelAdminFee = new TransactionCode();
				codeCancelAdminFee.setTransactionCode(TransactionCodeConst.CANCEL_ADMIN_FEE);
				transactionHistory.setTransactionCode(codeCancelAdminFee);
				transactionHistory.setTransactionDate(currentDate);
				transactionHistory.setTransactionDescription("CANCELLATION ADMIN FEE");
				transactionHistory.setStatus(TransactionStatusConst.PENDING);
				transactionHistory.setAmount(salesCancellationHistory.getCancelFee());
				transactionHistory.setAccount(account);
				transactionHistoryService.insert(transactionHistory);
			}
			
			double cancelTax = salesCancellationHistory.getCancelTax()!=null ? salesCancellationHistory.getCancelTax().doubleValue() : 0.0d;
			if(cancelTax > 0) {
				transactionHistory = new TransactionHistory();
				TransactionCode codeCancelTax = new TransactionCode();
				codeCancelTax.setTransactionCode(TransactionCodeConst.CANCEL_TAX);
				transactionHistory.setTransactionCode(codeCancelTax);
				transactionHistory.setTransactionDate(currentDate);
				transactionHistory.setTransactionDescription("CANCELLATION TAX");
				transactionHistory.setStatus(TransactionStatusConst.PENDING);
				transactionHistory.setAmount(salesCancellationHistory.getCancelTax());
				transactionHistory.setAccount(account);
				transactionHistoryService.insert(transactionHistory);
			}
			
			AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			account.setAccountStatus(AccountStatusConst.STATUS_CANCELLED);
			account.setChangedBy(userId);
			account.setDateChanged(currentDate);
			account.setCancelNetRefundAmt(salesCancellationHistory.getCancelNetRefundAmt());
			account.setCancelFee(salesCancellationHistory.getCancelFee());
			account.setCancelTax(salesCancellationHistory.getCancelTax());
			accountService.update(account);
			
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
			inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_CANCELLED);
			inventory.setChangeUserId(userId);
			inventory.setStatusChangeDate(currentDate);
			if(adjLog != null) {
				inventory.setPurchasePrice(adjLog.getPurchasePriceAft());
				inventory.setDiscountAmount(adjLog.getDiscountAmountAft());
				inventory.setDiscountRate(adjLog.getDiscountRateAft());
			}
			inventoryService.update(inventory);
			
			//ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());
			//projectService.update(project);
			
			SalesCancellationService salesCancellationService = (SalesCancellationService) SpringBeanUtil.lookup(SalesCancellationService.class.getName());
			salesCancellationHistory.setStatus(CancelStatusConst.APPROVE_CANCEL);
			salesCancellationHistory.setApprovedBy(userId);
			salesCancellationHistory.setDateApproved(currentDate);
			salesCancellationService.update(salesCancellationHistory);
			
			CaseAlert caseAlert = new CaseAlert();
			caseAlert.updateCase(CaseStatus.SALES_CANCELLED, projectId, account.getAccountId(),	
					currentUser, CaseStatus.APPROVED, null, null);
/*			caseAlert.cancelCase(CaseStatus.PAID_BOOKING_FEE, projectId, account.getAccountId(),
					currentUser, CaseStatus.CANCELLED, null, null);
*/			
			addInfoMessage("Information.", "Sales Cancellation Approval Completed Successfully.");
			return listPropertyUnits();
		} else {
			addErrorMessage("Warning!", "Failed to approve the sales cancellation.");
			return "salesCancellationApproval";
		}
	}

}
