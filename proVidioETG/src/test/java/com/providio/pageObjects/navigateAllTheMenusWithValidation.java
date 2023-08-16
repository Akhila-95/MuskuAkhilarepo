package com.providio.pageObjects;

 

import java.util.List;

 

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

 

import com.providio.testcases.baseClass;

 

public class navigateAllTheMenusWithValidation extends baseClass{
    WebDriver lDriver;
        public navigateAllTheMenusWithValidation(WebDriver rDriver ){

                lDriver=rDriver;
                PageFactory.initElements(rDriver, this);
            }

    public void goingThroughAlltheMenus(WebDriver driver) throws InterruptedException {
    	
        List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));

 

        for(int i = 1; i <= countofMenus.size(); ++i) {

 

            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));

 

            for(int j = 1; j <= noelementsofdrop.size(); ++j) {
                Thread.sleep(5000);
                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));

                Thread.sleep(5000);
                Actions action = new Actions(driver);
                action.moveToElement(NavigationMenu).perform();
                Thread.sleep(5000L);

                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + j + "]"));

 

                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
                Thread.sleep(5000L);
                List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
                List<WebElement> womensplp = driver.findElements(By.xpath("(//a[contains(text(), 'Womens')])[3]"));
                List<WebElement> menplp = driver.findElements(By.xpath("(//a[contains(text(), 'Mens')])[3]"));
                List<WebElement> electronicsplp = driver.findElements(By.xpath("(//a[contains(text(), 'Electronics')])[3]"));

 

                if(newArrivalplp.size()>0) {

                    String[] newArrivalsCategory= {"WOMENS", "MENS", "ELECTRONICS"};
                    WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                    String pageTitleText = pageTitle.getText();
                    test.info("verify that NewArrivals of  " + pageTitleText + " ");
                    if (pageTitleText.equals(newArrivalsCategory[j-1])) {
                        test.pass("Successfully clicked on the NewArrivals of  " + pageTitleText + " ");
                        logger.info("click Success NewArrivals of  " + pageTitleText + "");
                    }

                }else if(womensplp.size()>0) {

                    String[] womensCategory= {"OUTFITS", "TOPS", "DRESSES","BOTTOMS","JACKETS & COATS","FEELING RED","EARRINGS","BRACELETS","NECKLACES","SCARVES","SHOES"};
                    WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                    String pageTitleText = pageTitle.getText();
                    test.info("verify that Womens of  " + pageTitleText + " ");
                    if (pageTitleText.equals(womensCategory[j-1])) {
                        test.pass("Successfully clicked on the Womens of  " + pageTitleText + " ");
                        logger.info("click Success Womens of  " + pageTitleText + "");
                    }
                }else if(menplp.size()>0) {

                    String[] mensCategory= {"SUITS","JACKETS & COATS","DRESS SHIRTS","SHORTS","PANTS","TIES","GLOVES","LUGGAGE"};
                    WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                    String pageTitleText = pageTitle.getText();
                    test.info("verify that Mens of  " + pageTitleText + " ");
                    if (pageTitleText.equals(mensCategory[j-1])) {
                        test.pass("Successfully clicked on the Mens of  " + pageTitleText + " ");
                        logger.info("click Success Mens of  " + pageTitleText + "");
                    }
                }else {

 

                    String[] electronicsCategory= {"TELEVISIONS","DIGITAL CAMERAS","IPOD & MP3 PLAYERS","GPS NAVIGATION","GAMING"};
                    WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                    String pageTitleText = pageTitle.getText();
                    test.info("verify that Electronics of  " + pageTitleText + " ");
                    if (pageTitleText.equals(electronicsCategory[j-1])) {
                        test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
                        logger.info("click Success Electronics of  " + pageTitleText + "");
                    }
                }
            }
        }
    }

 

}