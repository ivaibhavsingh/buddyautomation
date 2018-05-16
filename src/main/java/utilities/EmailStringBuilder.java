package utilities;



import databuddy.databuddy.RunSanityTests;

public class EmailStringBuilder extends AppiumSetup {

	public static StringBuilder email=new StringBuilder();
	
	public static void getEmailString(){	  
	email.append("<html> <br> <font face='calibri' size='3' color='crimson' <b>Hi Team,<b> </html>");
	email.append("<html> <br> "+"<table width='800' border='1' cellpadding='2' cellspacing='0' style='font-family:calibri; size:10pt;'>");
	email.append("<tr> <td colspan='2' align='center'> <font face='calibri' size='4' color='crimson'> <b>DATABUDDY SANITY REPORT</b> </font> </td> </tr>");
	email.append("<tr> <td width='300' align='left'> Databuddy </td> <td width='500' align='center'> Build Version "+AppiumSetup.propObj.getProperty("version")+"</td> </tr>");
	//email.append("<tr> <td align='left'> OPCO Name </td> <td align='center'>"+GlobalDefinition.propObj.getProperty("OPCO_NAME")+"</td> </tr>");
	//email.append("<tr> <td align='left'> Customer Name </td> <td align='center'>"+GlobalDefinition.propObj.getProperty("Customer_Name")+"</td> </tr>");
	//email.append("<tr> <td align='left'> Project Name as in Compass </td> <td align='center'>"+GlobalDefinition.propObj.getProperty("Project_Name")+"</td> </tr>");
	email.append("<tr> <td colspan='2' align='center'> <font face='calibri' size='4' color='crimson'> <b>Test Cases Status Report </b> </font> </td> </tr>");
	email.append("<tr> <td align='left'> Status Summary of Test Cases  </td> <td align='left'> <ul>"+           
	"<li> <ul> "+RunSanityTests.Test1+": "+RunSanityTests.TestS1+" </ul> </li>"+
	"<li> <ul> "+RunSanityTests.Test2+": "+RunSanityTests.TestS2+" </ul> </li>"+
	"<li> <ul> "+RunSanityTests.Test3+": "+RunSanityTests.TestS3+" </ul> </li>"+
	"<li> <ul> "+RunSanityTests.Test4+": "+RunSanityTests.TestS4+" </ul> </li>"+
	"<li> <ul> "+RunSanityTests.Test5+": "+RunSanityTests.TestS5+" </ul> </li>"+
	"<li> <ul> Total Sanity Test Cases Executed: "+RunSanityTests.TotalTestCount+" </ul> </li>"+
    "<li> <ul> Total Test Cases Passed: "+RunSanityTests.PassCount+" </ul> </li>"+" <li> <ul> Total Test Cases Failed: "+RunSanityTests.FailCount+" </ul> </li> </td> </tr> </table>");
	//email.append("<tr> <td colspan='2' align='center'> <font face='calibri' size='4' color='crimson'> <b>Pass Percentage: "+JavaMail.passper+"% </b> </font> </td> </tr> ");
	//email.append("<tr> <td colspan='2' align='center'> <img src=\"cid:image\"> </td> </tr> </table>");
	email.append("<br> <font face='calibri' size='3' color='crimson'> <b>Regards, <br> Vaibhav </b> </br> </html>");
	
	}

	
}
