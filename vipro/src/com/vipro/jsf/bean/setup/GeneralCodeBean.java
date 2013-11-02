package com.vipro.jsf.bean.setup;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.component.log.Log;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataIntegrityViolationException;

import com.vipro.constant.CommonConst;
import com.vipro.data.CodeDet;
import com.vipro.data.CodeHeader;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.CodeService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "generalCodeBean")
@SessionScoped
public class GeneralCodeBean extends CommonBean implements Serializable {
	/**
	 * code header related properties
	 */
	private List<CodeHeader> codeHeaders;
	private CodeHeader codeHeader;
	private String codeHeaderId;
	/**
	 * code details related properties
	 */
	private List<CodeDet> codeDets;
	private CodeDet codeDet;
	private List<SelectItem> statusList;
	
	@PostConstruct
	public void init() {
		statusList = CodeUtil.getCodes("SS");
		listHeader();
	}
	
	public List<SelectItem> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}

	public CodeHeader getCodeHeader() {
		return codeHeader;
	}

	public void setCodeHeader(CodeHeader codeHeader) {
		this.codeHeader = codeHeader;
	}

	public List<CodeHeader> getCodeHeaders() {
		return codeHeaders;
	}

	public void setCodeHeaders(List<CodeHeader> codeHeaders) {
		this.codeHeaders = codeHeaders;
	}
	
	public List<CodeDet> getCodeDets() {
		return codeDets;
	}

	public void setCodeDets(List<CodeDet> codeDets) {
		this.codeDets = codeDets;
	}

	public CodeDet getCodeDet() {
		return codeDet;
	}

	public void setCodeDet(CodeDet codeDet) {
		this.codeDet = codeDet;
	}
	
	public String getCodeHeaderId() {
		return codeHeaderId;
	}

	public void setCodeHeaderId(String codeHeaderId) {
		this.codeHeaderId = codeHeaderId;
	}
	
	public String listHeader() {
		CodeService codeService = (CodeService) SpringBeanUtil
				.lookup(CodeService.class.getName());
		setCodeHeaders(codeService.findAllCodeHdrs());

		return "codeHeader";
	}

	public String addNewHeader() {
		codeHeader = new CodeHeader();
		return "newHeader";
	}

	public String editHeader() {
		try {
			setCodeHeaderId(codeHeader.getCodeHeaderId());
			
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}

		return "newHeader";
	}
	
	public String saveHeader() {
		try {
			String hId = codeHeader.getCodeHeaderId();
			codeHeader.setCodeHeaderId(hId.toUpperCase());
			String hName = codeHeader.getName();
			codeHeader.setName(hName.toUpperCase());

			CodeService codeService = (CodeService) SpringBeanUtil
					.lookup(CodeService.class.getName());
			
			codeService.insert(codeHeader);

			listHeader();

			addInfoMessage("Saved", "Common Code Header Record Saved Successfully.");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}

		return "codeHeader";
	}

	public String toCodeDetList() {
		try {
			if (codeHeader != null) {
				codeHeaderId = codeHeader.getCodeHeaderId();
			}
			CodeService codeService = (CodeService) SpringBeanUtil
					.lookup(CodeService.class.getName());
			setCodeDets(codeService.getCodeDets(codeHeaderId));
			
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "codeDetList";
	}

	public String addCodeDet() {
		codeDet = new CodeDet();
		return "editCodeDet";
	}
	
	public String editCodeDet() {

		return "editCodeDet";
	}
	

	public String deleteCodeDet() {
		try {
			CodeService codeService = (CodeService) SpringBeanUtil
					.lookup(CodeService.class.getName());

			if (codeDet != null) {
				codeService.deleteCodeDet(codeDet.getCodeHeaderId(), codeDet.getCode());
				addInfoMessage("Deleted", "Common Code Value Deleted Successfully.");
			}
		} catch (Throwable t) {
			if (t instanceof DataIntegrityViolationException) {
				addErrorMessage("Warning",
						"Deletion not allowed for this Common Code Value.");
			} else {
				addErrorMessage("Common Code Value", t.getMessage());
			}
		}
		return toCodeDetList();
	}
	
	public String saveCodeDet() {
		try {
			CodeService codeService = (CodeService) SpringBeanUtil
					.lookup(CodeService.class.getName());
			codeDet.setCodeHeader(codeHeader);
			
			codeService.update(codeDet);
			
			addInfoMessage("Saved", "Common Code Value Saved Successfully.");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
			return null;
		}
		return toCodeDetList();
	}
	
	public String saveCodedetAsNew() {
		try {
			String hId = codeHeader.getCodeHeaderId();
			codeHeader.setCodeHeaderId(hId.toUpperCase());
			String hName = codeHeader.getName();
			codeHeader.setName(hName.toUpperCase());
			
			CodeService codeService = (CodeService) SpringBeanUtil
					.lookup(CodeService.class.getName());
			codeDet.setCodeHeaderId(null);
			codeDet.setCode(null);
			codeDet.setCodeHeader(codeHeader);
			
			codeDet.setStatus(CommonConst.STATUS_ACTIVE);
			
			codeService.insert(codeDet);

			addInfoMessage("Added", "Common Code Value Added Successfully.");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
			return null;
		}
		return editCodeDet();
	}
	
}
