package databuddy.databuddy;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import functions.DatabuddyFunctions;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import utilities.AppElements;
import utilities.AppiumSetup;
import utilities.DatabaseConnectivity;
import utilities.JavaMail;

public class RunSanityTests extends AppElements{
	
	static String MSISDN=null;
	public static String Test1, Test2, Test3, Test4, Test5=null;
	public static String TestS1="Fail", TestS2="Fail", TestS3="Fail", TestS4="Fail", TestS5="Fail";
	public static int PassCount, FailCount, TotalTestCount=0;
	@SuppressWarnings("rawtypes")
	static AndroidDriver dr;
	//static AppiumDriver<MobileElement> dr;
	static String AssertString=null;
		
		@SuppressWarnings("rawtypes")
		@BeforeClass
		public void init() throws InterruptedException, IOException {
			AppiumSetup.loadProp();
			AppiumSetup.setupAppium();
			MSISDN=AppiumSetup.propObj.getProperty("MSISDN");
			dr=new AndroidDriver(new URL(AppiumSetup.appiumServiceUrl), AppiumSetup.desiredCapabilities);
			AppiumSetup.log.debug("The APK has been installed, opening app.");
		}
		
		@Test (priority=0)
		public void login() throws InterruptedException {
			
			dr=DatabuddyFunctions.Login(dr, MSISDN);
			WebElement home=dr.findElement(By.xpath(HomeAssert));
			AssertString=home.getText();
			//Assert.assertEquals(AssertString, "Home");
			if(AssertString.compareTo("Home")==0) {
				Test1="Login to Databuddy via. OTP";
				Assert.assertEquals(0, 0);
				TestS1="Pass";
				PassCount=PassCount+1;
			}
			else {
				Test1="Login to Databuddy via. OTP";
				FailCount=FailCount+1;
				Assert.fail();
			}
		}
		
		@Test (priority=1)
		public void loginForAuctions() throws InterruptedException {
			
			dr=DatabuddyFunctions.auctionLogin(dr);
			dr=DatabuddyFunctions.buyBid(dr);
			//Assert.assertEquals(DatabuddyFunctions.BidsLeft+2,(int)Integer.parseInt(dr.findElement(By.id(RemainingBids)).getText().toString()));
			if(((int)DatabuddyFunctions.BidsLeft+2)==(int)Integer.parseInt(dr.findElement(By.id(RemainingBids)).getText().toString())) {
				Test2="Login with Facebook and purchase Bids";
				Assert.assertEquals(0, 0);
				PassCount=PassCount+1;
				TestS2="Pass";
			}
			else {
				Test2="Login with Facebook and purchase Bids";
			 FailCount=FailCount+1;
			 Assert.fail();
			}
		}
		
		@Test (priority=2)
		public void placeBids() throws InterruptedException, ClassNotFoundException, SQLException {
			
			DatabaseConnectivity.deleteBid();
			dr=DatabuddyFunctions.placeBid(dr);
			WebElement AuctionScreen=dr.findElement(By.xpath(PostBid));
			AssertString=AuctionScreen.getText();
			if(AssertString.compareTo("Bid")==0) {
				Test3="Place Bids using the new option";
				PassCount=PassCount+1;
				Assert.assertEquals(0, 0);
				TestS3="Pass";
			}
			else {
				Test3="Place Bids using the new option";
				FailCount=FailCount+1;
				Assert.fail();
			}
			
		}
		
		@Test (priority=3)
		public void placeOldBids() throws ClassNotFoundException, SQLException, InterruptedException {
			
			DatabaseConnectivity.deleteBid();
			dr=DatabuddyFunctions.oldPlaceBid(dr);
			WebElement AuctionScreen=dr.findElement(By.xpath(PostBid));
			AssertString=AuctionScreen.getText();
			if(AssertString.compareTo("Bid")==0) {
				Test4="Place bids using the old version";
				PassCount=PassCount+1;
				Assert.assertEquals(0, 0);
				TestS4="Pass";
			}
			else {
				Test4="Place bids using the old version";
				FailCount=FailCount+1;
				Assert.fail();
			}
		}
		
		@Test (priority=4)
		public void inviteFriends() throws InterruptedException {
			
			dr=DatabuddyFunctions.inviteURL(dr);
			WebElement MsgEl=dr.findElement(By.xpath(Msg));
			AssertString=MsgEl.getText().toString();
			if(AssertString.isEmpty()) {
				Test5="Testing the Invite option";
				FailCount=FailCount+1;
				Assert.fail();
			}
			else {
				Test5="Testing the Invite option";
				PassCount=PassCount+1;
				Assert.assertEquals(1, 1);
				TestS5="Pass";
			}
		}
		@AfterClass
		public void teardown() throws IOException {
			TotalTestCount=PassCount+FailCount;
			System.out.println("Test Cases Pass Count is "+PassCount);
			System.out.println("Test Cases Fail Count is "+FailCount);
			System.out.println("Total Test Count is" +TotalTestCount);
			JavaMail.mail();
			dr.quit();
			AppiumSetup.service.stop();
		}
}
