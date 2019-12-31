package in.cdac.ecib.controller;

import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import in.cdac.ecib.service.IssueRenewalServ;
import in.cdac.ecib.dto.IssueRenewal;

@Controller
@SessionAttributes("issueRenewal")

public class BankController {

	@Autowired
	private IssueRenewalServ issueRenewalServ;

	 private Logger logger = LoggerFactory.getLogger(IssueRenewalServ.class);

	/*
	 * When bank click on Login button on index page then it will go to BankLogin
	 * and then bank will be able to see filled IssueRenewalForm and can also apply
	 * for new IssueRenewal.
	 */

	@RequestMapping(value = "/banklogin.htm")
	public String bankLoginForm(ModelMap model, HttpServletRequest request) {
		String str = "Bank Login";
		HttpSession session = request.getSession();
		session.setAttribute("str", str);
		List<IssueRenewal> listIssueRenewal = issueRenewalServ.getAllBankList();
		model.put("listIssueRenewal", listIssueRenewal);
		model.addAttribute("str", str);
		return "Login";
	}

	/*
	 * When ECGC click on Login button on index page then it will go to ECGCLogin
	 * and then ECGC user will be able to see filled IssueRenewalForm and can also
	 * apply for new IssueRenewal.
	 */

	@RequestMapping(value = "/eciblogin.htm")
	public String ecibLoginForm(ModelMap model, HttpServletRequest request) {
		String str = "ECGC Login";
		HttpSession session = request.getSession();
		session.setAttribute("str", str);
		List<IssueRenewal> listIssueRenewal = issueRenewalServ.getAllBankList();
		model.put("listIssueRenewal", listIssueRenewal);
		model.addAttribute("str", str);
		return "Login";
	}



	/*
	 * When a new proposal come then Bank or ECGC officer will logged in and when
	 * click IssueRenewalForm then a new form will open required details are filled.
	 */

	@RequestMapping(value = "/IssueRenewalForm.htm")
	public String prepLoginForm(@RequestParam("cover_type_wtpc_wtps") String cover_type_wtpc_wtps, ModelMap model,
			HttpServletRequest request) {
		model.addAttribute("issueRenewal", new IssueRenewal());
		return "issueRenewalForm";
	}

	/*
	 * When a new IssueRenewalForm form is filled then it goes to next page by
	 * clicking Next button and here on uploadAnnexure all the required annexures
	 * are uploaded.
	 */

	@RequestMapping(value = "/uploadFiles.htm", method = RequestMethod.POST)
	public ModelAndView nextIssueRenewalPage(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal,
			HttpServletRequest request, HttpServletResponse response, BindingResult result, ModelAndView model)
			throws Exception {
		if (issueRenewal != null) {
			issueRenewalServ.create(issueRenewal);
		} else {
			String str = "Incorrect details";
			request.setAttribute("str", str);
			model = new ModelAndView("ErrorPage");
		}
		HttpSession session = request.getSession();
		String str = (String) session.getAttribute("str");
		session.setAttribute("str", str);
		model = new ModelAndView("uploadAnnexure");
		return model;
	}

	/*
	 * When annexure are uploaded then next state is to save the form when clicked
	 * on submit button here form is saved and one refrence number is generated for
	 * that form.
	 */

	

	@RequestMapping(value = "saveIssueRenewal.htm", method = RequestMethod.POST)
	public String saveForm(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal,HttpServletRequest request, BindingResult result,
			ModelMap model) {
	
		// int id = issueRenewalServ.getById(bank);
		
		String str = "ECGC Login";
		HttpSession session = request.getSession();
		session.setAttribute("str", str);
		List<IssueRenewal> listIssueRenewal = issueRenewalServ.getAllBankList();
		model.put("listIssueRenewal", listIssueRenewal);
		model.addAttribute("str", str);
		return "Login";
		
	}
		
	
	
	/*
	 * When bank or ecgc is uploading the documents and if he want to go to previous
	 * page then using previous button he can come back to IssueRenewal form.
	 */

	@RequestMapping(value = "/PreviousBackToIssueRenewal.htm")
	public String prevPage(ModelMap model) {
		model.addAttribute("issueRenewal", new IssueRenewal());
		return "issueRenewalForm";
	}

	/*
	 * When bank or ecgc user is filling the form and if he want to cancel the
	 * filling form then using cancel button he can cancel the partially filled form
	 * and return back to index page.
	 */

	@RequestMapping(value = "/backToIndex.htm")
	public String cancel(ModelMap model) {
		List<IssueRenewal> listIssueRenewal = issueRenewalServ.getAllBankList();
		model.put("listIssueRenewal", listIssueRenewal);
		return "Login";
	}
	
	@RequestMapping(value = "/submitIssueRenewalForm.htm")
	public String submitParticularIssueRenewalForm(@RequestParam("proposalfrmid") String proposalfrmid, ModelMap model,HttpServletRequest request) {
		 issueRenewalServ.submitIssueRenewal(proposalfrmid);
		
			int num = (int) (Math.random() * Integer.MAX_VALUE);
			model.addAttribute("num", num);
		return "submitted";
		
	}
	
	

	@RequestMapping(value = "/editIssueRenewalForm.htm",method = RequestMethod.POST)
	public String editParticularUserForm(@RequestParam("proposalfrmid") String proposalfrmid, ModelMap model) {
		IssueRenewal issueRenewal = issueRenewalServ.selectUser(proposalfrmid);
		model.addAttribute("issueRenewal", issueRenewal);
		return "issueRenewalUpdate";
	}
	
	

	/*
	 * When changes made in IssueRenewal form after clicking on update button all
	 * changes will saved to database and return back to the particular logged
	 * Screen.
	 */

	@RequestMapping(value = "/updateIssueRenewal.htm")
	public String updateIssueRenewalForm(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model) {
		issueRenewalServ.modify(issueRenewal.getWt_isrn_proposal_frm_id(), issueRenewal);
//		List<IssueRenewal> listIssueRenewal = issueRenewalServ.getAllBankList();
//		model.put("listIssueRenewal", listIssueRenewal);
		return "updateAnnexure";
	}

	@RequestMapping(value = "/updateIssueRenewalForm.htm")
	public String updateIssueRenewalAnnexure(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model) {
		// issueRenewalServ.Modify(issueRenewal.getWt_isrn_proposal_frm_id(),
		// issueRenewal);
		List<IssueRenewal> listIssueRenewal = issueRenewalServ.getAllBankList();
		model.put("listIssueRenewal", listIssueRenewal);
		return "Login";
	}

	/*
	 * When ECGC officer is logged in then the IssueRenewal form which are submitted
	 * by bank or ecgc that only will be proceed for Preliminary Scrutiny all the
	 * forms that are submitted will be shown here.
	 */

	@RequestMapping(value = "/prep-priliminary-scrutiny.htm", method = RequestMethod.GET)
	public String prepPriliminaryScrutinyForm(ModelMap model, HttpServletRequest request) {

		List<IssueRenewal> listIssueRenewal = issueRenewalServ.getIssueRenewalList();
		List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
		List<IssueRenewal> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

		HttpSession session = request.getSession();
		String name = "ECIB Login";
		session.setAttribute("name", name);

		model.put("listIssueRenewal", listIssueRenewal);
		model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
		model.put("listOfRecommedation", listOfRecommedation);
		model.addAttribute("issueRenewal", new IssueRenewal());
		return "startPS";
	}

	/*
	 * If ECGC Officer opens any form for Preliminary Scrutiny and if he want to go
	 * back to select any other form then he will click on cancel button.
	 */

	@RequestMapping(value = "/cancelPreliminaryScrutinypage.htm")
	public String cancelPreliminaryScrutinyForm(ModelMap model) {
		List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getIssueRenewalList();
		List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
		List<IssueRenewal> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

		model.put("listIssueRenewal", listOfPreliminaryScrutiny);
		model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
		model.put("listOfRecommedation", listOfRecommedation);
		model.addAttribute("issueRenewal", new IssueRenewal());

		return "startPS";
	}

	/*
	 * Here ECGC officer will click on submitted IssueRenewal Form and then he will
	 * be able to check the IssueRenewal Form that all the filled data are
	 * applicable or not and after that it will go on Annexure Page.
	 */

	@RequestMapping(value = "/selectIssueRenewalId.htm")
	public String selectParticularUser(@RequestParam("proposalfrmid") String proposalfrmid, ModelMap model,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = request.getParameter("proposalfrmid");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);

		String name = "ECIB Login";
		session.setAttribute("name", name);

		IssueRenewal issueRenewal = issueRenewalServ.selectUser(proposalfrmid);
		model.addAttribute("issueRenewal", issueRenewal);
		return "displayPreliminarySrutinyForm";
	}

	/*
	 * Here ECGC officer will click on Annexure Page and will check that all
	 * uploaded Annexure are correct or not if found correct then he will verify the
	 * Form if some missing data found then he will send for clarification.
	 */

	@RequestMapping(value = "/DisplayPreliminaryScrutinySecondPage.htm")
	public String displayPreliminaryScrutinySecondPage(HttpServletRequest request,
			@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model) throws Exception {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = (String) session.getAttribute("wt_isrn_proposal_frm_id");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		String name = "ECIB Login";
		session.setAttribute("name", name);

		issueRenewal = issueRenewalServ.getByDocument(issueRenewal.getWt_isrn_proposal_frm_id());

		if (issueRenewal != null)
			model.put("issueRenewal", issueRenewal);
		return "displayPreliminaryScrutinySecondPage";
	}

	/*
	 * When Preliminary Scrutiny is done after that ECGC officer will click on
	 * OfficeNote Generation here Page will open.
	 */
	@RequestMapping(value = "/preliminaryScrutinyDone.htm", params = "action2")
	public String officeNoteGeneration(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = (String) session.getAttribute("wt_isrn_proposal_frm_id");
		
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		String name = "ECIB Login";
		session.setAttribute("name", name);

		issueRenewalServ.psCompleted(wt_isrn_proposal_frm_id);
		
		issueRenewal = issueRenewalServ.getOfficeNoteInfo(wt_isrn_proposal_frm_id);
		model.addAttribute("issueRenewal", issueRenewal);
		return "officeNote";

	}

	@RequestMapping(value = "/preliminaryScrutinyDone.htm", params = "action1")
	public String backToStartPS(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model,
			HttpServletRequest request) {

		List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getIssueRenewalList();
		List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
		List<IssueRenewal> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

		model.put("listIssueRenewal", listOfPreliminaryScrutiny);
		model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
		model.put("listOfRecommedation", listOfRecommedation);
		model.addAttribute("issueRenewal", new IssueRenewal());
		return "startPS";

	}

	@RequestMapping(value = "/officenote.htm")
	public String officeNotePage(@RequestParam("proposalfrmid") String proposalfrmid,
			@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = proposalfrmid;
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		
		String name = "ECIB Login";
		session.setAttribute("name", name);

		issueRenewal = issueRenewalServ.getOfficeNoteInfo(proposalfrmid);
		model.addAttribute("issueRenewal", issueRenewal);
		return "officeNote";
	}

	/*
	 * Here ECGC office after doing Preliminary Scrutiny will go for Office Note
	 * Generation where ECGC officer has to fill cover type, ISRN id and bank code
	 * after that it will go to that particular covert type form and office note is
	 * generated.
	 */

	@RequestMapping(value = "/GenerateOfficeNote.htm")
	public String officeNote(HttpServletRequest request, @ModelAttribute("issueRenewal") IssueRenewal issueRenewal,
			ModelMap model) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = (String) session.getAttribute("wt_isrn_proposal_frm_id");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		String name = "ECIB Login";
		session.setAttribute("name", name);

		try {
			boolean isvalid1 = issueRenewalServ.checkId(issueRenewal.getWt_isrn_proposal_frm_id());
//			boolean isvalid2 = issueRenewalServ.checkCoverType(issueRenewal.getCover_type());
//			boolean isvalid3 = issueRenewalServ.checkBankCode(issueRenewal.getBank_code());

			if (isvalid1) {
				if (issueRenewal.getCover_type().equals("1")) {
					issueRenewal = issueRenewalServ.openOfficeNotePC(issueRenewal);
					model.addAttribute("issueRenewal", issueRenewal);
					return "officeNotePC";

				} else if (issueRenewal.getCover_type().equals("2")) {
					issueRenewal = issueRenewalServ.openOfficeNotePS(issueRenewal);
					model.addAttribute("issueRenewal", issueRenewal);
					return "officeNotePS";
				}
			} else {
				String str = "Incorrect details";
				System.out.println(str);
				request.setAttribute("str", str);
				return "errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "startPS";
	}

	/*
	 * This controller is used to add data in office note database and after that it
	 * will return to main ecib screen i.e startPS
	 */

	@RequestMapping(value = "/officenotegeneration.htm")
	public String generationOfOfficeNote(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model) {
		
		issueRenewalServ.createOfficeNote(issueRenewal);

		List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getIssueRenewalList();
		List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
		List<IssueRenewal> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

		model.put("listIssueRenewal", listOfPreliminaryScrutiny);
		model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
		model.put("listOfRecommedation", listOfRecommedation);

		return "startPS";
	}

	/*
	 * This controller is used to go on recommedation page
	 */
	@RequestMapping(value = "/addRecommedation.htm")
	public String addRecommedation(@RequestParam("isrnfrmid") String isrnfrmid,
			@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = isrnfrmid;
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		String name = "ECIB Login";
		session.setAttribute("name", name);

		
		model.addAttribute("issueRenewal", new IssueRenewal());

		return "addRecommedation";
	}

	/*
	 * This controller is used to insert recommedation and will return on same page
	 * after adding recommedation
	 */

	@RequestMapping(value = "/insertRecommendation.htm")
	public String insertRecommendation(@RequestParam("recommendation_line") String recommendation_line,
			@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = (String) session.getAttribute("wt_isrn_proposal_frm_id");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		String name = "ECIB Login";
		session.setAttribute("name", name);


		issueRenewalServ.insertRecommendationData(wt_isrn_proposal_frm_id, recommendation_line);
		List<String> message = issueRenewalServ.showRecommedation(wt_isrn_proposal_frm_id);
		model.put("message", message);
		model.addAttribute("issueRenewal", new IssueRenewal());

		return "recommedation2";
	}

	@RequestMapping(value = "/insertRecommendation2.htm")
	public String insertRecommendation2(@RequestParam("recommendation_line") String recommendation_line,
			@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = (String) session.getAttribute("wt_isrn_proposal_frm_id");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		String name = "ECIB Login";
		session.setAttribute("name", name);


		issueRenewalServ.insertRecommendationData(wt_isrn_proposal_frm_id, recommendation_line);
		
		List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getIssueRenewalList();
		List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
		List<IssueRenewal> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

		model.put("listIssueRenewal", listOfPreliminaryScrutiny);
		model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
		model.put("listOfRecommedation", listOfRecommedation);

		return "startPS";
	}
	
	
	@RequestMapping(value = "/wt_isrn.htm", method = RequestMethod.POST)
	public String addSystemEntry(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, HttpServletRequest request,
			HttpServletResponse response, BindingResult result, Model model) throws Exception {

		issueRenewalServ.insertSystemEntry(issueRenewal);
		model.addAttribute("issueRenewal", issueRenewal);
		return "priliminaryScrutiny";
	}

	/*
	 * This controller will show whose decision is yet to do
	 */

	@RequestMapping(value = "/decision.htm", method = RequestMethod.GET)
	public String dop(@ModelAttribute("issueRenewal1") IssueRenewal issueRenewal, HttpServletRequest request,
			HttpServletResponse response, BindingResult result, ModelMap model) throws Exception {

		/*
		 * String name = "ecgc3"; HttpSession session = request.getSession();
		 * session.setAttribute("name",name);
		 */

		List<String> message = issueRenewalServ.showRecommedation();
		model.put("message", message);

		model.addAttribute("issueRenewal1", new IssueRenewal());
		return "decision";
	}

	/*
	 * This controller will show the Decision Page
	 */

	@RequestMapping(value = "/submitrecommedation.htm")
	public String submitRecommendation(@RequestParam("id") String isrn_id, ModelMap model, HttpServletRequest request) {
	
		/*
		 * HttpSession session = request.getSession(); String wt_isrn_proposal_frm_id =
		 * (String) session.getAttribute("name");
		 * session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		 */
		List<String> message = issueRenewalServ.showRecommedation(isrn_id);
		model.put("message", message);
		IssueRenewal issueRenewal1 = issueRenewalServ.getDetailsOfDop(isrn_id);
		model.addAttribute("issueRenewal1", issueRenewal1);
		return "decisionPage";
	}

	/*
	 * This controller will insert Decision data and return to pending decision page
	 */

	@RequestMapping(value = "/submitDOP.htm", method = RequestMethod.POST)
	public String dopSubmit(@RequestParam("start_date") Date start_date, @RequestParam("end_date") Date expiry_date,
			@ModelAttribute("issueRenewal1") IssueRenewal issueRenewal, HttpServletRequest request,
			HttpServletResponse response, BindingResult result, ModelMap model) throws Exception {

		String decision = request.getParameter("decision");
		String remarks = request.getParameter("remarks");
		String reason = request.getParameter("reason");
		String ml = request.getParameter("ml");
		String dl = request.getParameter("dl");
		String set_limit = request.getParameter("set_limit");

		issueRenewalServ.dopDone(decision, remarks, reason, start_date, expiry_date, ml, dl, set_limit, issueRenewal);

		List<String> message = issueRenewalServ.showRecommedation();
		model.put("message", message);
		model.addAttribute("issueRenewal1", new IssueRenewal());

		
		return "decision";
	}

	/*
	 * @ExceptionHandler(Exception.class) public String handleException() { return
	 * "errorPage"; }
	 */

}