<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java"%>
<html xmlns="http://www.w3.org/1999/xhtml">

    <%@ taglib prefix="s" uri="/struts-tags"%>
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/> 
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/> 
        <title>Trip Report</title> 
        <link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

        <script type="text/javascript"> 
            var geocoder;
            // var map;
            var infowindow = new google.maps.InfoWindow();
            var marker;
  
            var txt = "";
            
            var latitude;
  
            var latArray;
  
            var longitude;
  
            var langArray;
            
            var content;
            
            var contentArray;
      
            var dummy="";
            
            var markersArray = [];

    
            
            function initialize() 
            {  
                // alert("welcome");       
                geocoder = new google.maps.Geocoder();                   
                latitude = document.getElementById('latitude').value;
                //alert("latitude-->"+latitude);
                latArray = latitude.split(",");
                longitude = document.getElementById('longitude').value; 
                // alert("in inilialize 3-->"+longitude);
                //alert(latArray[0]);
                //alert(langArray[o]);
                langArray = longitude.split(",");
                content();
                setTimeout("setContent()",10000);
                
                //  alert("after time out");
                content = document.getElementById("location").value;
                //   alert("content  1--->>"+content);
            }
            function setContent()
            {
    
                 //alert("I ma in the loop");
                content = document.getElementById("location").value;
                //  alert("content---->>"+content);
                contentArray = content.split("^");
                for (var i = 0; i < latArray.length; i++) {
                    //   alert("sdhfgsdh");
                    //addmarker(latArray[i], langArray[i], contentArray[i]);
                    dummy="dummy"+i;
                    // alert(latArray.length);
                    // alert(dummy);
                     var test=contentArray[i];
                   //  alert("content array value-->"+test);
                    document.getElementById(dummy).value = contentArray[i];
                  //   alert("test"+dummy);
                } 
              
                //comment for testing of location
                // alert(langArray[o]);
                // alert(latArray[0]);
                //                var myLatlng = new google.maps.LatLng(latArray[0], langArray[0]);
                //                var myOptions = ({
                //                    zoom: 5,
                //                    center: myLatlng,
                //                    mapTypeId: google.maps.MapTypeId.ROADMAP
                //                });
                //                map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
                //                for (i = 0; i < latArray.length; i++) {
                //                   //   alert("sdhfgsdh");
                //                    addmarker(latArray[i], langArray[i], contentArray[i]);
                //                    dummy="dummy"+i;
                //                    alert(dummy);
                //                    document.getElementById(dummy).value = contentArray[i];
                //                } 
            }
            
            function content()
            {
               
              
                for(var i =0;i<latArray.length ;i++)
                {   
                    var lat = parseFloat(latArray[i]);
                    var lng = parseFloat(langArray[i]);
                        
                     // alert("lat--->"+lat+"--lng-->"+lng);                        
                    var latlng = new google.maps.LatLng(lat, lng); 
                    // alert("start--1>"+i);
                    geocoder.geocode({'latLng': latlng}, function(results, status) {  
                        //alert("start--status>"+i);
                        //alert("status  -->"+status);
                        // alert("result"+results[1].formatted_address);
                        // alert("value of the filed"+document.getElementById("location").value);
                        if(document.getElementById("location").value==""){
                            document.getElementById("location").value= results[1].formatted_address; 
                        }
                        else{
                            document.getElementById("location").value=document.getElementById("location").value+'^'+results[1].formatted_address;  
                        }
                    });
                    //    alert("hahaha");
                    //  setTimeout(func, 5000, param1, param2);
                    //  alert("start-->>>>>>>bhar>"+i);
                }// for loop ends here.
            }
            //comment for testing of location
            //            function addmarker(lat, lng, siteid) {
            //                //  alert(lat + ',' + lng + ', ' + siteid);
            //                marker = new google.maps.Marker({
            //                    position: new google.maps.LatLng(lat, lng),
            //                    map: map
            //                });
            //                 //  alert("marker-->>"+marker);
            //                // markersArray.push(marker);
            //                infowindow = new google.maps.InfoWindow();
            //                google.maps.event.addListener(marker, 'click', function () {
            //                    var contentString = siteid;
            //                    infowindow.setContent(contentString);
            //                    infowindow.open(map, this);
            //                });
            //            }


         
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>TravelMan: Fleet Management System</title>
        <link href="styles/layout.css" rel="stylesheet" type="text/css" />
        <link href="styles/wysiwyg.css" rel="stylesheet" type="text/css" />
        <!-- Theme Start -->
        <link href="themes/blue/styles.css" rel="stylesheet" type="text/css" />
        <!-- Theme End -->
    </head>
    <body id="homepage" onload="initialize()">

        <input type="text" name="latitude" id="latitude" value="<s:property value="latitude"/>"/>
        <input type="text" name="longitude" id="longitude" value="<s:property value="longitude"/>"/>
        <input type="text" name="location" id="location" />
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
						Trip Report
                    </h2>
                </div>
                <div class="contentbox">

                    <table cellpadding="0" cellspacing="0" border="2" width="100%">

                        <tr>
                            <th>S.No.</th>
                            <th>Start Date/Time</th>
                            <th>Start Location</th>
                            <th>Final Date/Time</th>
                            <th>Final Location</th>
                            <th>Time Duration</th>
                        </tr>
                        <%
                            int serial = 1;
                            int dummyindex=0;
                        %>
                        <s:iterator value="list" status="dummy" >
                            <tr>
                                <td><% out.println(serial++);%></td>
                                <td><s:property value="startDate" /></td>
                                                       
                                <td>
                                    <input type="text" readonly="readonly" width="50" boder="0" id="dummy<%=dummyindex++%>" value="" style="width: 250px;border-color: transparent"/>                                   
                               <!-- dummy<% out.println(dummyindex);%> -->
                                </td> 
                                <td><s:property value="endDate" /></td>                              
                               
                                <td>
                                  <!--  dummy<% out.println(dummyindex);%>  -->
                                    <input type="text" readonly="readonly" width="50" boder="0" id="dummy<%=dummyindex++%>" value="" style="width: 250px;border-color: transparent"/>                                    
                                   </td> 
                                <td><s:property value="duration"/></td>
                            </tr>
                        </s:iterator>


                    </table>

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
                
                <li>
                    <a class="collapsed heading">Administrative</a>
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


