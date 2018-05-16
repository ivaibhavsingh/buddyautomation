package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumSetup extends AppElements {
	public static DesiredCapabilities desiredCapabilities;
	public static String appiumServiceUrl;
	public static Properties propObj = new Properties();	
	public static String filename=null;
	public static String apk=null;
	public static Logger log;
	public static AppiumDriverLocalService service= AppiumDriverLocalService.buildDefaultService();
	public static void loadProp() throws IOException{
		log=Logger.getLogger("devpinoyLogger");
		filename="props/project.properties";
		File file = new File(filename);  
		FileInputStream fileInput = new FileInputStream(file);
	    propObj.load(fileInput);
	    log.debug("Properties File Loaded.");
	}
	
	public static void setupAppium() throws InterruptedException, MalformedURLException{
		apk="apk/databuddy.apk";
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("no-reset", true);
		desiredCapabilities.setCapability("full-reset", false);
		desiredCapabilities.setCapability("--session-override", true);
		desiredCapabilities.setCapability("disableAndroidWatchers", true);
		desiredCapabilities.setCapability("autoGrantPermissions", true);
		
		if(service.isRunning()) {
			System.out.println("Service is running, restarting before running the test.");
			service.stop();
			System.out.println("Service stopped.");
		}
		log.debug("Starting Appium Server...");
		System.out.println("Starting Appium Server...");
		service.start();
		log.debug("The server has started.");
		System.out.println("The server has started");
		appiumServiceUrl="http://127.0.0.1:4723/wd/hub";
		Thread.sleep(5000);
		desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		desiredCapabilities.setCapability("deviceName", "Moto C Plus");
		desiredCapabilities.setCapability("platformVersion", "7.0");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("app",apk);
		desiredCapabilities.setCapability("appPackage", "com.databuddy.app");
		desiredCapabilities.setCapability("appActivity", "com.databuddy.app.activities.SplashActivity");
		//desiredCapabilities.setCapability("automationName", "UiAutomator2");
		System.out.println("#########AppiumServiceURL "+appiumServiceUrl);
	}
}
