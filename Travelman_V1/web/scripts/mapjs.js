var context = 'travelman';
/*
 var map;
 var arrMarkers = [];
 var arrInfoWindows = [];
 function mapInit() {
 alert(2);
 var centerCoord = new google.maps.LatLng(24.173148, 78.042069);
 var mapOptions = {
 zoom: 5,
 center: centerCoord,
 mapTypeId: google.maps.MapTypeId.ROADMAP
 };
 map = new google.maps.Map(document.getElementById("map"), mapOptions);
 calcRoute();
 }
 */
/*
 $(function() {
 alert(1);
 mapInit();
 $("#markers a").live("click", function() {
 var i = $(this).attr("rel");
 arrInfoWindows[i].open(map, arrMarkers[i]);
 
 });
 
 });
 */

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

var timerID = null;
var timerRunning = false;
var flag = 0;
var delay = 20000;

function InitializeTimer() {
    StopTheClock();
    StartTheTimer();
}

function StopTheClock() {
    if (timerRunning) {
        clearTimeout(timerID);
    }
    timerRunning = false;
}

function StartTracking() {
//    alert("StartTracking");
    readMap();
    StartTheTimer();
}

function StartTheTimer() {
//    alert("StartTracking");
    timerRunning = true;
    timerID = self.setTimeout("StartTracking()", delay);

}

if (window.XMLHttpRequest) {
    var side_bar_html = "";
    var gmarkers = [];
    var htmls = [];
    var points = [];
    var lats = [];
    var lngs = [];
    var markersArray = new Array();

    var i = 0;
    var infowindow;

    var icons = [];
    icons[0] = "map_icons/minicar_red.png";
    icons[1] = "map_icons/marker_idling.png"; //IdlingIcon;			// Idling
    icons[2] = "map_icons/minicar_yellow.png"; //YellowIcon;			// Stopped
    icons[3] = "map_icons/minicar_green.png"; //GreenIcon;			// Moving
    icons[4] = "map_icons/marker_unknown.png"; //ErrorIcon;			// Unknown (Moving without Ignition On)
    icons[5] = "map_icons/hospital.png"; //hospotal
    icons[6] = "map_icons/bus-stand.png"; //bus stand
    icons[7] = "map_icons/railway-station.png"; //railway station
    icons[8] = "map_icons/oil_station.png"; //oil station
    icons[9] = "map_icons/bank.png"; //bank
    icons[10] = "map_icons/telephone_exchange.png"; //telephone exchange
    icons[11] = "map_icons/airport.png"; //airport
    icons[12] = "map_icons/green-area.png"; //green area
    icons[13] = "map_icons/church.png"; //church
    icons[14] = "map_icons/beach.png"; //beach
    icons[15] = "map_icons/restaurant.png"; //restaurant
    icons[16] = "map_icons/postal_office.png"; //postal office
    icons[17] = "map_icons/factory.png"; //factory
    icons[18] = "map_icons/electricity_exchange.png"; //electricity exchange
    icons[19] = "map_icons/fire_station.png"; //fire station
    icons[20] = "map_icons/photo-studio.png"; //photo studio
    icons[21] = "map_icons/fishing_place.png"; //fishing place
    icons[22] = "map_icons/tunnel.png"; //tunnel
    icons[23] = "map_icons/taxi-stand.png"; //taxi stand
    icons[24] = "map_icons/shopping-mall.png"; //shopping mall
    icons[25] = "map_icons/racecours.png"; //race course
    icons[26] = "map_icons/police_station.png"; //police station
    icons[27] = "map_icons/sport_stadium.png"; //sports stadium
    icons[28] = "map_icons/car_repair_workshop.png"; //caer repair workshop
    icons[29] = "map_icons/swimming-pool.png"; //swimming pool
    icons[30] = "map_icons/depot.png"; //depot
    icons[31] = "map_icons/dockyard.png"; //dockyard
    icons[40] = "tracking/vehicles/car_upg.png"; //north
    icons[41] = "tracking/vehicles/car_top_rightg.png"; //north-east
    icons[42] = "tracking/vehicles/car_rightg.png"; //east
    icons[43] = "tracking/vehicles/car_bottom_rightg.png"; //south-east
    icons[44] = "tracking/vehicles/car_downg.png"; //south
    icons[45] = "tracking/vehicles/car_bottom_leftg.png"; //south-west
    icons[46] = "tracking/vehicles/car_leftg.png"; //west
    icons[47] = "tracking/vehicles/car_top_leftg.png"; //north-west
    icons[50] = "tracking/vehicles/car_up.png"; //north
    icons[51] = "tracking/vehicles/car_top_right.png"; //north-east
    icons[52] = "tracking/vehicles/car_right.png"; //east
    icons[53] = "tracking/vehicles/car_bottom_right.png"; //south-east
    icons[54] = "tracking/vehicles/car_down.png"; //south
    icons[55] = "tracking/vehicles/car_bottom_left.png"; //south-west
    icons[56] = "tracking/vehicles/car_left.png"; //west
    icons[57] = "tracking/vehicles/car_top_left.png"; //north-west
    icons[60] = "tracking/vehicles/car_upy.png"; //north
    icons[61] = "tracking/vehicles/car_top_righty.png"; //north-east
    icons[62] = "tracking/vehicles/car_righty.png"; //east
    icons[63] = "tracking/vehicles/car_bottom_righty.png"; //south-east
    icons[64] = "tracking/vehicles/car_downy.png"; //south
    icons[65] = "tracking/vehicles/car_bottom_lefty.png"; //south-west
    icons[66] = "tracking/vehicles/car_lefty.png"; //west
    icons[67] = "tracking/vehicles/car_top_lefty.png"; //north-west
    icons[70] = "tracking/person/person02.png"; //OFF
    icons[71] = "tracking/person/person01.png"; //rest
    icons[72] = "tracking/person/person03.png"; //on move

    // A function to create the marker and set up the event window
    function createMarker(point, name, html, lat, lng, icontype) {
        var marker = new google.maps.Marker({
            position: point,
            map: map,
            icon: icons[icontype]//,
            //title: "Hello!"
        });

        markersArray.push(marker);

        google.maps.event.addListener(marker, "click", function() {

            if (infowindow)
                infowindow.close();
            infowindow = new google.maps.InfoWindow({
                content: html
            });
            infowindow.open(map, this);
        });
        points[i] = point;
        lats[i] = lat;
        lngs[i] = lng;
        gmarkers[i] = marker;
        i++;
        return marker;
    }

    function clearOverlays() {
        if (markersArray) {
            for (var i = 0; i < markersArray.length; i++) {
                markersArray[i].setMap(null);
            }
        }
    }

    function myclick(i) {
        //alert('fgh');
        google.maps.event.trigger(gmarkers[i], "click");
        map.setZoom(14);
    }

    // A function to read the data
    function readMap(url) {
        //url = "/Travelman_V1/trackingAjax";
        url = "/"+context+"/trackingAjax";
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState === 4) {
                markers = xmlhttp.responseXML.documentElement.getElementsByTagName("TrackData");
                side_bar_html = "";
                htmls = [];
                i = 0;
                clearOverlays();
                gmarkers = [];
                for (var i = 0; i < markers.length; i++) {
                    // obtain the attribues of each marker

                    var lat = parseFloat(markers[i].getElementsByTagName("latitudeList")[0].childNodes[0].nodeValue);
                    var lng = parseFloat(markers[i].getElementsByTagName("longitudeList")[0].childNodes[0].nodeValue);

                    //logic to get location
                    var deviceId = parseFloat(markers[i].getElementsByTagName("deviceid")[0].childNodes[0].nodeValue);
                    var geoCodeUrl = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lng + "&sensor=false";
                    //alert(deviceId);
                    //getLocation(deviceId, geoCodeUrl);

                    var icon_type = 3;
                    if (markers[i].getElementsByTagName("acc_status")[0].childNodes[0].nodeValue == 'OFF') {
                        icon_type = 2;
                    }
                    // var icon_type = parseFloat(markers[i].getAttribute("acc_status"));
                    var point = new google.maps.LatLng(lat, lng);
                    //var html = "<a href=\"http://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&sensor=false\">Location</a>";
                    var html = '<a href="javascript:getLocationFromLatLng(' + deviceId + ', ' + lat + ',' + lng + ')">Refresh Location</a>';
                    //alert(html);
                    //markers[i].getAttribute("html");
                    var label = "Label Value ";//markers[i].getAttribute("label");
                    //var category = markers[i].getAttribute("category");
                    //alert("Lat > " + lat + "Long > " + lng + "icon_type " + icon_type + " ");
                    var marker = createMarker(point, label, html, lat, lng, icon_type);
                    marker.setMap(map);

                }
                // put the assembled side_bar_html contents into the side_bar div
                // document.getElementById("side_bar").innerHTML = side_bar_html;

            }
        }
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    }
    readMap("a");

} else {
    alert("Sorry, the Google Maps API is not compatible with this browser");
}

// A function to get location from google / parse json
function getLocation(deviceId, geoCodeUrl) {
    alert("locationValue()");
    //url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=28.79012,79.013756&sensor=true";
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4) {
            //alert("xmlhttp.readyState ::: "+xmlhttp.readyState)
            //alert("xmlhttp.readyState ::: "+xmlhttp.status);
            //alert(locationValue[1].formatted_address);
            if (xmlhttp.status === 200) {
                var locationValue = xmlhttp.responseText;
                //alert(locationValue);
                var geoCodeResponse = JSON.parse(locationValue);
                document.getElementById(deviceId).value = geoCodeResponse.results[0].formatted_address;
                // alert(geoCodeResponse.results[0].formatted_address);
            } else {
                alert('There was a problem with the request! Refresh the page');
            }

        }
    };
    xmlhttp.open("GET", geoCodeUrl, true);
    xmlhttp.send();
}

function getLocationFromLatLng(deviceId, lat, lng) {
    //alert("getLocationFromLatLng()11");
    var geoCodeUrl = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lng + "&sensor=false";
    //var geoCodeUrl = "http://maps.googleapis.com/maps/api/geocode/json?latlng=26.066947,91.459674&sensor=false"
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4) {
            if (xmlhttp.status === 200) {
                var locationValue = xmlhttp.responseText;
                //alert(locationValue);
                var geoCodeResponse = JSON.parse(locationValue);
                document.getElementById(deviceId).value = geoCodeResponse.results[0].formatted_address;
                // alert(geoCodeResponse.results[0].formatted_address);
            } else {
                alert('There was a problem with the request! Refresh the page');
            }

        }
    };
    xmlhttp.open("GET", geoCodeUrl, true);
    xmlhttp.send();
}
