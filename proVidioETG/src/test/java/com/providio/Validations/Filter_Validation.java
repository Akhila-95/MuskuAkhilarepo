package com.providio.Validations;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class Filter_Validation extends baseClass {
	@Test
	public void filterValidation() throws InterruptedException {
		
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/womens/clothing/tops/?lang=en_US");
		
//		navigationPage navPage =new navigationPage(driver);
//		navPage.selectRandomMenu(driver);
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
		jsExecutor.executeScript("window.scrollBy(0, 330);");
		
		List <WebElement> priceElement= driver.findElements(By.xpath("//div[contains(@class,'refinement-price mb-3')]"));
		
		List <WebElement> colorElement= driver.findElements(By.xpath("//div[contains(@class,'refinement-color mb-3')]"));
		
		List <WebElement> sizeElement= driver.findElements(By.xpath("//div[contains(@class,'refinement-size mb-3')]"));
//		
				
//
//		if(colorElement.size()>0) {
//			productListingPage plp =new productListingPage(driver);
//			Thread.sleep(5000);
//			plp.selecttheColor(driver);
//			
//			Thread.sleep(7000);
//			System.out.println("44d");
//			
//		}
//		if(sizeElement.size()>0) {
//			productListingPage plp =new productListingPage(driver);
//			Thread.sleep(3000);
//			plp.selectTheSize(driver);
//			System.out.println("hjk");
//			Thread.sleep(3000);
//			
//		}
		if(priceElement.size()>0) {
			productListingPage plp =new productListingPage(driver);
			Thread.sleep(6000);
			plp.selectthePrice(driver);
			Thread.sleep(7000);
			logger.info("Selected price randomly");
		}
	}
}
