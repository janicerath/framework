package com.XeroPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testNG.framework.ReusableMethods;

public class DashBoardPO {
	
	public WebDriver driver;
	ReusableMethods objReusable = new ReusableMethods();
	
	@FindBy (xpath = "//a[@name='navigation-menu/dashboard']")
	WebElement dashboardBtn;
	
	@FindBy (xpath = "//button[@data-name='navigation-menu/accounting']")
	WebElement accountsDD;
	
	@FindBy (xpath = "//a[contains(text(),'Reports')]")
	WebElement reportBtn;
	
	@FindBy (xpath = "//button[@data-name='navigation-menu/contacts']")
	WebElement contactsBtn;
	
	@FindBy (xpath = "//button[@title='Quick Launch']")
	WebElement quickLaunchBtn;
	
	@FindBy (id ="reportcenter-search-field")
	WebElement searchBox;
	
	@FindBy (xpath = "//button[@title='Help']")
	WebElement helpTab;
	
	
	public DashBoardPO (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void dashboardClick () {
		this.dashboardBtn.click();
	}
	
	public void accountsClick () {
		this.accountsDD.click();
	}
	
	public void reportsClick() {
		this.reportBtn.click();
	}
	
	public void contactClick () {
		this.contactsBtn.click();
	}
	
	public void quickLaunchClick () {
		this.quickLaunchBtn.click();
	}
	
	public void setSearchBox (String searchItem) {
		this.searchBox.sendKeys(searchItem);
	}
	
	public void helpClick () {
		this.helpTab.click();
	}
	
}
