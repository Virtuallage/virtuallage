package com.vipro.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;

import com.vipro.data.Account;
import com.vipro.data.ProgressiveBilling;
import com.vipro.dto.BillingModelStageDTO;
import com.vipro.dto.ChangeAddressDTO;
import com.vipro.dto.PaymentEntryDTO;
import com.vipro.dto.TransactionEntryDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.dto.BillingReturnParaDTO;

public interface ProgressiveBillingService {

	
	public List<ProgressiveBilling> getProgressiveBilling(Long accountId);
		
	public void insert(ProgressiveBilling p);
	
	public void update(ProgressiveBilling p);
	
	public void delete(Long inventoryId);
	
	public void changeAddress(ChangeAddressDTO corDTO, Account account);
	
	public List<BillingModelStageDTO> getBillingModelListByProjectBillingModelCode(
			Long projectId, String billingModelCode, Long accountId); 
	
	public Long getAndUpdteSeqNO(String projectCode, String seqType, boolean isIncrement);
	public Long getNextSeqNO(String projectCode, String seqType, boolean isIncrement);
	public Long getCurrentSeqNO(String projectCode, String seqType, boolean isIncrement);	

	public BillingReturnParaDTO generateProgressiveBillForSelectedStages(List<BillingModelStageDTO> stageDtoList, Long refNo, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto, 
			Integer splitStageSeqNo, BigDecimal financierStageAmount, BigDecimal purchaserStageAmount, BigDecimal financierPortion);

	public boolean generateRenoticesForSelectedStages(List<BillingModelStageDTO> stageDtoList, Long refNo, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto, 
			BigDecimal financierStageAmount, BigDecimal financierPortion, String firstStageSelected);
	public boolean generatePaymentForInvoice(PaymentEntryDTO selectDto,BigDecimal paymentAmount, String paymentMethod, String bank, String chqNo, Date selectedChkDate, String selectedInvoice);
	public BigDecimal  getRemaingPaymentAmountByAccountIdStatusAndInvoiceNo(Long accountId, String[] statuses, String invoiceNo);
	public boolean generateReversalForBilling(PaymentEntryDTO selectDto,BigDecimal txnAmount, String selectedInvoice);
	public boolean processTransactionUpdate(TransactionEntryDTO selectDto,BigDecimal txnAmount, String selectedInvoice);
	
	public void printProgressiveLetter(String amount, Long projectId , String invoiceNo,String accountId, String lastStageSelected);
	public void printProgressiveLetterCash(String amount, Long projectId , String invoiceNo,String accountId, String lastStageSelected);
	public void printProgressiveLetterPurchaser(String amount, Long projectId , String invoiceNo,String accountId, String lastStageSelected);
	public void printProgressiveLetterPurchaserSplit(String amount, Long projectId , String invoiceNo,String accountId, String lastStageSelected);
	public void printProgressiveLetterFinancierSplit(String amount, Long projectId , String invoiceNo,String accountId, String lastStageSelected);
	
	public void printRenoticeLetter(String amount, Long projectId, String invoiceNo, String accountId, BigDecimal financierPortion, BigDecimal purchaserPortion, String firstStageSelected);

}
