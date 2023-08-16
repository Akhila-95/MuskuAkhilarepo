package com.providio.commonfunctionality;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.providio.testcases.baseClass;

public class sizeElementandSelection extends baseClass{
	
	public void sizeelement() {

        //Find the parent div element that contains size and width elements
        WebElement parentDiv = driver.findElement(By.xpath("(//div[@class ='attributes px-0'])"));

        //Verify the presence of size and width elements within the parent div
	       List<WebElement> sizeElements = parentDiv.findElements(By.xpath(".//select[@class='custom-select form-control select-size']"));
	       System.out.println(sizeElements.size());
	       List<WebElement> widthElements = parentDiv.findElements(By.xpath(".//select[@id='width-null']"));
	       System.out.println(widthElements.size());
		
	       
	    //action
	       
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
	}

}
