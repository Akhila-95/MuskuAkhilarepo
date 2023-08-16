package com.providio.paymentProccess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.Validations.Checkout_Validation;
import com.providio.pageObjects.miniCartPage;
import com.providio.testcases.baseClass;

public class tc__PaymentProcessByGooglePay extends baseClass {

	public void paymentProcessByGooglePay() throws InterruptedException {
		

		WebElement minicartcount = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
	    String countOfMinicart = minicartcount.getText();
	    int minicartCountValue = Integer.parseInt(countOfMinicart);
        if (minicartCountValue > 0) {

        	 Thread.sleep(5000);
        	 miniCartPage mc = new miniCartPage(driver);
             mc.clickcartbuttonjs(driver);
             Thread.sleep(2000);

             Checkout_Validation checkout= new Checkout_Validation();
             checkout.validateMiniCartClick();
           
             mc.clickOnGooglePayButton();
        }
            
	}
	
}
