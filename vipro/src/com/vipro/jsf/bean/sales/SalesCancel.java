package com.vipro.jsf.bean.sales;

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

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.util.StringUtils;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CommonConst;
import com.vipro.constant.DocumentTypeConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.constant.UserGroupConst;
import com.vipro.constant.CancelStatusConst;
import com.vipro.constant.CaseStatus;
import com.vipro.data.Account;
import com.vipro.data.SalesCancellationHistory;
import com.vipro.data.Customer;
import com.vipro.data.DocumentReference;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.jsf.bean.mydesk.CaseAlert;
import com.vipro.service.AccountService;
import com.vipro.service.SalesCancellationService;
import com.vipro.service.DocumentReferenceService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;


@ManagedBean(name = "salesCancel")
@SessionScoped
public class SalesCancel extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -812765222545363465L;


	private List<SelectItem> cancelReasons;
	
	
	private List<Project> projects;
	private List<ProjectInventory> inventories;
	private List<SelectItem> listProject;
	private List<DocumentReference> documentReferences;

	private ProjectInventory inventory;
	private Long projectId;
	private Project project;

	private String customerNames;
	private String cancelReason;
	private List<Customer> customers;
	private Account account;
	private TransactionHistory bookTrx;
	private UserProfile attendedBy;
	private DocumentReference documentReference;
	private UserProfile currentUser;
	private String unitNo;
	
	private double TaxCharge = 0.02;
	private double AdminFee = 500;

	private StreamedContent file;  

	@PostConstruct
	public void init() {
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
	
	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
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
	
	public String listProject() {
		try
		{		
			ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());
			projects = projectService.findAllProjects();
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		
		//return "cancelSelectProject";
		return "cancelPropertyList";
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

	public UserProfile getAttendedBy() {
		return attendedBy;
	}

	public void setAttendedBy(UserProfile attendedBy) {
		this.attendedBy = attendedBy;
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

	public TransactionHistory getBookTrx() {
		return bookTrx;
	}

	public void setBookTrx(TransactionHistory bookTrx) {
		this.bookTrx = bookTrx;
	}
	
	public String listPropertyUnits() {
		listProject = CodeUtil.getProjectAsItems();
		
		ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());
		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
		UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
		
		project = projectService.findById(projectId);
		inventories = new ArrayList<ProjectInventory>();

		AuthUser user = getCurrentUser();
		Long userId = user.getUserProfile().getUserId();
		UserProfile userProfile = userProfileService.findById(userId);
		
		if(userProfile.getUserGroup().getGroupId().equalsIgnoreCase(UserGroupConst.SALES_PIC) ||
				userProfile.getUserGroup().getGroupId().equalsIgnoreCase(UserGroupConst.ADMIN))
		{
			if (StringUtils.hasText(unitNo)) {
				inventories = inventoryService.getAvailableInventories(projectId, unitNo);
			} else {
				inventories = inventoryService.getAvailableInventories(projectId);
			}
		}
		else
		{
			List<ProjectInventory> dataList = inventoryService.getAvailableInventories(projectId);
			for(ProjectInventory data: dataList)
			{
				List<Account> accountList = accountService.findByAvailableProjectInventoryId(data.getInventoryId());
				for(Account account: accountList) {
					if(account.getAttendedBy().equals(userId))
					{
						inventories.add(data);
						break;
					}
				}
			}
		}
		
		//return "cancelSelectUnit";
		return "cancelPropertyList";
	}
	
	public String GetFontColorByInvertoryId(String idStr) {
		String fontColor = "Black";
		try
		{
			long attendedBy = -1;
			Long id = Long.valueOf(idStr);
			AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			List<Account> accounts = accountService.findByAvailableProjectInventoryId(id);
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
		List<Account> accounts = accountService.findByAvailableProjectInventoryId(id);
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
		List<Account> accounts = accountService.findByAvailableProjectInventoryId(id);
		for (Account account : accounts) {
			customerName = account.getCustomer().getFullName();
		}
		return customerName;
	}
	
	public void updateCancelTax() {
		if(account.getBookPymtMethod().equals(CommonConst.CREDIT_CARD)) {
			double regFee = account.getRegistrationFee()!=null ? account.getRegistrationFee().doubleValue() : 0.0d;
			double cancelTax = regFee * TaxCharge;
			account.setCancelTax(new BigDecimal(cancelTax));
		} else {
			account.setCancelTax(new BigDecimal(0));
		}
		
	}
	
	public void updateCancelFee() {
		DocumentReferenceService docService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		List<DocumentReference> docs = docService.findByAccountIdAndDocType(account.getAccountId(), DocumentTypeConst.CANCEL);
		if(docs.size() > 0){
			account.setCancelFee(new BigDecimal(0));
		} else {
			double regFee = account.getRegistrationFee()!=null ? account.getRegistrationFee().doubleValue() : 0.0d;
			double cancelTax = account.getCancelTax()!=null ? account.getCancelTax().doubleValue() : 0.0d;
			double cancelFee = regFee;
			if(regFee + cancelTax > AdminFee) {
				cancelFee = AdminFee;
			}
			account.setCancelFee(new BigDecimal(cancelFee));
		}
		
	}
	
	public String updateNetRefund() {
		
		double regFee = account.getRegistrationFee()!=null ? account.getRegistrationFee().doubleValue() : 0.0d;
		double cancelFee = account.getCancelFee()!=null ? account.getCancelFee().doubleValue() : 0.0d;
		double cancelTax = account.getCancelTax()!=null ? account.getCancelTax().doubleValue() : 0.0d;
		double netAmount = regFee - (cancelFee + cancelTax);
		account.setCancelNetRefundAmt(new BigDecimal(netAmount));
		
		return "salesCancellation";
	}
	
	public String selectInventory() {
		try {
			customers = new ArrayList<Customer>();
		
			account = null;
	
			AuthUser user = getCurrentUser();
			if (user != null)
				attendedBy = user.getUserProfile();
	
			AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
	
			List<Account> accounts = accountService.findByAvailableProjectInventoryId(inventory.getInventoryId());
			
			 //support only one account as per one property unit.
			   
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
			
			
			/*if (account!=null) {
				Set<TransactionHistory> trxhist = account.getTransactionHistories();
				for (TransactionHistory h : trxhist) {
					if (h.getTransactionCode().getTransactionCode().equals(TransactionCodeConst.BOOK_FEE)) {
						bookTrx =h;
					}
				}
				
				
				if (bookTrx!=null && !TransactionStatusConst.PENDING.equals(bookTrx.getStatus())) {
					addInfoMessage("Sales Cancellation", "Transaction is completed. Cancellation is not allowed");
					return listPropertyUnits();
				}
			
				if (account.getCancelDocId()!=null) {
					DocumentReferenceService docService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
					DocumentReference doc = docService.findById(account.getCancelDocId());
					if (doc!=null) {
						InputStream in = new ByteArrayInputStream(doc.getFileContent());
						
						file = new DefaultStreamedContent(in, getFileType(doc.getFilename()), doc.getFilename());  
					}
					 
				}
			}*/
			
			if ( account==null) {
				addInfoMessage("WARNING!", "This property unit has been billed, please contact your Sales Admin. (No Account)");
				return listPropertyUnits();
			}

			if (!account.getAccountStatus().equalsIgnoreCase(CommonConst.STATUS_NEW)) {
				addInfoMessage("WARNING!", "This property unit has been billed, please contact your Sales Admin.");
				return listPropertyUnits();
			}
			
			updateCancelTax();
			updateCancelFee();
			updateNetRefund();
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Error opening sales", t.getMessage());
			return listPropertyUnits();
		}

		//return "cancel";	
		return "salesCancellation";

	}
	
	public String submit() {
		
		return "salesCancellation";
	}
	
	public String cancel() {
		if (account != null) {
			if (!StringUtils.hasText(account.getCancelledReason())) {
				addErrorMessage("Failed to cancel", "Please select a reason for cancellation.");
				return "salesCancellation";
			}
			
			SalesCancellationService salesCancellationService=  (SalesCancellationService) SpringBeanUtil.lookup(SalesCancellationService.class.getName());
			SalesCancellationHistory salesCancellationHistory = new SalesCancellationHistory();
			salesCancellationHistory.setProjectInventory(account.getProjectInventory());
			salesCancellationHistory.setRegistrationFee(account.getRegistrationFee());
			salesCancellationHistory.setCancelledReason(account.getCancelledReason());
			salesCancellationHistory.setCancelFee(account.getCancelFee());
			salesCancellationHistory.setCancelTax(account.getCancelTax());
			salesCancellationHistory.setCancelNetRefundAmt(account.getCancelNetRefundAmt());
			salesCancellationHistory.setAccount(getAccount());
			
			ProjectInventoryService inventoryService=  (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
			inventory.setAccounts(null);
			inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_CANCELLING);
			// ** Bill : Update the changed date to current system date** //
			inventory.setStatusChangeDate(new Date());
			
			AuthUser user = getCurrentUser();
			currentUser = user.getUserProfile();
			inventory.setChangeUserId(user.getUserProfile().getUserId());
			
			inventoryService.update(inventory);

			salesCancellationHistory.setSubmittedBy(user.getUserProfile().getUserId());
			salesCancellationHistory.setDateSubmitted(new Date());
			salesCancellationHistory.setStatus(CancelStatusConst.SUBMIT_CANCEL);
			
			salesCancellationService.update(salesCancellationHistory);
			addInfoMessage("Information", "Sales Cancellation Submitted Successfully for Approval.");
			
			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil
					.lookup(UserProfileService.class.getName());
			UserProfile toUserProfile = userProfileService.findById(project.getPicId());
			
			CaseAlert caseAlert = new CaseAlert();
			caseAlert.insertCase(CaseStatus.SALES_CANCELLED, projectId, account.getAccountId(),
					currentUser, account.getCustomer(), CaseStatus.SUBMITTED, toUserProfile, null);
/*			caseAlert.cancelCase(CaseStatus.PAID_BOOKING_FEE, projectId, account.getAccountId(),
					currentUser, CaseStatus.CANCELLING, toUserProfile, null);
*/			
			return listPropertyUnits();
		} else {
			addErrorMessage("Warning!", "Sales Cancellation Submission Failed.");
			return "salesCancellation";
		}
	}
	
	public void upload(FileUploadEvent event) {

		if (account==null) {
			addErrorMessage("Upload failed", "Account not found");
			return;
		}
		
	    String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	    String filename = event.getFile().getFileName().substring(0, event.getFile().getFileName().lastIndexOf('.')) + 
	    					"_" + fmt.format(new Date()) + event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
 
	    if (filename.length() >= 50) {
			addErrorMessage("Upload failed", "Filename is too long");
			return;
		}

	    AuthUser user = getCurrentUser();
		String userName = user.getName();
		Long accId = account.getAccountId();
		String docType = DocumentTypeConst.CANCEL;
	    
	    path += "accounts/";
	    File fileAccountDir = new File(path);
	    if (!fileAccountDir.exists())
	    {
	    	fileAccountDir.mkdir();
	    }
	    path += accId + "/";
	    File fileIdDir = new File(path);
	    if (!fileIdDir.exists())
	    {
	    	fileIdDir.mkdir();
	    }
	    path += docType + "/";
	    File fileTypeDir = new File(path);
	    if (!fileTypeDir.exists())
	    {
	    	fileTypeDir.mkdir();
	    }
	    
	    File fileDir = new File(path + filename);

	    try
	    {
	    	InputStream is = event.getFile().getInputstream();
	    	OutputStream out = new FileOutputStream(fileDir);
	    	byte buf[] = new byte[1024];
	    	int len;
	    	while ((len = is.read(buf)) > 0)
	    		out.write(buf, 0, len);
	    	is.close();
	    	out.close();
	    }
	    catch(IOException ex)
	    {
	    	addErrorMessage("Upload failed", "Uploading file(s) error");
			return;
	    }

	    DocumentReferenceService service = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		DocumentReference doc = new DocumentReference();
		doc.setCreatedOn(new Date());
		doc.setCreatedBy(userName);
		doc.setDocType(docType);
		doc.setFilename(filename);
		doc.setAccount(account);
		service.insert(doc);
		
		updateCancelFee();
		
	    addInfoMessage("Upload Successful", "File(s) is uploaded");
	    
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}
	
	/*public String cancel() {
		try {
//			if (AccountStatusConst.CANCEL.equals(account.getAccountStatus())) {
//				addErrorMessage("Sales Cancellation", "Sales is already cancelled");
//				return "cancel";
//			}
			ProjectInventoryService inventoryService=  (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
			
			inventory.setAccounts(null);
			inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_ACTIVE);
			inventoryService.update(inventory);
			
			AccountService accountService=  (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			account.setAccountStatus(AccountStatusConst.CANCEL);
			
			double regFee = account.getRegistrationFee()!=null ? account.getRegistrationFee().doubleValue() : 0.0d;
			
			
			double d = regFee;
			d = d - (account.getCancelFee().doubleValue() + account.getCancelTax().doubleValue());
			
			account.setCancelNetRefundAmt(new BigDecimal(d));
			
			accountService.update(account);
			
			
			
			TransactionHistoryService trxService = (TransactionHistoryService) SpringBeanUtil.lookup(TransactionHistoryService.class.getName());
			List<TransactionHistory> hists = trxService.findByAccountId(account.getAccountId());
			
			for (TransactionHistory h : hists ) {
				if (TransactionCodeConst.CANCEL_FEE.equals(h.getTransactionCode().getTransactionCode())) {
					trxService.delete(h.getTransactionId());
				}
			}
			
			TransactionCode code = new TransactionCode(TransactionCodeConst.CANCEL_FEE);
			TransactionHistory cancelTrx = new TransactionHistory();
			cancelTrx.setTransactionCode(code);
			cancelTrx.setTransactionDate( new Date() );
			cancelTrx.setTransactionDescription("Cancel Fee");
			cancelTrx.setAccount(account);
			cancelTrx.setAmount(account.getCancelFee());
			cancelTrx.setStatus(TransactionStatusConst.COMPLETE);
			trxService.insert(cancelTrx);
			
			addInfoMessage("Sales Cancellation", "Sales is cancelled");
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Error cancelling sales", t.getMessage());
		}
		
		//return "cancel";
		return "salesCancellation";
	}*/
	
	/*public StreamedContent getFile() {  
        return file;  
    }
	
	public void upload(FileUploadEvent event) {
		DocumentReferenceService service = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
		
		if (account==null) {
			addErrorMessage("Account not found", "Upload failed as account not found");
			return;
		}
		
		if (account.getCancelDocId()!=null) {
			service.delete(account.getCancelDocId());
		}
		
		AuthUser user = getCurrentUser();
		String name = user.getName();

		UploadedFile file = event.getFile();
		if (file!=null) {
			
			
			DocumentReference doc = new DocumentReference();
			doc.setCreatedOn(new Date());
			doc.setCreatedBy(name);
			doc.setDocType(DocumentTypeConst.CANCEL);
			doc.setFileContent(file.getContents());
			
			
			service.insert(doc);
			
			if (doc.getId()!=null) {
				account.setCancelDocId(doc.getId());
				accountService.update(account);
			}
			addInfoMessage("Cancellation letter", "Cancellation letter is uploaded");
		} else {
			addErrorMessage("Cancellation Letter", "Upload failed");
		}
		
	}*/
}
