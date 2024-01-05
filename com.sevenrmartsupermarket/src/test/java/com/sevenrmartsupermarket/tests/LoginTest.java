package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class LoginTest extends Base 
{
	LoginPage loginPage;
	HomePage homepage;
	
	@Test
	public void verifyLogin()
	{
		loginPage=new LoginPage(driver);
		homepage=new HomePage(driver) ;
		String expectedProfileName="Admin";
		loginPage.login();
		
		String actualProfileName=homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);;
		
	}
	
	@Test
	public void verifyInvalidLogin()
	{
		loginPage=new LoginPage(driver);
		loginPage.login("abc","xyz");
		
		boolean actualResult=loginPage.checkErrorMsg("Invalid Username/Password");
		ScreenShot screenshot=new ScreenShot();
		screenshot.takeScreenShot(driver, "Rincy");
		Assert.assertTrue(actualResult);
	}
	
	
}
