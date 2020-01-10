package in.cdac.ecib.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import in.cdac.ecib.dto.Button;
import in.cdac.ecib.dto.IssueRenewal;
import in.cdac.ecib.dto.User;

public interface IssueRenewalServ {
	
	
	public void insertIssueRenewalRecord(IssueRenewal issueRenewal);
	

	public int modifyIssueRenewalForm(String id,IssueRenewal issueRenewal);

	
	public IssueRenewal getIssueRenewalById(String proposalfrmid);

	
	public IssueRenewal getByDocument(String proposal_frm_id);

	
	public IssueRenewal openOfficeNotePC(IssueRenewal issueRenewal);

	
	public IssueRenewal openOfficeNotePS(IssueRenewal issueRenewal);

	
	public boolean checkId(String Wt_isrn_proposal_frm_id);

	
	public int getById(IssueRenewal issueRenewal);
	

	public void insertSystemEntry(IssueRenewal issueRenewal);
	

	public IssueRenewal getOfficeNoteInfo(String wt_isrn_proposal_frm_id);
	

	public int psCompleted(String wt_isrn_proposal_frm_id);
	
	
	public void createOfficeNote(IssueRenewal issueRenewal);


	public void insertRecommendationData( String wt_isrn_proposal_frm_id,String recommendation_line);


	public  List<String> showRecommedation(String wt_isrn_proposal_frm_id);


	public IssueRenewal getDetailsOfDop(String isrn_id);


	public void dopDone(String decision, String remarks, String reason, Date start_date, Date expiry_date,
			BigDecimal ml, BigDecimal dl, BigDecimal set_limit, IssueRenewal issueRenewal);


	public int submitIssueRenewal(String proposalfrmid);

	
	public List<Button> getListOfButton();


	public List<IssueRenewal> getAllIssueRenewalList();

}
