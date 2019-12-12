package in.cdac.ecib.service;

import java.util.List;
import in.cdac.ecib.dto.IssueRenewal;

public interface IssueRenewalServ {
	
	
	public void Create(IssueRenewal issueRenewal);
	

	public int Modify(String id,IssueRenewal issueRenewal);

	
	public List<IssueRenewal> getAllBankList();

	
	public IssueRenewal selectUser(String proposalfrmid);

	
	public IssueRenewal getByDocument(String proposal_frm_id);

	
	public IssueRenewal openOfficeNotePC(IssueRenewal issueRenewal);

	
	public IssueRenewal openOfficeNotePS(IssueRenewal issueRenewal);

	
	public boolean checkId(String Wt_isrn_proposal_frm_id);

	
	public int getById(IssueRenewal issueRenewal);
	

	public void insertSystemEntry(IssueRenewal issueRenewal);
	

	public IssueRenewal getOfficeNoteInfo(String wt_isrn_proposal_frm_id);
	

	public int psCompleted(String wt_isrn_proposal_frm_id);
	

	public List<IssueRenewal> getlistOfPreliminaryScrutinyDone();
	

	public void createOfficeNote();
}
