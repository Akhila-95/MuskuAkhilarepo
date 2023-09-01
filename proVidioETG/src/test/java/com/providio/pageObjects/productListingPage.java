package com.providio.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productListingPage {
WebDriver lDriver;


	public productListingPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	 
	  //color
	  //beige
		@FindBy(xpath ="//span[@id ='swatch-circle-beige-assistive']")
		WebElement colorBeige;
		public void selectthecolorBeige(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
	        js.executeScript("arguments[0].click();", colorBeige);
			//colorBeige.click();
	    	Thread.sleep(3000);
		}
		//black
		@FindBy(xpath ="//span[@id ='swatch-circle-black-assistive']")
		WebElement colorblack;
		public void selectthecolorBlack(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
	        js.executeScript("arguments[0].click();", colorblack);
	    	Thread.sleep(3000);
		}
		//blue
		@FindBy(xpath ="//span[@id ='swatch-circle-blue-assistive']")
		WebElement colorblue;
		public void selectthecolorBlue(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colorblue);
	    	Thread.sleep(3000);
		}
		//navy
		@FindBy(xpath ="//span[@id ='swatch-circle-navy-assistive']")
		WebElement colornavy;
		public void selectthecolorBavy(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colornavy);
	    	Thread.sleep(3000);
		}
		//brown
		@FindBy(xpath ="//span[@id ='swatch-circle-brown-assistive']")
		WebElement colorbrown;
		public void selectthecolorbrown(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colorbrown);
	    	Thread.sleep(3000);
		}
		//green
		@FindBy(xpath ="//span[@id ='swatch-circle-green-assistive']")
		WebElement colorgreen;
		public void selectthecolorgreen(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colorgreen);
	    	Thread.sleep(3000);
		}
		//grey
		@FindBy(xpath ="//span[@id ='swatch-circle-grey-assistive']")
		WebElement colorgrey;
		public void selectthecolorgrey(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colorgrey);
	    	Thread.sleep(3000);
		}
		//orange
		@FindBy(xpath ="//span[@id ='swatch-circle-orange-assistive']")
		WebElement colororange;
		public void selectthecolororange(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colororange);

	    	Thread.sleep(3000);
		}
		//orange
		@FindBy(xpath ="//span[@id ='swatch-circle-pink-assistive']")
		WebElement colorpink;
		public void selectthecolorpink(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colorpink);
	    	Thread.sleep(3000);
		}
		//purple
		@FindBy(xpath ="//span[@id ='swatch-circle-purple-assistive']")
		WebElement colorpurple;
		public void selectthecolorpurple(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colorpurple);
	    	Thread.sleep(3000);
		}
		//red
		@FindBy(xpath ="//span[@id ='swatch-circle-red-assistive']")
		WebElement colorred;
		public void selectthecolorred(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colorred);
	    	Thread.sleep(3000);
		}
		//white
		@FindBy(xpath ="//span[@id ='swatch-circle-white-assistive']")
		WebElement colorwhite;
		public void selectthecolorwhite(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colorwhite);
	    	Thread.sleep(3000);
		}
		//yellow
		@FindBy(xpath ="//span[@id ='swatch-circle-yellow-assistivee']")
		WebElement coloryellow;
		public void selectthecoloryellow(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", coloryellow);

	    	Thread.sleep(3000);
		}
		//miscellaneous
		@FindBy(xpath ="//span[@id ='swatch-circle-miscellaneous-assistive']")
		WebElement colormiscellaneous;
		public void selectthecolormiscellaneous(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", colorblack);
			colormiscellaneous.click();
	    	Thread.sleep(3000);
		}
		
		//newArrival
		@FindBy(xpath ="//span[@class = 'refinement-value ' and contains(text(), 'New Arrival')]")
		WebElement NewArrivals;
		public void selecttheNewArrivals() throws InterruptedException{
			NewArrivals.click();
	    	Thread.sleep(3000);
		}
		
		//Sizes
		@FindBy(xpath ="(//span[@class='size-btn'])[3]")
		WebElement sizes;
		public void selectthesizes(WebDriver driver) throws InterruptedException{
			
			Select sizeSelect = new Select(sizes);
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
//			JavascriptExecutor js = (JavascriptExecutor) driver; 
//	        js.executeScript("arguments[0].click();", sizes);
	    	Thread.sleep(3000);
		}
		
		//price1
		@FindBy(xpath ="//div[contains(@class,'refinement refinement-price mb-3')]")
		WebElement Price;
		public void selectthePrice(WebDriver driver) throws InterruptedException{
			
			List<WebElement> parentDiv= driver.findElements(By.xpath("//div[@class='refinement refinement-price mb-3']"));
			WebElement parentDiv1= driver.findElement(By.xpath("//div[@class='refinement refinement-price mb-3']"));
			if(parentDiv.size()>0) {
				
				//WebElement parentDiv1= driver.findElement(By.xpath("//div[@class='refinement refinement-price mb-3']"));

					List<WebElement> priceElement =  parentDiv1.findElements(By.xpath("//div[@id='refinement-price']//li"));
					 	Random random = new Random();
					    int randomIndex = random.nextInt(priceElement.size());
					    Thread.sleep(7000);
					    // Get the WebElement corresponding to the random index and click it
					    WebElement randomPriceElement = priceElement.get(randomIndex);
					   
					    JavascriptExecutor js = (JavascriptExecutor) driver;
					    System.out.println(randomPriceElement.getText());
					   
					    //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomPriceElement);
					    js.executeScript("arguments[0].click();", randomPriceElement);
					   
					    randomPriceElement.click();
					    randomPriceElement.click();
					    Thread.sleep(3000);					    
			}else {
				System.out.println("No price filter in PLP");
				
			}
	
		}
		
		//color
		@FindBy(xpath ="//div[@class='refinement refinement-color mb-3']")
		WebElement color;
		public void selecttheColor(WebDriver driver) throws InterruptedException{
			
				List<WebElement> colorElement = driver.findElements(By.xpath("//li[@class='color-attribute ']"));
				if (!colorElement.isEmpty()) {
		            Random random = new Random();
		            int randomIndex = random.nextInt(colorElement.size());

		            WebElement randomColorElement = colorElement.get(randomIndex);

		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            js.executeScript("arguments[0].click();", randomColorElement);
		            randomColorElement.click();
		            Thread.sleep(5000);
		            // Break the method after selecting the color
		            return;
		        }			    
		}	
			    
		//size
		public void selectTheSize(WebDriver driver) throws InterruptedException {
			
			//WebElement parentDiv= driver.findElement(By.xpath("//div[@id='refinement-size']"));
			//List<WebElement> sizeElement = parentDiv.findElements(By.xpath("//li[@class='d-inline mb-3']"));
			
			List<WebElement> sizeElement = driver.findElements(By.xpath("//div[@class='refinement refinement-size mb-3']//li[@class='d-inline mb-3 ']"));
			if(sizeElement.size()>0) {
				Thread.sleep(3000);
			    Random random = new Random();
			    int randomIndex = random.nextInt(sizeElement.size());
			    WebElement randomSizeElement = sizeElement.get(randomIndex);
			    System.out.println(randomSizeElement.getText());
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    //js.executeScript("arguments[0].click();", randomSizeElement);
		    	Thread.sleep(2000);
		    	randomSizeElement.click();
			    
			    Thread.sleep(3000);
			    return;
			    }			
		}
		//filters
		@FindBy(xpath ="//select[@name = 'sort-order']")
		WebElement Filters;
		public void selecttheFilters(int i, WebDriver driver) throws InterruptedException{		
			Select countrySelect = new Select(Filters);
	        countrySelect.selectByIndex(i);
	        Thread.sleep(1000);
	        JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", Filters);
	        
			//Filters.click();
	    	Thread.sleep(3000);
		}
		
		
	
		//FilterResetButton
		@FindBy(xpath ="//button[@class = 'reset btn p-0']")
		WebElement ResetButton;
		public void selecttheResetButton() throws InterruptedException{
			ResetButton.click();
	    	Thread.sleep(3000);
		}
		
		//WishList
		@FindBy(xpath ="(//a[@title= 'Wishlist'])[1]")
		WebElement WishlistPlp;
		public void selecttheWishlist() throws InterruptedException{
			WishlistPlp.click();
	    	Thread.sleep(3000);
		}
		
		//quickshop
		@FindBy(xpath ="(//div[@class='d-flex flex-row']/a[@class='quickview hidden-md-down btn btn-outline-primary w-100'])[1]")
		WebElement Quickshop;
		public void selectthequickshope(WebDriver driver) throws InterruptedException{
			
			
//			Actions action = new Actions(driver);
//			action.moveToElement(Quickshop).perform();
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Quickshop);
//			JavascriptExecutor js = (JavascriptExecutor) driver; 
//			js.executeScript("arguments[0].click();", Quickshop);
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Quickshop);
			
	    	//Quickshop.click();
	    	Thread.sleep(3000);
		}

		public void selectProductRandom(WebDriver driver) throws InterruptedException {
			
	        Random random = new Random();
	        List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
	        int totalProductcount = products.size();
	        if(totalProductcount>0)
	        {
	        int randomselectProduct = random.nextInt(totalProductcount) + 1;
//	        ScrollBarfuctions sbf = new ScrollBarfuctions();
//	        sbf.scrollmedium(driver);
	        WebElement RandomSelectProductFormPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomselectProduct + "]"));
	        
	        JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", RandomSelectProductFormPLP);
            
            
	        }
	        //RandomSelectProductFormPLP.click();
	    }

	    public void selectAllProductsFormPLP(WebDriver driver) throws InterruptedException {
	        List<Integer> numbers = new ArrayList();
	        List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
	        int totalProductcount = products.size();
	        Random random = new Random();

	        for(int i = 1; i <= totalProductcount; ++i) {
	            int randomNumber = random.nextInt(totalProductcount) + 1;
	            if (numbers.contains(randomNumber)) {
	                --i;
	            } else {
	                numbers.add(randomNumber);
	                WebElement RandomSelectProductFormPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomNumber + "]"));
	                JavascriptExecutor js = (JavascriptExecutor)driver;
	                js.executeScript("arguments[0].click();", new Object[]{RandomSelectProductFormPLP});
	                Thread.sleep(5000L);
	                WebElement Backtoplp = driver.findElement(By.xpath("(//a[contains(text(),'Outfits')])[1]"));
	                js.executeScript("arguments[0].click();", new Object[]{Backtoplp});
	                Thread.sleep(5000L);
	            }
	        }
	        
	    }	    
	            @FindBy(xpath = "(//div[@class='product'])[3]")
				WebElement product;				
				public void clickOnProduct(WebDriver driver) throws InterruptedException {			
					Thread.sleep(5000);				
					Actions action = new Actions(driver);				
					action.moveToElement(product).perform();				
					Thread.sleep(5000);				
					JavascriptExecutor js = (JavascriptExecutor)driver;				
					// js.executeScript("arguments[0].click();", product);				
					product.click();

 

}
}
