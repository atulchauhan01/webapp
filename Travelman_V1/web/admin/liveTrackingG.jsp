<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java"%>
<html xmlns="http://www.w3.org/1999/xhtml">

    <%@ taglib prefix="s" uri="/struts-tags"%>
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
        <title>Vehicle Live Tracking</title>
        <link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
        <script type="text/javascript" src="scripts/searchForm.js"></script>
        <script type="text/javascript" src="scripts/mapjs.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Live Tracking</title>
        <style>
        #map_canvas {
        height: 80%;
        margin: 0px;
        padding: 0px
      }
      </style>
        <link href="styles/layout.css" rel="stylesheet" type="text/css" />
        <link href="styles/wysiwyg.css" rel="stylesheet" type="text/css" />
        <!-- Theme Start -->  
        <link href="themes/blue/styles.css" rel="stylesheet" type="text/css" />
        <!-- Theme End -->
        <script>
            var map;
            var arrMarkers = [];
            var arrInfoWindows = [];
            function mapInit() {
                var centerCoord = new google.maps.LatLng(24.173148, 78.042069);
                var mapOptions = {
                    zoom: 5,
                    center: centerCoord,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
            }



        </script>
    </head>
    <body id="homepage"  onload="mapInit(); InitializeTimer();" >
        <input type="text" name="latitude" id="latitude" value="<s:property value="latitude"/>"/>
        <input type="text" name="longitude" id="longitude" value="<s:property value="longitude"/>"/>
        <input type="text" name="location" id="location" />
        <input type="button" onclick="getLocation('url');" name="location" />
        <div id="header">
            <a href="" title=""><img src="img/cp_logo.png" alt="Control Panel" class="logo" /></a>
            <div id="searcharea">
                <table>                    
                    <form action="searchVehicle" method="post" name="searchForm" onsubmit="return search_Validator()">
                        <tr>
                            <s:textfield name="vehicleId" label="Enter Vehicle Id" ></s:textfield>               
                            <s:submit value="Search" />
                        </tr>
                    </form>
                </table>
            </div>

        </div>
        <!-- Right Side/Main Content Start -->
        <div id="rightside">
            <!-- Alternative Content Box Start -->
            <div class="contentcontainer">
                <div class="headings altheading">
                    <h2>Live Locations of Vehicles G</h2>
                </div>
                <div class="contentbox">
                    <table width="100%">
                        <thead>
                            <tr>
                                <th> Device ID </th>
                                <th> Date/Time</th>
                                <th> Speed </th>
                                <th> Ignition Status</th>
                                <th> Location </th>

                            </tr>
                        </thead>
                        <%
                            String locationArray = request.getParameter("txt");;
                            // int serial = 1;
                            // int i = 0;
                        %>
                        <tbody>
                            <s:iterator value="list">
                                <tr>
                                    <td><s:property value="deviceid"/></td>
                                    <td><s:property value="date"/></td>
                                    <td><s:property value="speed"/></td>
                                    <td><s:property value="acc_status"/></td>
                                    <td><input type="text" readonly="readonly" width="50" boder="0" id="<s:property value="deviceid"/>" value="" style="width: 400px;border-color: transparent"/>


                                    </td>                         
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>

                    <div style="clear: both;"></div>
                </div>

            </div>

            <div id="map_canvas"></div>
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
                    <a class="expanded heading">Tracking</a>
                    <ul class="navigation">
                        <li><a href="liveTracking" title="">Live Tracking</a></li>
                        <li><a href="selectVehicleForHistoryTracking" title="">History Tracking</a></li>
                    </ul>
                </li>     
                <li><a class="collapsed heading">Administrative</a>
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

                    <li><a class="collapsed heading">Billing</a>
                        <ul class="navigation">
                            <li><s:a href="paymentMgt" title="" class="likelogin">Payment</s:a></li>
                        <li><a href="<s:url action="offerAction"/>" title="" class="likelogin">Offers</a></li>
                        <li><a href="<s:url action="couponAction"/>" title="" class="likelogin">Coupons</a></li>
                        <li><s:a href="createPlans" title="" class="likelogin">Plan</s:a></li>
                        <li><s:a href="createTax" title="" class="likelogin">Tax</s:a></li>
                        <li><s:a href="assignPlan" title="" class="likelogin">Assign Plan</s:a></li>

                            <li><s:a href="generateBill" title="" class="likelogin">Generate Bill</s:a></li>
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
