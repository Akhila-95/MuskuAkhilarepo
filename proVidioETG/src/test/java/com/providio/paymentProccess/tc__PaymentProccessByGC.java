package com.providio.paymentProccess;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.providio.Validations.Checkout_Validation;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.testcases.baseClass;

public class tc__PaymentProccessByGC extends baseClass{

	public List<String> readDataFromExcel(String filePath, String sheetName) throws IOException {

		List<String> data = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		boolean isFirstRow = true; // Flag to skip the first row

	    for (Row row : sheet) {
	        // Skip the first row
	        if (isFirstRow) {
	            isFirstRow = false;
	            continue;
	        }

	        for (Cell cell : row) {
	            String stringValue = cell.toString();
	            data.add(stringValue);
	        }
	    }

		workbook.close();
		return data;
	}
// to pick the GC code randomly
	public void performRandomOperations(WebDriver driver) throws InterruptedException {
		//driver.get(baseURL);
		//logger.info("enterd into url");
		String filePath = "C:\\Users\\user\\eclipse-workspace\\Providio_25th\\AutomationsScripts-Etg-by-upendra-main\\proVidioETG_25th\\testDate\\GiftCertificateCodes.xlsx";
		String sheetName = "GC_Codes";

		try {
				List<String> dataList = readDataFromExcel(filePath, sheetName);
				int totalProducts = dataList.size();
				// Remove spaces from each element in the dataList
			    for (int i = 0; i < dataList.size(); i++) {
			        String element = dataList.get(i);
			        element = element.replace(" ", "");
			        dataList.set(i, element);
			    }
	
			    // Print the updated dataList
			 
				logger.info(dataList);
				int operations = 0;
				   Set<String> pickedValues = new HashSet<>();

				   while (true) {
						 String randomValue = pickRandomValueWithoutDuplicate(dataList, pickedValues);
			                logger.info(randomValue);
						if (randomValue == null) {
							logger.info("No data found");
							break; // No more values to pick
						}
						if (randomValue != null) {
							
						JavascriptExecutor js = (JavascriptExecutor) driver;				
						WebElement giftcertificate = driver.findElement(By.xpath("//input[@id='giftCert']"));
						js.executeScript("arguments[0].click();", giftcertificate);	
						giftcertificate.sendKeys(randomValue);
						Thread.sleep(2000);
							
							  
		            //check balance validation and checking the bal of GC
		             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
		             test.info("Verifying check balance button");
		            
		                // Scroll down by 500 pixels
		             js.executeScript("window.scrollBy(0, 500);");                 
		                js.executeScript("arguments[0].click();",checkBalButton);
		                //checkBalButton.click();
		                Thread.sleep(2000);
		                WebElement checkBal= driver.findElement(By.xpath("//div[@class='balance success']"));
		                logger.info(checkBal.getText()); 
			                if(checkBalButton.isDisplayed()) {
			                	
		                	test.pass("Check button is enabled and selected");
			                	logger.info("Check button is enabled and selected");
			                }else {
			                	test.fail("Check button is not enabled and not selected");
			                	logger.info("Check button is  not enabled and selected");
			                }
		                
		            // Click the apply button by passing GC
		            try {
		            	Thread.sleep(2000);
		            	js.executeScript("arguments[0].click();", giftcertificate);	
						giftcertificate.sendKeys(randomValue);
			            Thread.sleep(2000);
			            
		                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
		                Thread.sleep(3000);	              
		                // Scroll down by 500 pixels
		                js.executeScript("window.scrollBy(0, 500);");  
		             
		                // apply button validation
		                test.info("Verifying apply button is selected");
		                if(applyGiftCard.isDisplayed()) {
		                	    js.executeScript("arguments[0].click();", applyGiftCard);
		                	    test.pass("Apply button is selected");
		                	    logger.info("Apply button is selected");
		              
				                Thread.sleep(2000);
									if(driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size()!=0) {
										logger.info("Insufficent funds in this " +randomValue + " gift card" );
										giftcertificate.clear();
									}else if(driver.findElements(By.xpath("//div[contains(text(),'Gift card belongs to a different customer')]")).size()!=0){
										logger.info("This " + randomValue + "Gift Card belongs to different customer ");
										giftcertificate.clear();
									}
									
							        if (driver.findElements(By.xpath("//div[contains(text(),'Your order has no balance, so no payment method is necessary to complete this order')]")).size()!=0) {
								    	 logger.info("Your order has no balance,so no payment method is necessary");
								    	 giftcertificate.clear();
								    	 break;
							        } else {
								        	
							        	dataList.remove(randomValue);
										logger.info(" After applying GC we have this in datalist"+ dataList);
								    	    Thread.sleep(5000);
											operations++;	
									     }
								 
							
								}
		                 } catch (NoSuchElementException e) {
					  				logger.info("Element not found: " + e.getMessage());
								}  
						}			
			  }
					logger.info("Total data: " + totalProducts);
					logger.info("Total operations performed: " + operations);
		  }catch (IOException e) {
		
				e.printStackTrace();
	   }	
		   if (driver.findElements(By.xpath("//div[contains(text(),'Your order has no balance, so no payment method is necessary to complete this order')]")).size() != 0) {
				 //revieworder button  
			    paymentpPage pp = new paymentpPage(driver);
			    pp.clickonrevieworder(driver);
				logger.info("clicked on the review oreder");
				
			  //review order page
		        reviewOrderPage rop = new reviewOrderPage(driver);
				Thread.sleep(10000);
			
				rop.clickonplaceorderwithJsExuter(driver);
				logger.info("successfully click on the place order button");
				Thread.sleep(10000);
				logger.info(driver.getTitle());
			
				 Checkout_Validation checkout= new Checkout_Validation();
			 //validate the final place the order page
				 checkout.validatePlacetheOrderPage();
			
		     //ordernumberandOrderdate
				 checkout.ordernumberandOrderdat();
		   }
	}
	private String pickRandomValueWithoutDuplicate(List<String> dataList, Set<String> pickedValues) {
        Random random = new Random();
        int index = random.nextInt(dataList.size());

        String randomValue = dataList.get(index);
        if (pickedValues.contains(randomValue)) {
            // All values have been picked, return null
            if (pickedValues.size() == dataList.size()) {
                return null;
            }
            // Recursively pick another value
            return pickRandomValueWithoutDuplicate(dataList, pickedValues);
        } else {
            // Add the picked value to the set
            pickedValues.add(randomValue);
            return randomValue;
        }
    }

	// to pick the GC code sequentially
	
	public void performSequentialOperations(WebDriver driver) throws InterruptedException {
	    String filePath = "C:\\Users\\user\\git\\MuskuAkhilaRepo16\\proVidioETG\\testDate\\GiftCertificateCodes.xlsx";
	    String sheetName = "GC_Codes";

	    try {
	        List<String> dataList = readDataFromExcel(filePath, sheetName);
	        int totalProducts = dataList.size();
	        
	     // Remove spaces from each element in the dataList
		    for (int i = 0; i < dataList.size(); i++) {
		        String element = dataList.get(i);
		        element = element.replace(" ", "");
		        dataList.set(i, element);
		    }

		    // Print the updated dataList
		 
			logger.info(dataList);
	        int operations = 0;
	      	 Iterator<String> iterator = dataList.iterator();
	      	 
	      	WebElement checkoutPage2= driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));
	      	 if(checkoutPage2.isDisplayed()) {
		        while (iterator.hasNext()) {
		            String value = iterator.next();
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            WebElement giftCertificate = driver.findElement(By.xpath("//input[@id='giftCert']"));
		            js.executeScript("arguments[0].click();", giftCertificate);
		            giftCertificate.sendKeys(value);
		            Thread.sleep(2000);

		            
			            //check balance validation and checking the bal of GC
			             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
			             test.info("Verifying check balance button");
			           
		                // Scroll down by 500 pixels
			             js.executeScript("window.scrollBy(0, 500);");                 
		                js.executeScript("arguments[0].click();",checkBalButton);
		                //checkBalButton.click();
		                Thread.sleep(2000);
		                WebElement checkBal= driver.findElement(By.xpath("//div[@class='balance success']"));
		                logger.info(checkBal.getText()); 
			                if(checkBalButton.isDisplayed()) {
			                	
			                	test.pass("Check button is enabled and selected ");
			                	logger.info("Check button is enabled and selected");
			                }else {
			                	test.fail("Check button is not enabled and not selected");
			                	logger.info("Check button is  not enabled and selected");
			                }
		                
		            // Click the apply button by passing GC
		            try {
		            	Thread.sleep(2000);
		            	js.executeScript("arguments[0].click();", giftCertificate);
			            giftCertificate.sendKeys(value);
			            Thread.sleep(2000);
			            
		                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
		                Thread.sleep(3000);	              
		                // Scroll down by 500 pixels
		                js.executeScript("window.scrollBy(0, 200);");  
		             
		                // apply button validation
		                test.info("Verifying apply button is selected");
		                if(applyGiftCard.isDisplayed()) {
		                	    js.executeScript("arguments[0].click();", applyGiftCard);
		                	    test.pass("Apply button is selected");
		                	    logger.info("Apply button is selected");
		              
				                Thread.sleep(2000);
				                if (driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size() != 0) {
				                    logger.info("Insufficient funds in this " + value + " gift card");
				                    giftCertificate.clear();
				                } else if (driver.findElements(By.xpath("//div[contains(text(),'Gift card belongs to a different customer')]")).size() != 0) {
				                    logger.info("This " + value + " Gift Card belongs to a different customer");
				                    giftCertificate.clear();
				                }
			
				                if (driver.findElements(By.xpath("//div[contains(text(),'Your order has no balance, so no payment method is necessary to complete this order')]")).size() != 0) {
				                    logger.info("Your order has no balance, so no payment method is necessary");
				                    giftCertificate.clear();
				                    break;
				                } else {
				                    iterator.remove(); // Safely remove the element from the list
				                    logger.info("After applying GC we have this in datalist: " + dataList);
				                    Thread.sleep(5000);
				                    operations++;
				                }
	           
		                }else {
		                	test.fail("Apply button is not  selected");
		                	logger.info("Apply button is not selected");
		                }
		             
		                
		            } catch (NoSuchElementException e) {
		                logger.info("Element not found: " + e.getMessage());
		            }
	        }
	     }      
	        logger.info("Total data: " + totalProducts);
	        logger.info("Total operations performed: " + operations);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	 //revieworder button  
	    Thread.sleep(4000);
	    if (driver.findElements(By.xpath("//div[contains(text(),'Your order has no balance, so no payment method is necessary to complete this order')]")).size() != 0) {
			 //revieworder button  
		    paymentpPage pp = new paymentpPage(driver);
		    pp.clickonrevieworder(driver);
			logger.info("clicked on the review oreder");
			
		  //review order page
	        reviewOrderPage rop = new reviewOrderPage(driver);
			Thread.sleep(10000);
		
			rop.clickonplaceorderwithJsExuter(driver);
			logger.info("successfully click on the place order button");
			Thread.sleep(10000);
			logger.info(driver.getTitle());
		
			 Checkout_Validation checkout= new Checkout_Validation();
		 //validate the final place the order page
			 checkout.validatePlacetheOrderPage();
		
	     //ordernumberandOrderdate
			 checkout.ordernumberandOrderdat();
	   }else {
		   test.pass("No sufficient balance in Gift certificate");
	   }
	}
	
	//TO PLACE THE ORDER BY GC AND CC
		public void paymentBySemiGC () throws InterruptedException {
			double halfPrice1=0;
            List<WebElement> gcText= driver.findElements(By.xpath("//div[@class='success giftcert-pi']"));
            int sizeOfGc = gcText.size();
            WebElement totalSum= driver.findElement(By.xpath("//span[@class='grand-total-sum']"));
            String text = totalSum.getText();
            double  totalPrice = Double.parseDouble(text.replace("$", ""));     
            
         // Calculate half of the total price
            System.out.println("Total price is " + totalPrice);
            for(int i=1;i<=1;i++) {
                halfPrice1 = totalPrice / 2;
                 System.out.println("The half price is " +halfPrice1);
            }
			String filePath = "C:\\Users\\user\\git\\MuskuAkhilaRepo16\\proVidioETG\\testDate\\GiftCertificateCodes.xlsx";
		    String sheetName = "GC_Codes";

		    try {
		        List<String> dataList = readDataFromExcel(filePath, sheetName);
		        int totalProducts = dataList.size();
		        
		     // Remove spaces from each element in the dataList
			    for (int i = 0; i < dataList.size(); i++) {
			        String element = dataList.get(i);
			        element = element.replace(" ", "");
			        dataList.set(i, element);
			    }

			    // Remove the empty strings from the list
		        dataList.removeIf(String::isEmpty);

		        // Concatenate the elements of the list without the comma
		      
				logger.info(dataList);
		        int operations = 0;
		      	 Iterator<String> iterator = dataList.iterator();
		      	 
		        while (iterator.hasNext()) {

	                
		            String value = iterator.next();
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            WebElement giftCertificate = driver.findElement(By.id("giftCert"));
		            js.executeScript("arguments[0].click();", giftCertificate);
		            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",giftCertificate);
		            giftCertificate.sendKeys(value);
		            Thread.sleep(2000);

		            
		            //check balance validation and checking the bal of GC
		             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
		             test.info("Verifying check balance button");
		            
		                // Scroll down by 500 pixels
		             	js.executeScript("window.scrollBy(0, 500);");         
		                js.executeScript("arguments[0].click();",checkBalButton);
		                //checkBalButton.click();
		                Thread.sleep(2000);
		                WebElement checkBal= driver.findElement(By.xpath("//div[@class='balance success']"));
		                logger.info(checkBal.getText()); 
		                if(checkBalButton.isDisplayed()) {
		                	
	                	test.pass("Check button is enabled and selected");
		                	logger.info("Check button is enabled and selected");
		                }else {
		                	test.fail("Check button is not enabled and not selected");
		                	logger.info("Check button is  not enabled and selected");
		                }
		                
		            // Click the apply button by passing GC
		            try {
		            	Thread.sleep(2000);
		            	js.executeScript("arguments[0].click();", giftCertificate);
			            giftCertificate.sendKeys(value);
			            Thread.sleep(2000);
			            
		                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
		                Thread.sleep(3000);	              
		                // Scroll down by 500 pixels
		                js.executeScript("window.scrollBy(0, 200);");
		             
		                // apply button validation
		                test.info("Verifying apply button is selected");
		                if(applyGiftCard.isDisplayed()) {
		                	    js.executeScript("arguments[0].click();", applyGiftCard);
		                	    test.pass("Apply button is selected");
		                	    logger.info("Apply button is selected");
		              
				                Thread.sleep(2000);
				                if (driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size() != 0) {
				                	logger.info("Insufficient funds in this " + value + " gift card");
				                    giftCertificate.clear();
				                } else if (driver.findElements(By.xpath("//div[contains(text(),'Gift card belongs to a different customer')]")).size() != 0) {
				                	logger.info("This " + value + " Gift Card belongs to a different customer");
				                    giftCertificate.clear();
				                }
		
				          
			               // if(sizeOfGc>0) {
				                
			                //price after code redeemtion
				                WebElement halfTotal= driver.findElement(By.xpath("//span[@class='gift-certificate-total']"));
				                String text1 = halfTotal.getText();
				                double halfTotal1 = Double.parseDouble(text1.replace("$", ""));     
				                System.out.println("Price after redeemtion "+halfTotal1);
	
				           
				                if(halfPrice1==halfTotal1) {
				                    logger.info("Gift certificate codes are applied");
				                    test.info("Gift certificate codes are applied");
				                   // giftCertificate.clear();
				                    break;
				                } else {
				                    iterator.remove(); // Safely remove the element from the list
				                    logger.info("After applying GC we have this in datalist: " + dataList);
				                    Thread.sleep(5000);
				                    operations++;				                    
			                  }
			              //  }
	           
		                }else {
		                	test.fail("Apply button is not  selected");
		                	logger.info("Apply button is not selected");
		                }
		             
		                
		            } catch (NoSuchElementException e) {
		                logger.info("Element not found: " + e.getMessage());
		            }
		        }

		        logger.info("Total data: " + totalProducts);
		        logger.info("Total operations performed: " + operations);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

}
