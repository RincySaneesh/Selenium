package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class PushNotificationPage
{
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream ip;
	GeneralUtility generalutility;

	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushnotificationField;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement TitleField;

	@FindBy(xpath = "//input[@id='description']")
	WebElement DescriptionField;

	@FindBy(xpath = "//button[@type='submit']")					
	WebElement SendButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert alert-success alert-dismissible')]")					
	WebElement alertMessage;

	public PushNotificationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPushNotificationField()
	{
		pushnotificationField.click();
	}

	public void enterTitle(String title) 
	{
		TitleField.sendKeys(title);
	}

	public void enterDescription(String description)
	{
		DescriptionField.sendKeys(description);
	}

	public void clickSendKey() 
	{
		SendButton.click();
	}

	public void sendNotification(String title, String description)
	{
		enterTitle(title);
		enterDescription(description);
		clickSendKey();
	}
	
	public boolean checkPushNotificationMsg(String message)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.isWordPresent(alertMessage, message);
	}
}
