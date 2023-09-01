package com.providio.paymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.Validations.Checkout_Validation;
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
			 Thread.sleep(5000);
			 
			List<WebElement> minicartcount = driver.findElements(By.xpath("//span[@class ='minicart-quantity ml-1']"));		
			if(minicartcount.size()==0) {
				
		        List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
		        logger.info(continueasAGuest.size());
		        
		        paymentpPage pp = new paymentpPage(driver);
		        
				//brain tree
				List<WebElement> creditcardscheck = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
			    System.out.println(creditcardscheck.size());
			    
			    //creditcard salesfornce
	
				List<WebElement> creditcardsSalesForce = driver.findElements(By.xpath("//div[@class='sfpp-payment-method-header sfpp-payment-method-header-card']"));
			    System.out.println(creditcardsSalesForce.size());
			    
				    if(creditcardscheck.size()>0) {
				    	
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
				    	salesforcePaymentProcess();
				    	
				    	
				    	
				    }else {
			
				    	List<WebElement> savedCardsCyberSourece = driver.findElements(By.xpath("//option[@class ='js_stored_card']"));
				    	System.out.println(savedCardsCyberSourece.size());
				    	
				    	if(savedCardsCyberSourece.size()>0) {
				    		//select one and send the cvv number of that card
				    		logger.info("Saved cards are there for cyber source");
				    		
				    	}else {
				             // cyber source new card
				    		cyberSourceNewcard();
				    		
				    	}
	
				    }
				    
				    
				    //Salesforce payment integration place the order
				    if(creditcardsSalesForce.size()>0) {
				    	
				    	Thread.sleep(4000);
				    	 JavascriptExecutor js = (JavascriptExecutor) driver;
			            js.executeScript("window.scrollBy(0,300)", "");
				    	pp.placetheOrder(driver);
				    	logger.info("clicking the salesforce place the order");
				    	
				    	//click the place order button
				    	
				    	
				    }else {
				    	
				    	logger.info("executing another way of clicking  place the order");
				    	
				    	pp.clickonrevieworder(driver);
						logger.info("clicked on the review oreder");
						
						//revieworderpage
						
						reviewOrderPage rop = new reviewOrderPage(driver);
						Thread.sleep(1000);
						
						rop.clickonplaceorderwithJsExuter(driver);
						logger.info("successfully click on the place order button");
						
						
				    }
				    
				    Thread.sleep(10000);
					
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

	    
	//  //soft assertions payment page
	//  
	//  softAssert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
	//  
	//  //Hard assertions payment page
	//  
	//  Assert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
	
	   
	}
