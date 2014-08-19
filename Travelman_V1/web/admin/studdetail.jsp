<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>


<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
         <script language="javascript" type="text/javascript" src="datetimepicker.js">
</script>
  <title>SchoolMan</title>
  
  
  
  <link rel="stylesheet" type="text/css" href="style1/style.css" title="style1" />
</head>

    <body>
        
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1>School Management <span class="logo_colour">System</span></h1>
          
        </div>

     
        
      </div>

	
    <div id="site_content">
      
      <div id="content">
          <s:form action="studentRegistrationAction" method="post">
        <table><tr><td>
                    <td><s:textfield  name="stud_id" label="User_Id " /></td>
                    <td><s:password name="password" label="Password "/></td>
                     
                    <td><s:textfield name="fname" label="Student First Name" required="true"/></td>
                  <td> <s:textfield name="lname" label="Student Last Name" /></td>
                  <td><s:radio name="sgender" list="{'Male','Female'}" label="Gender"></s:radio> </td>
                  
                  <td>Date Of Birth</td><td><input type="Text" name="dob"   id="demo1" maxlength="25" size="25" ><a href="javascript:NewCal('demo1','ddmmmyyyy')"><img src="cal.gif" width="16" height="16" border="0" ></a></td>
                 
                      
                  <td><s:doubleselect  label="Select Class" name="sclass_cat" list="{'PrePrimary', 'Primary', 'Secondary','Higher Secondary'}" 
                                       doubleName="sclass" doubleList="top == 'PrePrimary' ? 
                                           {'Nursery', 'LKG', 'UKG'} : (top == 'Primary' ? 
                                         {'1', '2', '3','4','5'}
                                        
                                          :{'6', '7','8','9','10','11','12'})"/></td>
                  <td><s:select name="subjects" list="{'-LKG-','Hindi','English','-UKG-','Hindi','English','Maths','-Class 1-','Hindi','English','Maths','Science','Social science'}" emptyOption="false" label="Select Subject" multiple="true" Label="Select Subject"></s:select></td>
                   
                  
                  
                  <td><s:textfield  name="father_name" label="Father   Name"/></td>
                   
                    <td><s:textfield  name="mother_name" label="Mother Name"/></td>
                    <td><label>If your family members are study in this school so enter name</label></td>
                    <td><s:textfield  name="family_member" label="Family Member "/></td>
                     
                   <td><s:textfield  name="parents_phoneno" label="Parent Phone Number "/></td>
                   <td><s:textfield  name="parents_mobileno" label="Parent Mobile Number "/></td>
                    <td><s:textfield  name="parents_email" label="Parent Email "/></td>
                 
                   <td><s:textfield  name="cur_address" label="Current Address"/></td>
                   <td><s:textfield  name="cur_pincode" label="Pincode"/></td>
                    <td><s:select name="cur_city" list="{'Delhi','Noida','Bhopal','4','5','6','7','8','9','10','11','12'}" emptyOption="false" label="city"></s:select></td>
                    <td><s:select name="cur_state" list="{'Andaman Nicobar','Andhra Pradesh','Arunanchal Pradesh','Assam','Bihar','Chattisgarh','Goa','Gujarat','Haryana','Himachal Pradesh','Jammu & Kashmir',
                                 'Jharkhand','Karnataka','Kerala','Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram','Nagaland','Orissa','Punjab','Rajasthan','Sikkim','Tamil Nadu','Tripura','Uttar Pradesh','Uttaranchal','West Bengal'}" emptyOption="false" label="State"></s:select></td>
                   <td><s:select name="cur_country" list="{'India','Nepal','Pakistan','Bangladesh'}" emptyOption="false" label="Country"></s:select></td>
                   <td><s:textfield  name="per_address" label="Permanent Address"/></td>
                    <td><s:textfield  name="per_pincode" label="Pincode"/></td>
                    <td><s:select name="per_city" list="{'Delhi','Noida','Bhopal','4','5','6','7','8','9','10','11','12'}" emptyOption="false" label="city"></s:select></td>
                    <td><s:select name="per_state" list="{'Andaman Nicobar','Andhra Pradesh','Arunanchal Pradesh','Assam','Bihar','Chattisgarh','Goa','Gujarat','Haryana','Himachal Pradesh','Jammu & Kashmir',
                                 'Jharkhand','Karnataka','Kerala','Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram','Nagaland','Orissa','Punjab','Rajasthan','Sikkim','Tamil Nadu','Tripura','Uttar Pradesh','Uttaranchal','West Bengal'}" emptyOption="false" label="State"></s:select></td>
                   <td><s:select name="per_country" list="{'India','Nepal','Pakistan','Bangladesh','5','6','7','8','9','10','11','12'}" emptyOption="falses" label="Country"></s:select></td>
                   
                   
                  
                   <td><s:textfield name="sports" label="Sports"/></td>
                   <td><s:submit value="Next"></s:submit></td>
                   
                   
            </tr>
        </table>
        </s:form>
      </div>
    </div>
    </div>

    </body>
        

</html>