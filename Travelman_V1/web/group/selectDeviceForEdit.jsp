

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<%@ taglib prefix="s" uri="/struts-tags"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Edit Device</title>
		<link href="styles/layout.css" rel="stylesheet" type="text/css" />
		<link href="styles/wysiwyg.css" rel="stylesheet" type="text/css" />
		<!-- Theme Start -->
		<link href="themes/blue/styles.css" rel="stylesheet" type="text/css" />
		<!-- Theme End -->
	</head>
	<body id="homepage">
		<div id="header">
			<a href="" title=""><img src="img/cp_logo.png"
					alt="Control Panel" class="logo" />
			</a>
			
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
					Edit Device Details
					</h2>
				</div>
				<div class="contentbox">
                                    <table width="100%">
                        <s:form action="editDevice" method="post">
                           <thead>
                                <tr>
                                    <td><a href="addDevProfileAction" title="" class="likelogin">Create New Device </a></td>
                                    <td><a href="listDeviceAction" title="" class="likelogin"> List All Device </a></td>
                                    <td><a href="editMgtDevice" title="" class="likelogin">Edit Device </a></td>
                                    <td><a href="listDeleteDevice" title="" class="likelogin">Delete Device </a></td>
                                </tr>

                            </thead>
                            <tbody>
                                <tr> <td >User Id:</td><td><input type="text" name="userid" value="<s:property value="device.userid"/>" /></td></tr>  
                                
                                <tr> <td >Device Id:</td><td><input type="text" name="deviceid" value="<s:property value="device.deviceId"/>" readonly="true"/></td></tr>

                                <tr> <td> Device Type:</td><td><input type="text" name="dtype" value="<s:property value="device.dtype"/>" /></td></tr>

                                <tr><td> Device IEMI:</td><td><input type="text" name="diemi" value="<s:property value="device.diemi"/>" /></td></tr>

                                <tr><td>Device Sim Number:</td><td><input type="text" name="dsim_num" value="<s:property value="device.dsim_num"/>" /></td></tr>
                      
                               <s:submit value="Update Device" ></s:submit>
                            </tbody>
                        </s:form>
                    </table>
					
					<div class="extrabottom">
						<ul>
							<li>
								<p class="userbtn">
									<!--<a href="#" title="">Edit DeviceProfile</a>-->
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
                        <li><a href="<s:url action="addDevProfileAction"/>" title="" class="likelogin">Device Management</a></li>
                        <li><a href="<s:url action="addNewVehicle"/>" title="" class="likelogin">Vehicle Management</a></li>

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


