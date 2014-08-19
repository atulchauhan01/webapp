

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <%@ taglib prefix="s" uri="/struts-tags"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Send Email</title>
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
					Enter details 
                    </h2>
                </div>
                <div class="contentbox">
                    <table width="100%">
                        <s:form action="sendEmailAction" method="post" >
                            <thead>
                                <tr>
                                    <th width="20%">

                                        <s:select name="rtype" label="Report Type " headerKey="0" headerValue="Select Report Type" list=" # {'Trip Report':'Trip Report','History Report':'History Report','Stoppage Report':'Stoppage Report','Ideal Report':'Ideal Report' }"/>
                                       </th>
                                </tr>
                                <tr>
                                    <th width="20%">
                                        <s:select name="send_interval" label="Send Report :" headerKey="0" headerValue="Select Timeing" list=" # {'Daily':'Daily','weekly':'weekly','monthly':'monthly','yearly':'yearly' }"/>
                                    </th>
                                </tr>   
                                <tr>
                                    <th width="20%">
                                        <s:select name=" vehicleid" label="Vehicle Id :" headerKey="0" headerValue="Select Id" size="1" list="list" />	
                                    </th>
                                </tr>
                                
                            </thead>
                            <tbody>
                                <tr>  
                                    <th width="20%">
                                        <s:select name="report_for_days" label="Report for Days :" headerKey="0" headerValue="Select Days" list=" # {'1 Day':'1 Day','2 Days':'2 Days','3 Days':'3 Day','4 Days':'4 Days' }"/>	
                                    </th>
                                </tr>
                                <tr>   
                                    <th width="20%"><s:textfield label="Send To(Email) :" name="rec_email"></s:textfield>

                                    </th>
                                </tr>
                                <tr>
                                    <th width="20%"><s:select name="send_time" label="Time :" headerKey="0" headerValue="Select Time to Send" list=" # {'6 AM':'6 AM','8 AM':'8 AM','10 AM':'10 AM','12 PM':'12 PM','2 PM':'2 PM','4 PM':'4 PM','6 PM':'6 PM' }"/>

                                    </th>

                                </tr>
                                <s:submit value="Send" />
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
                    <a class="collapsed heading">Administrative</a>
                    <ul class="navigation">                      
                        <li><a href="<s:url action="changePassword" />" title="" class="likelogin"> Change Password </a></li>
                    </ul>
                </li>  
                    
                <li><a class="expanded heading">Notification </a>
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


