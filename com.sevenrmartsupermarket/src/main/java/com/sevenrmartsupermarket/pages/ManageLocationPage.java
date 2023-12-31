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
	
	public ManageLocationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void verifyManageLocationPage()
	{
		ManageLocation.click();
		AddNewLocation.click();
		
	}
	public void verifyCountry()
	{
		CountryField.click(); 
		Select countryDropDown=new Select(CountryField);
		WebElement selectedelement=countryDropDown.getFirstSelectedOption();
		String selectedCountry=selectedelement.getText();
		System.out.println(selectedCountry);
		
	}
	public void verifyState()
	{
		StateField.click(); 
		Select StateDropDown=new Select(StateField);
		WebElement selectedelement=StateDropDown.getFirstSelectedOption();
		String selectedState=selectedelement.getText();
		System.out.println(selectedState);
		
	}
	public void verifyLocation()
	{
		LocationField.click(); 
		
		
	}
	public void verifyDeliveryCharge()
	{
		DeliveryChargeField.click(); 
		
	}
}

;