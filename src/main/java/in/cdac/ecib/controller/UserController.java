package in.cdac.ecib.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.cdac.ecib.dto.IssueRenewal;
import in.cdac.ecib.dto.User;
import in.cdac.ecib.service.IssueRenewalServ;

@Controller
public class UserController {

	@Autowired
	IssueRenewalServ issueRenewalServ;
	
	private Logger logger = LoggerFactory.getLogger(IssueRenewalServ.class);

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String login(@ModelAttribute("user") User user, BindingResult result, Model model) {

		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/userlogin.htm", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("user") User user,
			@ModelAttribute("issueRenewal") IssueRenewal issueRenewal, ModelMap model, HttpServletRequest request) {

		System.out.println("***************************");
		logger.info("user :", user);
		

		user = issueRenewalServ.loginUser(user);
		System.out.println(user.getUserId());
		String name = user.getUserId();
		if (name != null) {
			if (name.equals("banklogin")) {
				List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getAllBankList();
				List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
				List<IssueRenewal> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

				model.put("listIssueRenewal", listOfPreliminaryScrutiny);
				model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
				model.put("listOfRecommedation", listOfRecommedation);

				model.addAttribute("issueRenewal", new IssueRenewal());

				return "StartPS";
			} else if (name.equals("eciblogin")) {
				List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getAllBankList();
				List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
				List<IssueRenewal> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

				model.put("listIssueRenewal", listOfPreliminaryScrutiny);
				model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
				model.put("listOfRecommedation", listOfRecommedation);

				model.addAttribute("issueRenewal", new IssueRenewal());

				return "StartPS";
			}

			else if (name.equals("ecgc1")) {

				List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getAllBankList();
				List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
				List<IssueRenewal> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

				model.put("listIssueRenewal", listOfPreliminaryScrutiny);
				model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
				model.put("listOfRecommedation", listOfRecommedation);
				model.addAttribute("issueRenewal", new IssueRenewal());
				return "StartPS";
			} else if (name.equals("ecgc2")) {

				List<IssueRenewal> listOfPreliminaryScrutiny = issueRenewalServ.getAllBankList();
				List<IssueRenewal> listOfPreliminaryScrutinyDone = issueRenewalServ.getlistOfPreliminaryScrutinyDone();
				List<IssueRenewal> listOfRecommedation = issueRenewalServ.getListOfOfficeNoteDone();

				model.put("listIssueRenewal", listOfPreliminaryScrutiny);
				model.put("listOfPreliminaryScrutinyDone", listOfPreliminaryScrutinyDone);
				model.put("listOfRecommedation", listOfRecommedation);
				model.addAttribute("issueRenewal", new IssueRenewal());
				return "StartPS";
			} else if (name.equals("ecgc3")) {
				
				 HttpSession session = request.getSession(); 
				 session.setAttribute("name",name);
				 
				List<String> message = issueRenewalServ.showRecommedation();
				model.put("message", message);
				model.addAttribute("issueRenewal1", new IssueRenewal());
				return "DOP";
			} else {
				return "login";
			}
		} else {
			return "login";
		}

	}

}
