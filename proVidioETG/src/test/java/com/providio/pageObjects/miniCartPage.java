package com.providio.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class miniCartPage {

WebDriver lDriver;
	
	public miniCartPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//cartbutton
	@FindBy(xpath="//a[contains(@class,'minicart-link')]")
	WebElement CartButton;
	public void clickcartbutton(WebDriver driver) throws InterruptedException{
		
		
		CartButton.click();
		Thread.sleep(2000);
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
  	        js.executeScript("arguments[0].click();", CartButton);
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception or perform an alternative action if necessary
	        CartButton.click();
	    }
	
	
	}
	//js
	@FindBy(xpath="//a[@class='minicart-link']")
	WebElement CartButtonjs;
	public void clickcartbuttonjs(WebDriver driver) throws InterruptedException{

			JavascriptExecutor js = (JavascriptExecutor) driver;
  	        js.executeScript("arguments[0].click();", CartButton);
	       

	}
	
	//viewCartButton
	@FindBy(xpath="//a[contains(@class,'btn  btn-block ')]")
	WebElement viewCartButton;
	public void clickviewCartButton(WebDriver driver) throws InterruptedException{	
		Thread.sleep(5000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
	  //  js.executeScript("arguments[0].click();", viewCartButton);
		viewCartButton.click();
        Thread.sleep(2000);
	}
	
	//Checkout
	@FindBy(xpath="//a[contains(@class,'btn btn-primary btn')]")
	WebElement Checkout;
	public void clickCheckout() throws InterruptedException{
		
		Checkout.click();	
        Thread.sleep(5000);
	}
	
	
	//paypal button by braintreee payment integration
	
	@FindBy(xpath="//div[contains(@class,'js_braintree_paypal_cart_button')]")
	WebElement brainTreePaypalButton ;
	public void clickBrainTreePaypalButton () throws InterruptedException{
		
		brainTreePaypalButton.click();	
        Thread.sleep(5000);
	}
	//paypal by salesforce integration
	@FindBy(xpath = "//div[contains(@class,'salesforce')]")
	WebElement salesforcePaypalButton;
	public void  clickSalesforcePaypalButton() {
		salesforcePaypalButton.click();
	}
	
	//google pay button for salesforce
	@FindBy(xpath = "//iframe[@title='Secure payment button frame']")
	WebElement googlePayButton;
	public void clickOnGooglePayButton() {
		googlePayButton.click();
	}

	
}
