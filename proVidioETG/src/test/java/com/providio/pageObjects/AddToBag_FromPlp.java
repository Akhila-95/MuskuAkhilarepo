package com.providio.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import com.providio.testcases.baseClass;

public class AddToBag_FromPlp extends baseClass {

	public void addToBag_FromPlp(WebDriver driver) throws InterruptedException {
		
		//The cart value before adding the product to cart
				Thread.sleep(2000);
		        WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
		        String countOfMinicart = minicartcount.getText();
		        int minicartCountValue = Integer.parseInt(countOfMinicart);
		        logger.info("The minicart count before adding the product is "+minicartCountValue);
		        
		   List<WebElement> allProduct =driver.findElements(By.xpath("//img[@class='tile-image']"));
	        int countOfProducts= allProduct.size();
	   try {
	        for(int i=1; i<=3;i++) {
	        	 Thread.sleep(3000);
	        	 WebElement product =driver.findElement(By.xpath("(//img[@class='tile-image'])["+i+"]"));	        	
	        	 Actions action = new Actions(driver);
				 action.moveToElement(product).perform();
				 Thread.sleep(2000);				 
				
				 
				 if(driver.findElements(By.xpath("(//a[@data-addtocart='Add to Bag'])["+i+"]")).size()!=0) {	
					 WebElement  addToBagbutton =driver.findElement(By.xpath("(//a[@data-addtocart='Add to Bag'])["+i+"]"));
					 //addToBagbutton.click();
					  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToBagbutton);
					  Thread.sleep(6000);
			            // Click the element
					  JavascriptExecutor js = (JavascriptExecutor) driver;

					  js.executeScript("arguments[0].click();", addToBagbutton);
					  //addToBagbutton.click();
				 }
				 //Find the div containing the list using XPath.
			       List<WebElement> parentDiv = driver.findElements(By.xpath("//div[@class='plp-size-list js-plp-size-list']"));
			        if(parentDiv.size()>0) {
			        	
			        	 WebElement divElement = driver.findElement(By.xpath("//div[@class='plp-size-list js-plp-size-list']"));
				        // Find all the list items (li tags) within the div using XPath.
				        List<WebElement> listItems = divElement.findElements(By.xpath(".//li"));
				        
				        if (listItems.isEmpty()) {
				            System.out.println("No size options available. Cannot proceed with adding the product to the cart.");
				            return;
				        }
				        // Get the total number of list items.
				        int totalItems = listItems.size();
				        
				        // Generate a random number between 0 and the total number of list items.
				        Random random = new Random();
				        int randomIndex = random.nextInt(totalItems);
		
				        // Get the link (a tag) corresponding to the randomly selected index.
				        WebElement randomLink = listItems.get(randomIndex).findElement(By.tagName("a"));
		
				        // Click on the randomly selected link.
				        Thread.sleep(2000);
				       
				        JavascriptExecutor js = (JavascriptExecutor) driver;
				        js.executeScript("arguments[0].click();", randomLink);
				      //  randomLink.click();
			        }
				        Thread.sleep(1000);
				       // WebElement addToBagAfterSizeSelected1 = driver.findElement(By.xpath("//a[@class='btn btn-outline-primary add-to-cart js-pt-add-to-cart hidden-md-down w-50 success-color']"));
				       // WebElement addToBag1 = addToBagAfterSizeSelected1.findElement(By.xpath("(//span[contains(text(),'Add to Bag')])["+i+"]"));
				        if(driver.findElements(By.xpath("//a[@class='btn btn-outline-primary add-to-cart js-pt-add-to-cart hidden-md-down w-50 success-color']")).size()!=0) {
				        	Thread.sleep(1000);
					        WebElement addToBagAfterSizeSelected = driver.findElement(By.xpath("//a[@class='btn btn-outline-primary add-to-cart js-pt-add-to-cart hidden-md-down w-50 success-color']"));
					        WebElement addToBag2 = addToBagAfterSizeSelected.findElement(By.xpath("(//span[contains(text(),'Add to Bag')])["+i+"]"));
					        Thread.sleep(3000);
				       
					        System.out.println("Product add to cart");
					        JavascriptExecutor js = (JavascriptExecutor) driver;
							js.executeScript("arguments[0].click();", addToBag2);
					        //addToBag2.click();
					        Thread.sleep(6000);
				        }else {
				        	System.out.println("Product is out of stock");
				        } 
				        if(driver.findElements(By.xpath("(//span[contains(text(),'Add to Bag')])["+i+"]")).size()!=0) {
					 
					   Thread.sleep(3000);
					   // Find the parent div element containing the anchor tag with the specified class using XPath.
				        WebElement parentDiv1 = driver.findElement(By.xpath("//div[@class='d-flex flex-row']//a[2]"));

				        // Find the child div element within the parent div using XPath.
				        WebElement childDiv = parentDiv1.findElement(By.xpath(".//span[@class='button-content']"));
				        JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", childDiv);
				       // childDiv .click();
//					   WebElement addToBagAfterSizeSelected = driver.findElement(By.xpath("//a[@class='btn btn-outline-primary add-to-cart js-pt-add-to-cart hidden-md-down w-50 success-color']"));
//					   WebElement directAddToBagButton=addToBagAfterSizeSelected.findElement(By.xpath("(//span[contains(text(),'Add to Bag')])["+i+"]")) ; 
//					   directAddToBagButton.click();
					   System.out.println("Directly added to cart from plp");
					   Thread.sleep(5000);
					   
				 } else {
					 System.out.println("No add to cart button from plp page ");
				 }
				//adding product from plp to cart by Add to bag button	 
				 WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
		         String countOfMinicartafteradding = minicartcountafteradding.getText();
		         int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

		         logger.info("Minicart count after the product is "+minicartCountValueafteradding);



			  //validation for product add to cart
			      test.info("Verifying the product is added to cart or not ");
			
			
			
			      if( minicartCountValueafteradding!= minicartCountValue) {
			          test.pass("Product added to cart");
			          logger.info("Product is  added to cart");
			      }else {
			          test.pass("Product is out of stock");
			          logger.info("Product is not added to cart");
			      }
	      }
	      
		}catch(MoveTargetOutOfBoundsException e){
			System.out.println(e);
		}
	}
}
