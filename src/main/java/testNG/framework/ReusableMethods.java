package testNG.framework;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {
public WebDriver driver;
		
	
	public void launchBrowser(String brType) {
		switch (brType) {
		case("ch"):
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		
		case("edge"):
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
			
		case("ff"):
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
			
		default:
			break;
					
		}
	}
	
	public void ufClickEle (WebElement ele) {
		
		ele.click();
	}
	
	public void explicitWait (WebElement ele, int x) {
		WebDriverWait wait = new WebDriverWait (driver, x);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	

	public void loginClick () {
		WebElement loginBtn = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		explicitWait(loginBtn, 5);
		loginBtn.click();
	}
	public String takeScreenShot (String fileName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/"+fileName+".jpeg";
		File dest = new File (screenshotPath);
		FileUtils.copyFile(source, dest);
		return screenshotPath;
	}
	
	public void autocompleteSelect (WebElement ele, String timeZone) {
		try {
		explicitWait(ele, 5);
		List<WebElement> autocompleteList = driver.findElements(By.xpath("//input[@id=\"myInput\"]/../div/div"));
		for (WebElement optionToSelect : autocompleteList) 
		{
			if (optionToSelect.getText().equalsIgnoreCase(timeZone))
				optionToSelect.click();
		}
		} catch(NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} 
		
	}
	
	
	public void closeBrowser () {
		driver.close();
	}
	
	public void quitBrowser () {
		driver.quit();
	}
}//end of main()
	

