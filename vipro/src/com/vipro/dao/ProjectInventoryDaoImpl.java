package com.vipro.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.CommonConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.constant.PurchaseTypeConst;
import com.vipro.data.ProjectInventory;

@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.ProjectInventoryDao")
public class ProjectInventoryDaoImpl extends DaoImpl<ProjectInventory>
		implements ProjectInventoryDao {

	@Override
	public List<ProjectInventory> findByProjectId(Long projectId) {
		String query = "select o from ProjectInventory o where o.project.projectId=?";
		return getHibernateTemplate().find(query, projectId);
	}
	
	@Override
	public List<ProjectInventory> findByAvailableProjectId(Long projectId) {
		String query = "select o from ProjectInventory o where o.project.projectId=? and o.propertyStatus in ('" 
				+ PropertyUnitStatusConst.STATUS_BOOKED + "', '" 
				+ PropertyUnitStatusConst.STATUS_SOLD + "')";
		return getHibernateTemplate().find(query, projectId);
	}

	@Override
	public ProjectInventory findById(Long id) {
		return getHibernateTemplate().get(ProjectInventory.class, id);
	}

	@Override
	public ProjectInventory findByCompositeKey(Long projectId, String blockNo,
			String unit, String level) {
		String query = "select o from ProjectInventory o where o.project.projectId=? "
				+ "and blockNo=? and o.unitNo=? and o.level=?";
		List<ProjectInventory> list = getHibernateTemplate().find(query,
				projectId, blockNo, unit, level);
		if (list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int countTotalUnits(Long projectId) {
		String query = "select o from ProjectInventory o where o.project.projectId=?";
		return getHibernateTemplate().find(query, projectId).size();
	}

	@Override
	public List<ProjectInventory> findByProjectIdUnitNo(Long projectId,
			String unitNo) {
		String query = "select o from ProjectInventory o where o.project.projectId=? and o.unitNo=?";
		return getHibernateTemplate().find(query, projectId, unitNo);
	}
	
	@Override
	public List<ProjectInventory> findByAvailableProjectIdUnitNo(Long projectId,String unitNo) {
		String query = "select o from ProjectInventory o where o.project.projectId=? and o.unitNo=? and o.propertyStatus in ('" 
				+ PropertyUnitStatusConst.STATUS_BOOKED + "', '" 
				+ PropertyUnitStatusConst.STATUS_SOLD + "')";
		return getHibernateTemplate().find(query, projectId, unitNo);
		
	}
	
	@Override
	public List<ProjectInventory> findLockedUnit(Long projectId, Long userId) {
		String query = "select o from ProjectInventory o where o.project.projectId=? and o.changeUserId=? and o.propertyStatus='"
				 + PropertyUnitStatusConst.STATUS_LOCKED + "'";
		return getHibernateTemplate().find(query, projectId, userId);
	}

	@Override
	public List<String> getTotalInventoryBlocks() {
		
		String query = "select distinct o.blockNo from ProjectInventory o ORDER BY o.blockNo ASC";
		List<String> resultList = (List<String>)getHibernateTemplate().find(query);
		if(resultList != null && resultList.size()>0){
			for(int i = 0; i<resultList.size(); i++){
				resultList.set(i, "Block "+resultList.get(i));
			}
			//resultList.add(0, "Description");
			//resultList.add("Total");			
			return resultList;
		}else{
			return null;
		}
	}

	@Override
	public Long getBlockCountByNo(String blockNo,Long projectId) {
		Long count = 0l;
		String query = "SELECT coalesce(Count(pin.inventoryId),0) FROM ProjectInventory pin WHERE pin.blockNo = ? AND pin.project.projectId = ? ";
		List<Long> resultList = (List<Long>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			count = resultList.get(0);
		}
		return count;
	}

	
	@Override
	public BigDecimal getValidityPeriodSum(String blockNo, Long projectId,String type) {
		BigDecimal result = new BigDecimal(0);
		String query = "";
		if(type != null && !type.isEmpty()){
			if(type.equals("Gross")){
				query = "SELECT coalesce(sum(p.purchasePrice),0) FROM ProjectInventory p WHERE p.blockNo = ? AND p.project.projectId = ?";
			}else if(type.equals("Net") ){
				query = "SELECT coalesce(sum(p.purchasePrice),0) - coalesce(sum(p.discountAmount),0) FROM ProjectInventory p WHERE p.blockNo = ? AND p.project.projectId = ?";
			}else if(type.equals("Secured")){
				query = "SELECT coalesce(sum(a.netPrice),0) FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ? "
						+ "AND a.spaSignedDate <> Null AND a.projectInventory.propertyStatus in ('"+PropertyUnitStatusConst.STATUS_BOOKED+"','"+PropertyUnitStatusConst.STATUS_SOLD+"') "
								+ "AND a.accountStatus in ('"+CommonConst.STATUS_NEW + "', '"+ CommonConst.STATUS_ACTIVE + "')";
			} 
		}
		
		List<BigDecimal> resultList = (List<BigDecimal>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			result = resultList.get(0);
		}
		return result;
	}

	@Override
	public Long getA5NameBlockCountByNo(String blockNo,Long projectId,Long businessPartnerId) {
		Long count = 0l;
		String query = "SELECT coalesce(Count(a.accountId),0) FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ? AND a.customer.businessPartner = ?"+
				"AND a.accountStatus in ('" 
						+ CommonConst.STATUS_NEW + "', '" 
						+ CommonConst.STATUS_ACTIVE + "')";
		List<Long> resultList = (List<Long>)getHibernateTemplate().find(query,blockNo,projectId,businessPartnerId);
		if(resultList != null && resultList.size() > 0){
			count = resultList.get(0);
		}
		return count;
	}
	@Override
	public BigDecimal addA5NameSum(String blockNo, Long projectId,String type,Long businessPartnerId) {
		BigDecimal result = new BigDecimal(0);
		String colToQuery = "";
		
		if(type != null && !type.isEmpty()){
			if(type.equals("Gross")){
				colToQuery = "purchasePrice";
			}else if(type.equals("Net") ){
				colToQuery = "netPrice";
			} 
		}
		String query = "SELECT coalesce(sum(a."+colToQuery+"),0) FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ? AND a.customer.businessPartner = ? AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		
		List<BigDecimal> resultList = (List<BigDecimal>)getHibernateTemplate().find(query,blockNo,projectId,businessPartnerId);
		if(resultList != null && resultList.size() > 0){
			result = resultList.get(0);
		}
		return result;
	}
	
	@Override
	public Long getBookingCountByNo(String blockNo,Long projectId) {
		Long count = 0l;
		String query = "SELECT coalesce(Count(a.accountId),0) FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ? " 
				+ "AND a.projectInventory.propertyStatus in ('"+PropertyUnitStatusConst.STATUS_BOOKED+"','"+PropertyUnitStatusConst.STATUS_SOLD+"') ";
		List<Long> resultList = (List<Long>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			count = resultList.get(0);
		}
		return count;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public BigDecimal addBookingSum(String blockNo, Long projectId,String type) {
		BigDecimal result = new BigDecimal(0);
		String colToQuery = "";
		boolean isBumi = false,isNonBumi = false;
		if(type != null && !type.isEmpty()){
			if(type.equals("Gross")){
				colToQuery = "coalesce(sum(a.purchasePrice),0)";
			}else if(type.equals("Net") ){
				colToQuery = "coalesce(sum(a.netPrice),0)";
			}else if(type.equals("Bumi")){
				colToQuery = "coalesce(count(a.accountId),0)";
				isBumi = true;
			}else if(type.equals("NonBumi")){
				colToQuery = "coalesce(count(a.accountId),0)";
				isNonBumi = true;
			}
		}
		String query = "SELECT "+colToQuery+ "FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?  ";
		if(isBumi){
			query += " AND a.customer.bumiIndicator = 'BMBUM'";
		}else if(isNonBumi){
			query += " AND a.customer.bumiIndicator != 'BMBUM'";
		}
		
		query += " AND a.accountStatus in ('" + CommonConst.STATUS_NEW + "','"+CommonConst.STATUS_ACTIVE+"') AND a.projectInventory.propertyStatus in ('"+PropertyUnitStatusConst.STATUS_BOOKED+"','"+PropertyUnitStatusConst.STATUS_SOLD+"') ";
		
		List resultList = (List)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			result = new BigDecimal(resultList.get(0).toString());
		}
		return result;
	}

	@Override
	public BigDecimal addSPASum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		String colToQuery = "";
		if(type != null && !type.isEmpty()){
			if(type.equals("Gross")){
				colToQuery = "purchasePrice";
			}else if(type.equals("Net") ){
				colToQuery = "netPrice";
			}
		}
		String query = "SELECT coalesce(sum(a."+colToQuery+"),0) FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?  AND a.spaSignedDate <> Null AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		
		List<BigDecimal> resultList = (List<BigDecimal>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			result = resultList.get(0);
		}
		return result;
	}

	
	@Override
	public Long getSPACountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		String query = "SELECT coalesce(Count(a.accountId),0)  FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?  AND a.spaSignedDate <> Null AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		List<Long> resultList = (List<Long>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			count = resultList.get(0);
		}
		return count;
	}

	@Override
	public Long getCashCountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		String query = "SELECT coalesce(Count(a.accountId),0)  FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?  AND a.purchaseType = ? AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		List<Long> resultList = (List<Long>)getHibernateTemplate().find(query,blockNo,projectId,PurchaseTypeConst.CASH);
		if(resultList != null && resultList.size() > 0){
			count = resultList.get(0);
		}
		return count;
	}

	@Override
	public BigDecimal addCashSum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		String colToQuery = "";
		if(type != null && !type.isEmpty()){
			if(type.equals("Gross")){
				colToQuery = "purchasePrice";
			}else if(type.equals("Net") ){
				colToQuery = "netPrice";
			}
		}
		String query = "SELECT coalesce(sum(a."+colToQuery+"),0) FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?  AND a.purchaseType = ? AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		
		List<BigDecimal> resultList = (List<BigDecimal>)getHibernateTemplate().find(query,blockNo,projectId,PurchaseTypeConst.CASH);
		if(resultList != null && resultList.size() > 0){
			result = resultList.get(0);
		}
		return result;
	}

	
	@Override
	public Long getLOCountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		String query = "SELECT coalesce(Count(a.accountId),0)  FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?   AND a.loSignedDate <> Null AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		List<Long> resultList = (List<Long>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			count = resultList.get(0);
		}
		return count;
	}

	@Override
	public BigDecimal addLOSum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		String colToQuery = "";
		if(type != null && !type.isEmpty()){
			if(type.equals("Gross")){
				colToQuery = "purchasePrice";
			}else if(type.equals("Net") ){
				colToQuery = "netPrice";
			}
		}
		String query = "SELECT coalesce(sum(a."+colToQuery+"),0) FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?   AND a.loSignedDate <> Null AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		
		List<BigDecimal> resultList = (List<BigDecimal>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			result = resultList.get(0);
		}
		return result;
	}
	
	@Override
	public Long getLACountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		String query = "SELECT coalesce(Count(a.accountId),0)  FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?   AND a.laSignedDate <> Null AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		List<Long> resultList = (List<Long>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			count = resultList.get(0);
		}
		return count;
	}

	@Override
	public BigDecimal addLASum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		String colToQuery = "";
		if(type != null && !type.isEmpty()){
			if(type.equals("Gross")){
				colToQuery = "purchasePrice";
			}else if(type.equals("Net") ){
				colToQuery = "netPrice";
			}
		}
		String query = "SELECT coalesce(sum(a."+colToQuery+"),0) FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?   AND a.laSignedDate <> Null AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		
		List<BigDecimal> resultList = (List<BigDecimal>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			result = resultList.get(0);
		}
		return result;
	}
	
	@Override
	public Long getAdviseCountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		String query = "SELECT coalesce(Count(a.accountId),0)  FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?   AND a.adviseSignedDate <> Null AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		List<Long> resultList = (List<Long>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			count = resultList.get(0);
		}
		return count;
	}

	@Override
	public BigDecimal addAdviseSum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		String colToQuery = "";
		if(type != null && !type.isEmpty()){
			if(type.equals("Gross")){
				colToQuery = "purchasePrice";
			}else if(type.equals("Net") ){
				colToQuery = "netPrice";
			}
		}
		String query = "SELECT coalesce(sum(a."+colToQuery+"),0) FROM Account a WHERE a.projectInventory.blockNo = ? AND a.projectInventory.project.projectId = ?   AND a.adviseSignedDate <> Null AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "')";
		
		List<BigDecimal> resultList = (List<BigDecimal>)getHibernateTemplate().find(query,blockNo,projectId);
		if(resultList != null && resultList.size() > 0){
			result = resultList.get(0);
		}
		return result;
	}

	@Override
	public List<Object> getTotalLoanOfferedByProjectId(Long projectId) {
		List<Object> resultList = new ArrayList<Object>();
		try{
		
		String query = "SELECT bp.companyName,coalesce(COUNT(a.accountId)),coalesce(SUM(a.loanAmount)) FROM Account a, BusinessPartner bp WHERE a.projectInventory.project.projectId = ?   AND a.purchaseType != ? AND a.panelBankId = bp.partnerId AND a.accountStatus in ('" 
				+ CommonConst.STATUS_NEW + "', '" 
				+ CommonConst.STATUS_ACTIVE + "') GROUP BY bp.companyName";
		
		resultList = (List<Object>)getHibernateTemplate().find(query,projectId,PurchaseTypeConst.CASH);
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<Object> getSalesByAgentByProjectId(Long projectId) {
		List<Object> resultList = new ArrayList<Object>();
		try{
		
		String query = 	" SELECT a.salesPerson as person, COALESCE(COUNT(a.accountId)) AS evalue, COALESCE(SUM(a.netPrice)) AS fvalue, " +
							" (SELECT COALESCE(COUNT(b.accountId))  AS gvalue " +
							" FROM Account b" +
							" WHERE b.projectInventory.project.projectId = ?" +
							" AND b.salesPerson = a.salesPerson" +
							" AND b.customer.specialHandling = 'SHSTF'" +
							" AND b.accountStatus IN ('SSNEW', 'SSACT')) as gvalue, " +
							" (SELECT COALESCE(COUNT(c.accountId))  AS hvalue " +
							" FROM Account c" +
							" WHERE c.projectInventory.project.projectId = ?" +
							" AND c.salesPerson = a.salesPerson" +
							" AND c.campaignCode <> Null) as hvalue " +
						" FROM Account a" +
						" WHERE a.projectInventory.project.projectId = ?" +
						" AND a.accountStatus IN ('SSNEW', 'SSACT')" +
						" GROUP BY a.salesPerson" +
						" ORDER BY a.salesPerson ASC";
		resultList = (List<Object>)getHibernateTemplate().find(query,projectId,projectId,projectId);
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultList;	}
}
