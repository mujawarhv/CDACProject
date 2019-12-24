package com.cdac.ecib.util;

import in.cdac.ecib.dto.IssueRenewal;

public interface IssueRenewalQueries {
	
	
	public static final IssueRenewal issueRenewal = new IssueRenewal();
	
	String INSERT_INTO_EMPLOYEES = "insert into wt_isrn_proposal_frm(wt_isrn_proposal_frm_id,annex_statement_of_packing_attached, "
			+ "	annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, "
			+ "	annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, "
			+ "	annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, "
			+ "	annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached,"
			+ "	annex_for_exporter_financial_statement_analysis_attached,ecgc_branch_code, bank_code,issue_renewal_flag,employee_code,bank_name,inward_id,cover_type,from_date,"
			+ "to_date,maximum_liability,no_of_limit_approved_acc,amt_of_limit_approved_acc,"
			+ "no_of_acct_default_reported,amt_of_default_reported,"
			+ "no_of_sma2_acc,amt_outstanding_of_sma2_acc, no_of_cdr_acc,amount_outstanding_cdr_accounts,"
			+ "total_outstanding_under_pc_ps,anticipated_outstanding_in_current_year,"
			+ "is_ssi_msme_covered,no_of_ssi_msme_acc_covered,amt_outstanding_for_ssi_msme,"
			+ "is_govt_company_covered,no_of_govt_companies_covered,amt_outstanding_for_govt_company,"
			+ "is_adv_against_lc_covered,no_of_acc_for_which_adv_against_lc_covered,amt_outstanding_from_adv_against_lc,"
			+ "is_obu_covered,no_of_obu_covered,amt_outstanding_for_obu,is_adv_against_bills_covered,"
			+ "no_of_acc_to_be_covrd_for_advances_against_bill_of_associate,amt_upto_which_adv_against_bill_covered,"
			+ "desired_dl_for_new_account)values('" + issueRenewal.getWt_isrn_proposal_frm_id()
			+ "','true','true','true','true','true','true','true','true','true','true','1','00271','false','343521','"
			+ issueRenewal.getBank_name() + "','2','" + issueRenewal.getCover_type() + "','"
			+ issueRenewal.getFrom_date() + "','" + issueRenewal.getTo_date() + "','"
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
	
	String SELECT_PARTICULAR_ISSUERENEWAL_FORM = "select * from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=? ";
	
	String SELECT_PARTICULAR_ANNEXURE_BY_ISRN_ID = "select annex_statement_of_packing_attached,annex_for_limit_sanction_attached,annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=? ";
	
	String OFFICENOTE_PC_DATA = "select * from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=?";
	
	String ISVALID_OFFICENOTE_ID = "SELECT wt_isrn_proposal_frm_id FROM wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=?";

	String OFFICENOTE_PS_DATA = "select wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability, amt_of_limit_approved_acc, amt_of_default_reported, amt_outstanding_of_sma2_acc, amount_outstanding_cdr_accounts, total_outstanding_under_pc_ps, anticipated_outstanding_in_current_year, amt_outstanding_for_ssi_msme, amt_outstanding_for_govt_company, amt_outstanding_for_obu, amt_outstanding_from_adv_against_lc, amt_upto_which_adv_against_bill_covered, desired_dl_for_new_account from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=?";

	String GET_OFFICENOTE_INFO = "select * from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=? ";

	String LIST_OF_PRELIMINARY_SCRUTINY_DONE ="SELECT wt_isrn_proposal_frm_id FROM wt_isrn_proposal_frm where issue_renewal_flag=true and wt_isrn_proposal_frm_id not in(SELECT wt_isrn_proposal_frm_id from wt_isrn where wt_isrn_id  in(select wt_isrn_id from wt_isrn_office_note))";

	String USER_LOGIN = "SELECT user_id, user_password FROM login WHERE user_id=?";
	
	String LIST_OF_OFFICENOTE_DONE ="SELECT wt_isrn_proposal_frm_id FROM wt_isrn WHERE wt_isrn_id IN (select wt_isrn_id from wt_isrn_office_note)";
	
	String SELECT_MAX_OFFICENOTE_ID ="SELECT wt_isrn_office_note_id FROM wt_isrn_office_note WHERE wt_isrn_office_note_id = (SELECT MAX(wt_isrn_office_note_id ) FROM wt_isrn_office_note)";


}
