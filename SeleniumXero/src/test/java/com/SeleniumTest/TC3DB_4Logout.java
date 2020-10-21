package com.SeleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.XeroPages.DashBoardPO;
import com.XeroPages.LogoutPO;
import com.XeroPages.loginPO;
import com.XeroPages.trailPO;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC3DB_4Logout extends ReusableMethods{
	
	DashBoardPO objDBPO;
	loginPO objLoginPO;
	LogoutPO objLogoutPO;
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath1 = System.getProperty("user.dir")+"/ExtentReport/TC3.html";
	
	
	@BeforeTest
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
		
		driver.get("https://login.xero.com/");
	
	}
	
	@Test
	public void TC3 () throws Exception {
		objDBPO = new DashBoardPO (driver);
		objLoginPO = new loginPO (driver);
		logger = reports.startTest("TC3");
		objLoginPO.loginXero();
		objDBPO.dashboardClick();
		objDBPO.accountsClick();
		objDBPO.reportsClick();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Reports')]")).isDisplayed(), true);
		takeScreenShot("/TC3Dashboard/TC3a");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/TC3Dashboard/TC3a.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		objDBPO.contactClick();
		
		objDBPO.setSearchBox("Files");
		takeScreenShot("/TC3Dashboard/TC3b");
		screenshotPath = System.getProperty("user.dir")+"/ScreenShot/TC3Dashboard/TC3b.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		objDBPO.helpClick();
		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Help')]")).isDisplayed(), true);
		takeScreenShot("/TC3Dashboard/TC3c");
		screenshotPath = System.getProperty("user.dir")+"/ScreenShot/TC3Dashboard/TC3c.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		reports.endTest(logger);
		
	}
	
	@Test
	public void TC4_logout () throws Exception {
		objLoginPO = new loginPO (driver);
		objLogoutPO = new LogoutPO (driver);
		logger = reports.startTest("TC4");
		objLogoutPO.logout();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Welcome to Xero')]")).isDisplayed(), true);
		takeScreenShot("/TC4Logout/TC4");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/TC4Logout/TC4.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		reports.endTest(logger);
	}
	
	
	@AfterSuite
	public void AfterSuite () {
		reports.flush();
		quitBrowser();
	}
}
