package com.vipay.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SalesByAgentItemDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String soldBy;
	private Long units;
	private BigDecimal netSales;
	private Long staffPurchase;
	private Long salesCampaign;
	private boolean isTotalRow;

	public SalesByAgentItemDTO() {
		
	}


	public String getSoldBy() {
		return soldBy;
	}


	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}


	public Long getUnits() {
		if(units == null){
			units = 0L;
		}
		return units;
	}


	public void setUnits(Long units) {
		this.units = units;
	}


	public BigDecimal getNetSales() {
		if(netSales == null){
			netSales = BigDecimal.ZERO;
		}
		return netSales;
	}


	public void setNetSales(BigDecimal netSales) {
		this.netSales = netSales;
	}


	public Long getStaffPurchase() {
		if(staffPurchase == null){
			staffPurchase = 0L;
		}
		return staffPurchase;
	}


	public void setStaffPurchase(Long staffPurchase) {
		this.staffPurchase = staffPurchase;
	}


	public Long getSalesCampaign() {
		if(salesCampaign == null){
			salesCampaign = 0L;
		}
		return salesCampaign;
	}


	public void setSalesCampaign(Long salesCampaign) {
		this.salesCampaign = salesCampaign;
	}


	public boolean getIsTotalRow() {
		return isTotalRow;
	}


	public void setIsTotalRow(boolean isTotalRow) {
		this.isTotalRow = isTotalRow;
	}
}
