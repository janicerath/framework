package com.XeroPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testNG.framework.ReusableMethods;

public class trailPO {
	
	
	public WebDriver driver;
	ReusableMethods objReusable = new ReusableMethods();
	
	@FindBy (xpath = "//li[@class='global-ceiling-bar-cta2']//a[contains(text(),'Free trial')]")
	WebElement freeTrailBtn;
	
	@FindBy (xpath = "//input[@name='FirstName']")
	WebElement fNamePH;
	
	@FindBy (xpath = "//input[@name='LastName']")
	WebElement lNamePH;
	
	@FindBy (xpath = "//input[@name='EmailAddress']")
	WebElement emailPH;
	
	@FindBy (xpath = "//input[@name='PhoneNumber']")
	WebElement phoneNumPH;
	
	@FindBy (xpath = "//div[@class='recaptcha-checkbox-border']")
	WebElement robotCheckBox;
	
	@FindBy (xpath = "//div[@class='g-recaptcha form-group']//iframe")
	WebElement iFrame;
	
	@FindBy (xpath = "//input[@name='TermsAccepted']")
	WebElement termsCheckBox;
	
	@FindBy (xpath = "//span[@class='g-recaptcha-submit']")
	WebElement submitBtn;
	
	@FindBy (xpath = "//span[@class='form-error-message']")
	WebElement errMsg;
	
	@FindBy (xpath = "//a[contains(text(),'terms')]")
	WebElement termsLink;
	
	@FindBy (xpath = "//a[contains(text(),'privacy')]")
	WebElement privacyLink;
	
	@FindBy (xpath = "//a[contains(text(),'offer details')]")
	WebElement offerLink;

	@FindBy (xpath = "//a[contains(text(),'accountant or bookkeeper')]")
	WebElement accountBookkeeperLink;

	public trailPO (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void freeTrailClick () {
		this.freeTrailBtn.click();
	}
	
	public void setNames (String fName, String lName) {
		this.fNamePH.sendKeys(fName);
		this.lNamePH.sendKeys(lName);
		
	}
	
	public void setEmail (String email) {
		this.emailPH.sendKeys(email);
	}
	
	public void setPhNum (String phNum) {
		this.phoneNumPH.sendKeys(phNum);
	}
	
	public void robotChBox () throws Exception{
		driver.switchTo().frame(iFrame);
		this.robotCheckBox.click();
		
		//driver.switchTo().parentFrame();
	}

	public void termsChBox () {
		this.termsCheckBox.click();
	}
	
	public void submitClick () {
		this.submitBtn.click();
	}
	
	public void errMsgValidation () {
		Assert.assertEquals(this.errMsg.isDisplayed(), true);
	}
	
	public void validate (WebElement ele) {
		Assert.assertEquals(ele.isDisplayed(), true);
	}
	
	public void termsLinkClick () {
		this.termsLink.click();
	}
	
	public void privacyLinkClick () {
		this.privacyLink.click();
	}
	
	public void offerLinkClick () {
		this.offerLink.click();
	}
	
	public void ACBookkeeperClick () {
		this.accountBookkeeperLink.click();
	}
}
