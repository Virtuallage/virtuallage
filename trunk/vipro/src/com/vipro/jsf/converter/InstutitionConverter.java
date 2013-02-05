package com.vipro.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.vipro.data.Institution;
import com.vipro.service.InstitutionService;
import com.vipro.utils.spring.SpringBeanUtil;

@FacesConverter("institution")
public class InstutitionConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
		InstitutionService service = (InstitutionService) SpringBeanUtil.lookup(InstitutionService.class.getName());
		try {
			Institution ins = service.findById(Long.parseLong(newValue));
			return ins;
		} catch (NumberFormatException e) {
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Institution) {
			Institution ins = (Institution) value;
			return ins.getInstitutionId().toString();
		}
		return null;
	}

}
