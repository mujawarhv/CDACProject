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

<title>ECGC</title>

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
						<a class="collapse-item" href="login.htm">Login</a>
						<div class="collapse-divider"></div>

						<a class="collapse-item" href="prep-priliminary-scrutiny.htm">ECIB</a>
            <a class="collapse-item" href="banklogin.htm">Bank Login</a> 	</div>
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



										<form:form method="post" action="officenotegeneration.htm"
											class="form-horizontal border border-dark p-3 mb-2 bg-white text-dark mt-5"
											role="form" modelAttribute="issueRenewal">
											<div class="row">

												<div class="col-sm-9">
													<%
														String proposalfrmid = (String) session.getAttribute("wt_isrn_proposal_frm_id");
															out.print("Proposal Id:-" + proposalfrmid);
													%>
												</div>
												<div class="col-sm-3">

													<%
														String str = (String) session.getAttribute("name");
															out.print(str);
													%>

												</div>
											</div>

											<div class="form-group">
												<div class="row">
													<div class="col-sm-5"></div>

													<div class="col-sm-4">
														<label for="heading" class="col-sm-3 control-label"></label>
													</div>
													<div class="col-sm-3"></div>
												</div>
											</div>


											<div class="form-group">
												<div class="row">
													<div class="col-sm-5">
														<label for="heading" class="col-sm-3 control-label">Office
															Note PS</label>
													</div>

													<div class="col-sm-4">
														<label for="heading" class="col-sm-3 control-label"></label>
													</div>
													<div class="col-sm-3"></div>
												</div>
											</div>



											<div class="form-group">
												<div class="row">
													<div class="col-sm-12">

														<label for="heading" class="col-sm-3 control-label">Inward
															number</label>${issueRenewal.inward_id} </br> <label for="heading"
															class="col-sm-3 control-label">Inward item number</label>2
														</br> <label for="heading" class="col-sm-3 control-label">Inward
															date</label>27/12/2019 </br> <label for="heading"
															class="col-sm-3 control-label">ECGC branch</label>${issueRenewal.ecgc_branch_code}</br>




														<label for="heading" class="col-sm-3 control-label">Bank
															code</label> ${issueRenewal.bank_code }</br> <label for="heading"
															class="col-sm-3 control-label">Bank name</label>${issueRenewal.bank_name }
														</br> <label for="heading" class="col-sm-3 control-label">Accounts
															good as on date</label>1500 </br> <label for="heading"
															class="col-sm-3 control-label">Total outstanding
															amount as on date</label>15000 </br> <label for="heading"
															class="col-sm-3 control-label">Anticipated total
															outstanding amount for coming year</label>${issueRenewal.anticipated_outstanding_in_current_year }</br>


														<label for="heading" class="col-sm-3 control-label">Stamped/signed</label>yes


														</br> <label for="heading" class="col-sm-3 control-label">Proposal
															date</label>27/12/2019 </br> <label for="heading"
															class="col-sm-3 control-label">Annexure 2(i)
															attached</label>${issueRenewal.annex_of_cdr_acc_attached ? 'Yes' : 'No'}
														</br> <label for="heading" class="col-sm-3 control-label">Annexure
															2(ii) attached</label>${issueRenewal.annex_of_cdr_acc_attached ? 'Yes' : 'No'}
														</br> <label for="heading" class="col-sm-3 control-label">Annexure
															3 attached</label>${issueRenewal.annex_of_cdr_acc_attached ? 'Yes' : 'No'}
														</br> <label for="heading" class="col-sm-3 control-label">Remarks</label>ECGC
														</br>


													</div>
												</div>
											</div>

											<div class="form-group">
												<div class="row">
													<div class="col-sm-12">

														<table class="table table-bordered">
															<thead>
																<label><b>LC Details </b></label>
															</thead>
															<thead>
																<tr>
																	<th class="th-sm">No of LC accounts</th>
																	<th class="th-sm">Total limit (Rs in lacs)</th>
																	<th class="th-sm">Total outstanding (Rs in lacs)</th>
																	<th class="th-sm">No of default accounts</th>
																	<th class="th-sm">Default amount</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																	<td><label for="heading" class="control-label">2525</label></td>
																	<td><label for="heading" class="control-label">725</label></td>
																	<td><label for="heading" class="control-label">785725</label></td>
																	<td><label for="heading" class="control-label">240</label></td>
																	<td><label for="heading" class="control-label">58757</label></td>

																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>




											<div class="form-group">
												<div class="row">
													<div class="col-sm-12">

														<table class="table table-bordered">
															<thead>
																<label><b>PSU Details</b></label>




																<thead>
															
															<thead>
																<tr>
																	<th>No of PSU</th>
																	<th>Total limit (Rs in Lacs)</th>
																	<th>Total outstanding (Rs in Lacs)</th>
																	<th>No. of default accounts</th>
																	<th>Default amount</th>
																</tr>
															</thead>
															<tbody>
															<tr>
																<td><label for="heading" class="control-label">2525</label></td>
															<td><label for="heading" class="control-label">725</label></td>
															<td><label for="heading" class="control-label">785725</label></td>
															<td><label for="heading" class="control-label">240</label></td>
															<td><label for="heading" class="control-label">58757</label></td>
																
																</tr>
															</tbody>

														</table>
													</div>
												</div>
											</div>


											<div class="form-group">
												<div class="row">
													<div class="col-sm-12">

														<table class="table table-bordered">
															<thead>
																<label><b>SSI details</b></label>
															
															<thead>
															
															<thead>
																<tr>
																	<th>No of SSI units</th>
																	<th>Total limit (Rs in Lacs)</th>
																	<th>Total outstanding (Rs in Lacs)</th>
																	<th>No. of default accounts</th>
																	<th>Default amount</th>
																</tr>
															</thead>
															<tbody>
															<tr>
																<td><label for="heading" class="control-label">2525</label></td>
															<td><label for="heading" class="control-label">725</label></td>
															<td><label for="heading" class="control-label">785725</label></td>
															<td><label for="heading" class="control-label">240</label></td>
															<td><label for="heading" class="control-label">58757</label></td>
																
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>


											<div class="form-group">
												<div class="row">
													<div class="col-sm-12">
														<table class="table table-bordered">
															<thead>
																<label><b>Past experience with bank branch
																		(for 3 years)</b></label>
															
															<thead>
															
															<thead>
																<tr>
																	<th>All accounts</th>
																	<th>Amount of claim paid</th>
																	<th>Amount of claim pending</th>
																	<th>Claim amount pending for recovery</th>
																	<th>Claim amount recovered</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																<td><label for="heading" class="control-label">2525</label></td>
															<td><label for="heading" class="control-label">725</label></td>
															<td><label for="heading" class="control-label">785725</label></td>
															<td><label for="heading" class="control-label">240</label></td>
															<td><label for="heading" class="control-label">58757</label></td>
																
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>


											<div class="form-group">
												<div class="row">
													<div class="col-sm-12">
														<table class="table table-bordered">
															<thead>
																<label><b>Past experience with bank branch
																		(for 3 years)</b></label>
															
															<thead>
															
															<thead>
																<tr>
																	<th>Discretionary limit</th>
																	<th>Max liability</th>
																	<th>Number of claim cases pending for recovery</th>
																	<th>Number of claims paid</th>
																	<th>Number of claims pending</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																<td><label for="heading" class="control-label">2525</label></td>
															<td><label for="heading" class="control-label">725</label></td>
															<td><label for="heading" class="control-label">785725</label></td>
															<td><label for="heading" class="control-label">240</label></td>
															<td><label for="heading" class="control-label">58757</label></td>
																
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>


											<div class="form-group">
												<div class="row">
													<div class="col-sm-12">
														<table class="table table-bordered">
															<thead>
																<label><b>Past experience with bank branch
																		(for 3 years)</b></label>
															
															<thead>
															
															<thead>
																<tr>
																	<th>Number of defaults reported</th>
																	<th>Outstanding</th>
																	<th>Premium claim ratio</th>
																	<th>Premium income</th>
																	<th>PSU accounts</th>
																</tr>
															</thead>
															<tbody>
															<tr>
																<td><label for="heading" class="control-label">2525</label></td>
															<td><label for="heading" class="control-label">725</label></td>
															<td><label for="heading" class="control-label">785725</label></td>
															<td><label for="heading" class="control-label">240</label></td>
															<td><label for="heading" class="control-label">58757</label></td>
																
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>

											<div class="form-group">
												<div class="row">
													<div class="col-sm-12">
														<table class="table table-bordered">
															<thead>
																<label><b>Past experience with bank branch
																		(for 3 years)</b></label>
															
															<thead>
															
															<thead>
																<tr>
																	<th>Risk value</th>
																	<th>SSI Accounts</th>
																	<th>Risk value</th>
																	<th>Total limit in respect of all accounts</th>
																	<th>Total premium paid since issue of Cover</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																<td><label for="heading" class="control-label">2525</label></td>
															<td><label for="heading" class="control-label">725</label></td>
															<td><label for="heading" class="control-label">785725</label></td>
															<td><label for="heading" class="control-label">240</label></td>
															<td><label for="heading" class="control-label">58757</label></td>
																
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>



											<div class="form-group">
												<div class="row">
													<div class="col-sm-12">
														<table class="table table-bordered">
															<thead>
																<label><b>Past experience with bank branch
																		(for 3 years)</b></label>
															
															<thead>
															
															<thead>
																<tr>

																	<th>Total value of default during the year</th>
																	<th>Value of report default</th>
																	<th>Year I (mm/dd/yyyy)</th>
																	<th>Year II (mm/dd/yyyy)</th>
																	<th>Year III (mm/dd/yyyy)</th>

																</tr>
															</thead>
															<tbody>
																<tr>
																<td><label for="heading" class="control-label">2525</label></td>
															<td><label for="heading" class="control-label">725</label></td>
															<td><label for="heading" class="control-label">785725</label></td>
															<td><label for="heading" class="control-label">240</label></td>
															<td><label for="heading" class="control-label">58757</label></td>
																
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>


											<div class="form-group">
												<div class="row">
													<div class="col-sm-6"></div>
													<div class="col-sm-6">
														<label for="heading" class="col-sm-3 control-label">Generated
															BY</label><br> <label for="heading"
															class="col-sm-3 control-label">Date:-</label><br>
															<input type="submit" class="btn btn-danger"
															value="Generate OfficeNote" onclick="window.print()">
																<a href="cancelPreliminaryScrutinypage.htm"
															class="btn btn-danger active form-actions">Cancel</a>
													</div>
													
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

					<script>
		function genPDF() {
			const element = document.getElementById("maindiv");
			var doc = new jsPDF('p', 'mm', 'a4');
			var specialElementHandlers = {
				'#maindiv' : function(element, render) {
					return true;
				}
			};

			doc.fromHTML($('#maindiv').get(0), 20, 20, {
				'width' : 500,
				'elementHandlers' : specialElementHandlers
			});
			
			doc.setFontSize(26);
			doc.setTextColor(92, 76, 76);
			doc.save('test.pdf');
		}
	</script>
				</div>
			</div>
		</div>
	</div>

</body>

</html>
