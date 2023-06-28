

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta charset="UTF-8" /><meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport" /><title>
	Member Panel
</title>
    <!-- General CSS Files -->
    <link href="Assets/css/calendarajx.css" rel="stylesheet" /><link href="Assets/css/app.min.css" rel="stylesheet" /><link rel="stylesheet" href="Assets/css/app.min.css" /><link href="Assets/css/datatable-min.css" rel="stylesheet" /><link href="Assets/css/bootstrap4-min.css" rel="stylesheet" /><link rel="stylesheet" href="Assets/bundles/jqvmap/dist/jqvmap.min.css" /><link rel="stylesheet" href="Assets/bundles/weather-icon/css/weather-icons.min.css" /><link href="Assets/bundles/bootstrap-social/bootstrap-social.css" rel="stylesheet" /><link rel="stylesheet" href="Assets/bundles/weather-icon/css/weather-icons-wind.min.css" /><link rel="stylesheet" href="Assets/bundles/summernote/summernote-bs4.css" />
    <!-- Template CSS -->
    <link rel="stylesheet" href="Assets/css/style.css" /><link rel="stylesheet" href="Assets/css/components.css" />
    <!-- Custom style CSS -->
    <link rel="stylesheet" href="Assets/css/custom.css" /><link rel="shortcut icon" type="image/x-icon" href="Assets/img/favicon.ico" />
    <script src="Assets/js/Jquery3_4_1.js"></script>
    <script type="application/javascript">
        $(document).ready(function () {
            var pathname = window.location.pathname;
            $('.sidebar-menu > li > a[href="' + pathname + '"]').parent().addClass('active');
            var prm = Sys.WebForms.PageRequestManager.getInstance();
            prm.add_endRequest(function () {
                var pathname = window.location.pathname;
                $('.sidebar-menu > li > a[href="' + pathname + '"]').parent().addClass('active');
            });
        });

    </script>
    

    
    

    
    
    <style type="text/css">
.tooltip {
    position: relative;
    display: inline-block;
    border-bottom: 1px dotted black;
        opacity: 1;
        z-index:initial;
}

.tooltip .tooltiptext {
    visibility: hidden;
    width: 170px;
    background-color: black;
    color: #fff;
    text-align: center;
    border-radius: 6px;
   padding: 2px 5px 2px -10px; 

    /* Position the tooltip */
    position:absolute;
    z-index: 1;
}

.tooltip:hover .tooltiptext {
    visibility: visible;
}
</style>
</head>
<body>
    <form method="post" action="./MemberTree.aspx" id="form1">
<div class="aspNetHidden">
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="" />
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwULLTExNTQ3OTE3NzgPZBYCZg9kFgICAQ9kFg4CAQ8PFgIeCEltYWdlVXJsBSd+L01lbWJlci9pbWFnZXMvSU1HLTIwMjMwMTExLVdBMDAyMS5qcGdkZAICDxYCHglpbm5lcmh0bWwFEkhlbGxvICBSYXNtaXRhIERhc2QCBA8WAh8BBQtSYXNtaXRhIERhc2QCBQ8WAh8BBQxJRDogVFo0MzMzMzhkAgYPFgIfAQUMS1lDIEFwcHJvdmVkZAIID2QWAgIBDxYCHwEFTTxhIHN0eWxlPSdjb2xvcjpyZWQ7JyBocmVmPSdNZW1iZXJUcmVlLmFzcHg/TWVtYmVycz1UWjQzMzMzOCc+VFo0MzMzMzg8L2E+IHwgZAIJDw8WAh4EVGV4dAUUQ29weXJpZ2h0IEAgMjAyMyBCeSBkZGTIIj2ZmSZm0aapZ7A+MuhfKAmSyNUPxYzRxQ7SSuyX/w==" />
</div>

<script type="text/javascript">
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</script>


<div class="aspNetHidden">

	<input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="938F90D7" />
	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEdAAVuhcEkKfivglb1JGYi/8IqgUFlgNU1eucH/1aaMMUqPjmUxJr3noImSeetRExoxKMtQqKtbOVxArImloCc4e9RMndlphst4Fd4YZoH9PZlXdi+0ogydhd9gi18chj2p6Kxvd0WAKjXXriou5SoFO7a" />
</div>

        <div class="loader"></div>
        <div class="main-wrapper main-wrapper-1" style="background-color: #e4e3e3">
            <nav class="navbar navbar-expand-lg main-navbar">
                <div class="form-inline mr-auto">
                    <ul class="navbar-nav mr-3">
                        <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg
									collapse-btn"><i data-feather="align-justify"></i></a></li>
                        <li><a href="#" class="nav-link nav-link-lg fullscreen-btn">
                            <i data-feather="maximize"></i>
                        </a></li>
                        <li>
                            
                        </li>
                    </ul>
                </div>
                <ul class="navbar-nav navbar-right">
                    <li class="dropdown dropdown-list-toggle"><a href="#" data-toggle="dropdown"
                        class="nav-link nav-link-lg message-toggle"><i data-feather="mail"></i>
                        <span class="badge headerBadge1">6 </span></a>
                        <div class="dropdown-menu dropdown-list dropdown-menu-right pullDown">
                            <div class="dropdown-header">
                                Messages
                <div class="float-right">
                    <a href="#">Mark All As Read</a>
                </div>
                            </div>
                            <div class="dropdown-list-content dropdown-list-message">
                                
                            </div>
                            <div class="dropdown-footer text-center">
                                <a href="#">View All <i class="fas fa-chevron-right"></i></a>
                            </div>
                        </div>
                    </li>

                    <li class="dropdown"><a href="#" data-toggle="dropdown"
                        class="nav-link dropdown-toggle nav-link-lg nav-link-user">
                        <img id="imgUser" class="user-img-radious-style" src="images/IMG-20230111-WA0021.jpg" />

                        <span class="d-sm-none d-lg-inline-block"></span></a>
                        <div class="dropdown-menu dropdown-menu-right pullDown">
                            <div id="DivDropName" class="dropdown-title">Hello  Rasmita Das</div>

                            <a href="profile.aspx" class="dropdown-item has-icon"><i class="fa fa-user"></i>Profile</a>
                            <a href="ChangePassword.aspx" class="dropdown-item has-icon"><i class="fa fa-key"></i>Password(s)</a>
                            <a href="AddBank.aspx" class="dropdown-item has-icon"><i class="fa fa-university"></i>Bank Details</a>
                            <a href="KYC.aspx" class="dropdown-item has-icon"><i class="fa fa-file"></i>KYC</a>
                            <a href="WelcomeLetter.aspx" class="dropdown-item has-icon"><i class="fa fa-file-pdf"></i>Welcome Letter</a>
                            <a href='../Invoice.aspx?invoiceid=Oqzbvpd79kays5CaVnpqP YWGp3KmXi0PXmomaRpp8Y=' target="_blank" class="dropdown-item has-icon"><i class="fa fa-print"></i>Print Reciept</a>

                            <a href="#" class="dropdown-item has-icon"><i class="fa fa-id-card"></i>ID Card</a>
                            <a href="#" class="dropdown-item has-icon"><i class="fa fa-cog"></i>
                                Settings
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="../login.aspx" class="dropdown-item has-icon text-danger"><i class="fas fa-sign-out-alt"></i>
                                Logout
                            </a>
                        </div>
                    </li>
                </ul>
            </nav>
            <div class="main-sidebar sidebar-style-2">
                <aside id="sidebar-wrapper">
                    <div class="sidebar-brand">
                        <a href="../Default.aspx">
                            <img src="../login/Assets/img/products/logo.png" id="imglogo" alt="image" class="header-logo" />
                            
                          
                        </a>
                    </div>
                    <div class="sidebar-user">

                        <div class="sidebar-user-details">
                            <div id="DivUserName" class="user-name" style="color: white;">Rasmita Das</div>
                            <div id="DivRole" class="user-role">ID: TZ433338</div>
                            <div id="divkycstatus" class="user-role">KYC Approved</div>

                        </div>
                    </div>
                    <ul class="sidebar-menu">
                        <li class="menu-header">Main</li>
                        <li class="dropdown">
                            <a href="Default.aspx" class="nav-link"><i data-feather="monitor"></i><span>Dashboard</span></a>

                        </li>
                        <li class="dropdown">
                            <a href="../Registration.aspx" class="nav-link"><i data-feather="monitor"></i><span>New Registration</span></a>

                        </li>
                        
                        <li class="dropdown">
                            <a href="#" class="nav-link has-dropdown"><i data-feather="user"></i><span>Profile</span></a>
                            <ul class="dropdown-menu">
                                
                                

                                
                                <li><a class="nav-link" href="profile.aspx">Profile</a></li>
                                <li><a href="ChangePassword.aspx" class="link-page">Change Password</a></li>
                                <li><a class="nav-link" href="KYC.aspx">KYC</a></li>
                                <li><a class="nav-link" href="AddBank.aspx">Bank Details</a></li>
                                <li><a href="Card.aspx" class="link-page">ID Card</a></li>
                                <li><a class="nav-link" href="WelcomeLetter.aspx">Welcome Letter</a></li>
                                
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="nav-link has-dropdown"><i data-feather="dollar-sign"></i><span>Fund Management</span></a>
                            <ul class="dropdown-menu">

                                <li><a class="nav-link" href="AddFund.aspx">Add Fund</a></li>
                                
                                <li><a class="nav-link" href="RequestFund.aspx">Requested Fund</a></li>


                                <li><a class="nav-link" href="FundHistory.aspx">Fund  History</a></li>
                                <li><a class="nav-link" href="RankUpgrade.aspx">Upgrade Rank</a></li>
                            </ul>
                        </li>
                        

                        
                        
                        
                        
                        
                        <li class="dropdown">
                            <a href="#" class="nav-link has-dropdown"><i data-feather="slack"></i><span>My Network</span></a>
                            <ul class="dropdown-menu">

                                <li><a class="nav-link" href="MyDirects.aspx">My Direct</a></li>
                                <li><a class="nav-link" href="GenealogyLeftDownline.aspx">Left Downline</a></li>
                                <li><a class="nav-link" href="GenealogyRightDownline.aspx">Right Downline</a></li>
                                <li><a class="nav-link" href="TreeDetails.aspx">Generation Report</a></li>
                                <li><a class="nav-link" href="ReferLevelReport.aspx">Refer Level Report</a></li>
                               
                                <li><a class="nav-link" href="MemberTree.aspx">Member Tree</a></li>
                                <li><a class="nav-link" href="BusinessReport.aspx">Business Report</a></li>
                                <li><a class="nav-link" href="MonthLyBusinessReport.aspx">Monthly Business Report</a></li>

                            </ul>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="nav-link has-dropdown"><i data-feather="briefcase"></i><span>My Income</span></a>
                            <ul class="dropdown-menu">

                                <li><a class="nav-link" href="TransactionReport.aspx?type=Bonus Income">Performance Bonus</a></li>
                                <li><a class="nav-link" href="TransactionReport.aspx?type=Perfomance Bonus">Sales Performance Bonus</a></li>
                        
                                <li><a class="nav-link" href="TransactionReport.aspx?type=Referral Level Bonus">Referral Level Bonus</a></li>
                              
                           
                                </ul>
                        </li>
                      
                        <li class="hidden-sm hidden-md hidden-lg">
                            <a href="../products.aspx" class="nav-link"><i data-feather="gift"></i><span>Shopping</span></a>
                            
                        </li>
                        <li class="dropdown">
                            <a href="#" class="nav-link has-dropdown"><i data-feather="gift"></i><span>Order List</span></a>
                            <ul class="dropdown-menu">
                                <li><a class="nav-link" href="InvoiceList.aspx">Order List</a></li>
                                <li><a class="nav-link" href="PendingOrderList.aspx">Pending Order List</a></li>
                            </ul>
                        </li>

                        
                        <li class="dropdown">
                            <a href="#" class="nav-link has-dropdown"><i data-feather="gift"></i><span>Withdrawal</span></a>
                            <ul class="dropdown-menu">

                                
                                <li><a class="nav-link" href="Payout.aspx">Withdraw Report</a></li>
                                <li><a class="nav-link" href="MonthlyTdsReport.aspx">Monthly TDS</a></li>

                            </ul>
                        </li>
                        
                        <li class="dropdown">
                            <a href="#" class="nav-link has-dropdown"><i data-feather="settings"></i><span>Support</span></a>
                            <ul class="dropdown-menu">
                                <li><a class="nav-link" href="RaiseTicket.aspx">New Ticket</a></li>                              
                                <li><a class="nav-link" href="UserRaisedTicket.aspx">Ticket Report</a></li>
                                <li><a class="nav-link" href="TicketCompleted.aspx">Ticket Completed</a></li>
                            </ul>
                        </li>
                        <li class="hidden-sm hidden-md hidden-lg">
                            <a id="LinkButton1" href="javascript:__doPostBack(&#39;ctl00$LinkButton1&#39;,&#39;&#39;)">
                                   <i class="fa fa-sign-out"></i> Log Out
                            </a>
                        </li>
                    
                        
                        
                        
                    </ul>
                </aside>
                
            </div>
                   <script type="text/javascript" language="javascript"> history.pushState({ page: 1 }, "title 1", "#nbb"); window.onhashchange = function (event) { window.location.hash = "nbb"; };</script>
    <!-- start: PAGESLIDE LEFT -->
			
			
			<!-- end: PAGESLIDE LEFT -->
			<!-- start: PAGESLIDE RIGHT -->
			
			<!-- end: PAGESLIDE RIGHT -->
			<!-- start: MAIN CONTAINER -->
			<div class="main-container inner">
				<!-- start: PAGE -->
				<div class="main-content">
					<!-- start: PANEL CONFIGURATION MODAL FORM -->
					<div class="modal fade" id="panel-config" tabindex="-1" role="dialog" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
										&times;
									</button>
									<h4 class="modal-title">Panel Configuration</h4>
								</div>
								<div class="modal-body">
									Here will be a configuration form
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">
										Close
									</button>
									<button type="button" class="btn btn-primary">
										Save changes
									</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<!-- end: SPANEL CONFIGURATION MODAL FORM -->
					<div class="container" style="margin-left: 0%;">
						<!-- start: PAGE HEADER -->
						<!-- start: TOOLBAR -->
						
						<!-- end: TOOLBAR -->
						<!-- end: PAGE HEADER -->
						<!-- start: BREADCRUMB -->
						<div class="row">
							<div class="col-md-12">
								<ol class="breadcrumb">
									<li>
										<a href="#">
											Geneology
										</a>
									</li>
									<li class="active">
										Tree View
									</li>
								</ol>
							</div>
						</div>
						<!-- end: BREADCRUMB -->
						<!-- start: PAGE CONTENT -->
						<div class="row">
							
							<div class="col-md-12">
								   <ul id="ContentPlaceHolder1_NodeTrack" class="list-unstyled w3-padding-left"><a style='color:red;' href='MemberTree.aspx?Members=TZ433338'>TZ433338</a> | </ul>
								<!-- start: SELECT BOX PANEL -->
								<div class="panel panel-white" style="height: 906px; overflow:auto">
									<div class="panel-heading">
										
										<div class="panel-tools">
											<div class="dropdown">
												<a data-toggle="dropdown" class="btn btn-xs dropdown-toggle btn-transparent-grey">
													<i class="fa fa-cog"></i>
												</a>
												<ul class="dropdown-menu dropdown-light pull-right" role="menu">
													<li>
														<a class="panel-collapse collapses" href="#"><i class="fa fa-angle-up"></i> <span>Collapse</span> </a>
													</li>
													<li>
														<a class="panel-refresh" href="#">
															<i class="fa fa-refresh"></i> <span>Refresh</span>
														</a>
													</li>
													<li>
														<a class="panel-config" href="#panel-config" data-toggle="modal">
															<i class="fa fa-wrench"></i> <span>Configurations</span>
														</a>
													</li>
													<li>
														<a class="panel-expand" href="#">
															<i class="fa fa-expand"></i> <span>Fullscreen</span>
														</a>
													</li>
												</ul>
											</div>
											<a class="btn btn-xs btn-link panel-close" href="#">
												<i class="fa fa-times"></i>
											</a>
										</div>
									</div>
									<div class="panel-body">
                                        <center>
                                            <table>
                                                <tr>
                                                    <th>
                                                      
                                                     <a id="ContentPlaceHolder1_lnktop" href="javascript:__doPostBack(&#39;ctl00$ContentPlaceHolder1$lnktop&#39;,&#39;&#39;)">Go To Top ID</a>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>Enter Trackid : </th><td>
                                                        <input name="ctl00$ContentPlaceHolder1$txttrackid" type="text" id="ContentPlaceHolder1_txttrackid" /></td><td>
                                                            <input type="submit" name="ctl00$ContentPlaceHolder1$btnsearch" value="Search" id="ContentPlaceHolder1_btnsearch" /></td>
                                                </tr>
                                            </table>
                    
                        
                    
                    <div>
                        <table id="ContentPlaceHolder1_Table1" align="Center" style="width:100%;">
	<tr>
		<td align="center" colspan="8"><div class='tooltip'><img src='images/FemaleGreen.png' width='60px'><a href='MemberTree.aspx?Members=TZ433338'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>Rasmita Das</b><br>TZ433338<br></a><b style='color: #CC0000'>Left : 1538 | Right : 1294  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>Rasmita Das</td></tr><tr><td>Trackid : </td><td>TZ433338</td></tr><tr><td>Sponsor ID : </td><td>TZ123456</td></tr><tr><td>Sponsor Name : </td><td>TENZA MARKETING PVT LTD</td></tr><tr><td>Joining Date : </td><td>7/16/2022 1:43:53 PM</td></tr><tr><td>Activated On : </td><td>7/19/2022 4:31:15 PM</td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Active</td></tr><tr><td>Direct Member</td><td>230</td></tr><tr><td>Direct Active</td><td>141</td></tr><tr><tr><td>Left Total leg : </td><td>1538</td></tr><td>Left Active leg : </td><td>1225</td></tr>  <tr><td>Right Total leg : </td><td>1294</td></tr> <tr><td>Right Active leg : </td><td>950</td></tr><tr><td>Current Left Team RBV : </td><td>0</td></tr><tr><td>Current Right Team RBV : </td><td>110390</td></tr><tr><td>Current Self BV : </td><td>0</td></tr><tr><td>Total Left BV : </td><td>1255940</td></tr><tr><td>Total Right BV : </td><td>965400</td></tr><tr><td>Self BV : </td><td>5000.00</td></tr></table></div></div></td>
	</tr><tr>
		<td align="center" colspan="8"><img src='Images/line.png'  Width='50%'></td>
	</tr><tr>
		<td align="center" colspan="4"><div class='tooltip'><img src='images/FemaleGreen.png' width='60px'><a href='MemberTree.aspx?Members=TZ628072'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>r</b><br>TZ628072<br></a><b style='color: #CC0000'>Left : 1537 | Right : 0  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>r</td></tr><tr><td>Trackid : </td><td>TZ433338</td></tr><tr><td>Sponsor ID : </td><td>TZ123456</td></tr><tr><td>Sponsor Name : </td><td>TENZA MARKETING PVT LTD</td></tr><tr><td>Joining Date : </td><td>7/16/2022 1:52:17 PM</td></tr><tr><td>Activated On : </td><td>11/25/2022 6:04:28 PM</td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Active</td></tr><tr><td>Direct Member</td><td>0</td></tr><tr><td>Direct Active</td><td>0</td></tr><tr><tr><td>Left Total leg : </td><td>1537</td></tr><td>Left Active leg : </td><td>1224</td></tr>  <tr><td>Right Total leg : </td><td>0</td></tr> <tr><td>Right Active leg : </td><td>0</td></tr><tr><td>Current Left Team RBV : </td><td>0</td></tr><tr><td>Current Right Team RBV : </td><td>0</td></tr><tr><td>Current Self BV : </td><td>0</td></tr><tr><td>Total Left BV : </td><td>1254940</td></tr><tr><td>Total Right BV : </td><td>0</td></tr><tr><td>Self BV : </td><td>1000.00</td></tr></table></div></div></td><td align="center" colspan="4"><div class='tooltip'><img src='images/mangreen.png' width='60px'><a href='MemberTree.aspx?Members=TZ160418'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>SARAT KUMAR NAYAK</b><br>TZ160418<br></a><b style='color: #CC0000'>Left : 205 | Right : 1088  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>SARAT KUMAR NAYAK</td></tr><tr><td>Trackid : </td><td>TZ433338</td></tr><tr><td>Sponsor ID : </td><td>TZ433338</td></tr><tr><td>Sponsor Name : </td><td>Sunil Kaushik</td></tr><tr><td>Joining Date : </td><td>7/20/2022 7:31:50 AM</td></tr><tr><td>Activated On : </td><td>5/5/2023 11:08:45 PM</td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Active</td></tr><tr><td>Direct Member</td><td>5</td></tr><tr><td>Direct Active</td><td>4</td></tr><tr><tr><td>Left Total leg : </td><td>205</td></tr><td>Left Active leg : </td><td>97</td></tr>  <tr><td>Right Total leg : </td><td>1088</td></tr> <tr><td>Right Active leg : </td><td>852</td></tr><tr><td>Current Left Team RBV : </td><td>64150</td></tr><tr><td>Current Right Team RBV : </td><td>44240</td></tr><tr><td>Current Self BV : </td><td>2000</td></tr><tr><td>Total Left BV : </td><td>92950</td></tr><tr><td>Total Right BV : </td><td>869450</td></tr><tr><td>Self BV : </td><td>3000.00</td></tr></table></div></div></td>
	</tr><tr>
		<td align="center" colspan="4"><img src='Images/alllines.png' Width='50%'></td><td align="center" colspan="4"><img src='images/alllines.png' Width='50%'></td>
	</tr><tr>
		<td align="center" colspan="2"><div class='tooltip'><img src='images/mangreen.png' width='60px'><a href='MemberTree.aspx?Members=TZ402803'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>Sunil Kaushik</b><br>TZ402803<br></a><b style='color: #CC0000'>Left : 1536 | Right : 0  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>Sunil Kaushik</td></tr><tr><td>Trackid : </td><td>TZ628072</td></tr><tr><td>Sponsor ID : </td><td>TZ123456</td></tr><tr><td>Sponsor Name : </td><td>TENZA MARKETING PVT LTD</td></tr><tr><td>Joining Date : </td><td>7/16/2022 1:54:30 PM</td></tr><tr><td>Activated On : </td><td>4/14/2023 11:29:06 PM</td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Active</td></tr><tr><td>Direct Member</td><td>0</td></tr><tr><td>Direct Active</td><td>0</td></tr><tr><tr><td>Left Total leg : </td><td>1536</td></tr><td>Left Active leg : </td><td>1223</td></tr>  <tr><td>Right Total leg : </td><td>0</td></tr> <tr><td>Right Active leg : </td><td>0</td></tr><tr><td>Current Left Team RBV : </td><td>0</td></tr><tr><td>Current Right Team RBV : </td><td>0</td></tr><tr><td>Current Self BV : </td><td>0</td></tr><tr><td>Total Left BV : </td><td>1253940</td></tr><tr><td>Total Right BV : </td><td>0</td></tr><tr><td>Self BV : </td><td>1000.00</td></tr></table></div></div></td><td align="center" colspan="2"><img src='images/blank.png' width='60px'><a href='#' target='_blank'><Div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>Empty</b><br>Click to join<br></a><b style='color: #CC0000'>Left : 0 | Right : 0</b></Div></td><td align="center" colspan="2"><div class='tooltip'><img src='images/FemaleGreen.png' width='60px'><a href='MemberTree.aspx?Members=TZ753975'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>SUMATI NAYAK</b><br>TZ753975<br></a><b style='color: #CC0000'>Left : 57 | Right : 147  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>SUMATI NAYAK</td></tr><tr><td>Trackid : </td><td>TZ160418</td></tr><tr><td>Sponsor ID : </td><td>TZ160418</td></tr><tr><td>Sponsor Name : </td><td>SARAT KUMAR NAYAK</td></tr><tr><td>Joining Date : </td><td>4/27/2023 1:28:46 PM</td></tr><tr><td>Activated On : </td><td>5/16/2023 9:18:56 PM</td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Active</td></tr><tr><td>Direct Member</td><td>15</td></tr><tr><td>Direct Active</td><td>7</td></tr><tr><tr><td>Left Total leg : </td><td>57</td></tr><td>Left Active leg : </td><td>12</td></tr>  <tr><td>Right Total leg : </td><td>147</td></tr> <tr><td>Right Active leg : </td><td>84</td></tr><tr><td>Current Left Team RBV : </td><td>0</td></tr><tr><td>Current Right Team RBV : </td><td>64150</td></tr><tr><td>Current Self BV : </td><td>0</td></tr><tr><td>Total Left BV : </td><td>12000</td></tr><tr><td>Total Right BV : </td><td>79950</td></tr><tr><td>Self BV : </td><td>1000.00</td></tr></table></div></div></td><td align="center" colspan="2"><div class='tooltip'><img src='images/male.png' width='60px'><a href='MemberTree.aspx?Members=TZ761059'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>BHAGABATAT TUDU</b><br>TZ761059<br></a><b style='color: #CC0000'>Left : 0 | Right : 1087  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>BHAGABATAT TUDU</td></tr><tr><td>Trackid : </td><td>TZ160418</td></tr><tr><td>Sponsor ID : </td><td>TZ433338</td></tr><tr><td>Sponsor Name : </td><td>Sunil Kaushik</td></tr><tr><td>Joining Date : </td><td>7/20/2022 7:33:02 AM</td></tr><tr><td>Activated On : </td><td></td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Inactive</td></tr><tr><td>Direct Member</td><td>0</td></tr><tr><td>Direct Active</td><td>0</td></tr><tr><tr><td>Left Total leg : </td><td>0</td></tr><td>Left Active leg : </td><td>0</td></tr>  <tr><td>Right Total leg : </td><td>1087</td></tr> <tr><td>Right Active leg : </td><td>852</td></tr><tr><td>Current Left Team RBV : </td><td>0</td></tr><tr><td>Current Right Team RBV : </td><td>44240</td></tr><tr><td>Current Self BV : </td><td>0</td></tr><tr><td>Total Left BV : </td><td>0</td></tr><tr><td>Total Right BV : </td><td>869450</td></tr><tr><td>Self BV : </td><td>0.00</td></tr></table></div></div></td>
	</tr><tr>
		<td align="center" colspan="2"><img src='Images/alllines.png' Width='50%'></td><td align="center" colspan="2"><img src='images/alllines.png' Width='50%'></td><td align="center" colspan="2"><img src='images/alllines.png' Width='50%'></td><td align="center" colspan="2"><img src='images/alllines.png' Width='50%'></td>
	</tr><tr>
		<td align="center" colspan="1"><div class='tooltip'><img src='images/FemaleGreen.png' width='60px'><a href='MemberTree.aspx?Members=TZ200912'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>t</b><br>TZ200912<br></a><b style='color: #CC0000'>Left : 1535 | Right : 0  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>t</td></tr><tr><td>Trackid : </td><td>TZ402803</td></tr><tr><td>Sponsor ID : </td><td>TZ123456</td></tr><tr><td>Sponsor Name : </td><td>TENZA MARKETING PVT LTD</td></tr><tr><td>Joining Date : </td><td>7/16/2022 1:55:55 PM</td></tr><tr><td>Activated On : </td><td>4/14/2023 11:29:02 PM</td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Active</td></tr><tr><td>Direct Member</td><td>0</td></tr><tr><td>Direct Active</td><td>0</td></tr><tr><tr><td>Left Total leg : </td><td>1535</td></tr><td>Left Active leg : </td><td>1222</td></tr>  <tr><td>Right Total leg : </td><td>0</td></tr> <tr><td>Right Active leg : </td><td>0</td></tr><tr><td>Current Left Team RBV : </td><td>0</td></tr><tr><td>Current Right Team RBV : </td><td>0</td></tr><tr><td>Current Self BV : </td><td>0</td></tr><tr><td>Total Left BV : </td><td>1252940</td></tr><tr><td>Total Right BV : </td><td>0</td></tr><tr><td>Self BV : </td><td>1000.00</td></tr></table></div></div></td><td align="center" colspan="1"><img src='images/blank.png' width='60px'><a href='#' target='_blank'><Div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>Empty</b><br>Click to join<br></a><b style='color: #CC0000'>Left : 0 | Right : 0</b></Div></td><td align="center" colspan="1"><img src='images/blank.png' width='60px'><a href='#'><Div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>Empty</b><br>No Member<br></a><b style='color: #CC0000'>Left : 0 | Right : 0</b></Div></td><td align="center" colspan="1"><img src='images/blank.png' width='60px'><a href='#'><Div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>Empty</b><br>No Member<br></a><b style='color: #CC0000'>Left : 0 | Right : 0</b></Div></td><td align="center" colspan="1"><div class='tooltip'><img src='images/mangreen.png' width='60px'><a href='MemberTree.aspx?Members=TZ672515'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>BRAJAMOHAN DALAI</b><br>TZ672515<br></a><b style='color: #CC0000'>Left : 56 | Right : 0  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>BRAJAMOHAN DALAI</td></tr><tr><td>Trackid : </td><td>TZ753975</td></tr><tr><td>Sponsor ID : </td><td>TZ753975</td></tr><tr><td>Sponsor Name : </td><td>SARAT KUMAR NAYAK</td></tr><tr><td>Joining Date : </td><td>4/27/2023 1:40:37 PM</td></tr><tr><td>Activated On : </td><td>5/16/2023 5:33:45 PM</td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Active</td></tr><tr><td>Direct Member</td><td>1</td></tr><tr><td>Direct Active</td><td>0</td></tr><tr><tr><td>Left Total leg : </td><td>56</td></tr><td>Left Active leg : </td><td>11</td></tr>  <tr><td>Right Total leg : </td><td>0</td></tr> <tr><td>Right Active leg : </td><td>0</td></tr><tr><td>Current Left Team RBV : </td><td>0</td></tr><tr><td>Current Right Team RBV : </td><td>0</td></tr><tr><td>Current Self BV : </td><td>0</td></tr><tr><td>Total Left BV : </td><td>11000</td></tr><tr><td>Total Right BV : </td><td>0</td></tr><tr><td>Self BV : </td><td>1000.00</td></tr></table></div></div></td><td align="center" colspan="1"><div class='tooltip'><img src='images/FemaleGreen.png' width='60px'><a href='MemberTree.aspx?Members=TZ386942'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>DHARITRI MAHALIK</b><br>TZ386942<br></a><b style='color: #CC0000'>Left : 85 | Right : 61  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>DHARITRI MAHALIK</td></tr><tr><td>Trackid : </td><td>TZ753975</td></tr><tr><td>Sponsor ID : </td><td>TZ753975</td></tr><tr><td>Sponsor Name : </td><td>SUMATI NAYAK</td></tr><tr><td>Joining Date : </td><td>5/21/2023 12:14:59 PM</td></tr><tr><td>Activated On : </td><td>5/21/2023 11:07:19 PM</td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Active</td></tr><tr><td>Direct Member</td><td>16</td></tr><tr><td>Direct Active</td><td>10</td></tr><tr><tr><td>Left Total leg : </td><td>85</td></tr><td>Left Active leg : </td><td>49</td></tr>  <tr><td>Right Total leg : </td><td>61</td></tr> <tr><td>Right Active leg : </td><td>34</td></tr><tr><td>Current Left Team RBV : </td><td>40950</td></tr><tr><td>Current Right Team RBV : </td><td>23200</td></tr><tr><td>Current Self BV : </td><td>0</td></tr><tr><td>Total Left BV : </td><td>46950</td></tr><tr><td>Total Right BV : </td><td>32000</td></tr><tr><td>Self BV : </td><td>1000.00</td></tr></table></div></div></td><td align="center" colspan="1"><img src='images/blank.png' width='60px'><a href='#' target='_blank'><Div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>Empty</b><br>Click to join<br></a><b style='color: #CC0000'>Left : 0 | Right : 0</b></Div></td><td align="center" colspan="1"><div class='tooltip'><img src='images/male.png' width='60px'><a href='MemberTree.aspx?Members=TZ678706'><div class='MemberTree'  align='center'> <b style='color:#000066;font-size: 14px;'>satendra</b><br>TZ678706<br></a><b style='color: #CC0000'>Left : 0 | Right : 1086  </b></div><div class='tooltiptext' style='width:250px; text-align : left;'><table style='width: 250px;'><tr><td>Name : </td><td>satendra</td></tr><tr><td>Trackid : </td><td>TZ761059</td></tr><tr><td>Sponsor ID : </td><td>TZ433338</td></tr><tr><td>Sponsor Name : </td><td>Sunil Kaushik</td></tr><tr><td>Joining Date : </td><td>7/20/2022 7:34:10 AM</td></tr><tr><td>Activated On : </td><td></td></tr><tr><td>Package : </td><td> (0) </td></tr><tr><td>Status : </td><td>Inactive</td></tr><tr><td>Direct Member</td><td>0</td></tr><tr><td>Direct Active</td><td>0</td></tr><tr><tr><td>Left Total leg : </td><td>0</td></tr><td>Left Active leg : </td><td>0</td></tr>  <tr><td>Right Total leg : </td><td>1086</td></tr> <tr><td>Right Active leg : </td><td>852</td></tr><tr><td>Current Left Team RBV : </td><td>0</td></tr><tr><td>Current Right Team RBV : </td><td>44240</td></tr><tr><td>Current Self BV : </td><td>0</td></tr><tr><td>Total Left BV : </td><td>0</td></tr><tr><td>Total Right BV : </td><td>869450</td></tr><tr><td>Self BV : </td><td>0.00</td></tr></table></div></div></td>
	</tr>
</table>
                    </div>
                    
                    <!--/End Software-->
               
 </center>
									</div>
								</div>
								<!-- end: SELECT BOX PANEL -->
							</div>
						</div>
						<!-- end: PAGE CONTENT-->
					</div>
					<div class="subviews">
						<div class="subviews-container"></div>
					</div>
				</div>
				<!-- end: PAGE -->
			</div>
			<!-- end: MAIN CONTAINER -->
			<!-- start: FOOTER -->

            <footer class="main-footer">
                <div class="footer-left">
                    <span id="lblFooterText">Copyright @ 2023 By </span>
                    </div>
                    
                    <div class="footer-right">
                    </div>
                    </div>
            </footer>
            <script src="Assets/js/app.min.js"></script>
            <!-- JS Libraies -->
            <script src="Assets/bundles/echart/echarts.js"></script>
            <script src="Assets/bundles/chartjs/chart.min.js"></script>
            <!-- Page Specific JS File -->
            <script src="Assets/js/page/index.js"></script>
            <!-- Template JS File -->
            <script src="Assets/js/scripts.js"></script>
            <!-- Custom JS File -->
            <script src="Assets/js/custom.js"></script>
            <!-- General JS Scripts -->

            <!-- JS Libraies -->
            <!-- Page Specific JS File -->
            <script src="Assets/bundles/datatables/datatables.min.js"></script>
            <script src="Assets/bundles/datatables/DataTables-1.10.16/js/dataTables.bootstrap4.min.js"></script>
            <script src="Assets/bundles/datatables/export-tables/dataTables.buttons.min.js"></script>
            <script src="Assets/bundles/datatables/export-tables/buttons.flash.min.js"></script>
            <script src="Assets/bundles/datatables/export-tables/jszip.min.js"></script>
            <script src="Assets/bundles/datatables/export-tables/pdfmake.min.js"></script>
            <script src="Assets/bundles/datatables/export-tables/vfs_fonts.js"></script>

            <script src="Assets/bundles/datatables/export-tables/buttons.print.min.js"></script>
            <script src="Assets/js/page/datatables.js"></script>



            <script type="application/javascript">
                $(document).ready(function () {

                    $(function () {
                        $('.categoryimgpop').on('click', function () {
                            $('.imagepreview').attr('src', $(this).find('img').attr('src'));
                            $('#imagemodal').modal('show');
                        });

                        $('[data-toggle="tooltip"]').tooltip()
                    });

                    var prm = Sys.WebForms.PageRequestManager.getInstance();

                    prm.add_endRequest(function () {
                        $(function () {
                            $('.categoryimgpop').on('click', function () {
                                $('.imagepreview').attr('src', $(this).find('img').attr('src'));
                                $('#imagemodal').modal('show');
                            });

                            $('[data-toggle="tooltip"]').tooltip()
                        });
                    });
                });
            </script>
        </div>
    </form>
    <div class="modal fade" id="imagemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" data-dismiss="modal">
            <div class="modal-content">
                <div class="modal-header" style="padding: 0px; border-bottom: 0px;">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>

                <div class="modal-body text-center" style="padding-top: 0px;">
                    <img class="imagepreview" style="max-width: 100%;" />
                </div>
            </div>
        </div>
    </div>

    <script src="/css/js/select2.full.min.js"></script>
    <script type="application/javascript">
        $(document).ready(function () {
            $('.select2').select2();
            var prm = Sys.WebForms.PageRequestManager.getInstance();
            prm.add_endRequest(function () {
                $('.select2').select2();
            });
        });
    </script>

</body>
</html>