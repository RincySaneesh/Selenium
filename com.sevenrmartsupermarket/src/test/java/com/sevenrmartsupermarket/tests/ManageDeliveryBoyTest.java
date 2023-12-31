package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyTest extends Base 
{
	
		ManageDeliveryBoyPage managedeliveryboypage;
		LoginPage loginPage;
		PageUtility pageutility;
		ExcelRead excelRead = new ExcelRead();

	
	String name;
	String username;
	String password;
	
	@Test
	public void verifyManageDeliveryBoyPage() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login();
		managedeliveryboypage.verifyManageDeliveryBoy();

	}

	@Test
	public void verifyAddDeliveryBoyFromExcel()
	{
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login();
		pageutility=new PageUtility(driver);
		
		excelRead.setExcelFile("ManageDeliveryBoy", "SignUp");

		name = excelRead.getCellData(2, 0);
		System.out.println(name);

		username = excelRead.getCellData(2, 1);
		System.out.println(username);

		password = excelRead.getCellData(2, 2);
		System.out.println(password);

		managedeliveryboypage.verifyManageDeliveryBoy();
		managedeliveryboypage.addDeliveryBoy();
		managedeliveryboypage.verifyName(name);
		managedeliveryboypage.verifyUserName(username);
		managedeliveryboypage.verifyPassword(password);
		managedeliveryboypage.clickonSaveButton();
		
	}

	@Test
	public void verifyNewDeliveryBoyDetailsAddedAlertMsg() throws InterruptedException {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		excelRead.setExcelFile("ManageDeliveryBoy", "SignUp");
		loginPage = new LoginPage(driver);
		loginPage.login();

		name = excelRead.getCellData(3, 0);
		username = excelRead.getCellData(3, 1);
		password = excelRead.getCellData(3, 2);
		
		managedeliveryboypage.verifyManageDeliveryBoy();
		managedeliveryboypage.addDeliveryBoy();
		managedeliveryboypage.verifyName(name);
		managedeliveryboypage.verifyUserName(username);
		managedeliveryboypage.verifyPassword(password);
		managedeliveryboypage.clickonSaveButton();
		
		Thread.sleep(3000);
		
		boolean actualResult=managedeliveryboypage.checkDeliveryBoyRegisterMsg("Delivery Boy Details Created Successfully");
		Assert.assertTrue(actualResult);
	}
	@Test
	public void verifySearchButtonFeatures()
	{
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login();
		managedeliveryboypage.verifyManageDeliveryBoy();
		managedeliveryboypage.verifyClickSearchButton("Eldriya");
	}
	
	@Test
	public void verifySearchReset()
	{
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login();
		managedeliveryboypage.verifyManageDeliveryBoy();
		managedeliveryboypage.verifyClickSearchButton("Eldriya");
		managedeliveryboypage.verifyResetButton();
	}
	
}
