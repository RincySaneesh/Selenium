package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageLocationDataProvider;
import com.sevenrmartsupermarket.pages.ManageLocationPage;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageLocationTest extends Base
{
	LoginPage loginPage;
	 ManageLocationPage managelocationpage;
	  PageUtility pageutility;
	  ManageLocationDataProvider managelocationprovider;
	 
	@Test
	public void verifyLocationPage()
	{
		loginPage = new LoginPage(driver);
		loginPage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.scrollAndClickManageLocationPage();
		
	}
	@Test
	public void verifyDropDownLocationPage()
	{
		loginPage = new LoginPage(driver);
		loginPage.login();
		managelocationpage=new ManageLocationPage(driver);
		
		managelocationpage.scrollAndClickManageLocationPage();
		managelocationpage.clikAddNewLocation();
		managelocationpage.selectCountry();
		managelocationpage.selectState();
		
		String expectedText="Add Locations";
		String actualText=managelocationpage.getTextOfHeadingAddLocation();
		Assert.assertEquals(actualText, expectedText);
	}
	@Test(dataProvider = "Location",dataProviderClass =ManageLocationDataProvider.class)
	public void verifyLocation(String location,String Amt)
	{
		loginPage = new LoginPage(driver);
		loginPage.login();
		managelocationpage=new ManageLocationPage(driver);
		
		managelocationpage.scrollAndClickManageLocationPage();
		managelocationpage.clikAddNewLocation();
		managelocationpage.selectCountry();
		managelocationpage.selectState();
		managelocationpage.verifyLocationAndDeliveryCharge(location,Amt);
		managelocationpage.scrollAndSave();
		
		boolean actualResult=managelocationpage.alertLocationCreated("Location Created Successfully");
		Assert.assertTrue(actualResult);
	}
	
}
