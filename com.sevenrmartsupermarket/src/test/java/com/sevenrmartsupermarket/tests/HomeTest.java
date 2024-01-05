package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base 
{
	LoginPage loginpage;
	HomePage homepage;
	@Test
	public void verify_Logout()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login();
		homepage.logout();
		
		String expectedText="7rmart supermarket";
		String actualText=homepage.superMarketGetext();	
		Assert.assertEquals(actualText,expectedText);
	}

}


