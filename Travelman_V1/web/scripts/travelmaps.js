/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var geocoder;
var map;
var infowindow = new google.maps.InfoWindow();
var marker;
var txt = "";
var latitude;
var latArray;
var longitude;
var langArray;

function initialize()
{
    geocoder = new google.maps.Geocoder();
    latitude = document.getElementById('latitude').value;
    latArray = latitude.split(",");
    longitude = document.getElementById('longitude').value;
    langArray = longitude.split(",");
    var myLatlng = new google.maps.LatLng(latArray[0], langArray[0]);
    alert("myLatlng" + myLatlng);
    var myOptions = {
        zoom: 11,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    alert("myOptions" + myOptions);
    codeLatLng();
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    marker = new google.maps.Marker({
        position: myLatlng,
        map: map
    });
}

function attachSecretMessage(marker, number) {
    var message = ["This", "is", "the", "secret", "message"];
    var infowindow = new google.maps.InfoWindow(
            {content: message[number]
            });
    google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map, marker);
    });
}
function getLocation()
{
    return document.getElementById('location').value;
}
function codeLatLng() {
    var lat = parseFloat(latArray[0]);
    var lng = parseFloat(langArray[0]);
    var latlng = new google.maps.LatLng(lat, lng);
    geocoder.geocode({'latLng': latlng}, function(results, status) {
        alert("status" + status);
        alert("result" + results[1].formatted_address);
        if (status === google.maps.GeocoderStatus.OK) {
            if (results[1]) {
                map.setZoom(11);
                marker = new google.maps.Marker({
                    position: latlng,
                    map: map
                });
                infowindow.setContent(results[1].formatted_address);
                if (txt == "") {
                    txt = results[1].formatted_address;
                } else {
                    txt += ":" + results[1].formatted_address;
                }
                document.getElementById("location").value = txt;
                document.getElementById("dummy").value = txt;
                infowindow.open(map, marker);
            } else {
                alert("No results found");
            }
        } else {
            alert("Geocoder failed due to: " + status);
        }
    });
}

