//package com.providio.pageObjects;
//
//import java.util.Iterator;
//import java.util.List;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.github.dockerjava.api.model.Driver;
//
//public class myOrdersPage {
//
//	WebDriver lDriver;
//	public myOrdersPage(WebDriver rDriver ){
//			
//			lDriver=rDriver;
//			PageFactory.initElements(rDriver, this);
//	}
//	
//	//to track the order numbers
//	
//	
//	
//	public void trackOrderDetails(WebDriver driver) throws InterruptedException {
//		
//		List <WebElement>  orderNumbers=driver.findElements(By.xpath("//h3[@class='pull-left']"));
//		int totalNumberOfOrders= orderNumbers.size();
//		System.out.println("The total number of orders placed are " +totalNumberOfOrders);
//		for(int i=1;i<=totalNumberOfOrders;i++) {
//			
//			WebElement orderNumber=driver.findElement(By.xpath("(//h3[@class='pull-left'])["+i+"]"));
//			String textOforderNumber =orderNumber.getText();
//			System.out.println("Order Number is " +textOforderNumber);
//			WebElement viewDetailsElement=driver.findElement(By.xpath("//a[@class='pull-right']"));
//			viewDetailsElement.click();
//			Thread.sleep(2000);
//			
//			WebElement orderDatElement=driver.findElement(By.xpath("//span[@class='summary-details order-date']"));
//			String textOfOrderDatElement =orderDatElement.getText();
//			System.out.println(" The date of order placed" +textOfOrderDatElement);
//			
//			WebElement shippingDetailsElement=driver.findElement(By.xpath("//div[@class='single-shipping']"));
//			String textOfShippingDetailsElement =shippingDetailsElement.getText();
//			System.out.println("shipping address : " +textOfShippingDetailsElement);
//			
//			WebElement billingDetailsElement =driver.findElement(By.xpath("//div[@class='summary-details billing']"));
//			String textOfBillingDetailsElement =billingDetailsElement.getText();
//			System.out.println("Billing Address is : "+textOfBillingDetailsElement);
//			
//			WebElement paymentDetailsElement=driver.findElement(By.xpath("//div[@class='payment-details']"));
//			String textOfPaymentDetailsElement =paymentDetailsElement.getText();
//			System.out.println("payment details is : " +textOfPaymentDetailsElement);
//			
//			
//			//to check total price
//			viewCartPage viewCartPage =new viewCartPage(driver);
//			viewCartPage.totalPrice(driver);
//			System.out.println("Captured total price of all products");
//			viewCartPage.subTotal();
//			System.out.println("Captured sub total price of all products");
//			
//			
//			WebElement noOfItemsElement =driver.findElement(By.xpath("//span[@class='order-receipt-label grand-total-label']"));
//			String textOfNoOfItemsElement = noOfItemsElement.getText();
//			System.out.println("The total number of " +textOfNoOfItemsElement+ " items are placed ");
//			
//			WebElement subTotalElement=driver.findElement(By.xpath("//span[@class='sub-total']"));
//			String textOfsubTotalElement =subTotalElement.getText();
//			System.out.println("The sub Total price " +textOfsubTotalElement);
//			
//			WebElement grandTotaElement =driver.findElement(By.xpath("//span[@class='grand-total-sum']"));
//			String textOfgrandTotaElement =grandTotaElement.getText();
//			System.out.println("Grand total " + textOfgrandTotaElement);
//			
//			WebElement  backToOrderHistoryElement =driver.findElement(By.xpath("//a[@title='Back to My Account']"));
//			JavascriptExecutor js = (JavascriptExecutor) driver; 
//			js.executeScript("arguments[0].click();",  backToOrderHistoryElement);
//			Thread.sleep(5000);
//		}
//	}
//}
