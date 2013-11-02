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
	public Long getLatestPBSeqNo() {
		Long no = new Long(0l);
		SeqNo seq = seqNoDao.findById(ProgressiveBillingConst.PB_INVOICE_SEQ_TYPE);
		no = seq.getNextSeq() + 1 ;
		//seq.setNextSeq(no);
		seqNoDao.updateSeqNo(ProgressiveBillingConst.PB_INVOICE_SEQ_TYPE, no);
		return no;
	}

	@Override
	public void printProgressiveLetter(Long projectId , String invoiceNo, String accountId){
		ReportService rs = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setProjectId(projectId);
		reportDTO.setReportFormatId(new Long(2l));
		reportDTO.setBlocksTitle(invoiceNo);
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
	@Transactional
	public boolean generateProgressiveBillForSelectedStages(
			List<BillingModelStageDTO> stageDtoList, String invoiceNo, ProgressiveBillingUnitSeachDTO selectedDto) {
		boolean isSucessfull = false;
		
		String refNo = "";

		if(stageDtoList!= null &&  !stageDtoList.isEmpty()){
			refNo = getRefNo(selectedDto.getProject().getDeveloperId());
			refNo = refNo + "/"+ selectedDto.getProject().getProjectCode() +"/" + selectedDto.getProjectInvetory().getUnitNo()+"/"+invoiceNo;
			Account act = selectedDto.getAccount();
			UserProfile userProfile = CommonBean.getCurrentUser().getUserProfile();
			
			Account a = new Account();
			a.setAccountId(act.getAccountId());
			
			BillingModelStageDTO sumDTO = stageDtoList.remove(stageDtoList.size() -1 );
			
			boolean isFirstSeqNo = false;

			TransactionHistory tx = new TransactionHistory();
			tx.setTransactionCode(new TransactionCode(TransactionCodeConst.ADD_PROGRESSIVE_BILLING));
			tx.setTransactionDescription("Progressive Billing ");
			tx.setAmount(sumDTO.getProgressiveBilling().getAmountBilled());
			tx.setInvoiceNo(invoiceNo);
			tx.setStatus(TransactionStatusConst.PENDING);
			tx.setRefNo(refNo);
			tx.setAccount(a);
			tx.setTransactionDate(new Date());				
			transactionHistoryDao.insert(tx);
			
			Date dueDate = getDueDate(selectedDto.getProject().getDueDays(), userProfile);
			
			for (BillingModelStageDTO stageDto : stageDtoList) {
				if(stageDto.getBillingModel().getBillingSeq().equals(1) ){
					isFirstSeqNo = true;
				}
				ProgressiveBilling pb = new ProgressiveBilling();
				pb.setAccount(a);
				pb.setAmountBilled(act.getPurchasePrice().multiply(stageDto.getBillingModel().getBillingPercentage()).divide(new BigDecimal(100)));
				pb.setDateBilled(new Date());
				pb.setInvoiceNo(invoiceNo);
				pb.setPercentage(stageDto.getBillingModel().getBillingPercentage());
				pb.setStageNo(stageDto.getBillingModel().getStage());
				pb.setStageDescription(stageDto.getBillingModel().getDescription());
				pb.setSeqNo(new Byte(stageDto.getBillingModel().getBillingSeq().toString()));
				pb.setStatus(ProgressiveBillingConst.PB_STATUS_BILL);
				pb.setDueDate(dueDate); 
				
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
	
	
	private String getRefNo(Long developerId){
		String refNo = "";
		BusinessPartner partner = this.businessPartnerDao.findById(developerId);
		if(partner != null)
			refNo = partner.getCompanyCode();
		return refNo;
	}
	
	private Date getDueDate(int dueDays,UserProfile profile){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, dueDays);

		boolean isOffDay = false;
		
		do {
			if(isOffDay){
				cal.add(Calendar.DAY_OF_YEAR, 1);
			}
			isOffDay = institutionDao.isOffDay(cal.get(Calendar.DAY_OF_WEEK), profile.getInstitution().getInstitutionId());
			if(!isOffDay){
				isOffDay = institutionDao.isHoliday(cal.getTime(), profile.getInstitution().getInstitutionId());
			}
		} while (isOffDay);  
		Date dueDate = cal.getTime(); 		
		return dueDate;
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
