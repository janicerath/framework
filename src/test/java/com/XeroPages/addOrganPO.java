package com.XeroPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testNG.framework.ReusableMethods;


public class addOrganPO {

	public WebDriver driver;
	ReusableMethods objReusable = new ReusableMethods();
	
	
	@FindBy (xpath = "//div[@class='xrh-appmenucontainer']//button[@data-header-component='menu-trigger']")
	WebElement myXeroDD;
	
	@FindBy (xpath = "//a[@data-name='partner-apps-menu/my-xero']")
	WebElement myXeroBtn;
	
	@FindBy (xpath = "//a[@id='ext-gen1042']")
	WebElement addOrganizationBtn;
	
	@FindBy (xpath = "//input[@data-automationid='organisation-name--input']")
	WebElement businessNamePH;
	
	@FindBy (xpath = "//input[@data-automationid='industry-autocompleter--input']")
	WebElement industryPH;
	
	@FindBy (xpath = "//div[@tabindex='0']")
	WebElement timeZoneDD;
	
	@FindBy (xpath = "//input[@placeholder='Search']")
	WebElement timeZoneSearchBox;
	
	@FindBy (xpath = "//button[@class='xui-pickitem--body']")
	WebElement centralTimeBtn;
	
	//error
	@FindBy (xpath = "//input[@id=\"No, it's just me\"]//../div")
	WebElement noRadioBtn;
	
	@FindBy (xpath = "//button[@data-automationid=\"NewOrgProv-StartTrial\"]")
	WebElement startTrailBtn;
	
	@FindBy (xpath = "//button[@data-automationid=\"NewOrgProv-BuyNow\"]")
	WebElement buyNowBtn;
	
	@FindBy (xpath ="//span[@data-automationid='Early--label']//../div")
	WebElement earlyPlanRadBtn;
	
	@FindBy (id = "continueButton")
	WebElement contPlanBtn;
	
	@FindBy (id = "contactAddress")
	WebElement addPH;
	
	@FindBy (id = "contactCity")
	WebElement cityPH;
	
	@FindBy (xpath = "//input[@name='contactState']//../div/button")
	WebElement stateBtn;	
	
	@FindBy (xpath = "//li[@id='Texas']")
	WebElement txState;
	
	@FindBy (id = "contactPostalCode")
	WebElement zipPH;
	
	@FindBy (id = "stepAccountCreate")
	WebElement createBtn;
	
	public addOrganPO (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void myXeroClick () throws Exception{
		this.myXeroDD.click();
		this.myXeroBtn.click();
		ArrayList<String> windowTab = new ArrayList (driver.getWindowHandles());
		System.out.println(windowTab.size());
		driver.switchTo().window(windowTab.get(1));
		Thread.sleep(2000);
		
	}
	
	public void addOrgan () throws Exception {
		
		this.addOrganizationBtn.click();
		this.businessNamePH.sendKeys("Self");
		this.industryPH.sendKeys("IT Contracting" + Keys.ENTER);
		this.timeZoneDD.click();
		this.timeZoneSearchBox.click();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyPress(KeyEvent.VK_BACK_SPACE);
		rb.keyRelease(KeyEvent.VK_BACK_SPACE);
		
		this.timeZoneSearchBox.sendKeys("Central Time" + Keys.ENTER);
		this.centralTimeBtn.click();
		this.noRadioBtn.click();
	}
	
	public void startTrailClick () {
		this.startTrailBtn.click();
	}
	
	public void buyNowClick () {
		this.buyNowBtn.click();
	}
	
	public void earlyPlanclic() {
		this.earlyPlanRadBtn.click();
		this.contPlanBtn.click();
	}
	
	public void fillPlanInfo () {
		this.addPH.sendKeys("960 Chelsea St");
		this.cityPH.sendKeys("El Paso") ;
		this.stateBtn.click();
		this.txState.click();
		this.zipPH.sendKeys("79903");
		this.createBtn.click();
	}
	
}
