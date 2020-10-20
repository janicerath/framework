package com.XeroPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testNG.framework.ReusableMethods;

public class LogoutPO {
	
	public WebDriver driver;
	ReusableMethods objReusable = new ReusableMethods();
	
		
	@FindBy (xpath = "//button[@title='User Info']")
	WebElement userInfo;
	
	
	@FindBy (xpath = "//a[@data-name='user-menu/log-out']")
	WebElement logoutBtn;
	
	public LogoutPO (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logout () {
		this.userInfo.click();
		this.logoutBtn.click();
	}
	
}
