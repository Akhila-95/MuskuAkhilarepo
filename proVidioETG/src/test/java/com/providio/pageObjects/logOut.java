package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logOut {
	
WebDriver lDriver;
	
	public logOut(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
		//logout
		@FindBy(xpath="(//a[contains(text(), 'Logout')])[1]")
		WebElement logout;
		public void clicklogout(WebDriver driver){
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click();", logout);
			//logout.click();
		}
		
		
}
