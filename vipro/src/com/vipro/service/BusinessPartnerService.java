package com.vipro.service;

import java.util.List;

import javax.faces.model.SelectItem;

import com.vipro.data.BusinessPartner;


public interface BusinessPartnerService {
	
	public BusinessPartner findById(Long PartnerId);
		
	public BusinessPartner findAll();
	
}
