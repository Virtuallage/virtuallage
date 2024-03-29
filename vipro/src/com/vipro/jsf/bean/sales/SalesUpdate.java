package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.model.StreamedContent;

import com.vipro.auth.AuthUser;
import com.vipro.constant.BusinessPartnerTypeConst;
import com.vipro.constant.CommonConst;
import com.vipro.constant.CustomerTypeConst;
import com.vipro.constant.DocumentTypeConst;
import com.vipro.constant.PurchaseTypeConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.constant.UserGroupConst;
import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.DocumentReference;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.AddressService;
import com.vipro.service.CustomerService;
import com.vipro.service.DocumentReferenceService;
import com.vipro.service.ProjectInventoryService;
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat; 

import javax.servlet.ServletContext;  
import javax.servlet.http.HttpServletResponse;


@ManagedBean(name="salesUpdate")
@SessionScoped
public class SalesUpdate extends CommonBean implements Serializable{

	private List<Project> projects;
	private List<ProjectInventory> inventories;
	private List<Account> accounts;
	private List<SelectItem> listProject;
	private List<SelectItem> purchaseTypes;
	private List<SelectItem> propertyTypes;
	private List<SelectItem> listCountry = null;
	private List<SelectItem> listCity = null;
	private List<SelectItem> listState = null;
	private List<SelectItem> listIdType = null;
	private List<SelectItem> listTitle = null;
	private List<SelectItem> listGender = null;
	private List<SelectItem> listMaritalStatus = null;
	private List<SelectItem> listBumi = null;
	private List<SelectItem> listRace = null;
	private List<SelectItem> listSolicitors = null;
	private List<SelectItem> listPanelBanks = null;
	private List<SelectItem> listSpecial = null;
	private List<SelectItem> listUsers = null;
	private List<SelectItem> listSalesPersons = null;
	
	private ProjectInventory inventory;
	private Long projectId;
	private String unitNo;
	private Project project;
	private String customerName;
	private String customerName2;
	private String customerName3;
	private String customerName4;
	private String customerName5;
	private List<Customer> customers;
	private Account account;
	private Long accountId;
	private UserProfile attendedBy;
	
	private List<DocumentReference> documentReferences;
	private DocumentReference documentReference;
	private String documentType;
	private StreamedContent file;
	
	private String searchIdNo;
	private String searchName;
	private String customerId;
	private String customerNo;
	private List<Customer> availableCustomers;
	private List<Customer> searchCustList;
	private Customer selectedCustomer;
	private Customer delCustomer;

	private Customer individual;
	private Customer company;
	private Address address;
	private String disableLoanFields;
		
	@PostConstruct
	public void init() {
		purchaseTypes = CodeUtil.getCodes("PU");
		propertyTypes = CodeUtil.getCodes("PT");
		listCountry = CodeUtil.getCodes("CT");
		listCity = CodeUtil.getCodes("CI");
		listIdType = CodeUtil.getCodes("ID");
		listTitle = CodeUtil.getCodes("TT");
		listGender = CodeUtil.getCodes("SX");
		listMaritalStatus = CodeUtil.getCodes("MS");
		listBumi = CodeUtil.getCodes("BM");
		listRace = CodeUtil.getCodes("RC");
		listState = CodeUtil.getCodes("ST");
		listSpecial = CodeUtil.getCodes("SH");
		listSolicitors = CodeUtil.getBusinessPartnerAsItems(BusinessPartnerTypeConst.SOLICITOR);
		listPanelBanks = CodeUtil.getCodes("BK");
		listUsers = CodeUtil.getActiveUsersAsItems();
		listSalesPersons = CodeUtil.getActiveUsersAsItems();
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
	
	public List<SelectItem> getListState() {
		return listState;
	}

	public void setListState(List<SelectItem> listState) {
		this.listState = listState;
	}

	public List<SelectItem> getListRace() {
		return listRace;
	}

	public void setListRace(List<SelectItem> listRace) {
		this.listRace = listRace;
	}

	public List<SelectItem> getListCountry() {
		return listCountry;
	}

	public void setListCountry(List<SelectItem> listCountry) {
		this.listCountry = listCountry;
	}

	public List<SelectItem> getListCity() {
		return listCity;
	}

	public void setListCity(List<SelectItem> listCity) {
		this.listCity = listCity;
	}

	public List<SelectItem> getListIdType() {
		return listIdType;
	}

	public void setListIdType(List<SelectItem> listIdType) {
		this.listIdType = listIdType;
	}

	public List<SelectItem> getListTitle() {
		return listTitle;
	}

	public void setListTitle(List<SelectItem> listTitle) {
		this.listTitle = listTitle;
	}

	public List<SelectItem> getListGender() {
		return listGender;
	}

	public void setListGender(List<SelectItem> listGender) {
		this.listGender = listGender;
	}

	public List<SelectItem> getListMaritalStatus() {
		return listMaritalStatus;
	}

	public void setListMaritalStatus(List<SelectItem> listMaritalStatus) {
		this.listMaritalStatus = listMaritalStatus;
	}

	public List<SelectItem> getListBumi() {
		return listBumi;
	}

	public void setListBumi(List<SelectItem> listBumi) {
		this.listBumi = listBumi;
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


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	public String getCustomerName2() {
		return customerName2;
	}


	public void setCustomerName2(String customerName2) {
		this.customerName2 = customerName2;
	}
	
	
	public String getCustomerName3() {
		return customerName3;
	}


	public void setCustomerName3(String customerName3) {
		this.customerName3 = customerName3;
	}
	
	
	public String getCustomerName4() {
		return customerName4;
	}


	public void setCustomerName4(String customerName4) {
		this.customerName4 = customerName4;
	}
	
	
	public String getCustomerName5() {
		return customerName5;
	}


	public void setCustomerName5(String customerName5) {
		this.customerName5 = customerName5;
	}
	

	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
	public List<Account> getAccounts() {
		return this.accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
	public Account getAccount() {
		return account;
	}
	
	
	public Long getAccountId() {
		return accountId;
	}


	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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
	
	public String getSearchIdNo() {
		return searchIdNo;
	}

	public void setSearchIdNo(String searchIdNo) {
		this.searchIdNo = searchIdNo;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	public List<Customer> getAvailableCustomers() {
		return availableCustomers;
	}

	public void setAvailableCustomers(List<Customer> availableCustomers) {
		this.availableCustomers = searchCustList;
	}

	public List<Customer> getSearchCustList() {
		return searchCustList;
	}

	public void setSearchCustList(List<Customer> searchCustList) {
		this.searchCustList = searchCustList;
	}
	
	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer getIndividual() {
		return individual;
	}

	public void setIndividual(Customer individual) {
		this.individual = individual;
	}

	public Customer getCompany() {
		return company;
	}

	public void setCompany(Customer company) {
		this.company = company;
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
	
	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	public void setSPADocumentType() {
		this.documentType = DocumentTypeConst.SPA;
		//RequestContext.getCurrentInstance().execute("uploadDialog.show()");
	}
	
	public void setLODocumentType() {
		this.documentType = DocumentTypeConst.LO;
		//RequestContext.getCurrentInstance().execute("uploadDialog.show()");
	}
	
	public void setLADocumentType() {
		this.documentType = DocumentTypeConst.LA;
		//RequestContext.getCurrentInstance().execute("uploadDialog.show()");
	}
	
	public void listSPADocumentType() {
		DocumentReferenceService documentReferenceService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		documentReferences = documentReferenceService.findByAccountIdAndDocType(account.getAccountId(), DocumentTypeConst.SPA);
	}
	
	public void listLODocumentType() {
		DocumentReferenceService documentReferenceService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		documentReferences = documentReferenceService.findByAccountIdAndDocType(account.getAccountId(), DocumentTypeConst.LO);
	}
	
	public void listLADocumentType() {
		DocumentReferenceService documentReferenceService = (DocumentReferenceService) SpringBeanUtil.lookup(DocumentReferenceService.class.getName());
		documentReferences = documentReferenceService.findByAccountIdAndDocType(account.getAccountId(), DocumentTypeConst.LA);
	}
	
	public String listProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projects = projectService.findAllProjects();
		
		return "updateSelectProject";
	}

	public String listAccounts(){
		listProject = CodeUtil.getProjectAsItems();
		
		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
		UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());

		if (StringUtils.hasText(unitNo)) {
			inventories = inventoryService.getAvailableInventories(projectId, unitNo);
		} else {
			inventories = inventoryService.getAvailableInventories(projectId);
		}
		accounts = new ArrayList<Account>();
		
		AuthUser user = getCurrentUser();
		Long userId = user.getUserProfile().getUserId();
		UserProfile userProfile = userProfileService.findById(userId);
			
		for(ProjectInventory projectInventory: inventories)
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
		}
		
		return "updatePropertyList";
	}
	
	public String selectAccount() {
		availableCustomers = new ArrayList<Customer>();
		
		if (account.getCustomer() != null) {
			availableCustomers.add(account.getCustomer());
		}
		if (account.getCustomer2() != null) {
			availableCustomers.add(account.getCustomer2());
		}
		if (account.getCustomer3() != null) {
			availableCustomers.add(account.getCustomer3());
		}
		if (account.getCustomer4() != null) {
			availableCustomers.add(account.getCustomer4());
		}
		if (account.getCustomer5() != null) {
			availableCustomers.add(account.getCustomer5());
		}
		
		disableLoanFields = "N";
		if (account.getPurchaseType() != null) {
			if (account.getPurchaseType().equalsIgnoreCase(PurchaseTypeConst.CASH) || account.getPurchaseType().equalsIgnoreCase(PurchaseTypeConst.PENDING_LOAN)) {
				if (account.getAccountStatus().equalsIgnoreCase(CommonConst.STATUS_ACTIVE)) {
					disableLoanFields = "Y";
				} else {
					disableLoanFields = "N"; 
				}
			} else {
// Disable changes on Loan information once the first billing is issued.
				if (account.getLoVerifiedBy() != null) {
					disableLoanFields = "Y";
				}			
			} 
		}
		
		return "salesProgressUpdate";
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
	
	public String verify() {
		AuthUser user = getCurrentUser();
		long userId = user.getUserProfile().getUserId();
		if(this.documentType.equalsIgnoreCase(DocumentTypeConst.SPA)) {
			account.setSpaVerifiedBy(userId);
		} else if(this.documentType.equalsIgnoreCase(DocumentTypeConst.LO)) {
			account.setLoVerifiedBy(userId);
		} else if(this.documentType.equalsIgnoreCase(DocumentTypeConst.LA)) {
			account.setLaVerifiedBy(userId);
		}
		return "salesProgressUpdate";
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
	
	private int countDeleteCustomer = 0;
	public String verifyDeleteCustomer() {
		String display = "none";

		int lastCustomerNo = 0;
		if(account.getCustomer5() != null) {
			lastCustomerNo = 5;
		} else if(account.getCustomer4() != null) {
			lastCustomerNo = 4;
		} else if(account.getCustomer3() != null) {
			lastCustomerNo = 3;
		} else if(account.getCustomer2() != null) {
			lastCustomerNo = 2;
		} else {
			lastCustomerNo = 1;
		}
		
		countDeleteCustomer = countDeleteCustomer + 1;
		
		if(countDeleteCustomer == lastCustomerNo) {
			if(countDeleteCustomer > 1) {
				display = "inline";
			}
			countDeleteCustomer = 0;
		}
		
		return display;
	}
	
	private int countAddCustomer = 0;
	public String verifyAddCustomer() {
		String display = "none";
		
		int lastCustomerNo = 0;
		if(account.getCustomer5() != null) {
			lastCustomerNo = 5;
		} else if(account.getCustomer4() != null) {
			lastCustomerNo = 4;
		} else if(account.getCustomer3() != null) {
			lastCustomerNo = 3;
		} else if(account.getCustomer2() != null) {
			lastCustomerNo = 2;
		} else {
			lastCustomerNo = 1;
		}
		
		countAddCustomer = countAddCustomer + 1;
		
		if(countAddCustomer == lastCustomerNo) {
			if(countAddCustomer < 5) {
				display = "inline";
			}
			countAddCustomer = 0;
		}
			
		return display;
	}
	
	public String verifyByDocumentType(String docType) {
		String display = "none";
		AuthUser user = getCurrentUser();
		String groupId = user.getUserProfile().getUserGroup().getGroupId();
		if(docType.equalsIgnoreCase(DocumentTypeConst.SPA)) {
			if(groupId.equalsIgnoreCase(UserGroupConst.SALES_ADM) || groupId.equalsIgnoreCase(UserGroupConst.MANAGEMENT) || groupId.equalsIgnoreCase(UserGroupConst.ADMIN) || groupId.equalsIgnoreCase(UserGroupConst.SALES_PIC)) {
				display = "inline";
			}
		} else if(docType.equalsIgnoreCase(DocumentTypeConst.LO)) {
			if(groupId.equalsIgnoreCase(UserGroupConst.SALES_ADM) || groupId.equalsIgnoreCase(UserGroupConst.MANAGEMENT) || groupId.equalsIgnoreCase(UserGroupConst.ADMIN) || groupId.equalsIgnoreCase(UserGroupConst.SALES_PIC)) {
				display = "inline";
			}
		} else if(docType.equalsIgnoreCase(DocumentTypeConst.LA)) {
			if(groupId.equalsIgnoreCase(UserGroupConst.SALES_ADM) || groupId.equalsIgnoreCase(UserGroupConst.MANAGEMENT) || groupId.equalsIgnoreCase(UserGroupConst.ADMIN) || groupId.equalsIgnoreCase(UserGroupConst.SALES_PIC)) {
				display = "inline";
			}
		}
		return display;
	}
	
	public String update() {
		
		if (account.getSpaSignedDate() != null && account.getSpaSolicitorId() == 0) {
			addErrorMessage("Invalid SPA Solicitor",
					"Please select SPA Solicitor from the dropdown list.");
			return "salesProgressUpdate";
		} 
		
		if (account.getLaSignedDate() != null && account.getLaSolicitorId() == 0) {
			addErrorMessage("Invalid LA Solicitor",
					"Please select LA Solicitor from the dropdown list.");
			return "salesProgressUpdate";
		}
		
		if (account != null) {
			AccountService accountService=  (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());

			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
			UserProfile salesProfile = userProfileService.findById(account.getSalesPersonId());
			if(salesProfile != null) {
				account.setSalesPerson(salesProfile.getName());
			}
			
			if (account.getSpaSignedDate() != null) {
				Date tempDate = account.getSpaSignedDate();
				Calendar tempCal = Calendar.getInstance();
				tempCal.setTime(tempDate);
				int tempYear = tempCal.get(Calendar.YEAR);		
				if (tempYear < 2000) {
					tempYear = tempYear + 2000;
					tempCal.set(Calendar.YEAR, tempYear);
					account.setSpaSignedDate(tempCal.getTime());
				}				
			}
			
			if (account.getLaSignedDate() != null) {	
				Date tempDate = account.getLaSignedDate();
				Calendar tempCal = Calendar.getInstance();
				tempCal.setTime(tempDate);
				int tempYear = tempCal.get(Calendar.YEAR);			
				if (tempYear < 2000) {
					tempYear = tempYear + 2000;
					tempCal.set(Calendar.YEAR, tempYear);
					account.setLaSignedDate(tempCal.getTime());
				}
			}

			if (account.getLoSignedDate() != null) {
				Date tempDate = account.getLoSignedDate();
				Calendar tempCal = Calendar.getInstance();
				tempCal.setTime(tempDate);
				int tempYear = tempCal.get(Calendar.YEAR);
				if (tempYear < 2000) {
					tempYear = tempYear + 2000;
					tempCal.set(Calendar.YEAR, tempYear);
					account.setLoSignedDate(tempCal.getTime());
				}
			}
			
			if (account.getDatePurchased() != null) {
				Date tempDate = account.getDatePurchased();
				Calendar tempCal = Calendar.getInstance();
				tempCal.setTime(tempDate);
				int tempYear = tempCal.get(Calendar.YEAR);			
				if (tempYear < 2000) {
					tempYear = tempYear + 2000;
					tempCal.set(Calendar.YEAR, tempYear);
					account.setDatePurchased(tempCal.getTime());
				}
			}
			
			account.setChangedBy(salesProfile.getUserId());
			account.setDateChanged(new Date());
			
			accountService.update(account);
			addInfoMessage("Information", "Sales Update Completed Successfully.");
			return listAccounts();
		} else {
			addInfoMessage("WARNING!", "Update Failed.");
			return "salesProgressUpdate";
		}
	}
	
	public void upload(FileUploadEvent event){
		
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
		String docType = documentType;
	    
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

	    addInfoMessage("Upload Successful", "File(s) is uploaded");
	    
	}
	
	public String searchCustomer() {
		if (!StringUtils.hasText(searchIdNo)
				&& !StringUtils.hasText(searchName)) {
			setSearchCustList(null);
			addErrorMessage("Search Customer", "Please enter customer name or Id No.");
			return null;
		}

		CustomerService customerService = (CustomerService) SpringBeanUtil.lookup(CustomerService.class.getName());

		if (StringUtils.hasText(searchName) || StringUtils.hasText(searchIdNo)) {
			setSearchCustList(customerService.findByIdNoName(searchIdNo, searchName));
		}

		individual = new Customer();
		company = new Customer();
		address = new Address();

		return null;
	}
	
	public void setCustomerId(Long customerId) {
		setCustomerId(customerId + "");
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
		this.customerNo = "";
	}
	
	public void setCustomerNo(Long customerId) {
		setCustomerNo(customerId + "");
	}
	
	public void setCustomerNo(String customerId) {
		this.customerId = "";
		
		if(account.getCustomer2() != null && account.getCustomer2().getCustomerId().toString().equalsIgnoreCase(customerId)) {
			this.customerNo = "2";
		} else if(account.getCustomer3() != null && account.getCustomer3().getCustomerId().toString().equalsIgnoreCase(customerId)) {
			this.customerNo = "3";
		} else if(account.getCustomer4() != null && account.getCustomer4().getCustomerId().toString().equalsIgnoreCase(customerId)) {
			this.customerNo = "4";
		} else if(account.getCustomer5() != null && account.getCustomer5().getCustomerId().toString().equalsIgnoreCase(customerId)) {
			this.customerNo = "5";
		} else {
			this.customerNo = "1";
		}
	}
	
	public void changeSelectedCustomer() {
		setAccountCustomer(selectedCustomer);
	}
	
	public void deleteByCustomerId(Long customerId) {
		deleteByCustomerId(customerId + "");
	}
	
	public void deleteByCustomerId(String customerId) {

		if(account.getCustomer5() != null && account.getCustomer5().getCustomerId().toString().equalsIgnoreCase(customerId)) {
			account.setCustomer5(null);
		} else if(account.getCustomer4() != null && account.getCustomer4().getCustomerId().toString().equalsIgnoreCase(customerId)) {
			account.setCustomer4(null);
		} else if(account.getCustomer3() != null && account.getCustomer3().getCustomerId().toString().equalsIgnoreCase(customerId)) {
			account.setCustomer3(null);
		} else if(account.getCustomer2() != null && account.getCustomer2().getCustomerId().toString().equalsIgnoreCase(customerId)) {
			account.setCustomer2(null);
		}
		
		selectAccount();
	}
	
	public void setAccountCustomer(Customer customer)
	{
		if((account.getCustomer2() != null && account.getCustomer2().getCustomerId().toString().equalsIgnoreCase(customerId)) || customerNo.equalsIgnoreCase("1")) {
			account.setCustomer2(customer);
			setCustomerName2(customer.getFullName());
		} else if((account.getCustomer3() != null && account.getCustomer3().getCustomerId().toString().equalsIgnoreCase(customerId)) || customerNo.equalsIgnoreCase("2")) {
			account.setCustomer3(customer);
			setCustomerName3(customer.getFullName());
		} else if((account.getCustomer4() != null && account.getCustomer4().getCustomerId().toString().equalsIgnoreCase(customerId)) || customerNo.equalsIgnoreCase("3")) {
			account.setCustomer4(customer);
			setCustomerName4(customer.getFullName());
		} else if((account.getCustomer5() != null && account.getCustomer5().getCustomerId().toString().equalsIgnoreCase(customerId)) || customerNo.equalsIgnoreCase("4")) {
			account.setCustomer5(customer);
			setCustomerName5(customer.getFullName());
		} else {
			account.setCustomer(customer);
			setCustomerName(customer.getFullName());
		}

		selectAccount();
	}
	
	public String toAddIndividual() {
		individual = new Customer();
		address = new Address();
		return "addIndividual";
	}

	public String toAddCompany() {
		company = new Customer();
		address = new Address();
		return "addCompany";
	}
	
	public String saveIndividual() {
		try {
			if (address.getCountry().equals(CommonConst.MALAYSIA)) {
				if (!StringUtils.hasText(address.getCity())) {
					addErrorMessage("WARNING!",
							"Please enter a City Name in Malaysia");
					return null;
				}
				if (!StringUtils.hasText(address.getState())) {
					addErrorMessage("WARNING!",
							"Please select a valid State in Malaysia.");
					return null;
				}
			}
			
			String fname = individual.getFullName();
			individual.setFullName(fname.toUpperCase());
			
			CustomerService customerService = (CustomerService) SpringBeanUtil.lookup(CustomerService.class.getName());
			individual.setCustomerCategory(CustomerTypeConst.INDIVIDUAL);
			customerService.insert(individual);

			AddressService addressService = (AddressService) SpringBeanUtil.lookup(AddressService.class.getName());
			address.setCustomer(individual);
			String aline1 = address.getAddressLine1();
			address.setAddressLine1(aline1.toUpperCase());
			String aline2 = address.getAddressLine2();
			address.setAddressLine2(aline2.toUpperCase());
			String aline3 = address.getAddressLine3();
			address.setAddressLine3(aline3.toUpperCase());
			String aline4 = address.getAddressLine4();
			address.setAddressLine4(aline4.toUpperCase());
			String acity = address.getCity();
			address.setCity(acity.toUpperCase());			
			addressService.insert(address);

			individual.setAddressId(address.getAddressId());

			customerService.update(individual);
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Individual", t.getMessage());
			return null;
		}
		
		setAccountCustomer(individual);
		
		return "salesProgressUpdate";
	}

	public String saveCompany() {
		try {
			if (address.getCountry().equals(CommonConst.MALAYSIA)) {
				if (!StringUtils.hasText(address.getCity())) {
					addErrorMessage("WARNING!",
							"Please enter a City Name in Malaysia");
					return null;
				}
				if (!StringUtils.hasText(address.getState())) {
					addErrorMessage("WARNING!",
							"Please select a valid State in Malaysia.");
					return null;
				}
			}
			
			String fname = company.getFullName();
			company.setFullName(fname.toUpperCase());
			
			CustomerService customerService = (CustomerService) SpringBeanUtil.lookup(CustomerService.class.getName());
			company.setCustomerCategory(CustomerTypeConst.COMPANY);
			customerService.insert(company);

			AddressService addressService = (AddressService) SpringBeanUtil.lookup(AddressService.class.getName());
			address.setCustomer(company);
			String aline1 = address.getAddressLine1();
			address.setAddressLine1(aline1.toUpperCase());
			String aline2 = address.getAddressLine2();
			address.setAddressLine2(aline2.toUpperCase());
			String aline3 = address.getAddressLine3();
			address.setAddressLine3(aline3.toUpperCase());
			String aline4 = address.getAddressLine4();
			address.setAddressLine4(aline4.toUpperCase());
			String acity = address.getCity();
			address.setCity(acity.toUpperCase());			
			addressService.insert(address);

			company.setAddressId(address.getAddressId());
			customerService.update(company);
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Company", t.getMessage());
			return null;
		}
		
		setAccountCustomer(company);
		
		return "salesProgressUpdate";
	}

	public List<SelectItem> getListSpecial() {
		return listSpecial;
	}

	public void setListSpecial(List<SelectItem> listSpecial) {
		this.listSpecial = listSpecial;
	}

	public List<SelectItem> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<SelectItem> listUsers) {
		this.listUsers = listUsers;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public List<SelectItem> getListSalesPersons() {
		return listSalesPersons;
	}

	public void setListSalesPersons(List<SelectItem> listSalesPersons) {
		this.listSalesPersons = listSalesPersons;
	}

	public String getDisableLoanFields() {
		return disableLoanFields;
	}

	public void setDisableLoanFields(String disableLoanFields) {
		this.disableLoanFields = disableLoanFields;
	}

}
