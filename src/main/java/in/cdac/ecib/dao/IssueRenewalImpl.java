package in.cdac.ecib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.cdac.ecib.dto.IssueRenewal;

@Repository
public class IssueRenewalImpl implements IssueRenewalDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * This method is for insertion of data in database when IssueRenewal Form is
	 * filled up
	 */

	@Override
	public void Save(IssueRenewal issueRenewal) {

		String str = "insert into wt_isrn_proposal_frm(wt_isrn_proposal_frm_id,annex_statement_of_packing_attached, " + 
				"	annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, " + 
				"	annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, " + 
				"	annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, " + 
				"	annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached," + 
				"	annex_for_exporter_financial_statement_analysis_attached,ecgc_branch_code, bank_code,issue_renewal_flag,employee_code,bank_name,inward_id,cover_type,from_date,"
				+ "to_date,maximum_liability,no_of_limit_approved_acc,amt_of_limit_approved_acc,"
				+ "no_of_acct_default_reported,amt_of_default_reported,"
				+ "no_of_sma2_acc,amt_outstanding_of_sma2_acc, no_of_cdr_acc,amount_outstanding_cdr_accounts,"
				+ "total_outstanding_under_pc_ps,anticipated_outstanding_in_current_year,"
				+ "is_ssi_msme_covered,no_of_ssi_msme_acc_covered,amt_outstanding_for_ssi_msme,"
				+ "is_govt_company_covered,no_of_govt_companies_covered,amt_outstanding_for_govt_company,"
				+ "is_adv_against_lc_covered,no_of_acc_for_which_adv_against_lc_covered,amt_outstanding_from_adv_against_lc,"
				+ "is_obu_covered,no_of_obu_covered,amt_outstanding_for_obu,is_adv_against_bills_covered,"
				+ "no_of_acc_to_be_covrd_for_advances_against_bill_of_associate,amt_upto_which_adv_against_bill_covered,"
				+ "desired_dl_for_new_account)values('" + issueRenewal.getWt_isrn_proposal_frm_id()	+ "','true','true','true','true','true','true','true','true','true','true','1','00271','false','343521','" + issueRenewal.getBank_name() + "','2','" + issueRenewal.getCover_type()
				+ "','" + issueRenewal.getFrom_date() + "','" + issueRenewal.getTo_date() + "','"
				+ issueRenewal.getMaximum_liability() + "','" + issueRenewal.getNo_of_limit_approved_acc() + "','"
				+ issueRenewal.getAmt_of_limit_approved_acc() + "','" + issueRenewal.getNo_of_acct_default_reported()
				+ "','" + issueRenewal.getAmt_of_default_reported() + "',	'" + issueRenewal.getNo_of_sma2_acc()
				+ "','" + issueRenewal.getAmt_outstanding_of_sma2_acc() + "','" + issueRenewal.getNo_of_cdr_acc()
				+ "','" + issueRenewal.getAmount_outstanding_cdr_accounts() + "', '"
				+ issueRenewal.getTotal_outstanding_under_pc_ps() + "','"
				+ issueRenewal.getAnticipated_outstanding_in_current_year() + "','"
				+ issueRenewal.isIs_ssi_msme_covered() + "', '" + issueRenewal.getNo_of_ssi_msme_acc_covered() + "','"
				+ issueRenewal.getAmt_outstanding_for_ssi_msme() + "','" + issueRenewal.isIs_govt_company_covered()
				+ "', '" + issueRenewal.getNo_of_govt_companies_covered() + "','"
				+ issueRenewal.getAmt_outstanding_for_govt_company() + "','"
				+ issueRenewal.isIs_adv_against_lc_covered() + "','"
				+ issueRenewal.getNo_of_acc_for_which_adv_against_lc_covered() + "','"
				+ issueRenewal.getAmt_outstanding_from_adv_against_lc() + "', '" + issueRenewal.isIs_obu_covered()
				+ "','" + issueRenewal.getNo_of_obu_covered() + "','" + issueRenewal.getAmt_outstanding_for_obu()
				+ "', '" + issueRenewal.isIs_adv_against_bills_covered() + "','"
				+ issueRenewal.getNo_of_acc_to_be_covrd_for_advances_against_bill_of_associate() + "','"
				+ issueRenewal.getAmt_upto_which_adv_against_bill_covered() + "','"
				+ issueRenewal.getDesired_dl_for_new_account() + "')";

		jdbcTemplate.update(str);

	}

	/*
	 * When any changes in IssueRenewal is done then after clicking on update button
	 * Modify method of service will call to this method and updation will be done
	 */

	@Override
	public int Update(String id, IssueRenewal issueRenewal) {
		String sql = "UPDATE wt_isrn_proposal_frm SET bank_name='" + issueRenewal.getBank_name() + "',cover_type='"
				+ issueRenewal.getCover_type() + "',is_ssi_msme_covered='" + issueRenewal.isIs_ssi_msme_covered()
				+ "',is_govt_company_covered='" + issueRenewal.isIs_govt_company_covered() + "', is_obu_covered='"
				+ issueRenewal.isIs_obu_covered() + "', is_adv_against_lc_covered='"
				+ issueRenewal.isIs_adv_against_lc_covered() + "', is_adv_against_bills_covered='"
				+ issueRenewal.isIs_adv_against_bills_covered() + "', no_of_limit_approved_acc='"
				+ issueRenewal.getNo_of_limit_approved_acc() + "',no_of_acct_default_reported='"
				+ issueRenewal.getNo_of_acct_default_reported() + "', no_of_sma2_acc='"
				+ issueRenewal.getNo_of_sma2_acc() + "', no_of_cdr_acc='" + issueRenewal.getNo_of_cdr_acc()
				+ "', no_of_ssi_msme_acc_covered='" + issueRenewal.getNo_of_ssi_msme_acc_covered()
				+ "', no_of_govt_companies_covered='" + issueRenewal.getNo_of_govt_companies_covered()
				+ "', no_of_obu_covered='" + issueRenewal.getNo_of_obu_covered()
				+ "', no_of_acc_for_which_adv_against_lc_covered='"
				+ issueRenewal.getNo_of_acc_for_which_adv_against_lc_covered()
				+ "', no_of_acc_to_be_covrd_for_advances_against_bill_of_associate='"
				+ issueRenewal.getNo_of_acc_to_be_covrd_for_advances_against_bill_of_associate() + "', from_date='"
				+ issueRenewal.getFrom_date() + "', to_date='" + issueRenewal.getTo_date() + "', maximum_liability='"
				+ issueRenewal.getMaximum_liability() + "', amt_of_limit_approved_acc='"
				+ issueRenewal.getAmt_of_limit_approved_acc() + "', amt_of_default_reported='"
				+ issueRenewal.getAmt_of_default_reported() + "', amt_outstanding_of_sma2_acc='"
				+ issueRenewal.getAmt_outstanding_of_sma2_acc() + "',amount_outstanding_cdr_accounts='"
				+ issueRenewal.getAmount_outstanding_cdr_accounts() + "', total_outstanding_under_pc_ps='"
				+ issueRenewal.getTotal_outstanding_under_pc_ps() + "',anticipated_outstanding_in_current_year='"
				+ issueRenewal.getAnticipated_outstanding_in_current_year() + "', amt_outstanding_for_ssi_msme='"
				+ issueRenewal.getAmt_outstanding_for_ssi_msme() + "', amt_outstanding_for_govt_company='"
				+ issueRenewal.getAmt_outstanding_for_govt_company() + "', amt_outstanding_for_obu='"
				+ issueRenewal.getAmt_outstanding_for_obu() + "', amt_outstanding_from_adv_against_lc='"
				+ issueRenewal.getAmt_outstanding_from_adv_against_lc() + "',amt_upto_which_adv_against_bill_covered='"
				+ issueRenewal.getAmt_upto_which_adv_against_bill_covered() + "', desired_dl_for_new_account='"
				+ issueRenewal.getDesired_dl_for_new_account() + "', WHERE wt_isrn_proposal_frm_id=?" + issueRenewal.getWt_isrn_proposal_frm_id();

		return jdbcTemplate.update(sql);

	}

	@Override
	public List<IssueRenewal> userList() {
		List<IssueRenewal> list = jdbcTemplate.query(
				"SELECT * FROM wt_isrn_proposal_frm where issue_renewal_flag=false  order by wt_isrn_proposal_frm_id", new RowMapper<IssueRenewal>() {
					@Override
					public IssueRenewal mapRow(ResultSet rs, int rowNum) throws SQLException {
						IssueRenewal issueRenewal = new IssueRenewal();
						issueRenewal.setWt_isrn_proposal_frm_id(rs.getString("wt_isrn_proposal_frm_id"));
						issueRenewal.setBank_name(rs.getString("bank_name"));
						issueRenewal.setCover_type(rs.getString("cover_type"));
						return issueRenewal;
					}
				});
		return list;
	}

	@Override
	public IssueRenewal selectUsers(String proposalfrmid) {
		String sql = "select * from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=? ";
		IssueRenewal issueRenewal = jdbcTemplate.queryForObject(sql, new Object[] { proposalfrmid },
				new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class));
		return issueRenewal;
	}

	@Override
	public IssueRenewal getbyDocuments(String proposal_frm_id) {
		IssueRenewal issueRenewal = new IssueRenewal();
		String sql = "select annex_statement_of_packing_attached,annex_for_limit_sanction_attached,annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=? ";
		try {
			issueRenewal = jdbcTemplate.queryForObject(sql, new Object[] { proposal_frm_id },
					new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class));
		} catch (Exception e) {
			issueRenewal = null;
		}
		return issueRenewal;
	}

	@Override
	public IssueRenewal openOfficeNotePC(IssueRenewal issueRenewal) {
//		String sql = "select t1.inward_number, t1.inward_item_number,t1.inward_date,t2.wt_isrn_proposal_frm_id,"
//				+ "t2.ecgc_branch_code,t2.inward_id,t2.bank_code,t2.no_of_govt_companies_covered,t2.amt_outstanding_for_govt_company,t2.amt_outstanding_for_obu,t2.no_of_obu_covered,"
//				+ "t2.annex_statement_of_packing_attached,t2.annex_for_limit_sanction_attached,t2.annex_of_cdr_acc_attached ,t2.bank_name from i_o t1 "
//				+ "inner join wt_isrn_proposal_frm t2 on t1.inward_id = t2.inward_id where wt_isrn_proposal_frm_id=?";
	
		String sql = "select * from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=?";
		IssueRenewal issueRenewal1 = jdbcTemplate.queryForObject(sql,
				new Object[] { issueRenewal.getWt_isrn_proposal_frm_id() },
				new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class));
		return issueRenewal1;
	}
	

	@Override
	public boolean isValidOfficeNoteId(String Wt_isrn_proposal_frm_id) {

		String sql = "SELECT wt_isrn_proposal_frm_id FROM wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=?";
		try {
			jdbcTemplate.queryForObject(sql, new Object[] {Wt_isrn_proposal_frm_id},
					new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public IssueRenewal openOfficeNotePS(IssueRenewal issueRenewal) {
		String sql = "select wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability, amt_of_limit_approved_acc, amt_of_default_reported, amt_outstanding_of_sma2_acc, amount_outstanding_cdr_accounts, total_outstanding_under_pc_ps, anticipated_outstanding_in_current_year, amt_outstanding_for_ssi_msme, amt_outstanding_for_govt_company, amt_outstanding_for_obu, amt_outstanding_from_adv_against_lc, amt_upto_which_adv_against_bill_covered, desired_dl_for_new_account from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=?";
		IssueRenewal issueRenewal1 = jdbcTemplate.queryForObject(sql,
				new Object[] { issueRenewal.getWt_isrn_proposal_frm_id() },
				new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class));
		return issueRenewal1;
	}

	@Override
	public void insertSystemEntryPS(IssueRenewal issueRenewal) {
		String sql = "insert into wt_isrn(wt_isrn_id, wt_isrn_proposal_frm_id,employee_code,maximum_liability) values "
				+ "('1','"+issueRenewal.getWt_isrn_proposal_frm_id()+"','"+issueRenewal.getEmployee_code()+"','"+issueRenewal.getMaximum_liability()+"')";
		jdbcTemplate.update(sql);
	}


	@Override
	public IssueRenewal getONInfo(String wt_isrn_proposal_frm_id) {
		IssueRenewal issueRenewal;
		String sql = "select * from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=? ";
		try {
			issueRenewal = jdbcTemplate.queryForObject(sql, new Object[] { wt_isrn_proposal_frm_id },
					new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class));
		} catch (Exception e) {
			issueRenewal = null;
		}
		return issueRenewal;
	}

	@Override
	public int prelimiaryScrutinyCompleted(String wt_isrn_proposal_frm_id) {
		String sql = "UPDATE wt_isrn_proposal_frm SET issue_renewal_flag=true WHERE wt_isrn_proposal_frm_id='"+ wt_isrn_proposal_frm_id+"'";
		return jdbcTemplate.update(sql);
	}
	
	@Override
	public List<IssueRenewal> getlistOfPreliminaryScrutinyDone() {
		List<IssueRenewal> list = jdbcTemplate.query(
				"SELECT * FROM wt_isrn_proposal_frm where issue_renewal_flag=true  order by wt_isrn_proposal_frm_id", new RowMapper<IssueRenewal>() {
					@Override
					public IssueRenewal mapRow(ResultSet rs, int rowNum) throws SQLException {
						IssueRenewal issueRenewal = new IssueRenewal();
						issueRenewal.setWt_isrn_proposal_frm_id(rs.getString("wt_isrn_proposal_frm_id"));
						issueRenewal.setBank_name(rs.getString("bank_name"));
						issueRenewal.setCover_type(rs.getString("cover_type"));
						return issueRenewal;
					}
				});
		return list;
	}

	@Override
	public Object createOfficeNote() {
		// TODO Auto-generated method stub
		return null;
	}

}
