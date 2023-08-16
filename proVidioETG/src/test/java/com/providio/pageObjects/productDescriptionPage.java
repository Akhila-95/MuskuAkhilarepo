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

public class productDescriptionPage {

	WebDriver ldriver;
	
	public productDescriptionPage(WebDriver rdriver ){	
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}
//to  select product 1
@FindBy(xpath = "//img[@alt='Washable Wool Classic Straight Skirt']")
WebElement product1;

public void clickOnProduct1() throws InterruptedException{	
	
	Thread.sleep(2000);
	 product1.click();
	 Thread.sleep(2000);
	
}


     
	//nvaigate through breadcrumbs
	//xapth for all breadcrumbs
	@FindBy(xpath ="(//ol[@class='breadcrumb mb-0']//a[ contains(text(),'Womens')])[1]" )
	WebElement allBreadCrumbs;
	
	
	public void clickOnBreadCrumbs(WebDriver driver) throws InterruptedException
	{
//		List<WebElement> breadcrumbItems = allBreadCrumbs.findElements(By.className( ".breadcrumb-item"));
//		Thread.sleep(2000);
		Actions actions =new Actions(driver);
		actions.moveToElement(allBreadCrumbs);
		allBreadCrumbs.click();
//		for (WebElement breadcrumbItem : breadcrumbItems) {
//		   
//		    breadcrumbItem.click(); // or perform other actions on the item
//		}
		
	}
	
	
	//count the images
//	int count = 0;
//	public int countElementsWithSameClassName(WebDriver driver, String className) {
//	    List<WebElement> elements = driver.findElements(By.className("slick-paging-image-container"));
//	    
//	    for (WebElement element : elements) {
//	        count++;
//			 System.out.println(count);
//
//	    }
//	    return count;
//	
//	}
	
	//forleftCarousel
			@FindBy(xpath = "//button[@class='slick-prev slick-arrow']")
			WebElement leftCarousel;
			
			public void clickOnLeftCarousel(WebDriver driver) throws InterruptedException
			{
				//countElementsWithSameClassName(driver, countWebElement);
				for(int i=1;i<=2;i++)
				{
					leftCarousel.click();
					
				}
			
				Thread.sleep(2000);
			}	
			
		
	//forrightCarousel
			@FindBy(xpath = "//button[@class='slick-next slick-arrow']")
			WebElement rightCarousel;
			public void clickOnRightCarousel(WebDriver driver) throws InterruptedException {
				
				for(int i=1;i<=2;i++)
				{
					rightCarousel.click();
				
				}
				Thread.sleep(2000);
			}
     //write a review at top
			@FindBy(xpath = "(//a[@class='pr-snippet-write-review-link pr-underline'])[1]")
			WebElement writeAReviewAtTop;
			public void clickOnWriteAReviewAtTop() throws InterruptedException {
				
				writeAReviewAtTop.click();
				Thread.sleep(3000);
			}
//in write a rwview page
			//for rating
			@FindBy(xpath = "//span[contains(@class, 'pr-accessible-text')]")
			WebElement rating1;
			public void clickOnRating(WebDriver driver) throws InterruptedException {
				
				if (rating1.isEnabled()) {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", rating1);
					
				} else {
				    System.out.println("Element is disabled");
				}

				 
			}
			//for review headline
			@FindBy(xpath = "//input[@name='Review Headline']")
			WebElement reviewHeadline;
			
			public void clickOnReviewHeadline(WebDriver driver, String headline) throws InterruptedException {
				
				 JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();", reviewHeadline);
				 reviewHeadline.sendKeys( headline);
				 Thread.sleep(3000);
				
			}
			//for commemnts
			@FindBy(xpath = "//textarea[@id='pr-comments-input']")
			WebElement comments;
			public void clickOnComments(String comment) throws InterruptedException {
				comments.sendKeys(comment);
				Thread.sleep(3000);
			}
			//bottom line for yes
			@FindBy(xpath = "//label[text()='Yes, I would recommend this to a friend']")
			WebElement forYes;
			public void clickOnYes() throws InterruptedException {
				forYes.click();
				Thread.sleep(2000);
			}
			
			//bottom line for no
			@FindBy(xpath = "//input[@id='pr-plF1ZjMbk-PpfQ1jg06AR1']")
			WebElement forNo;
			public void clickOnNo() throws InterruptedException {
				forYes.click();
				Thread.sleep(2000);
			}
			//nickname
			@FindBy(xpath = "//input[@id='pr-name-input']")
			WebElement nickName;
			public void clicknickName(String name) throws InterruptedException {
				nickName.sendKeys(name);
				Thread.sleep(5000);
			}
			//location
			@FindBy(xpath = "//input[@id='pr-location-input']")
			WebElement location;
			public void clickOnLoc(String loc) throws InterruptedException  {
				location.sendKeys(loc);
				Thread.sleep(4000);
			}
			//submitreview
			@FindBy(xpath = "//button[@type='submit' and text()='Submit Review']")
			WebElement submitReview;
			
			public void clickOnSubmitReview(WebDriver driver) throws InterruptedException {
				
				 JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();",submitReview);
				 Thread.sleep(4000);
				 //driver.navigate().back();
			}
			
		/*//to select color
			
			@FindBy(xpath = "//select[contains(@class,'select-color-swatch')]")
			List<WebElement colorElement;
			public void clickOnColor() {
				//size
  			  WebElement sizeElement = colorElement.get(0);
  			  System.out.println("Size element is present on the page.");
  			  
  				Select colorElement = new Select(sizeElement);
  			    List<WebElement> options = colorElement.getOptions();
  			    
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
				
				   Select  colorSelect = new Select(color);
				    List<WebElement> colorOptions =  colorSelect.getOptions();
				    Random random = new Random();
			        int randomIndex = random.nextInt(colorOptions.size() - 1) + 1;
			        colorSelect.selectByIndex(randomIndex);
			}
			*/
		//to select size
			
			@FindBy(xpath ="//select[contains(@class,'select-size')]" )
			WebElement Size;
			public void clickOnSize(WebDriver driver) throws InterruptedException {
				//sizes in boxess
				List<WebElement> sizeBox= driver.findElements(By.xpath("//div[@class='select-size size-change d-flex flex-wrap']"));
				if(sizeBox.size()>0) {
					
					  List<WebElement> sizeElements = driver.findElements(By.cssSelector(".select-size .text-center:not(.disabled)"));

				        // Generate a random index within the range of available sizes
				        int randomIndex = new Random().nextInt(sizeElements.size());

				        // Get the randomly selected size element
				        WebElement selectedSizeElement = sizeElements.get(randomIndex);

				        // Click the selected size element
				        selectedSizeElement.click();

				}else {
				// sizes from drop down Create a Select object and select the first enabled size
				
			    Select colorElement = new Select(Size);
			    List<WebElement> options = colorElement.getOptions();
			    List<String> enabledSizes = new ArrayList<>();
			    int optionIndex = 0;
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
			    		//System.out.println("This size is not avaliable");
			    	}
			    	
			    	 optionIndex++;
			    }
			    
			    //System.out.println(enabledSizes);

			  }
			}
			//decrease the qunatity
			@FindBy (xpath="//span[@class='qty-minus']")
			WebElement decreaseTheQunatity;
			public void clickOndecreaseTheQunatity() throws InterruptedException {
				if (decreaseTheQunatity.isEnabled()) {
					

					for(int i=1;i<=5;i++) {
						decreaseTheQunatity.click();
						Thread.sleep(1000);
					}
					
				}
				
				else {
					System.out.println("decrease quantity is not enabled");
				}
				Thread.sleep(1000);
			}
			
			
			//decrease the quantity
			@FindBy(xpath="//span[@class='qty-plus']")
			WebElement increaseTheQuantity;
			public void clickInIncreaseQuantity() throws InterruptedException {
				
				if (increaseTheQuantity.isEnabled()) {
					
					for(int i=1;i<=5;i++) {
						increaseTheQuantity.click();
						Thread.sleep(1000);
					}
				}
				else {
				System.out.println("increase quantity is not enabled");
				}
				Thread.sleep(1000);
			}
			
			
		//wishlist from pdp
			@FindBy(xpath="//button[@type='submit' and span[text()='Wishlist']]")
			WebElement wishlist;
			public void clickOnWishlist() {
				wishlist.click();
			}
			
			
		//to find the store
			@FindBy(xpath="//span[contains(text(),'Find a Store')]")
			WebElement findAStore;
			public void clickOnStore(WebDriver driver) throws InterruptedException {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();", findAStore);
				 Thread.sleep(2000);
				
			}
		//zip code or postal code
			@FindBy(id = "store-postal-code")
			WebElement zipCodeInStore;
			public void clickOnZipCode(String zipcodeStore) {
				zipCodeInStore.sendKeys(zipcodeStore);
			}
			
		//radius in fina a store
			@FindBy(id="radius")
			WebElement radius;
			public void clickOnRadius() {
				Select selectRadius = new Select(radius);
				selectRadius.selectByIndex(1);
			}
		//click on find stores
			@FindBy(xpath="//button[contains(text(),'Find Stores')]")
			WebElement findStores;
			public void clickOnFindStores() throws InterruptedException {
				
				findStores.click();
				Thread.sleep(2000);
			}
		//close the find stores
		/*	@FindBy(xpath="(//span[@aria-hidden='true' and text()='×'])[1]")
			WebElement closeFindStore;
			public void clickOnCloseFindStore(WebDriver driver ) throws InterruptedException {
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();",  closeFindStore);
				
			}*/
			@FindBy(xpath = "//div[@id='findInStoreModal']")
			WebElement closeFindStore;
			
			public void clickOnCloseFindStore(WebDriver driver ) throws InterruptedException {
				Thread.sleep(2000);
				closeFindStore.click();
			}
		//social media
			//pin interest
			@FindBy(xpath="//i[@class='fa fa-pinterest']")
			WebElement pinterest;
			public void clickOnPinterest() throws InterruptedException {
				Thread.sleep(1000);
				pinterest.click();
			}
			
			//facebook
			@FindBy(xpath="//i[@class='fa fa-facebook-official']")
			WebElement facebook;
			public void clickOnFacebook() throws InterruptedException {
				Thread.sleep(1000);
				 facebook.click();
			}
			
			//twitter
			@FindBy(xpath="(//i[@class='fa fa-twitter'])[1]")
			WebElement twitter;
			public void clickOntwitter() throws InterruptedException {
				Thread.sleep(1000);
				twitter.click();
			}
			
			//link
			@FindBy(xpath="//i[@class='fa fa-link']")
			WebElement link;
			public void clickOnLink() throws InterruptedException {
				Thread.sleep(1000);
				link.click();
			}
			
			//write a review at bottom
			@FindBy(xpath="(//a[contains(text(),'Write the First Review')])[2]")
			WebElement writeAReviewAtBottom;
			public void clickOnwriteAReviewAtBottom() {
				writeAReviewAtBottom.click();
			}
			
	//to select addtocart
	//cartbutton
			
			
				@FindBy(xpath = "//button[contains(@class,'add-to-cart')]")
				WebElement CartButton;
				public void clickcartbutton(WebDriver driver) throws InterruptedException{
					 
					 Thread.sleep(5000);
					 JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", CartButton);
					 Thread.sleep(2000);
					 
				}
				
				
				//memory size element
				
				@FindBy(id ="memorySize-null" )
				WebElement memorySize;
				public void selecttheMemorySize(WebDriver driver) throws InterruptedException {
					 List<WebElement> memoryBox = driver.findElements(By.xpath("//div[@class='select-memorySize size-change d-flex flex-wrap']"));
					if(memoryBox.size()>0) {
						 List<WebElement> memorySizeElements = driver.findElements(By.cssSelector(".select-memorySize .text-center.selectable"));

					        // Create a random instance
					        Random random = new Random();

					        // Choose a random index
					        int randomIndex = random.nextInt(memorySizeElements.size());

					        // Get the randomly selected memory size element
					        WebElement selectedMemorySizeElement = memorySizeElements.get(randomIndex);

					        // Click the selected memory size element
					        selectedMemorySizeElement.click();
					}else {
					
					
					// Create a Select object and select the first enabled size
					WebElement memorySize= driver.findElement(By.xpath("//select[contains(@class,'select-memorySize')]"));
				    Select MemoryElement = new Select(memorySize);
				    List<WebElement> options = MemoryElement.getOptions();
				    
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
				    		System.out.println("This memory size is not avaliable");
				    	}				    	
				    	 optionIndex++;
				    }
				    
				    //System.out.println(enabledSizes);
					}
				}
				
				@FindBy(xpath = "//a[contains(text(), 'Continue Shopping')]")
				WebElement continueShoppingLink;
				public void clickOncontinueShoping(WebDriver driver) throws InterruptedException {
					
					continueShoppingLink.click();

					 Thread.sleep(2000);
				}
				
				//buy now button in pdp page
				 	@FindBy(xpath = "//button[contains(@class,'buy-now')]")
				 	WebElement buyNowButton;
				 	public void clickOnBuyNowButton(WebDriver driver) {
				 		JavascriptExecutor js = (JavascriptExecutor)driver;
                        js.executeScript("arguments[0].click();", buyNowButton);
				 		//buyNowButton.click();
				 	}
				
				
			 	public void clickOnColor(WebDriver driver) throws InterruptedException {
			 		
			 		List<WebElement> colorBox= driver.findElements(By.xpath("//button[contains(@class,'color-attribute')]"));
			 		if(colorBox.size()>0) {
			 			 // Find all the color buttons that are selectable
			 	        List<WebElement> colorButtons = driver.findElements(By.cssSelector(".color-attribute.selectable"));

			 	        // Create a random instance
			 	        Random random = new Random();

			 	        // Choose a random index
			 	        int randomIndex = random.nextInt(colorButtons.size());

			 	        // Get the randomly selected color button
			 	        WebElement selectedColorButton = colorButtons.get(randomIndex);

			 	        // Click the selected color button
			 	        selectedColorButton.click();
			 		}else {
			 		// Create a Select object and select the first enabled size
					WebElement color = driver.findElement(By.xpath("//select[contains(@class,'select-color-swatch')]"));
					
				    Select colorElement = new Select(color);
				    List<WebElement> options = colorElement.getOptions();
				    
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
				                Thread.sleep(5000);
				                break; 				                
				            }
				        }
    	
				    	 optionIndex++;
				    }
			   
			    }
			}
				 	
				 	//select width
				 	public void selectWidth(WebDriver driver) throws InterruptedException {
				 		 List<WebElement> widthBox = driver.findElements(By.xpath("//div[@class='select-width size-change d-flex flex-wrap']"));
				 		
				 		if(widthBox.size()>0) {
				 		// Find all the width size elements that are selectable
				 			WebElement parentDiv= driver.findElement(By.xpath("//div[@class='select-width size-change d-flex flex-wrap']"));
				 			
				 	        List<WebElement> widthSizeElements =  parentDiv.findElements(By.xpath("//span[@class='text-center']"));

				 	        // Create a random instance
				 	        Random random = new Random();

				 	        Thread.sleep(2000);
				 	        // Choose a random index
				 	       // if() {
				 	        int randomIndex = random.nextInt(widthSizeElements.size());

				 	        // Get the randomly selected width size element
				 	        WebElement selectedWidthSizeElement = widthSizeElements.get(randomIndex);

				 	        // Click the selected width size element
				 	        selectedWidthSizeElement.click();
				 	       // }
				 	        
				 		}else {
				 		List<WebElement> widthElements = driver.findElements(By.xpath(".//select[@id='width-null']"));
			    	    System.out.println(widthElements.size());
			    	        
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
	        			
	        			  Thread.sleep(5000);
				 		}
				 	}
				 	
				 	//select showname
				 	public void selectShowName(WebDriver driver) throws InterruptedException {
				 		List<WebElement> showNameElements = driver.findElements(By.xpath("//select[contains(@class,'select-showName')]"));
			    	    System.out.println(showNameElements.size());
			    	        
				 		  //show name
	        			  WebElement widthElement = showNameElements.get(0);
	        			  System.out.println("width element is present on the page.");
	        			  
	        				Select showNameSelect = new Select(widthElement);
	        				
	        				// Get the list of available options
	        			  List<WebElement> availableOptionsofwidth =  showNameSelect.getOptions();
	        			
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
	        			  showNameSelect.selectByIndex(randomIndexofwidth); 
	        			
	        			  Thread.sleep(5000);
				 	}
				 	
				//Paypal buynow button
				 	@FindBy(xpath = "//div[contains(@class,'salesforce-buynow-element ')]")
				 	WebElement paypalBuyNow;
				 	public void clickOnPaypalBuyNow(WebDriver driver) {
				 		paypalBuyNow.click();
				    	 JavascriptExecutor js = (JavascriptExecutor) driver;
				    	// js.executeScript("arguments[0].click();", paypalBuyNow);
				 	}
}
