package in.cdac.ecib.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.ecib.dao.IssueRenewalDao;
import in.cdac.ecib.dto.Button;
import in.cdac.ecib.dto.IssueRenewal;
import in.cdac.ecib.dto.User;

@Service
public class IssueRenewalServImpl implements IssueRenewalServ {
	
	@Autowired
	IssueRenewalDao issueRenewalDao;

	@Override
	public void create(IssueRenewal issueRenewal) {
		issueRenewalDao.save(issueRenewal);		
	}

	@Override
	public int modify(String id,IssueRenewal issueRenewal) {
		return issueRenewalDao.update(id, issueRenewal);		
	}

	@Override
	public List<IssueRenewal> getAllBankList() {
		return issueRenewalDao.userList();
	}

	@Override
	public IssueRenewal selectUser(String proposalfrmid) {
		return issueRenewalDao.selectUsers(proposalfrmid);
	}

	@Override
	public IssueRenewal getByDocument(String proposal_frm_id) {
		return issueRenewalDao.getbyDocuments(proposal_frm_id);
	}

	@Override
	public IssueRenewal openOfficeNotePC(IssueRenewal issueRenewal) {
		return issueRenewalDao.openOfficeNotePC(issueRenewal);
	}

	@Override
	public IssueRenewal openOfficeNotePS(IssueRenewal issueRenewal) {
		return issueRenewalDao.openOfficeNotePS(issueRenewal);
	}

	@Override
	public boolean checkId(String Wt_isrn_proposal_frm_id) {
		return issueRenewalDao.isValidOfficeNoteId(Wt_isrn_proposal_frm_id);
	}

	@Override
	public int getById(IssueRenewal issueRenewal) {
	
		return 0;
	}
	
	@Override
	public void insertSystemEntry(IssueRenewal issueRenewal) {
		issueRenewalDao.insertSystemEntryPS(issueRenewal);		
	}

	@Override
	public IssueRenewal getOfficeNoteInfo(String wt_isrn_proposal_frm_id) {
		return issueRenewalDao.getONInfo(wt_isrn_proposal_frm_id);
	}

	@Override
	public int psCompleted(String wt_isrn_proposal_frm_id) {
		return issueRenewalDao.prelimiaryScrutinyCompleted(wt_isrn_proposal_frm_id);
	}


	@Override
	public void createOfficeNote(IssueRenewal issueRenewal) {
		 issueRenewalDao.createOfficeNote(issueRenewal);		
	}


	@Override
	public User loginUser(User user) {
		return issueRenewalDao.loginUser(user);
	}

	@Override
	public void insertRecommendationData( String wt_isrn_proposal_frm_id,String recommendation_line) {
	  issueRenewalDao.insertRecommendation(wt_isrn_proposal_frm_id,recommendation_line);		
	}

	@Override
	public  List<String> showRecommedation(String wt_isrn_proposal_frm_id) {
		return issueRenewalDao.showRecommedationMessage(wt_isrn_proposal_frm_id);
	}

	@Override
	public List<String> getListOfRecommedationNoteDone() {
		return issueRenewalDao.getListOfRecommedationDone();
	}

	@Override
	public List<String> showRecommedation() {
		return issueRenewalDao.getListOfRecommedationDone();
	}

	@Override
	public IssueRenewal getDetailsOfDop(String isrn_id) {
		return issueRenewalDao.getDetailsOfDop(isrn_id);
	}

	@Override
	public void dopDone(String decision, String remarks, String reason, Date start_date, Date expiry_date,
			String ml, String dl, String set_limit, IssueRenewal issueRenewal) {
		issueRenewalDao.insertdop( decision,  remarks,  reason,  start_date,  expiry_date, ml,  dl,  set_limit,  issueRenewal);
	}

	@Override
	public int submitIssueRenewal(String proposalfrmid) {
		return issueRenewalDao.submitIssueRenewal(proposalfrmid);
	}
	
	public List<Button> getListOfButton()
	{
		return issueRenewalDao.buttonList();
	}

	
	
}
