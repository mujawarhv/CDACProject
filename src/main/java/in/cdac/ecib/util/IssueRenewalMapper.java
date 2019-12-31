package in.cdac.ecib.util;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import in.cdac.ecib.dto.*;

public class IssueRenewalMapper implements RowMapper<IssueRenewal>{

	@Override
	public IssueRenewal mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		IssueRenewal issueRenewal = new IssueRenewal();
		issueRenewal.setWt_isrn_proposal_frm_id(rs.getString("wt_isrn_proposal_frm_id"));
		issueRenewal.setEcgc_branch_code(rs.getString("ecgc_branch_code"));
		issueRenewal.setBank_code(rs.getString("bank_code"));
		issueRenewal.setEmployee_code(rs.getString("employee_code"));
		issueRenewal.setBank_name(rs.getString("bank_name"));
		issueRenewal.setInward_id(rs.getString("inward_id"));
		issueRenewal.setCover_type(rs.getString("cover_type"));
		issueRenewal.setForm_status(rs.getString("form_status"));
		issueRenewal.setBank_employee_name(rs.getString("bank_employee_name"));
		issueRenewal.setBank_ecgc_designation(rs.getString("bank_ecgc_designation"));
		issueRenewal.setBank_address(rs.getString("bank_address"));
		
		issueRenewal.setIssue_renewal_flag(rs.getBoolean("issue_renewal_flag"));
		issueRenewal.setIs_ssi_msme_covered(rs.getBoolean("is_ssi_msme_covered"));
		issueRenewal.setIs_govt_company_covered(rs.getBoolean("is_govt_company_covered"));
		issueRenewal.setIs_adv_against_lc_covered(rs.getBoolean("is_adv_against_lc_covered"));
		issueRenewal.setIs_obu_covered(rs.getBoolean("is_obu_covered"));
		issueRenewal.setIs_adv_against_bills_covered(rs.getBoolean("is_adv_against_bills_covered"));
		issueRenewal.setAnnex_statement_of_packing_attached(rs.getBoolean("annex_statement_of_packing_attached"));
		issueRenewal.setAnnex_for_limit_sanction_attached(rs.getBoolean("annex_for_limit_sanction_attached"));
		issueRenewal.setAnnex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd(rs.getBoolean("annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd"));
		issueRenewal.setAnnex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd(rs.getBoolean("annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd"));
		issueRenewal.setAnnex_of_cdr_acc_attached(rs.getBoolean("annex_of_cdr_acc_attached"));
		issueRenewal.setAnnex_of_shipment_export_credit_limit_sanctioned_attached(rs.getBoolean("annex_of_shipment_export_credit_limit_sanctioned_attached"));
		issueRenewal.setAnnex_of_annual_statement_of_acc_in_default_attached(rs.getBoolean("annex_of_annual_statement_of_acc_in_default_attached"));
		issueRenewal.setAnnex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid(rs.getBoolean("annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid"));
		issueRenewal.setAnnex_of_annual_statment_of_acc_in_default_attached(rs.getBoolean("annex_of_annual_statment_of_acc_in_default_attached"));
		issueRenewal.setAnnex_for_exporter_financial_statement_analysis_attached(rs.getBoolean("annex_for_exporter_financial_statement_analysis_attached"));
		issueRenewal.setNo_of_limit_approved_acc(rs.getInt("no_of_limit_approved_acc"));
		issueRenewal.setNo_of_acct_default_reported(rs.getInt("no_of_acct_default_reported"));
		issueRenewal.setNo_of_sma2_acc(rs.getInt("no_of_sma2_acc"));
		issueRenewal.setNo_of_cdr_acc(rs.getInt("no_of_cdr_acc"));
		issueRenewal.setNo_of_ssi_msme_acc_covered(rs.getInt("no_of_ssi_msme_acc_covered"));
		issueRenewal.setNo_of_govt_companies_covered(rs.getInt("no_of_govt_companies_covered"));
		issueRenewal.setNo_of_obu_covered(rs.getInt("no_of_obu_covered"));
		issueRenewal.setNo_of_acc_for_which_adv_against_lc_covered(rs.getInt("no_of_acc_for_which_adv_against_lc_covered"));
		issueRenewal.setNo_of_acc_to_be_covrd_for_advances_against_bill_of_associate(rs.getInt("no_of_acc_to_be_covrd_for_advances_against_bill_of_associate"));
		
		issueRenewal.setFrom_date(rs.getDate("from_date"));
		issueRenewal.setTo_date(rs.getDate("to_date"));
		issueRenewal.setSubmission_date(rs.getDate("submission_date"));
		issueRenewal.setLast_trans_date(rs.getDate("last_trans_date"));
		
		issueRenewal.setMaximum_liability(rs.getString("maximum_liability"));
		issueRenewal.setAmt_of_default_reported(rs.getString("amt_of_default_reported"));
		issueRenewal.setAmt_outstanding_of_sma2_acc(rs.getString("amt_outstanding_of_sma2_acc"));
		issueRenewal.setAmount_outstanding_cdr_accounts(rs.getString("amount_outstanding_cdr_accounts"));
		issueRenewal.setAmt_of_limit_approved_acc(rs.getString("amt_of_limit_approved_acc"));
		issueRenewal.setTotal_outstanding_under_pc_ps(rs.getString("total_outstanding_under_pc_ps"));
		issueRenewal.setAmt_outstanding_for_ssi_msme(rs.getString("amt_outstanding_for_ssi_msme"));
		issueRenewal.setAmt_outstanding_for_govt_company(rs.getString("amt_outstanding_for_govt_company"));
		issueRenewal.setAmt_outstanding_for_obu(rs.getString("amt_outstanding_for_obu"));
		issueRenewal.setAnticipated_outstanding_in_current_year(rs.getString("anticipated_outstanding_in_current_year"));
		issueRenewal.setAmt_outstanding_from_adv_against_lc(rs.getString("amt_outstanding_from_adv_against_lc"));
		issueRenewal.setAmt_upto_which_adv_against_bill_covered(rs.getString("amt_upto_which_adv_against_bill_covered"));
		issueRenewal.setDesired_dl_for_new_account(rs.getString("desired_dl_for_new_account"));
		
		return issueRenewal;
	}

}
