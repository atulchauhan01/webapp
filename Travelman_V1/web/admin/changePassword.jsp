<%-- 
    Document   : changePassword
    Created on : Oct 31, 2011, 5:15:51 PM
    Author     : technolife
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <%@ taglib prefix="s" uri="/struts-tags"%>
    <head>
        <script type="text/javascript" >
            function compairPassword(){
                //alert("hello testing")
                  var flag="";     
                var password=document.getElementById('newPsd').value;               
                var Repassword=document.getElementById('rNewPsd').value;      
                 //alert("Repassword-2-->"+Repassword)
                if(password==Repassword){
                   // alert("password is match") 
                    flag=true;
                }
                else{
                    document.getElementById("newPsd").focus();
                    document.getElementById('newPsd').value=null;
                    document.getElementById('rNewPsd').value=null;                    
                    document.getElementById('label').innerHTML='*new password not match';
                    //alert("password not match");
                    
                     flag=false;
                }
                return flag;
            }
            
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Change Password</title>
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
                        <tr>
                            <td><a href="addUser" title="" class="likelogin">Create New User </a></td>
                            <td><a href="listUser" title="" class="likelogin"> List All Users </a></td>
                            <td><a href="editUser" title="" class="likelogin"> Edit User Profile </a> </td>
                            <td><a href="changePassword" title="" class="likelogin"> Change Password </a> </td>
                        </tr>
                    </table>
                    <table width="100%">
                        <s:form action="saveNewPassword" method="post" name="changePassword" onsubmit="return compairPassword()">
                            <s:password label="Enter Password" name="password"></s:password>                            
                            <s:password label="Enter New Password" name="newPassword" id="newPsd"></s:password>
                            <s:password label="Re-Enter Password" name="newPasswordCheck" id="rNewPsd"></s:password>
                            <s:label id="label" />
                            <s:submit></s:submit>
                        </s:form>
                    </table> 
                </div>

            </div>

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
                <!--<li><a class="expanded heading">Enquiry</a>
                    <ul class="navigation">
                        <li><a href="#" title="" class="likelogin">Section link here</a></li>
                        <li><a href="#" title="">Section link here</a></li>
                        <li><a href="#" title="">Section link here</a></li>
                    </ul>
                </li>         
                --><li><a class="expanded heading">Administrative</a>
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



