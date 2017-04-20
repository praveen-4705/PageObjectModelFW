package com.testscripts;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.util.EmailReport;
import com.util.Screenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {

	protected AndroidDriver<MobileElement> driver;
	
	protected ExtentReports extentReports;
	protected ExtentHtmlReporter extentHtmlReporter;
	protected ExtentTest extentTest;
	
	DesiredCapabilities desiredCapabilities;
	
	private static Logger log	= Logger.getLogger(BaseTest.class);

	public void createDriver() {
		
		log.info("Setting the Capabilities");
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/test/java/com/backup/apps/redBus.apk");

		try {
			log.info("Setting Driver");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeMethod(alwaysRun = true)
	public void initDriver(Method m) {
		createDriver();
		loggerSetup();
		setUpExtentReports(m.getName());
		log.info("Resetting App");
		driver.resetApp();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		
		
		
		if (result.isSuccess()) {
			
			Screenshot.getScreenshot(driver, result.getName() + "- Pass");
			
			String destPath = System.getProperty("user.dir") + "/src/test/java/com/screenshot/"+result.getName() + "- Pass.jpeg";
			
			extentTest.pass("Test Passed");
			
			try {
				extentTest.addScreenCaptureFromPath(destPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			Screenshot.getScreenshot(driver, result.getName() + "- Fail");
			
			String destPath = System.getProperty("user.dir") + "/src/test/java/com/screenshot/"+result.getName() + "- Fail.jpeg";
			
			extentTest.fail(result.getThrowable());
			
			try {
				extentTest.addScreenCaptureFromPath(destPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		extentReports.flush();
		
		log.info("Quiting Driver");
		
		driver.quit();
		
		EmailReport.sendReport();
	}
	
	
	public void loggerSetup(){
		System.setProperty("logfilename", System.getProperty("user.dir")+"/src/test/java/com/logger/logFile");
		DOMConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/com/logger/log4j.xml");
	}
	
	public void setUpExtentReports(String testName){
		
		extentHtmlReporter	= new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/reports/AutomationReport.html");
		
		extentHtmlReporter.config().setDocumentTitle("Appium Automation Test Report");
		
		extentHtmlReporter.config().setReportName("Automation Report");
		
		extentHtmlReporter.config().setTheme(Theme.DARK);
		
		extentReports	= new ExtentReports();
		
		extentReports.attachReporter(extentHtmlReporter);
		
		
		extentTest	= extentReports.createTest(testName);
		
	}

}
