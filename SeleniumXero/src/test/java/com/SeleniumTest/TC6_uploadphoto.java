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
import com.XeroPages.addOrganPO;
import com.XeroPages.loginPO;
import com.XeroPages.trailPO;
import com.XeroPages.uploadPhotoPO;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC6_uploadphoto extends ReusableMethods{
	
	loginPO objLoginPO;
	uploadPhotoPO objuploadPO;
	addOrganPO objAddOrgan;
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath1 = System.getProperty("user.dir")+"/ExtentReport/TC6_upload.html";
	
	
	@BeforeTest
	@Parameters("browser")
	public void setup ( String browser ) throws Exception {
		
		//launchBrowser("ch");
		
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
	
	@Test //(enabled = false)
	public void TC6 () throws Exception {
		
		objLoginPO = new loginPO (driver);
		objuploadPO = new uploadPhotoPO(driver);
		logger = reports.startTest("TC6");
		objLoginPO.loginXero();
		objuploadPO.uploadPhoto("C:\\Users\\Danielle's Ideapad\\eclipse-workspace\\eclipse-workspace\\jpeg\\S3Q5.jpg");
		
		
		takeScreenShot("/TC6uploadPhoto/TC6");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/TC6uploadPhoto/TC6.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
			
		reports.endTest(logger);
		
	}
	
	@Test  //(enabled = false)
	public void TC8A_addOrganization () throws Exception {
		objLoginPO = new loginPO (driver);
		objAddOrgan = new addOrganPO (driver);
		objLoginPO.login("gopala.anumanchipalli@gmail.com", "password12", "//div[@class='xrh-header--main']");
		objAddOrgan.myXeroClick();
		objAddOrgan.addOrgan();
		objAddOrgan.startTrailClick();
			
		logger = reports.startTest("TC8A");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='xui-pageheading--title']")).isDisplayed(), true);
		takeScreenShot("/addOrganization/TC8A");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/addOrganization/TC8A.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		reports.endTest(logger);
	}
	
	@Test  //(enabled = false)
	public void TC8B_addOrganBuy () throws Exception {
		objLoginPO = new loginPO (driver);
		objAddOrgan = new addOrganPO (driver);
		objLoginPO.login("gopala.anumanchipalli@gmail.com", "password12", "//div[@class='xrh-header--main']");
		objAddOrgan.myXeroClick();
		objAddOrgan.addOrgan();
		objAddOrgan.buyNowClick();
		objAddOrgan.earlyPlanclic();
		objAddOrgan.fillPlanInfo();
		
		
		logger = reports.startTest("TC8B");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Select plan')]")).isDisplayed(), true);
		takeScreenShot("/addOrganBuy/TC8B");
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/addOrganBuy/TC8B.png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		reports.endTest(logger);
	}
	
	@AfterSuite
	public void AfterSuite () {
		reports.flush();
		//quitBrowser();
	}
}
