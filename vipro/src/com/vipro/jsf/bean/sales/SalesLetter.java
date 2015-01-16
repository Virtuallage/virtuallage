package com.vipro.jsf.bean.sales;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.util.StringUtils;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CommonConst;
import com.vipro.constant.JasperConst;
import com.vipro.data.Account;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.UserProfile;
import com.vipro.data.Letter;
import com.vipro.data.LetterHistory;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.LetterHistoryService;
import com.vipro.service.LetterService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.JasperUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "salesLetter")
@SessionScoped
public class SalesLetter extends CommonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2107834150458219530L;

	private List<SelectItem> listProject = null;

	private List<Project> projects;
	private List<ProjectInventory> inventories;
	private ProjectInventory inventory;
	private List<Letter> letters;
	private Letter letter;
	private LetterHistory letterHistory;
	private Long projectId;
	private String projectName;
	private String unitNo;
	private String selectedUnitNo;
	private String selectedLetter;
	private String purchaserName;
	private Project project;
	private List<Account> accounts;
	private Account account;
	private UserProfile attendedBy;
	private Long currentUserId;
	private String whatFileName;
	private String reportName;
	private String jasperName;
	private String confirmMessage;
	private String lh_createdBy;
	private Date lh_createdDate;

	private CommandButton submitButton;
	private CommandButton viewButton;
	
    private StreamedContent dFile;

	@PostConstruct
	public void init() {
		listProject = CodeUtil.getProjectAsItems();
	}

	public List<SelectItem> getListProject() {
		listProject = CodeUtil.getProjectAsItems();
		return listProject;
	}

	public void setListProject(List<SelectItem> listProject) {
		this.listProject = listProject;
	}

	public UserProfile getAttendedBy() {
		return attendedBy;
	}

	public void setAttendedBy(UserProfile attendedBy) {
		this.attendedBy = attendedBy;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public Letter getLetter() {
		return letter;
	}

	public void setLetter(Letter letter) {
		this.letter = letter;
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
	
	public String listPropertyUnits() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		project = projectService.findById(projectId);
		
		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());
		
		if (StringUtils.hasText(unitNo)) {
			inventories = inventoryService.getUnAvailableInventories(projectId, unitNo);
		} else {
			inventories = inventoryService.getUnAvailableInventories(projectId);
		}
		return "selectLetter";
	}

	public String GetUserNameByUserId(Long id){
		String userName = "";
		UserProfileService userProfileService = (UserProfileService) SpringBeanUtil
				.lookup(UserProfileService.class.getName());
		UserProfile up = userProfileService.findById(id);
		userName = up.getName();
		return userName;
	}

	public Long GetAccountIdByInventoryId(Long id){
		Long accountid = null;
		AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
		List<Account> accounts = accountService.findByAvailableProjectInventoryId(id);
		for (Account account : accounts) {
			accountid = account.getAccountId();
		}
		return accountid;
	}

	public String selectAccount() {
		setProjectName(project.getProjectName());
		setSelectedUnitNo(inventory.getUnitNo());
		refreshAccount();
		return "selectAccount";
	}
	
	public String selectInventory() {
		refreshLetterHistory();
		return "listLetter";
	}
	
	public void refreshLetterHistory() {
		LetterService letterService = (LetterService) SpringBeanUtil
				.lookup(LetterService.class.getName());
		
		Long project_id = inventory.getProject().getProjectId();
		String active_sts = CommonConst.STATUS_ACTIVE;
		letters = letterService.findByProjectIdStatus(project_id, active_sts);
	}
	
	public void refreshAccount() {
		AccountService accountService = (AccountService) SpringBeanUtil
				.lookup(AccountService.class.getName());
		
		accounts = accountService.findAllByProjectInventoryId(inventory.getInventoryId());
	}

	public String letterGenBy(Long letterid) {

		LetterHistoryService lhService = (LetterHistoryService) SpringBeanUtil.
				lookup(LetterHistoryService.class.getName());
		
		Long account_id = account.getAccountId();
		
		List<LetterHistory> lhs = lhService.findByLetterIdAccount(letterid, account_id);
		
		if (lhs.size() == 0) {
			setLh_createdBy(null);
			setLh_createdDate(null);
		} else {
			letterHistory = lhs.get(0);
			setLh_createdBy(GetUserNameByUserId(letterHistory.getCreatedBy()));
			setLh_createdDate(letterHistory.getDateCreated());
		}
		return lh_createdBy;
	}
	
	public String displayValue(Long letterid) {

		String buttonValue = "SUBMIT";

		LetterHistoryService lhService = (LetterHistoryService) SpringBeanUtil.
				lookup(LetterHistoryService.class.getName());
		
		Long account_id = account.getAccountId();
		
		List<LetterHistory> lhs = lhService.findByLetterIdAccount(letterid, account_id);

		// Not found in Letter History, Show SUBMIT button
		if (lhs.size() == 0) {
			submitButton.setStyle("");
			viewButton.setStyle("display: none");
		} else {
			submitButton.setStyle("display: none");
			viewButton.setStyle("");
		}
		
		return buttonValue;
	}

	public void selectLetter() {
		setWhatFileName(letter.getJasperName());
		int position = whatFileName.indexOf(".");
		reportName = whatFileName.substring(0, position) + ".PDF";
		jasperName = whatFileName.substring(0, position) + ".jrxml";
	}
	
	public String onSubmit() {
		selectLetter();
		confirmMessage = "Please confirm generate the following letter for " + selectedUnitNo + ":";
		selectedLetter = getCodeDesc("LE", letter.getLetterCode());
		return null;
	}

	public void genLetter(ActionEvent actionEvent) {	
		// save letter history
		
		AuthUser user = getCurrentUser();
		if (user != null) {
			attendedBy = user.getUserProfile();
			setCurrentUserId(attendedBy.getUserId());
		}

		LetterHistoryService lhService = (LetterHistoryService) SpringBeanUtil.
				lookup(LetterHistoryService.class.getName());
		
		letterHistory = new LetterHistory();
		letterHistory.setAccount(account);
		letterHistory.setLetter(letter);
		letterHistory.setStatus(CommonConst.STATUS_NEW);
		letterHistory.setCreatedBy(getCurrentUserId());
		letterHistory.setDateCreated(new Date());
		lhService.update(letterHistory);
		
		// generate report
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("ProjectId", Long.toString(inventory.getProject().getProjectId()));
		hm.put("Unit_No", selectedUnitNo);
		hm.put("AccountId", account.getAccountId());
		hm.put("ProjectCode", inventory.getProject().getProjectCode());
		String report = JasperConst.JASPER_PATH + jasperName;
		JasperUtil.generateReport(hm, report, account, reportName);
		
		FacesContext fcontext = FacesContext.getCurrentInstance();
        fcontext.addMessage(null, new FacesMessage("Generated", "Letter " + selectedLetter + " generated successfully."));
		
		refreshLetterHistory();
	}
	
	public StreamedContent getdFile() {  
		selectLetter();
		String path ="/reports/" + account.getAccountId() + "/" + reportName;
		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);  
		dFile = new DefaultStreamedContent(stream, reportName, reportName);   
		return dFile;
    } 
	
	public void setdFile(StreamedContent dFile) {
		this.dFile = dFile;
	}

	public String backToselectLetter() {
		return "selectLetter";
	}
	
	public String backToselectAccount() {
		return "selectAccount";
	}
	
	public CommandButton getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(CommandButton submitButton) {
		this.submitButton = submitButton;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public Long getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Long currentUserId) {
		this.currentUserId = currentUserId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSelectedUnitNo() {
		return selectedUnitNo;
	}

	public void setSelectedUnitNo(String selectedUnitNo) {
		this.selectedUnitNo = selectedUnitNo;
	}

	public String getPurchaserName() {
		return purchaserName;
	}

	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}

	public List<Letter> getLetters() {
		return letters;
	}

	public void setLetters(List<Letter> letters) {
		this.letters = letters;
	}

	public String getWhatFileName() {
		return whatFileName;
	}

	public void setWhatFileName(String whatFileName) {
		this.whatFileName = whatFileName;
	}

	public String getConfirmMessage() {
		return confirmMessage;
	}

	public void setConfirmMessage(String confirmMessage) {
		this.confirmMessage = confirmMessage;
	}

	public String getSelectedLetter() {
		return selectedLetter;
	}

	public void setSelectedLetter(String selectedLetter) {
		this.selectedLetter = selectedLetter;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public CommandButton getViewButton() {
		return viewButton;
	}

	public void setViewButton(CommandButton viewButton) {
		this.viewButton = viewButton;
	}

	public LetterHistory getLetterHistory() {
		return letterHistory;
	}

	public void setLetterHistory(LetterHistory letterHistory) {
		this.letterHistory = letterHistory;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getLh_createdBy() {
		return lh_createdBy;
	}

	public void setLh_createdBy(String lh_createdBy) {
		this.lh_createdBy = lh_createdBy;
	}

	public Date getLh_createdDate() {
		return lh_createdDate;
	}

	public void setLh_createdDate(Date lh_createdDate) {
		this.lh_createdDate = lh_createdDate;
	}

}
