<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java"%>
<html xmlns="http://www.w3.org/1999/xhtml">

    <%@ taglib prefix="s" uri="/struts-tags"%>
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/> 
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/> 
        <title>List Over Speed Report</title> 

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />        
        <link href="styles/layout.css" rel="stylesheet" type="text/css" />
        <link href="styles/wysiwyg.css" rel="stylesheet" type="text/css" />
        <!-- Theme Start -->
        <link href="themes/blue/styles.css" rel="stylesheet" type="text/css" />
        <!-- Theme End -->
    </head>
    <body id="homepage" onload="initialize()">

<!--        <input type="hidden" name="latitude" id="latitude" value="<s:property value="latitude"/>"/>
        <input type="hidden" name="longitude" id="longitude" value="<s:property value="longitude"/>"/>
        <input type="hidden" name="location" id="location" />    -->
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
                    <h2>Over Speed Report</h2>
                </div>
                <div class="contentbox divheight">

                    <table cellpadding="0" cellspacing="0" border="2" width="100%" >

                        <tr>
                            <th>Sr. No.</th>
                            <th>Date Time</th>
                            <th>Status</th>
                            <th>Speed(Km/Hr.)</th> 
                            <th>GPS</th>
                            <th>(Location)</th>                            
                        </tr>
                        <%

                            int serial = 1;


                        %>
                        <s:iterator value="list" status="dummy" >
                            <tr>  <td>
                                    <%out.println(serial++);%>
                                </td>

                                <td>
                                    <s:property value="startDate" />
                                </td>
                                <td>
                                    <s:property value="ignition" />                                
                                </td>                           
                                <td>
                                    <s:property value="speed" />
                                </td>
                                <td>
                                    <s:property value="GPS" />
                                </td>
                                <td>
                                    <s:property value="location" />
                                </td>

                            </s:iterator>

                        </tr>
                    </table>


                </div>
            </div>
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
                <li><a class="collapsed heading">Administrative</a>
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
                <li><a class="expanded heading">Report</a>
                    <ul class="navigation">
                        <li><s:a href="historyReportMgt" title="" class="likelogin">History Report</s:a></li>
                        <li><s:a href="tripReportMgt" title="" class="likelogin">Trip Report</s:a></li>
                        <li><s:a href="stoppageReportMgt" title="" class="likelogin">Stoppage Report</s:a></li>
                        <li><s:a href="idealTimeReportMgt" title="" class="likelogin">Ideal Time Report</s:a></li>
                        <li><s:a href="overSpeedReportMgt" title="" class="likelogin">Over Speed Report</s:a></li>
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


