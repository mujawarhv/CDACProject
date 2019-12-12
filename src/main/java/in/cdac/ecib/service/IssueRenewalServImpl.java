package in.cdac.ecib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.ecib.dao.IssueRenewalDao;
import in.cdac.ecib.dao.IssueRenewalImpl;
import in.cdac.ecib.dto.IssueRenewal;

@Service
public class IssueRenewalServImpl implements IssueRenewalServ {
	
	@Autowired
	IssueRenewalDao issueRenewalDao;

	@Override
	public void Create(IssueRenewal issueRenewal) {
		issueRenewalDao.Save(issueRenewal);		
	}

	@Override
	public int Modify(String id,IssueRenewal issueRenewal) {
		return issueRenewalDao.Update(id, issueRenewal);		
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
	public List<IssueRenewal> getlistOfPreliminaryScrutinyDone() {
		return issueRenewalDao.getlistOfPreliminaryScrutinyDone();
	}

	@Override
	public void createOfficeNote() {
		 issueRenewalDao.createOfficeNote();		
	}
	
}
