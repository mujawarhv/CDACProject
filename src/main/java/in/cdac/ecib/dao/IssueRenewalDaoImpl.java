package in.cdac.ecib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.cdac.ecib.dto.Button;
import in.cdac.ecib.dto.IssueRenewal;
import in.cdac.ecib.dto.User;

@Repository
public class IssueRenewalDaoImpl implements IssueRenewalDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * This method is for insertion of data in database when IssueRenewal Form is
	 * filled up
	 */

	@Override
	public void save(IssueRenewal issueRenewal) {

		String sql = "select wt_isrn_proposal_frm_id from wt_isrn_proposal_frm;";
		
	

		List<String> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});

		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = Integer.parseInt(list.get(i));
		}
		int max=0;
		if (arr.length == 0) 
		{
			max=max+1;
		}
		else
		{
			Arrays.sort(arr);
		    max = arr[arr.length-1];
			max = max + 1;
		
		
		}

		

		String str = "insert into wt_isrn_proposal_frm(wt_isrn_proposal_frm_id,annex_statement_of_packing_attached, "
				+ "	annex_for_limit_sanction_attached, annex_of_stmnt_of_acc_covrd_undr_wt_with_claim_recovery_attchd, "
				+ "	annex_of_annual_stmnt_of_acc_covered_under_wt_wo_attchd, annex_of_cdr_acc_attached, "
				+ "	annex_of_shipment_export_credit_limit_sanctioned_attached, annex_of_annual_statement_of_acc_in_default_attached, "
				+ "	annex_of_annl_stmnt_of_acc_covrd_undr_ecib_or_postn_of_clm_paid, annex_of_annual_statment_of_acc_in_default_attached,"
				+ "	annex_for_exporter_financial_statement_analysis_attached,ecgc_branch_code, bank_code,issue_renewal_flag,employee_code,form_status,bank_employee_name,bank_name,inward_id,cover_type,from_date,"
				+ "to_date,maximum_liability,no_of_limit_approved_acc,amt_of_limit_approved_acc,"
				+ "no_of_acct_default_reported,amt_of_default_reported,"
				+ "no_of_sma2_acc,amt_outstanding_of_sma2_acc, no_of_cdr_acc,amount_outstanding_cdr_accounts,"
				+ "total_outstanding_under_pc_ps,anticipated_outstanding_in_current_year,"
				+ "is_ssi_msme_covered,no_of_ssi_msme_acc_covered,amt_outstanding_for_ssi_msme,"
				+ "is_govt_company_covered,no_of_govt_companies_covered,amt_outstanding_for_govt_company,"
				+ "is_adv_against_lc_covered,no_of_acc_for_which_adv_against_lc_covered,amt_outstanding_from_adv_against_lc,"
				+ "is_obu_covered,no_of_obu_covered,amt_outstanding_for_obu,is_adv_against_bills_covered,"
				+ "no_of_acc_to_be_covrd_for_advances_against_bill_of_associate,amt_upto_which_adv_against_bill_covered,"
				+ "desired_dl_for_new_account)values('" + max
				+ "','true','true','true','true','true','true','true','true','true','true','1','00271','false','343521','fail','hatim','"
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

		jdbcTemplate.update(str);
		
	}

	/*
	 * When any changes in IssueRenewal is done then after clicking on update button
	 * Modify method of service will call to this method and updation will be done
	 */

	@Override
	public int update(String id, IssueRenewal issueRenewal) {
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
				+ issueRenewal.getDesired_dl_for_new_account() + "' WHERE wt_isrn_proposal_frm_id='"
				+ issueRenewal.getWt_isrn_proposal_frm_id() + "'";

		return jdbcTemplate.update(sql);

	}

	@Override
	public List<IssueRenewal> userList() {
		List<IssueRenewal> list = jdbcTemplate.query(
				"SELECT * FROM wt_isrn_proposal_frm where issue_renewal_flag IS  false  order by wt_isrn_proposal_frm_id ",
				new RowMapper<IssueRenewal>() {
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
			jdbcTemplate.queryForObject(sql, new Object[] { Wt_isrn_proposal_frm_id },
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
				+ "('1','" + issueRenewal.getWt_isrn_proposal_frm_id() + "','" + issueRenewal.getEmployee_code() + "','"
				+ issueRenewal.getMaximum_liability() + "')";
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
		String button_status = "UPDATE wt_isrn_button_status set prelim_status='false', office_note_status='true', reco_status='false', decision_status='false' WHERE isrn_id='"+wt_isrn_proposal_frm_id+"'";
		jdbcTemplate.update(button_status);
		
		String sql = "UPDATE wt_isrn_proposal_frm SET form_status='pass' WHERE wt_isrn_proposal_frm_id='"+ wt_isrn_proposal_frm_id + "'";
		return jdbcTemplate.update(sql);
		
	
	}

	@Override
	public List<IssueRenewal> getlistOfPreliminaryScrutinyDone() {
		List<IssueRenewal> list = jdbcTemplate.query(
				"SELECT wt_isrn_proposal_frm_id FROM wt_isrn_proposal_frm where form_status='pass' and wt_isrn_proposal_frm_id not in(SELECT wt_isrn_proposal_frm_id from wt_isrn where wt_isrn_id  in(select wt_isrn_id from wt_isrn_office_note)) order by wt_isrn_proposal_frm_id ",
				new RowMapper<IssueRenewal>() {
					@Override
					public IssueRenewal mapRow(ResultSet rs, int rowNum) throws SQLException {
						IssueRenewal issueRenewal = new IssueRenewal();
						issueRenewal.setWt_isrn_proposal_frm_id(rs.getString("wt_isrn_proposal_frm_id"));
						return issueRenewal;
					}
				});
		return list;
	}

	@Override
	public void createOfficeNote(IssueRenewal issueRenewal) {

		String wt_isrn_office_note_id = "SELECT wt_isrn_office_note_id FROM wt_isrn_office_note WHERE wt_isrn_office_note_id = (SELECT MAX(wt_isrn_office_note_id ) FROM wt_isrn_office_note);";
		String office_note_id = jdbcTemplate.queryForObject(wt_isrn_office_note_id, String.class);

		String sql1 = "select  * from wt_isrn where wt_isrn_proposal_frm_id=?";

		IssueRenewal isrn_id = jdbcTemplate.queryForObject(sql1,
				new Object[] { issueRenewal.getWt_isrn_proposal_frm_id() },
				new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class));

		System.out.println(isrn_id);

		String wt_isrn_proposal_id = issueRenewal.getWt_isrn_proposal_frm_id();

		
		int id = Integer.parseInt(office_note_id);
		id = id + 1;
	
		String sql = "insert into wt_isrn_office_note(wt_isrn_office_note_id,wt_isrn_id,filename,employee_code,dated) values('"
				+ id + "','" + wt_isrn_proposal_id + "','xyz.pdf','" + issueRenewal.getEmployee_code()
				+ "','2019-12-27') ";
		
		jdbcTemplate.update(sql);
		
		String button_status = "UPDATE wt_isrn_button_status set prelim_status='false', office_note_status='false', reco_status='true', decision_status='false' WHERE isrn_id='"+issueRenewal.getWt_isrn_proposal_frm_id()+"'";
		jdbcTemplate.update(button_status);

	}

	@Override
	public List<IssueRenewal> getListOfOfficeNoteDone() {
		
		String sql = "select wt_isrn_proposal_frm_id from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id IN(select wt_isrn_id from wt_isrn WHERE wt_isrn_id IN (select wt_isrn_id from wt_isrn_office_note where wt_isrn_id NOT IN (Select wt_isrn_id from recommendations))) order by wt_isrn_proposal_frm_id";
		
		List<IssueRenewal> list = jdbcTemplate.query(sql,
				new RowMapper<IssueRenewal>() {
					@Override
					public IssueRenewal mapRow(ResultSet rs, int rowNum) throws SQLException {
						IssueRenewal issueRenewal = new IssueRenewal();
						issueRenewal.setWt_isrn_proposal_frm_id(rs.getString("wt_isrn_proposal_frm_id"));
						return issueRenewal;
					}
				});
		return list;

		
	}

	@Override
	public User loginUser(User user) {

		String sql = "SELECT user_id, user_password FROM login WHERE user_id=?";
		user = jdbcTemplate.queryForObject(sql, new Object[] { user.getUserId() },
				new BeanPropertyRowMapper<User>(User.class));
	
		return user;
	}

	@Override
	public void insertRecommendation(String wt_isrn_id, String recommendation_line) {
	
		String sql1 = "SELECT recommendation_id FROM recommendations where  wt_isrn_id=?";

		List<String> list = jdbcTemplate.query(sql1, new Object[] {wt_isrn_id}, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		
		String[] arr = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		String recommend_Id="";
		if (arr.length == 0) 
		{
			recommend_Id = wt_isrn_id + "R" + 1;	
		}
		else
		{
			Arrays.sort(arr);
			String max = arr[arr.length-1];
			char myString = max.charAt(max.length() - 1);
			myString = (char) (myString + 1);
			recommend_Id = wt_isrn_id + "R" + myString;
		
		}
		
		
	
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));

		String sql = "insert into recommendations(employee_code, recommendation_line, recommendation_date, recommendation_id, wt_isrn_id) values('343521','"
				+ recommendation_line + "','" + sd.format(date) + "','" + recommend_Id + "','" + wt_isrn_id + "')";
		jdbcTemplate.update(sql);
	
		String button_status = "UPDATE wt_isrn_button_status set prelim_status='false', office_note_status='false', reco_status='false', decision_status='true' WHERE isrn_id='"+wt_isrn_id+"'";
		jdbcTemplate.update(button_status);
		
	}
	

	@Override
	public List<String> showRecommedationMessage(String wt_isrn_proposal_frm_id) {
		
		String sql = "select recommendation_line from recommendations where wt_isrn_id=?";
		List<String> data = jdbcTemplate.query(sql, new Object[] { wt_isrn_proposal_frm_id }, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		return data;
	}
	

	@Override
	public List<String> getListOfRecommedationDone() {
		String sql = "select DISTINCT(wt_isrn_id) from recommendations where wt_isrn_id NOT IN(Select wt_isrn_id from wt_isrn_decision);";

		List<String> data = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		return data;
	}
	

	@Override
	public IssueRenewal getDetailsOfDop(String isrn_id) {
		
		IssueRenewal issueRenewal;
		String sql = "select * from wt_isrn_proposal_frm where wt_isrn_proposal_frm_id=? ";
		
			issueRenewal = jdbcTemplate.queryForObject(sql, new Object[] { isrn_id },
					new BeanPropertyRowMapper<IssueRenewal>(IssueRenewal.class));
		
		return issueRenewal;
	}
	

	@Override
	public void insertdop(String decision, String remarks, String reason, java.sql.Date start_date, java.sql.Date expiry_date,
			String ml, String dl, String set_limit, IssueRenewal issueRenewal) {
		
		
		
		
		String wt_isrn_decision_id = "select wt_isrn_decision_id from wt_isrn_decision;";

		List<String> list = jdbcTemplate.query(wt_isrn_decision_id, new Object[] {}, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});

		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = Integer.parseInt(list.get(i));
		}
		int max=0;
		if (arr.length == 0) 
		{
			max =1;	
		}
		else
		{
		Arrays.sort(arr);
		max = arr[arr.length-1];
		max = max + 1;
		}
	
		String sql = "insert into wt_isrn_decision (wt_isrn_decision_id, wt_isrn_id, employee_code, decision, remarks, reason, decision_date, start_date, expiry_date, ml, dl, set_limit)"
				+ " values ('"+max+"','"+issueRenewal.getWt_isrn_proposal_frm_id()+"','"+issueRenewal.getEmployee_code() + "','"+decision+"','"+remarks+"','"+reason+"','"+java.time.LocalDate.now()+"','"+start_date+"','"+expiry_date+"','"+ml+"','"+dl+"','"+set_limit+"')";
		
		jdbcTemplate.update(sql);
		
		String button_status = "UPDATE wt_isrn_button_status set prelim_status='false', office_note_status='false', reco_status='false', decision_status='false' WHERE isrn_id='"+issueRenewal.getWt_isrn_proposal_frm_id()+"'";
		jdbcTemplate.update(button_status);
	}

	@Override
	public int submitIssueRenewal(String proposalfrmid) {
		
		String button_status = "INSERT INTO wt_isrn_button_status(isrn_id, prelim_status, office_note_status, reco_status, decision_status)VALUES ('"+proposalfrmid+"','true','false','false','false');";
		jdbcTemplate.update(button_status);
		String sql = "UPDATE wt_isrn_proposal_frm SET issue_renewal_flag='true'  WHERE wt_isrn_proposal_frm_id='"+ proposalfrmid+"'  ";
		return jdbcTemplate.update(sql);
	}
	

	@Override
	public List<IssueRenewal> IssueRenewalList() {
		List<IssueRenewal> list = jdbcTemplate.query(
				" SELECT * FROM wt_isrn_proposal_frm where issue_renewal_flag=true and form_status='fail'",
				new RowMapper<IssueRenewal>() {
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

	
	public List<Button> buttonList() {
		List<Button> list = jdbcTemplate.query(
				"SELECT * FROM wt_isrn_button_status order by isrn_id",
				new RowMapper<Button>() {
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