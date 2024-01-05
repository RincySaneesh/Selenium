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
			managedeliveryboypage.clickManageDeliveryBoy();
			
			String expectedText="Add-Delivery Boy";
			String actualText=managedeliveryboypage.getTextOfHeadingAddDeliveryBoy();
			Assert.assertEquals(actualText, expectedText);

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

			managedeliveryboypage.clickManageDeliveryBoy();
			managedeliveryboypage.addDeliveryBoy();
			managedeliveryboypage.addName(name);
			managedeliveryboypage.addUserName(username);
			managedeliveryboypage.createPassword(password);
			managedeliveryboypage.clickonSaveButton();
		
			
			boolean actualResult=managedeliveryboypage.checkDeliveryBoyRegisterAlertMsg("Delivery Boy Details Created Successfully");
			Assert.assertTrue(actualResult);
		}

		
		@Test
		public void verifySearchButtonFeatures()
		{
			managedeliveryboypage = new ManageDeliveryBoyPage(driver);
			loginPage = new LoginPage(driver);
			loginPage.login();
			managedeliveryboypage.clickManageDeliveryBoy();
			managedeliveryboypage.ClickSearchButton("name6");
			
			String expectedText="Search List Delivery Boy";
			String actualText=managedeliveryboypage.getTextOfSearchDeliveryBoy();
			Assert.assertEquals(actualText, expectedText);
		}
		
		@Test
		public void verifySearchReset()
		{
			managedeliveryboypage = new ManageDeliveryBoyPage(driver);
			loginPage = new LoginPage(driver);
			loginPage.login();
			managedeliveryboypage.clickManageDeliveryBoy();
			managedeliveryboypage.ClickSearchButton("Eldriya");
			managedeliveryboypage.clickResetButtonInsideSearch();
			
			String expectedText="List Delivery Boy";
			String actualText=managedeliveryboypage.getTextOfHeadingListDeliveryBoy();
			Assert.assertEquals(actualText, expectedText);
			
		}
		@Test
		public void verify_NameDelete()
		{
			loginPage = new LoginPage(driver);
			loginPage.login();
			managedeliveryboypage=new ManageDeliveryBoyPage(driver);
			managedeliveryboypage.clickManageDeliveryBoy();
			managedeliveryboypage.deleteDeliveryBoy("Velva Cruickshank");
			
			boolean actualResult=managedeliveryboypage.checkDeliveryBoyRegisterAlertMsg("Delivery Boy Informations Deleted Successfully");
			Assert.assertTrue(actualResult);
			
		}
		@Test
		public void verify_editUser()
		{
			loginPage = new LoginPage(driver);
			loginPage.login();
			managedeliveryboypage=new ManageDeliveryBoyPage(driver);
			managedeliveryboypage.clickManageDeliveryBoy();
			managedeliveryboypage.editUser("Trudie McGlynn");
			
			String expectedText="Edit-Delivery Boy";
			String actualText=managedeliveryboypage.getTextOfHeadingEditDeliveryBoy();
			Assert.assertEquals(actualText, expectedText);
			
		}
}

