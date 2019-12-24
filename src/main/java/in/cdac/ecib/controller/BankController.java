package in.cdac.ecib.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

	@RequestMapping(value = "/ecgclogin.htm")
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
	 * Here ECGC officer will be able to do Prelimiary Scrutiny as well as he will
	 * be able to generate Office Note and Recommendation.
	 */

	@RequestMapping(value = "/index1.htm")
	public String index(ModelMap model) {
		return "StartPS";
	}

	/*
	 * When a new proposal come then Bank or ECGC officer will logged in and when
	 * click IssueRenewalForm then a new form will open required details are filled.
	 */

	@RequestMapping(value = "/IssueRenewalForm.htm")
	public String prepLoginForm(@RequestParam("cover_type_wtpc_wtps") String cover_type_wtpc_wtps, ModelMap model,
			HttpServletRequest request) {
		model.addAttribute("issueRenewal", new IssueRenewal());
		return "IssueRenewal";
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
			issueRenewalServ.Create(issueRenewal);
		} else {
			String str = "Incorrect details";
			System.out.println(str);
			request.setAttribute("str", str);
			model = new ModelAndView("ErrorPage");
		}
		model = new ModelAndView("uploadAnnexure");
		return model;
	}

	/*
	 * When annexure are uploaded then next state is to save the form when clicked
	 * on submit button here form is saved and one refrence number is generated for
	 * that form.
	 */

	// @RequestMapping(value =
	// "/http://10.212.9.172:8080/dms/dmsrestfileupload/uploadfile", method =
	// RequestMethod.POST)

	@RequestMapping(value = "saveIssueRenewal.htm", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, BindingResult result,
			Model model) {
		int num = (int) (Math.random() * Integer.MAX_VALUE);
		// int id = issueRenewalServ.getById(bank);
		ModelAndView model1 = new ModelAndView("submitted");
		model.addAttribute("num", num);
		return model1;
	}

	/*
	 * When bank or ecgc is uploading the documents and if he want to go to previous
	 * page then using previous button he can come back to IssueRenewal form.
	 */

	@RequestMapping(value = "/PreviousBackToIssueRenewal.htm")
	public String prevPage(ModelMap model) {
		model.addAttribute("issueRenewal", new IssueRenewal());
		return "IssueRenewal";
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

	/*
	 * When bank/ECGC officer has filled IssueRenewal form and he when any changes
	 * occur in that form then he will go to IssueRenewalUpdate to make changes in
	 * filled form.
	 */

	@RequestMapping(value = "/editIssueRenewalForm.htm")
	public String editParticularUserForm(@RequestParam("proposalfrmid") String proposalfrmid, ModelMap model) {
		IssueRenewal issueRenewal = issueRenewalServ.selectUser(proposalfrmid);
		model.addAttribute("issueRenewal", issueRenewal);
		return "IssueRenewalUpdate";
	}

	/*
	 * When changes made in IssueRenewal form after clicking on update button all
	 * changes will saved to database and return back to the particular logged
	 * Screen.
	 */

	@RequestMapping(value = "/updateIssueRenewal.htm")
	public String update(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model) {
		issueRenewalServ.Modify(issueRenewal.getWt_isrn_proposal_frm_id(), issueRenewal);
//		List<IssueRenewal> listIssueRenewal = issueRenewalServ.getAllBankList();
//		model.put("listIssueRenewal", listIssueRenewal);
		return "updateAnnexure";
	}

	@RequestMapping(value = "/updateIssueRenewalForm.htm")
	public String updateAnnexure(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model) {
		//issueRenewalServ.Modify(issueRenewal.getWt_isrn_proposal_frm_id(), issueRenewal);
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

		List<IssueRenewal> listIssueRenewal = issueRenewalServ.getAllBankList();
		List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
		List<String> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();
		//List<String> listOfDOP = issueRenewalServ.getListOfRecommedationNoteDone();

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = request.getParameter("wt_isrn_proposal_frm_id");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);

		model.put("listIssueRenewal", listIssueRenewal);
		model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
		model.put("listOfRecommedation", listOfRecommedation);
	//	model.put("listOfDOP", listOfDOP);
		model.addAttribute("issueRenewal", new IssueRenewal());
		return "StartPS";
	}

	/*
	 * If ECGC Officer opens any form for Preliminary Scrutiny and if he want to go
	 * back to select any other form then he will click on cancel button.
	 */

	@RequestMapping(value = "/cancelPreliminaryScrutinypage.htm")
	public String cancelPreliminaryScrutinypage(ModelMap model) {
		List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getAllBankList();
		List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
		List<String> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

		model.put("listIssueRenewal", listOfPreliminaryScrutiny);
		model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
		model.put("listOfRecommedation", listOfRecommedation);
		model.addAttribute("issueRenewal", new IssueRenewal());

		return "StartPS";
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

		IssueRenewal issueRenewal = issueRenewalServ.selectUser(proposalfrmid);
		model.addAttribute("issueRenewal", issueRenewal);
		return "DisplayPreliminarySrutinyForm";
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

		issueRenewal = issueRenewalServ.getByDocument(issueRenewal.getWt_isrn_proposal_frm_id());

		if (issueRenewal != null)
			model.put("issueRenewal", issueRenewal);
		return "DisplayPreliminaryScrutinySecondPage";
	}

	/*
	 * When Preliminary Scrutiny is done after that ECGC officer will click on
	 * OfficeNote Generation here Page will open.
	 */

	@RequestMapping(value = "/preliminaryScrutinyDone.htm")
	public String officeNoteGeneration(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = (String) session.getAttribute("wt_isrn_proposal_frm_id");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);

		issueRenewalServ.psCompleted(wt_isrn_proposal_frm_id);
		issueRenewal = issueRenewalServ.getOfficeNoteInfo(wt_isrn_proposal_frm_id);
		model.addAttribute("issueRenewal", issueRenewal);
		return "OfficeNote";
	}

	@RequestMapping(value = "/officenote.htm")
	public String officeNotePage(@RequestParam("proposalfrmid") String proposalfrmid,
			@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = (String) session.getAttribute("wt_isrn_proposal_frm_id");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);

		issueRenewal = issueRenewalServ.getOfficeNoteInfo(proposalfrmid);
		model.addAttribute("issueRenewal", issueRenewal);
		return "OfficeNote";
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

		try {
			boolean isvalid1 = issueRenewalServ.checkId(issueRenewal.getWt_isrn_proposal_frm_id());
//			boolean isvalid2 = issueRenewalServ.checkCoverType(issueRenewal.getCover_type());
//			boolean isvalid3 = issueRenewalServ.checkBankCode(issueRenewal.getBank_code());

			if (isvalid1) {
				if (issueRenewal.getCover_type().equals("1")) {
					issueRenewal = issueRenewalServ.openOfficeNotePC(issueRenewal);
					model.addAttribute("issueRenewal", issueRenewal);
					return "OfficeNotePC";

				} else if (issueRenewal.getCover_type().equals("2")) {
					issueRenewal = issueRenewalServ.openOfficeNotePS(issueRenewal);
					model.addAttribute("issueRenewal", issueRenewal);
					return "OfficeNotePS";
				}
			} else {
				String str = "Incorrect details";
				System.out.println(str);
				request.setAttribute("str", str);
				return "ErrorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "StartPS";
	}

	@RequestMapping(value = "/officenotegeneration.htm")
	public String generationOfOfficeNote(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model) {
		issueRenewalServ.createOfficeNote(issueRenewal);

		List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getAllBankList();
		List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
		List<String> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

		model.put("listIssueRenewal", listOfPreliminaryScrutiny);
		model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
		model.put("listOfRecommedation", listOfRecommedation);

		return "StartPS";
	}

	@RequestMapping(value = "/addRecommedation.htm")
	public String AddRecommedation(@RequestParam("isrnfrmid") String isrnfrmid,
			@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = isrnfrmid;
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);

		List<String> message = issueRenewalServ.showRecommedation(wt_isrn_proposal_frm_id);
		model.put("message", message);
		model.addAttribute("issueRenewal", new IssueRenewal());

		return "addRecommedation";
	}

	@RequestMapping(value = "/insertRecommendation.htm")
	public String insertRecommendation(@RequestParam("recommendation_line") String recommendation_line,
			@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = (String) session.getAttribute("wt_isrn_proposal_frm_id");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);

		List<String> message = issueRenewalServ.showRecommedation(wt_isrn_proposal_frm_id);
		model.put("message", message);
		model.addAttribute("issueRenewal", new IssueRenewal());

		issueRenewalServ.insertRecommendationData(wt_isrn_proposal_frm_id, recommendation_line);
		model.addAttribute("issueRenewal", new IssueRenewal());

		return "addRecommedation";
	}
	
	
	@RequestMapping(value = "/submitrecommedation.htm")
	public String submitRecommendation(@RequestParam("id") String isrn_id,@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model, HttpServletRequest request) {
		System.out.println("****************************");
		
		HttpSession session = request.getSession();
		String wt_isrn_proposal_frm_id = (String) session.getAttribute("name");
		session.setAttribute("wt_isrn_proposal_frm_id", wt_isrn_proposal_frm_id);
		
		IssueRenewal listIssueRenewal = issueRenewalServ.getDetailsOfDop(isrn_id);
		model.put("listIssueRenewal", listIssueRenewal);
		return "Login";
	}
	

	@RequestMapping(value = "/wt_isrn.htm", method = RequestMethod.POST)
	public String addSystemEntry(@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, HttpServletRequest request,
			HttpServletResponse response, BindingResult result, Model model) throws Exception {

		issueRenewalServ.insertSystemEntry(issueRenewal);
		model.addAttribute("issueRenewal", issueRenewal);
		return "Priliminary_Scrutiny";
	}

	


	
	/*
	 * @ExceptionHandler(Exception.class) public String handleException() { return
	 * "ErrorPage"; }
	 */

}