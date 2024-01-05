package com.sevenrmartsupermarket.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageOfferCodePage 
{
	  WebDriver driver;
	  GeneralUtility generalutility;
	  PageUtility pageutility;
	  
	  @FindBy(xpath="//html//body//div//div[1]//section//div//div//div[6]//div//a//i")
	  WebElement MageOfferCode55MoreInfo;
	  
	  @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	  WebElement AddNewListProducts;
	 
	  @FindBy(xpath="//input[@id='offer_code']")
	  WebElement offer_Code;
	  
	  @FindBy(xpath="//input[@value='yes']")
	  WebElement firstOderUserRadioBtnYES;
	  
	  @FindBy(xpath="//input[@id='offer_per']")
	  WebElement percentage;
	  
	  @FindBy(xpath="//input[@id='offer_price']")
	  WebElement amount;
	  
	  @FindBy(xpath="//div[@class='note-editable card-block']")
	  WebElement description;
	  
	  @FindBy(xpath = "//input[@id='main_img']")
	  WebElement choosefile;
	  
	  @FindBy(xpath = "//button[contains(text(),'Save')]")
	  WebElement saveButton;
	  
	  @FindBy(xpath="//a[text()=' Search']")
	  WebElement SearchButton;
		
	  @FindBy(xpath="//input[@name='un']")
	   WebElement OfferCode;
		
	  @FindBy(xpath="//button[@name='Search']")
	  WebElement clickSearch;
		
	  @FindBy(xpath="//a[text()=' Reset']")
	  WebElement ResetButton;
		
	  @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	  WebElement OfferCreatedAlert;
	  
	  public ManageOfferCodePage(WebDriver driver) {
	    this.driver=driver;
	    PageFactory.initElements(driver, this);
	  }
	  public void ClickOnMoreInfo() {
		  MageOfferCode55MoreInfo.click();
	  }
	  public void ClickNew() {
		  AddNewListProducts.click();
	  }

	     public void enter_Offer(String offer) {
	        offer_Code.sendKeys(offer);
	       }
	     public void enter_Percentage(String percentageData) {
	        percentage.sendKeys(percentageData);
	       }
	     public void enter_Amount(String amountData) {
	        amount.sendKeys(amountData);
	       }
	     public void enter_Description(String descriptionData) {
	        description.sendKeys(descriptionData);
	       }
	     public void imageUpload() {
	       
	        File file=new File(Constants.IMAGE_FILE_PATH);
	        choosefile.sendKeys(file.getAbsolutePath());
	    }
	     public void clickonSaveButton()
	 	{
	 		pageutility=new PageUtility(driver);
	 		pageutility.scrollIntoElementView(description);
	 		pageutility.scrollAndClick(saveButton);
	 		
	 	}
	     
	     public void ClickSearchButton(String enterOfferCode)
	 	{
	 		SearchButton.click();
	 		OfferCode.sendKeys(enterOfferCode);	
	 		clickSearch.click();
	 	}
	 	public void clickReset()
	 	{
	 		ResetButton.click();	
	 	}
	 	
	 	public boolean OfferCreatedAlert(String message)
		{
			generalutility=new GeneralUtility(driver);
			return generalutility.isWordPresent(OfferCreatedAlert,message);	
		}
		
	 	public String getTextOfHeadingSearchListOfferCode()
		{
			return SearchButton.getText();
		}
	 	
}
