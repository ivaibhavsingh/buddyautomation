package functions;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import utilities.AppElements;

public class DatabuddyFunctions extends AppElements {
	static String MSISDN=null;
	public static int BidsLeft=0;
	@SuppressWarnings("rawtypes")
	//This is a common function for Login that will be used across the framework.
	public static AndroidDriver Login(AndroidDriver driver, String msisdn) throws InterruptedException {
		Thread.sleep(5000);
		//driver.findElement(By.xpath(SMSPermissionAllow)).click();
		//driver.findElement(By.xpath(CallsPermissionAllow)).click();
		driver.findElement(By.xpath(SignUp)).click();
		driver.findElement(By.id(Msisdn)).sendKeys(msisdn);
		driver.navigate().back();
		driver.findElement(By.xpath(GetOtp)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VerifyButton)).click();
		Thread.sleep(15000);
		driver.findElementById(PopUp).click();
		return driver;
	}

	//This function is for logging into BidnWin using Facebook.
	@SuppressWarnings("rawtypes")
	public static AndroidDriver auctionLogin(AndroidDriver driver) throws InterruptedException {
	
		driver.findElement(By.xpath(Auction)).click();
		driver.findElement(By.xpath(AuctionLogin)).click();
		Thread.sleep(10000);
		driver.findElement(By.id(Continue)).click();
		Thread.sleep(12000);
		Assert.assertEquals(driver.findElement(By.xpath(AssertFBLogin)).getText(), "Bid & Win");
		driver.findElement(By.xpath(Offers)).click();
		return driver;
	}
	
	//This function will open an offer and place a bid
	
	@SuppressWarnings("rawtypes")
	public static AndroidDriver placeBid(AndroidDriver driver) throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PlaceBid)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(BidNumber)).click();
		driver.findElement(By.xpath(Bid)).click();
		driver.findElement(By.xpath(Place)).click();
		Thread.sleep(1000 );
		driver.findElement(By.xpath(Confirm)).click();
		Thread.sleep(3000);
		return driver;
	}
	
	@SuppressWarnings("rawtypes")
	public static AndroidDriver oldPlaceBid(AndroidDriver driver) throws InterruptedException {
		
		/*Thread.sleep(3000);
		driver.findElement(By.xpath(Offers)).click();
		Thread.sleep(2000);*/
		driver.findElement(By.xpath(PlaceBid)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OldVersion)).click();
		Thread.sleep(1000 );
		/*driver.findElement(By.xpath(ETRupee)).sendKeys("10");
		driver.findElement(By.xpath(ETPaisa)).sendKeys("10");*/
		//driver.findElement(By.xpath(OldBid)).click();
		driver.findElement(By.id(OldBid)).click();
		driver.findElement(By.xpath(Confirm)).click();
		Thread.sleep(3000);
		driver.navigate().back();
		
		return driver;
	}
	
	@SuppressWarnings("rawtypes")
	public static AndroidDriver inviteURL(AndroidDriver driver) throws InterruptedException {
		
		/*Thread.sleep(5000);
		driver.openNotifications();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text='MARK AS READ']")).click();*/
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Invite)).click();
		driver.findElement(By.id(OthersBtn)).click();
		driver.findElement(By.xpath(NewMsg)).click();
		//driver.navigate().back();
		driver.findElement(By.xpath(SelNum)).click();
		
		return driver;
	 }

	@SuppressWarnings("rawtypes")
	public static AndroidDriver buyBid(AndroidDriver driver) throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(BuyBids)).click();
		BidsLeft=(int)Integer.parseInt(driver.findElement(By.id(RemainingBids)).getText().toString());
		System.out.println(BidsLeft);
		driver.findElement(By.xpath(TwoBids)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Wallet)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PAY)).click();
		Thread.sleep(2000);
		return driver;
	}

}
