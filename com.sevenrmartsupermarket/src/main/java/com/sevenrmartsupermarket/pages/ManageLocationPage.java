package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageLocationPage
{
	WebDriver driver;
	PageUtility pageUtility;
	GeneralUtility generalUtility;
	PageUtility pageutility;
	
	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement ScrollPushnotificationField;
	
	@FindBy(xpath="//html//body//div//div[1]//section//div//div//div[11]//div//a")
	WebElement ManageLocation ;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement AddNewLocation ;
	
	@FindBy(xpath="//select[@id='country_id']")
	WebElement CountryField;
	
	@FindBy(xpath="//select[@id='st_id']")
	WebElement StateField;
	
	@FindBy(xpath="//input[@id='location']")
	WebElement LocationField;
	
	@FindBy(xpath="//input[@id='delivery']")
	WebElement DeliveryChargeField;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement SaveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement LocationAddedAlertMsg;
	
	public ManageLocationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void scrollAndClickManageLocationPage()
	{
		pageutility=new PageUtility(driver);
		pageutility.scrollIntoElementView(ScrollPushnotificationField);
		pageutility.scrollAndClick(ManageLocation);
		
	}
	public void clikAddNewLocation()
	{
		
		AddNewLocation.click();
		
	}
	public void selectCountry()
	{
		CountryField.click(); 
		Select countryDropDown=new Select(CountryField);
		WebElement selectedelement=countryDropDown.getFirstSelectedOption();
		String selectedCountry=selectedelement.getText();
		System.out.println(selectedCountry);
		
	}
	public void selectState()
	{
		StateField.click(); 
		Select StateDropDown=new Select(StateField);
		WebElement selectedelement=StateDropDown.getFirstSelectedOption();
		String selectedState=selectedelement.getText();
		System.out.println(selectedState);
		
	}
	public void enterLocationAndDeliveryCharge(String location,String amount)
	{
		LocationField.sendKeys(location);
		DeliveryChargeField.sendKeys(amount);
		
	}
	public void verifyLocationAndDeliveryCharge(String location,String Amt)
	{
		enterLocationAndDeliveryCharge(location,Amt);
		LocationField.click(); 
		DeliveryChargeField.click(); 
		
	}
	public void scrollAndSave()
	{
		pageutility=new PageUtility(driver);
		pageutility.scrollIntoElementView(ScrollPushnotificationField);
		pageutility.scrollAndClick(SaveButton);
		
	}
	public String getTextOfHeadingAddLocation()
	{
		return AddNewLocation.getText();
	}
	
	public boolean alertLocationCreated(String message)
	{
		generalUtility=new GeneralUtility(driver);
		return generalUtility.isWordPresent(LocationAddedAlertMsg,message);	
	}
}

;