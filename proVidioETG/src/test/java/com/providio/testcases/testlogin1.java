		package com.providio.testcases;
		
		 
		
		 
		
		import java.time.Duration;
		
		import java.util.List;
		
		import java.util.Random;
		
		 
		
		import org.openqa.selenium.By;
		
		import org.openqa.selenium.JavascriptExecutor;
		
		import org.openqa.selenium.WebDriver;
		
		import org.openqa.selenium.WebElement;
		
		import org.openqa.selenium.chrome.ChromeDriver;
		
		import org.openqa.selenium.interactions.Actions;
		
		import org.openqa.selenium.support.ui.ExpectedConditions;
		
		import org.openqa.selenium.support.ui.WebDriverWait;
		
		import org.testng.annotations.Test;
		
		 
		
		import io.github.bonigarcia.wdm.WebDriverManager;
		
		 
		
		public class testlogin1 {
		
		 
		
		public static WebDriver driver;
		
		@Test
		
		private void initializeDriver() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/womens/clothing/bottoms/?lang=en_US");
		
		 
		
		WebElement product =driver.findElement(By.xpath("(//img[@class='tile-image'])[1]"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(product).perform();
		
		Thread.sleep(2000);
		
		WebElement addToBagbutton =driver.findElement(By.xpath("(//a[@data-addtocart='Add to Bag'])[1]"));
		
		addToBagbutton.click();
		
		 
		
		// Find the div containing the list using XPath.
		
		WebElement divElement = driver.findElement(By.xpath("//div[@class='plp-size-list js-plp-size-list']"));
		
		 
		
		// Find all the list items (li tags) within the div using XPath.
		
		List<WebElement> listItems = divElement.findElements(By.xpath(".//li"));
		
		 
		
		// Get the total number of list items.
		
		int totalItems = listItems.size();
		
		// Generate a random number between 0 and the total number of list items.
		
		Random random = new Random();
		
		int randomIndex = random.nextInt(totalItems);
		
		 
		
		// Get the link (a tag) corresponding to the randomly selected index.
		
		WebElement randomLink = listItems.get(randomIndex).findElement(By.tagName("a"));
		
		 
		
		// Click on the randomly selected link.
		
		randomLink.click();
		
		 
		
		Thread.sleep(3000);
		
		WebElement addToBagAfterSizeSelected = driver.findElement(By.xpath("//a[@class='btn btn-outline-primary add-to-cart js-pt-add-to-cart hidden-md-down w-50 success-color']"));
		
		WebElement addToBag1 = addToBagAfterSizeSelected.findElement(By.xpath("//span[contains(text(),'Add to Bag')]"));
		
		Thread.sleep(2000);
		
		 
		
		System.out.println("Product add to cart");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//js.executeScript("arguments[0].click();", addToBag1);
		
		addToBag1.click();
		
		}
		
		}