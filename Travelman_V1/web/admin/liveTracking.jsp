<!DOCTYPE html>
<%@ page language="java"%>


<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <META HTTP-EQUIV="REFRESH" CONTENT="120;url=liveTracking"/>
    <title>Vehicle Live Tracking</title>
    <link href="styles/layout.css" rel="stylesheet" type="text/css" />
    <link href="styles/wysiwyg.css" rel="stylesheet" type="text/css" />
    <!-- Theme Start -->  
    <link href="themes/blue/styles.css" rel="stylesheet" type="text/css" />
    <!-- Theme End -->
    <script type="text/javascript" src="scripts/searchForm.js"></script>
    <script type="text/javascript" src="http://apis.mapmyindia.com/v2.0/mapApi/licKey=1009e2cdfd6b0d63bc08d9c982a23dc4&platform=java"></script>
    <script type="text/javascript">
        var map =null;
        var mark=null;
    </script> 
</head>
<body>




    <!-- <body id="homepage" onload="initialize()"> -->

atul

    <input type="text" name="latitude" id="latitude" value="<s:property value="latitude"/>"/>
    <input type="text" name="longitude" id="longitude" value="<s:property value="longitude"/>"/>
    <input type="text" name="location" id="location" value="<s:property value="location" />" />
    <div id="header">
        <a href="" title=""><img src="img/cp_logo.png" alt="Control Panel" class="logo" /></a>
        <div id="searcharea">
            <table>                    
                <form action="searchVehicle" method="post" name="searchForm" >
                    <tr>
                        <s:textfield name="vn" label="Enter Vehicle Number" ></s:textfield>               
                        <s:submit value="Search" />
                    </tr>
                </form>
            </table>
        </div>

    </div>

    <!-- Top Breadcrumb Start -->
    <!-- Top Breadcrumb End -->

    <!-- Right Side/Main Content Start -->
    <div id="rightside">

        <!-- Status Bar Start -->







        <!-- Alternative Content Box Start -->
        <div class="contentcontainer">
            <div class="headings altheading">
                <h2>Live Locations of Vehicles</h2>
            </div>
            <div class="contentbox">
                <table width="100%">
                    <thead>
                        <tr>
                            <th> Vehicle Number</th>
                            <th> Device ID </th>
                            <th> Date/Time</th>
                            <th> Speed </th>
                            <th> Ignition Status</th>
                            <th> Location </th>

                        </tr>
                    </thead>
                    <%
                        String locationArray = request.getParameter("txt");
                        // int serial = 1;
                        int i = 0;
                    %>
                    <tbody>
                        <s:iterator value="list" status="dummy" >
                            <tr>

                                <td><s:property value="vregisteration_num"/></td>
                                <td><s:property value="deviceid" /></td>
                                <td><s:property value="date"/></td>
                                <td><s:property value="speed"/></td>
                                <td><s:property value="acc_status"/></td>
                                <s:set  value="dummy.index" ></s:set>
                                    <td>
                                    <%-- <input type="text" readonly="readonly" width="50" boder="0" id="dummy<s:property value="%{#dummy.index}"/>" value="" style="width: 400px;border-color: transparent"/> --%>
                                    <s:property value="location"/>


                                </td>                         
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>

                <div style="clear: both;"></div>
            </div>

        </div>

        <div id="MapDiv" style="border:1px solid #999;width:1000px;height:457px;">

            <script type="text/javascript">
                var latitude;
                var latArray;
                var longitude;  
                var langArray;
                latitude = document.getElementById('latitude').value;
                 //alert(latitude);
                latArray = latitude.split(",");
                //alert("latArray ==>"+latArray[0]);
                longitude = document.getElementById('longitude').value; 
                // alert(longitude);
                langArray = longitude.split(",");
                //alert("longArrary==>"+langArray[0]);
                var _X = '77.2197173068909';
                // alert(_X);                                             
                var _Y = '28.632715604525647';  
//var _X =latArray[0];
//var _Y =langArray[0];
              //  var pt = new Point(_X, _Y);
               var pt = new Point(langArray[0],latArray[0]);
                map = $("#MapDiv").MireoMap();
                //var routeDrawer = new RouteDrawer(map);
                var imgPath = "images/green.png";
                $().ready(function() {

                    try {
                        // $("#map_alt_div").hide();
                        //  $("#map_alt_text").html("");
                        map.MireoMap("setCenterAndZoomLevel",pt ,8);
                        var Overlays = {
                            //marker : new Array(),
                            addMarker : function(mark) {
                                marker.push(mark);
                            }
                        }

                        var elem   = $(HTMLHelper.mapMarker(imgPath, 37,35));
                        var marker = map.MireoMap("addMarker", elem, pt);
                        Overlays.addMarker(marker);
                        elem.mouseover(function() {
                            var infoDiv = GeocodinginfoDiv.createInfoDiv("Delhi","New Delhi");
                            map.MireoMap("showInfoWindow", pt, {inner:infoDiv});

                        });
                        var GeocodinginfoDiv = {

                            createInfoDiv : function (name,address) {

                                var infoDiv = new Array();
                                infoDiv.push("<div id='infoOption' class='PoiInfoBox'><span><b>")
                                infoDiv.push(name);

                                infoDiv.push("</b></span><div>");
                                infoDiv.push(address);
                                infoDiv.push("</div>");
                                infoDiv.push("</div>");
                                return infoDiv.join("");
                            }
                        }
                        
                        elem.mouseout(function() {
                            map.MireoMap("hideInfoWindow");
                        });

                        // ,
                    } catch(e) {
                        alert(e);
                    }
                });
            </script>
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
                    <li><a href="infoWindow.jsp">Info Window</a></li>
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
