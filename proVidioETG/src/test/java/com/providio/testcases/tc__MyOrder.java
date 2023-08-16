//package com.providio.testcases;
//
//
//import org.testng.annotations.Test;
//
//import com.providio.pageObjects.homePage;
//import com.providio.pageObjects.myOrdersPage;
//
//
//
//public class tc__MyOrder extends baseClass  {
//	double totalPrice = 0;
//	 @Test(dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"})
//	public void myOrder() throws InterruptedException {
//		if (isLoggedIn =true) {
//			
//			homePage homepage =new homePage(driver);
//			homepage.hoverOnProfile(driver);
//			logger.info("hovered on profile");
//			
//			homepage.clickOnMyOrders();
//			logger.info("clicked on my orders");
//			
//			myOrdersPage myOrdersPage =new myOrdersPage(driver);
//			myOrdersPage.trackOrderDetails(driver);
//			
//		}
//	
//			 
//			/*// VALIDATION FOR PRICE
//			 List<WebElement> totalPriceElement =driver.findElements(By.xpath("//div[contains(@class, 'pricing line-item-total-price-amount item-total-')]"));
//			for (WebElement priceElement :  totalPriceElement) {
//				 String priceText =priceElement.getText();
//				 String[] parts = priceText.split("\\$");
//				 String priceValue = parts[1];
//				 System.out.println("The price of is " +priceValue );
//				 totalPrice += Double.parseDouble(priceValue);
//				 }
//			 	System.out.println("The sum of all product "+ totalPrice);
//			 	
//			 	
//			 WebElement TextOfSubTotalLocator =driver.findElement(By.xpath("//span[@class='sub-total']"));
//				 String subTotal=TextOfSubTotalLocator.getText();
//				 System.out.println("Sub total of all products "+subTotal);
//				 String[] subTotalParts = subTotal.split("\\$");
//				 double subTotalValue = Double.parseDouble(subTotalParts[1]);
//				  if (totalPrice==subTotalValue) {
//					  test.log(LogStatus.PASS, "Total price reflected in subtotal");
//					  System.out.println("Total price reflected in subtotal ");
//				}
//				  else {
//					  test.log(LogStatus.FAIL, "Total price not reflected to sub total");
//					  System.err.println("Total price not reflected to sub total");
//				}
//				*/
//			
//	}	
//	
//	}
//
