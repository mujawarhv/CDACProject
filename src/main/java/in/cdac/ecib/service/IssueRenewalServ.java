package in.cdac.ecib.service;

import java.util.List;
import in.cdac.ecib.dto.IssueRenewal;
import in.cdac.ecib.dto.User;

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
	

	public void createOfficeNote(IssueRenewal issueRenewal);


	public List<String> getListOfOfficeNoteDone();


	public User loginUser(User user);


	public void insertRecommendationData( String wt_isrn_proposal_frm_id,String recommendation_line);


	public  List<String> showRecommedation(String wt_isrn_proposal_frm_id);


	public List<String> getListOfRecommedationNoteDone();


	public List<String> showRecommedation();


	public IssueRenewal getDetailsOfDop(String isrn_id);
}
