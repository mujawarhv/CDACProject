package in.cdac.ecib.dto;


import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class IssueRenewal {

	@NotEmpty(message = "isrn_proposal_frm_id cannot be empty")
	private String wt_isrn_proposal_frm_id;
	private String ecgc_branch_code;
	private String bank_code;
	private String employee_code;
	private String bank_name;
	private String inward_id;
	private String cover_type;
	private String form_status;
	private String bank_employee_name;
	private String bank_ecgc_designation;
	private String bank_address;
	
	private boolean issue_renewal_flag;
	private boolean is_ssi_msme_covered;
	private boolean is_govt_company_covered;
	private boolean is_adv_against_lc_covered;
	private boolean is_obu_covered;
	private boolean is_adv_against_bills_covered;
	
	private boolean annex_statement_of_packing_attached;
	private boolean annex_for_limit_sanction_attached;
	private boolean annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd;
	private boolean annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd;
	private boolean annex_of_cdr_acc_attached;
	private boolean annex_of_shipment_export_credit_limit_sanctioned_attached;
	private boolean annex_of_annual_statement_of_acc_in_default_attached;
	private boolean annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid;
	private boolean annex_of_annual_statment_of_acc_in_default_attached;
	private boolean annex_for_exporter_financial_statement_analysis_attached;
	
	private Integer no_of_limit_approved_acc;
	private Integer no_of_acct_default_reported;
	private Integer no_of_sma2_acc;
	private Integer no_of_cdr_acc;
	private Integer no_of_ssi_msme_acc_covered;
	private Integer no_of_govt_companies_covered;
	private Integer no_of_obu_covered;
	private Integer no_of_acc_for_which_adv_against_lc_covered;
	private Integer no_of_acc_to_be_covrd_for_advances_against_bill_of_associate;
	
	private Date from_date;
	private Date to_date;
	private Date submission_date;
	private Date last_trans_date;
	
	private String maximum_liability;
	private String amt_of_default_reported;
	private String amt_outstanding_of_sma2_acc;
	private String amount_outstanding_cdr_accounts;
	private String amt_of_limit_approved_acc;	
	private String total_outstanding_under_pc_ps;
	private String amt_outstanding_for_ssi_msme;
	private String amt_outstanding_for_govt_company;
	private String amt_outstanding_for_obu;
	private String anticipated_outstanding_in_current_year;
	private String amt_outstanding_from_adv_against_lc;
	private String amt_upto_which_adv_against_bill_covered;
	private String desired_dl_for_new_account;

	public IssueRenewal() {
		super();
		
	}

	

	public IssueRenewal(String wt_isrn_proposal_frm_id, String ecgc_branch_code, String bank_code, String employee_code,
			String bank_name, String inward_id, String cover_type, String form_status, String bank_employee_name,
			String bank_ecgc_designation, String bank_address, boolean issue_renewal_flag, boolean is_ssi_msme_covered,
			boolean is_govt_company_covered, boolean is_adv_against_lc_covered, boolean is_obu_covered,
			boolean is_adv_against_bills_covered, boolean annex_statement_of_packing_attached,
			boolean annex_for_limit_sanction_attached,
			boolean annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd,
			boolean annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, boolean annex_of_cdr_acc_attached,
			boolean annex_of_shipment_export_credit_limit_sanctioned_attached,
			boolean annex_of_annual_statement_of_acc_in_default_attached,
			boolean annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid,
			boolean annex_of_annual_statment_of_acc_in_default_attached,
			boolean annex_for_exporter_financial_statement_analysis_attached, int no_of_limit_approved_acc,
			int no_of_acct_default_reported, int no_of_sma2_acc, int no_of_cdr_acc, int no_of_ssi_msme_acc_covered,
			int no_of_govt_companies_covered, int no_of_obu_covered, int no_of_acc_for_which_adv_against_lc_covered,
			int no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, Date from_date, Date to_date,
			Date submission_date, Date last_trans_date, String maximum_liability, String amt_of_default_reported,
			String amt_outstanding_of_sma2_acc, String amount_outstanding_cdr_accounts,
			String amt_of_limit_approved_acc, String total_outstanding_under_pc_ps, String amt_outstanding_for_ssi_msme,
			String amt_outstanding_for_govt_company, String amt_outstanding_for_obu,
			String anticipated_outstanding_in_current_year, String amt_outstanding_from_adv_against_lc,
			String amt_upto_which_adv_against_bill_covered, String desired_dl_for_new_account) {
		super();
		this.wt_isrn_proposal_frm_id = wt_isrn_proposal_frm_id;
		this.ecgc_branch_code = ecgc_branch_code;
		this.bank_code = bank_code;
		this.employee_code = employee_code;
		this.bank_name = bank_name;
		this.inward_id = inward_id;
		this.cover_type = cover_type;
		this.form_status = form_status;
		this.bank_employee_name = bank_employee_name;
		this.bank_ecgc_designation = bank_ecgc_designation;
		this.bank_address = bank_address;
		this.issue_renewal_flag = issue_renewal_flag;
		this.is_ssi_msme_covered = is_ssi_msme_covered;
		this.is_govt_company_covered = is_govt_company_covered;
		this.is_adv_against_lc_covered = is_adv_against_lc_covered;
		this.is_obu_covered = is_obu_covered;
		this.is_adv_against_bills_covered = is_adv_against_bills_covered;
		this.annex_statement_of_packing_attached = annex_statement_of_packing_attached;
		this.annex_for_limit_sanction_attached = annex_for_limit_sanction_attached;
		this.annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd = annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd;
		this.annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd = annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd;
		this.annex_of_cdr_acc_attached = annex_of_cdr_acc_attached;
		this.annex_of_shipment_export_credit_limit_sanctioned_attached = annex_of_shipment_export_credit_limit_sanctioned_attached;
		this.annex_of_annual_statement_of_acc_in_default_attached = annex_of_annual_statement_of_acc_in_default_attached;
		this.annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid = annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid;
		this.annex_of_annual_statment_of_acc_in_default_attached = annex_of_annual_statment_of_acc_in_default_attached;
		this.annex_for_exporter_financial_statement_analysis_attached = annex_for_exporter_financial_statement_analysis_attached;
		this.no_of_limit_approved_acc = no_of_limit_approved_acc;
		this.no_of_acct_default_reported = no_of_acct_default_reported;
		this.no_of_sma2_acc = no_of_sma2_acc;
		this.no_of_cdr_acc = no_of_cdr_acc;
		this.no_of_ssi_msme_acc_covered = no_of_ssi_msme_acc_covered;
		this.no_of_govt_companies_covered = no_of_govt_companies_covered;
		this.no_of_obu_covered = no_of_obu_covered;
		this.no_of_acc_for_which_adv_against_lc_covered = no_of_acc_for_which_adv_against_lc_covered;
		this.no_of_acc_to_be_covrd_for_advances_against_bill_of_associate = no_of_acc_to_be_covrd_for_advances_against_bill_of_associate;
		this.from_date = from_date;
		this.to_date = to_date;
		this.submission_date = submission_date;
		this.last_trans_date = last_trans_date;
		this.maximum_liability = maximum_liability;
		this.amt_of_default_reported = amt_of_default_reported;
		this.amt_outstanding_of_sma2_acc = amt_outstanding_of_sma2_acc;
		this.amount_outstanding_cdr_accounts = amount_outstanding_cdr_accounts;
		this.amt_of_limit_approved_acc = amt_of_limit_approved_acc;
		this.total_outstanding_under_pc_ps = total_outstanding_under_pc_ps;
		this.amt_outstanding_for_ssi_msme = amt_outstanding_for_ssi_msme;
		this.amt_outstanding_for_govt_company = amt_outstanding_for_govt_company;
		this.amt_outstanding_for_obu = amt_outstanding_for_obu;
		this.anticipated_outstanding_in_current_year = anticipated_outstanding_in_current_year;
		this.amt_outstanding_from_adv_against_lc = amt_outstanding_from_adv_against_lc;
		this.amt_upto_which_adv_against_bill_covered = amt_upto_which_adv_against_bill_covered;
		this.desired_dl_for_new_account = desired_dl_for_new_account;
	}



	public IssueRenewal(String ecgc_branch_code, String bank_code, String employee_code, String bank_name,
			String inward_id, String cover_type, String form_status, String bank_employee_name,
			String bank_ecgc_designation, String bank_address, boolean issue_renewal_flag, boolean is_ssi_msme_covered,
			boolean is_govt_company_covered, boolean is_adv_against_lc_covered, boolean is_obu_covered,
			boolean is_adv_against_bills_covered, boolean annex_statement_of_packing_attached,
			boolean annex_for_limit_sanction_attached,
			boolean annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd,
			boolean annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, boolean annex_of_cdr_acc_attached,
			boolean annex_of_shipment_export_credit_limit_sanctioned_attached,
			boolean annex_of_annual_statement_of_acc_in_default_attached,
			boolean annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid,
			boolean annex_of_annual_statment_of_acc_in_default_attached,
			boolean annex_for_exporter_financial_statement_analysis_attached, int no_of_limit_approved_acc,
			int no_of_acct_default_reported, int no_of_sma2_acc, int no_of_cdr_acc, int no_of_ssi_msme_acc_covered,
			int no_of_govt_companies_covered, int no_of_obu_covered, int no_of_acc_for_which_adv_against_lc_covered,
			int no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, Date from_date, Date to_date,
			Date submission_date, Date last_trans_date, String maximum_liability, String amt_of_default_reported,
			String amt_outstanding_of_sma2_acc, String amount_outstanding_cdr_accounts,
			String amt_of_limit_approved_acc, String total_outstanding_under_pc_ps, String amt_outstanding_for_ssi_msme,
			String amt_outstanding_for_govt_company, String amt_outstanding_for_obu,
			String anticipated_outstanding_in_current_year, String amt_outstanding_from_adv_against_lc,
			String amt_upto_which_adv_against_bill_covered, String desired_dl_for_new_account) {
		super();
		this.ecgc_branch_code = ecgc_branch_code;
		this.bank_code = bank_code;
		this.employee_code = employee_code;
		this.bank_name = bank_name;
		this.inward_id = inward_id;
		this.cover_type = cover_type;
		this.form_status = form_status;
		this.bank_employee_name = bank_employee_name;
		this.bank_ecgc_designation = bank_ecgc_designation;
		this.bank_address = bank_address;
		this.issue_renewal_flag = issue_renewal_flag;
		this.is_ssi_msme_covered = is_ssi_msme_covered;
		this.is_govt_company_covered = is_govt_company_covered;
		this.is_adv_against_lc_covered = is_adv_against_lc_covered;
		this.is_obu_covered = is_obu_covered;
		this.is_adv_against_bills_covered = is_adv_against_bills_covered;
		this.annex_statement_of_packing_attached = annex_statement_of_packing_attached;
		this.annex_for_limit_sanction_attached = annex_for_limit_sanction_attached;
		this.annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd = annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd;
		this.annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd = annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd;
		this.annex_of_cdr_acc_attached = annex_of_cdr_acc_attached;
		this.annex_of_shipment_export_credit_limit_sanctioned_attached = annex_of_shipment_export_credit_limit_sanctioned_attached;
		this.annex_of_annual_statement_of_acc_in_default_attached = annex_of_annual_statement_of_acc_in_default_attached;
		this.annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid = annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid;
		this.annex_of_annual_statment_of_acc_in_default_attached = annex_of_annual_statment_of_acc_in_default_attached;
		this.annex_for_exporter_financial_statement_analysis_attached = annex_for_exporter_financial_statement_analysis_attached;
		this.no_of_limit_approved_acc = no_of_limit_approved_acc;
		this.no_of_acct_default_reported = no_of_acct_default_reported;
		this.no_of_sma2_acc = no_of_sma2_acc;
		this.no_of_cdr_acc = no_of_cdr_acc;
		this.no_of_ssi_msme_acc_covered = no_of_ssi_msme_acc_covered;
		this.no_of_govt_companies_covered = no_of_govt_companies_covered;
		this.no_of_obu_covered = no_of_obu_covered;
		this.no_of_acc_for_which_adv_against_lc_covered = no_of_acc_for_which_adv_against_lc_covered;
		this.no_of_acc_to_be_covrd_for_advances_against_bill_of_associate = no_of_acc_to_be_covrd_for_advances_against_bill_of_associate;
		this.from_date = from_date;
		this.to_date = to_date;
		this.submission_date = submission_date;
		this.last_trans_date = last_trans_date;
		this.maximum_liability = maximum_liability;
		this.amt_of_default_reported = amt_of_default_reported;
		this.amt_outstanding_of_sma2_acc = amt_outstanding_of_sma2_acc;
		this.amount_outstanding_cdr_accounts = amount_outstanding_cdr_accounts;
		this.amt_of_limit_approved_acc = amt_of_limit_approved_acc;
		this.total_outstanding_under_pc_ps = total_outstanding_under_pc_ps;
		this.amt_outstanding_for_ssi_msme = amt_outstanding_for_ssi_msme;
		this.amt_outstanding_for_govt_company = amt_outstanding_for_govt_company;
		this.amt_outstanding_for_obu = amt_outstanding_for_obu;
		this.anticipated_outstanding_in_current_year = anticipated_outstanding_in_current_year;
		this.amt_outstanding_from_adv_against_lc = amt_outstanding_from_adv_against_lc;
		this.amt_upto_which_adv_against_bill_covered = amt_upto_which_adv_against_bill_covered;
		this.desired_dl_for_new_account = desired_dl_for_new_account;
	}


	



	public String getWt_isrn_proposal_frm_id() {
		return wt_isrn_proposal_frm_id;
	}



	public void setWt_isrn_proposal_frm_id(String wt_isrn_proposal_frm_id) {
		this.wt_isrn_proposal_frm_id = wt_isrn_proposal_frm_id;
	}



	public String getEcgc_branch_code() {
		return ecgc_branch_code;
	}



	public void setEcgc_branch_code(String ecgc_branch_code) {
		this.ecgc_branch_code = ecgc_branch_code;
	}



	public String getBank_code() {
		return bank_code;
	}



	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}



	public String getEmployee_code() {
		return employee_code;
	}



	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}



	public String getBank_name() {
		return bank_name;
	}



	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}



	public String getInward_id() {
		return inward_id;
	}



	public void setInward_id(String inward_id) {
		this.inward_id = inward_id;
	}



	public String getCover_type() {
		return cover_type;
	}



	public void setCover_type(String cover_type) {
		this.cover_type = cover_type;
	}



	public String getForm_status() {
		return form_status;
	}



	public void setForm_status(String form_status) {
		this.form_status = form_status;
	}



	public String getBank_employee_name() {
		return bank_employee_name;
	}



	public void setBank_employee_name(String bank_employee_name) {
		this.bank_employee_name = bank_employee_name;
	}



	public String getBank_ecgc_designation() {
		return bank_ecgc_designation;
	}



	public void setBank_ecgc_designation(String bank_ecgc_designation) {
		this.bank_ecgc_designation = bank_ecgc_designation;
	}



	public String getBank_address() {
		return bank_address;
	}



	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}



	public boolean isIssue_renewal_flag() {
		return issue_renewal_flag;
	}



	public void setIssue_renewal_flag(boolean issue_renewal_flag) {
		this.issue_renewal_flag = issue_renewal_flag;
	}



	public boolean isIs_ssi_msme_covered() {
		return is_ssi_msme_covered;
	}



	public void setIs_ssi_msme_covered(boolean is_ssi_msme_covered) {
		this.is_ssi_msme_covered = is_ssi_msme_covered;
	}



	public boolean isIs_govt_company_covered() {
		return is_govt_company_covered;
	}



	public void setIs_govt_company_covered(boolean is_govt_company_covered) {
		this.is_govt_company_covered = is_govt_company_covered;
	}



	public boolean isIs_adv_against_lc_covered() {
		return is_adv_against_lc_covered;
	}



	public void setIs_adv_against_lc_covered(boolean is_adv_against_lc_covered) {
		this.is_adv_against_lc_covered = is_adv_against_lc_covered;
	}



	public boolean isIs_obu_covered() {
		return is_obu_covered;
	}



	public void setIs_obu_covered(boolean is_obu_covered) {
		this.is_obu_covered = is_obu_covered;
	}



	public boolean isIs_adv_against_bills_covered() {
		return is_adv_against_bills_covered;
	}



	public void setIs_adv_against_bills_covered(boolean is_adv_against_bills_covered) {
		this.is_adv_against_bills_covered = is_adv_against_bills_covered;
	}



	public boolean isAnnex_statement_of_packing_attached() {
		return annex_statement_of_packing_attached;
	}



	public void setAnnex_statement_of_packing_attached(boolean annex_statement_of_packing_attached) {
		this.annex_statement_of_packing_attached = annex_statement_of_packing_attached;
	}



	public boolean isAnnex_for_limit_sanction_attached() {
		return annex_for_limit_sanction_attached;
	}



	public void setAnnex_for_limit_sanction_attached(boolean annex_for_limit_sanction_attached) {
		this.annex_for_limit_sanction_attached = annex_for_limit_sanction_attached;
	}



	public boolean isAnnex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd() {
		return annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd;
	}



	public void setAnnex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd(
			boolean annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd) {
		this.annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd = annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd;
	}



	public boolean isAnnex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd() {
		return annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd;
	}



	public void setAnnex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd(
			boolean annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd) {
		this.annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd = annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd;
	}



	public boolean isAnnex_of_cdr_acc_attached() {
		return annex_of_cdr_acc_attached;
	}



	public void setAnnex_of_cdr_acc_attached(boolean annex_of_cdr_acc_attached) {
		this.annex_of_cdr_acc_attached = annex_of_cdr_acc_attached;
	}



	public boolean isAnnex_of_shipment_export_credit_limit_sanctioned_attached() {
		return annex_of_shipment_export_credit_limit_sanctioned_attached;
	}



	public void setAnnex_of_shipment_export_credit_limit_sanctioned_attached(
			boolean annex_of_shipment_export_credit_limit_sanctioned_attached) {
		this.annex_of_shipment_export_credit_limit_sanctioned_attached = annex_of_shipment_export_credit_limit_sanctioned_attached;
	}



	public boolean isAnnex_of_annual_statement_of_acc_in_default_attached() {
		return annex_of_annual_statement_of_acc_in_default_attached;
	}



	public void setAnnex_of_annual_statement_of_acc_in_default_attached(
			boolean annex_of_annual_statement_of_acc_in_default_attached) {
		this.annex_of_annual_statement_of_acc_in_default_attached = annex_of_annual_statement_of_acc_in_default_attached;
	}



	public boolean isAnnex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid() {
		return annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid;
	}



	public void setAnnex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid(
			boolean annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid) {
		this.annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid = annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid;
	}



	public boolean isAnnex_of_annual_statment_of_acc_in_default_attached() {
		return annex_of_annual_statment_of_acc_in_default_attached;
	}



	public void setAnnex_of_annual_statment_of_acc_in_default_attached(
			boolean annex_of_annual_statment_of_acc_in_default_attached) {
		this.annex_of_annual_statment_of_acc_in_default_attached = annex_of_annual_statment_of_acc_in_default_attached;
	}



	public boolean isAnnex_for_exporter_financial_statement_analysis_attached() {
		return annex_for_exporter_financial_statement_analysis_attached;
	}



	public void setAnnex_for_exporter_financial_statement_analysis_attached(
			boolean annex_for_exporter_financial_statement_analysis_attached) {
		this.annex_for_exporter_financial_statement_analysis_attached = annex_for_exporter_financial_statement_analysis_attached;
	}



	public Integer getNo_of_limit_approved_acc() {
		return no_of_limit_approved_acc;
	}



	public void setNo_of_limit_approved_acc(Integer no_of_limit_approved_acc) {
		this.no_of_limit_approved_acc = no_of_limit_approved_acc;
	}



	public Integer getNo_of_acct_default_reported() {
		return no_of_acct_default_reported;
	}



	public void setNo_of_acct_default_reported(Integer no_of_acct_default_reported) {
		this.no_of_acct_default_reported = no_of_acct_default_reported;
	}



	public Integer getNo_of_sma2_acc() {
		return no_of_sma2_acc;
	}



	public void setNo_of_sma2_acc(Integer no_of_sma2_acc) {
		this.no_of_sma2_acc = no_of_sma2_acc;
	}



	public Integer getNo_of_cdr_acc() {
		return no_of_cdr_acc;
	}



	public void setNo_of_cdr_acc(Integer no_of_cdr_acc) {
		this.no_of_cdr_acc = no_of_cdr_acc;
	}



	public Integer getNo_of_ssi_msme_acc_covered() {
		return no_of_ssi_msme_acc_covered;
	}



	public void setNo_of_ssi_msme_acc_covered(Integer no_of_ssi_msme_acc_covered) {
		this.no_of_ssi_msme_acc_covered = no_of_ssi_msme_acc_covered;
	}



	public Integer getNo_of_govt_companies_covered() {
		return no_of_govt_companies_covered;
	}



	public void setNo_of_govt_companies_covered(Integer no_of_govt_companies_covered) {
		this.no_of_govt_companies_covered = no_of_govt_companies_covered;
	}



	public Integer getNo_of_obu_covered() {
		return no_of_obu_covered;
	}



	public void setNo_of_obu_covered(Integer no_of_obu_covered) {
		this.no_of_obu_covered = no_of_obu_covered;
	}



	public Integer getNo_of_acc_for_which_adv_against_lc_covered() {
		return no_of_acc_for_which_adv_against_lc_covered;
	}



	public void setNo_of_acc_for_which_adv_against_lc_covered(Integer no_of_acc_for_which_adv_against_lc_covered) {
		this.no_of_acc_for_which_adv_against_lc_covered = no_of_acc_for_which_adv_against_lc_covered;
	}



	public Integer getNo_of_acc_to_be_covrd_for_advances_against_bill_of_associate() {
		return no_of_acc_to_be_covrd_for_advances_against_bill_of_associate;
	}



	public void setNo_of_acc_to_be_covrd_for_advances_against_bill_of_associate(
			Integer no_of_acc_to_be_covrd_for_advances_against_bill_of_associate) {
		this.no_of_acc_to_be_covrd_for_advances_against_bill_of_associate = no_of_acc_to_be_covrd_for_advances_against_bill_of_associate;
	}



	public Date getFrom_date() {
		return from_date;
	}



	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}



	public Date getTo_date() {
		return to_date;
	}



	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}



	public Date getSubmission_date() {
		return submission_date;
	}



	public void setSubmission_date(Date submission_date) {
		this.submission_date = submission_date;
	}



	public Date getLast_trans_date() {
		return last_trans_date;
	}



	public void setLast_trans_date(Date last_trans_date) {
		this.last_trans_date = last_trans_date;
	}



	public String getMaximum_liability() {
		return maximum_liability;
	}



	public void setMaximum_liability(String maximum_liability) {
		this.maximum_liability = maximum_liability;
	}



	public String getAmt_of_default_reported() {
		return amt_of_default_reported;
	}



	public void setAmt_of_default_reported(String amt_of_default_reported) {
		this.amt_of_default_reported = amt_of_default_reported;
	}



	public String getAmt_outstanding_of_sma2_acc() {
		return amt_outstanding_of_sma2_acc;
	}



	public void setAmt_outstanding_of_sma2_acc(String amt_outstanding_of_sma2_acc) {
		this.amt_outstanding_of_sma2_acc = amt_outstanding_of_sma2_acc;
	}



	public String getAmount_outstanding_cdr_accounts() {
		return amount_outstanding_cdr_accounts;
	}



	public void setAmount_outstanding_cdr_accounts(String amount_outstanding_cdr_accounts) {
		this.amount_outstanding_cdr_accounts = amount_outstanding_cdr_accounts;
	}



	public String getAmt_of_limit_approved_acc() {
		return amt_of_limit_approved_acc;
	}



	public void setAmt_of_limit_approved_acc(String amt_of_limit_approved_acc) {
		this.amt_of_limit_approved_acc = amt_of_limit_approved_acc;
	}



	public String getTotal_outstanding_under_pc_ps() {
		return total_outstanding_under_pc_ps;
	}



	public void setTotal_outstanding_under_pc_ps(String total_outstanding_under_pc_ps) {
		this.total_outstanding_under_pc_ps = total_outstanding_under_pc_ps;
	}



	public String getAmt_outstanding_for_ssi_msme() {
		return amt_outstanding_for_ssi_msme;
	}



	public void setAmt_outstanding_for_ssi_msme(String amt_outstanding_for_ssi_msme) {
		this.amt_outstanding_for_ssi_msme = amt_outstanding_for_ssi_msme;
	}



	public String getAmt_outstanding_for_govt_company() {
		return amt_outstanding_for_govt_company;
	}



	public void setAmt_outstanding_for_govt_company(String amt_outstanding_for_govt_company) {
		this.amt_outstanding_for_govt_company = amt_outstanding_for_govt_company;
	}



	public String getAmt_outstanding_for_obu() {
		return amt_outstanding_for_obu;
	}



	public void setAmt_outstanding_for_obu(String amt_outstanding_for_obu) {
		this.amt_outstanding_for_obu = amt_outstanding_for_obu;
	}



	public String getAnticipated_outstanding_in_current_year() {
		return anticipated_outstanding_in_current_year;
	}



	public void setAnticipated_outstanding_in_current_year(String anticipated_outstanding_in_current_year) {
		this.anticipated_outstanding_in_current_year = anticipated_outstanding_in_current_year;
	}



	public String getAmt_outstanding_from_adv_against_lc() {
		return amt_outstanding_from_adv_against_lc;
	}



	public void setAmt_outstanding_from_adv_against_lc(String amt_outstanding_from_adv_against_lc) {
		this.amt_outstanding_from_adv_against_lc = amt_outstanding_from_adv_against_lc;
	}



	public String getAmt_upto_which_adv_against_bill_covered() {
		return amt_upto_which_adv_against_bill_covered;
	}



	public void setAmt_upto_which_adv_against_bill_covered(String amt_upto_which_adv_against_bill_covered) {
		this.amt_upto_which_adv_against_bill_covered = amt_upto_which_adv_against_bill_covered;
	}



	public String getDesired_dl_for_new_account() {
		return desired_dl_for_new_account;
	}



	public void setDesired_dl_for_new_account(String desired_dl_for_new_account) {
		this.desired_dl_for_new_account = desired_dl_for_new_account;
	}



	@Override
	public String toString() {
		return wt_isrn_proposal_frm_id + "" + ecgc_branch_code + " " + bank_code + " " + employee_code + " " + bank_name
				+ " " + inward_id + " " + cover_type + " " + form_status + " " + bank_employee_name + " "
				+ bank_ecgc_designation + " " + bank_address + " " + issue_renewal_flag + " " + is_ssi_msme_covered
				+ " " + is_govt_company_covered + " " + is_obu_covered + " " + is_adv_against_lc_covered + " "
				+ is_adv_against_bills_covered + " " + annex_statement_of_packing_attached + " "
				+ annex_for_limit_sanction_attached + " "
				+ annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd + " "
				+ annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd + " " + annex_of_cdr_acc_attached + " "
				+ annex_of_shipment_export_credit_limit_sanctioned_attached + " "
				+ annex_of_annual_statement_of_acc_in_default_attached + " "
				+ annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid + " "
				+ annex_of_annual_statment_of_acc_in_default_attached + " "
				+ annex_for_exporter_financial_statement_analysis_attached + " " + no_of_limit_approved_acc + " "
				+ no_of_acct_default_reported + " " + no_of_sma2_acc + " " + no_of_cdr_acc + " "
				+ no_of_ssi_msme_acc_covered + " " + no_of_govt_companies_covered + " " + no_of_obu_covered + " "
				+ no_of_acc_for_which_adv_against_lc_covered + " "
				+ no_of_acc_to_be_covrd_for_advances_against_bill_of_associate + " " + from_date + " " + to_date + " "
				+ submission_date + " " + last_trans_date + " " + maximum_liability + " " + amt_of_limit_approved_acc
				+ " " + amt_of_default_reported + " " + amt_outstanding_of_sma2_acc + " "
				+ amount_outstanding_cdr_accounts + " " + total_outstanding_under_pc_ps + " "
				+ anticipated_outstanding_in_current_year + " " + amt_outstanding_for_ssi_msme + " "
				+ amt_outstanding_for_govt_company + " " + amt_outstanding_for_obu + " "
				+ amt_outstanding_from_adv_against_lc + " " + amt_upto_which_adv_against_bill_covered + " "
				+ desired_dl_for_new_account + " ";
	}

}