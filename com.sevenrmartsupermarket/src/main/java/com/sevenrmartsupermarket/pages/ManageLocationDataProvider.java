package com.sevenrmartsupermarket.pages;

import org.testng.annotations.DataProvider;

public class ManageLocationDataProvider
{
	@DataProvider(name="Location")
	public Object[][] enterLocation()
	{
		return new Object [][] {{"PALAKKAD"},{"CALICUT"}};
	}
	
	
	@DataProvider(name="DeliveryCharge")
	public Object[][] enterAmount()
	{
	return new Object [][] {{"$1000"},{"$500"}};
	}
}
