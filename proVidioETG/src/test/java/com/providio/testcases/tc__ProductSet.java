package com.providio.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.loginPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.utilities.scrollBarfuctions;


public class tc__ProductSet extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test(
		        dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"}
		    )
	public void productSet() throws InterruptedException {
		 
		 
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
	                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
	                String menuname = NavigationMenu.getText();

	                Thread.sleep(5000);
	                Actions action = new Actions(driver);
	                action.moveToElement(NavigationMenu).perform();
	                Thread.sleep(5000L);
	                
	                scrollBarfuctions sf = new scrollBarfuctions();
	                
	                sf.scrolldownfull(driver);
	                
	                
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
	    	        
	    	        
	    	        //validating the size element is there or not  
	    	        if(sizeElementcount.size()>1) {
	    	    	   
	    	    	     //iterating the size elements more than one
	    	    	     for(int p = 1; p <= sizeElementcount.size(); p++) {
		    	        	
		    	        	  logger.info("Excuting");

		    	               //Find the parent div element that contains size and width elements
		    	               WebElement parentDiv = driver.findElement(By.xpath("(//div[@class ='attributes px-0'])["+p+"]"));

		    	               //Verify the presence of size and width elements within the parent div
				    	       List<WebElement> sizeElements = parentDiv.findElements(By.xpath(".//select[@class='custom-select form-control select-size']"));
				    	       System.out.println(sizeElements.size());
				    	       List<WebElement> widthElements = parentDiv.findElements(By.xpath(".//select[@id='width-null']"));
				    	       System.out.println(widthElements.size());
	
		    	               // Both size and width elements are present within the parent div
			    	           if (!sizeElements.isEmpty() && !widthElements.isEmpty()) {

			    	        	      //size
				        			  WebElement sizeElement = sizeElements.get(0);
				        			  System.out.println("Size element is present on the page.");
				        			  
				        				Select sizeSelect = new Select(sizeElement);
				        			    List<WebElement> options = sizeSelect.getOptions();
				        			    
				        			    List<String> enabledSizes = new ArrayList<>();
				        			    
				        			    int optionIndex = 0;
				        			    
				        			    System.out.println(options.size());

				        			    for (WebElement option : options) {

				        			    	if (optionIndex > 0 && option.isEnabled()) {
				        			    		
				        			    		String text = option.getText();
				        			    		  //System.out.println(text);

				        			            if (!text.isEmpty()) {      	
				        			            	String value = option.getAttribute("data-attr-value");
				        			                enabledSizes.add(value);
				        			                //System.out.println(value);
				        			                option.click();
				        			                break; 
				        			                // Select the first enabled size and exit the loop
				        			            }
				        			        }
				        			    	else {
				        			    		System.out.println("This size is not avaliable");
				        			    	}
				        			    	
				        			    	 optionIndex++;
				        			  
				        			    }
				        			    
				        			  //width 
				        			  WebElement widthElement = widthElements.get(0);
				        			  System.out.println("width element is present on the page.");
				        			  
				        				Select widthSelect = new Select(widthElement);
				        				
				        				// Get the list of available options
				        			  List<WebElement> availableOptionsofwidth = widthSelect.getOptions();
				        			
				        			  // Create a list to store the indices of enabled options
				        			  List<Integer> enabledIndixes = new ArrayList<>();
				        			
				        			  // Iterate through the available options and store the indices of enabled options
				        			  for (int a = 0; a < availableOptionsofwidth.size(); a++) {
				        			  	
				        			      if (availableOptionsofwidth.get(a).isEnabled()) {
				        			      	enabledIndixes.add(a);
				        			      }
				        			  }
				        			  Integer randomIndexofwidth = enabledIndixes.set(1, 1);
				        			  //logger.info(enabledIndixes);
				        			  System.out.println("total numbers of"+enabledIndixes);

				        			  System.out.println("only width"+enabledIndixes);
				        			  // Select the option at the random index
				        			  widthSelect.selectByIndex(randomIndexofwidth); 
				        			
				        			  Thread.sleep(3000);

					    	    	   String elementXPath = "//div[contains(text(), 'In Stock')]";
					    	    		List<WebElement> Stocksize = driver.findElements(By.xpath(elementXPath));

					    	    	    // Check if the element is present
					    	    	    if (Stocksize.size() > 0) {
					    	    	        System.out.println("The element is present on the PDP.");
					    	    	        // Additional actions when the element is present

    	    					    			WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));
    	    					    			
    	    					    			js.executeScript("arguments[0].click();", addAllToCartElement);
    	    					    			
    	    					    			System.out.println("products added to cart");
					    	    				       
					    	    	    } else {
					    	    	    	
					    	    	        System.out.println("This item is currently not available");
					    	    	        // Additional actions when the element is not present
					    	    	    }
			        		        

			    	         } else if(!sizeElements.isEmpty()){
			    	        	System.out.println("coming");

			    	             // Either size or width element is missing within the parent div

		    	        	       //size
		    	        		    WebElement sizeElement = sizeElements.get(0);
		    	        		    //System.out.println("Size element is present on the page."+sizeElement);
		    	        		    
		    	        		    Select sizeSelect = new Select(sizeElement);
			        			    List<WebElement> options = sizeSelect.getOptions();
			        			    
			        			    List<String> enabledSizes = new ArrayList<>();
			        			    
			        			    int optionIndex = 0;
			        			    
			        			    System.out.println(options.size());

			        			    for (WebElement option : options) {

			        			    	if (optionIndex > 0 && option.isEnabled()) {
			        			    		
			        			    		String text = option.getText();
			        			    		  //System.out.println(text);

			        			            if (!text.isEmpty()) {      	
			        			            	String value = option.getAttribute("data-attr-value");
			        			                enabledSizes.add(value);
			        			                //System.out.println(value);
			        			                option.click();
			        			                break; 
			        			                // Select the first enabled size and exit the loop
			        			            }
			        			        }
			        			    	else {
			        			    		System.out.println("This size is not avaliable");
			        			    	}
			        			    	
			        			    	 optionIndex++;
			        			  
			        			    }

		    	        		    Thread.sleep(3000);
		    	        		    
		    		    	    	   String elementXPath = "//div[contains(text(), 'In Stock')]";
		    		    	    		List<WebElement> Stocksize = driver.findElements(By.xpath(elementXPath));

		    		    	    	    // Check if the element is present
		    		    	    	    if (Stocksize.size() > 0) {
		    		    	    	        System.out.println("The element is present on the PDP.");
		    		    	    	        // Additional actions when the element is present
			
	    					    			WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));
	    					    			
	    					    			js.executeScript("arguments[0].click();", addAllToCartElement);
		    		    	    					    			
		    		    	    					    
		    		    	    	    } else {
		    		    	    	        System.out.println("This item is currently not available");
		    		    	    	        // Additional actions when the element is not present
		    		    	    	    }

			    	         }
			    	           
			    	      }
	    	    	   
	    	       }else {
	    	    	   
	    	    	   System.out.println("currently we are excuting only product sets not all products");
	    	    	      	   
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

