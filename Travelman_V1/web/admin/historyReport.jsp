
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <%@ taglib prefix="s" uri="/struts-tags"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>History Report</title>
        <link href="styles/layout.css" rel="stylesheet" type="text/css" />
        <link href="styles/wysiwyg.css" rel="stylesheet" type="text/css" />
        <!-- Theme Start -->
        <link href="themes/blue/styles.css" rel="stylesheet" type="text/css" />
        <!-- Theme End -->
        <script language="javascript" type="text/javascript" src="scripts/datetimepicker.js">

            //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
            //Script featured on JavaScript Kit (http://www.javascriptkit.com)
            //For this script, visit http://www.javascriptkit.com 
     
        </script>
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
						History Report
                    </h2>
                </div>
                <div class="contentbox">
                    <form action="listHistoryReport">
                        <table cellpadding="0" cellspacing="0" border="1" width="100%">
                             <s:select label="Vehicle Id" name="vregistration_num" list="list"></s:select>
                             <td>Start Date</td><td><input type="text" name="startDate" id="demo1" maxlength="25" size="25" readonly="true" /><a href="javascript:NewCal('demo1','ddmmmyyyy',true,24)"><img src="img/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></td>             
                               
                         <tr><td>End Date</td><td><input type="text" name="endDate" id="demo2" maxlength="25" size="25" readonly="true" /><a href="javascript:NewCal('demo2','ddmmmyyyy',true,24)"><img src="img/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></td>
                         </tr>>
                        </table>
                            <s:submit value="submit"></s:submit>
                    </form>
                     
                    <div style="clear: both;"></div>
                </div>

            </div>


            <div style="clear: both;"></div>


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


