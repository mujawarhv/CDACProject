package in.cdac.ecib.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import in.cdac.ecib.dto.Button;
import in.cdac.ecib.dto.IssueRenewal;
import in.cdac.ecib.util.IssueRenewalMapper;

@Repository
public class IssueRenewalDaoImpl implements IssueRenewalDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setTemplate(NamedParameterJdbcTemplate template){
        this.namedParameterJdbcTemplate=template;
    }

	
	/*
	 * This method is for insertion of data in database when IssueRenewal Form is
	 * filled up
	 */

	@Override
	public void saveIssueRenewalRecord(IssueRenewal issueRenewal) {
		
		

		String sql = "select wt_isrn_proposal_frm_id from wt_isrn_proposal_frm;";
		Map<String, String> issueRenewalParam1 = new HashMap<String,String>();
		issueRenewalParam1.put("Wt_isrn_proposal_frm_id", issueRenewal.getWt_isrn_proposal_frm_id());
		List<String> list = namedParameterJdbcTemplate.query(sql, issueRenewalParam1, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});

		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = Integer.parseInt(list.get(i));
		}
		int max = 0;
		if (arr.length == 0) {
			max = max + 1;
		} else {
			Arrays.sort(arr);
			max = arr[arr.length - 1];
			max = max + 1;

		}
		
		
		Map<String, Object> issueRenewalParam = new HashMap<String,Object>();

		issueRenewalParam.put("Wt_isrn_proposal_frm_id", max);
		issueRenewalParam.put("ecgc_branch_code", "1");
		issueRenewalParam.put("bank_code", "00271");
		issueRenewalParam.put("employee_code", "343521");
		issueRenewalParam.put("bank_name", issueRenewal.getBank_name());
		issueRenewalParam.put("inward_id", "2");
		if(issueRenewal.getCover_type().equals("WT/PC"))
			issueRenewalParam.put("cover_type", "1");
		else
			issueRenewalParam.put("cover_type", "2");
		issueRenewalParam.put("form_status", "pass");
		issueRenewalParam.put("bank_employee_name", "hatim");
		issueRenewalParam.put("bank_ecgc_designation", "employee");
		issueRenewalParam.put("bank_address", "sangola");
		
		issueRenewalParam.put("issue_renewal_flag", false);
		issueRenewalParam.put("is_ssi_msme_covered", issueRenewal.isIs_ssi_msme_covered());
		issueRenewalParam.put("is_govt_company_covered", issueRenewal.isIs_govt_company_covered());
		issueRenewalParam.put("is_adv_against_lc_covered", issueRenewal.isIs_adv_against_lc_covered());
		issueRenewalParam.put("is_obu_covered", issueRenewal.isIs_obu_covered());
		issueRenewalParam.put("is_adv_against_bills_covered",  issueRenewal.isIs_adv_against_bills_covered());
		
		issueRenewalParam.put("annex_statement_of_packing_attached", issueRenewal.isAnnex_statement_of_packing_attached());
		issueRenewalParam.put("annex_for_limit_sanction_attached", issueRenewal.isAnnex_for_limit_sanction_attached());
		issueRenewalParam.put("annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd", issueRenewal.isAnnex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd());
		issueRenewalParam.put("annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd", issueRenewal.isAnnex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd());
		issueRenewalParam.put("annex_of_cdr_acc_attached", issueRenewal.isAnnex_of_cdr_acc_attached());
		issueRenewalParam.put("annex_of_shipment_export_credit_limit_sanctioned_attached", issueRenewal.isAnnex_of_shipment_export_credit_limit_sanctioned_attached());
		issueRenewalParam.put("annex_of_annual_statement_of_acc_in_default_attached", issueRenewal.isAnnex_of_annual_statement_of_acc_in_default_attached());
		issueRenewalParam.put("annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid", issueRenewal.isAnnex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid());
		issueRenewalParam.put("annex_of_annual_statment_of_acc_in_default_attached", issueRenewal.isAnnex_of_annual_statement_of_acc_in_default_attached());
		issueRenewalParam.put("annex_for_exporter_financial_statement_analysis_attached", issueRenewal.isAnnex_for_exporter_financial_statement_analysis_attached());
		
		issueRenewalParam.put("no_of_limit_approved_acc",issueRenewal.getNo_of_limit_approved_acc());
		issueRenewalParam.put("no_of_acct_default_reported", issueRenewal.getNo_of_acct_default_reported());
		issueRenewalParam.put("no_of_sma2_acc", issueRenewal.getNo_of_sma2_acc());
		issueRenewalParam.put("no_of_cdr_acc", issueRenewal.getNo_of_cdr_acc());
		issueRenewalParam.put("no_of_ssi_msme_acc_covered", issueRenewal.getNo_of_ssi_msme_acc_covered());
		issueRenewalParam.put("no_of_govt_companies_covered", issueRenewal.getNo_of_govt_companies_covered());
		issueRenewalParam.put("no_of_obu_covered", issueRenewal.getNo_of_obu_covered());
		issueRenewalParam.put("no_of_acc_for_which_adv_against_lc_covered", issueRenewal.getNo_of_acc_for_which_adv_against_lc_covered());
		issueRenewalParam.put("no_of_acc_to_be_covrd_for_advances_against_bill_of_associate", issueRenewal.getNo_of_acc_to_be_covrd_for_advances_against_bill_of_associate());
		
		
		issueRenewalParam.put("from_date", issueRenewal.getFrom_date());
		issueRenewalParam.put("to_date", issueRenewal.getTo_date());
		issueRenewalParam.put("submission_date", issueRenewal.getFrom_date());
		issueRenewalParam.put("last_trans_date", issueRenewal.getFrom_date());
		
		issueRenewalParam.put("maximum_liability", issueRenewal.getMaximum_liability());
		issueRenewalParam.put("amt_of_default_reported", issueRenewal.getAmt_of_default_reported());
		issueRenewalParam.put("amt_outstanding_of_sma2_acc", issueRenewal.getAmt_outstanding_of_sma2_acc());
		issueRenewalParam.put("amount_outstanding_cdr_accounts", issueRenewal.getAmount_outstanding_cdr_accounts());
		issueRenewalParam.put("amt_of_limit_approved_acc", issueRenewal.getAmt_of_limit_approved_acc());
		issueRenewalParam.put("total_outstanding_under_pc_ps", issueRenewal.getTotal_outstanding_under_pc_ps());
		issueRenewalParam.put("amt_outstanding_for_ssi_msme", issueRenewal.getAmt_outstanding_for_ssi_msme());
		issueRenewalParam.put("amt_outstanding_for_govt_company", issueRenewal.getAmt_outstanding_for_govt_company());
		issueRenewalParam.put("amt_outstanding_for_obu", issueRenewal.getAmt_outstanding_for_obu());
		issueRenewalParam.put("anticipated_outstanding_in_current_year", issueRenewal.getAnticipated_outstanding_in_current_year());
		issueRenewalParam.put("amt_outstanding_from_adv_against_lc", issueRenewal.getAmt_outstanding_from_adv_against_lc());
		issueRenewalParam.put("amt_upto_which_adv_against_bill_covered", issueRenewal.getAmt_upto_which_adv_against_bill_covered());
		issueRenewalParam.put("desired_dl_for_new_account", issueRenewal.getDesired_dl_for_new_account());

		String INSERT_ISSUERENEWAL_RECORD = "INSERT INTO wt_isrn_proposal_frm(wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability, amt_of_limit_approved_acc, amt_of_default_reported, amt_outstanding_of_sma2_acc, amount_outstanding_cdr_accounts, total_outstanding_under_pc_ps, anticipated_outstanding_in_current_year, amt_outstanding_for_ssi_msme, amt_outstanding_for_govt_company, amt_outstanding_for_obu, amt_outstanding_from_adv_against_lc, amt_upto_which_adv_against_bill_covered, desired_dl_for_new_account)VALUES (:Wt_isrn_proposal_frm_id,:ecgc_branch_code,:bank_code,:employee_code,:bank_name,:inward_id,:cover_type,:form_status,:bank_employee_name,:bank_ecgc_designation,:bank_address,:issue_renewal_flag,:is_ssi_msme_covered,:is_govt_company_covered,:is_adv_against_lc_covered,:is_obu_covered,:is_adv_against_bills_covered,:annex_statement_of_packing_attached,:annex_for_limit_sanction_attached,:annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd,:annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd,:annex_of_cdr_acc_attached,:annex_of_shipment_export_credit_limit_sanctioned_attached,:annex_of_annual_statement_of_acc_in_default_attached,:annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid,:annex_of_annual_statment_of_acc_in_default_attached,:annex_for_exporter_financial_statement_analysis_attached,:no_of_limit_approved_acc,:no_of_acct_default_reported,:no_of_sma2_acc,:no_of_cdr_acc,:no_of_ssi_msme_acc_covered,:no_of_govt_companies_covered,:no_of_obu_covered,:no_of_acc_for_which_adv_against_lc_covered,:no_of_acc_to_be_covrd_for_advances_against_bill_of_associate,:from_date,:to_date,:submission_date,:last_trans_date,:maximum_liability,:amt_of_default_reported,:amt_outstanding_of_sma2_acc,:amount_outstanding_cdr_accounts,:amt_of_limit_approved_acc,:total_outstanding_under_pc_ps,:amt_outstanding_for_ssi_msme,:amt_outstanding_for_govt_company,:amt_outstanding_for_obu,:anticipated_outstanding_in_current_year,:amt_outstanding_from_adv_against_lc,:amt_upto_which_adv_against_bill_covered,:desired_dl_for_new_account)";
		namedParameterJdbcTemplate.update(INSERT_ISSUERENEWAL_RECORD,issueRenewalParam );
		
	}

	/*
	 * When any changes in IssueRenewal is done then after clicking on update button
	 * Modify method of service will call to this method and updation will be done
	 */

	@Override
	public int updateIssueRenewalForm(String id, IssueRenewal issueRenewal) {
		
	String updateIssueRenewalForm="	UPDATE wt_isrn_proposal_frm set ecgc_branch_code=:ecgc_branch_code, bank_code=:bank_code, employee_code=:employee_code, bank_name=:bank_name, inward_id=:inward_id, cover_type=:cover_type, form_status=:form_status, bank_employee_name=:bank_employee_name, bank_ecgc_designation=:bank_ecgc_designation, bank_address=:bank_address, issue_renewal_flag=:issue_renewal_flag, is_ssi_msme_covered=:is_ssi_msme_covered, is_govt_company_covered=:is_govt_company_covered, is_obu_covered=:is_obu_covered, is_adv_against_lc_covered=:is_adv_against_lc_covered, is_adv_against_bills_covered=:is_adv_against_bills_covered, annex_statement_of_packing_attached=:annex_statement_of_packing_attached, annex_for_limit_sanction_attached=:annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd=:annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd=:annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached=:annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached=:annex_of_shipment_export_credit_limit_sanctioned_attached,annex_of_annual_statement_of_acc_in_default_attached=:annex_of_annual_statement_of_acc_in_default_attached,annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid=:annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid,annex_of_annual_statment_of_acc_in_default_attached=:annex_of_annual_statment_of_acc_in_default_attached,annex_for_exporter_financial_statement_analysis_attached=:annex_for_exporter_financial_statement_analysis_attached,no_of_limit_approved_acc=:no_of_limit_approved_acc, no_of_acct_default_reported=:no_of_acct_default_reported,no_of_sma2_acc=:no_of_sma2_acc, no_of_cdr_acc=:no_of_cdr_acc, no_of_ssi_msme_acc_covered=:no_of_ssi_msme_acc_covered,no_of_govt_companies_covered=:no_of_govt_companies_covered, no_of_obu_covered=:no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered=:no_of_acc_for_which_adv_against_lc_covered,no_of_acc_to_be_covrd_for_advances_against_bill_of_associate=:no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date=:from_date, to_date=:to_date,submission_date=:submission_date, last_trans_date=:last_trans_date, maximum_liability=:maximum_liability, amt_of_limit_approved_acc=:amt_of_limit_approved_acc,amt_of_default_reported=:amt_of_default_reported, amt_outstanding_of_sma2_acc=:amt_outstanding_of_sma2_acc, amount_outstanding_cdr_accounts=:amount_outstanding_cdr_accounts,total_outstanding_under_pc_ps=:total_outstanding_under_pc_ps, anticipated_outstanding_in_current_year=:anticipated_outstanding_in_current_year, amt_outstanding_for_ssi_msme=:amt_outstanding_for_ssi_msme, amt_outstanding_for_govt_company=:amt_outstanding_for_govt_company, amt_outstanding_for_obu=:amt_outstanding_for_obu, amt_outstanding_from_adv_against_lc=:amt_outstanding_from_adv_against_lc, amt_upto_which_adv_against_bill_covered=:amt_upto_which_adv_against_bill_covered, desired_dl_for_new_account=:desired_dl_for_new_account where wt_isrn_proposal_frm_id=:Wt_isrn_proposal_frm_id";

	Map<String, Object> issueRenewalParam = new HashMap<String,Object>();

	issueRenewalParam.put("Wt_isrn_proposal_frm_id", issueRenewal.getWt_isrn_proposal_frm_id());
	issueRenewalParam.put("ecgc_branch_code", issueRenewal.getEcgc_branch_code());
	issueRenewalParam.put("bank_code", issueRenewal.getBank_code());
	issueRenewalParam.put("employee_code",issueRenewal.getEmployee_code());
	issueRenewalParam.put("bank_name", issueRenewal.getBank_name());
	issueRenewalParam.put("inward_id", issueRenewal.getInward_id());
	if(issueRenewal.getCover_type().equals("WT/PC"))
		issueRenewalParam.put("cover_type", "1");
	else if(issueRenewal.getCover_type().equals("1"))
		issueRenewalParam.put("cover_type", "1");
	else
		issueRenewalParam.put("cover_type", "2");

	issueRenewalParam.put("form_status", issueRenewal.getForm_status());
	issueRenewalParam.put("bank_employee_name", issueRenewal.getBank_employee_name());
	issueRenewalParam.put("bank_ecgc_designation", "employee");
	issueRenewalParam.put("bank_address", "sangola");
	
	issueRenewalParam.put("issue_renewal_flag", false);
	issueRenewalParam.put("is_ssi_msme_covered", issueRenewal.isIs_ssi_msme_covered());
	issueRenewalParam.put("is_govt_company_covered", issueRenewal.isIs_govt_company_covered());
	issueRenewalParam.put("is_adv_against_lc_covered", issueRenewal.isIs_adv_against_lc_covered());
	issueRenewalParam.put("is_obu_covered", issueRenewal.isIs_obu_covered());
	issueRenewalParam.put("is_adv_against_bills_covered",  issueRenewal.isIs_adv_against_bills_covered());
	
	issueRenewalParam.put("annex_statement_of_packing_attached", issueRenewal.isAnnex_statement_of_packing_attached());
	issueRenewalParam.put("annex_for_limit_sanction_attached", issueRenewal.isAnnex_for_limit_sanction_attached());
	issueRenewalParam.put("annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd", issueRenewal.isAnnex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd());
	issueRenewalParam.put("annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd", issueRenewal.isAnnex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd());
	issueRenewalParam.put("annex_of_cdr_acc_attached", issueRenewal.isAnnex_of_cdr_acc_attached());
	issueRenewalParam.put("annex_of_shipment_export_credit_limit_sanctioned_attached", issueRenewal.isAnnex_of_shipment_export_credit_limit_sanctioned_attached());
	issueRenewalParam.put("annex_of_annual_statement_of_acc_in_default_attached", issueRenewal.isAnnex_of_annual_statement_of_acc_in_default_attached());
	issueRenewalParam.put("annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid", issueRenewal.isAnnex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid());
	issueRenewalParam.put("annex_of_annual_statment_of_acc_in_default_attached", issueRenewal.isAnnex_of_annual_statement_of_acc_in_default_attached());
	issueRenewalParam.put("annex_for_exporter_financial_statement_analysis_attached", issueRenewal.isAnnex_for_exporter_financial_statement_analysis_attached());
	
	issueRenewalParam.put("no_of_limit_approved_acc",issueRenewal.getNo_of_limit_approved_acc());
	issueRenewalParam.put("no_of_acct_default_reported", issueRenewal.getNo_of_acct_default_reported());
	issueRenewalParam.put("no_of_sma2_acc", issueRenewal.getNo_of_sma2_acc());
	issueRenewalParam.put("no_of_cdr_acc", issueRenewal.getNo_of_cdr_acc());
	issueRenewalParam.put("no_of_ssi_msme_acc_covered", issueRenewal.getNo_of_ssi_msme_acc_covered());
	issueRenewalParam.put("no_of_govt_companies_covered", issueRenewal.getNo_of_govt_companies_covered());
	issueRenewalParam.put("no_of_obu_covered", issueRenewal.getNo_of_obu_covered());
	issueRenewalParam.put("no_of_acc_for_which_adv_against_lc_covered", issueRenewal.getNo_of_acc_for_which_adv_against_lc_covered());
	issueRenewalParam.put("no_of_acc_to_be_covrd_for_advances_against_bill_of_associate", issueRenewal.getNo_of_acc_to_be_covrd_for_advances_against_bill_of_associate());
	
	
	issueRenewalParam.put("from_date", issueRenewal.getFrom_date());
	issueRenewalParam.put("to_date", issueRenewal.getTo_date());
	issueRenewalParam.put("submission_date", issueRenewal.getFrom_date());
	issueRenewalParam.put("last_trans_date", issueRenewal.getFrom_date());
	
	issueRenewalParam.put("maximum_liability", issueRenewal.getMaximum_liability());
	issueRenewalParam.put("amt_of_default_reported", issueRenewal.getAmt_of_default_reported());
	issueRenewalParam.put("amt_outstanding_of_sma2_acc", issueRenewal.getAmt_outstanding_of_sma2_acc());
	issueRenewalParam.put("amount_outstanding_cdr_accounts", issueRenewal.getAmount_outstanding_cdr_accounts());
	issueRenewalParam.put("amt_of_limit_approved_acc", issueRenewal.getAmt_of_limit_approved_acc());
	issueRenewalParam.put("total_outstanding_under_pc_ps", issueRenewal.getTotal_outstanding_under_pc_ps());
	issueRenewalParam.put("amt_outstanding_for_ssi_msme", issueRenewal.getAmt_outstanding_for_ssi_msme());
	issueRenewalParam.put("amt_outstanding_for_govt_company", issueRenewal.getAmt_outstanding_for_govt_company());
	issueRenewalParam.put("amt_outstanding_for_obu", issueRenewal.getAmt_outstanding_for_obu());
	issueRenewalParam.put("anticipated_outstanding_in_current_year", issueRenewal.getAnticipated_outstanding_in_current_year());
	issueRenewalParam.put("amt_outstanding_from_adv_against_lc", issueRenewal.getAmt_outstanding_from_adv_against_lc());
	issueRenewalParam.put("amt_upto_which_adv_against_bill_covered", issueRenewal.getAmt_upto_which_adv_against_bill_covered());
	issueRenewalParam.put("desired_dl_for_new_account", issueRenewal.getDesired_dl_for_new_account());
		
	return namedParameterJdbcTemplate.update(updateIssueRenewalForm, issueRenewalParam);
	
	}

	@Override
	public List<IssueRenewal> getAllIssueRenewalList() {
		
		IssueRenewal issueRenewal = new IssueRenewal();
		
		Map<String, String> issueRenewalParam = new HashMap<String,String>();
		issueRenewalParam.put("Wt_isrn_proposal_frm_id", issueRenewal.getWt_isrn_proposal_frm_id());
		issueRenewalParam.put("bank_name", issueRenewal.getBank_name());
		issueRenewalParam.put("cover_type", issueRenewal.getCover_type());
		
		String sql = "select wt_isrn_proposal_frm_id,bank_name,cover_type from wt_isrn_proposal_frm where issue_renewal_flag IS  false  order by wt_isrn_proposal_frm_id ";
		
		List<IssueRenewal> list = namedParameterJdbcTemplate.query(sql,issueRenewalParam,new RowMapper<IssueRenewal>() {
					@Override
					public IssueRenewal mapRow(ResultSet rs, int rowNum) throws SQLException {
						IssueRenewal issueRenewal = new IssueRenewal();
						issueRenewal.setWt_isrn_proposal_frm_id(rs.getString("wt_isrn_proposal_frm_id"));
						issueRenewal.setBank_name(rs.getString("bank_name"));
						if(rs.getString("cover_type").equals("1"))
								issueRenewal.setCover_type("WT/PC");
						else
							issueRenewal.setCover_type("WT/PS");
						return issueRenewal;
					}
				});
		return list;
	}

	@Override
	public IssueRenewal getIssueRenewalById(String wt_isrn_proposal_frm_id) {
		
		String GET_ISSUERENEWAL_BY_ID = "SELECT wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability::numeric, amt_of_limit_approved_acc::numeric::numeric, amt_of_default_reported::numeric, amt_outstanding_of_sma2_acc::numeric, amount_outstanding_cdr_accounts::numeric, total_outstanding_under_pc_ps::numeric, anticipated_outstanding_in_current_year::numeric, amt_outstanding_for_ssi_msme::numeric, amt_outstanding_for_govt_company::numeric, amt_outstanding_for_obu::numeric::numeric, amt_outstanding_from_adv_against_lc::numeric, amt_upto_which_adv_against_bill_covered::numeric, desired_dl_for_new_account::numeric FROM wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id ";
		
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		
		return namedParameterJdbcTemplate.queryForObject(GET_ISSUERENEWAL_BY_ID, issueRenewalParam, new IssueRenewalMapper() );
	}

	@Override
	public IssueRenewal getbyDocuments(String wt_isrn_proposal_frm_id) {

		IssueRenewal issueRenewal = new IssueRenewal();
		String sql = "select annex_statement_of_packing_attached,annex_for_limit_sanction_attached,annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id ";
		
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		
		try {
			issueRenewal = namedParameterJdbcTemplate.queryForObject(sql, issueRenewalParam, new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class) );
		} catch (Exception e) {
			issueRenewal = null;
		}
		return issueRenewal;
	}

	@Override
	public IssueRenewal openOfficeNotePC(IssueRenewal issueRenewal) {

		String GET_ISSUERENEWAL_BY_ID = "SELECT wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability::numeric, amt_of_limit_approved_acc::numeric::numeric, amt_of_default_reported::numeric, amt_outstanding_of_sma2_acc::numeric, amount_outstanding_cdr_accounts::numeric, total_outstanding_under_pc_ps::numeric, anticipated_outstanding_in_current_year::numeric, amt_outstanding_for_ssi_msme::numeric, amt_outstanding_for_govt_company::numeric, amt_outstanding_for_obu::numeric::numeric, amt_outstanding_from_adv_against_lc::numeric, amt_upto_which_adv_against_bill_covered::numeric, desired_dl_for_new_account::numeric FROM wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id ";
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("wt_isrn_proposal_frm_id", issueRenewal.getWt_isrn_proposal_frm_id());
		
		IssueRenewal issueRenewal1 = namedParameterJdbcTemplate.queryForObject(GET_ISSUERENEWAL_BY_ID, issueRenewalParam, new IssueRenewalMapper() );
		return issueRenewal1;
	}

	@Override
	public boolean isValidOfficeNoteId(String wt_isrn_proposal_frm_id) {

		String sql = "SELECT wt_isrn_proposal_frm_id FROM wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id";
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		
		try {
			namedParameterJdbcTemplate.queryForObject(sql, issueRenewalParam, new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class) );
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public IssueRenewal openOfficeNotePS(IssueRenewal issueRenewal) {
		
		String GET_ISSUERENEWAL_BY_ID = "SELECT wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability::numeric, amt_of_limit_approved_acc::numeric::numeric, amt_of_default_reported::numeric, amt_outstanding_of_sma2_acc::numeric, amount_outstanding_cdr_accounts::numeric, total_outstanding_under_pc_ps::numeric, anticipated_outstanding_in_current_year::numeric, amt_outstanding_for_ssi_msme::numeric, amt_outstanding_for_govt_company::numeric, amt_outstanding_for_obu::numeric::numeric, amt_outstanding_from_adv_against_lc::numeric, amt_upto_which_adv_against_bill_covered::numeric, desired_dl_for_new_account::numeric FROM wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id ";
		
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("wt_isrn_proposal_frm_id", issueRenewal.getWt_isrn_proposal_frm_id());
		
		IssueRenewal issueRenewal1 = namedParameterJdbcTemplate.queryForObject(GET_ISSUERENEWAL_BY_ID, issueRenewalParam, new IssueRenewalMapper() );
		return issueRenewal1;
	}

	
	//No need of this metod
	@Override
	public void insertSystemEntryPS(IssueRenewal issueRenewal) {
		String sql = "insert into wt_isrn(wt_isrn_id, wt_isrn_proposal_frm_id,employee_code,maximum_liability) values(:wt_isrn_id, :wt_isrn_proposal_frm_id,:employee_code,:maximum_liability) ";
		
		Map<String, Object> issueRenewalParam = new HashMap<String, Object>();
		issueRenewalParam.put("wt_isrn_id", issueRenewal.getWt_isrn_proposal_frm_id());
		issueRenewalParam.put("wt_isrn_proposal_frm_id", issueRenewal.getWt_isrn_proposal_frm_id());
		issueRenewalParam.put("employee_code",  issueRenewal.getEmployee_code());
		issueRenewalParam.put("maximum_liability",  issueRenewal.getMaximum_liability());
		
		namedParameterJdbcTemplate.update(sql,issueRenewalParam);
	}

	@Override
	public IssueRenewal getONInfo(String wt_isrn_proposal_frm_id) {
		IssueRenewal issueRenewal;
		String GET_ISSUERENEWAL_BY_ID = "SELECT wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability::numeric, amt_of_limit_approved_acc::numeric::numeric, amt_of_default_reported::numeric, amt_outstanding_of_sma2_acc::numeric, amount_outstanding_cdr_accounts::numeric, total_outstanding_under_pc_ps::numeric, anticipated_outstanding_in_current_year::numeric, amt_outstanding_for_ssi_msme::numeric, amt_outstanding_for_govt_company::numeric, amt_outstanding_for_obu::numeric::numeric, amt_outstanding_from_adv_against_lc::numeric, amt_upto_which_adv_against_bill_covered::numeric, desired_dl_for_new_account::numeric FROM wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id ";
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		
		try {
			issueRenewal =  namedParameterJdbcTemplate.queryForObject(GET_ISSUERENEWAL_BY_ID, issueRenewalParam, new IssueRenewalMapper() );
		} catch (Exception e) {
			issueRenewal = null;
		}
		return issueRenewal;
	}

	@Override
	public int prelimiaryScrutinyCompleted(String wt_isrn_proposal_frm_id) {
		
		String button_status = "UPDATE wt_isrn_button_status set prelim_status='false', office_note_status='true', reco_status='false', decision_status='false' WHERE isrn_id=:wt_isrn_proposal_frm_id";
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		namedParameterJdbcTemplate.update(button_status,issueRenewalParam);

		String sql = "UPDATE wt_isrn_proposal_frm SET form_status='pass' WHERE wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id";
		return 	namedParameterJdbcTemplate.update(sql,issueRenewalParam);

	}


	@Override
	public void createOfficeNote(IssueRenewal issueRenewal) {

		String wt_isrn_proposal_id = issueRenewal.getWt_isrn_proposal_frm_id();
		String get_office_note_id = "SELECT wt_isrn_office_note_id FROM wt_isrn_office_note";

		List<String> list = namedParameterJdbcTemplate.query(get_office_note_id, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});

		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = Integer.parseInt(list.get(i));
		}
		int id = 0;
		if (arr.length == 0) {
			id = id + 1;
		} else {
			Arrays.sort(arr);
			id = arr[arr.length - 1];
			id = id + 1;

		}
	
		String sql = "insert into wt_isrn_office_note(wt_isrn_office_note_id,wt_isrn_id,filename,employee_code,dated) values(:wt_isrn_office_note_id,:wt_isrn_id,:filename,:employee_code,:dated) ";
		
		Map<String, Object> issueRenewalParam1 = new HashMap<String, Object>();
		issueRenewalParam1.put("wt_isrn_office_note_id",id);
		issueRenewalParam1.put("wt_isrn_id", wt_isrn_proposal_id);
		issueRenewalParam1.put("filename", "xyz.pdf");
		issueRenewalParam1.put("employee_code", issueRenewal.getEmployee_code());
		issueRenewalParam1.put("dated", new Date());
		namedParameterJdbcTemplate.update(sql,issueRenewalParam1);

		String button_status = "UPDATE wt_isrn_button_status set prelim_status=:prelim_status, office_note_status=:office_note_status, reco_status=:reco_status, decision_status=:decision_status WHERE isrn_id=:wt_isrn_id";
		Map<String, Object> issueRenewalParam2 = new HashMap<String, Object>();
		issueRenewalParam2.put("wt_isrn_id",wt_isrn_proposal_id);
		issueRenewalParam2.put("prelim_status", false);
		issueRenewalParam2.put("office_note_status", false);
		issueRenewalParam2.put("reco_status", true);
		issueRenewalParam2.put("decision_status", false);
		namedParameterJdbcTemplate.update(button_status,issueRenewalParam2);

	}

	@Override
	public void insertRecommendation(String wt_isrn_id, String recommendation_line) {

		String sql1 = "SELECT recommendation_id FROM recommendations where  wt_isrn_id=:wt_isrn_id";
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("wt_isrn_id", wt_isrn_id);

		List<String> list = namedParameterJdbcTemplate.query(sql1,issueRenewalParam , new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});

		String[] arr = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		String recommend_Id = "";
		if (arr.length == 0) {
			recommend_Id = wt_isrn_id + "R" + 1;
		} else {
			Arrays.sort(arr);
			String max = arr[arr.length - 1];
			char myString = max.charAt(max.length() - 1);
			myString = (char) (myString + 1);
			recommend_Id = wt_isrn_id + "R" + myString;

		}


		String sql = "insert into recommendations(employee_code, recommendation_line, recommendation_date, recommendation_id, wt_isrn_id)values(:employee_code, :recommendation_line, :recommendation_date, :recommendation_id, :wt_isrn_id)";
		
		Map<String, Object> issueRenewalParam1 = new HashMap<String, Object>();
		issueRenewalParam1.put("employee_code", "343521");
		issueRenewalParam1.put("recommendation_line", recommendation_line);
		issueRenewalParam1.put("recommendation_date",new Date() );
		issueRenewalParam1.put("recommendation_id", recommend_Id);
		issueRenewalParam1.put("wt_isrn_id", wt_isrn_id);
		
		
		namedParameterJdbcTemplate.update(sql,issueRenewalParam1);

		String button_status = "UPDATE wt_isrn_button_status set prelim_status=:prelim_status, office_note_status=:office_note_status, reco_status=:reco_status, decision_status=:decision_status WHERE isrn_id=:wt_isrn_id";
		Map<String, Object> issueRenewalParam2 = new HashMap<String, Object>();
		issueRenewalParam2.put("wt_isrn_id", wt_isrn_id);
		issueRenewalParam2.put("prelim_status", false);
		issueRenewalParam2.put("office_note_status", false);
		issueRenewalParam2.put("reco_status", false);
		issueRenewalParam2.put("decision_status", true);
		namedParameterJdbcTemplate.update(button_status,issueRenewalParam2);

	}

	@Override
	public List<String> showRecommedationMessage(String wt_isrn_proposal_frm_id) {

		String sql = "select recommendation_line from recommendations where wt_isrn_id=:wt_isrn_proposal_frm_id";
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		
		List<String> data = namedParameterJdbcTemplate.query(sql, issueRenewalParam, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		return data;
	}

	@Override
	public IssueRenewal getDetailsOfDop(String isrn_id) {

		IssueRenewal issueRenewal;
		String sql = "SELECT wt_isrn_proposal_frm_id, ecgc_branch_code, bank_code, employee_code, bank_name, inward_id, cover_type, form_status, bank_employee_name, bank_ecgc_designation, bank_address, issue_renewal_flag, is_ssi_msme_covered, is_govt_company_covered, is_obu_covered, is_adv_against_lc_covered, is_adv_against_bills_covered, annex_statement_of_packing_attached, annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached, annex_for_exporter_financial_statement_analysis_attached, no_of_limit_approved_acc, no_of_acct_default_reported, no_of_sma2_acc, no_of_cdr_acc, no_of_ssi_msme_acc_covered, no_of_govt_companies_covered, no_of_obu_covered, no_of_acc_for_which_adv_against_lc_covered, no_of_acc_to_be_covrd_for_advances_against_bill_of_associate, from_date, to_date, submission_date, last_trans_date, maximum_liability::numeric, amt_of_limit_approved_acc::numeric::numeric, amt_of_default_reported::numeric, amt_outstanding_of_sma2_acc::numeric, amount_outstanding_cdr_accounts::numeric, total_outstanding_under_pc_ps::numeric, anticipated_outstanding_in_current_year::numeric, amt_outstanding_for_ssi_msme::numeric, amt_outstanding_for_govt_company::numeric, amt_outstanding_for_obu::numeric::numeric, amt_outstanding_from_adv_against_lc::numeric, amt_upto_which_adv_against_bill_covered::numeric, desired_dl_for_new_account::numeric FROM wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=:isrn_id";
		Map<String, String> issueRenewalParam = new HashMap<String, String>();
		issueRenewalParam.put("isrn_id", isrn_id);

		issueRenewal = namedParameterJdbcTemplate.queryForObject(sql, issueRenewalParam,new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class));
		return issueRenewal;
	}

	@Override
	public void insertdop(String decision, String remarks, String reason, java.sql.Date start_date,
			java.sql.Date expiry_date, BigDecimal ml, BigDecimal dl, BigDecimal set_limit, IssueRenewal issueRenewal) {

		String wt_isrn_decision_id = "select wt_isrn_decision_id from wt_isrn_decision;";

		List<String> list = namedParameterJdbcTemplate.query(wt_isrn_decision_id, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});

		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = Integer.parseInt(list.get(i));
		}
		int max = 0;
		if (arr.length == 0) {
			max = 1;
		} else {
			Arrays.sort(arr);
			max = arr[arr.length - 1];
			max = max + 1;
		}

		String sql = "insert into wt_isrn_decision (wt_isrn_decision_id, wt_isrn_id, employee_code, decision, remarks, reason, decision_date, start_date, expiry_date, ml, dl, set_limit) values (:wt_isrn_decision_id, :wt_isrn_id, :employee_code, :decision, :remarks, :reason, :decision_date, :start_date, :expiry_date, :ml, :dl, :set_limit)";

		Map<String, Object> issueRenewalParam = new HashMap<String, Object>();
		issueRenewalParam.put("wt_isrn_decision_id", max);
		issueRenewalParam.put("wt_isrn_id", issueRenewal.getWt_isrn_proposal_frm_id());
		issueRenewalParam.put("employee_code", issueRenewal.getEmployee_code());
		issueRenewalParam.put("decision", decision);
		issueRenewalParam.put("remarks", remarks);
		issueRenewalParam.put("reason", reason);
		issueRenewalParam.put("decision_date", java.time.LocalDate.now());
		issueRenewalParam.put("start_date", start_date);
		issueRenewalParam.put("expiry_date", expiry_date);
		issueRenewalParam.put("ml", ml);
		issueRenewalParam.put("dl", dl);
		issueRenewalParam.put("set_limit", set_limit);
		namedParameterJdbcTemplate.update(sql,issueRenewalParam);

		String button_status = "UPDATE wt_isrn_button_status set prelim_status=:prelim_status, office_note_status=:office_note_status, reco_status=:reco_status, decision_status=:decision_status WHERE isrn_id=:wt_isrn_proposal_frm_id";
		
		Map<String, Object> issueRenewalParam1 = new HashMap<String, Object>();
		issueRenewalParam1.put("wt_isrn_proposal_frm_id", issueRenewal.getWt_isrn_proposal_frm_id());
		issueRenewalParam1.put("prelim_status", false);
		issueRenewalParam1.put("office_note_status", false);
		issueRenewalParam1.put("reco_status", false);
		issueRenewalParam1.put("decision_status", false);
		namedParameterJdbcTemplate.update(button_status,issueRenewalParam1);
	}

	@Override
	public int submitIssueRenewal(String wt_isrn_proposal_frm_id) {

		String sql1 = "INSERT INTO wt_isrn(wt_isrn_id, wt_isrn_proposal_frm_id, employee_code, maximum_liability, discretionary_limit, cover_percentage, premium_rate) VALUES (:wt_isrn_id,:wt_isrn_proposal_frm_id,:employee_code,:maximum_liability,:discretionary_limit,:cover_percentage,:premium_rate);";
		Map<String, Object> issueRenewalParam = new HashMap<String, Object>();
		issueRenewalParam.put("wt_isrn_id", wt_isrn_proposal_frm_id);
		issueRenewalParam.put("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		issueRenewalParam.put("employee_code", "343521");
		issueRenewalParam.put("maximum_liability", 1234);
		issueRenewalParam.put("discretionary_limit", 1234);
		issueRenewalParam.put("cover_percentage", 3);
		issueRenewalParam.put("premium_rate", 3);
		namedParameterJdbcTemplate.update(sql1,issueRenewalParam);
		
		String button_status = "INSERT INTO wt_isrn_button_status(isrn_id, prelim_status, office_note_status, reco_status, decision_status)VALUES (:isrn_id,:prelim_status,:office_note_status,:reco_status,:decision_status);";
		Map<String, Object> issueRenewalParam1 = new HashMap<String, Object>();
		issueRenewalParam1.put("isrn_id", wt_isrn_proposal_frm_id);
		issueRenewalParam1.put("prelim_status", true);
		issueRenewalParam1.put("office_note_status", false);
		issueRenewalParam1.put("reco_status", false);
		issueRenewalParam1.put("decision_status", false);
		namedParameterJdbcTemplate.update(button_status,issueRenewalParam1);
	
		String sql = "UPDATE wt_isrn_proposal_frm SET issue_renewal_flag='true'  WHERE wt_isrn_proposal_frm_id=:wt_isrn_proposal_frm_id ";
		Map<String, String> issueRenewalParam2 = new HashMap<String, String>();
		issueRenewalParam2.put("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		return namedParameterJdbcTemplate.update(sql,issueRenewalParam2);
	}

	

	public List<Button> buttonList() {
		
		String sql ="SELECT isrn_id, prelim_status, office_note_status, reco_status, decision_status FROM wt_isrn_button_status where prelim_status=true or office_note_status=true or reco_status=true or decision_status=true order by isrn_id";
		List<Button> list = namedParameterJdbcTemplate.query(sql, new RowMapper<Button>() {
			@Override
			public Button mapRow(ResultSet rs, int rowNum) throws SQLException {
				Button button = new Button();
				button.setIsrn_id(rs.getString("isrn_id"));
				button.setPrelim_status(rs.getBoolean("prelim_status"));
				button.setOffice_note_status(rs.getBoolean("office_note_status"));
				button.setReco_status(rs.getBoolean("reco_status"));
				button.setDecision_status(rs.getBoolean("decision_status"));
				return button;
			}
		});
		return list;
	}

}