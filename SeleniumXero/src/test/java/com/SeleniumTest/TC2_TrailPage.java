package com.SeleniumTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.XeroPages.trailPO;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC2_TrailPage extends ReusableMethods {
	
	trailPO objTrailPO;
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath1 = System.getProperty("user.dir")+"/ExtentReport/TC2_TrailPage.html";
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup (String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")){
			launchBrowser("ch");
		}else if (browser.equalsIgnoreCase("edge")){
			launchBrowser("edge");
		}
		reports = new ExtentReports(sPath1);				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void BeforeMethod () {
		
		driver.get("https://www.xero.com/us/");
	
	}
	
	@Test (priority = 10)
	public void TC2A () throws Exception {
		objTrailPO = new trailPO (driver);
		logger = reports.startTest("TC2A");
		objTrailPO.freeTrailClick();
		objTrailPO.setNames("Jane", "Doe");
		objTrailPO.setEmail("janeDoe@yahoo.com");
		objTrailPO.setPhNum("7811232231");
		objTrailPO.termsChBox();
		objTrailPO.robotChBox();
		objTrailPO.submitClick();
		
		takeScreenShot("/trail/TC2A");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/trail/TC2A.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		reports.endTest(logger);
		
	}
	
	@Test (priority = 0)
	public void TC2B () throws Exception {
		objTrailPO = new trailPO (driver);
		logger = reports.startTest("TC2B");
		objTrailPO.freeTrailClick();
		objTrailPO.submitClick();
		objTrailPO.errMsgValidation();
		
		takeScreenShot("/trail/TC2B1");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/trail/TC2B1.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		
		objTrailPO.setEmail("jancie122");
		objTrailPO.submitClick();
		WebElement errMsg = driver.findElement(By.xpath("//span[contains(text(),'Email address is invalid')]"));
		Assert.assertEquals(errMsg.isDisplayed(), true);
		takeScreenShot("/trail/TC2B2");
		screenshotPath = System.getProperty("user.dir")+"/ScreenShot/trail/TC2B2.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		
		reports.endTest(logger);
	}
	
	@Test (priority = 1)
	public void TC2C () throws Exception {
		objTrailPO = new trailPO (driver);
		logger = reports.startTest("TC2C");
		objTrailPO.freeTrailClick();
		objTrailPO.termsLinkClick();
		ArrayList<String> windowTabs = new ArrayList (driver.getWindowHandles());
		driver.switchTo().window(windowTabs.get(1));
		objTrailPO.validate(driver.findElement(By.xpath("//h1")));
		takeScreenShot("/trail/TC2C1");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/trail/TC2C1.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		driver.switchTo().defaultContent();
		objTrailPO.privacyLinkClick();
		windowTabs = new ArrayList (driver.getWindowHandles());
		driver.switchTo().window(windowTabs.get(1));
		objTrailPO.validate(driver.findElement(By.xpath("//h1")));
		takeScreenShot("/trail/TC2C2");
		screenshotPath = System.getProperty("user.dir")+"/ScreenShot/trail/TC2C2.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));

		reports.endTest(logger);
		driver.switchTo().defaultContent();
		
	}
	
	@Test (priority = 2)
	public void TC2D () throws Exception {
		objTrailPO = new trailPO (driver);
		logger = reports.startTest("TC2D");
		objTrailPO.freeTrailClick();
		objTrailPO.offerLinkClick();
		ArrayList<String> windowTabs = new ArrayList (driver.getWindowHandles());
		driver.switchTo().window(windowTabs.get(2));
		objTrailPO.validate(driver.findElement(By.xpath("//h1")));
		takeScreenShot("/trail/TC2D");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/trail/TC2D.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		reports.endTest(logger);
		driver.switchTo().defaultContent();
		
	}

	
	@Test (priority = 3)
	public void TC2E () throws Exception {
		objTrailPO = new trailPO (driver);
		logger = reports.startTest("TC2E");
		objTrailPO.freeTrailClick();
		objTrailPO.ACBookkeeperClick();
		objTrailPO.validate(driver.findElement(By.xpath("//h2")));
		takeScreenShot("/trail/TC2E");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/trail/TC2E.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		reports.endTest(logger);
		
	}
	
	@AfterSuite
	public void AfterSuite () {
		reports.flush();
		quitBrowser();
	}
	
}
