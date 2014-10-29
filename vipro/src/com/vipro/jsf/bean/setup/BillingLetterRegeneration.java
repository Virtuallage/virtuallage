package com.vipro.jsf.bean.setup;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.jsf.bean.PageConst;
import com.vipro.service.ProgressiveBillingService;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean
@RequestScoped
public class BillingLetterRegeneration extends CommonBean implements PageConst {
	private String xAmountInWords;
	private Long xProjectId;
	private String xInvoiceNo;
	private String xAccountId;
	private String xLastSelectedStage;

	@PostConstruct
public void init() {
	xAmountInWords = "";
	xProjectId = new Long(0l);
	xInvoiceNo = "";
	xAccountId = "";
	xLastSelectedStage = "";

	}
	
public void cashLetter() {
		
	ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
	pbService.printProgressiveLetterCash(xAmountInWords ,xProjectId, xInvoiceNo, xAccountId, xLastSelectedStage);

	addInfoMessage("Billing Letter Regenerated", "This Invoice No has been regenerated (Cash - Bill to Purchaser): "+xInvoiceNo);

	}

public void purchaserLetter() {
	
	ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
	pbService.printProgressiveLetterPurchaser(xAmountInWords ,xProjectId, xInvoiceNo, xAccountId, xLastSelectedStage);

	addInfoMessage("Billing Letter Regenerated", "This Invoice No has been regenerated (Loan - Bill to Purchaser): "+xInvoiceNo);

	}

public void financierLetter() {
	
	ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
	pbService.printProgressiveLetter(xAmountInWords ,xProjectId, xInvoiceNo, xAccountId, xLastSelectedStage);

	addInfoMessage("Billing Letter Regenerated", "This Invoice No has been regenerated (Loan - Bill to Financier): "+xInvoiceNo);

	}

public void purchaserSplitLetter() {
	
	ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
	pbService.printProgressiveLetterPurchaserSplit(xAmountInWords ,xProjectId, xInvoiceNo, xAccountId, xLastSelectedStage);

	addInfoMessage("Billing Letter Regenerated", "This Invoice No has been regenerated (Loan - Bill to Purchaser): "+xInvoiceNo);

	}

public void financierSplitLetter() {
	
	ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
	pbService.printProgressiveLetterFinancierSplit(xAmountInWords ,xProjectId, xInvoiceNo, xAccountId, xLastSelectedStage);

	addInfoMessage("Billing Letter Regenerated", "This Invoice No has been regenerated (Loan - Bill to Financier): "+xInvoiceNo);

	}

public void clearScreen() {
	
	xAmountInWords = "";
	xProjectId = new Long(0l);
	xInvoiceNo = "";
	xAccountId = "";
	xLastSelectedStage = "";
	
	}

public String getxAmountInWords() {
	return xAmountInWords;
	}

public void setxAmountInWords(String xAmountInWords) {
	this.xAmountInWords = xAmountInWords;
	}

public Long getxProjectId() {
	return xProjectId;
	}

public void setxProjectId(Long xProjectId) {
	this.xProjectId = xProjectId;
	}

public String getxInvoiceNo() {
	return xInvoiceNo;
	}

public void setxInvoiceNo(String xInvoiceNo) {
	this.xInvoiceNo = xInvoiceNo;
	}

public String getxAccountId() {
	return xAccountId;
	}

public void setxAccountId(String xAccountId) {
	this.xAccountId = xAccountId;
	}

public String getxLastSelectedStage() {
	return xLastSelectedStage;
	}

public void setxLastSelectedStage(String xLastSelectedStage) {
	this.xLastSelectedStage = xLastSelectedStage;
	}

}
