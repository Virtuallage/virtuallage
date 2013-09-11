package com.vipro.service;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.NumberFormatter;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;

import com.vipro.constant.DataSourceConst;
import com.vipro.constant.JasperConst;
import com.vipro.dto.ProjectRevenueItemDTO;
import com.vipro.dto.ReportDTO;
import com.vipro.utils.spring.DownloadManager;

@Service("com.vipro.service.ReportService")
public class ReportServiceImpl extends DownloadManager implements ReportService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2980981727609909173L;
	
	@Override
	public void generateSalesSummaryReport(ReportDTO reportDTO,List<ProjectRevenueItemDTO> projecRevenueRows,List<String> columns) throws SQLException, JRException, FileNotFoundException {
		
		// Populating Parameters
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", reportDTO.getProjectId());
		params.put("project_name", reportDTO.getProjectName());
		params.put("institution_name", reportDTO.getInstitutionName());
		
		// Creating Dynamic Jasper Report
		DynamicReportBuilder drb = new DynamicReportBuilder();
		
		
		// Column Header Font and Style
		Font font = new Font(10, "Verdana", true);
		
		Style headerStyle = new Style();
		headerStyle.setFont(font);
		headerStyle.setHorizontalAlign(HorizontalAlign.LEFT);
		headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
		headerStyle.setBackgroundColor(new Color(204,204,204));
		headerStyle.setTransparency(Transparency.OPAQUE);
		
		Style centerHeaderStyle = new Style();
		centerHeaderStyle.setFont(font);
		centerHeaderStyle.setHorizontalAlign(HorizontalAlign.CENTER);
		centerHeaderStyle.setVerticalAlign(VerticalAlign.MIDDLE);
		centerHeaderStyle.setBackgroundColor(new Color(204,204,204));
		centerHeaderStyle.setTransparency(Transparency.OPAQUE);
		
		// Column Value Font and Style
		font = new Font(8, "Verdana", false);
		
		Style detailStyle = new Style();
		detailStyle.setFont(font);
		detailStyle.setHorizontalAlign(HorizontalAlign.LEFT);
		detailStyle.setVerticalAlign(VerticalAlign.MIDDLE);
		
		Style rightAlignStyle = new Style();
		rightAlignStyle.setFont(font);
		rightAlignStyle.setVerticalAlign(VerticalAlign.MIDDLE);
		rightAlignStyle.setHorizontalAlign(HorizontalAlign.RIGHT);
		
		
		// Adding Description Column
		drb.addColumn(ColumnBuilder.getNew().setColumnProperty("description", String.class.getName())
				.setTitle("Description").setWidth(new Integer(100))
				.setStyle(detailStyle).setHeaderStyle(headerStyle).build());
		
		if(columns != null && columns.size() > 0){
			for(String block: columns){
				String temp = block.replace(" ", "");
				temp = temp.toLowerCase();
				drb.addColumn(ColumnBuilder.getNew().setColumnProperty(temp, String.class.getName())
					.setTitle(block).setWidth(new Integer(50))
					.setStyle(rightAlignStyle).setHeaderStyle(centerHeaderStyle).build());
			}
		}
		
		drb.addColumn(ColumnBuilder.getNew().setColumnProperty("total", String.class.getName())
				.setTitle("Total").setWidth(new Integer(60))
				.setStyle(rightAlignStyle).setHeaderStyle(centerHeaderStyle).build());
			
		drb.setUseFullPageWidth(true);
		
		
		
		drb.setTemplateFile(JasperConst.SALES_SUMMARY_PROJECT_REVENUE);
		DynamicReport dr = drb.build();
		JRDataSource ds = getDataSource(projecRevenueRows,columns);
		JasperPrint jp = null;
		JasperReport jr = DynamicJasperHelper.generateJasperReport(dr,
				new ClassicLayoutManager(), params);
		if (ds != null) {
			jp = JasperFillManager.fillReport(jr, params, ds);
		} else {
			jp = JasperFillManager.fillReport(jr, params);
		}
		byte[] reportData = null;
		if(reportDTO.getReportFormatId() == 2L){
			reportData = JasperExportManager.exportReportToPdf(jp);
		}else if(reportDTO.getReportFormatId() == 1L){
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			JRXlsxExporter  exporterXLS = new JRXlsxExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporterXLS.exportReport();
			reportData = output.toByteArray();
		}
		
		String extension = "";
		if(reportDTO.getReportFormatId() == 1L){
			extension = ".xlsx";
		}else if(reportDTO.getReportFormatId() == 2L){
			extension = ".pdf";
		}
		downloadDocument(reportData, "ProjectRevenueReport"+extension);
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected JRDataSource getDataSource(List<ProjectRevenueItemDTO> projecRevenueRows,List<String> columns) {

		List records = new ArrayList();
		if(projecRevenueRows != null && projecRevenueRows.size() > 0){

			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
			NumberFormat numberFormatter = NumberFormat.getNumberInstance();
			String currencySymbol = currencyFormatter.getCurrency().getSymbol();
			
			for(ProjectRevenueItemDTO dto : projecRevenueRows){
				Map columnWithValues = new HashMap();
				columnWithValues.put("description", dto.getDescription());
				if(dto.getBlocks() != null){
				for(int index = 0; index < columns.size(); index++){
					String block =columns.get(index); 
					String temp = block.replace(" ", "");
					temp = temp.toLowerCase();
					
					if(dto.getBlocks().get(index) != null){
						if(dto.isCurrency()){
							String result = currencyFormatter.format(dto.getBlocks().get(index).doubleValue());
							columnWithValues.put(temp, result.replace(currencySymbol, ""));
						}else{
							String result = numberFormatter.format(dto.getBlocks().get(index).intValue());
							columnWithValues.put(temp, result);
						}
					}else{
						columnWithValues.put(temp, "");
					}
				}
				}else{
					if(dto.getAdditionalInformation() != null && !dto.getAdditionalInformation().isEmpty()){
						String[] strArr = dto.getAdditionalInformation().split("till");
						if(columns.size() >1){
							columnWithValues.put(columns.get(0).replace(" ", "").toLowerCase(), strArr[0]+" till ");
							columnWithValues.put(columns.get(1).replace(" ", "").toLowerCase(), strArr[1]);
						}else if(columns.size() == 1){
							columnWithValues.put(columns.get(0).replace(" ", "").toLowerCase(), strArr[0]+" till ");
							columnWithValues.put("total", strArr[1]);
						}
					}
				}
				if(!dto.isEmptyRow()){
					if(dto.isCurrency()){
							String result = currencyFormatter.format(dto.getTotal().doubleValue());
							columnWithValues.put("total", result.replace(currencySymbol, ""));
					}else{
						String result = numberFormatter.format(dto.getTotal().intValue());
						columnWithValues.put("total", result);
					}
				}else{
					columnWithValues.put("total","");
				}
				
				records.add(columnWithValues);
			}
		}
		JRDataSource ds = new JRMapCollectionDataSource(records);
		return ds;

	}

	private byte[] generateReportData(String reportPath, Map<String, Object> parameters,Long exportTo)throws SQLException,JRException{
		byte[] reportData = null;
		try{
			
			Connection connection = getConnection();
			
			JasperPrint jasperReport = JasperFillManager.fillReport(reportPath, parameters, connection);
				if(exportTo == 1L){
					ByteArrayOutputStream output = new ByteArrayOutputStream();
					JRXlsxExporter  exporterXLS = new JRXlsxExporter();
					exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperReport);
					exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
					exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
					exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
					exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
					exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
					exporterXLS.exportReport();
					reportData = output.toByteArray();
				}else if(exportTo == 2L){
					reportData = JasperExportManager.exportReportToPdf(jasperReport);
				}
				connection.close();
	
		}catch(SQLException sqlE){
			sqlE.printStackTrace();
		}catch(JRException jrE){
			jrE.printStackTrace();
		}
		return reportData;
	}
	
	public static Connection getConnection() {  
        Connection jdbcConnection = null;  
        try {  
            Class.forName(DataSourceConst.DB_DRIVER);  
            jdbcConnection = DriverManager.getConnection(DataSourceConst.DB_URL,DataSourceConst.DB_USERNAME,DataSourceConst.DB_PASSWORD);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return jdbcConnection;  
    }

	@Override
	public void generateTotalLoanOfferedReport(ReportDTO reportDTO)throws SQLException, JRException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", reportDTO.getProjectId());
		params.put("blocksTitle", reportDTO.getBlocksTitle());
		String reportPath = JasperConst.SALES_SUMMARY_TOTAL_LOAN_OFFERED;
		
		String extension = "";
		if(reportDTO.getReportFormatId() == 1L){
			extension = ".xlsx";
		}else if(reportDTO.getReportFormatId() == 2L){
			extension = ".pdf";
		}
		byte[] reportData = generateReportData(reportPath,params,reportDTO.getReportFormatId());
		downloadDocument(reportData, "TotalLoanOfferedReport"+extension);
		
	}

	@Override
	public void generateSalesByStaffAgentReport(ReportDTO reportDTO)throws SQLException, JRException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", reportDTO.getProjectId());
		params.put("blocksTitle", reportDTO.getBlocksTitle());
		String reportPath = JasperConst.SALES_SUMMARY_SALES_BY_STAFF;
		
		String extension = "";
		if(reportDTO.getReportFormatId() == 1L){
			extension = ".xlsx";
		}else if(reportDTO.getReportFormatId() == 2L){
			extension = ".pdf";
		}
		byte[] reportData = generateReportData(reportPath,params,reportDTO.getReportFormatId());
		downloadDocument(reportData, "SalesByStaffAgentReport"+extension);
		
	}  
	
}
