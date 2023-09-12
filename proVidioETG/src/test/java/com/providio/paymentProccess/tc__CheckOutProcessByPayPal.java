package com.providio.paymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.Validations.Checkout_Validation;
import com.providio.Validations.ShippingAndBilling_PaymentDetails;
import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.testcases.baseClass;

public class tc__CheckOutProcessByPayPal extends baseClass{
		
	 Checkout_Validation checkout= new Checkout_Validation();
	 
	    public void checkoutprocessFromMiniCart() throws InterruptedException {


			WebElement minicartcount =  driver.findElement(By.cssSelector(".minicart-quantity"));
		    String countOfMinicart = minicartcount.getText();
		    int minicartCountValue = Integer.parseInt(countOfMinicart);
	        if (minicartCountValue > 0) {

	            miniCartPage mc = new miniCartPage(driver);
	            
	            	Thread.sleep(3000);
	                mc.clickcartbuttonjs(driver);
	                Thread.sleep(2000);
	  
	                //Checkout_Validation checkout= new Checkout_Validation();
	                checkout.validateMiniCartClick();
	                       
				//paypal checkout process
	            Thread.sleep(2000);
				List<WebElement> salesforceButton= driver.findElements(By.xpath("//div[contains(@class,'salesforce')]"));
				List<WebElement> brainPayPalButton = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
				if(salesforceButton.size()>0) {
					logger.info("Salesforce paypal integration activated");
					WebElement salesforceButton1= driver.findElement(By.xpath("//div[contains(@class,'salesforce')]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", salesforceButton1);
					mc.clickSalesforcePaypalButton();	
					paymentpPage pp =new paymentpPage(driver);
					Thread.sleep(3000);
					//checkout.validatePaypalClick();
					pp.paypalPopup(driver);
					logger.info("Entered into paypal window and entered the paypal details");
					//paypal window
		
					
				}else if(brainPayPalButton.size()>0){
					logger.info("Brain tree activated");
					WebElement brainPayPalButton1 = driver.findElement(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  brainPayPalButton1);
					mc.clickBrainTreePaypalButton();
					logger.info("Clicked on  brain tree paypal button");
					paymentpPage pp =new paymentpPage(driver);
					Thread.sleep(3000);
					//checkout.validatePaypalClick();
					pp.paypalPopup(driver);					
				}else {
					test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
	            	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
				}
				       //review order page
					        reviewOrderPage rop = new reviewOrderPage(driver);
							Thread.sleep(3000);

							 if(driver.findElements(By.xpath("//button[contains(@class,'place-order')]")).size()!=0) {
								rop.clickonplaceorderwithJsExuter(driver);
								test.info("successfully click on the place order button");
							 }
							 Thread.sleep(8000);
				    		System.out.println(driver.getTitle());
						
				    		 //Checkout_Validation checkout= new Checkout_Validation();
				    		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
				    			
				    			 Checkout_Validation checkout= new Checkout_Validation();
				    		 //validate the final place the order page
				    			 checkout.validatePlacetheOrderPage();
				    		
				    	     //ordernumberandOrderdate
				    			 checkout.ordernumberandOrderdat();
				    			 Thread.sleep(5000);
				    			}
	        }
	 }
	 
	 //checkout from viewcart paypal button
	    
	 		public void checkoutprocessFromViewCart() throws InterruptedException {

	 			WebElement minicartcount = driver.findElement(By.cssSelector(".minicart-quantity"));
	 		    String countOfMinicart = minicartcount.getText();
	 		    int minicartCountValue = Integer.parseInt(countOfMinicart);
	 			//count of items in minicart 
		 		   if (minicartCountValue > 0) {
	
			            miniCartPage mc = new miniCartPage(driver);
			            
			            	Thread.sleep(5000);
			                mc.clickcartbuttonjs(driver);
			                Thread.sleep(2000);
			               // Checkout_Validation checkout= new Checkout_Validation();
			                
				           //validate minicart
				           checkout.validateMiniCartClick();
				            logger.info("Validated minicart");
				            
				            mc.clickviewCartButton(driver);
				            logger.info("Clicked on view cart button"  );
				            
				            checkout.validateViewCartClick();
				            logger.info("Validated the view cart ");
				            
				            viewCartPage vcp = new viewCartPage(driver);
			            
				            Thread.sleep(2000);
			            List<WebElement> brainPayPalButton = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
			            List<WebElement> salesforcePayPalButton = driver.findElements(By.xpath("(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]"));
			            
				            if(brainPayPalButton.size()>0) {
				            	test.info("Braintree payment integration is activated");
				            	 vcp.braintreePayPalButton(driver);
				            }else if(salesforcePayPalButton.size()>0){
				            	test.info("Salesforce payment integration is activated");
				            	vcp.salesforcePayPalButton(driver);
				            	
				            }else {
				            	test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
				            	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
				            }
					        	paymentpPage pp =new paymentpPage(driver);
					        	Thread.sleep(2000);
					        	//validate paypal window
					        	// checkout.validatePaypalClick();
								pp.paypalPopup(driver);
								//test.info("Entered into paypal window and entered the paypal details");
								reviewOrderPage rop = new reviewOrderPage(driver);							
								Thread.sleep(3000);
								 if(driver.findElements(By.xpath("//button[contains(@class,'place-order')]")).size()!=0) {
									rop.clickonplaceorderwithJsExuter(driver);
									test.info("successfully click on the place order button");
								 }
					    		Thread.sleep(10000);
								if(driver.getTitle().endsWith("Order Confirmation | Providio")) {								
									 Checkout_Validation checkout= new Checkout_Validation();
								 //validate the final place the order page
									 checkout.validatePlacetheOrderPage();							
							     //ordernumberandOrderdate
									 checkout.ordernumberandOrderdat();
									 Thread.sleep(3000);
									}
	 		   }
		 		   
			 		  	           
	 		}
	        
	    public void checkoutprocessFromCheckout() throws InterruptedException {

	    	List<WebElement> billingAddress= driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));
		    	  if(billingAddress.size()>0) {
					//List<WebElement> brainPaypalAcc = driver.findElements(By.xpath("//option[@id ='braintreePaypalAccount']"));		    	
			    	//System.out.println(brainPaypalAcc.size());
		    	 
		    	 	List<WebElement> brainPaypalAcc = driver.findElements(By.cssSelector("img[title='PayPal Credit']"));
			    	List<WebElement> parentDivOfPaypal= driver.findElements(By.xpath("//div[@aria-label='PayPal Checkout']"));
			    	List<WebElement> salesforcePaypal= driver.findElements(By.xpath("(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]"));
			    	JavascriptExecutor js = (JavascriptExecutor) driver;	    		  
		    		js.executeScript("window.scrollBy(0,500)", "");
	
		    	 if(brainPaypalAcc.size()>0) {	    		
		    		test.info("Brain tree payment integration is activated");
		    		WebElement brainPaypalAcc1 = driver.findElement(By.cssSelector("img[title='PayPal Credit']"));
		    		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",brainPaypalAcc1);
		    		paymentpPage pp =new paymentpPage(driver);	   
		    		Thread.sleep(2000);
		    		pp.braintreePaypal(driver);
		    		Thread.sleep(2000);
		    		WebElement reviewOrderButton= driver.findElement(By.xpath("//button[contains(@class,'submit-payment')]"));
		    		if (reviewOrderButton.isDisplayed()) {
		    			WebElement reviewOrderButton1= driver.findElement(By.xpath("//button[contains(@class,'submit-payment')]"));	
						js.executeScript("arguments[0].click();", reviewOrderButton1);         
					}else  {
						pp.brainTreeAfterClick(driver);
						logger.info("A click to Enter into paypal");				
				    	pp.paypalPopup(driver);
				    	logger.info("Clicked on paypal button");
	
				    	// review order page
				    		reviewOrderPage rop = new reviewOrderPage(driver);
				    		Thread.sleep(4000);			    		
				    		
				    		//List<WebElement> reviewOrderList= driver.findElements(By.xpath("//button[contains(text(), 'Next: Review Order')]"));
				    		WebElement reviewOrder= driver.findElement(By.xpath("//button[contains(text(), 'Next: Review Order')]"));	
				    		
				    		if(reviewOrder.isDisplayed()) {
					    		rop.clickonReviewOrder(driver);
					    		logger.info("Clicked on review order button");
					    		Thread.sleep(2000);
					    		
					    		//shipping and billing ,payment detailss
					    		ShippingAndBilling_PaymentDetails details= new ShippingAndBilling_PaymentDetails();
					    		details.placeOrderPageDetails();
				    		}
				    		//placeorder
				    		WebElement placeOrder= driver.findElement(By.cssSelector("button.place-order"));	
				    		List<WebElement> placeOrderList= driver.findElements(By.cssSelector("button.place-order"));
				    		if (placeOrder.isDisplayed()) { 
				    			 js.executeScript("window.scrollBy(0,350)", "");
				    			 Thread.sleep(3000);
				    			 WebElement placeOrderButton= driver.findElement(By.cssSelector("button.place-order"));		    		
				    				
				    			 js.executeScript("arguments[0].click();", placeOrderButton);
				    			 Thread.sleep(5000);
					    		 logger.info("successfully click on the place order button by normal click");
					    		
					    		}					
					}
		    	}else if(salesforcePaypal.size()>0) {	 
		    	
		    		test.info("salesoforce payment integration is activated");
		    		WebElement salesforcePaypal1= driver.findElement(By.xpath("(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]"));
		    		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", salesforcePaypal1);
				    paymentpPage pp = new paymentpPage(driver);		   	         
				    pp.salesforcePaypalCheckout(driver);	
				    logger.info("Clicked on paypal button after clicking on paypal icon");
				    Thread.sleep(2000);
			    	pp.paypalPopup(driver);
			    	logger.info("Clicked on paypal button");
		    	}else {
		    		test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
	            	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
		    	}
	    	  }
	    		Thread.sleep(10000);
	    		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
	    			
	    			 Checkout_Validation checkout= new Checkout_Validation();
	    		 //validate the final place the order page
	    			 checkout.validatePlacetheOrderPage();
	    		
	    	     //ordernumberandOrderdate
	    			 checkout.ordernumberandOrderdat();
	    			 Thread.sleep(3000);
	    			}
	    }
	    
	    public void paypalCheckoutFromPDP() throws InterruptedException {
 
	    	
	 			    Thread.sleep(4000);
	 				paymentpPage pp =new paymentpPage(driver);
	 				pp.paypalPopup(driver);
	 				
	 				reviewOrderPage rop = new reviewOrderPage(driver);
					Thread.sleep(2000);
					
					WebElement placeOrder= driver.findElement(By.cssSelector("button.place-order"));	
		    		//List<WebElement> placeOrderList= driver.findElements(By.cssSelector("button.place-order"));
			    		if (placeOrder.isDisplayed()) { 
						rop.clickonplaceorderwithJsExuter(driver);
						test.info("successfully click on the place order button");
						Thread.sleep(8000);
		    		}
		    		
					if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
						
						 Checkout_Validation checkout= new Checkout_Validation();
					 //validate the final place the order page
						 checkout.validatePlacetheOrderPage();
					
				     //ordernumberandOrderdate
						 checkout.ordernumberandOrderdat();
						} 
	 		  
	    }
	    
	    public void paypalFromLoginPage() throws InterruptedException {
	    	
		    	List<WebElement> paypalList= driver.findElements(By.xpath("(//div[contains(@class,'paypal-buttons-layout-horizontal')])[1]"));
		    	if(paypalList.size()>0) {	
		    		test.info("Paypal in login page");
		    		WebElement paypal= driver.findElement(By.xpath("(//div[contains(@class,'paypal-buttons-layout-horizontal')])[1]"));
		    		paypal.click();
		    		Thread.sleep(4000);
	 				paymentpPage pp =new paymentpPage(driver);
	 				pp.paypalPopup(driver);
	 				 checkOutPage cp = new checkOutPage(driver);
			          //selecting shipping address
			            
		            tc__CheckOutProcess cop = new tc__CheckOutProcess();
		            cop.selectShippingAddress(cp);
		            cop.selectPaymentMethod(cp);
		            
		            WebElement placeOrder= driver.findElement(By.cssSelector("button.place-order"));	
		    		//List<WebElement> placeOrderList= driver.findElements(By.cssSelector("button.place-order"));
		    		if (placeOrder.isDisplayed()) { 
			            reviewOrderPage rop = new reviewOrderPage(driver);
						Thread.sleep(2000);
						rop.clickonplaceorderwithJsExuter(driver);
						logger.info("successfully click on the place order button");
						Thread.sleep(5000);
		    		}		    				    		
					if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
						
						 Checkout_Validation checkout= new Checkout_Validation();
					 //validate the final place the order page
						 checkout.validatePlacetheOrderPage();
					
				     //ordernumberandOrderdate
						 checkout.ordernumberandOrderdat();
						}
		    	}else {
		    		test.info("No paypal button in login page");
		    		
		    	}
	 			  
	    }

		
}
