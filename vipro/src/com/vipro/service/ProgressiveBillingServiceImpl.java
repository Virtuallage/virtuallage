package com.vipro.service;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vipro.constant.AccountStatusConst;
import com.vipro.constant.CommonConst;
import com.vipro.constant.JasperConst;
import com.vipro.constant.ProgressiveBillingConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.dao.AccountDao;
import com.vipro.dao.BillingModelDao;
import com.vipro.dao.BusinessPartnerDao;
import com.vipro.dao.InstitutionDao;
import com.vipro.dao.ProgressiveBillingDao;
import com.vipro.dao.SeqNoDao;
import com.vipro.dao.TransactionHistoryDao;
import com.vipro.data.Account;
import com.vipro.data.BillingModel;
import com.vipro.data.BusinessPartner;
import com.vipro.data.ProgressiveBilling;
import com.vipro.data.SeqNo;
import com.vipro.data.TransactionCode;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.dto.BillingModelStageDTO;
import com.vipro.dto.ChangeAddressDTO;
import com.vipro.dto.PaymentEntryDTO;
import com.vipro.dto.TransactionEntryDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.dto.ReportDTO;
import com.vipro.dto.BillingReturnParaDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.utils.spring.SpringBeanUtil;

@Service("com.vipro.service.ProgressiveBillingService")
public class ProgressiveBillingServiceImpl implements ProgressiveBillingService {

	@Autowired
	private ProgressiveBillingDao progressiveBillingDao;
	@Autowired
	private BillingModelDao billingModelDao;
	@Autowired
	private SeqNoDao seqNoDao;
	@Autowired
	private BusinessPartnerDao businessPartnerDao;
	@Autowired
	private TransactionHistoryDao transactionHistoryDao;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private InstitutionDao institutionDao; 
	private Long pInvoiceNo = new Long(1l);
	BillingReturnParaDTO dto = new BillingReturnParaDTO();
	
	@Override
	public List<ProgressiveBilling> getProgressiveBilling(Long accountId) {
		return progressiveBillingDao.findByAccountId(accountId);
	}

	@Override
	public void insert(ProgressiveBilling p) {
		progressiveBillingDao.insert(p);

	}

	@Override
	public void update(ProgressiveBilling p) {
		progressiveBillingDao.update(p);

	}

	@Override
	public void delete(Long id) {
		ProgressiveBilling o = progressiveBillingDao.findById(id);
		progressiveBillingDao.delete(o);

	}

	@Override
	@Transactional
	public void changeAddress(ChangeAddressDTO corDTO, Account account) {
		 AddressService adrService = (AddressService)SpringBeanUtil.lookup(AddressService.class.getName());
		 CustomerService cusService = (CustomerService)SpringBeanUtil.lookup(CustomerService.class.getName());
		 AccountService acctService = (AccountService)SpringBeanUtil.lookup(AccountService.class.getName());
		 
		 
		 if(corDTO.isCorrAddress()){
			 cusService.update(corDTO.getCustomer()); // update email address
			 adrService.update(corDTO.getAddress());
		
			 if(!corDTO.getCustomer().getCustomerId().equals(account.getCorrAddrCustId())){
				 account.setCorrAddrCustId(corDTO.getCustomer().getCustomerId());
				 acctService.update(account);
			 }
		 }
	}

	@Override
	public List<BillingModelStageDTO> getBillingModelListByProjectBillingModelCode(
			Long projectId, String billingModelCode, Long accountId) {
		
		List<BillingModelStageDTO> dtoList = new ArrayList<BillingModelStageDTO>();
		
		List<BillingModel> list = billingModelDao.findByBillingModelCode(billingModelCode);
		
		for (BillingModel billingModel : list) { 
			BillingModelStageDTO dto = new BillingModelStageDTO();
			dto.setBillingModel(billingModel);
			
			ProgressiveBilling pb = progressiveBillingDao.findByStageAndAccountId(accountId, billingModel.getStage());
			if(pb != null){
				if(pb.getDatePaid() != null){
					dto.setStatus(ProgressiveBillingConst.STAGE_PAID);		
				}else if(pb.getDateBilled() != null){
					if(pb.getStatus().equalsIgnoreCase(ProgressiveBillingConst.PB_STATUS_BILL)){
						dto.setStatus(ProgressiveBillingConst.STAGE_BILLED);
					} else {
						dto.setStatus(ProgressiveBillingConst.STAGE_PENDING);
					}
				}else{
					dto.setStatus(ProgressiveBillingConst.STAGE_PENDING);
				}
				
				if(pb.getInvoiceNo()!= null && pb.getInvoiceNo().startsWith("RI")){ // if it is Renoticed.
					dto.setStatus(ProgressiveBillingConst.STAGE_RENOTICED);
					
				}
			}else{
				pb = new ProgressiveBilling();
				dto.setStatus(ProgressiveBillingConst.STAGE_PENDING);
			}
			
			dto.setProgressiveBilling(pb);
			dtoList.add(dto);
			
		}
		return dtoList;
	}

	@Override
	public Long getAndUpdteSeqNO(String projectCode, String seqType, boolean isIncrement) {
		Long no = new Long(0l);
		SeqNo seq = seqNoDao.findById(seqType,projectCode);
		no = seq.getNextSeq() + (isIncrement ? 1l: -1l) ;
		seqNoDao.updateSeqNo(seqType, no, projectCode);
		return no;
	}
	
	@Override
	public Long getNextSeqNO(String projectCode, String seqType, boolean isIncrement) {
		Long no = new Long(0l);
		SeqNo seq = seqNoDao.findById(seqType,projectCode);
		no = seq.getNextSeq() + (isIncrement ? 1l: -1l) ;
		return no;
	}

	@Override
	public Long getCurrentSeqNO(String projectCode, String seqType, boolean isIncrement) {
		Long no = new Long(0l);
		SeqNo seq = seqNoDao.findById(seqType,projectCode);
		no = seq.getNextSeq();
		return no;
	}

	
	@Override
	public void printProgressiveLetter(String amount, Long projectId , String invoiceNo, String accountId, String lastStageSelected){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
		reportDTO.setProjectName(lastStageSelected);
		try {
			String path = JasperConst.ACCOUNTS_FOLDER+"/"+accountId+"/"+CommonConst.PROGRESSIVE_BILL_FOLDER_NAME+"/";
			
			 File baseFolder = new File(path);
			 if(!baseFolder.exists()){
				 baseFolder.mkdirs();
				}
			
			rs.generateProgressBillingLetterReport(reportDTO,invoiceNo,path);
		} catch (SQLException e) {	
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public void printProgressiveLetterCash(String amount, Long projectId , String invoiceNo, String accountId, String lastStageSelected){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
		reportDTO.setProjectName(lastStageSelected);
		try {
			String path = JasperConst.ACCOUNTS_FOLDER+"/"+accountId+"/"+CommonConst.PROGRESSIVE_BILL_FOLDER_NAME+"/";
			
			 File baseFolder = new File(path);
			 if(!baseFolder.exists()){
				 baseFolder.mkdirs();
				}
			 
			rs.generateProgressBillingLetterCash(reportDTO,invoiceNo,path);
		} catch (SQLException e) {	
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public void printProgressiveLetterPurchaser(String amount, Long projectId, String invoiceNo, String accountId, String lastStageSelected){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
		reportDTO.setProjectName(lastStageSelected);
		try {
			String path = JasperConst.ACCOUNTS_FOLDER+"/"+accountId+"/"+CommonConst.PROGRESSIVE_BILL_FOLDER_NAME+"/";
			
			 File baseFolder = new File(path);
			 if(!baseFolder.exists()){
				 baseFolder.mkdirs();
				}
			
			rs.generateProgressBillingLetterPurchaser(reportDTO,invoiceNo,path);
		} catch (SQLException e) {	
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public void printProgressiveLetterPurchaserSplit(String amount, Long projectId, String invoiceNo, String accountId, String lastStageSelected){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
		reportDTO.setProjectName(lastStageSelected);
		try {
			String path = JasperConst.ACCOUNTS_FOLDER+"/"+accountId+"/"+CommonConst.PROGRESSIVE_BILL_FOLDER_NAME+"/";
			
			 File baseFolder = new File(path);
			 if(!baseFolder.exists()){
				 baseFolder.mkdirs();
				}
			
			rs.generateProgressBillingLetterPurchaserSplit(reportDTO,invoiceNo,path);
		} catch (SQLException e) {	
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void printProgressiveLetterFinancierSplit(String amount, Long projectId, String invoiceNo, String accountId, String lastStageSelected){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
		reportDTO.setProjectName(lastStageSelected);
		try {
			String path = JasperConst.ACCOUNTS_FOLDER+"/"+accountId+"/"+CommonConst.PROGRESSIVE_BILL_FOLDER_NAME+"/";
			
			 File baseFolder = new File(path);
			 if(!baseFolder.exists()){
				 baseFolder.mkdirs();
				}
			
			rs.generateProgressBillingLetterFinancierSplit(reportDTO,invoiceNo,path);
		} catch (SQLException e) {	
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public void printRenoticeLetter(String amount, Long projectId , String invoiceNo, String accountId, BigDecimal financierPortion, BigDecimal purchaserPortion, String firstStageSelected){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
		reportDTO.setProjectName(firstStageSelected);
		try {
			String path = JasperConst.ACCOUNTS_FOLDER+"/"+accountId+"/"+CommonConst.PROGRESSIVE_BILL_FOLDER_NAME+"/";
			
			 File baseFolder = new File(path);
			 if(!baseFolder.exists()){
				 baseFolder.mkdirs();
				}
			
			rs.generateRenoticeLetterReport(reportDTO,invoiceNo,path,financierPortion,purchaserPortion);
		} catch (SQLException e) {	
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	@Transactional
	public boolean generateRenoticesForSelectedStages(
			List<BillingModelStageDTO> stageDtoList, Long seqNo, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto, 
			BigDecimal financierStageAmount, BigDecimal financierPortion, String firstStageSelected) {
        Long currentUserId = CommonBean.getCurrentUser().getUserProfile().getUserId();
		boolean isSucessfull = false;
		Long revTxnId = new Long(0l);
		
		if(stageDtoList!= null &&  !stageDtoList.isEmpty()){
			Account act = selectedDto.getAccount();		
			BillingModelStageDTO sumDTO = stageDtoList.remove(stageDtoList.size() -1 );
			UserProfile userProfile = CommonBean.getCurrentUser().getUserProfile();
			BigDecimal totalAmount = sumDTO.getProgressiveBilling().getAmountBilled();
			BigDecimal accumAmountPB = totalAmount;
			String refNo = getRefNo(selectedDto.getProject().getDeveloperId());
//			refNo = refNo + "/"+ selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo()+"/"+seqNo;
//			refNo = refNo + "/"+ selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo()+"/"+invoiceNo;
			refNo = selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo();

			//1. Create new Transaction History Record for Progressive Billing Reversal
			TransactionHistory tx = new TransactionHistory();
			tx.setTransactionCode(new TransactionCode(
					TransactionCodeConst.REVERSAL_PROGRESSIVE_BILLING));
			tx.setTransactionDescription("RENOTICE - PROGRESSIVE BILLING REVERSAL");
			tx.setAmount(totalAmount);
			tx.setCodeType(TransactionCodeConst.CREDIT);
	        tx.setUserId(currentUserId);
			tx.setStatus(TransactionStatusConst.POSTED);
			//tx.setInvoiceNo(invoiceNo);
			//tx.setRefNo(refNo);
			tx.setAccount(act);
			tx.setTransactionDate(new Date());
			tx.setPostingDate(new Date());
			tx.setPostedBy(currentUserId);
			transactionHistoryDao.insert(tx);
			
			// To update the new Txn Id for all transaction that already reversed.
			revTxnId = tx.getTransactionId();
			
			//2. Create New Transaction History Record for Payment Reversal, if any
			//2.a
			BigDecimal tempTotalAmountPaid = BigDecimal.ZERO;
			BigDecimal selectedStagesAmount = BigDecimal.ZERO;
			int firstStageSeqNo = 0;
			String firstStageInvoiceNo = "";
			String[] stageNos = new String[stageDtoList.size()];
			int i = 0;
			for (BillingModelStageDTO stageDto : stageDtoList) {
				if(ProgressiveBillingConst.PB_STATUS_FULL_PAYMENT.equals(stageDto.getProgressiveBilling().getStatus())){
					tempTotalAmountPaid = tempTotalAmountPaid.add(stageDto.getProgressiveBilling().getAmountBilled());
				}
				stageNos[i++]= stageDto.getBillingModel().getStage();// building string for query.
				if (i == 1) {
					firstStageSeqNo = stageDto.getBillingModel().getBillingSeq();
					firstStageInvoiceNo = stageDto.getProgressiveBilling().getInvoiceNo();
				}
				selectedStagesAmount = selectedStagesAmount.add(stageDto.getProgressiveBilling().getAmountBilled());
			}		
			
			if (tempTotalAmountPaid.compareTo(BigDecimal.ZERO) > 0 ) {	
				//2.b create reversal txn for payment transaction
				Account aa = new Account();
				aa.setAccountId(act.getAccountId());
				TransactionHistory txPayRev = new TransactionHistory();
				txPayRev.setTransactionCode(new TransactionCode(TransactionCodeConst.REVERSAL_PAYMENT_GENERAL));
				txPayRev.setTransactionDescription("RENOTICE - PAYMENT REVERSAL");
				txPayRev.setAmount(tempTotalAmountPaid);
				txPayRev.setCodeType(TransactionCodeConst.DEBIT);
		        txPayRev.setUserId(currentUserId);
				txPayRev.setStatus(TransactionStatusConst.POSTED);
				txPayRev.setAccount(aa);
				txPayRev.setTransactionDate(new Date());
				txPayRev.setPostingDate(new Date());
				txPayRev.setPostedBy(currentUserId);
				transactionHistoryDao.insert(txPayRev);
				
				//2.c
				act.setTotalPaymentTodate(act.getTotalPaymentTodateNotNull().subtract(tempTotalAmountPaid));
				act.setBillingPaymentTodate(act.getBillingPaymentTodateNotNull().subtract(tempTotalAmountPaid));
				act.setAccountBalance(act.getAccountBalanceNotNull().add(tempTotalAmountPaid));
				accountDao.update(act);
			}
			
			//3.  Update Existing ProgressiveBilling records for selected stages(PBBIL/PBPAI)to PBREV
			progressiveBillingDao.updateProgressiveBillingStatus(act.getAccountId(), ProgressiveBillingConst.PB_STATUS_REVERSAL,
					new String[]{ProgressiveBillingConst.PB_STATUS_BILL, ProgressiveBillingConst.PB_STATUS_FULL_PAYMENT},stageNos, tx.getTransactionId());
			
			//4. Create a new progressive billing record for every selected stages		
			Date billDate = new Date();
			if (selectedDto.getProject().getDaysToBill() != null) {
				billDate = getBillDate(selectedDto.getProject().getDaysToBill(), selectedDto.getProject().getIncludeOffDay(), userProfile);
			} else {
				selectedDto.getProject().setDaysToBill(0);
			}
			
			Date currentDate = new Date();
			Long daysDiff = (billDate.getTime() - currentDate.getTime()) / (24 * 60 * 60 * 1000);
			Integer daysToBill = daysDiff.intValue();

			// get due date from the previous progressive billing
			ProgressiveBilling pBilling = new ProgressiveBilling();
			pBilling = progressiveBillingDao.findByStageAndAccountId(act.getAccountId(), firstStageSelected);
			Date dueDate = pBilling.getDueDate();
			//			Date dueDate = getDueDate(selectedDto.getProject().getDueDays(), daysToBill, selectedDto.getProject().getIncludeOffDay(), userProfile);
			
			Account a = new Account();
			a.setAccountId(act.getAccountId());
			
			for (BillingModelStageDTO stageDto : stageDtoList) {
				// Update Original Transaction TxnReversalId to the reversal txn Id
				TransactionHistory thRevId = new TransactionHistory();
				thRevId = transactionHistoryDao.findByAccountIdInvoiceNo(stageDto.getProgressiveBilling().getAccount().getAccountId(), stageDto.getProgressiveBilling().getInvoiceNo());
				if(thRevId.getTransactionId()!= null){
					thRevId.setTxnReversalId(revTxnId);
					transactionHistoryDao.update(thRevId);
				}
				// Recreate Progressive Billing Record as Renotice Billing with Renotice Inv No
				ProgressiveBilling pb = new ProgressiveBilling();
				pb.setAccount(a);
				pb.setAmountBilled(act.getPurchasePrice().multiply(stageDto.getBillingModel().getBillingPercentage()).divide(new BigDecimal(100)));
				pb.setDateBilled(billDate);
				pb.setInvoiceNo(invoiceNo);
				pb.setPercentage(stageDto.getBillingModel().getBillingPercentage());
				pb.setStageNo(stageDto.getBillingModel().getStage());
				pb.setStageDescription(stageDto.getBillingModel().getDescription());
				pb.setSeqNo(new Byte(stageDto.getBillingModel().getBillingSeq().toString()));
				pb.setStatus(ProgressiveBillingConst.PB_STATUS_BILL);
				pb.setDueDate(dueDate); 
				if ((stageDto.getBillingModel().getBillingSeq() == firstStageSeqNo) && (financierStageAmount.compareTo(new BigDecimal(0.00)) > 0)) {
					pb.setFinancierInvoiceNo(invoiceNo);
					pb.setFinancierPortion(financierStageAmount);
					accumAmountPB = accumAmountPB.subtract(financierStageAmount);
				} else {
					if (accumAmountPB.compareTo(BigDecimal.ZERO) > 0) {
						pb.setFinancierInvoiceNo(invoiceNo);
						pb.setFinancierPortion(pb.getAmountBilled());
						accumAmountPB = accumAmountPB.subtract(pb.getAmountBilled());		
					}
				}
				progressiveBillingDao.insert(pb);
				
				
			}// end for			
			
			//5. Create new TransactionHistory Renotice record 
			if(totalAmount.compareTo(financierPortion) == 0) {    
				// 100% billed to Financier
				TransactionHistory txr = new TransactionHistory();
				txr.setTransactionCode(new TransactionCode(TransactionCodeConst.RENOTICE_BILLING));
				txr.setTransactionDescription("RENOTICE BILLING");
				txr.setAmount(totalAmount);
				txr.setCodeType(TransactionCodeConst.DEBIT);
				txr.setInvoiceNo(invoiceNo);
		        txr.setUserId(currentUserId);
				txr.setStatus(TransactionStatusConst.POSTED);
				txr.setRefNo(refNo);
				txr.setAccount(a);
				txr.setTransactionDate(new Date());
				txr.setFinancierInvoiceNo(invoiceNo);
				txr.setFinancierPortion(financierPortion);
				txr.setPostingDate(new Date());
				txr.setPostedBy(currentUserId);
				transactionHistoryDao.insert(txr);

				isSucessfull = true;
			} else {
				// Transaction History Record for Purchaser Amount
				TransactionHistory txr = new TransactionHistory();
				txr.setTransactionCode(new TransactionCode(TransactionCodeConst.RENOTICE_BILLING));
				txr.setTransactionDescription("RENOTICE BILLING");
				txr.setAmount(totalAmount.subtract(financierPortion));
				txr.setCodeType(TransactionCodeConst.DEBIT);
				txr.setInvoiceNo(invoiceNo);
		        txr.setUserId(currentUserId);
				txr.setStatus(TransactionStatusConst.POSTED);
				txr.setRefNo(refNo);
				txr.setAccount(a);
				txr.setTransactionDate(new Date());
				txr.setFinancierInvoiceNo("");
				txr.setFinancierPortion(BigDecimal.ZERO);
				txr.setPostingDate(new Date());
				txr.setPostedBy(currentUserId);
				transactionHistoryDao.insert(txr);
				
				// Transaction History Record for Financier Amount
				TransactionHistory txr2 = new TransactionHistory();
				txr2.setTransactionCode(new TransactionCode(TransactionCodeConst.RENOTICE_BILLING));
				txr2.setTransactionDescription("RENOTICE BILLING");
				txr2.setAmount(financierPortion);
				txr2.setCodeType(TransactionCodeConst.DEBIT);
				txr2.setInvoiceNo(invoiceNo);
		        txr2.setUserId(currentUserId);
				txr2.setStatus(TransactionStatusConst.POSTED);
				txr2.setRefNo(refNo);
				txr2.setAccount(a);
				txr2.setTransactionDate(new Date());
				txr2.setFinancierInvoiceNo(invoiceNo);
				txr2.setFinancierPortion(financierPortion);
				txr2.setPostingDate(new Date());
				txr2.setPostedBy(currentUserId);
				transactionHistoryDao.insert(txr2);
				
				isSucessfull = true;
			}

		}		
		return isSucessfull;
	}
	
	@Override
	@Transactional
	public BillingReturnParaDTO generateProgressiveBillForSelectedStages(
			List<BillingModelStageDTO> stageDtoList, Long seqNo, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto, 
			Integer splitStageSeqNo, BigDecimal financierStageAmount, BigDecimal purchaserStageAmount, BigDecimal financierPortion) {

		String refNo = "";
		dto.setIsSucessfull(false);
		dto.setInvoiceNo("");
		dto.setInvoiceNo2("");
        Long currentUserId = CommonBean.getCurrentUser().getUserProfile().getUserId();
		
		// get and update next seq no as PB Invoice No
		ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
		this.setpInvoiceNo(pbService.getAndUpdteSeqNO(selectedDto.getProject().getProjectCode(), ProgressiveBillingConst.PB_INVOICE_SEQ_TYPE, true));			
		dto.setInvoiceNo(getPInvoiceNoFormated());

		if(stageDtoList!= null &&  !stageDtoList.isEmpty()){
//			refNo = getRefNo(selectedDto.getProject().getDeveloperId());
//			refNo = refNo + "/"+ selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo()+"/"+seqNo;
//			refNo = refNo + "/"+ selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo()+"/"+invoiceNo;
			refNo = selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo();
			Account act = selectedDto.getAccount();
			UserProfile userProfile = CommonBean.getCurrentUser().getUserProfile();

			// get bill and due date for progressive billing record
			Date billDate = new Date();
			if (selectedDto.getProject().getDaysToBill() != null) {
				billDate = getBillDate(selectedDto.getProject().getDaysToBill(), selectedDto.getProject().getIncludeOffDay(), userProfile);
			} else {
				selectedDto.getProject().setDaysToBill(0);
			}

			Date currentDate = new Date();
			Long daysDiff = (billDate.getTime() - currentDate.getTime()) / (24 * 60 * 60 * 1000);
			Integer daysToBill = daysDiff.intValue();
							
			Date dueDate = getDueDate(selectedDto.getProject().getDueDays(), daysToBill, selectedDto.getProject().getIncludeOffDay(), userProfile);
						
			Account a = new Account();
			a.setAccountId(act.getAccountId());
			
			BillingModelStageDTO sumDTO = stageDtoList.remove(stageDtoList.size() -1 );
			
			boolean isFirstSeqNo = false;
			BigDecimal txFinancierPortion = BigDecimal.ZERO;
			BigDecimal tempFinancierPortion = financierPortion;
			
			for (BillingModelStageDTO stageDto : stageDtoList) {
				
				ProgressiveBilling pb = new ProgressiveBilling();
				pb.setAccount(a);
				pb.setAmountBilled(act.getPurchasePrice().multiply(stageDto.getBillingModel().getBillingPercentage()).divide(new BigDecimal(100)));
				pb.setInvoiceNo(dto.getInvoiceNo());
				pb.setPercentage(stageDto.getBillingModel().getBillingPercentage());
				pb.setStageNo(stageDto.getBillingModel().getStage());
				pb.setStageDescription(stageDto.getBillingModel().getDescription());
				pb.setSeqNo(new Byte(stageDto.getBillingModel().getBillingSeq().toString()));
				pb.setStatus(ProgressiveBillingConst.PB_STATUS_BILL);
				if(stageDto.getBillingModel().getBillingSeq().equals(1) ){  // if first Stage, fixed the bill and due date
					isFirstSeqNo = true;
					if (act.getSpaStampedDate() == null) {
						pb.setDateBilled(new Date());
						pb.setDueDate(new Date()); 
					} else {
						pb.setDateBilled(act.getSpaStampedDate());
						pb.setDueDate(act.getSpaStampedDate()); 
					}
				} else {
					pb.setDateBilled(billDate);
					pb.setDueDate(dueDate); 
				}
				
				if (splitStageSeqNo > 0) {  // if the selected stage is split billing
					if (stageDto.getBillingModel().getBillingSeq() == splitStageSeqNo) {  // if same stage as split stage
						this.setpInvoiceNo(pbService.getAndUpdteSeqNO(selectedDto.getProject().getProjectCode(), ProgressiveBillingConst.PB_INVOICE_SEQ_TYPE, true));			
						dto.setInvoiceNo2(getPInvoiceNoFormated());	
						pb.setFinancierInvoiceNo(dto.getInvoiceNo2());
						pb.setFinancierPortion(financierStageAmount);
						txFinancierPortion = txFinancierPortion.add(financierStageAmount);
					} else {  // set the financier amount and invoice no
						if (stageDto.getBillingModel().getBillingSeq() > splitStageSeqNo) {
							txFinancierPortion = txFinancierPortion.add(pb.getAmountBilled());
							pb.setFinancierPortion(pb.getAmountBilled());
							pb.setFinancierInvoiceNo(dto.getInvoiceNo2());
						}
					}					
				} else {
					if (tempFinancierPortion.compareTo(BigDecimal.ZERO) >= 0) { // if bill to Financier
						pb.setFinancierPortion(pb.getAmountBilled());
						pb.setFinancierInvoiceNo(dto.getInvoiceNo());
						tempFinancierPortion = tempFinancierPortion.add(pb.getAmountBilled());
					} else {
						pb.setFinancierPortion(BigDecimal.ZERO);
						pb.setFinancierInvoiceNo("");
					}
				}
				
				progressiveBillingDao.insert(pb);			
			}// end for
						
			// for split billing, create 2 transaction history records
			if (splitStageSeqNo > 0) { 
				// create first transaction history for purchaser
				TransactionHistory tx = new TransactionHistory();
				tx.setTransactionCode(new TransactionCode(TransactionCodeConst.ADD_PROGRESSIVE_BILLING));
				tx.setTransactionDescription("PROGRESSIVE BILLING");
				tx.setAmount(sumDTO.getProgressiveBilling().getAmountBilled().subtract(financierStageAmount));
				tx.setCodeType(TransactionCodeConst.DEBIT);
				tx.setInvoiceNo(dto.getInvoiceNo());
		        tx.setUserId(currentUserId);
				tx.setStatus(TransactionStatusConst.POSTED);
				tx.setRefNo(refNo);
				tx.setAccount(a);
				tx.setTransactionDate(new Date());
				tx.setFinancierPortion(BigDecimal.ZERO);
				tx.setFinancierInvoiceNo("");
				tx.setPostedBy(currentUserId);
				tx.setPostingDate(new Date());
				transactionHistoryDao.insert(tx);
				
				// create second transaction history for financier
				TransactionHistory tx2 = new TransactionHistory();
				tx2.setTransactionCode(new TransactionCode(TransactionCodeConst.ADD_PROGRESSIVE_BILLING));
				tx2.setTransactionDescription("PROGRESSIVE BILLING");
				tx2.setAmount(financierStageAmount);
				tx2.setCodeType(TransactionCodeConst.DEBIT);
				tx2.setInvoiceNo(dto.getInvoiceNo2());
				tx2.setUserId(currentUserId);
				tx2.setStatus(TransactionStatusConst.POSTED);
				tx2.setRefNo(refNo);
				tx2.setAccount(a);
				tx2.setTransactionDate(new Date());
				tx2.setFinancierPortion(financierStageAmount);				
				tx2.setFinancierInvoiceNo(dto.getInvoiceNo2());
				tx2.setPostedBy(currentUserId);
				tx2.setPostingDate(new Date());
				transactionHistoryDao.insert(tx2);
				
			} else { // for single billing
				// create new PB transaction history record
				TransactionHistory tx = new TransactionHistory();
				tx.setTransactionCode(new TransactionCode(TransactionCodeConst.ADD_PROGRESSIVE_BILLING));
				tx.setTransactionDescription("PROGRESSIVE BILLING");
				tx.setAmount(sumDTO.getProgressiveBilling().getAmountBilled());
				tx.setCodeType(TransactionCodeConst.DEBIT);
				tx.setInvoiceNo(dto.getInvoiceNo());
		        tx.setUserId(currentUserId);
				tx.setStatus(TransactionStatusConst.POSTED);
				tx.setRefNo(refNo);
				tx.setAccount(a);
				tx.setTransactionDate(new Date());
				if (financierPortion.compareTo(BigDecimal.ZERO) >= 0) { //if bill to financier
					tx.setFinancierPortion(sumDTO.getProgressiveBilling().getAmountBilled());
					tx.setFinancierInvoiceNo(dto.getInvoiceNo());
				} else {
					tx.setFinancierPortion(BigDecimal.ZERO);
					tx.setFinancierInvoiceNo("");
				}
				tx.setPostedBy(currentUserId);
				tx.setPostingDate(new Date());
				transactionHistoryDao.insert(tx);
			}
			
			// update account balance
			act.setAccountBalance(act.getAccountBalanceNotNull().add(sumDTO.getProgressiveBilling().getAmountBilled()));
			act.setBillingAmountTodate(act.getBillingAmountTodateNotNull().add(sumDTO.getProgressiveBilling().getAmountBilled()));
			if(isFirstSeqNo){
				act.setAccountStatus(AccountStatusConst.STATUS_ACTIVE);
			}			
			accountDao.update(act);

			dto.setIsSucessfull(true);
//			isSucessfull = true;
		}
		
		return dto;
	}

	public BigDecimal getRemaingPaymentAmountByAccountIdStatusAndInvoiceNo(Long accountId, String[] statuses, String invoiceNo){
	
		return progressiveBillingDao.getRemaingPaymentAmountByAccountIdStatusAndInvoiceNo(accountId, statuses, invoiceNo);
		
	}
	
	public BigDecimal getRemaingPaymentAmountByAccountIdStatusAndFInvoiceNo(Long accountId, String[] statuses, String invoiceNo){
		
		return progressiveBillingDao.getRemaingPaymentAmountByAccountIdStatusAndFInvoiceNo(accountId, statuses, invoiceNo);
		
	}

	
	@Override
	@Transactional
	public boolean generatePaymentForInvoice(PaymentEntryDTO selectDto,BigDecimal paymentAmount, String paymentMethod, String bank, String chqNo,Date selectedChkDate, String selectedInvoice){
		boolean isSuccess = false;
        Long currentUserId = CommonBean.getCurrentUser().getUserProfile().getUserId();

		String[] statuses = new String[]{ProgressiveBillingConst.PB_STATUS_BILL, ProgressiveBillingConst.PB_STATUS_PARTIAL_PAYMENT};
		BigDecimal tempPaymentAmount = paymentAmount.add(BigDecimal.ZERO);
		List<ProgressiveBilling> pbList = progressiveBillingDao.findByAccountIdStatusAndInvoiceNo(selectDto.getAccount().getAccountId(), statuses, selectDto.getTransaction().getInvoiceNo());
		if(pbList == null || pbList.isEmpty()) {
			pbList = progressiveBillingDao.findByAccountIdStatusAndFInvoiceNo(selectDto.getAccount().getAccountId(), statuses, selectDto.getTransaction().getInvoiceNo());
		}
	
		if(pbList != null && !pbList.isEmpty()){
			
			for (ProgressiveBilling pb : pbList) {
				if(ProgressiveBillingConst.PB_STATUS_PARTIAL_PAYMENT.equals(pb.getStatus())){
					if((pb.getAmountBilled().subtract(pb.getPartialPaidAmountNotNull())).compareTo(tempPaymentAmount) == 1){
						pb.setPartialPaidAmount(pb.getPartialPaidAmountNotNull().add(tempPaymentAmount));
						pb.setStatus(ProgressiveBillingConst.PB_STATUS_PARTIAL_PAYMENT);
						tempPaymentAmount = BigDecimal.ZERO;
						
					}else{
						pb.setDatePaid(new Date());
						pb.setStatus(ProgressiveBillingConst.PB_STATUS_FULL_PAYMENT);						
						tempPaymentAmount = tempPaymentAmount.subtract(pb.getAmountBilled().subtract(pb.getPartialPaidAmountNotNull()));
						pb.setPartialPaidAmount(BigDecimal.ZERO);
						}
				}else if (ProgressiveBillingConst.PB_STATUS_BILL.equals(pb.getStatus())){
					if(pb.getAmountBilled().compareTo(tempPaymentAmount) == 1 ){
						pb.setPartialPaidAmount(tempPaymentAmount);
						pb.setStatus(ProgressiveBillingConst.PB_STATUS_PARTIAL_PAYMENT);
						tempPaymentAmount = BigDecimal.ZERO;
						
					}else{
						pb.setDatePaid(new Date());
						pb.setStatus(ProgressiveBillingConst.PB_STATUS_FULL_PAYMENT);
						tempPaymentAmount = tempPaymentAmount.subtract(pb.getAmountBilled());
						}
				}	
				progressiveBillingDao.update(pb);
			}// end for
		}//end if list.isempty
			
		//2. Update account table.
		//if(tempPaymentAmount.compareTo(BigDecimal.ZERO) == 0 ){
		Account act = selectDto.getAccount();
		act.setBillingPaymentTodate(act.getBillingPaymentTodateNotNull().add(paymentAmount));
		act.setTotalPaymentTodate(act.getTotalPaymentTodateNotNull().add(paymentAmount));
		act.setAccountBalance(act.getAccountBalanceNotNull().subtract(paymentAmount));
		BigDecimal tempRemdeptionAmount = act.getBankRedemptionSumNotNull().subtract(act.getBankRedemptionTodateNotNull());
		if (tempRemdeptionAmount.compareTo(BigDecimal.ZERO) == 1) {
			if (tempRemdeptionAmount.compareTo(paymentAmount) == 1) {
				act.setBankRedemptionTodate(act.getBankRedemptionTodateNotNull().add(paymentAmount));
			}else{
				act.setBankRedemptionTodate(act.getBankRedemptionTodateNotNull().add(tempRemdeptionAmount));
			}				
		}
		accountDao.update(act);
		//	}//end if
			
		//3 Create Payment Transaction History Record
		Account a = new Account();
		a.setAccountId(selectDto.getAccount().getAccountId());
			
		TransactionHistory th  = new TransactionHistory();
		th.setAccount(a);
		if (selectDto.getTransaction().getFinancierInvoiceNo().isEmpty()) {
			th.setTransactionCode(new TransactionCode(TransactionCodeConst.PAYMENT_FROM_PURCHASER));
		} else {
			th.setTransactionCode(new TransactionCode(TransactionCodeConst.PAYMENT_FROM_FINANCIER));			
		}
		th.setTransactionDate(new Date());
		th.setAmount(paymentAmount);
		th.setCodeType(TransactionCodeConst.CREDIT);
		th.setTransactionDescription("PAYMENT RECEIVED - THANK YOU");
		th.setPaymentMethod(paymentMethod);
		th.setBank(bank);
		th.setCardChequeNo(chqNo);
		th.setChqDate(selectedChkDate);
		//th.setInvoiceNo(selectDto.getTransaction().getInvoiceNo()); -- user select
		th.setInvoiceNo(selectedInvoice);
		th.setRefNo(selectDto.getTransaction().getRefNo());
		//th.setTxnReversalId(selectDto.getTransaction().getTransactionId());
	    th.setUserId(currentUserId);
		th.setStatus(TransactionStatusConst.POSTED);
		th.setPostedBy(currentUserId);
		th.setPostingDate(new Date());
		transactionHistoryDao.insert(th);

		if(selectDto.getTransaction().getAmount().compareTo(paymentAmount) == 0) {
			selectDto.getTransaction().setTxnReversalId(th.getTransactionId());
			transactionHistoryDao.update(selectDto.getTransaction());
		} else {
			boolean fullyPaid = progressiveBillingDao.isInvoiceFullyPaid(selectDto.getAccount().getAccountId(), selectDto.getTransaction().getInvoiceNo());
			if(fullyPaid){
				selectDto.getTransaction().setTxnReversalId(th.getTransactionId());
				transactionHistoryDao.update(selectDto.getTransaction());
			} else {
				if(!selectDto.getTransaction().getFinancierInvoiceNo().isEmpty()) {
					fullyPaid = progressiveBillingDao.isFInvoiceFullyPaid(selectDto.getAccount().getAccountId(), selectDto.getTransaction().getInvoiceNo());
					if(fullyPaid){
						selectDto.getTransaction().setTxnReversalId(th.getTransactionId());
						transactionHistoryDao.update(selectDto.getTransaction());
					} 
				}
			}
		}
		isSuccess = true;
		return isSuccess;		
	}
	
	public boolean generateReversalForBilling(PaymentEntryDTO selectDto,BigDecimal txnAmount, String selectedInvoice){
		boolean isSuccess = false;
        Long currentUserId = CommonBean.getCurrentUser().getUserProfile().getUserId();
				
		//1. Update account table.
		Account act = selectDto.getAccount();
		act.setAccountBalance(act.getAccountBalanceNotNull().subtract(txnAmount));
		act.setBillingAmountTodate(act.getBillingAmountTodateNotNull().subtract(txnAmount));
		accountDao.update(act);	

		//2 Create Reversal Transaction History Record
		Account aa = new Account();
		aa.setAccountId(selectDto.getAccount().getAccountId());
		
		TransactionHistory trev  = new TransactionHistory();
		trev.setAccount(aa);
		trev.setTransactionCode(new TransactionCode(TransactionCodeConst.MANUAL_REVERSAL));
		trev.setTransactionDate(new Date());
		trev.setAmount(txnAmount);
		trev.setCodeType(TransactionCodeConst.CREDIT);
		trev.setTransactionDescription("REVERSAL - PROGRESSIVE BILLING");
		trev.setInvoiceNo(selectDto.getTransaction().getInvoiceNo());
		trev.setRefNo(selectDto.getTransaction().getRefNo());
//		trev.setTxnReversalId(selectDto.getTransaction().getTransactionId());
        trev.setUserId(currentUserId);
		trev.setStatus(TransactionStatusConst.POSTED);
		if (selectDto.getTransaction().getFinancierInvoiceNo() != null) {
			trev.setFinancierInvoiceNo(selectDto.getTransaction().getFinancierInvoiceNo());	
		}
		if (selectDto.getTransaction().getFinancierPortion() != null) {
			trev.setFinancierPortion(selectDto.getTransaction().getFinancierPortion());	
		}
		trev.setPostedBy(currentUserId);
		trev.setPostingDate(new Date());
		transactionHistoryDao.insert(trev);	
		
		//3 Update all selected reversal records as Reversal	
		String[] statuses = new String[]{ProgressiveBillingConst.PB_STATUS_BILL};
		List<ProgressiveBilling> pbList = progressiveBillingDao.findByAccountIdStatusAndInvoiceNo(selectDto.getAccount().getAccountId(), statuses, selectDto.getTransaction().getInvoiceNo());
		if(pbList != null && !pbList.isEmpty()){
			for (ProgressiveBilling pb : pbList) {
				pb.setTxnReversalId(trev.getTransactionId()); 
				pb.setStatus(ProgressiveBillingConst.PB_STATUS_REVERSAL);
				progressiveBillingDao.update(pb);
			}// end for
		}//end if list.isempty
		
		//4 Update the Original Transaction History Record 	
		selectDto.getTransaction().setTxnReversalId(trev.getTransactionId());
		transactionHistoryDao.update(selectDto.getTransaction());
		
		isSuccess = true;

	return isSuccess;
	}

	public boolean processTransactionUpdate(TransactionEntryDTO selectDto,BigDecimal txnAmount, String selectedInvoice){
		boolean isSuccess = false;
        Long currentUserId = CommonBean.getCurrentUser().getUserProfile().getUserId();
				
		//1. Update account table.
		Account act = selectDto.getAccount();
		act.setAccountBalance(act.getAccountBalanceNotNull().subtract(txnAmount));
		act.setBillingAmountTodate(act.getBillingAmountTodateNotNull().subtract(txnAmount));
		accountDao.update(act);	

		//2 Create Reversal Transaction History Record
		Account aa = new Account();
		aa.setAccountId(selectDto.getAccount().getAccountId());
		
		TransactionHistory tu  = new TransactionHistory();
		tu.setAccount(aa);
		tu.setTransactionCode(new TransactionCode(TransactionCodeConst.MANUAL_REVERSAL));
		tu.setTransactionDate(new Date());
		tu.setAmount(txnAmount);
		tu.setCodeType(TransactionCodeConst.CREDIT);
		tu.setTransactionDescription("MANUAL REVERSAL - PROGRESSIVE BILLING");
//		tu.setInvoiceNo(selectDto.getTransaction().getInvoiceNo());
//		tu.setRefNo(selectDto.getTransaction().getRefNo());
//		tu.setTxnReversalId(selectDto.getTransaction().getTransactionId());
        tu.setUserId(currentUserId);
		tu.setStatus(TransactionStatusConst.POSTED);
//		if (selectDto.getTransaction().getFinancierInvoiceNo() != null) {
//			tu.setFinancierInvoiceNo(selectDto.getTransaction().getFinancierInvoiceNo());	
//		}
//		if (selectDto.getTransaction().getFinancierPortion() != null) {
//			tu.setFinancierPortion(selectDto.getTransaction().getFinancierPortion());	
//		}
		tu.setPostedBy(currentUserId);
		tu.setPostingDate(new Date());
		transactionHistoryDao.insert(tu);	
			
		isSuccess = true;

	return isSuccess;
	}

	
	private String getRefNo(Long developerId){
		String refNo = "";
		BusinessPartner partner = this.businessPartnerDao.findById(developerId);
		if(partner != null)
			refNo = partner.getCompanyCode();
		return refNo;
	}
	
	private Date getDueDate(int dueDays, int daysToBill, String includeOffDay, UserProfile profile) {
		Calendar cal = Calendar.getInstance();
		
		if (includeOffDay.compareTo("Y") == 0) {
			cal.add(Calendar.DAY_OF_YEAR, (daysToBill + dueDays - 1));
		} else {
			cal.add(Calendar.DAY_OF_YEAR, (daysToBill + 1));	

			boolean isOffDay = false;
			Integer countDays = 1;
			do {
				isOffDay = institutionDao.isOffDay(cal.get(Calendar.DAY_OF_WEEK), profile.getInstitution().getInstitutionId());
				if(!isOffDay){
					isOffDay = institutionDao.isHoliday(cal.getTime(), profile.getInstitution().getInstitutionId());
				}
				if(!isOffDay){
					countDays++;
				} 
				cal.add(Calendar.DAY_OF_YEAR, 1);
			} while (countDays < dueDays); 			
			
			boolean isOffDay2 = false;
			do {
				if(isOffDay2){
					cal.add(Calendar.DAY_OF_YEAR, 1);
				}
				isOffDay2 = institutionDao.isOffDay(cal.get(Calendar.DAY_OF_WEEK), profile.getInstitution().getInstitutionId());
				if(!isOffDay2){
					isOffDay2 = institutionDao.isHoliday(cal.getTime(), profile.getInstitution().getInstitutionId());
				}
			} while (isOffDay2); 	
		}
		
//		if (includeOffDay.compareTo("N") == 0) {
//			boolean isOffDay = false;
//			do {
//				if(isOffDay){
//					cal.add(Calendar.DAY_OF_YEAR, 1);
//				}
//				isOffDay = institutionDao.isOffDay(cal.get(Calendar.DAY_OF_WEEK), profile.getInstitution().getInstitutionId());
//				if(!isOffDay){
//					isOffDay = institutionDao.isHoliday(cal.getTime(), profile.getInstitution().getInstitutionId());
//				}
//			} while (isOffDay); 			
//		}

		Date dueDate = cal.getTime(); 		
		return dueDate;
	}
	
	private Date getBillDate(int daysToBill, String includeOffDay, UserProfile profile) {
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, daysToBill);
		
		if (includeOffDay.compareTo("N") == 0) {			
			boolean isOffDay = false;
			do {
				if(isOffDay){
					cal2.add(Calendar.DAY_OF_YEAR, 1);
				}
				isOffDay = institutionDao.isOffDay(cal2.get(Calendar.DAY_OF_WEEK), profile.getInstitution().getInstitutionId());
				if(!isOffDay){
					isOffDay = institutionDao.isHoliday(cal2.getTime(), profile.getInstitution().getInstitutionId());
				}
			} while (isOffDay); 			
		}
		
		Date billDate = cal2.getTime(); 
		return billDate;
	}

	/***************************** Getter/Setters *****************************/
	
	public ProgressiveBillingDao getProgressiveBillingDao() {
		return progressiveBillingDao;
	}

	public void setProgressiveBillingDao(ProgressiveBillingDao progressiveBillingDao) {
		this.progressiveBillingDao = progressiveBillingDao;
	}
	public BillingModelDao getBillingModelDao() {
		return billingModelDao;
	}

	public void setBillingModelDao(BillingModelDao billingModelDao) {
		this.billingModelDao = billingModelDao;
	}
	

	
	public SeqNoDao getSeqNoDao() {
		return seqNoDao;
	}

	public void setSeqNoDao(SeqNoDao seqNoDao) {
		this.seqNoDao = seqNoDao;
	}

	public BusinessPartnerDao getBusinessPartnerDao() {
		return businessPartnerDao;
	}

	public void setBusinessPartnerDao(BusinessPartnerDao businessPartnerDao) {
		this.businessPartnerDao = businessPartnerDao;
	}

	public TransactionHistoryDao getTransactionHistoryDao() {
		return transactionHistoryDao;
	}

	public void setTransactionHistoryDao(TransactionHistoryDao transactionHistoryDao) {
		this.transactionHistoryDao = transactionHistoryDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public InstitutionDao getInstitutionDao() {
		return institutionDao;
	}

	public void setInstitutionDao(InstitutionDao institutionDao) {
		this.institutionDao = institutionDao;
	}

	public Long getpInvoiceNo() {
		return pInvoiceNo;
	}
	
	public String getPInvoiceNoFormated() {
		return String.format("PB%04d%n", this.pInvoiceNo);
	}

	public void setpInvoiceNo(Long pInvoiceNo) {
		this.pInvoiceNo = pInvoiceNo;
	}

	
}
