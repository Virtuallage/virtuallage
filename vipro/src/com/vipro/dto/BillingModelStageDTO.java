package com.vipro.dto;

import java.io.Serializable;

import com.vipro.data.BillingModel;
import com.vipro.data.ProgressiveBilling;
import com.vipro.constant.*;

public class BillingModelStageDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3424231223454665724L;
	private BillingModel billingModel = new BillingModel();
	private ProgressiveBilling progressiveBilling = new ProgressiveBilling();
	private String status = ProgressiveBillingConst.STAGE_PENDING;	
	private boolean billMe = false;
	public BillingModelStageDTO() {
		super();
	}



	public ProgressiveBilling getProgressiveBilling() {
		return progressiveBilling;
	}



	public void setProgressiveBilling(ProgressiveBilling progressiveBilling) {
		this.progressiveBilling = progressiveBilling;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public BillingModel getBillingModel() {
		return billingModel;
	}



	public void setBillingModel(BillingModel billingModel) {
		this.billingModel = billingModel;
	}



	public boolean isBillMe() {
		return billMe;
	}



	public void setBillMe(boolean billMe) {
		this.billMe = billMe;
	}
	
	
	
}
