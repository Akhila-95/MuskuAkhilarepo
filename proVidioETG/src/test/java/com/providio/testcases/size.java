package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;

public class size extends baseClass{

	public void selectSize(WebDriver driver) throws InterruptedException {
		
		 
		//selecting attributes
			allElements(driver);
			
			
	     productDescriptionPage pdp = new productDescriptionPage(driver);
	     WebElement cartEnabled =driver.findElement(By.xpath("//button[contains(@class,'add-to-cart')]"));
	     List  <WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
	     if(cartEnabled.isEnabled()&& inStock.size()>0) {
		     pdp.clickcartbutton(driver);
		   /*  System.out.println("Product added to cart");
		     test.info("Verifying Add to cart button in PDP");
		     if(cartEnabled.isDisplayed()) {
		    	 test.pass("Successfully clicked on add to cart button");
		     }else {
		    	 test.fail("Not clicked on add to cart button");
		     }*/
		      
	     }else {
	    	 System.out.println("Product is out of stock so searching for new product");
	    	 
	    	 	Thread.sleep(2000);
             	WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
                String countOfMinicart = minicartcount.getText();
                int minicartCountValue = Integer.parseInt(countOfMinicart);
                System.out.println("Minicart count is " +minicartCountValue);

	    	 navigationPage navPage =new navigationPage(driver);
	    	 navPage.selectRandomMenu(driver);
	    	 
	    	
	    	 productListingPage plp = new productListingPage(driver);
	    	 plp.selectProductRandom(driver);
	
	    	
	    	 selectSize(driver);
	    	 
	    	 WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
             String countOfMinicartafteradding = minicartcountafteradding.getText();
             int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

		         if( minicartCountValueafteradding!= minicartCountValue) {
		        	 System.out.println("Product added to cart");
		            
		         }else {
		        	 System.out.println("Product is not added to cart");
		        	 
		         }	    	 
	     }
	     
	}
	
	public void allElements(WebDriver driver) throws InterruptedException {
		
		//to know the product type
		
		List <WebElement> mainDiv= driver.findElements(By.xpath("//div[@class='attributes px-0']"));
		System.out.println("The total number of size division are " +mainDiv.size());
	
		List<WebElement> colorElement = driver.findElements(By.xpath("//span[contains(@class,' non-input-label')]"));
		System.out.println("The color count is " + colorElement.size());
		
		List<WebElement> sizeElement = driver.findElements(By.xpath("//select[@class='custom-select form-control select-size']"));
		System.out.println("The size count is " +  sizeElement.size());
		
		List<WebElement> memoryElement = driver.findElements(By.id("memorySize-null"));
		
		 List<WebElement> widthElements = driver.findElements(By.xpath(".//select[@id='width-null']"));
	     System.out.println(widthElements.size());
	     
	     List<WebElement> showName = driver.findElements(By.xpath("//select[contains(@class,'select-showName')]"));
	     System.out.println(showName.size());
	     
	     //another way of attributes
	     
	     List<WebElement> sizeBox= driver.findElements(By.xpath("//div[@class='select-size size-change d-flex flex-wrap']"));
	     	     	 	
	     List<WebElement> colorBox= driver.findElements(By.xpath("//button[contains(@class,'color-attribute')]"));
	     
	     List<WebElement> memoryBox = driver.findElements(By.xpath("//div[@class='select-memorySize size-change d-flex flex-wrap']"));
	     
		 List<WebElement> widthBox = driver.findElements(By.xpath("//div[@class='select-width size-change d-flex flex-wrap']"));
		 
		 List<WebElement> showNameBox= driver.findElements(By.cssSelector(".showName"));
	     
	     for(int i=1; i<=mainDiv.size();i++) {
	    	 
			if(colorElement.size()>0|| colorBox.size()>0) {
				productDescriptionPage pdp = new productDescriptionPage(driver);
				pdp.clickOnColor(driver);
				System.out.println("selected color");
				Thread.sleep(4000);
			}if(sizeElement.size()>0|| sizeBox.size()>0 ) {
				
				productDescriptionPage pdp = new productDescriptionPage(driver);
				pdp.clickOnSize(driver);
				System.out.println("selected size");
				Thread.sleep(4000);					
			} if(memoryElement.size()>0||  memoryBox.size()>0) {
				productDescriptionPage pdp = new productDescriptionPage(driver);
				pdp.selecttheMemorySize(driver);
				System.out.println("selected memory size");
				Thread.sleep(4000);
			} if(widthElements.size()>0 || widthBox.size()>0) {
				Thread.sleep(4000);
				productDescriptionPage pdp = new productDescriptionPage(driver);
				pdp.selectWidth(driver);
				System.out.println("selected width");
				Thread.sleep(4000);
			}if(showName.size()>0 || showNameBox.size()>0) {
				Thread.sleep(4000);
				productDescriptionPage pdp = new productDescriptionPage(driver);
				pdp.selectShowName(driver);
				System.out.println("Selected show name ");
			}
			
//			WebElement mainDiv1= driver.findElement(By.xpath("(//div[@class='attributes px-0']) [" +i+"]"));
//			
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mainDiv1);
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("window.scrollBy(0,700)", "");

	     }
	}
	public void clickOnBuyNow(WebDriver driver) throws InterruptedException {
		//selecting attributes
			allElements(driver);
			
	     productDescriptionPage pdp = new productDescriptionPage(driver);
	    List <WebElement> buyNowEnabled =driver.findElements(By.xpath("//button[@class='buy-now btn btn-primary col-12 col-sm-6 d-none']"));
	     List  <WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
	     if((buyNowEnabled.size()>0)&& inStock.size()>0) {
	    	 
	    	 Thread.sleep(3000);	    	 
	    	 WebElement buyNowEnabled1 =driver.findElement(By.xpath("//button[@class='buy-now btn btn-primary col-12 col-sm-6 d-none']"));
		     test.info("Verifying Buy now button in PDP");
			     if(buyNowEnabled1.isDisplayed()) {
			    	 test.pass("Successfully clicked on buy now button");
			     }else {
			    	 test.fail("No  buy now button is clicked");
			     }
			     
		     pdp.clickOnBuyNowButton(driver);
		     System.out.println("Product added to cart by Buy now button");
		     Thread.sleep(3000);
		     
		     
	     }else {
	    	 	System.out.println("Product is out of stock so searching for new product");	    	 
	    	 	Thread.sleep(2000);
	    	 	navigationPage navPage =new navigationPage(driver);
		    	navPage.selectRandomMenu(driver);
		    	 
		    	 productListingPage plp = new productListingPage(driver);
		    	 plp.selectProductRandom(driver);
		    	 
		    	 selectSize(driver);    	 
	     }
	}
	
		public void paypalBuyNowFromPDP(WebDriver driver) throws InterruptedException {
			
			List<WebElement> paypalbuyNowPdp =driver.findElements(By.xpath("//div[contains(@class,'salesforce-buynow-element ')]"));
			if(paypalbuyNowPdp.size()>0) {
			
			//selecting attributes
			  	 allElements(driver);
			  	 Thread.sleep(2000);
			  	
			  	 WebElement paypalbuyNowEnabled =driver.findElement(By.xpath("//div[contains(@class,'salesforce-buynow-element ')]"));
			     List<WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
			     if(paypalbuyNowEnabled.isEnabled()&& inStock.size()>0) {
			    	 productDescriptionPage pdp = new productDescriptionPage(driver);			    	 
			    	 pdp.clickOnPaypalBuyNow(driver);
			    	 
			    	 test.info("Verifying the paypal buy now button");
			    	  if (paypalbuyNowEnabled.isDisplayed()) {
			    		  test.pass("Succesffuly clicked on paypal buy noe button in pdp");
			    	  }
			    	  else {
			    		  test.fail("No  paypal buy now button in pdp");
			    	  }
			    	  
			     }else {
			    	 	System.out.println("Product is out of stock so searching for new product");
			    	 
			    	 	Thread.sleep(2000);
		             	WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
		                String countOfMinicart = minicartcount.getText();
		                int minicartCountValue = Integer.parseInt(countOfMinicart);
		                System.out.println("Minicart count is " +minicartCountValue);

				    	navigationPage navPage =new navigationPage(driver);
				    	navPage.selectRandomMenu(driver);
				    	 
				    	productListingPage plp = new productListingPage(driver);
				    	plp.selectProductRandom(driver);
				    	 
				    	selectSize(driver);
			    	 
				    	WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
			            String countOfMinicartafteradding = minicartcountafteradding.getText();
			            int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

					         if( minicartCountValueafteradding!= minicartCountValue) {
					        	 System.out.println("Product added to cart");
					            
					         }else {
					        	 System.out.println("Product is not added to cart");
					        	 
					         }	    	 
			     }
			  
			}else {
				System.out.println("No paypal buy now button");
			}
		}	
}