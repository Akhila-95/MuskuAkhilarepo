package com.providio.paymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.Validations.Checkout_Validation;
import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.testcases.baseClass;

public class tc__CheckOutProcessByPayPal extends baseClass{
		
	 Checkout_Validation checkout= new Checkout_Validation();
	 
	    public void checkoutprocessFromMiniCart() throws InterruptedException {


			WebElement minicartcount = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
		    String countOfMinicart = minicartcount.getText();
		    int minicartCountValue = Integer.parseInt(countOfMinicart);
	        if (minicartCountValue > 0) {

	            miniCartPage mc = new miniCartPage(driver);
	            
	            	Thread.sleep(5000);
	                mc.clickcartbuttonjs(driver);
	                Thread.sleep(2000);
	  
	                //Checkout_Validation checkout= new Checkout_Validation();
	                checkout.validateMiniCartClick();
	                       
				//paypal checkout process

				List<WebElement> salesforceButton= driver.findElements(By.xpath("//div[contains(@class,'salesforce')]"));
				
				if(salesforceButton.size()>0) {
					logger.info("Salesforce paypal integration activated");
					mc.clickSalesforcePaypalButton();	
					//paypal window
					
					
					paymentpPage pp =new paymentpPage(driver);
				}else {
					logger.info("Brain tree activated");
					mc.clickBrainTreePaypalButton();
				}	
					paymentpPage pp =new paymentpPage(driver);
					Thread.sleep(3000);
					checkout.validatePaypalClick();
					pp.paypalPopup(driver);
					logger.info("Entered into paypal window and entered the paypal details");

				       //review order page
					        reviewOrderPage rop = new reviewOrderPage(driver);
							Thread.sleep(10000);
						
							rop.clickonplaceorderwithJsExuter(driver);
							logger.info("successfully click on the place order button");
							Thread.sleep(10000);
				    		System.out.println(driver.getTitle());
						
				    		 //Checkout_Validation checkout= new Checkout_Validation();
			    		//validate the final place the order page
				    		 checkout.validatePlacetheOrderPage();
						
			            //ordernumberandOrderdate
				    		 checkout.ordernumberandOrderdat();
	        }
	        	

	 }
	 
	 //checkout from viewcart paypal button
	    
	 		public void checkoutprocessFromViewCart() throws InterruptedException {

	 			WebElement minicartcount = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
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
			            
			            List<WebElement> payPalButton = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
				            if(payPalButton.size()>0) {
				            	 logger.info("Braintree payment integration is activated");
				            	 vcp.braintreePayPalButton(driver);
				            }else {
				            	logger.info("Salesforce payment integration is activated");
				            	vcp.salesforcePayPalButton(driver);
				            	
				            }
					        	paymentpPage pp =new paymentpPage(driver);
					        	Thread.sleep(2000);
					        	//validate paypal window
					        	// checkout.validatePaypalClick();
								pp.paypalPopup(driver);
								logger.info("Entered into paypal window and entered the paypal details");
								reviewOrderPage rop = new reviewOrderPage(driver);
								Thread.sleep(10000);
								rop.clickonplaceorderwithJsExuter(driver);
								logger.info("successfully click on the place order button");
								Thread.sleep(10000);
					    		System.out.println(driver.getTitle());
					    		
					    		 //Checkout_Validation checkout= new Checkout_Validation();
					    		//validate the final place the order page
					    		 checkout.validatePlacetheOrderPage();
								
					            //ordernumberandOrderdate
					    		 checkout.ordernumberandOrderdat();   
	 		   }
		 		   
			 		  	           
	 		}
	        
	    public void checkoutprocessFromCheckout() throws InterruptedException {
	    	Thread.sleep(3000);
	    	//payment page
		
				List<WebElement> brainPaypalAcc = driver.findElements(By.xpath("//option[@id ='braintreePaypalAccount']"));		    	
		    	System.out.println(brainPaypalAcc.size());
		    	List<WebElement> parentDivOfPaypal= driver.findElements(By.xpath("//div[@class='tab-pane paypal-content js_braintree_paypalContent active']"));
		    	JavascriptExecutor js = (JavascriptExecutor) driver;	    		  
	    		js.executeScript("window.scrollBy(0,300)", "");

	    	if(brainPaypalAcc.size()>0) {
	    		
	    		test.info("Brain tree payment integration is activated");
	    		paymentpPage pp =new paymentpPage(driver);	    		
	    		pp.braintreePaypal(driver);
	    		Thread.sleep(4000);
	    		List<WebElement> reviewOrderButton= driver.findElements(By.xpath("//button[contains(@class,'submit-payment')]"));
	    		if (parentDivOfPaypal.size()>0) {
	    			pp.brainTreeAfterClick(driver);
					logger.info("A click to Enter into paypal");				
			    	pp.paypalPopup(driver);
			    	logger.info("Clicked on paypal button");
         
				}else {
					WebElement reviewOrderButton1= driver.findElement(By.xpath("//button[contains(@class,'submit-payment')]"));	
					  js.executeScript("arguments[0].click();", reviewOrderButton1);
				}
	    	}else {	 
	    		test.info("salesoforce payment integration is activated");
			    paymentpPage pp = new paymentpPage(driver);		   	         
			    pp.salesforcePaypalCheckout(driver);	
			    logger.info("Clicked on paypal button after clicking on paypal icon");
			    Thread.sleep(2000);
		    	pp.paypalPopup(driver);
		    	logger.info("Clicked on paypal button");
	    	}
	    		
	    	

	    	// review order page
	    		reviewOrderPage rop = new reviewOrderPage(driver);
	    		if(driver.findElements(By.xpath("//button[contains(text(), 'Next: Review Order')]")).size()!=0) {
		    		rop.clickonReviewOrder(driver);
		    		logger.info("Clicked on review order button");
		    		Thread.sleep(2000);
	    		}	    		
	    		if (driver.findElements(By.xpath("//button[contains(text(), 'Place Order')]")).size()!=0) { 	    			
	    			 Thread.sleep(3000);
	    			 WebElement placeOrder= driver.findElement(By.xpath("//button[contains(text(), 'Place Order')]"));		    		
	    			 js.executeScript("window.scrollBy(0,150)", "");	    			
	    			 placeOrder.click();
		    		 logger.info("successfully click on the place order button by normal click");
		    			if(driver.findElements(By.xpath("//button[contains(text(), 'Place Order')]")).size()!=0) {
		    				js.executeScript("arguments[0].click();", placeOrder);
		    				logger.info("successfully click on the place order button by javascript click");
		    				}
		    		}

			
			 Thread.sleep(10000);
			 //Checkout_Validation checkout= new Checkout_Validation();
	    		//validate the final place the order page
	    		 checkout.validatePlacetheOrderPage();
				
	            //ordernumberandOrderdate
	    		 checkout.ordernumberandOrderdat();  
	
	    }
	    
	    public void paypalCheckoutFromPDP() throws InterruptedException {
 
	 			    Thread.sleep(4000);
	 				paymentpPage pp =new paymentpPage(driver);
	 				pp.paypalPopup(driver);
	 				
	 				reviewOrderPage rop = new reviewOrderPage(driver);
					Thread.sleep(10000);
					rop.clickonplaceorderwithJsExuter(driver);
					logger.info("successfully click on the place order button");
					Thread.sleep(10000);
		    		
		    		
		    		// Checkout_Validation checkout= new Checkout_Validation();
		    		//validate the final place the order page
		    		 checkout.validatePlacetheOrderPage();
					
		            //ordernumberandOrderdate
		    		 checkout.ordernumberandOrderdat();  
	 		  
	    }
	    
	    public void paypalFromLoginPage() throws InterruptedException {
	    	
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
		            
		        	reviewOrderPage rop = new reviewOrderPage(driver);
					Thread.sleep(10000);
					rop.clickonplaceorderwithJsExuter(driver);
					logger.info("successfully click on the place order button");
					Thread.sleep(10000);
		    		
		    		
		    		// Checkout_Validation checkout= new Checkout_Validation();
		    		//validate the final place the order page
		    		 checkout.validatePlacetheOrderPage();
					
		            //ordernumberandOrderdate
		    		 checkout.ordernumberandOrderdat(); 
			           
	 			  
	    }

		
}
