package com.providio.testcases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.paymentProccess.tc__CheckOutProcess;


public class tc__BundleProduct extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test( dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"}  )
	public void bundleProduct() throws InterruptedException {
		 
		 
	if(isLoggedIn) {
		 
			Random random = new Random();
			 
			//finding how many menus are present the website
		    List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
	        int count = countofMenus.size();

	        //iterating the all menus
	        for(int i = 1; i <= count; ++i) {
	            
	        	//finding how many sub menus are present in each menu
	            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
	            int countdropdown = noelementsofdrop.size();

	            //iterating the submenus and select one menu of sub menu
	            for(int j = 2; j <= countdropdown; ++j) {
	            	
	                Thread.sleep(5000);
	                
	                //select the one menu
	                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[contains(@class, 'nav-link') and contains(@class, 'dropdown-toggle')])[" + i + "]"));
	                String menuname = NavigationMenu.getText();

	                Thread.sleep(5000);
	                Actions action = new Actions(driver);
	                action.moveToElement(NavigationMenu).perform();
	                Thread.sleep(5000);
	                
//	                ScrollBarfuctions sf = new ScrollBarfuctions();
//	                
//	                sf.scrolldownfull(driver);
	                
	                
	                //log for reports
	                test.pass ("Successfully Howered on the" + menuname + " ");
	                
	                logger.info("Menu name " + menuname);
	                
	                //select menus of sub menu
	                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + j + "]"));
	                String submenuName = NavigationMenuitem.getText();
	                
	                JavascriptExecutor js = (JavascriptExecutor)driver;
	                js.executeScript("arguments[0].click();", NavigationMenuitem);

	                Thread.sleep(5000L);

	                logger.info("Sub menu name  " + submenuName);
	                
	                test.pass( "Successfully clicked on the" + submenuName + " of " + menuname + "");

	                //Select a random product	

                	//Random random = new Random();
	    	        List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));	    	        
	    	        int totalProductcount = products.size();	    	        
	    	        int randomselectProduct = random.nextInt(totalProductcount) + 1;

	    	        WebElement RandomSelectProductFormPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])"+"  "+"[" + randomselectProduct + "]"));
	    	       // String productName = RandomSelectProductFormPLP.getText();
	    	        //logger.info(productName);
	    	        js.executeScript("arguments[0].click();",  RandomSelectProductFormPLP);
	    	        
	    	        
	    	        //logger.info(productName);
	    	        Thread.sleep(5000);
	    	        
	    	        
		    	    //finding the size elements of the page
	    	        List<WebElement> sizeElementcount = driver.findElements(By.xpath("//select[@class='custom-select form-control select-size']"));
	    	        System.out.println(sizeElementcount.size());
	    	        
	    	        
	    	        List<WebElement> addalltocart = driver.findElements(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));
	    	        System.out.println(addalltocart.size());
	    	        
	    	        
	    	        //validating the size element is there or not  
	    	        if(sizeElementcount.size() == 0 && addalltocart.size() > 0 ) {
	    	        	
	    	        	
	    	        	System.out.println("Excuting the if condition");
	    	        	
	    				WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));
	    				
	    				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAllToCartElement);
	    				
	    				Thread.sleep(5000);
	    				
	    				
	    				
	    				js.executeScript("arguments[0].click();", addAllToCartElement);
	    	        	
	    	        }
	    	        else {
	    	        	System.out.println("We are excuting only bundle product not all the products");
	    	        }

	    	        Thread.sleep(5000);
	    	      
		    	        }
	            }
	        //checkoutProcess
	        
         tc__CheckOutProcess cp = new tc__CheckOutProcess();
         
         cp.checkoutprocess();	        }
	        
	  else {
	        Assert.fail("User not logged in");
	    }
	 }
}

