package com.vipro.service;

import java.io.File;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.dto.ReportDTO;
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
					dto.setStatus(ProgressiveBillingConst.STAGE_BILLED);	
				}else{
					dto.setStatus(ProgressiveBillingConst.STAGE_PENDING);
				}
				
				if(pb.getInvoiceNo()!= null && pb.getInvoiceNo().startsWith("RB")){ // if it is Renoticed.
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
	public void printProgressiveLetter(String amount, Long projectId , String invoiceNo, String accountId){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
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
	public void printProgressiveLetterCash(String amount, Long projectId , String invoiceNo, String accountId){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
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
	public void printProgressiveLetterPurchaser(String amount, Long projectId , String invoiceNo, String accountId){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
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
	public void printRenoticeLetter(String amount, Long projectId , String invoiceNo, String accountId){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(3l));
		reportDTO.setBlocksTitle(invoiceNo);
		reportDTO.setInstitutionName(amount);
		try {
			String path = JasperConst.ACCOUNTS_FOLDER+"/"+accountId+"/"+CommonConst.PROGRESSIVE_BILL_FOLDER_NAME+"/";
			
			 File baseFolder = new File(path);
			 if(!baseFolder.exists()){
				 baseFolder.mkdirs();
				}
			
			rs.generateRenoticeLetterReport(reportDTO,invoiceNo,path);
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
			List<BillingModelStageDTO> stageDtoList, Long seqNo, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto) {
		boolean isSucessfull = false;
		if(stageDtoList!= null &&  !stageDtoList.isEmpty()){
			Account act = selectedDto.getAccount();		
			BillingModelStageDTO sumDTO = stageDtoList.remove(stageDtoList.size() -1 );
			UserProfile userProfile = CommonBean.getCurrentUser().getUserProfile();
			BigDecimal totalAmount = sumDTO.getProgressiveBilling().getAmountBilled();			
			String refNo = getRefNo(selectedDto.getProject().getDeveloperId());
//			refNo = refNo + "/"+ selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo()+"/"+seqNo;
//			refNo = refNo + "/"+ selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo()+"/"+invoiceNo;
			refNo = selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo();

			
			//1. Progressive Billing Reversal Transaction History Record
			TransactionHistory tx = new TransactionHistory();
			tx.setTransactionCode(new TransactionCode(
					TransactionCodeConst.REVERSAL_PROGRESSIVE_BILLING));
			tx.setTransactionDescription("PROGRESSIVE BILLING REVERSAL");
			tx.setAmount(totalAmount);
			tx.setStatus(TransactionStatusConst.TRANSACTION_PENDING);
			//tx.setInvoiceNo(invoiceNo);
			//tx.setRefNo(refNo);
			tx.setAccount(act);
			tx.setTransactionDate(new Date());
			transactionHistoryDao.insert(tx);
			
			//2. New Payment Reversal Transaction History Record
			//2.a
			BigDecimal tempTotalAmountPaid = BigDecimal.ZERO;
			String[] stageNos = new String[stageDtoList.size()];
			int i = 0;
			for (BillingModelStageDTO stageDto : stageDtoList) {				
				if(ProgressiveBillingConst.PB_STATUS_FULL_PAYMENT.equals(stageDto.getProgressiveBilling().getStatus())){
					tempTotalAmountPaid = tempTotalAmountPaid.add(stageDto.getProgressiveBilling().getAmountBilled());
				}
				stageNos[i++]= stageDto.getBillingModel().getStage();// building string for query.
			}
			
			if (tempTotalAmountPaid.compareTo(BigDecimal.ZERO) > 0 ) {	
				//2.b
				Account aa = new Account();
				aa.setAccountId(act.getAccountId());
				TransactionHistory txPayRev = new TransactionHistory();
				txPayRev.setTransactionCode(new TransactionCode(TransactionCodeConst.REVERSAL_PAYMENT_FROM_PURCHASER));
				txPayRev.setTransactionDescription("PAYMENT REVERSAL");
				txPayRev.setAmount(tempTotalAmountPaid);
				txPayRev.setStatus(TransactionStatusConst.TRANSACTION_PENDING);
				txPayRev.setAccount(aa);
				txPayRev.setTransactionDate(new Date());				
				transactionHistoryDao.insert(txPayRev);	
				
				
				//2.c
				act.setTotalPaymentTodate(act.getTotalPaymentTodateNotNull().subtract(tempTotalAmountPaid));
				act.setAccountBalance(act.getAccountBalanceNotNull().add(tempTotalAmountPaid));
				if(act.getBankRedemptionTodateNotNull().compareTo(BigDecimal.ZERO) > 0 ){
					act.setBankRedemptionTodate(act.getBankRedemptionTodateNotNull().subtract(tempTotalAmountPaid));					
				}
				act.setDateChanged(new Date());
				act.setChangedBy(userProfile.getUserId());
				accountDao.update(act);
			}
			
			//3.  Update Existing ProgressiveBilling records for selected stages(PBBIL/PBPAI)
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
			
			Date dueDate = getDueDate(selectedDto.getProject().getDueDays(), daysToBill, selectedDto.getProject().getIncludeOffDay(), userProfile);
			Account a = new Account();
			a.setAccountId(act.getAccountId());

			for (BillingModelStageDTO stageDto : stageDtoList) {				
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
				
				progressiveBillingDao.insert(pb);
			}// end for
			
			
			//5. Create new TransactionHistory Renotice record
			TransactionHistory txr = new TransactionHistory();
			txr.setTransactionCode(new TransactionCode(TransactionCodeConst.RENOTICE_BILLING));
			txr.setTransactionDescription("RENOTICE BILLING");
			txr.setAmount(totalAmount);
			txr.setInvoiceNo(invoiceNo);
			txr.setStatus(TransactionStatusConst.TRANSACTION_PENDING);
			txr.setRefNo(refNo);
			txr.setAccount(a);
			txr.setTransactionDate(new Date());				
			transactionHistoryDao.insert(txr);

			isSucessfull = true;
		}		
		return isSucessfull;
	}
	
	
	
	@Override
	@Transactional
	public boolean generateProgressiveBillForSelectedStages(
			List<BillingModelStageDTO> stageDtoList, Long seqNo, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto) {
		boolean isSucessfull = false;
		
		String refNo = "";

		if(stageDtoList!= null &&  !stageDtoList.isEmpty()){
			refNo = getRefNo(selectedDto.getProject().getDeveloperId());
//			refNo = refNo + "/"+ selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo()+"/"+seqNo;
//			refNo = refNo + "/"+ selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo()+"/"+invoiceNo;
			refNo = selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo();
			Account act = selectedDto.getAccount();
			UserProfile userProfile = CommonBean.getCurrentUser().getUserProfile();
			
			Account a = new Account();
			a.setAccountId(act.getAccountId());
			
			BillingModelStageDTO sumDTO = stageDtoList.remove(stageDtoList.size() -1 );
			
			boolean isFirstSeqNo = false;
			
			TransactionHistory tx = new TransactionHistory();
			tx.setTransactionCode(new TransactionCode(TransactionCodeConst.ADD_PROGRESSIVE_BILLING));
			tx.setTransactionDescription("PROGRESSIVE BILLING");
			tx.setAmount(sumDTO.getProgressiveBilling().getAmountBilled());
			tx.setInvoiceNo(invoiceNo);
			tx.setStatus(TransactionStatusConst.PENDING);
			tx.setRefNo(refNo);
			tx.setAccount(a);
			tx.setTransactionDate(new Date());				
			transactionHistoryDao.insert(tx);
			
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
			
			for (BillingModelStageDTO stageDto : stageDtoList) {
				ProgressiveBilling pb = new ProgressiveBilling();
				pb.setAccount(a);
				pb.setAmountBilled(act.getPurchasePrice().multiply(stageDto.getBillingModel().getBillingPercentage()).divide(new BigDecimal(100)));
				pb.setInvoiceNo(invoiceNo);
				pb.setPercentage(stageDto.getBillingModel().getBillingPercentage());
				pb.setStageNo(stageDto.getBillingModel().getStage());
				pb.setStageDescription(stageDto.getBillingModel().getDescription());
				pb.setSeqNo(new Byte(stageDto.getBillingModel().getBillingSeq().toString()));
				pb.setStatus(ProgressiveBillingConst.PB_STATUS_BILL);

				if(stageDto.getBillingModel().getBillingSeq().equals(1) ){
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
				
				progressiveBillingDao.insert(pb);
			}// end for
			
			act.setAccountBalance(act.getAccountBalanceNotNull().add(sumDTO.getProgressiveBilling().getAmountBilled()));
			act.setDateChanged(new Date());
			act.setChangedBy(userProfile.getUserId());
			if(isFirstSeqNo){
				act.setAccountStatus(AccountStatusConst.STATUS_ACTIVE);
			}
			
			accountDao.update(act);
			isSucessfull = true;
		}
		return isSucessfull;
	}
	
	public BigDecimal getRemaingPaymentAmountByAccountIdStatusAndInvoiceNo(Long accountId, String[] statuses, String invoiceNo){
	
		return progressiveBillingDao.getRemaingPaymentAmountByAccountIdStatusAndInvoiceNo(accountId, statuses, invoiceNo);
		
	}
	
	
	@Override
	@Transactional
	public boolean generatePaymentForInvoice(PaymentEntryDTO selectDto,BigDecimal paymentAmount, String paymentMethod, String bank, String chqNo,Date selectedChkDate){
		boolean isSuccess = false;
		
		String[] statuses = new String[]{ProgressiveBillingConst.PB_STATUS_BILL, ProgressiveBillingConst.PB_STATUS_PARTIAL_PAYMENT};
		BigDecimal tempPaymentAmount = paymentAmount.add(BigDecimal.ZERO);
		List<ProgressiveBilling> pbList = progressiveBillingDao.findByAccountIdStatusAndInvoiceNo(selectDto.getAccount().getAccountId(), statuses, selectDto.getTransaction().getInvoiceNo());
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
			th.setTransactionCode(new TransactionCode(TransactionCodeConst.PAYMENT_FROM_PURCHASER));
			th.setTransactionDate(new Date());
			th.setAmount(paymentAmount);
			th.setTransactionDescription("PAYMENT RECEIVED");
			th.setPaymentMethod(paymentMethod);
			th.setBank(bank);
			th.setCardChequeNo(chqNo);
			th.setChqDate(selectedChkDate);
			th.setInvoiceNo(selectDto.getTransaction().getInvoiceNo());
			th.setRefNo(selectDto.getTransaction().getRefNo());
			//th.setTxnReversalId(selectDto.getTransaction().getTransactionId());
			th.setStatus(TransactionStatusConst.TRANSACTION_PENDING);
			transactionHistoryDao.insert(th);
			
			boolean fullyPaid = progressiveBillingDao.isInvoiceFullyPaid(selectDto.getAccount().getAccountId(), selectDto.getTransaction().getInvoiceNo());
			if(fullyPaid){
				selectDto.getTransaction().setTxnReversalId(th.getTransactionId());
				transactionHistoryDao.update(selectDto.getTransaction());
			}
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

	
}
