package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.vipro.constant.CustomerTypeConst;
import com.vipro.constant.DocumentTypeConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
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
	
	private ProjectInventory inventory;
	private Long projectId;
	private Project project;
	private String customerName;
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
	private List<Customer> searchCustList;
	private Customer selectedCustomer;
	private Customer delCustomer;

	private Customer individual;
	private Customer company;
	private Address address;
		
	@PostConstruct
	public void init() {
		purchaseTypes = CodeUtil.getCodes("PU");
		listCountry = CodeUtil.getCodes("CT");
		listCity = CodeUtil.getCodes("CI");
		listIdType = CodeUtil.getCodes("ID");
		listTitle = CodeUtil.getCodes("TT");
		listGender = CodeUtil.getCodes("SX");
		listMaritalStatus = CodeUtil.getCodes("MS");
		listBumi = CodeUtil.getCodes("BM");
		listRace = CodeUtil.getCodes("RC");
		listState = CodeUtil.getCodes("ST");
		listSolicitors = CodeUtil.getBusinessPartnerAsItems(BusinessPartnerTypeConst.SOLICITOR);
		listPanelBanks = CodeUtil.getBusinessPartnerAsItems(BusinessPartnerTypeConst.BANK);

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

		inventories = inventoryService.getInventories(projectId);
		accounts = new ArrayList<Account>();
		
		AuthUser user = getCurrentUser();
		Long userId = user.getUserProfile().getUserId();
		UserProfile userProfile = userProfileService.findById(userId);
		
		
		for(ProjectInventory projectInventory: inventories)
		{
			List<Account> dataList = accountService.findByProjectInventoryId(projectInventory.getInventoryId());
			if(dataList != null && dataList.size() > 0) {
				if(userProfile.getUserGroup().getGroupId().equalsIgnoreCase("SALES_PIC") ||
						userProfile.getUserGroup().getGroupId().equalsIgnoreCase("ADMIN"))
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
		setSelectedCustomer(account.getCustomer());
		setCustomerName(account.getCustomer().getFullName());
		return "salesProgressUpdate";
	}
	
	public String update() {
		
		if (account != null) {
			AccountService accountService=  (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			account.setCustomer(selectedCustomer);
			accountService.update(account);
			addInfoMessage("Sales Update", "Updated Successfully.");
			return listAccounts();
		} else {
			addInfoMessage("Sales Update", "Failed to update.");
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
	
	public void changeSelectedCustomer() {
		setCustomerName(selectedCustomer.getFullName());
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
			CustomerService customerService = (CustomerService) SpringBeanUtil.lookup(CustomerService.class.getName());
			individual.setCustomerCategory(CustomerTypeConst.INDIVIDUAL);
			customerService.insert(individual);

			AddressService addressService = (AddressService) SpringBeanUtil.lookup(AddressService.class.getName());
			address.setCustomer(individual);
			addressService.insert(address);

			individual.setAddressId(address.getAddressId());

			customerService.update(individual);
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Individual", t.getMessage());
			return null;
		}
		
		setSelectedCustomer(individual);
		setCustomerName(individual.getFullName());
		
		return "salesProgressUpdate";
	}

	public String saveCompany() {
		try {
			CustomerService customerService = (CustomerService) SpringBeanUtil.lookup(CustomerService.class.getName());
			company.setCustomerCategory(CustomerTypeConst.COMPANY);
			customerService.insert(company);

			AddressService addressService = (AddressService) SpringBeanUtil.lookup(AddressService.class.getName());
			address.setCustomer(company);
			addressService.insert(address);

			company.setAddressId(address.getAddressId());
			customerService.update(company);
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Company", t.getMessage());
			return null;
		}
		
		setSelectedCustomer(company);
		setCustomerName(company.getFullName());
		
		return "salesProgressUpdate";
	}

}
