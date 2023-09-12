package com.providio.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class reviewOrderPage {
	
WebDriver lDriver;
	
	public reviewOrderPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath ="//button[contains(text(), 'Next: Review Order')]")
	WebElement reviewOrderPage;
    public void clickonReviewOrder(WebDriver driver) throws InterruptedException {	 
    	JavascriptExecutor js = (JavascriptExecutor) driver;     
    	js.executeScript("arguments[0].click();",reviewOrderPage);
    	Thread.sleep(2000);
    	if(reviewOrderPage.isDisplayed()) {
    	 reviewOrderPage.click();
    	}
    }
    //In checkout page if the it will check the button of revieworder and place order buttons
	@FindBy(xpath ="//button[contains(@class,' place-order')]")
	WebElement placetheorderwithJsExuter;
    public void clickonplaceorderwithJsExuter(WebDriver driver) throws InterruptedException {
    	 if(driver.findElements(By.xpath("//button[contains(@class,'place-order')]")).size()!=0) {
	    	try {
	    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placetheorderwithJsExuter);
	    	Thread.sleep(4000);
	
	    	JavascriptExecutor js = (JavascriptExecutor) driver;     
	    	placetheorderwithJsExuter.click();
	    
	    
	    	}catch(Exception e) {
	    		Thread.sleep(4000);
	    		JavascriptExecutor js = (JavascriptExecutor) driver; 
	    		js.executeScript("arguments[0].click();", placetheorderwithJsExuter);
	    	}
	      }
    } 
 
}
