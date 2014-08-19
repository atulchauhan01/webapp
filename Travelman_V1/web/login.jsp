<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<%@ taglib prefix="s" uri="/struts-tags"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Vehicle Manager</title>
		<link href="styles/layout.css" rel="stylesheet" type="text/css" />
		<link href="styles/wysiwyg.css" rel="stylesheet" type="text/css" />
		<!-- Theme Start -->
		<link href="themes/blue/styles.css" rel="stylesheet" type="text/css" />
		<!-- Theme End -->
                <script type="text/javascript">
                    function onLoad(){
                        document.loginForm.uemail.focus();
                    }
                    
                </script>>
	</head>
        <body id="homepage" onload="onLoad()">
		<div id="header">
			<a href="" title=""><img src="img/cp_logo.png"
					alt="Control Panel" class="logo" /> </a>
			
			<%-- login code is written below and this code is left for further use
			<div id="loginarea">
				<s:form action="loginAction" method="post" name="loginAction">
					<s:textfield key="Login" name="loginid" class="searchbox" />
					<s:textfield key="Password" name="password" class="searchbox" />
					<input type="submit" value="Login" class="searchbtn" />
				</s:form>

			</div>
		--%>
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
						Travelman ( Your Online Vehicle Manager ) 
					</h2>
				</div>
				<div class="contentbox" style="size: 100px;">
					<table width="50%" height="50%">
					<thead>
                    	
                    </thead>
                    <tbody>
                     
                    	<tr>
					    <img src="img/logo.png" alt="Techno" />
					    </tr>
					  </tbody>  
					</table>
					
					
					<div style="clear: both;"></div>
				</div>

			</div>


			<div style="clear: both;"></div>


			<div id="footer">
				&copy; Copyright 2011, Techno Life. All Rights Reserved.
			</div>

		</div>
		<!-- Right Side/Main Content End -->

		<!-- Left Dark Bar Start -->
		<div id="leftside">
		  <table width="210" border="0" cellpadding="0" align="">
		  <form action="loginAction" method="post" name="loginForm">
            <tr>
              <td width="79"><b><font color="white">Login Id</font></b></td>
              <td width="125"><input type="text" name="uemail" size="17" /></td>
            </tr>
            <tr>
              <td><b><font color="white">Password</font></b></td>
              <td><input type="password" name="password" size="17"/></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="34"> <input name="submit" type="submit" value="Login" align="right"/></td>
            </tr>
            </form>
          </table >
		  <!--<ul id="nav">
				<li>
					<ul class="navigation">
						<li class="heading selected">
							Vehicles Current Status						<span class="user">
							
							</span></li>
						<li>
							<a href="#" title="">Home</a>						</li>
					</ul>
				</li>
				<li>
					<a class="collapsed heading">Tracking</a>
					<ul class="navigation">
						<li>
							<a href="#" title="">Section link here</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
					</ul>
				</li>
				<li>
					<a class="expanded heading">Enquiry</a>
					<ul class="navigation">
						<li>
							<a href="#" title="" class="likelogin">Section link here</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
					</ul>
				</li>
				<li>
					<a class="expanded heading">Admin</a>
					<ul class="navigation">
						<li>
							<a href="userManageMainAction" title="" class="likelogin">User
								Management</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
					</ul>
				</li>
				<li>
					<a class="expanded heading">Support</a>
					<ul class="navigation">
						<li>
							<a href="#" title="" class="likelogin">Section link here</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
					</ul>
				</li>
				<li>
					<a class="expanded heading">Report</a>
					<ul class="navigation">
						<li>
							<a href="#" title="" class="likelogin">Section link here</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
						<li>
							<a href="#" title="">Section link here</a>						</li>
					</ul>
				</li>
		  </ul>
	--></div>
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
