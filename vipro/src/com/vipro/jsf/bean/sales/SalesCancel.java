package com.vipro.jsf.bean.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.transaction.annotation.Transactional;

import com.vipro.auth.AuthUser;
import com.vipro.constant.AccountStatusConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.TransactionCode;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.service.AccountService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.TransactionHistoryService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "salesCancel")
@SessionScoped
public class SalesCancel {

	private List<SelectItem> cancelReasons;
	
	
	private List<Project> projects;
	private List<ProjectInventory> inventories;

	private ProjectInventory inventory;
	private Long projectId;
	private Project project;

	private String customerNames;
	private List<Customer> customers;
	private Account account;
	private TransactionHistory bookTrx;
	private UserProfile attendedBy;

	@PostConstruct
	public void init() {
		cancelReasons = CodeUtil.getCodes("CANCEL_R");
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

	public String listProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projects = projectService.findAllProjects();
		return "cancelSelectProject";
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

	public TransactionHistory getBookTrx() {
		return bookTrx;
	}

	public void setBookTrx(TransactionHistory bookTrx) {
		this.bookTrx = bookTrx;
	}


	public String listPropertyUnits() {
		if (project != null) {
			projectId = project.getProjectId();
		}

		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());
		inventories = inventoryService.getInventories(projectId);

		return "cancelSelectUnit";
	}

	public String selectInventory() {
		try {
			customers = new ArrayList<Customer>();
			account = new Account();
			account.setDatePurchased(new Date());
	
			AuthUser user = FacesUtil.getCurrentUser();
			if (user != null)
				attendedBy = user.getUserProfile();
	
			AccountService accountService = (AccountService) SpringBeanUtil
					.lookup(AccountService.class.getName());
			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil
					.lookup(UserProfileService.class.getName());
	
			List<Account> accounts = accountService
					.findByProjectInventoryId(inventory.getInventoryId());
			/**
			 * support only one account as per one property unit.
			 */
			for (Account a : accounts) {
				account = a;
				if (account.getAttendedBy() != null) {
					UserProfile up = userProfileService.findById(account
							.getAttendedBy());
					attendedBy = up;
				}
				customers = new ArrayList<Customer>();
				StringBuffer names = new StringBuffer();
				if (account.getCustomer() != null) {
					customers.add(account.getCustomer());
					names.append(account.getCustomer().getFullName()).append(", ");
				}
				if (account.getCustomer2() != null) {
					customers.add(account.getCustomer2());
					names.append(account.getCustomer().getFullName()).append(", ");
				}
				if (account.getCustomer3() != null) {
					customers.add(account.getCustomer3());
					names.append(account.getCustomer3().getFullName()).append(", ");
				}
				if (account.getCustomer4() != null) {
					customers.add(account.getCustomer4());
					names.append(account.getCustomer4().getFullName()).append(", ");
				}
				if (account.getCustomer5() != null) {
					customers.add(account.getCustomer5());
					names.append(account.getCustomer5().getFullName()).append(", ");
				}
				customerNames = names.toString();
			}
			
			
	
			Set<TransactionHistory> trxhist = account.getTransactionHistories();
			for (TransactionHistory h : trxhist) {
				if (h.getTransactionCode().getTransactionCode().equals(TransactionCodeConst.BOOK_FEE)) {
					bookTrx =h;
				}
			}
			
			if (bookTrx==null) {
				FacesUtil.addInfoMessage("Sales Cancellation", "This property Unit has no sales transaction. There is nothing to cancel.");
				return listPropertyUnits();
			}
			
			if (!TransactionStatusConst.PENDING.equals(bookTrx.getStatus())) {
				FacesUtil.addInfoMessage("Sales Cancellation", "Transaction is completed. Cancellation is not allowed");
				return listPropertyUnits();
			}
		} catch (Throwable t) {
			t.printStackTrace();
			FacesUtil.addErrorMessage("Error opening sales", t.getMessage());
			return listPropertyUnits();
		}
		
		
		return "cancel";
	}
	
	
	public String cancel() {
		try {
//			if (AccountStatusConst.CANCEL.equals(account.getAccountStatus())) {
//				FacesUtil.addErrorMessage("Sales Cancellation", "Sales is already cancelled");
//				return "cancel";
//			}
			ProjectInventoryService inventoryService=  (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
			
			inventory.setAccounts(null);
			inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_ACTIVE);
			inventoryService.update(inventory);
			
			AccountService accountService=  (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			account.setAccountStatus(AccountStatusConst.CANCEL);
			
			if (account.getRegistrationFee()!=null && account.getCancelFee()!=null && account.getCancelTax()!=null) {
				BigDecimal refundAmt = account.getRegistrationFee();
				double d = refundAmt.doubleValue();
				d = d - (account.getCancelFee().doubleValue() + account.getCancelTax().doubleValue());
				refundAmt = new BigDecimal(d);
				account.setCancelNetRefundAmt(refundAmt);
			}
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
			
			FacesUtil.addInfoMessage("Sales Cancellation", "Sales is cancelled");
		} catch (Throwable t) {
			t.printStackTrace();
			FacesUtil.addErrorMessage("Error cancelling sales", t.getMessage());
		}
		return "cancel";
	}
}
