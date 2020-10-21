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
import com.XeroPages.accountPO;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC10account extends ReusableMethods{
	
	loginPO objLoginPO;
	accountPO objAccountPO;
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath1 = System.getProperty("user.dir")+"/ExtentReport/TC10.html";
	
	
	@BeforeTest
	//@Parameters("browser")
	public void setup () throws Exception {
		
		
		launchBrowser("edge");
		/*
		if(browser.equalsIgnoreCase("chrome")){
			launchBrowser("ch");
		}else if (browser.equalsIgnoreCase("edge")){
			launchBrowser("edge");
		}*/
		reports = new ExtentReports(sPath1);				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void BeforeMethod () {
		
		driver.get("https://login.xero.com/");
	
	}
	
	@Test
	public void TC10 () throws Exception {
		objAccountPO = new accountPO (driver);
		objLoginPO = new loginPO (driver);
		logger = reports.startTest("TC3");
		objLoginPO.loginXero();
		objAccountPO.accountPage();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Account')]")).isDisplayed(), true);
		takeScreenShot("/TC10Account/TC10a");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/TC10Account/TC10a.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		
		reports.endTest(logger);
		
	}
	
	
	
	@AfterSuite
	public void AfterSuite () {
		reports.flush();
		quitBrowser();
	}
}
