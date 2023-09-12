package com.providio.paymentProccess;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.providio.Validations.Checkout_Validation;
import com.providio.Validations.ShippingAndBilling_PaymentDetails;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.testcases.baseClass;

public class tc__CreditCardPaymentProcess extends baseClass{
	
	public void paymentByCreditCard() throws InterruptedException {
		
		List<WebElement> reviewOrderPage =driver.findElements(By.xpath("//select[@id='billingAddressSelector']"));
		if(reviewOrderPage.size()>0) {
			
			//validating the payment page
			if(driver.findElements(By.xpath("//label[contains(text(), 'Payment Method')]")).size()!=0) {
				 Checkout_Validation checkout= new Checkout_Validation();
				 checkout.validatePaymentButtonClk();
			}else {
				WebElement gc =driver.findElement(By.xpath("//div[contains(text(),'Your order has been paid using gift certificates')]"));
				if(gc.isDisplayed()) {
					test.info("Payment is done by GC ");
					test.pass("Payment is done by GC ");
					logger.info("Payment is by Gift certificate");
				}else {
					test.pass("Gift certificate is not redeemed ");
					logger.info("Gift certificate is not redeemed");
				}
				
			}			 
			List<WebElement> minicartcount = driver.findElements(By.xpath("//span[@class ='minicart-quantity ml-1']"));		
			if(minicartcount.size()==0) {
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("window.scrollBy(0,700)", "");

	 
		        List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
		        logger.info("Continued as Guest "+continueasAGuest.size());
		        
		        paymentpPage pp = new paymentpPage(driver);
		        
				//brain tree
				List<WebElement> braintreecheck = driver.findElements(By.id("braintreeCardOwner"));
			    System.out.println("Brain tree payment name "+braintreecheck.size());
			    
			    List<WebElement> braintreecheck2 = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
			    System.out.println(" brain tree"+braintreecheck2.size());
			    
			    //creditcard salesfornce
	
				List<WebElement> creditcardsSalesForce = driver.findElements(By.xpath("//div[@class='sfpp-payment-method-header sfpp-payment-method-header-card']"));
			    System.out.println("Salesforce payment"+creditcardsSalesForce.size());
			    
			    //stripe payment
				List<WebElement> stripePayment = driver.findElements(By.cssSelector("li.nav-item[data-method-id='CREDIT_CARD']"));
				System.out.println("stripe"+ stripePayment.size()) ;
				
				//cybersource
				//List<WebElement>  cybersource= driver.findElements(By.cssSelector("li.nav-item[data-method-id='CREDIT_CARD']"));
				List<WebElement> cybersourceNum = driver.findElements(By.xpath("//label[@for='expirationMonth']"));
				System.out.println("cyber source "+ cybersourceNum);
				
				//a[@class='nav-link credit-card-tab active']
				    if(braintreecheck.size()>0 && braintreecheck2 .size()>0 ) {
				    	test.info("Brain tree payment activated");
				    	List<WebElement> savedCardsBrainTree = driver.findElements(By.xpath("//option[@class ='js_stored_card']"));
				    	System.out.println(savedCardsBrainTree.size());
				    	if(savedCardsBrainTree.size()>0) {
				    		
				    		logger.info("Saved cards are there selected one of them");
				    		
				    	}else {
				    		
				    		Thread.sleep(5000);
				    		if(continueasAGuest.size()>0) {
				    			//guest cc
				    			guestUserCCpayment();			    			
			
			                }else {
			                	//new card
			                	registerUserCC();
			                }				    		    		
				    	}				   	
				    }else if(creditcardsSalesForce.size()>0) {
				    	
				    	//new card salesforce
				    	test.info("Salesforce payment activated");
				    	salesforcePaymentProcess();
				    	
				    }else if(cybersourceNum.size()>0) {
			
				    	List<WebElement> savedCardsCyberSourece = driver.findElements(By.xpath("//option[@class ='js_stored_card']"));
				    	System.out.println("Cybersource paymnet"+savedCardsCyberSourece.size());
				    	test.info("Cyber source payment activated");
				    	if(savedCardsCyberSourece.size()>0) {
				    		//select one and send the cvv number of that card
				    		logger.info("Saved cards are there for cyber source");
				    		List<WebElement> savedCards = driver.findElements(By.cssSelector("div.saved-payment-instrument"));
				    		Random random = new Random();
				            int randomIndex = random.nextInt(savedCards.size());
				            // Select the randomly chosen payment instrument
				            WebElement selectedPaymentInstrument = savedCards.get(randomIndex);
				            // Perform actions on the selected payment instrument (e.g., click)
				            selectedPaymentInstrument.click();
				           WebElement securityCode = driver.findElement(By.id("saved-payment-security-code"));
				            securityCode.sendKeys("9876");
				    		
				    	}else {
				             // cyber source new card
				    		cyberSourceNewcard();				    		
				    	}
				    }else if(stripePayment.size()>0) {
				    	test.info("Stripe payment activated");
				    	stripePayment();
				    	
					    	
				    	
				    }
    
				    //Salesforce payment integration place the order
				    if(creditcardsSalesForce.size()>0) {
		
			            js.executeScript("window.scrollBy(0,300)", "");
				    	pp.placetheOrder(driver);
				    	logger.info("clicking the salesforce place the order");
				    	
				    	//click the place order button
				    	
				    	
				    }else {	
				    	
				    	try {
				    		//revieworderpage
					    Thread.sleep(2000);		
			    		List<WebElement> reviewOrderList  = driver.findElements(By.xpath("//button[@class='btn btn-primary btn-block submit-payment'  and @value='submit-payment']"));
			    		System.out.println("Review order button"+ reviewOrderList.size());
				    		if(reviewOrderList.size()>0) {	
				    			pp.clickonrevieworder(driver);
						    	//js.executeScript("arguments[0].click();", element);							     //pp.clickonrevieworder(driver);
								logger.info("clicked on the review oreder");
								
								//shipping and billing ,payment detailss
					    		ShippingAndBilling_PaymentDetails details= new ShippingAndBilling_PaymentDetails();
					    		details.placeOrderPageDetails();
				    		}
				    	} catch(Exception e) {
				    		System.out.println(e);
				    	}
						
						//placeorder
						reviewOrderPage rop = new reviewOrderPage(driver);
						Thread.sleep(1000);
						 if(driver.findElements(By.xpath("//button[contains(@class,'place-order')]")).size()!=0) {
							rop.clickonplaceorderwithJsExuter(driver);
							test.info("successfully click on the place order button");
						 }						
				    }
				    
				    Thread.sleep(7000);
					
					Checkout_Validation checkout= new Checkout_Validation();
		    		//validate the final place the order page
		    		 checkout.validatePlacetheOrderPage();
					
		            //ordernumberandOrderdate
		    		 checkout.ordernumberandOrderdat();    
			}		
	
			}else {
	                logger.info("The cart value is empty");
	                test.fail("The cart value is empty");
			}
		
	}
	
	//payment of cyber source 
	private void cyberSourceNewcard() throws InterruptedException {
		
		paymentpPage pp = new paymentpPage(driver);
		
		//pp.addPaymentButton(driver);
    	//logger.info("click on the add payment button");
    	
        pp.latestcardnumber(driver);
        logger.info("entered card number");
        pp.latestExpDate(driver);
        logger.info("entered exp month");
        pp.latestExpYear(driver);
        logger.info("entered exp year");
        pp.latestSceuritycode(driver);
        logger.info("entered scecode");
		
	}
	//payment of salesforce integeration new one
	private void salesforcePaymentProcess() throws InterruptedException {
		paymentpPage pp = new paymentpPage(driver);
		
		pp.cardNumber(driver);
    	
    	logger.info("entered card number");
    	pp.expiryDate(driver);
    	
    	logger.info("entered cvv");
    	pp.cvc(driver);
    	logger.info("entered exp");
	}
	//payment method of reg new card details
	private void registerUserCC() throws InterruptedException {
		
		paymentpPage pp = new paymentpPage(driver);

    	pp.selectnewcardindropdown();  
		logger.info("Selectd the new card");
		
		pp.setcardholdername(driver);
		logger.info("entered card name");
		
		pp.setcardnumber(driver);
		logger.info("entered card number");
		
		pp.setcardcvv(driver);
		logger.info("entered cvv");
		
		pp.setcardexp(driver);
		logger.info("entered exp");
	}
	
	//payment method of guest user cc
	public void guestUserCCpayment() throws InterruptedException {
		
		paymentpPage pp = new paymentpPage(driver);
		
		pp.setcardholdername(driver);
		logger.info("entered card name");
		
		pp.setcardnumber(driver);
		logger.info("entered card number");
		
		pp.setcardcvv(driver);
		logger.info("entered cvv");
		
		pp.setcardexp(driver);
		logger.info("entered exp");
		
	}

	public void stripePayment() {
		paymentpPage pp = new paymentpPage(driver);
		
		pp.cardNum(driver);
		test.info("entered card number");
		pp. expDate(driver);
		test.info("entered exp date");		
		pp.cvv(driver);
		test.info("entered cvv");
		pp.postalCode();
		test.info("entered postal code");
	}
	    
	//  //soft assertions payment page
	//  
	//  softAssert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
	//  
	//  //Hard assertions payment page
	//  
	//  Assert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
	
	   
	}
