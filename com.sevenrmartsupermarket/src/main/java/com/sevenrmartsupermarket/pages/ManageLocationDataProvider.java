package com.sevenrmartsupermarket.pages;



import org.testng.annotations.DataProvider;

public class ManageLocationDataProvider 
{
	//WebDriver driver;
	/*public ManageLocationDataProvider(WebDriver driver)
	{
		this.driver=driver;
	
	}*/
	
	
	@DataProvider(name="Location")
	public Object[][] enterLocation()
	{
		return new Object [][] {{"PALAKKAD","$1000"}};
	}
	
	
	@DataProvider(name="DeliveryCharge")
	public Object[][] enterAmount()
	{
	return new Object [][] {{},{}};
	}
}
