package com.providio.paymentProccess;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class Tc_PaymentProcessByCCandGC extends baseClass {

	public void paymentProcessByCCandGC(WebDriver driver) throws InterruptedException {
		
	
		System.out.println("Product count");
	
 
			 tc__PaymentProccessByGC code= new tc__PaymentProccessByGC();				
			 code.paymentBySemiGC();				
			 logger.info("applied gift card code ");
			
			 tc__CreditCardPaymentProcess  paymentByCC = new tc__CreditCardPaymentProcess ();				
			 paymentByCC.paymentByCreditCard();				
			 logger.info("Selected credit cards");
				
	
			
      }
}
