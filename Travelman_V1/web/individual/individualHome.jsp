<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TravelMan: Fleet Management System</title>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/wysiwyg.css" rel="stylesheet" type="text/css" />
<!-- Theme Start -->  
<link href="themes/blue/styles.css" rel="stylesheet" type="text/css" />
<!-- Theme End -->
</head>
<body id="homepage">
	<div id="header">
    	<a href="" title=""><img src="img/cp_logo.png" alt="Control Panel" class="logo" /></a>
    	
    	
    	
    </div>
        
    <!-- Top Breadcrumb Start -->
    <!--<div id="breadcrumb">
    	<ul>	
        	<li><img src="img/icons/icon_breadcrumb.png" alt="Location" /></li>
        	<li><strong>Location:</strong></li>
            <li><a href="#" title="">Sub Section</a></li>
            <li>/</li>
            <li class="current">Control Panel</li>
        </ul>
    </div>
    --><!-- Top Breadcrumb End -->
     
    <!-- Right Side/Main Content Start -->
    <div id="rightside">
    
    	<!-- Status Bar Start -->
        
       
    
       
        
        
        
        <!-- Alternative Content Box Start -->
         <div class="contentcontainer">
            <div class="headings altheading">
                <h2>Welcome to Home</h2>
            </div>
            <div class="contentbox">
              Under Construction
            	<!--<table width="100%">
                	<thead>
                    	<tr>
                        	<th> SNo</th>
                            <th>&nbsp;</th>
                            <th> UserId</th>
                            <th> Profile </th>
                            <th> CreationDate</th>
                            <th> Status </th>
                            <th> Action </th>

                        </tr>
                    </thead>
                    <tbody>
                    	<tr>
                        	<td>1</td>
                            <td><a href="#" title=""><img src="img/icons/icon_delete.png" alt="Inactive" /></a></td>
                            <td><a href="#" title=""><img src="img/google_maps.png" alt="Google Map"/></a></td>
                            <td><a href="#" title=""><img src="img/yahoo_map.png" alt="Yahoo Map"/></a></td>
                            <td> JBHR55M8520</td>
                            <td> 700011 </td>
                            <td> 29/May/2011 02:12:17 </td>
                          
                          
                        </tr>
                        <tr class="alt">
                        	<td>2</td>
                            <td><a href="#" title=""><img src="img/icons/icon_approve.png" alt="Active Static" /></a></td>
                            <td><a href="#" title=""><img src="img/google_maps.png" alt="Google Map"/></a></td>
                            <td><a href="#" title=""><img src="img/yahoo_map.png" alt="Yahoo Map"/></a></td>
                            <td>JBHR55J4733</td>
                            <td> 000077777777711 </td>
                            <td>29/May/2011 00:47:58</td>
                          
                        </tr>
                        <tr>
                        	<td>3</td>
                            <td><a href="#" title=""><img src="img/icons/icon_approve.png" alt="Active Static" /></a></td>
                            <td><a href="#" title=""><img src="img/google_maps.png" alt="Google Map"/></a></td>
                            <td><a href="#" title=""><img src="img/yahoo_map.png" alt="Yahoo Map"/></a></td>
                            <td>JBHR55J8520</td>
                            <td> 000001714000300 </td>
                            <td> 29/May/2011 00:47:43 </td>
                          
                        </tr>
                    </tbody>
                </table>
                --><!--<div class="extrabottom">
                	<ul>
                    	<li> <p class="userbtn"><a href="#" title="">Add User</a></p></li>
						<li><img src="img/icons/icon_approve.png" alt="Approve" /> Active Static</li>
						<li><img src="img/icons/icon_edit.png" alt="Edit" /> Active Running</li>                       
                        <li><img src="img/icons/icon_unapprove.png" alt="Unapprove" /> Active Over Speed</li>
                        
                    </ul>
                    <div class="bulkactions">
                    	
                    </div>
                </div>
            
                --><div style="clear: both;"></div>
            </div>
            
        </div>
        
        
        <div style="clear:both;"></div>

        
        <div id="footer">
        	&copy; Copyright 2011, Techno Life. All Rights Reserved.
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
                        <li><a href="liveTracking" title="">Home</a></li>
                    </ul>
                </li>
                <li>
                    <a class="collapsed heading">Tracking</a>
                    <ul class="navigation">
                        <li><a href="liveTracking" title="">Live Tracking</a></li>
                        <li><a href="selectVehicleForHistoryTracking" title="">History Tracking</a></li>
                    </ul>
                </li>  
                
                <li>
                    <a class="expanded">Administrative</a>
                    <ul class="navigation">                      
                        <li><a href="<s:url action="changePassword" />" title="" class="likelogin"> Change Password </a></li>
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
