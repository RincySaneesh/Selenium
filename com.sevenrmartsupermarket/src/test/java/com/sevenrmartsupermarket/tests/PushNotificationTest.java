package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;
import org.testng.Assert;

public class PushNotificationTest extends Base 
{
	ExcelRead excelRead = new ExcelRead();
	PushNotificationPage pushnotificationpage;
	LoginPage loginPage;
	
	String tileData;
	String descriptionData;

	@Test
	public void verifyDataFromExcel()
	{
		pushnotificationpage = new PushNotificationPage(driver);
		loginPage=new LoginPage(driver);
		loginPage.login(); 
		excelRead.setExcelFile("PushNotifications", "notifications");
		tileData = excelRead.getCellData(1,0);
		System.out.println(tileData);
		descriptionData = excelRead.getCellData(1,1);
		System.out.println(descriptionData);
		
		pushnotificationpage.clickPushNotificationField();
		pushnotificationpage.enterTitle(tileData);
		pushnotificationpage.enterDescription(descriptionData);
		pushnotificationpage.clickSendKey();
		
	}
		
		@Test
		public void verifyPushNotificationAlertMsg() throws InterruptedException 
		{
		pushnotificationpage = new PushNotificationPage(driver);
		loginPage=new LoginPage(driver);
		excelRead.setExcelFile("PushNotifications", "notifications");
		tileData = excelRead.getCellData(0,0);
		descriptionData = excelRead.getCellData(1,1);
		loginPage.login();
		
		pushnotificationpage.clickPushNotificationField();
		pushnotificationpage.enterTitle(tileData);
		pushnotificationpage.enterDescription(descriptionData);
		pushnotificationpage.clickSendKey();
		Thread.sleep(3000);
		
		boolean actualResult=pushnotificationpage.checkPushNotificationMsg("Message send successfully");
		Assert.assertTrue(actualResult);
		}
		
		
	}
