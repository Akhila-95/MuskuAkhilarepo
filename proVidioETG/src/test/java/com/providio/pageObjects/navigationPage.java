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

//Menunewarrivals

@FindBy(xpath="//a[@id = 'newarrivals']")

WebElement newarrivalsMenu;

public void clicknewarrivalssMenu(WebDriver driver) throws InterruptedException{

    

    Actions action = new Actions(driver);

    action.moveToElement(newarrivalsMenu).perform();

    Thread.sleep(5000);

}

//submensNewarrivals

//womens

@FindBy(xpath="//a[@id='newarrivals-womens']")

WebElement newarrivalWomens;

public void ClicknewarrivalofWomens(){

    newarrivalWomens.click();

}

//mens

@FindBy(xpath="//a[@id='newarrivals-mens']")

WebElement newarrivalsMens;

public void ClicknewarrivalofMens(){

    newarrivalsMens.click();

}

//electronics

@FindBy(xpath="//a[@id='newarrivals-electronics']")

WebElement newarrivalElectronics;

public void ClicknewarrivalofElectronics(){

    newarrivalElectronics.click();

}



    

//MenuWomens

@FindBy(xpath="//a[@id = 'womens']")

WebElement WomensMenu;

public void clickwoMensMenubaritems(WebDriver driver) throws InterruptedException{

    Actions action = new Actions(driver);

    action.moveToElement(WomensMenu).perform();

    Thread.sleep(5000);

}

//submensWomens

//outfilts

@FindBy(xpath="//a[@id='womens-outfits']")

WebElement womensOutfits;

public void ClickwoMensofOutfits(){

    womensOutfits.click();

}

//clothing

@FindBy(xpath="//a[@id='womens-clothing']")

WebElement womensclothing;

public void ClickwoMensofclothing(){

    womensclothing.click();

}

//jewelry  

@FindBy(xpath="//a[@id='womens-jewelry']")

WebElement womensjewelry;

public void ClickwoMensofjewelry(){

    womensjewelry.click();

}

@FindBy(xpath="//a[@id='womens-accessories']")

WebElement womensaccessories;

public void ClickwoMensofaccessories(){

    womensaccessories.click();

}

//accessories

//tops

@FindBy(xpath="//a[@id='womens-clothing-tops']")

WebElement womenstops;

public void ClickwoMensofTops(){

    womenstops.click();

}

//dresses

@FindBy(xpath="//a[@id='womens-clothing-dresses']")

WebElement womenDresses;

public void ClickwoMensofDresses(){

    womenDresses.click();

}



//womenjackets

@FindBy(xpath="//a[@id='womens-clothing-jackets']")

WebElement womensJackets;

public void ClickwoMensofjackets(){

    womensJackets.click();

}

//red

@FindBy(xpath="//a[@id='womens-clothing-feeling-red']")

WebElement womensfeelingred;

public void ClickwoMensofFeelingRed(){

    womensfeelingred.click();

}

//Earrings

@FindBy(xpath="//a[@id='womens-jewelry-earrings']")

WebElement womenEarrings;

public void ClickwoMensofEarRings(){

    womenEarrings.click();

}

//Bracelets

@FindBy(xpath="//a[@id='womens-jewelry-bracelets']")

WebElement womenBracelets;

public void ClickwoMensofBraceletss(){

    womenBracelets.click();

}

//necklaces

@FindBy(xpath="//a[@id='womens-jewelry-necklaces']")

WebElement womennecklaces;

public void ClickwoMensofnecklaces(){

    womennecklaces.click();

}

//scarves

@FindBy(xpath="//a[@id='womens-accessories-scarves']")

WebElement womensscarves;

public void ClickwoMensofscarves(){

    womensscarves.click();

}

//shoes

@FindBy(xpath="//a[@id='womens-accessories-shoes']")

WebElement womensshoes;

public void ClickwoMensofshoes(){

    womensshoes.click();

}

//bottoms

@FindBy(xpath="//a[@id='womens-clothing-bottoms']")

WebElement womenbottoms;

public void ClickwoMensofbottoms(){

    womenbottoms.click();

}



//menuMens

@FindBy(xpath="//a[@id = 'mens']")

WebElement Mensmenu;

public void clickMensMenubaritems(WebDriver driver) throws InterruptedException{            

    Actions action = new Actions(driver);

    action.moveToElement(Mensmenu).perform();

    Thread.sleep(5000);

}

//submenusMens

//clothing

@FindBy(xpath="//a[@id='mens-clothing']")

WebElement Mensclothing;

public void ClickMensofclothing(){

    Mensclothing.click();

}

//accessories

@FindBy(xpath="//a[@id='mens-accessories']")

WebElement Mensaccessories;

public void ClickMensofaccessories(){

    Mensaccessories.click();

}

//suits

@FindBy(xpath="//a[@id='mens-clothing-suits']")

WebElement MensSuits;

public void ClickMensofsuits(){

    MensSuits.click();

}

//jackets

@FindBy(xpath="//a[@id='mens-clothing-jackets']")

WebElement Mensjackets;

public void ClickMensofJackets(){

    Mensjackets.click();

}

//dressShirts

@FindBy(xpath="//a[@id='mens-clothing-dress-shirts']")

WebElement MensShirts;

public void ClickMensofShirts(){

    MensShirts.click();

}

//Shorts

//dressShirts

@FindBy(xpath="//a[@id='mens-clothing-shorts']")

WebElement MensShorts;

public void ClickMensofShorts(){

    MensShorts.click();

}

//pants

//dressShirts

@FindBy(xpath="//a[@id='mens-clothing-pants']")

WebElement mensPants;

public void ClickMensofPants(WebDriver driver) throws InterruptedException{
    Thread.sleep(1000);
    mensPants.click();
    if(mensPants.isDisplayed()) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", mensPants);
    }
}

//ties

@FindBy(xpath="//a[@id='mens-accessories-ties']")

WebElement Mensties;

public void ClickMensofties(){

    Mensties.click();

}



//gloves

@FindBy(xpath="//a[@id='mens-accessories-gloves']")

WebElement Mensgloves;

public void ClickMensofgloves(){

    Mensgloves.click();

}

//luggage

@FindBy(xpath="//a[@id='mens-accessories-luggage']")

WebElement Mensluggage;

public void ClickMensofluggage(){

    Mensluggage.click();

}







//Menuelectronics

@FindBy(xpath="//a[@id = 'electronics']")

WebElement electronicsMenu;

public void clickelectronicsMenu(WebDriver driver) throws InterruptedException{

    

    Actions action = new Actions(driver);

    action.moveToElement(electronicsMenu).perform();

    Thread.sleep(5000);

}

//submenselectronics

//televisions

@FindBy(xpath="//a[@id='electronics-televisions']")

WebElement electronicsTelevisions;

public void ClickelectronicsofTelevisions(WebDriver driver) throws InterruptedException{

    

    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript("arguments[0].click();", electronicsTelevisions);

//    Thread.sleep(2000);

//    electronicsTelevisions.click();

}

//cameras

@FindBy(xpath="//a[@id='electronics-digital-cameras']")

WebElement electronicsdigitalcameras;

public void Clickelectronicsofcameras(){

    electronicsdigitalcameras.click();

}

//media-players

@FindBy(xpath="//a[@id='electronics-digital-media-players']")

WebElement electronicsmediaplayers;

public void Clickelectronicsofmediaplayers(){

    electronicsmediaplayers.click();

}

//gps-units

@FindBy(xpath="//a[@id='electronics-gps-units']")

WebElement electronicsGpsUnits;

public void ClickelectronicsofGpsUnits(){

    electronicsGpsUnits.click();

}

//gaming

@FindBy(xpath="//a[@id='electronics-gaming']")

WebElement electronicsgaming;

public void ClickelectronicsofGaming(){

    electronicsgaming.click();

}





//MenuTopseller

@FindBy(xpath="//a[@id = 'top-seller']")

WebElement Topseller;

public void clickTopsellerMenu(WebDriver driver) throws InterruptedException{

    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript("arguments[0].click();", Topseller);

    Thread.sleep(5000);

    //Topseller.click();

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
