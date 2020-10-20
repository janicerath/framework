
package testNG.framework;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.XeroPages.loginPO;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClassUsingListerners extends ReusableMethods {
	
	public WebDriver driver;
	loginPO objLogin;
	
	@BeforeClass
	public void setup () throws Exception {
		//launchBrowser("ch");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@BeforeMethod
	public void BeforeMethod () {
		
		driver.get("https://login.xero.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test (priority = 2, dataProvider = "loginUserData")
	public void TC1ABC (String username, String pwd, String xpath) throws Exception{
		objLogin = new loginPO (driver);
		objLogin.login(username, pwd, xpath);
						
	}
	
	@Test (priority = 1)
	public void TC1D () throws Exception {
		objLogin = new loginPO (driver);
		objLogin.forgotPwd("janice_wmtse@yahoo.ca");
		
		
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
	
}
