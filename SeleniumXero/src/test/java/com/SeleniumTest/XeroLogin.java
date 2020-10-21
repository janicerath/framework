package com.SeleniumTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.XeroPages.loginPO;
import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class XeroLogin extends ReusableMethods{
	
	loginPO objLogin;
	
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath1 = System.getProperty("user.dir")+"/ExtentReport/loginReport.html";
	
		
	@BeforeClass
	@Parameters("browser")
	public void setup (String browser) throws Exception {
		
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
	
		
	@Test (priority = 2, dataProvider = "loginUserData")
	public void TC1ABC (String username, String pwd, String xpath) throws Exception{
		objLogin = new loginPO (driver);
		logger = reports.startTest("TC1ABC"+username+"\t"+pwd);
		objLogin.login(username, pwd, xpath);
		takeScreenShot("/login/"+username+"_"+pwd);
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/login/"+username+"_"+pwd+".png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		reports.endTest(logger);
				
	}
	
	@Test (priority = 1)
	public void TC1D () throws Exception {
		objLogin = new loginPO (driver);
		logger = reports.startTest("TC1D");
		objLogin.forgotPwd("janice_wmtse@yahoo.ca");
		String fileName = "login/TC1D";
		takeScreenShot(fileName);
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/"+fileName+".png";
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		reports.endTest(logger);
	}
	
	@DataProvider (name = "loginUserData")
	public Object[][] getDataForLogin() throws Exception{
		return readExcelAndReturnObject(System.getProperty("user.dir")+"/resources/TestData/username_pwd.xls");
	}
	
	public Object[][] readExcelAndReturnObject(String sFile) throws Exception{
		
		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
		HSSFSheet myExcleSheet = myExcelBook.getSheet("Sheet1");
		HSSFRow row1 = myExcleSheet.getRow(0);
		System.out.println(myExcleSheet.getPhysicalNumberOfRows());
			int iCountCol =row1.getLastCellNum();
			int iCountRow = myExcleSheet.getPhysicalNumberOfRows();
			Object[][] excelData= new Object[iCountRow][iCountCol]; 
			for(int countRow=0;countRow<iCountRow;countRow++) {
				for(int countCol = 0; countCol<iCountCol;countCol++) {
				
					HSSFRow tempRow=myExcleSheet.getRow(countRow);
					String sTemp;
					try {
					sTemp=tempRow.getCell(countCol).getStringCellValue();
					}catch (NullPointerException b) {
						sTemp="";
					}catch(Exception a) {
						sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
					}
					excelData[countRow][countCol] = sTemp;
				}
				
			}
				
			return excelData;
		}
	
	@AfterSuite
	public void AfterSuite () {
		reports.flush();
		quitBrowser();
	}
	
	
}

