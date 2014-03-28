package com.vipro.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.vipro.data.Account;
import com.vipro.data.ProgressiveBilling;
import com.vipro.dto.BillingModelStageDTO;
import com.vipro.dto.ChangeAddressDTO;
import com.vipro.dto.PaymentEntryDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;

public interface ProgressiveBillingService {

	
	public List<ProgressiveBilling> getProgressiveBilling(Long accountId);
		
	public void insert(ProgressiveBilling p);
	
	public void update(ProgressiveBilling p);
	
	public void delete(Long inventoryId);
	
	public void changeAddress(ChangeAddressDTO corDTO, Account account);
	
	public List<BillingModelStageDTO> getBillingModelListByProjectBillingModelCode(
			Long projectId, String billingModelCode, Long accountId); 
	
	public Long getAndUpdteSeqNO(String projectCode, String seqType, boolean isIncrement);

	public boolean generateProgressiveBillForSelectedStages(List<BillingModelStageDTO> stageDtoList, Long refNo, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto);
	public boolean generateRenoticesForSelectedStages(List<BillingModelStageDTO> stageDtoList, Long refNo, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto, BigDecimal purchaserStageAmount);
	public boolean generatePaymentForInvoice(PaymentEntryDTO selectDto,BigDecimal paymentAmount, String paymentMethod, String bank, String chqNo, Date selectedChkDate);
	public BigDecimal  getRemaingPaymentAmountByAccountIdStatusAndInvoiceNo(Long accountId, String[] statuses, String invoiceNo);
	
	public void printProgressiveLetter(String amount, Long projectId , String invoiceNo,String accountId);
	public void printProgressiveLetterCash(String amount, Long projectId , String invoiceNo,String accountId);
	public void printProgressiveLetterPurchaser(String amount, Long projectId , String invoiceNo,String accountId);

	public void printRenoticeLetter(String amount, Long projectId, String invoiceNo, String accountId, BigDecimal financierPortion, BigDecimal purchaserPortion);
}
