package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream ip;
	GeneralUtility generalutility;
	PageUtility pageutility;
	ManageDeliveryBoyPage managedeliveryboypage;

	@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
	WebElement manageDeliveryBoyField;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement newName;

	@FindBy(xpath = "//input[@id='username']")
	WebElement newUserName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement newPassword;

	@FindBy(xpath = "//button[@name='create']")
	WebElement newSave;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertMsg;
	
	@FindBy(xpath="//a[text()=' Search']")
	WebElement SearchButton;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement SearchName;
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement clickSearch;
	
	@FindBy(xpath="//a[text()=' Reset']")
	WebElement resetSearchElement;
	
	@FindBy(xpath="//table//tbody//tr//td[1]")
	List<WebElement>allnames;
	
	
	

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyManageDeliveryBoy() {
		manageDeliveryBoyField.click();
		
	}
	public void addDeliveryBoy()
	{
		newButton.click();	
	}

	public void verifyName(String namefield) {
		newName.sendKeys(namefield);
	}

	public void verifyUserName(String userNamefield) {
		newUserName.sendKeys(userNamefield);
	}

	public void verifyPassword(String passwordfield) {
		newPassword.sendKeys(passwordfield);

	}
 
	public void clickonSaveButton()
	{
		pageutility=new PageUtility(driver);
		pageutility.scrollIntoElementView(newPassword);
		pageutility.scrollAndClick(newSave);
		
	}

	public boolean checkDeliveryBoyRegisterMsg(String message) {
		generalutility = new GeneralUtility(driver);
		return generalutility.isWordPresent(AlertMsg, message);
	}
	public void verifyClickSearchButton(String ToFindTheName)
	{
		SearchButton.click();
		SearchName.sendKeys(ToFindTheName);	
		clickSearch.click();
	}
	public void verifyResetButton()
	{
	resetSearchElement.click();	
	}
	public void verifyEditButton()
	{
	resetSearchElement.click();	
	}
	
	public void deleteDeliveryBoy(String nameOfDeliveryBoy)
	{
		int index=0;
		List<String> names = new ArrayList<String>();
		generalutility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		names = generalutility.getTextOfElements(allnames);
		System.out.println(names);
		for(index=0;index<names.size();index++)
		{
			if(nameOfDeliveryBoy.equals(names.get(index)))
			{
				index++;
			}
			
			break;
		}
		WebElement editButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[8]//a[1]"));
		pageutility.scrollAndClick(newPassword);
	}	
	
	
	
}
