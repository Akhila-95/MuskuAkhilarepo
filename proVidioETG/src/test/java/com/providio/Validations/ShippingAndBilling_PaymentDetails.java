package com.providio.Validations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.providio.testcases.baseClass;

public class ShippingAndBilling_PaymentDetails extends baseClass {

	   //get the shipping ,billing and payment details in place order page 
    @FindBy(xpath = "(//div[@class='single-shipping'])[2]")
    WebElement shippingDetails;
    @FindBy(xpath = "(//div[@class='address-summary'])[2]")
    WebElement billingDetails;
    @FindBy(xpath = "//div[@class='summary-details']")
    WebElement paymentDetails;
    
    public void placeOrderPageDetails() {
    	if(shippingDetails.isDisplayed()) {
    		test.info("shipping details are " + shippingDetails.getText());
    	}if(billingDetails.isDisplayed()) {
    		test.info("Billing details " + billingDetails.getText());
    	}if(paymentDetails.isDisplayed()) {
    		test.info("Payment details " + paymentDetails.getText());
    	}
    }
}
