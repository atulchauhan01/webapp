function search_Validator()
{

var checkOK = "0123456789";

var checkStr = document.searchForm.vehicleId.value;

var allValid = true;
var allNum = "";

for (i = 0;  i < checkStr.length;  i++)
{
ch = checkStr.charAt(i);
for (j = 0;  j < checkOK.length;  j++)
if (ch == checkOK.charAt(j))
break;
if (j == checkOK.length)
{
allValid = false;
break;
}
if (ch != ",")
allNum += ch;
}
if (!allValid)
{
alert("Please enter only digit characters in the \"Vehicle Id \" field.");
document.searchForm.vehicleId.focus();
return false;
}
}
     