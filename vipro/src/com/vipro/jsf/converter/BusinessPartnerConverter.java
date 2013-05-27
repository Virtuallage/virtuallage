package com.vipro.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.vipro.data.BusinessPartner;
import com.vipro.service.BusinessPartnerService;
import com.vipro.utils.spring.SpringBeanUtil;

@FacesConverter("businessPartner")
public class BusinessPartnerConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
		BusinessPartnerService service = (BusinessPartnerService) SpringBeanUtil.lookup(BusinessPartnerService.class.getName());
		try {
			BusinessPartner partners = service.findById(Long.parseLong(newValue));
			return partners;
		} catch (NumberFormatException e) {
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof String) {
			return (String) value;
		}
		if (value instanceof BusinessPartner) {
			BusinessPartner partners = (BusinessPartner) value;
			return partners.getPartnerId() + "";
		}
		return null;

	}

}
