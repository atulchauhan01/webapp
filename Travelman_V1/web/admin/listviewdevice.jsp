<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@taglib uri="http://displaytag.sf.net" prefix="display" %>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>List of Devices</title>
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
        <!-- Top Breadcrumb End -->

        <!-- Right Side/Main Content Start -->
        <div id="rightside">

            <!-- Status Bar Start -->







            <!-- Alternative Content Box Start -->
            <div class="contentcontainer">
                <div class="headings altheading">
                    <h2>List of Devices</h2>
                </div>
                <div class="contentbox">
                    <table width="100%">                       
                            
                                <tr>
                                    <td><a href="addDevProfileAction" title="" class="likelogin">Create New Device </a></td>
                                    <td><a href="listDeviceAction" title="" class="likelogin"> List All Device </a></td>
                                    <td><a href="editMgtDevice" title="" class="likelogin">Edit Device </a></td>
                                    <td><a href="listDeleteDevice" title="" class="likelogin">Delete Device </a></td>
                                </tr>
                    </table>

   
                    <!--<table cellpadding="0" cellspacing="0" border="2" width="100%">
                    
                    <tr><th width="50">DeviceId</th><th width="50">Type</th><th width="50">protocol</th><th width="50">IEMI Number</th>
                    <th width="50">Registration Date</th><th width="50">Sim Number</th><th width="50">User</th><th width="50">Vehicle</th></tr>
                    
                    <s:iterator value="list" var="device">
                    <tr>
                    <td width="50"><s:property value="deviceId"/></td>
                    <td width="50"><s:property value="dtype"/></td>
                    <td width="50"><s:property value="dprotocol"/></td>
                    <td width="50"><s:property value="diemi"/></td>
                    <td width="100"><s:property value="dreg_date"/></td>
                    <td width="50"><s:property value="dsim_num"/></td>
                    <td width="50"><s:property value="userid"/></td>
                    
                    
                    </tr></s:iterator>
                    
                    </table>-->

                    <display:table id="data" name="list" requestURI="/listDeviceAction" pagesize="10" export="true">
                        
                        
                        <display:column property="deviceId" title="Device ID" sortable="true" group="1" />
                        <display:column property="dtype" title="Type" sortable="true" />
                        <display:column property="dprotocol" title="Protocol" sortable="true" />
                        <display:column property="diemi" title="IEMI" sortable="true" />
                        <display:column property="dreg_date" title="Date" sortable="true" />
                        <display:column property="dsim_num" title="Sim number" sortable="true" />
                        <display:column property="userid" title="User ID" sortable="true" />
                        

                        <display:setProperty name="export.excel.filename" value="DeviceList.xls"/>
                        <display:setProperty name="export.pdf.filename" value="DeviceList.pdf"/>
                        <display:setProperty name="export.pdf" value="true" />
                    </display:table>


                    <div style="clear: both;"></div>
                </div>

            </div>


            <div style="clear:both;"></div>


            <div id="footer">
                &copy; Copyright 2011,Techno Life. All Rights Reserved.
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
                        <li><a href="selectVehicleForHistoryTracking" title="">History Tracking</a></li>
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


