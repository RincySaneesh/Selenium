package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageOfferCodePage;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageOfferCodeTest extends Base
{
	  LoginPage loginpage;
	  ManageOfferCodePage addoffercodepage;
	  PageUtility pageutility;
	  
	  @Test
	  public void verify_NewOffer() 
	  {
	   loginpage = new LoginPage(driver);
	   loginpage.login("admin", "admin");
	   addoffercodepage=new ManageOfferCodePage(driver);
	   pageutility=new PageUtility(driver);
		
		addoffercodepage.ClickOnMoreInfo();
	    addoffercodepage.ClickNew();
	    addoffercodepage.enter_Offer("Discount!");
	    addoffercodepage.enter_Percentage("25%");
	    addoffercodepage.enter_Amount("250");
	    addoffercodepage.enter_Description("FLAT 25% OFF ON MAMAEARTH PRODUCT");
	    addoffercodepage.imageUpload();
	    addoffercodepage.clickonSaveButton();
	    
	  }
	  
	  @Test
		public void verifySearchButtonFeatures()
		{
		  loginpage = new LoginPage(driver);
		   loginpage.login("admin", "admin");
		   addoffercodepage=new ManageOfferCodePage(driver);
		   addoffercodepage.ClickOnMoreInfo();
		   addoffercodepage.verifyClickSearchButton("TestOfferCD656");
		}
		
		@Test
		public void verifySearchReset()
		{
			loginpage = new LoginPage(driver);
			  loginpage.login("admin", "admin");
			   addoffercodepage=new ManageOfferCodePage(driver);
			   addoffercodepage.ClickOnMoreInfo();
			   addoffercodepage.verifyClickSearchButton("TestOfferCD484");
			   addoffercodepage.verifyResetButton();
		}
		
}
