package com.providio.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SizeSelectionForProductSet {

	public void sizeSelection(WebDriver driver) throws InterruptedException {
		  JavascriptExecutor js = (JavascriptExecutor)driver;
	    //finding the size elements of the page
        List<WebElement> sizeElementcount = driver.findElements(By.xpath("//select[@class='custom-select form-control select-size']"));
        System.out.println(sizeElementcount.size());
        
        
        //validating the size element is there or not  
        if(sizeElementcount.size()>1) {
    	   
    	     //iterating the size elements more than one
    	     for(int p = 1; p <= sizeElementcount.size(); p++) {
	        	
	        	 // logger.info("Excuting");

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
	}
	}
}
