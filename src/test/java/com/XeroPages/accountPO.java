package com.XeroPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testNG.framework.ReusableMethods;


public class accountPO {
	
	public WebDriver driver;
	ReusableMethods objReusable = new ReusableMethods();
	
		
	@FindBy (xpath = "//button[@title='User Info']")
	WebElement userInfo;
	
	
	@FindBy (xpath = "//a[@data-name='user-menu/account']")
	WebElement accountBtn;
	
	public accountPO (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void accountPage () {
		this.userInfo.click();
		this.accountBtn.click();
	}
	
}
