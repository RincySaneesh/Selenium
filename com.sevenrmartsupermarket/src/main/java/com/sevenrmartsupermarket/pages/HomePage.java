package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalutility;

	@FindBy(xpath = "//a[@class='d-block']")
	WebElement profileName;
	
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	WebElement adminElement;
	
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	WebElement signoutElement;
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	WebElement superMarket;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		generalutility = new GeneralUtility(driver);
		String profile_Name = generalutility.getTextofElement(profileName);
		return profile_Name;
	}
	public String superMarketGetext()
	{
		return superMarket.getText();
	}
	public void logout()
	{
		
	  adminElement.click();
	  signoutElement.click();
		
	}
}
