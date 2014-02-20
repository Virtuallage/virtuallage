package com.vipay.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProjectRevenueItemDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3459347961684851024L;
	private String description;		
	private boolean isHeading = false;
	private boolean isEmptyRow = false;
	private boolean isCurrency = true;
	private BigDecimal total;
	private List<BigDecimal> blocks;
	private String additionalInformation;
	
	public ProjectRevenueItemDTO() {
		
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getTotal() {
		if(total == null){
			total = new BigDecimal(0);
		}
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<BigDecimal> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<BigDecimal> blocks) {
		this.blocks = blocks;
	}

	public boolean isHeading() {
		return isHeading;
	}

	public void setHeading(boolean isHeading) {
		this.isHeading = isHeading;
	}

	public boolean isEmptyRow() {
		return isEmptyRow;
	}

	public void setEmptyRow(boolean isEmptyRow) {
		this.isEmptyRow = isEmptyRow;
	}

	public boolean isCurrency() {
		return isCurrency;
	}

	public void setCurrency(boolean isCurrency) {
		this.isCurrency = isCurrency;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

}


