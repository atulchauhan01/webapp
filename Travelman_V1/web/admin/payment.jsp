<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Payment Entry</title>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/wysiwyg.css" rel="stylesheet" type="text/css" />
<!-- Theme Start -->  
<link href="themes/blue/styles.css" rel="stylesheet" type="text/css" />

<!-- Theme End -->
<script language="javascript" type="text/javascript" src="scripts/datetimepicker.js"></script>
</head>
<body id="homepage">
	<div id="header">
    	<a href="" title=""><img src="img/cp_logo.png" alt="Control Panel" class="logo" /></a>
    	
    	
    </div>
    	
    	
 
        
    <!-- Top Breadcrumb Start -->
    
    <!-- Top Breadcrumb End -->
     
    <!-- Right Side/Main Content Start -->
    <div id="rightside">

			<!-- Status Bar Start -->







			<!-- Alternative Content Box Start -->
			<div class="contentcontainer">
				<div class="headings altheading">
					<h2>
					Enter Payment 
					</h2>
				</div>
				<div class="contentbox">
                                    <table width="100%">
                        <s:form action="savePayment" method="post">
                            <thead>
                               
                            </thead>
                            <tbody>          
                                <tr><s:textfield type="text" name="accNo" label="Account Number" readonly="true"/></tr>
                                
                                <tr><s:select list="list" name="deviceId" label="Device Id"/></tr>

                                <tr><s:textfield type="text" name="netAmount" label="Amount"/></tr>
                                
                                <tr><s:select list="# {'1':'Cash','2':'Cheque','3':'Demand Draft','4':'PO' }" name="paymentMode" label="Mode OF Payment"/></tr>

                                <tr><s:textfield type="text" name="paymentDate" label="date"/></tr>
                                <!--<tr><td>Payment Date</td><td><input type="Text" name="paymentDate" id="demo1" maxlength="25" size="25" readonly="true   "/><a href="javascript:NewCal('demo1','ddmmmyyyy')"><img src="img/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></td></tr>
                                -->
                                <tr><s:textfield type="text" name="receivedAmt" label="Recevied Amount"/></td></tr>
                                
                                <tr><s:textfield type="text" name="chqDdNo" label="Chq/PO/DD Number"/></td></tr>
                                
                                <tr><s:textfield type="text" name="bankName" label="Bank Nme"/></td></tr>
                                
                                <tr><s:textfield type="text" name="branchName" label="Bank Branch"/></td></tr>
                                
                                <tr><s:select list="{'abc1','abc2','abc3'}" name="offerName" label="Offer"/></tr>
                                
                                <tr><s:textfield type="text" name="offerAmt" label="Offer Amount"/></td></tr>
                                
                                <tr><s:textfield type="text" name="adjusment" label="Adjusment"/></td></tr>
                                
                                <tr><s:textfield type="text" name="discount" label="Discount"/></td></tr>
                                
                                <tr><s:textfield type="text" name="couponNo" label="Coupon Number"/></td></tr>
                                
                                <tr><s:textfield type="text" name="couponDiscount" label="couponDiscount"/></td></tr>
                      
                               <s:submit value="Save" ></s:submit>
                            </tbody>
                        </s:form>
                    </table>
					
					<div class="extrabottom">
						<ul>
							<li>
								<p class="userbtn">
									
								</p>
							</li>
						</ul>
						<div class="bulkactions">

						</div>
					</div>

					<div style="clear: both;"></div>
				</div>

			</div>


			<div style="clear: both;"></div>


			<div id="footer">
				&copy; Copyright 2011, Techno Life. All Rights
				Reserved.
			</div>

		</div>
    <!-- Right Side/Main Content End -->
    
        <!-- Left Dark Bar Start -->
    <div id="leftside">
            <div class="user">
                <img src="img/avatar.png" width="44" height="44" class="hoverimg" alt="Avatar" />
                <p>Logged in as:</p>
                <p class="username"><s:property value="currentUserName" ></s:property></p>
                <p class="userbtn"><a href="<s:url action="logout"/>">Log out</a></p>
            </div>




            <ul id="nav">
                <li>
                    <ul class="navigation">
                        <li class="heading selected">User Management</li>
                        <li><a href="home" title="">Home</a></li>
                    </ul>
                </li>
                <li>
                    <a class="collapsed heading">Tracking</a>
                    <ul class="navigation">
                        <li><a href="liveTracking" title="">Live Tracking</a></li>
                        <li><a href="historyTracking" title="">History Tracking</a></li>
                    </ul>
                </li>     
                <li><a class="expanded heading">Administrative</a>
                    <ul class="navigation">
                        <li><a href="<s:url action="addUser"/>">User Management</a></li>
                    
                    <li><a href="<s:url action="deviceMgtAction"/>" title="" class="likelogin">Device Management</a></li>
                    <li><a href="<s:url action="vehicleMgtAction"/>" title="" class="likelogin">Vehicle Management</a></li>
                        
                    </ul>
                </li>    
                <li><a class="collapsed heading">Notification </a>
                    <ul class="navigation">
                        <li><s:a href="smsMgtAction" title=""  class="likelogin">Sms</s:a></li>

                            <li><s:a href="emailMgtAction" title="" class="likelogin">Email</s:a></li>

                            <li><s:a href="feedbackMgtAction" title="" class="likelogin">Feedback</s:a></li>
                        </ul>
                    </li>   
                    <li><a class="collapsed heading">Report</a>
                        <ul class="navigation">
                            <li><s:a href="historyReportMgt" title="" class="likelogin">History Report</s:a></li>
                        <li><s:a href="tripReportMgt" title="" class="likelogin">Trip Report</s:a></li>
                        <li><s:a href="stoppageReportMgt" title="" class="likelogin">Stoppage Report</s:a></li>
                        <li><s:a href="idealTimeReportMgt" title="" class="likelogin">Ideal Time Report</s:a></li>
                    </ul>
                </li> 
                    
                  <li><a class="expanded heading">Billing</a>
                        <ul class="navigation">
                            <li><s:a href="#" title="" class="likelogin">Billing Management</s:a></li>
                       
                    </ul>
                </li>  

            </ul>
        </div>
    <!-- Left Dark Bar End --> 
    
    
    
    <script type="text/javascript" src="scripts/enhance.js"></script>	
    <script type='text/javascript' src='scripts/excanvas.js'></script>
	<script type='text/javascript' src='scripts/jquery.min.js'></script>
    <script type='text/javascript' src='scripts/jquery-ui.min.js'></script>
	<script type='text/javascript' src='scripts/jquery.wysiwyg.js'></script>
    <script type='text/javascript' src='scripts/visualize.jQuery.js'></script>
    <script type="text/javascript" src='scripts/functions.js'></script>
    

</body>
</html>
