package com.XeroPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testNG.framework.ReusableMethods;


public class loginPO {

	public WebDriver driver;
	ReusableMethods objReusable = new ReusableMethods();
	
	@FindBy (id = "email")
	WebElement usernamePH;
	
	@FindBy (id = "submitButton")
	WebElement signinBtn;
	
	@FindBy (id ="password")
	WebElement pwdPH;
	
	@FindBy (xpath = "//a[@class='forgot-password-advert']")
	WebElement forgotPwdLink;
	
	@FindBy (xpath = "//input[@id='UserName']")
	WebElement emailPH;
	
	@FindBy (xpath = "//span[@class='text']")
	WebElement sendLink;
	
	
	public loginPO (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername (String username) {
		usernamePH.clear();
		usernamePH.sendKeys(username);
	}
	
	public void setPwd (String pwd)  {
		pwdPH.clear();
		pwdPH.sendKeys(pwd);
	}

	public void login (String username, String pwd, String xpath) {
		this.setUsername(username);
		this.setPwd(pwd);
		this.signinBtn.click();
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).isDisplayed(), true);
	}
	
	public void setForgotPwdEmail (String emailId) {
		emailPH.clear();
		emailPH.sendKeys(emailId);
	}
	public void forgotPwd (String emailId) throws Exception{
		this.forgotPwdLink.click();
		Thread.sleep(2000);
		this.emailPH.sendKeys(emailId);
		this.sendLink.click();
		
	}
	
	public void loginXero() {
		this.setUsername("janice_wmtse@yahoo.ca");
		this.setPwd("Xero1234");
		this.signinBtn.click();
	}
}
