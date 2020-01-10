<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="ErrorPage.jsp"%>
<%@page import="in.cdac.ecib.dto.*"%><%@page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fmt"%>
<%
	IssueRenewal issueRenewal = (IssueRenewal) session.getAttribute("issueRenewal");
%>
<%
	List<IssueRenewal> userList = (List<IssueRenewal>) request.getAttribute("listIssueRenewal");
%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>ECGC </title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
	function sendData() {

		$.post({
			url : 'savemembership',
			data : $('form[name=membershipForm]').serialize(),
			success : function(res) {

				alert("Result is: " + res)

			}
		});

	}
</script>


</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					SB Admin <sup>2</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item"><a class="nav-link" href="index.html">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item active"><a class="nav-link" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>Components</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Custom Components:</h6>
						<a class="collapse-item" href="buttons.html">Buttons</a> <a
							class="collapse-item active" href="cards.html">Cards</a>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>Utilities</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Custom Utilities:</h6>
						<a class="collapse-item" href="utilities-color.html">Colors</a> <a
							class="collapse-item" href="utilities-border.html">Borders</a> <a
							class="collapse-item" href="utilities-animation.html">Animations</a>
						<a class="collapse-item" href="utilities-other.html">Other</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Addons</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i> <span>Pages</span>
			</a>
				<div id="collapsePages" class="collapse show"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Login Screens:</h6>
						  
					<div class="collapse-divider"></div>

					<a class="collapse-item" href="prep-priliminary-scrutiny.htm">ECIB</a>
            <a class="collapse-item" href="banklogin.htm">Bank Login</a>
					</div>
				</div></li>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="charts.html">
					<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link" href="tables.html">
					<i class="fas fa-fw fa-table"></i> <span>Tables</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
								<span class="badge badge-danger badge-counter">3+</span>
						</a> <!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown">
								<h6 class="dropdown-header">Alerts Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-primary">
											<i class="fas fa-file-alt text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 12, 2019</div>
										<span class="font-weight-bold">A new monthly report is
											ready to download!</span>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-success">
											<i class="fas fa-donate text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 7, 2019</div>
										$290.29 has been deposited into your account!
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-warning">
											<i class="fas fa-exclamation-triangle text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 2, 2019</div>
										Spending Alert: We've noticed unusually high spending for your
										account.
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Show All Alerts</a>
							</div></li>

						<!-- Nav Item - Messages -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i>
								<!-- Counter - Messages --> <span
								class="badge badge-danger badge-counter">7</span>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="messagesDropdown">
								<h6 class="dropdown-header">Message Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
										<div class="status-indicator bg-success"></div>
									</div>
									<div class="font-weight-bold">
										<div class="text-truncate">Hi there! I am wondering if
											you can help me with a problem I've been having.</div>
										<div class="small text-gray-500">Emily Fowler · 58m</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
										<div class="status-indicator"></div>
									</div>
									<div>
										<div class="text-truncate">I have the photos that you
											ordered last month, how would you like them sent to you?</div>
										<div class="small text-gray-500">Jae Chun · 1d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
										<div class="status-indicator bg-warning"></div>
									</div>
									<div>
										<div class="text-truncate">Last month's report looks
											great, I am very happy with the progress so far, keep up the
											good work!</div>
										<div class="small text-gray-500">Morgan Alvarez · 2d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
										<div class="status-indicator bg-success"></div>
									</div>
									<div>
										<div class="text-truncate">Am I a good boy? The reason I
											ask is because someone told me that people say this to all
											dogs, even if they aren't good...</div>
										<div class="small text-gray-500">Chicken the Dog · 2w</div>
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Read More Messages</a>
							</div></li>

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie
									Luna</span> <img class="img-profile rounded-circle"
								src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Settings
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">ECIB</h1>
					</div>



					<div class="row">

						<div class="col-lg-12">

							<!-- Dropdown Card Example -->
							<!-- Collapsable Card Example -->
							<div class="card shadow mb-4">
								<!-- Card Header - Accordion -->
								<a href="#collapseCardExample" class="d-block card-header py-3"
									data-toggle="collapse" role="button" aria-expanded="true"
									aria-controls="collapseCardExample">
									<h6 class="m-0 font-weight-bold text-primary">Issue
										Renewal</h6>
								</a>
								<!-- Card Content - Collapse -->
								<div class="collapse show" id="collapseCardExample">
									<div class="card-body">

										<form:form method="post"
											class="form-horizontal border border-dark p-3 mb-2 bg-white text-dark mt-5"
											role="form" action="updateIssueRenewal.htm" modelAttribute="issueRenewal">

											<div class="form-group">
												<label for="heading" class="col-sm-3 control-label"></label>
												<div class="col-sm-9"></div>
											</div>

											<div class="row">

												<div class="col-sm-9">
													<label for="heading" class="col-sm-3 control-label"><b>FRESH
															/ RENEWAL </b></label>
												</div>
												<div class="col-sm-3">
														<b>	Proposal Form Id: ${ proposalfrmid}</b>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-9"></div>
												<div class="col-sm-3">
															<label for="heading" class="col-sm-3 control-label"></label>
															<label for="heading" class="col-sm-3 control-label"></label>
												</div>
											</div>

											<div class="form-group">
												<div class="row justify-content-center align-items-center">
													<div class="col-sm-3"></div>
													<div class="col-sm-9">
														<label for="heading" class="col-sm-9 control-label"><b>PROPOSAL
																FOR EXPORT CREDIT INSURANCE FOR BANKS</b></label> <label
															for="heading" class="col-sm-9 control-label"><b>
																&nbsp; &nbsp; (WHOLE TURNOVER POST SHIPMENT-ECIB WT-PS)
														</b></label>
													</div>
												</div>
											</div>

											<div class="form-group">
												<div class="row">
													<div class="col-sm-3"></div>
													<div class="col-sm-9">
														<label for="heading">(To be submitted by the Head
															Office of the Bank to the Head Office of ECGC Ltd. </label> <label
															for="heading">&nbsp; &nbsp; together with a
															non-refundable processing fee of Rs 10,000/-)</label>
													</div>
												</div>
											</div>

											<div class="form-field">
												<div class="form-field__control">
													<label for="exampleField" class="form-field__label">We,
														<form:input id="exampleField" list="Bank-Name" type="text"
															class="form-field__input" placeholder="(Name of Bank)"
															path="bank_name" /> <datalist id="Bank-Name">
															<option value="Allahabad Bank" />
															<option value="Andhra Bank" />
															<option value="Axis Bank" />
															<option value="Bank of Bahrain and Kuwait" />
															<option value="Bank of Baroda - Corporate Banking" />
															<option value="Bank of Baroda - Retail Banking" />
															<option value="Bank of India" />
															<option value="Bank of Maharashtra" />
															<option value="Canara Bank">
															<option value="Central Bank of India" />
															<option value="City Union Bank" />
															<option value="Corporation Bank" />
															<option value="Deutsche Bank">
															<option value="Development Credit Bank" />
															<option value="Dhanlaxmi Bank" />
															<option value="Federal Bank" />
															<option value="ICICI Bank" />
															<option value="IDBI Bank" />
															<option value="Indian Bank" />
															<option value="Indian Overseas Bank" />
															<option value="IndusInd Bank" />
															<option value="ING Vysya Bank">
															<option value="Jammu and Kashmir Bank" />
															<option value="Karnataka Bank Ltd" />
															<option value="Karur Vysya Bank" />
															<option value="Kotak Bank" />
															<option value="Laxmi Vilas Bank" />
															<option value="Oriental Bank of Commerce" />
															<option value="Punjab National Bank - Corporate Banking" />
															<option value="Punjab National Bank - Retail Banking" />
															<option value="Punjab & Sind Bank" />
															<option value="Shamrao Vitthal Co-operative Bank" />
															<option value="South Indian Bank" />
															<option value="State Bank of Bikaner & Jaipur" />
															<option value="State Bank of Hyderabad" />
															<option value="State Bank of India" />
															<option value="State Bank of Mysore" />
															<option value="State Bank of Patiala" />
															<option value="State Bank of Travancore" />
															<option value="Syndicate Bank" />
															<option value="Tamilnad Mercantile Bank Ltd." />
															<option value="UCO Bank" />
															<option value="Union Bank of India" />
															<option value="United Bank of India" />
															<option value="Vijaya Bank" />
															<option value="Yes Bank Ltd" />
															<option value="Bank Of India" />
															<option value="Bank Of Maharashtra" />
															<option value="Bank Of Baroda" />
														</datalist> hereby apply for issuance of 
														<%-- <%if(issueRenewal.getCover_type().equals("1")) %> --%>
														<form:input
															id="exampleField" list="Fresh/Renewal"
															placeholder="insurance type" type="text"
															class="form-field__input" path="cover_type" />
														<datalist id="Fresh/Renewal">
															<option value="WT/PS" />
															<option value="WT/PC" />
														</datalist> of Export Credit Insurance for Banks(Whole Turnover Post
														shipment) ECIB(WT-PS) of the ECGC Ltd(formerly Export
														Credit Guarantee Corporation of India Limited)
													</label>
													<p>
														(herein after refer's to as the "Corporation") for a
														period of one year from

														<form:input id="exampleField" type="date"
															pattern="dd/MM/yyyy" class="form-field__input"
															path="from_date" />

														to


														<form:input id="exampleField" type="date"
															pattern="dd/MM/yyyy" class="form-field__input"
															path="to_date" />

														with a Maximum Liability of Rs
														<form:input id="exampleField" type="text"
															class="form-field__input" path="maximum_liability" />
														Crores.
													</p>
												</div>
											</div>

											<div class="form-field__control">
												<p>
													2. We furnish below information on the accounts:<br> <label
														for="heading" class="form-field__label"> </label> &nbsp;
													&nbsp;
												</p>
											</div>

											<table class="table table-bordered">
												<thead>
													<tr>
														<th>SL No</th>
														<th>Particulars</th>
														<th>No of Account</th>
														<th>Amount<br>(Rs in Lacs)
														</th>
													</tr>
												</thead>

												<tbody>
													<tr>
														<td>a</td>
														<td>Limit Approved as on 31.03.2017</td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input"
																path="no_of_limit_approved_acc" /></td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input"
																path="amt_of_limit_approved_acc" /></td>
													</tr>

													<tr>
														<td>b</td>
														<td>Defaults reported to ECGC as on 31.03.2017</td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input"
																path="no_of_acct_default_reported" /></td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input"
																path="amt_of_default_reported" /></td>
													</tr>

													<tr>
														<td>c</td>
														<td>No of SMA 2 account as on 31.03.2017</td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input" path="no_of_sma2_acc" /></td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input"
																path="amt_outstanding_of_sma2_acc" /></td>
													</tr>

													<tr>
														<td>d</td>
														<td>No of CDR accounts as on 31.03.2017</td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input" path="no_of_cdr_acc" /></td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input"
																path="amount_outstanding_cdr_accounts" /></td>
													</tr>

													<tr>
														<td>e</td>
														<td>Total outstanding under Post Shipment Accounts as
															on 31st March,2017</td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input"
																path="total_outstanding_under_pc_ps" /></td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input" path="total_outstanding_under_pc_ps" /></td>
													</tr>

													<tr>
														<td>f</td>
														<td>Anticipated level of average outstanding during
															the current year</td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input"
																path="anticipated_outstanding_in_current_year" /></td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input" path="anticipated_outstanding_in_current_year" /></td>
													</tr>

													<tr>
														<td>g</td>
														<td>Whether Small Scale Industrial Units/MSME are to
															be covered under the ECIB, <br>If yes
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <form:checkbox
																element="enable1" checked="checked"
																path="is_ssi_msme_covered"
																items="${is_ssi_msme_covered}" />
														</td>
														<td><form:input id="exampleField1"
																name="exampleField1" type="text"
																class="form-field__input"
																path="no_of_ssi_msme_acc_covered" /></td>
														<td><form:input id="exampleField2"
																name="exampleField2" type="text"
																class="form-field__input"
																path="amt_outstanding_for_ssi_msme" /></td>

													</tr>

													<tr>
														<td>h</td>
														<td>Whether Government Companies-are to be covered
															under the ECIB <br>If yes
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <form:checkbox
																element="enable2" checked="checked"
																path="is_govt_company_covered"
																items="${is_govt_company_covered}" />
														</td>
														<td><form:input id="exampleField3"
																name="exampleField3" type="text"
																class="form-field__input"
																path="no_of_govt_companies_covered" /></td>
														<td><form:input id="exampleField4"
																name="exampleField4" type="text"
																class="form-field__input"
																path="amt_outstanding_for_govt_company" /></td>
													</tr>

													<tr>
														<td>i</td>
														<td>Whether advances against Letters of Credit are
															covered under the ECIB, <br>If yes
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <form:checkbox
																element="enable3" checked="checked"
																path="is_adv_against_lc_covered"
																items="${is_adv_against_lc_covered}" />
														</td>
														<td><form:input id="exampleField5"
																name="exampleField5" type="text"
																class="form-field__input"
																path="no_of_acc_for_which_adv_against_lc_covered" /></td>
														<td><form:input id="exampleField6"
																name="exampleField6" type="text"
																class="form-field__input"
																path="amt_outstanding_from_adv_against_lc" /></td>
													</tr>

													<tr>
														<td>j</td>
														<td>Whether the Overseas Business Units(OBU) are to
															be covered under the ECIB, <br>If yes
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <form:checkbox
																element="enable4" checked="checked"
																path="is_obu_covered"
																items="${is_obu_covered}" />
														</td>
														<td><form:input id="exampleField7"
																name="exampleField7" type="text"
																class="form-field__input"
																path="no_of_obu_covered" /></td>
														<td><form:input id="exampleField8"
																name="exampleField8" type="text"
																class="form-field__input"
																path="amt_outstanding_for_obu" /></td>
													</tr>

													<tr>
														<td>k</td>
														<td>Whether advances against bills drawn on overseas
															Associates<br> are to be covered under the ECIB, If
															yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <form:checkbox
																element="enable5" checked="checked"
																path="is_adv_against_bills_covered"
																items="${is_adv_against_bills_covered}" />
														</td>
														<td><form:input id="exampleField9"
																name="exampleField9" type="text"
																class="form-field__input"
																path="no_of_acc_to_be_covrd_for_advances_against_bill_of_associate" /></td>
														<td><form:input id="exampleField10"
																name="exampleField10" type="text"
																class="form-field__input"
																path="amt_upto_which_adv_against_bill_covered" /></td>
													</tr>

													<tr>
														<td>l</td>
														<td>Considering the size of operations, the
															Discretionary<br> Limit desired by the bank for new
															accounts <br>(Max. Rs 100 Lakhs)(To be removed)
														</td>
														<td>N/A</td>
														<td><form:input id="exampleField" type="text"
																class="form-field__input"
																path="desired_dl_for_new_account" /></td>
													</tr>
												</tbody>
											</table>

											<div class="align-self-center mx-auto">
												<div class="row">
													<div class="col-sm-4"></div>
													<div class="col-sm-4">

														<form:input type="submit" value="Save"
															class="btn btn-success active" path="" />
														<a href="backToIndex.htm" class="btn btn-danger active">Cancel</a>

													</div>
													<div class="col-sm-4"></div>
												</div>

											</div>




										</form:form>




									</div>
								</div>
							</div>

						</div>

					</div>
					<div class="row">



						<div class="col-lg-12">

							<!-- Dropdown Card Example -->



							<!-- Footer -->
							<footer class="sticky-footer bg-white">
								<div class="container my-auto">
									<div class="copyright text-center my-auto">
										<span>Copyright &copy; Your Website 2019</span>
									</div>
								</div>
							</footer>
							<!-- End of Footer -->

						</div>
						<!-- End of Content Wrapper -->

					</div>
					<!-- End of Page Wrapper -->

					<!-- Scroll to Top Button-->
					<a class="scroll-to-top rounded" href="#page-top"> <i
						class="fas fa-angle-up"></i>
					</a>

					<!-- Logout Modal-->
					<div class="modal fade" id="logoutModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Ready to
										Leave?</h5>
									<button class="close" type="button" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								<div class="modal-body">Select "Logout" below if you are
									ready to end your current session.</div>
								<div class="modal-footer">
									<button class="btn btn-secondary" type="button"
										data-dismiss="modal">Cancel</button>
									<a class="btn btn-primary" href="login.html">Logout</a>
								</div>
							</div>
						</div>
					</div>

					<!-- Bootstrap core JavaScript-->

					<!-- Core plugin JavaScript-->
					<script
						src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

					<!-- Custom scripts for all pages-->
					<script
						src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

					<script type="text/javascript"
						src="webjars/jquery/3.0.0/jquery.min.js"></script>
					<script type="text/javascript"
						src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

					<script type="text/javascript">
						$(
								"input[name='is_ssi_msme_covered']")
								.click(
										function() {
											if ($(this).is(':checked')) {
												$("#exampleField1").attr(
														"disabled", false);
												$("#exampleField2").attr(
														"disabled", false);
											} else if ($(this).not(':checked')) {
												var ok = confirm('Are you sure you want to remove all data?');
												if (ok) {
													var remove = '';
													$("#exampleField1").val('');
													$("#exampleField2").val('');
													$("#exampleField1").attr(
															"disabled", true);
													$("#exampleField2").attr(
															"disabled", true);
												}
											}
										});
					</script>

					<script type="text/javascript">
						$("input[name='is_govt_company_covered']")
								.click(
										function() {
											if ($(this).is(':checked')) {
												$("#exampleField3").attr(
														"disabled", false);
												$("#exampleField4").attr(
														"disabled", false);
											} else if ($(this).not(':checked')) {
												var ok = confirm('Are you sure you want to remove all data?');
												if (ok) {
													var remove = '';
													$("#exampleField3").val('');
													$("#exampleField4").val('');
													$("#exampleField3").attr(
															"disabled", true);
													$("#exampleField4").attr(
															"disabled", true);
												}
											}
										});
					</script>

					<script type="text/javascript">
		$("input[name='is_adv_against_lc_covered']")
				.click(
						function() {
							if ($(this).is(':checked')) {
								$("#exampleField5").attr("disabled", false);
								$("#exampleField6").attr("disabled", false);
							} else if ($(this).not(':checked')) {
								var ok = confirm('Are you sure you want to remove all data?');
								if (ok) {
									var remove = '';
									$("#exampleField5").val('');
									$("#exampleField6").val('');
									$("#exampleField5").attr("disabled", true);
									$("#exampleField6").attr("disabled", true);
								}
							}
						});
	</script>

					<script type="text/javascript">
		$("input[name='is_obu_covered']").click(function() {
			if ($(this).is(':checked')) {
				$("#exampleField7").attr("disabled", false);
				$("#exampleField8").attr("disabled", false);
			} else if ($(this).not(':checked')) {
				var ok = confirm('Are you sure you want to remove all data?');
				if (ok) {
					var remove = '';
					$("#exampleField7").val('');
					$("#exampleField8").val('');
					$("#exampleField7").attr("disabled", true);
					$("#exampleField8").attr("disabled", true);
				}
			}
		});
	</script>

					<script type="text/javascript">
		$(
				"input[name='is_adv_against_bills_covered']")
				.click(
						function() {
							if ($(this).is(':checked')) {
								$("#exampleField9").attr("disabled", false);
								$("#exampleField10").attr("disabled", false);
							} else if ($(this).not(':checked')) {
								var ok = confirm('Are you sure you want to remove all data?');
								if (ok) {
									var remove = '';
									$("#exampleField9").val('');
									$("#exampleField10").val('');
									$("#exampleField9").attr("disabled", true);
									$("#exampleField10").attr("disabled", true);
								}
							}
						});
	</script>

					<script>
		var hidden = false;
		function action() {
			hidden = !hidden;
			if (hidden) {
				document.getElementById('update').style.visibility = 'hidden';
			} else {
				document.getElementById('togglee').style.visibility = 'visible';
			}
		}
	</script>
</body>

</html>
