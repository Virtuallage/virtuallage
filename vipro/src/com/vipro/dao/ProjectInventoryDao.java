package com.vipro.dao;

import java.math.BigDecimal;
import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.ProjectInventory;

public interface ProjectInventoryDao extends Dao<ProjectInventory>{

	
	public List<ProjectInventory> findByProjectId(Long projectId);
	
	public List<ProjectInventory> findByProjectIdUnitNo(Long projectId, String unitNo);
	
	public List<ProjectInventory> findLockedUnit(Long projectId, Long userId);
	
	public List<ProjectInventory> findByAvailableProjectId(Long projectId);
	
	public ProjectInventory findById(Long id);
	
	public ProjectInventory findByCompositeKey(Long projectId, String blockNo, String unit, String level);

	public int countTotalUnits(Long projectId);
	
	public List<String> getTotalInventoryBlocks();
	public Long getBlockCountByNo(String blockNo,Long projectId);
	public BigDecimal getValidityPeriodSum(String blockNo, Long projectId,String type);
	public Long getA5NameBlockCountByNo(String blockNo, Long projectId,Long businessPartnerId);
	public BigDecimal addA5NameSum(String blockNo, Long projectId,String type,Long landProprietorId);
	public Long getBookingCountByNo(String blockNo,Long projectId);
	public BigDecimal addBookingSum(String blockNo, Long projectId,String type);
	public Long getSPACountByNo(String blockNo, Long projectId);
	public BigDecimal addSPASum(String blockNo, Long projectId, String type);
	public Long getCashCountByNo(String blockNo, Long projectId);
	public BigDecimal addCashSum(String blockNo, Long projectId, String type);
	
	public Long getLOCountByNo(String blockNo, Long projectId);
	public BigDecimal addLOSum(String blockNo, Long projectId, String type);
	public Long getLACountByNo(String blockNo, Long projectId);
	public BigDecimal addLASum(String blockNo, Long projectId, String type);
	public Long getAdviseCountByNo(String blockNo, Long projectId);
	public BigDecimal addAdviseSum(String blockNo, Long projectId, String type);
	
	
	public List<Object> getTotalLoanOfferedByProjectId(Long projectId);
	public List<Object> getSalesByAgentByProjectId(Long projectId);
}
