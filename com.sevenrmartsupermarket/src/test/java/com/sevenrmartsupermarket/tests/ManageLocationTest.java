package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageLocationDataProvider;
import com.sevenrmartsupermarket.pages.ManageLocationPage;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageLocationTest extends Base
{
	 LoginPage loginpage;
	 ManageLocationPage managelocationpage;
	  PageUtility pageutility;
	 
	@Test
	public void verifyLocationPage()
	{
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		managelocationpage=new ManageLocationPage(driver);
		pageutility=new PageUtility(driver);
		
		managelocationpage.verifyManageLocationPage();
		
	}
	@Test
	public void verifyDropDownLocationPage()
	{
		loginpage = new LoginPage(driver);
		   loginpage.login("admin", "admin");
		managelocationpage=new ManageLocationPage(driver);
		pageutility=new PageUtility(driver);
	
		managelocationpage.verifyManageLocationPage();
		managelocationpage.verifyCountry();
		managelocationpage.verifyState();
	}
	@Test(dataProvider = "Location",dataProviderClass =ManageLocationDataProvider.class)
	public void verifyLocation()
	{
		loginpage=new LoginPage(driver);
		managelocationpage=new ManageLocationPage(driver);
	
		managelocationpage.verifyLocation();
		
	}
	@Test(dataProvider = "DeliveryCharge",dataProviderClass =ManageLocationDataProvider.class)
	public void verifyDeliveryCharge()
	{
		loginpage=new LoginPage(driver);
		managelocationpage=new ManageLocationPage(driver);
	
		managelocationpage.verifyDeliveryCharge();
	}
}
