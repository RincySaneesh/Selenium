package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility
{
	WebDriver          driver;
	Select             select;
	Actions            actions;
    JavascriptExecutor js;
    
    public PageUtility(WebDriver driver)
    {
    	this.driver=driver;
    }
	
    public void selectByIndex(WebElement element,int index)
    {
    	select=new Select(element);
    	select.selectByIndex(index);
    }
    
    public void selectByValue(WebElement element,String value)
    {
    	select=new Select(element);
    	select.selectByValue(value);
    }
    
    public void selectByVisibleText(WebElement element,String text)
    {
    	select=new Select(element);
    	select.selectByVisibleText(text);
    }
    
    public void moveMouse(WebElement element)
    {
    	actions=new Actions(driver);
    	actions.moveToElement(element).build().perform();
    }
    
    public void scrollIntoElementView(WebElement element)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
    
    public void scrollAndClick(WebElement element)
    {
    	int y=0;
    	js=(JavascriptExecutor)driver;
    	while(!isClicked(element))
    	{
    		js.executeScript("window.scrollBy(0," + y + ")");
    		y=y+5;
    	}
    }
    public boolean isClicked(WebElement element)
    {
    try {
    	element.click();
    	return true;
    	
    } catch (Exception e) {
    	return false;
    	
    }	
    }
}
