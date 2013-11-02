package com.vipro.service;

import java.util.List;

import com.vipro.data.Account;
import com.vipro.data.ProgressiveBilling;
import com.vipro.dto.BillingModelStageDTO;
import com.vipro.dto.ChangeAddressDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;

public interface ProgressiveBillingService {

	
	public List<ProgressiveBilling> getProgressiveBilling(Long accountId);
	
	public void insert(ProgressiveBilling p);
	
	public void update(ProgressiveBilling p);
	
	public void delete(Long inventoryId);
	
	public void changeAddress(ChangeAddressDTO corDTO, Account account);
	
	public List<BillingModelStageDTO> getBillingModelListByProjectBillingModelCode(
			Long projectId, String billingModelCode, Long accountId); 
	
	public Long getLatestPBSeqNo();
	
	public boolean generateProgressiveBillForSelectedStages(List<BillingModelStageDTO> stageDtoList, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto);
	public void printProgressiveLetter(Long projectId , String invoiceNo,String accountId);
}
