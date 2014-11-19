package com.vipro.service;

import java.math.BigDecimal;
import java.util.List;

import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.dto.AdviseUpdateDetailsDTO;
import com.vipro.dto.PaymentEntryDTO;
import com.vipro.dto.TransactionEntryDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.dto.PropertyUnitDetailsDTO;
import com.vipro.dto.SalesByAgentItemDTO;
import com.vipro.dto.TotalLoanOfferedItemDTO;
import com.vipro.dto.ManualEntryApprovalDTO;
import com.vipro.dto.LoanCancellationDTO;

public interface ProjectService {
  
	public List<Project> findAllProjects();
	public Project findById(Long projectId);
	public Project findByIdAndUnit(Long projectId, String unit);
	public List<PropertyUnitDetailsDTO> getPropertyUnitDetailsDTOListByProjectIdAndUnit(Long projectId, String UnitNo);

	public List<AdviseUpdateDetailsDTO> getAdviseUpdateDetailsDTOListByProjectIdAndUnit(Long projectId, String UnitNo);
	public List<ProgressiveBillingUnitSeachDTO> getProgressiveBillingUnitSearchDTOListByProjectIdAndUnit(Long projectId, String UnitNo);
	public List<PaymentEntryDTO> getPaymentEntryDTOListByProjectIdAndUnit(Long projectId, String UnitNo);
	public List<TransactionEntryDTO> getTransactionEntryDTOListByProjectIdAndUnit(Long projectId, String UnitNo);
	public List<ProjectInventory> findInventories(Long projectId);
	public List<ManualEntryApprovalDTO> getManualEntryApprovalDTOList(Long projectId, String UnitNo);
	public List<LoanCancellationDTO> getLoanCancellationByProjectIdAndUnit(Long projectId, String UnitNo);
	
	public void insert(Project p);
	public void update(Project p);
	public void deleteProject(Long projectId);
	
	public void insert(ProjectInventory i);
	public void update(ProjectInventory i);
	public void deleteInventory(Long inventoryId);
	
	public List<String> getTotalInventoryBlocks();
	public Long getBlockCountByNo(String blockNo,Long projectId);
	public BigDecimal getValidityPeriodSum(String blockNo, Long projectId,String type);
	public Long getA5NameBlockCountByNo(String blockNo,Long projectId,Long landProprietorID);
	public BigDecimal addA5NameSum(String blockNo, Long projectId,String type,Long landProprietorID);
	public Long getBookingCountByNo(String blockNo,Long projectId);
	public BigDecimal addBookingSum(String blockNo, Long projectId,String type);
	public Long getSPACountByNo(String blockNo,Long projectId);
	public BigDecimal addSPASum(String blockNo, Long projectId,String type);
	public Long getCashCountByNo(String blockNo,Long projectId);
	public BigDecimal addCashSum(String blockNo, Long projectId,String type);
	public Long getLOCountByNo(String blockNo, Long projectId);
	public BigDecimal addLOSum(String blockNo, Long projectId, String type);
	public Long getLACountByNo(String blockNo, Long projectId);
	public BigDecimal addLASum(String blockNo, Long projectId, String type);
	public Long getAdviseCountByNo(String blockNo, Long projectId);
	public BigDecimal addAdviseSum(String blockNo, Long projectId, String type);
	
	public List<TotalLoanOfferedItemDTO> getTotalLoanOfferedByProjectId(Long projectId);
	public List<SalesByAgentItemDTO> getSalesByAgentByProjectId(Long projectId);
}
