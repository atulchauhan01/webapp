<link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
 <script type="text/javascript">
var map;
var markersArray = [];
var marker;
var infowindow;
var url = '/SearchRing/GetSiteDetails';
function Showmap(siteids, lats, longs) {
    var arrylats = lats.split('^');
    var arrylongs = longs.split('^');
    var arrysiteids = siteids.split('^');
    var myLatlng = new google.maps.LatLng(17.375278, 78.474444);
    var myOptions = ({
        zoom: 8,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    for (i = 1; i < arrylats.length; i++) {
        addmarker(arrylats[i], arrylongs[i], arrysiteids[i]);
    }
}
function addmarker(lat, lng, siteid) {
    alert(lat + ',' + lng + ', ' + siteid);
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(lat, lng),
        map: map
    });
    markersArray.push(marker);
    infowindow = new google.maps.InfoWindow();
    google.maps.event.addListener(marker, 'click', function () {
        var contentString = "<div><iframe id='divframe' name ='framediv' src='" + url + "?id=" + siteid + "'></iframe></div>";
        infowindow.setContent(contentString);
        infowindow.open(map, this);
    });
}
 </script>