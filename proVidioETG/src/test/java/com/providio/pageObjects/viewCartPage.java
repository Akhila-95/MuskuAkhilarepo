package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class viewCartPage {
	
WebDriver lDriver;
	
	public viewCartPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//Checkout :- 
	@FindBy(xpath="//a[@class ='btn btn-primary btn-block checkout-btn ']")
	WebElement Checkout;	
	public void clickCheckout(WebDriver driver) throws InterruptedException{		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", Checkout);		
        Thread.sleep(5000);
	}
	
	//Removeitem	
	@FindBy(xpath="(//button[@class ='remove-btn-lg cart-delete-confirmation-btn btn btn-light'])[1]")
	WebElement CancelItem;
	public void clickCancelItem(WebDriver driver) throws InterruptedException{	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", CancelItem);
        Thread.sleep(5000);
	}
		
	
   //brain tree paypal button

		public void braintreePayPalButton(WebDriver driver) {
			
		    // Find the element using its xpath
		    WebElement payPalButton = driver.findElement(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
	
		    // Perform the click action
		    payPalButton.click();
		}
//salesforce paypalbutton
		public void salesforcePayPalButton(WebDriver driver) {
				
			    // Find the element using its xpath
			    WebElement payPalButton = driver.findElement(By.xpath("(//div[contains(@class,'salesforce-paymentrequest-element')])[1]"));
		
			    // Perform the click action
			    payPalButton.click();
			}
	
	

	/*public void clickPayPalButton(WebDriver driver) throws InterruptedException {
	    // Locate the parent div containing the PayPal button
	    WebElement parentPaypal = driver.findElement(By.xpath("//div[@class='paypal-button paypal-button-number-0 paypal-button-layout-horizontal paypal-button-shape-rect paypal-button-number-single paypal-button-env-sandbox paypal-button-color-gold paypal-button-text-color-black paypal-logo-color-blue']"));

	    // Find the child div with class 'paypal-button-label-container'
	    WebElement payPalButton = parentPaypal.findElement(By.xpath(".//div[@class='paypal-button-label-container']"));

	    // Click the PayPal button using JavaScript
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", payPalButton);

	    // Wait for a short while (adjust the time if needed)
	    Thread.sleep(5000);
	}*/


	
		 

}
