package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.SizeSelectionInQuickShop;
import com.providio.pageObjects.homePage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;

public class tc__WishlistProccess extends baseClass {

	
	public void wishlistPage(WebDriver driver) throws InterruptedException {
	 navigationPage navPage= new navigationPage(driver);
     
     navPage.selectRandomMenu(driver);
     logger.info("Selected random menu");
     
     productListingPage plp = new productListingPage(driver);
     plp.selecttheWishlist();
     logger.info("Added product to wishlist");
    
     homePage hp=new homePage(driver);
     Thread.sleep(3000);
     hp.clickOnWishlist(driver);
	 logger.info("clicked on  wishlist");
	 
	 
	 List<WebElement> productCards = driver.findElements(By.xpath("//div[contains(@class, 'row') and contains(@class, 'product-card')]"));

	 for (int i = productCards.size(); i >= 1; i--) {
	     List<WebElement> productCardsUpdated = driver.findElements(By.xpath("//div[contains(@class, 'row') and contains(@class, 'product-card')]"));

	     WebElement productcardparent = productCardsUpdated.get(i - 1);

	     List<WebElement> noofInStockElements = productcardparent.findElements(By.xpath(".//span[@class='value' and @content='null']"));
	     logger.info(noofInStockElements.size());

	     if (noofInStockElements.size() > 0) {
	         Thread.sleep(3000);
	         
	         List<WebElement> remove = driver.findElements(By.xpath("(//button[starts-with(@class, 'remove-btn-lg remove-from-wishlist')])["+i+"]"));
	         logger.info(remove.size());
	         WebElement removeButton = remove.get(0);

	         if (removeButton.isDisplayed()) {
	             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", removeButton);
	             Thread.sleep(1000);
	             JavascriptExecutor js = (JavascriptExecutor) driver;
	             js.executeScript("arguments[0].click();", removeButton);
	             logger.info("Removed the wishlist");
	             test.pass("Removed from the wishlist because of price of the product is null");
	         } else {
	             logger.info("Remove button is not visible");
	         }

	         logger.info("Product name with null value: ");
	     } else {
	         logger.info("Product value is not null.");
	     }
	 }

	 Thread.sleep(10000);

	//add to cart from wishlist
		
		List<WebElement> selectAttributesButton = driver.findElements(By.xpath("//button[@class='select-attributes-btn btn btn-outline-primary']"));
		 int countOfselectAttributesButton= selectAttributesButton.size();
		 System.out.println("The total product in Select Attributes " + countOfselectAttributesButton);
		 
		
		 for(int i=countOfselectAttributesButton;i >=1;i--) {
			 
			 Thread.sleep(5000);
			 WebElement productsInWishlist1 = driver.findElement(By.xpath("(//button[@class='select-attributes-btn btn btn-outline-primary'])[" + i + "]" ));
			
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", productsInWishlist1);

			 //productsInWishlist1.click();
			  System.out.println("Clicked on Select attributes");
			  Thread.sleep(5000);
			  
			  //size selection
			  SizeSelectionInQuickShop sizeSelection = new SizeSelectionInQuickShop();
			  sizeSelection.sizeSelectionInQuickShop(driver);
			  logger.info("Selected size");
			

			  //update
			  Thread.sleep(5000);
			  WebElement updateElement= driver.findElement(By.xpath("//button[@class='btn-update-wishlist-product update-cart-product-global btn btn-primary']"));
			  boolean isEnabled = updateElement.isEnabled();

			  if (isEnabled) {
			      System.out.println("Button is enabled");
			      updateElement.click();
				  logger.info("Clicked on update");
				  test.pass("Product is changed from select attributes to the Add To Cart");
			      
			  } else {
			      System.out.println("Button is disabled");
			      
			  }
			  
		 }
		 
		 Thread.sleep(5000);
		 
		 List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[@class='add-to-cart btn btn-primary']"));
		 int countOfAddToCartButtons = addToCartButtons.size();
		 System.out.println("The total products in the wishlist: " + countOfAddToCartButtons);

		 for (int j = countOfAddToCartButtons - 1; j >= 0; j--) {
		     WebElement addToCartButton = addToCartButtons.get(j);

		     try {
		         boolean isEnabled = addToCartButton.isEnabled();

		         if (isEnabled) {
		             System.out.println("Button is enabled");
		             JavascriptExecutor js = (JavascriptExecutor) driver;
		             js.executeScript("arguments[0].click();", addToCartButton);
		             
		             logger.info("Product added to cart");
		             test.pass("Product is successfully add to the cart");
		         } else {
		             // Remove from the wishlist
		             WebElement removeButton = driver.findElement(By.xpath("//button[@class='remove-btn-lg remove-from-wishlist btn btn-light']"));
		             removeButton.click();

		             System.out.println("Button is disabled");
		         }
		     } catch (StaleElementReferenceException e) {
		         // Element is stale, re-find the element and continue with the loop
		         addToCartButtons = driver.findElements(By.xpath("//button[@class='add-to-cart btn btn-primary']"));
		         addToCartButton = addToCartButtons.get(j);
		         j++; // Increment j to repeat the same index in the next iteration
		     }
		 }

		 

			}
	
	}


	

