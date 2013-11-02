package com.vipro.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import com.vipro.dto.ProjectRevenueItemDTO;
import com.vipro.dto.ReportDTO;

public interface ReportService {

	public void generateSalesSummaryReport(ReportDTO reportDTO,List<ProjectRevenueItemDTO> projecRevenueRows,List<String> columns) throws SQLException, JRException, FileNotFoundException;
	public void generateTotalLoanOfferedReport(ReportDTO reportDTO) throws SQLException, JRException;
	public void generateSalesByStaffAgentReport(ReportDTO reportDTO) throws SQLException, JRException;
	public void generateProgressBillingLetterReport(ReportDTO reportDTO,String InvoiceNo, String path)throws SQLException, JRException,FileNotFoundException,IOException ;
}
