package com.XeroPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.SeleniumTest.ReusableMethods;


public class uploadPhotoPO {

	public WebDriver driver;
	ReusableMethods objReusable = new ReusableMethods();
	
	@FindBy (xpath = "//button[@title='User Info']")
	WebElement userInfoBtn;
	
	@FindBy (xpath = "//a[@data-name='user-menu/profile']")
	WebElement editProfile;
	
	@FindBy (xpath ="//span[@id='button-1041-btnInnerEl']")
	WebElement uploadImage;
	
	@FindBy (xpath = "//input[@id='filefield-1174-button-fileInputEl']")
	WebElement browseBtn;
		
	@FindBy (xpath = "//div[@id='panel-1040-innerCt']")
	WebElement photoIcon;
	
	@FindBy (xpath = "//a[@id='button-1178-btnEl']")
	WebElement uploadBtn;
	
	
	public uploadPhotoPO (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void uploadPhoto (String filePath) throws Exception {
		this.userInfoBtn.click();
		this.editProfile.click();
		this.uploadImage.click();
		this.browseBtn.sendKeys(filePath);
		Thread.sleep(2000);
		this.uploadBtn.click();
		
		Assert.assertEquals(photoIcon.isDisplayed(), true);
	}
	
	
}
