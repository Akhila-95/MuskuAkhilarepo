package com.providio.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SizeSelectionInQuickShop {

	
	public void sizeSelectionInQuickShop(WebDriver driver) throws InterruptedException {


		    //finding the size elements of the page
	       List<WebElement> sizeElementcount = driver.findElements(By.xpath("//select[@class='custom-select form-control select-size']"));
	       System.out.println(sizeElementcount.size());
	       
	       List<WebElement> widthElementcount = driver.findElements(By.xpath("//select[@class='custom-select form-control select-width']"));
	       System.out.println(widthElementcount.size());
	        
	       List<WebElement> sizeElementcountofGloves = driver.findElements(By.xpath("//select[@class='custom-select form-control select-accessorySize']"));
	       System.out.println(sizeElementcountofGloves.size());
	        
	       List<WebElement> memorySize = driver.findElements(By.xpath("//select[@id='memorySize-null']"));
	       System.out.println(memorySize.size());
	       
	       if(sizeElementcount.size()>0&&widthElementcount.size()>0) {
	    	   
	    	   //size
 			 WebElement sizeElement = driver.findElement(By.xpath("//select[@class='custom-select form-control select-size']"));
 			 System.out.println("Size element is present on the page.");	  
			 Select sizeSelect = new Select(sizeElement);
		     List<WebElement> options = sizeSelect.getOptions();
 			 List<String> enabledSizes = new ArrayList<>();
 			 int optionIndex = 0;
 			 System.out.println(options.size());
 			 
 			 for (WebElement option : options) {
 				 
 			    if (optionIndex > 0 && option.isEnabled()) {
 			    		String text = option.getText();

 			            if (!text.isEmpty()) {      	
 			            	String value = option.getAttribute("data-attr-value");
 			                enabledSizes.add(value);
 			                //System.out.println(value);
 			                option.click();
 			                break; 
 			                // Select the first enabled size and exit the loop
 			            }
 			        }else {
 			    		System.out.println("This size is not avaliable");
 			    	}
 			    	
 			    	 optionIndex++;
 			  }
 			    
		  //width 
		   WebElement widthElement = driver.findElement(By.xpath("//select[@class='custom-select form-control select-width']"));
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
	    	   System.out.println("1");
	    	   
	    	   
	       }else if(sizeElementcount.size()>0) {
	    	   
	    	   //size
	 			 WebElement sizeElement = driver.findElement(By.xpath("//select[@class='custom-select form-control select-size']"));
	 			 System.out.println("Size element is present on the page.");	  
				 Select sizeSelect = new Select(sizeElement);
			     List<WebElement> options = sizeSelect.getOptions();
	 			 List<String> enabledSizes = new ArrayList<>();
	 			 int optionIndex = 0;
	 			 System.out.println(options.size());
	 			 
	 			 for (WebElement option : options) {
	 				 
	 			    if (optionIndex > 0 && option.isEnabled()) {
	 			    		String text = option.getText();

	 			            if (!text.isEmpty()) {      	
	 			            	String value = option.getAttribute("data-attr-value");
	 			                enabledSizes.add(value);
	 			                //System.out.println(value);
	 			                option.click();
	 			                break; 
	 			                // Select the first enabled size and exit the loop
	 			            }
	 			        }else {
	 			    		System.out.println("This size is not avaliable");
	 			    	}
	 			    	
	 			    	 optionIndex++;
	 			  }
	    	   
	    	   System.out.println("2");
	       }else if(sizeElementcountofGloves.size()>0) {
	    	   
	    	   //size
	 			 WebElement sizeElement = driver.findElement(By.xpath("//select[@class='custom-select form-control select-accessorySize']"));
	 			 System.out.println("Size element is present on the page.");	  
				 Select sizeSelect = new Select(sizeElement);
			     List<WebElement> options = sizeSelect.getOptions();
	 			 List<String> enabledSizes = new ArrayList<>();
	 			 int optionIndex = 0;
	 			 System.out.println(options.size());
	 			 
	 			 for (WebElement option : options) {
	 				 
	 			    if (optionIndex > 0 && option.isEnabled()) {
	 			    		String text = option.getText();

	 			            if (!text.isEmpty()) {      	
	 			            	String value = option.getAttribute("data-attr-value");
	 			                enabledSizes.add(value);
	 			                //System.out.println(value);
	 			                option.click();
	 			                break; 
	 			                // Select the first enabled size and exit the loop
	 			            }
	 			        }else {
	 			    		System.out.println("This size is not avaliable");
	 			    	}
	 			    	
	 			    	 optionIndex++;
	 			  }
	    	   
	    	   System.out.println("3");
	       }else {
	    	   
	    	   //size
	 			 WebElement sizeElement = driver.findElement(By.xpath("//select[@id='memorySize-null']"));
	 			 System.out.println("Size element is present on the page.");	  
				 Select sizeSelect = new Select(sizeElement);
			     List<WebElement> options = sizeSelect.getOptions();
	 			 List<String> enabledSizes = new ArrayList<>();
	 			 int optionIndex = 0;
	 			 System.out.println(options.size());
	 			 
	 			 for (WebElement option : options) {
	 				 
	 			    if (optionIndex > 0 && option.isEnabled()) {
	 			    		String text = option.getText();

	 			            if (!text.isEmpty()) {      	
	 			            	String value = option.getAttribute("data-attr-value");
	 			                enabledSizes.add(value);
	 			                //System.out.println(value);
	 			                option.click();
	 			                break; 
	 			                // Select the first enabled size and exit the loop
	 			            }
	 			        }else {
	 			    		System.out.println("This size is not avaliable");
	 			    	}
	 			    	
	 			    	 optionIndex++;
	 			  }
	    	   System.out.println("4");
	       }
	       
	       
	       
	       

	   }
            
}

