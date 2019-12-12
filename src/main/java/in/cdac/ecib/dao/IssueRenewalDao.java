package in.cdac.ecib.dao;

import java.util.List;
import in.cdac.ecib.dto.IssueRenewal;

public interface IssueRenewalDao {
	
	public void Save(IssueRenewal issueRenewal);

	public int Update(String id, IssueRenewal issueRenewal); 

	public List<IssueRenewal > userList();
	
	public IssueRenewal selectUsers(String proposalfrmid);

	public IssueRenewal getbyDocuments(String proposal_frm_id);

	public IssueRenewal openOfficeNotePC(IssueRenewal issueRenewal);
	
	public boolean isValidOfficeNoteId(String Wt_isrn_proposal_frm_id);
	
	public IssueRenewal openOfficeNotePS(IssueRenewal issueRenewal);
	
	public void insertSystemEntryPS(IssueRenewal issueRenewal);
	
	public IssueRenewal getONInfo(String wt_isrn_proposal_frm_id);
	
	public int prelimiaryScrutinyCompleted(String wt_isrn_proposal_frm_id);
	
	public List<IssueRenewal> getlistOfPreliminaryScrutinyDone();
	
	public Object createOfficeNote();
}
