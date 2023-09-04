package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class bundleProductAddAllToCart extends baseClass{

	
	public void addAllToCart(WebDriver driver) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
 		WebElement elementXPath = driver.findElement(By.xpath("//div[@class='col-12 col-sm-6 offset-sm-6 bundle-footer']"));
 		WebElement elementCss = driver.findElement(By.cssSelector("div.bundle-footer"));
 		List<WebElement>  inStock =elementCss.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));

 	    // Check if the element is present
 	    if (inStock.size()> 0 ) {
 	    		
	 	       	WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAllToCartElement);
				if(!addAllToCartElement.isEnabled()) {
					test.info("product is out of stock searching for new product");
//					BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
//					bundleProduct.performRandomOperations(driver);
//					addAllToCart(driver);
					
				}else {
					Thread.sleep(5000);
					js.executeScript("arguments[0].click();", addAllToCartElement);
					System.out.println("All products added to cart");
					Thread.sleep(5000);	       	
	 	           	System.out.println("Product is availble");
	 	           
				}
			}
	}
}
