package in.cdac.ecib.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import in.cdac.ecib.dto.Button;
import in.cdac.ecib.dto.IssueRenewal;
import in.cdac.ecib.dto.User;

public interface IssueRenewalDao {
	
	public void saveIssueRenewalRecord(IssueRenewal issueRenewal);

	public int updateIssueRenewalForm(String id, IssueRenewal issueRenewal); 
	
	public IssueRenewal getIssueRenewalById(String proposalfrmid);

	public IssueRenewal getbyDocuments(String proposal_frm_id);

	public IssueRenewal openOfficeNotePC(IssueRenewal issueRenewal);
	
	public boolean isValidOfficeNoteId(String Wt_isrn_proposal_frm_id);
	
	public IssueRenewal openOfficeNotePS(IssueRenewal issueRenewal);
	
	public void insertSystemEntryPS(IssueRenewal issueRenewal);
	
	public IssueRenewal getONInfo(String wt_isrn_proposal_frm_id);
	
	public int prelimiaryScrutinyCompleted(String wt_isrn_proposal_frm_id);
	
	public void createOfficeNote(IssueRenewal issueRenewal);
	

	public void insertRecommendation(String wt_isrn_proposal_frm_id,String wt_isrn_office_note_recommendation_id);

	public List<String> showRecommedationMessage(String wt_isrn_proposal_frm_id);

	public IssueRenewal getDetailsOfDop(String isrn_id);

	public void insertdop(String decision, String remarks, String reason, Date start_date, Date expiry_date,
			BigDecimal ml, BigDecimal dl, BigDecimal set_limit, IssueRenewal issueRenewal);

	public int submitIssueRenewal(String proposalfrmid);

	public List<Button> buttonList();

	List<IssueRenewal> getAllIssueRenewalList();
}
