package com.providio.Validations;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class QuantityValidation extends baseClass {
	
@Test	
public void commonScript() throws InterruptedException {
		
		driver.get(this.baseURL);
        logger.info("enterd into url");
       
        navigationPage navMenu = new navigationPage(driver);
     
        navMenu.clickwoMensMenubaritems(driver);
        logger.info("hovered on Womens");
        
        navMenu.ClickwoMensofBraceletss(driver);
        logger.info("clicked on Braceletss  sub menu");	        

        productListingPage plp = new productListingPage(driver);
        plp.clickOnProduct(driver);
       // plp.selectProductRandom(driver);
        logger.info("clicked on earings product");

        size s = new size();
        s.selectSize(driver);
        
        miniCartPage mc = new miniCartPage(driver);
        
        Thread.sleep(4000);
           
        //click on the cart button
        mc.clickcartbutton(driver);
        Thread.sleep(2000);
        
        quantityValidationInMinicart();

        mc.clickCheckout();
        logger.info("Clicked on checkout button");
        
        quantityValidationInViewCart();
 
	}
	
	//quantity Validation In Minicart
		public void quantityValidationInMinicart() throws InterruptedException {
			
			logger.info("Increasing the quantity in minicart");
			toIncreaseQuantity();
			
			logger.info("Decreasing the quantity in minicart");
			toDecreaseQuantity();
		}
	
	//view cart validation
		public void quantityValidationInViewCart() throws InterruptedException {				
          
			logger.info("Increasing the quantity in viewcart");
            toIncreaseQuantity();
            
        	logger.info("Decreasing the quantity in viewcart");	            
            toDecreaseQuantity();
         
            
		}
			
			
	 Float unitProductValue= (float) 0;
	 Float totalProductValue1 = (float) 0 ;
	 String formattedTotalProductValue=null;
	 int j=1;
	 
	 
    public void toIncreaseQuantity() throws InterruptedException {
    	
    	//products count in minicart
    	 List<WebElement> itemsCountInMinicart= driver.findElements(By.xpath("//div[@class='card-body']"));
    	 List<WebElement> itemsInViewCart= driver.findElements(By.xpath("//h2[contains(@class,'number-of-items ')]"));
    	 if(itemsCountInMinicart.size()>0) {
    		 
	    	 for(int k=1;k<=itemsCountInMinicart.size();k++) {
			    	 WebElement product = driver.findElement(By.xpath("(//div[@class='line-item-name'])["+k+"]"));
			    	 logger.info("The product name in minicart is " + product.getText());
			    	
			    	 Thread.sleep(3000);
			    	
			    	 //unit price of product
			    	 WebElement parentDiv= driver.findElement(By.xpath("(//div[@class='unit-price'])["+k+"]"));
			    	 WebElement unitPrice = parentDiv.findElement(By.xpath("(//span[@class='sales'])["+k+"]"));
			    	 logger.info("Unit price of the product is " +unitPrice.getText());
			    	 
					 String productValueinText = unitPrice.getText();
			         String numericValue = productValueinText.substring(1).replace(",", "");
			         unitProductValue = Float.parseFloat(numericValue);
			    	 Thread.sleep(2000);
			    	
					// total price 	
			    	 Thread.sleep(2000);		 
					 WebElement totalPriceBeforeIncrease =driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])["+k+"]"));				
					 logger.info("The total price shown before increasing the quantity is " +totalPriceBeforeIncrease.getText());
			         for( j=1; j<=4;j++) {		            	 
			
			        	try {
				    		//increase quantity
				    		 WebElement plusQuantity = driver.findElement(By.xpath("(//span[@class='qty-plus'])["+k+"]"));
				    		 Thread.sleep(1000);
				    		 plusQuantity.click();
			        	}catch(StaleElementReferenceException e) {
				        	 System.out.println(e);
				        }			        	
				    }
			         totalProductValue1 =  unitProductValue*(j);
			         
			      // Format the float value as currency with the dollar sign
			         NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
			         formattedTotalProductValue = currencyFormat.format(totalProductValue1);
					 logger.info("After increasing the qunatity the calculated price is " +formattedTotalProductValue );
					 
			         Thread.sleep(3000);
					 WebElement totalPriceAfterIncrease =driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])["+k+"]"));				            		
			    	 logger.info("The total price shown  increasing the quantity is " +totalPriceAfterIncrease.getText());
			    		
			    	 test.info("To check whether the quantity increasing is reflecting in price");
			        		if(formattedTotalProductValue.equals(totalPriceAfterIncrease.getText())) {
			        			test.pass("Succesfully the price is reflecting While increasing the quantity ");
			        			logger.info("While increasing the quantity of the price is also increasing");
			        		}else {
			        			test.fail("While increasing the quantity of the price is not increasing");
			        			logger.info("While increasing the quantity of the price is not increasing");
			        		}
			        		Thread.sleep(7000);
			        		System.out.println("");
	    	 }
	      }else {
	    	  for(int k=1;k<=itemsInViewCart.size();k++) {
			    	 WebElement product = driver.findElement(By.xpath("(//div[@class='line-item-name'])["+k+"]"));
			    	 logger.info("The product name in minicart is " + product.getText());
			    	
			    	 Thread.sleep(3000);
			    	
			    	 //unit price of product
			    	 WebElement parentDiv= driver.findElement(By.xpath("(//div[@class='unit-price'])["+k+"]"));
			    	 WebElement unitPrice = parentDiv.findElement(By.xpath("(//span[@class='sales'])["+k+"]"));
			    	 logger.info("Unit price of the product is " +unitPrice.getText());
			    	 
					 String productValueinText = unitPrice.getText();
			         String numericValue = productValueinText.substring(1).replace(",", "");
			         unitProductValue = Float.parseFloat(numericValue);
			    	 Thread.sleep(2000);
			    	
					// total price 	
			    	 Thread.sleep(2000);		 
					 WebElement totalPriceBeforeIncrease =driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])["+k+"]"));				
					 logger.info("The total price shown before increasing the quantity is " +totalPriceBeforeIncrease.getText());
			         for( j=1; j<=4;j++) {		            	 
			
			        	try {
				    		//increase quantity
				    		 WebElement plusQuantity = driver.findElement(By.xpath("(//span[@class='qty-plus'])["+k+"]"));
				    		 Thread.sleep(1000);
				    		 plusQuantity.click();
			        	}catch(StaleElementReferenceException e) {
				        	 System.out.println(e);
				        }			        	
				    }
			         totalProductValue1 =  unitProductValue*(j);
			         
			      // Format the float value as currency with the dollar sign
			         NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
			         formattedTotalProductValue = currencyFormat.format(totalProductValue1);
					 logger.info("After increasing the qunatity the calculated price is " +formattedTotalProductValue );
					 
			         Thread.sleep(3000);
					 WebElement totalPriceAfterIncrease =driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])["+k+"]"));				            		
			    	 logger.info("The total price shown  increasing the quantity is " +totalPriceAfterIncrease.getText());
			    		
			    	 test.info("To check whether the quantity increasing is reflecting in price");
			        		if(formattedTotalProductValue.equals(totalPriceAfterIncrease.getText())) {
			        			test.pass("Succesfully the price is reflecting While increasing the quantity ");
			        			logger.info("While increasing the quantity of the price is also increasing");
			        		}else {
			        			test.fail("While increasing the quantity of the price is not increasing");
			        			logger.info("While increasing the quantity of the price is not increasing");
			        		}
			        		Thread.sleep(4000);
			        		System.out.println("");
	    	 }
	      }
    }
	     
    
    public void toDecreaseQuantity() throws InterruptedException {
    	//products count in minicart
   	 List<WebElement> itemsCountInMnicart= driver.findElements(By.xpath("//div[@class='card-body']"));
   	 List<WebElement> itemsInViewCart= driver.findElements(By.xpath("//h2[contains(@class,'number-of-items ')]"));
   	 if(itemsCountInMnicart.size()>0) {
	   	 for(int k=1;k<=itemsCountInMnicart.size();k++) {
	   		 
			    	 WebElement product = driver.findElement(By.xpath("(//div[@class='line-item-name'])["+k+"]"));
			    	 logger.info("The product name in minicart is " + product.getText());
			    	
			    	 Thread.sleep(3000);
			    	
			    	 //unit price of product
			    	 WebElement parentDiv= driver.findElement(By.xpath("(//div[@class='unit-price'])["+k+"]"));
			    	 WebElement unitPrice = parentDiv.findElement(By.xpath("(//span[@class='sales'])["+k+"]"));
			    	 logger.info("Unit price of the product is " +unitPrice.getText());
			    	 
					 String productValueinText = unitPrice.getText();
			         String numericValue = productValueinText.substring(1).replace(",", "");
			         unitProductValue = Float.parseFloat(numericValue);
			    	 Thread.sleep(2000);
			    	
					// total price 	
			    	 Thread.sleep(2000);		 
					 WebElement totalPriceBeforeDecrease =driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])["+k+"]"));				
					 logger.info("The total price shown before decreasing the quantity is " +totalPriceBeforeDecrease.getText());
					 String totalProductValueBeforeDecrease = totalPriceBeforeDecrease.getText();
			         String numericValue1 = totalProductValueBeforeDecrease.substring(1).replace(",", "");
			         float formattedtotalProductValue = Float.parseFloat(numericValue1);
			    	 Thread.sleep(2000);
					 
			         for( j=1; j<=2;j++) {		            	 
			
			        	try {
				    		//increase quantity
				    		 WebElement minusQuantity = driver.findElement(By.xpath("(//span[@class='qty-minus'])["+k+"]"));
				    		 Thread.sleep(1000);
				    		 minusQuantity.click();
			        	}catch(StaleElementReferenceException e) {
				        	 System.out.println(e);
				        }			        	
				    }
			         System.out.println(formattedtotalProductValue);
			         System.out.println(unitProductValue*j);
			         totalProductValue1 =  (unitProductValue*j);
			         
			      // Format the float value as currency with the dollar sign
			         NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
			         formattedTotalProductValue = currencyFormat.format(totalProductValue1);
					 logger.info("After decreasing the qunatity the calculated price is " +formattedTotalProductValue );
					 
			         Thread.sleep(3000);
					 WebElement totalPriceAfterIncrease =driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])["+k+"]"));				            		
			    	 logger.info("The total price shown in the quantity is " +totalPriceAfterIncrease.getText());
			    		
			    	 test.info("To check whether the quantity increasing is reflecting in price");
			        		if(formattedTotalProductValue.equals(totalPriceAfterIncrease.getText())) {
			        			test.pass("Succesfully the price is reflecting While decreasing the quantity ");
			        			logger.info("Succesfully the price is reflecting While decreasing the quantity ");
			        		}else {
			        			test.fail(" The price is not reflecting While decreasing the quantity ");
			        			logger.info("The price is not reflecting While decreasing the quantity");
			        		}
			        		Thread.sleep(7000);
			        		System.out.println("");
	   	 			}
	   	 		}else {
	   	 		 for(int k=1;k<=itemsInViewCart.size();k++) {
	   		   		 
			    	 WebElement product = driver.findElement(By.xpath("(//div[@class='line-item-name'])["+k+"]"));
			    	 logger.info("The product name in minicart is " + product.getText());
			    	
			    	 Thread.sleep(3000);
			    	
			    	 //unit price of product
			    	 WebElement parentDiv= driver.findElement(By.xpath("(//div[@class='unit-price'])["+k+"]"));
			    	 WebElement unitPrice = parentDiv.findElement(By.xpath("(//span[@class='sales'])["+k+"]"));
			    	 logger.info("Unit price of the product is " +unitPrice.getText());
			    	 
					 String productValueinText = unitPrice.getText();
			         String numericValue = productValueinText.substring(1).replace(",", "");
			         unitProductValue = Float.parseFloat(numericValue);
			    	 Thread.sleep(2000);
			    	
					// total price 	
			    	 Thread.sleep(2000);		 
					 WebElement totalPriceBeforeDecrease =driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])["+k+"]"));				
					 logger.info("The total price shown before decreasing the quantity is " +totalPriceBeforeDecrease.getText());
					 String totalProductValueBeforeDecrease = totalPriceBeforeDecrease.getText();
			         String numericValue1 = totalProductValueBeforeDecrease.substring(1).replace(",", "");
			         float formattedtotalProductValue = Float.parseFloat(numericValue1);
			    	 Thread.sleep(2000);
					 
			         for( j=1; j<=2;j++) {		            	 
			
			        	try {
				    		//increase quantity
				    		 WebElement minusQuantity = driver.findElement(By.xpath("(//span[@class='qty-minus'])["+k+"]"));
				    		 Thread.sleep(1000);
				    		 minusQuantity.click();
			        	}catch(StaleElementReferenceException e) {
				        	 System.out.println(e);
				        }			        	
				    }
			         System.out.println(formattedtotalProductValue);
			         System.out.println(unitProductValue*j);
			         totalProductValue1 =  (unitProductValue*j);
			         
			      // Format the float value as currency with the dollar sign
			         NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
			         formattedTotalProductValue = currencyFormat.format(totalProductValue1);
					 logger.info("After decreasing the qunatity the calculated price is " +formattedTotalProductValue );
					 
			         Thread.sleep(3000);
					 WebElement totalPriceAfterIncrease =driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])["+k+"]"));				            		
			    	 logger.info("The total price shown in the quantity is " +totalPriceAfterIncrease.getText());
			    		
			    	 test.info("To check whether the quantity increasing is reflecting in price");
			        		if(formattedTotalProductValue.equals(totalPriceAfterIncrease.getText())) {
			        			test.pass("Succesfully the price is reflecting While decreasing the quantity ");
			        			logger.info("Succesfully the price is reflecting While decreasing the quantity ");
			        		}else {
			        			test.fail(" The price is not reflecting While decreasing the quantity ");
			        			logger.info("The price is not reflecting While decreasing the quantity");
			        		}
			        		Thread.sleep(4000);
			        		System.out.println("");
	   	 			}
	   	 		}	   	 		
    }
    
	
		
}
