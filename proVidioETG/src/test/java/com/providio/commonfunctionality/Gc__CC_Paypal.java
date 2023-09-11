package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__PaymentProccessByGC;
import com.providio.paymentProccess.tc__PaymentProccessByGC_CC_Paypal;
import com.providio.testcases.baseClass;

public class Gc__CC_Paypal extends baseClass{

	public void paymentProccessByGCandCC(WebDriver driver) throws InterruptedException {
		
		List<WebElement> giftCard = driver.findElements(By.xpath("//label[contains(text(),' Redeem gift certificate')]"));	
		if(giftCard.size()>0) {
			//brain tree
			List<WebElement> creditcardsBraintree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
			//salesforce
			List<WebElement> creditcardsSalesForce = driver.findElements(By.xpath("//div[@class='sfpp-payment-method-header sfpp-payment-method-header-card']"));
			//stripe		
			List<WebElement> stripePayment = driver.findElements(By.cssSelector("li.nav-item[data-method-id=\"CREDIT_CARD\"]"));
			Thread.sleep(1000);
			
			 if(creditcardsBraintree.size()>0) {
					 test.info("brain tree payment is activated");
					 List<WebElement> giftCertificate = driver.findElements(By.xpath("//input[@class='giftCertCode']"));
					 if(giftCertificate.size()>0) {
						 tc__PaymentProccessByGC_CC_Paypal code= new  tc__PaymentProccessByGC_CC_Paypal();				
						 code.paymentBySemiGC();					
						 logger.info("applied gift card code ");
					 }
			 }else if(creditcardsSalesForce.size()>0) {
					 test.info("salesforce payment is activated");	
					 List<WebElement> giftCertificate = driver.findElements(By.xpath("//input[@class='giftCertCode']"));				 
					 if(giftCertificate.size()>0) {
						 tc__PaymentProccessByGC_CC_Paypal code= new  tc__PaymentProccessByGC_CC_Paypal();				
						 code.paymentBySemiGC();					
						 logger.info("applied gift card code ");
					 }
			 }else if(stripePayment .size()>0) {
			 		test.info("Stripe payment activated");
			 		 List<WebElement> giftCertificate = driver.findElements(By.xpath("//input[@class='giftCertCode']"));				 
					 if(giftCertificate.size()>0) {
						 tc__PaymentProccessByGC_CC_Paypal code= new  tc__PaymentProccessByGC_CC_Paypal();				
						 code.paymentBySemiGC();					
						 logger.info("applied gift card code ");
					 }		 		
			 }else {
				 	 test.info("Cyber source payment is activated");
				 	 test.pass("No GC configuration for cybersource");
			 }
			//credit card process from chechout		
			 List<WebElement> gcText= driver.findElements(By.xpath("//div[@class='success giftcert-pi']")); 
			 if(creditcardsBraintree.size()>0 || creditcardsSalesForce.size()>0 ||stripePayment .size()>0) {
				 if(gcText.size()>0) {
					 test.info("GC  is redemeed");
				     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();			     
				     cc.paymentByCreditCard();
				 }else {
					 test.info("No GC code is redemeed ");
					 test.pass("No GC code is redemeed because of insufficient balnce or Gc belongs to different customer");
				 }
			 }else {			
			 	 test.pass("No GC configuration for cybersource,so GC and CC payment is terminated");
			 }
	
		}else {
			test.info("Gc is Added into cart so order will not be placed with Gc");
		}
	}
	
	public void paymentProccessByGCandPaypal() throws InterruptedException {
		
		List<WebElement> giftCard = driver.findElements(By.xpath("//label[contains(text(),' Redeem gift certificate')]"));	
		if(giftCard.size()>0) {
			//brain tree
			List<WebElement> creditcardsBraintree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));				
			List<WebElement> brainPaypalAcc = driver.findElements(By.cssSelector("img[title='PayPal Credit']"));
			
			//salesforce
			List<WebElement> creditcardsSalesForce = driver.findElements(By.xpath("//div[@class='sfpp-payment-method-header sfpp-payment-method-header-card']"));
			List<WebElement> salesforcePaypal= driver.findElements(By.xpath("(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]"));
			
			//stripe		
			List<WebElement> stripePayment = driver.findElements(By.cssSelector("li.nav-item[data-method-id=\"CREDIT_CARD\"]"));
			 if(creditcardsBraintree.size()>0 || brainPaypalAcc.size()>0) {
					 test.info("brain tree payment is activated");
					 List<WebElement> giftCertificate = driver.findElements(By.xpath("//input[@class='giftCertCode']"));
					 if(giftCertificate.size()>0) {					 
						 tc__PaymentProccessByGC_CC_Paypal code= new  tc__PaymentProccessByGC_CC_Paypal();				
						 code.paymentBySemiGC();					
						 logger.info("applied gift card code ");
					 }
			 }else if(creditcardsSalesForce.size()>0 || salesforcePaypal.size()>0) {
					 test.info("salesforce payment is activated");					 
					 List<WebElement> giftCertificate = driver.findElements(By.id("giftCert"));
					 if(giftCertificate.size()>0) {
						 tc__PaymentProccessByGC_CC_Paypal code= new  tc__PaymentProccessByGC_CC_Paypal();				
						 code.paymentBySemiGC();					
						 logger.info("applied gift card code ");
					 }
			 }else if(stripePayment .size()>0) {
			 		test.info("Stripe payment activated");
			 		test.pass("No GC configuration for stripe so GC and paypal payment is terminated");
			 }else {
				 	 test.info("Cyber source payment is activated");
				 	 test.pass("No configuration for cybersource");
			 }
			 Thread.sleep(1000);
			//paypal process from chechout			
			 List<WebElement> gcText= driver.findElements(By.xpath("//div[@class='success giftcert-pi']")); 
			 
			 if(creditcardsBraintree.size()>0 || creditcardsSalesForce.size()>0 ){
				 if(gcText.size()>0) {
					 	test.info("GC  is redemeed");
					 	logger.info("Entered into paypal");
						tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
						cpp.checkoutprocessFromCheckout();
				 }else {
						 test.info("No GC code is redemeed");
						 test.pass("No GC code is redemeed because of insufficient balnce or Gc beloAngs to different customer");
				 }
			 }else if(stripePayment .size()>0) {
				 		test.info("Stripe payment activated");
				 		test.pass("No GC configuration for stripe so GC and paypal payment is terminated");
				 		
			 }else {
				 		test.info("Cybersource paymnet activated");
				 		test.pass("No GC configuration for cybersource so GC and paypal payment is terminated");
			 }
		}else {
			test.info("Gc is Added into cart so order will not be placed with Gc");
		}
	}
	
	public void paymentByGiftCard() throws InterruptedException {
		
		List<WebElement> giftCard = driver.findElements(By.xpath("//label[contains(text(),' Redeem gift certificate')]"));	
		if(giftCard.size()>0) {
			//brain tree
			List<WebElement> creditcardsBraintree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));				
			List<WebElement> brainPaypalAcc = driver.findElements(By.cssSelector("img[title='PayPal Credit']"));
			//salesforce
			List<WebElement> creditcardsSalesForce = driver.findElements(By.xpath("//div[@class='sfpp-payment-method-header sfpp-payment-method-header-card']"));
			List<WebElement> salesforcePaypal= driver.findElements(By.xpath("(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]"));
			
			//stripe payment
			List<WebElement> stripePayment = driver.findElements(By.cssSelector("li.nav-item[data-method-id=\"CREDIT_CARD\"]"));
			
			 if(creditcardsBraintree.size()>0 || brainPaypalAcc.size()>0) {
				 
					 test.info("brain tree payment is activated");
					 tc__PaymentProccessByGC code= new tc__PaymentProccessByGC();
				     //code.performRandomOperations(driver);
					 List<WebElement> giftCertificate = driver.findElements(By.id("giftCert"));
					 if(giftCertificate.size()>0) {
						 code.performSequentialOperations(driver);						
						 logger.info("applied gift card code");
						 test.info("Gc code applied");
					 }
						 
			 } else if(creditcardsSalesForce.size()>0 || salesforcePaypal.size()>0) {
				 
					 test.info("salesforce payment is activated");					 
					 tc__PaymentProccessByGC code= new tc__PaymentProccessByGC();
					 List<WebElement> giftCertificate = driver.findElements(By.id("giftCert"));
					 if(giftCertificate.size()>0) {
						 code.performSequentialOperations(driver);						
						 logger.info("applied gift card code");
						 test.info("Gc code applied");
					 }
			 }else if(stripePayment.size()>0) {
				 
				 	test.info("Stripe payment is activated");
				 	tc__PaymentProccessByGC code= new tc__PaymentProccessByGC();
					 List<WebElement> giftCertificate = driver.findElements(By.id("giftCert"));
					 if(giftCertificate.size()>0) {
						 code.performSequentialOperations(driver);						
						 logger.info("applied gift card code");
						 test.info("Gc code applied");
					 }
				 	
			 }else {
				 test.info("Cyber source payment is activated");
			 	 test.pass("No GC configuration for cybersource");
			 }
 
		}else {
			test.info("Gift card is added into cart So Gc will not be placed with Gift card");
		
		}
	}
}
