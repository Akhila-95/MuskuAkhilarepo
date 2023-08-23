package com.providio.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class navigationPage {

WebDriver lDriver;
public navigationPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	int randomNumberitem=0;
		
		public void selectRandomMenu(WebDriver driver) throws InterruptedException {
	        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
	        int count = elements.size();
	        if (count > 0) {
	            Random random = new Random();
	            int randomNumbermenu = random.nextInt(count) + 1;
	        
	        List<WebElement> elementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + randomNumbermenu + "]//a[@class='dropdown-link']"));
	        int countdropdown = elementsofdrop.size();

	        if (countdropdown > 0) {
	             randomNumberitem = random.nextInt(countdropdown) + 1;
	            // Rest of your code using randomNumberitem
	        } else {
	            // Handle the case where there are no dropdown items
	            System.out.println("No dropdown items available.");
	        }
	        
	       // int randomNumberitem = random.nextInt(countdropdown) + 1;
	        WebElement NavigationRandomMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]"));
	        Thread.sleep(5000L);
	        Actions action = new Actions(driver);
	        action.moveToElement(NavigationRandomMenu).perform();
	        Thread.sleep(5000L);
	        WebElement NavigationRandomMenuitem = driver.findElement(By.xpath("(//a[@class='dropdown-link'])[" + randomNumberitem + "]"));
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", new Object[]{NavigationRandomMenuitem});
	        Thread.sleep(5000L);
	        }
	    }

	    public void goingThroughAlltheMenus(WebDriver driver) throws InterruptedException {
	        List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
	        int count = countofMenus.size();
	        System.out.println(count);
	        Random random = new Random();

	        for(int i = 1; i <= count; ++i) {
	            System.out.println("Menu of number" + i);
	            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
	            int countdropdown = noelementsofdrop.size();
	            int randomNumbermenuitem = random.nextInt(countdropdown);
	            System.out.println(countdropdown);
	            
	            System.out.println(randomNumbermenuitem);

	            for(int j = randomNumbermenuitem; j <= randomNumbermenuitem; ++j) {
	                Thread.sleep(5000);
	                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
	                String menuname = NavigationMenu.getText();
	                System.out.println(menuname);
	                
	                Thread.sleep(5000);
	                Actions action = new Actions(driver);
	                action.moveToElement(NavigationMenu).perform();
	                Thread.sleep(5000L);
	                
	                System.out.println("Menu name " + menuname);
	                
	                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + j + "]"));
	                String submenuName = NavigationMenuitem.getText();
	                System.out.println("Menu name " + submenuName);
	                JavascriptExecutor js = (JavascriptExecutor)driver;
	                js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
	                Thread.sleep(5000L);
	                
	                System.out.println("Sub menu name  " + submenuName);
	            }
	        }
	    }
	        
	        public void goingThroughEachMenuOneItem(WebDriver driver) throws InterruptedException {
		        List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
		        int count = countofMenus.size();
		        System.out.println(count);
		        Random random = new Random();

		        for(int i = 1; i <= count; ++i) {
		            System.out.println("Menu of number" + i);
		            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
		            int countdropdown = noelementsofdrop.size();
		            int randomNumbermenuitem = random.nextInt(countdropdown);
		            System.out.println(countdropdown);
		            
		            System.out.println(randomNumbermenuitem);

		                Thread.sleep(5000);
		                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
		                String menuname = NavigationMenu.getText();
		                System.out.println(menuname);
		                
		                Thread.sleep(5000);
		                Actions action = new Actions(driver);
		                action.moveToElement(NavigationMenu).perform();
		                Thread.sleep(5000L);
		                
		                System.out.println("Menu name " + menuname);
		                
		                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + randomNumbermenuitem + "]"));
		                String submenuName = NavigationMenuitem.getText();
		                System.out.println("Menu name " + submenuName);
		                JavascriptExecutor js = (JavascriptExecutor)driver;
		                js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
		                Thread.sleep(5000L);
		                
		                System.out.println("Sub menu name  " + submenuName);
		            }
		        }
	    
}
