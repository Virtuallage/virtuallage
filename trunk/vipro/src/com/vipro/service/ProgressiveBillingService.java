package com.vipro.service;

import java.util.List;

import com.vipro.data.ProgressiveBilling;
import com.vipro.dto.*;
import com.vipro.data.*;

public interface ProgressiveBillingService {

	
	public List<ProgressiveBilling> getProgressiveBilling(Long accountId);
	
	public void insert(ProgressiveBilling p);
	
	public void update(ProgressiveBilling p);
	
	public void delete(Long inventoryId);
	
	public void changeAddress(ChangeAddressDTO corDTO, Account account);
}
