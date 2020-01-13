package in.cdac.ecib.util;

public interface IssueRenewalQueries {
	
	public static String INSERT_ISSUERENEWAL_RECORD = "INSERT INTO wt_isrn_proposal_frm(wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability, amt_of_limit_approved_acc, amt_of_default_reported, amt_outstanding_of_sma2_acc, amount_outstanding_cdr_accounts, total_outstanding_under_pc_ps, anticipated_outstanding_in_current_year, amt_outstanding_for_ssi_msme, amt_outstanding_for_govt_company, amt_outstanding_for_obu, amt_outstanding_from_adv_against_lc, amt_upto_which_adv_against_bill_covered, desired_dl_for_new_account)VALUES (:Wt_isrn_proposal_frm_id,:ecgc_branch_code,:bank_code,:employee_code,:bank_name,:inward_id,:cover_type,:form_status,:bank_employee_name,:bank_ecgc_designation,:bank_address,:issue_renewal_flag,:is_ssi_msme_covered,:is_govt_company_covered,:is_adv_against_lc_covered,:is_obu_covered,:is_adv_against_bills_covered,:annex_statement_of_packing_attached,:annex_for_limit_sanction_attached,:annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd,:annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd,:annex_of_cdr_acc_attached,:annex_of_shipment_export_credit_limit_sanctioned_attached,:annex_of_annual_statement_of_acc_in_default_attached,:annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid,:annex_of_annual_statment_of_acc_in_default_attached,:annex_for_exporter_financial_statement_analysis_attached,:no_of_limit_approved_acc,:no_of_acct_default_reported,:no_of_sma2_acc,:no_of_cdr_acc,:no_of_ssi_msme_acc_covered,:no_of_govt_companies_covered,:no_of_obu_covered,:no_of_acc_for_which_adv_against_lc_covered,:no_of_acc_to_be_covrd_for_advances_against_bill_of_associate,:from_date,:to_date,:submission_date,:last_trans_date,:maximum_liability,:amt_of_default_reported,:amt_outstanding_of_sma2_acc,:amount_outstanding_cdr_accounts,:amt_of_limit_approved_acc,:total_outstanding_under_pc_ps,:amt_outstanding_for_ssi_msme,:amt_outstanding_for_govt_company,:amt_outstanding_for_obu,:anticipated_outstanding_in_current_year,:amt_outstanding_from_adv_against_lc,:amt_upto_which_adv_against_bill_covered,:desired_dl_for_new_account)";
	
	public static String GET_WT_ISRN_PROPOSAL_FORM_ID= "select wt_isrn_proposal_frm_id from wt_isrn_proposal_frm;";
	
	public static String UPDATE_ISSUERENEWAL_FORM="	UPDATE wt_isrn_proposal_frm set ecgc_branch_code=:ecgc_branch_code, bank_code=:bank_code, employee_code=:employee_code, bank_name=:bank_name, inward_id=:inward_id, cover_type=:cover_type, form_status=:form_status, bank_employee_name=:bank_employee_name, bank_ecgc_designation=:bank_ecgc_designation, bank_address=:bank_address, issue_renewal_flag=:issue_renewal_flag, is_ssi_msme_covered=:is_ssi_msme_covered, is_govt_company_covered=:is_govt_company_covered, is_obu_covered=:is_obu_covered, is_adv_against_lc_covered=:is_adv_against_lc_covered, is_adv_against_bills_covered=:is_adv_against_bills_covered, annex_statement_of_packing_attached=:annex_statement_of_packing_attached, annex_for_limit_sanction_attached=:annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd=:annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd=:annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached=:annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached=:annex_of_shipment_export_credit_limit_sanctioned_attached,annex_of_annual_statement_of_acc_in_default_attached=:annex_of_annual_statement_of_acc_in_default_attached,annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid=:annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid,annex_of_annual_statment_of_acc_in_default_attached=:annex_of_annual_statment_of_acc_in_default_attached,annex_for_exporter_financial_statement_analysis_attached=:annex_for_exporter_financial_statement_analysis_attached,no_of_limit_approved_acc=:no_of_limit_approved_acc, no_of_acct_default_reported=:no_of_acct_default_reported,no_of_sma2_acc=:no_of_sma2_acc, no_of_cdr_acc=:no_of_cdr_acc, no_of_ssi_msme_acc_covered=:no_of_ssi_msme_acc_covered,no_of_govt_companies_covered=:no_of_govt_companies_covered, no_of_obu_covered=:no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered=:no_of_acc_for_which_adv_against_lc_covered,no_of_acc_to_be_covrd_for_advances_against_bill_of_associate=:no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date=:from_date, to_date=:to_date,submission_date=:submission_date, last_trans_date=:last_trans_date, maximum_liability=:maximum_liability, amt_of_limit_approved_acc=:amt_of_limit_approved_acc,amt_of_default_reported=:amt_of_default_reported, amt_outstanding_of_sma2_acc=:amt_outstanding_of_sma2_acc, amount_outstanding_cdr_accounts=:amount_outstanding_cdr_accounts,total_outstanding_under_pc_ps=:total_outstanding_under_pc_ps, anticipated_outstanding_in_current_year=:anticipated_outstanding_in_current_year, amt_outstanding_for_ssi_msme=:amt_outstanding_for_ssi_msme, amt_outstanding_for_govt_company=:amt_outstanding_for_govt_company, amt_outstanding_for_obu=:amt_outstanding_for_obu, amt_outstanding_from_adv_against_lc=:amt_outstanding_from_adv_against_lc, amt_upto_which_adv_against_bill_covered=:amt_upto_which_adv_against_bill_covered, desired_dl_for_new_account=:desired_dl_for_new_account where wt_isrn_proposal_frm_id=:Wt_isrn_proposal_frm_id";

	public static String GET_ISSUERENEWAL_BY_ID = "SELECT wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability::numeric, amt_of_limit_approved_acc::numeric::numeric, amt_of_default_reported::numeric, amt_outstanding_of_sma2_acc::numeric, amount_outstanding_cdr_accounts::numeric, total_outstanding_under_pc_ps::numeric, anticipated_outstanding_in_current_year::numeric, amt_outstanding_for_ssi_msme::numeric, amt_outstanding_for_govt_company::numeric, amt_outstanding_for_obu::numeric::numeric, amt_outstanding_from_adv_against_lc::numeric, amt_upto_which_adv_against_bill_covered::numeric, desired_dl_for_new_account::numeric FROM wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id ";
	
	public static String GET_ISSUERENEWAL_ANNEXURE_BY_ID = "select annex_statement_of_packing_attached,annex_for_limit_sanction_attached,annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id ";

}
