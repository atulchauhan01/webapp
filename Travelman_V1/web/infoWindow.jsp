<%-- 
    Document   : test
    Created on : Sep 8, 2011, 3:26:41 PM
    Author     : ce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="http://apis.mapmyindia.com/v2.0/mapApi/licKey=1009e2cdfd6b0d63bc08d9c982a23dc4&platform=java"></script>
        <script type="text/javascript">
            var map =null;
            var mark=null;
        </script>
    </head>
    <body>
        <div class="map" id="MapDiv" style="border:1px solid #999;width:649px;height:457px;">
            <div style="position:absolute; bottom:20px; right:50px; z-index:10000">
                <img title="MapmyIndia.com" alt="MapmyIndia.com" src="images/watermark.gif"/>
            </div>
            <script type="text/javascript">
                var _X = '77.2197173068909';
                var _Y = '28.632715604525647';
                var pt = new Point(_X, _Y);
                map = $("#MapDiv").MireoMap();
                //var routeDrawer = new RouteDrawer(map);
                var imgPath = "images/home.png";
                $().ready(function() {

                    try {
                        // $("#map_alt_div").hide();
                        //  $("#map_alt_text").html("");
                        map.MireoMap("setCenterAndZoomLevel",pt ,4);
                        var Overlays = {
                            addMarker : function(mark) {
                                marker.push(mark);
                            }
                        }

                        var elem   = $(HTMLHelper.mapMarker(imgPath, 37,35));
                        var marker = map.MireoMap("addMarker", elem, pt);
                        Overlays.addMarker(marker);
                        elem.mouseover(function() {
                            var infoDiv = GeocodinginfoDiv.createInfoDiv("text1","text2");
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
                        map.mousemove(function(e){
                            $("#contextMenu").hide();
                        } );
                        // ,
                    } catch(e) {
                        alert(e);
                    }
                });

                
            </script>

        </div>

        <a href="firstMap.jsp">First Map</a>
        <a href="Polyline.jsp">Polyline</a>
        <a href="polygons.jsp">Polygons</a>
        <a href="infoWindow.jsp">Info Window</a>
    </body>
</html>
