package com.vipro.jsf.bean.salesadm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.vipro.constant.CodeConst;
import com.vipro.constant.CommonConst;
import com.vipro.constant.JasperConst;
import com.vipro.data.Project;
import com.vipro.dto.AdviseUpdateDetailsDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.CodeService;
import com.vipro.service.ProjectService;
import com.vipro.utils.spring.SpringBeanUtil;


@ManagedBean(name = "adviseUpdateBean")
@ViewScoped
public class AdviseUpdateBean extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -393535972424223490L;

	private ProjectService projectService;
	private Long selectedProjectId;
	private String unit;
	private List<SelectItem> projects;
	private AdviseUpdateDetailsDTO selectedDto = new AdviseUpdateDetailsDTO();
	private List<AdviseUpdateDetailsDTO> dtoList;
	
	private List<SelectItem> statesSIList;
	private List<SelectItem> titlTypesSIList;
	
	private Project project = null;
	private StreamedContent fileToDownload;
	
	public AdviseUpdateBean() {
		
		this.projectService = (ProjectService)SpringBeanUtil.lookup(ProjectService.class.getName());
		String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedProjectId");
		if(selectedProjectIdStr != null && !selectedProjectIdStr.isEmpty()){
			selectedProjectId = Long.parseLong(selectedProjectIdStr);
			project = this.projectService.findById(selectedProjectId);
		}
	}

	@PostConstruct
	public void initialize(){
		
		try{
			projects = new ArrayList<SelectItem>();
			projects.add(new SelectItem(null,CommonConst.SELECT));
			List<Project> allProjects = projectService.findAllProjects();
			if(allProjects != null && allProjects.size()>0){
				for(Project proj : allProjects){
					projects.add(new SelectItem(proj.getProjectId(),proj.getProjectName()));
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private List<SelectItem> getCodeSIList(String code) {
		CodeService codeService = (CodeService) SpringBeanUtil.lookup(CodeService.class.getName());
		return codeService.getCodes(code);
	}
	
	public void saveAdviseDetails(ActionEvent actionEvent) {  
	        RequestContext context = RequestContext.getCurrentInstance();  
	        boolean success = false; 
	        AccountService service = (AccountService)SpringBeanUtil.lookup(AccountService.class.getName());
	        
	        service.update(getSelectedDto().getAccount());
	        
	        setSelectedDto(new AdviseUpdateDetailsDTO());
	        
	        searchProject();

	        CommonBean.addInfoMessage("Update Successful."," The Advise information has been updated successfully.");
	        success = true;
	        context.addCallbackParam("success", success);  
	    }  
	
	public void closeAdviseDetails(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        boolean success = true; 
        setSelectedDto(new AdviseUpdateDetailsDTO());
        refreshProjectSearch();
        CommonBean.addInfoMessage("Details Closed."," Details windows closed.");
        context.addCallbackParam("success", success);  
    }  
	
	public void refreshProjectSearch(){
		if(selectedProjectId != null){
			dtoList = this.projectService.getAdviseUpdateDetailsDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
		}
	}
	
	public String searchProject(){
		try{
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("puListForm:projectList_input");
			if(selectedProjectIdStr != null){
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				dtoList = this.projectService.getAdviseUpdateDetailsDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private File getBaseFolder(Long accountId){
		File baseFolder = new File(CommonConst.ADVISE_FOLDER_NAME);
		if(accountId != null){
			 baseFolder = new File(JasperConst.ACCOUNTS_FOLDER+"/"+accountId.toString()+"/"+CommonConst.ADVISE_FOLDER_NAME);
			 if(!baseFolder.exists()){
				 baseFolder.mkdirs();
				}
		}
			 return baseFolder;
	}
	
	
	
	public void handleFileUpload(FileUploadEvent event) {
		try{
				 
			 if(getSelectedDto().getAccount().getAccountId() != null){
				 
				File targetFolder = getBaseFolder(getSelectedDto().getAccount().getAccountId());
				InputStream inputStream = event.getFile().getInputstream();
				OutputStream out = new FileOutputStream(new File(targetFolder,event.getFile().getFileName()));
				int read = 0;
				byte[] bytes = new byte[1024];
				while((read = inputStream.read(bytes)) != -1){
					out.write(bytes,0,read);
				}
				inputStream.close();
				out.flush();
				out.close();
				CommonBean.addInfoMessage("Upload Successful."," The document is stored at "+targetFolder.getAbsolutePath());
			 }
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
	 public List<StreamedContent> getAllUploadedFiles() {
		 List<StreamedContent> fileList = new ArrayList<StreamedContent>();
		 
		 if(getSelectedDto().getAccount().getAccountId() != null){
			 File baseFolder =  getBaseFolder(getSelectedDto().getAccount().getAccountId());
		 
		 File[] filesArray = baseFolder.listFiles();

		 if (filesArray != null) {
		     for (File ufile : filesArray) {
		     InputStream stream = null;
		     try {
		    	 String filePath = ufile.getAbsolutePath();
		         stream = new FileInputStream(filePath);
		         MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
				 String mimeType = mimeTypesMap.getContentType(filePath);
		         StreamedContent file = new DefaultStreamedContent(stream,mimeType,ufile.getName());
		         fileList.add(file);
		     } catch (FileNotFoundException e) {
		         e.printStackTrace();
		     }
		     try {
		         stream.close();
		     } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		     }
		     }
		 }

		 }
		 return fileList;
		 }
	public void prepareFileToDownload(final StreamedContent arq) {
		try{
			 if(getSelectedDto().getAccount().getAccountId() != null){
				 File baseFolder = getBaseFolder(getSelectedDto().getAccount().getAccountId());					 
				 String fileName =baseFolder.getPath()+"/"+arq.getName();
				MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
				String mimeType = mimeTypesMap.getContentType(fileName);
				InputStream stream = new FileInputStream(fileName);
				this.fileToDownload = new DefaultStreamedContent(stream,mimeType,arq.getName());
			 }
		}catch(IOException e){
			e.printStackTrace();
		}
		}
	public Long getSelectedProjectId() {
		return selectedProjectId;
	}

	public void setSelectedProjectId(Long selectedProjectId) {
		this.selectedProjectId = selectedProjectId;
	}

	public List<SelectItem> getProjects() {
		return projects;
	}

	public void setProjects(List<SelectItem> projects) {
		this.projects = projects;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<AdviseUpdateDetailsDTO> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<AdviseUpdateDetailsDTO> dtoList) {
		this.dtoList = dtoList;
	}

	public AdviseUpdateDetailsDTO getSelectedDto() {
		return selectedDto;
	}

	public void setSelectedDto(AdviseUpdateDetailsDTO selectedDto) {
		this.selectedDto = selectedDto;
	}

	public List<SelectItem> getStatesSIList() {
		statesSIList = getCodeSIList(CodeConst.STATE);
		
		return statesSIList;
	}

	public void setStatesSIList(List<SelectItem> statesSIList) {
		this.statesSIList = statesSIList;
	}

	public List<SelectItem> getTitlTypesSIList() {
		titlTypesSIList = getCodeSIList(CodeConst.PROPERTY_TITLE);
		return titlTypesSIList;
	}

	public void setTitlTypesSIList(List<SelectItem> titlTypesSIList) {
		this.titlTypesSIList = titlTypesSIList;
	}

	public StreamedContent getFileToDownload() {
		return fileToDownload;
	}

	public void setFileToDownload(StreamedContent fileToDownload) {
		this.fileToDownload = fileToDownload;
	}
}
