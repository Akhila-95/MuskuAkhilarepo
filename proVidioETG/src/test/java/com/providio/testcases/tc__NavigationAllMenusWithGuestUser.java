//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.providio.testcases;

import com.providio.pageObjects.navigationPage;
import com.providio.testcases.baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__NavigationAllMenusWithGuestUser extends baseClass {

	SoftAssert softAssert = new SoftAssert();

    @Test
    public void NavigationAllMenusWithGuestUser() throws InterruptedException {
        
        driver.get(this.baseURL);
        logger.info("enterd into url");
            
//            navigationPage NM = new navigationPage(driver);
//            NM.goingThroughAlltheMenus(driver);
            
            navigationPage NM = new navigationPage(driver);
            
            test.info("verify that NewArrival of mens");
            NM.clicknewarrivalssMenu(driver);
            logger.info("Howered Newarrival menu");
            Thread.sleep(5000L);
            
            NM.ClicknewarrivalofMens();
            logger.info("Clicked on the NewArrival mens");
            Thread.sleep(5000L);
            
            //validate new arrival mens
            WebElement NewMens = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
            String ActualTitleofMens = NewMens.getText();
            String ExpectedTitleofMens = "MENS";
            //logger.info(NewMens.getText());
            if (ActualTitleofMens.equals(ExpectedTitleofMens)) {
                test.pass("Successfully clicked on the NewArrival of  " + ActualTitleofMens + " ");
                logger.info("click Success New arrival mens");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofMens + " " + "  but found" + " " + ActualTitleofMens + " ");
                logger.info("Click failed");
            }
            
//          //soft assertions new arrival mens
//          
//          softAssert.assertEquals(ActualTitleofMens, ExpectedTitleofMens, "Page title does not match expected value");
//          
//          //Hard assertions new arrival mens
//          
//          Assert.assertEquals(ActualTitleofMens, ExpectedTitleofMens, "Page title does not match expected value");

            test.info("verify that NewArrival of womens");
            NM.clicknewarrivalssMenu(driver);
            logger.info("Howered Newarrival menu");
            
            NM.ClicknewarrivalofWomens();
            logger.info("Clicked on the NewArrival womens");
            Thread.sleep(15000L);
            
          //validate new arrival womens
            WebElement NewwoMens = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
            String ActualTitleofwoMens = NewwoMens.getText();
            String ExpectedTitleofwoMens = "WOMENS";
            logger.info(NewwoMens.getText());
            if (ActualTitleofwoMens.equals(ExpectedTitleofwoMens)) {
                test.pass("Successfully clicked on the NewArrival of  " + ActualTitleofwoMens + " " + " ");
                logger.info("click Success New arrival womens");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofwoMens + " " + "  but found" + " " + ActualTitleofwoMens + " ");
                logger.info("Click failed");
            }
            
//          //soft assertions new arrival womens
//          
//          softAssert.assertEquals(ActualTitleofwoMens, ExpectedTitleofwoMens, "Page title does not match expected value");
//          
//          //Hard assertions new arrival mens
//          
//          Assert.assertEquals(ActualTitleofwoMens, ExpectedTitleofwoMens, "Page title does not match expected value");

            test.info("verify that NewArrival of electronics");
            NM.clicknewarrivalssMenu(driver);
            logger.info("Howered Newarrival menu");
            
            NM.ClicknewarrivalofElectronics();
            logger.info("Clicked on the NewArrival electronics");
            Thread.sleep(5000L);
            
          //validate new arrival Electronics
            WebElement NewElectronics = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
            String ActualTitleofElectronics = NewElectronics.getText();
            String ExpectedTitleofElectronics = "ELECTRONICS";
            logger.info(NewElectronics.getText());
            if (ActualTitleofElectronics.equals(ExpectedTitleofElectronics)) {
                test.pass("Successfully clicked on the NewArrival of  " + ActualTitleofElectronics + " " + " ");
                logger.info("click Success New arrival Electronics");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofElectronics + " " + "  but found" + " " + ActualTitleofElectronics + " ");
                logger.info("Click failed");
            }
            
//          //soft assertions new arrival Electronics
//          
//          softAssert.assertEquals(ActualTitleofElectronics, ExpectedTitleofElectronics, "Page title does not match expected value");
//          
//          //Hard assertions new arrival mens
//          
//          Assert.assertEquals(ActualTitleofElectronics, ExpectedTitleofElectronics, "Page title does not match expected value");

            test.info("verify that womens of outfits");
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            Thread.sleep(5000L);
            
            NM.ClickwoMensofOutfits();
            logger.info("Clicked womens of outfits");
            Thread.sleep(5000L);
            
          //validate womens of outFits
            WebElement outfits = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofoutfits = outfits.getText();
            String ExpectedTitleofoutfits = "OUTFITS";
            logger.info(outfits.getText());
            if (ActualTitleofoutfits.equals(ExpectedTitleofoutfits)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofoutfits + " ");
                logger.info("click Success Womens of outfits");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofoutfits + " " + "  but found" + " " + ActualTitleofoutfits + " ");
                logger.info("Click failed");
            }
            
            //soft assertions new arrival womens
//          
//          softAssert.assertEquals(ActualTitleofoutfits, ExpectedTitleofoutfits, "Page title does not match expected value");
//          
//          //Hard assertions new arrival mens
//          
//          Assert.assertEquals(ActualTitleofoutfits, ExpectedTitleofoutfits, "Page title does not match expected value");
            
            
            
            test.info("verify that womens of tops");
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            
            NM.ClickwoMensofTops();
            logger.info("Clicked womens of tops");
            Thread.sleep(5000L);
            
          //validate womens of tops
            WebElement tops = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleoftops = tops.getText();
            String ExpectedTitleoftops = "TOPS";
            logger.info(tops.getText());
            if (ActualTitleoftops.equals(ExpectedTitleoftops)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleoftops + " ");
                logger.info("click Success Womens of tops");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleoftops + " " + "  but found" + " " + ActualTitleoftops + " ");
                logger.info("Click failed");
            }
            
            //soft assertions womens of tops
//          
//          softAssert.assertEquals(ActualTitleoftops, ExpectedTitleoftops, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleoftops, ExpectedTitleoftops, "Page title does not match expected value");

            test.info("verify that womens of dresses");
            
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            
            NM.ClickwoMensofDresses();
            logger.info("Clicked womens of dresses");
            Thread.sleep(5000L);
            
          //validate womens of Dresses
            WebElement Dresses = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofDresses = Dresses.getText();
            String ExpectedTitleofDresses = "DRESSES";
            logger.info(Dresses.getText());
            if (ActualTitleofDresses.equals(ExpectedTitleofDresses)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofDresses + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofDresses + " " + "  but found" + " " + ActualTitleofDresses + " ");
                logger.info("Click failed");
            }
            
            //soft assertions womens of Dresses
//          
//          softAssert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");
            
            test.info("verify that womens of bottoms");
            
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            
            NM.ClickwoMensofbottoms();
            logger.info("Clicked womens of bottoms");
            Thread.sleep(5000L);
            
          //validate womens of bottoms
            WebElement bottoms = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofbottoms = bottoms.getText();
            String ExpectedTitleofbottoms = "BOTTOMS";
            logger.info(bottoms.getText());
            if (ActualTitleofbottoms.equals(ExpectedTitleofbottoms)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofbottoms + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofbottoms + " " + "  but found" + " " + ActualTitleofbottoms + " ");
                logger.info("Click failed");
            }

            //soft assertions womens of bottoms
//          
//          softAssert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");
            
            test.info("verify that womens of jackets");
            
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            
            NM.ClickwoMensofjackets();
            logger.info("Clicked womens of jackets");
            Thread.sleep(5000L);
            
            //validate womens of Jackets
            WebElement Jackets = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofJackets = Jackets.getText();
            String ExpectedTitleofJackets = "JACKETS & COATS";
            logger.info(Jackets.getText());
            if (ActualTitleofJackets.equals(ExpectedTitleofJackets)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofJackets + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofJackets + " " + "  but found" + " " + ActualTitleofJackets + " ");
                logger.info("Click failed");
            }
            
            //soft assertions womens of bottoms
//          
//          softAssert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");

            test.info("verify that womens of red");
            
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            
            NM.ClickwoMensofFeelingRed();
            logger.info("Clicked womens of red");
            Thread.sleep(5000L);
            
          //validate womens of FeelingRed
            WebElement FeelingRed = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofFeelingRed = FeelingRed.getText();
            String ExpectedTitleofFeelingRed = "FEELING RED";
            logger.info(FeelingRed.getText());
            if (ActualTitleofFeelingRed.equals(ExpectedTitleofFeelingRed)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofFeelingRed + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofFeelingRed + " " + "  but found" + " " + ActualTitleofFeelingRed + " ");
                logger.info("Click failed");
            }

            //soft assertions womens of FeelingRed
//          
//          softAssert.assertEquals(ActualTitleofFeelingRed, ExpectedTitleofFeelingRed, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofFeelingRed, ExpectedTitleofFeelingRed, "Page title does not match expected value");
            
            test.info("verify that womens of earrings");
            
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            
            NM.ClickwoMensofEarRings();
            logger.info("Clicked womens of earrings");
            Thread.sleep(5000L);
            
          //validate womens of earrings
            WebElement earrings = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofearrings = earrings.getText();
            String ExpectedTitleofearrings = "EARRINGS";
            logger.info(earrings.getText());
            if (ActualTitleofearrings.equals(ExpectedTitleofearrings)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofearrings + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofearrings + " " + "  but found" + " " + ActualTitleofearrings + " ");
                logger.info("Click failed");
            }

            
            //soft assertions womens of earrings
//          
//          softAssert.assertEquals(ActualTitleofearrings, ExpectedTitleofearrings, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofearrings, ExpectedTitleofearrings, "Page title does not match expected value");
            
            test.info("verify that womens of neckless");
            
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            NM.ClickwoMensofnecklaces();
            logger.info("Clicked womens of neckless");
            Thread.sleep(5000L);
            
          //validate womens of neckless
            WebElement neckless = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofneckless = neckless.getText();
            String ExpectedTitleofneckless = "NECKLACES";
            logger.info(neckless.getText());
            if (ActualTitleofneckless.equals(ExpectedTitleofneckless)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofneckless + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofneckless + " " + "  but found" + " " + ActualTitleofneckless + " ");
                logger.info("Click failed");
            }
            
            //soft assertions womens of neckless
//          
//          softAssert.assertEquals(ActualTitleofneckless, ExpectedTitleofneckless, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofneckless, ExpectedTitleofneckless, "Page title does not match expected value");
            
            test.info("verify that womens of braceletss");
            
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            
            NM.ClickwoMensofBraceletss();
            logger.info("Clicked womens of braceletss");
            Thread.sleep(5000L);
            
          //validate womens of braceletss
            WebElement braceletss = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofbraceletss = braceletss.getText();
            String ExpectedTitleofbraceletss = "BRACELETS";
            logger.info(braceletss.getText());
            if (ActualTitleofbraceletss.equals(ExpectedTitleofbraceletss)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofbraceletss + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofbraceletss + " " + "  but found" + " " + ActualTitleofbraceletss + " ");
                logger.info("Click failed");
            }
            
            //soft assertions womens of braceletss
//          
//          softAssert.assertEquals(ActualTitleofbraceletss, ExpectedTitleofbraceletss, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofbraceletss, ExpectedTitleofbraceletss, "Page title does not match expected value");
            
            test.info("verify that womens of scarves");
            
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            Thread.sleep(3000);
            
            NM.ClickwoMensofscarves();
            logger.info("Clicked womens of scarves");
            Thread.sleep(5000L);
            
          //validate womens of scarves
            WebElement scarves = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofscarves = scarves.getText();
            String ExpectedTitleofscarves = "SCARVES";
            logger.info(scarves.getText());
            if (ActualTitleofscarves.equals(ExpectedTitleofscarves)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofscarves + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofscarves + " " + "  but found" + " " + ActualTitleofscarves + " ");
                logger.info("Click failed");
            }
            
            //soft assertions womens of scarves
//          
//          softAssert.assertEquals(ActualTitleofscarves, ExpectedTitleofscarves, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofscarves, ExpectedTitleofscarves, "Page title does not match expected value");
            
            test.info("verify that womens of shoes");
            
            NM.clickwoMensMenubaritems(driver);
            logger.info("Howered womens menu");
            
            NM.ClickwoMensofshoes();
            logger.info("Clicked womens of shoes");
            Thread.sleep(5000L);
            
          //validate womens of shoes
            WebElement shoes = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofshoes = shoes.getText();
            String ExpectedTitleofshoes = "SHOES";
            logger.info(shoes.getText());
            if (ActualTitleofshoes.equals(ExpectedTitleofshoes)) {
                test.pass("Successfully clicked on the Womens of  " + ActualTitleofshoes + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofshoes + " " + "  but found" + " " + ActualTitleofshoes + " ");
                logger.info("Click failed");
            }
            
            //soft assertions womens of shoes
//          
//          softAssert.assertEquals(ActualTitleofshoes, ExpectedTitleofshoes, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofshoes, ExpectedTitleofshoes, "Page title does not match expected value");
            

            test.info("verify that mens of suits");
            
            NM.clickMensMenubaritems(driver);
            logger.info("Howered mens menu");
            Thread.sleep(5000L);
            
            NM.ClickMensofsuits();
            logger.info("Clicked mens of suits");
            Thread.sleep(5000L);
            
          //validate mens of suits
            WebElement suits = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofsuits = suits.getText();
            String ExpectedTitleofsuits = "SUITS";
            logger.info(suits.getText());
            if (ActualTitleofsuits.equals(ExpectedTitleofsuits)) {
                test.pass("Successfully clicked on the mens of  " + ActualTitleofsuits + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofsuits + " " + "  but found" + " " + ActualTitleofsuits + " ");
                logger.info("Click failed");
            }
            
            //soft assertions mens of suits
//          
//          softAssert.assertEquals(ActualTitleofsuits, ExpectedTitleofsuits, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofsuits, ExpectedTitleofsuits, "Page title does not match expected value");
            
            test.info("verify that mens of pants");
            
            NM.clickMensMenubaritems(driver);
            logger.info("Howered mens menu");
            
            NM.ClickMensofPants();
            logger.info("Clicked mens of pants");
            Thread.sleep(5000L);
            
            //validate mens of pants
            WebElement pants = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofpants = pants.getText();
            String ExpectedTitleofpants = "PANTS";
            logger.info(pants.getText());
            if (ActualTitleofpants.equals(ExpectedTitleofpants)) {
                test.pass("Successfully clicked on the mens of  " + ActualTitleofpants + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofpants + " " + "  but found" + " " + ActualTitleofpants + " ");
                logger.info("Click failed");
            }
            
            //soft assertions mens of pants
//          
//          softAssert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");
            
            test.info("verify that mens of shirts");
            
            NM.clickMensMenubaritems(driver);
            logger.info("Howered mens menu");
            
            NM.ClickMensofShirts();
            logger.info("Clicked mens of shirts");
            Thread.sleep(5000L);
            
          //validate mens of shirts
            WebElement shirts = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofshirts = shirts.getText();
            String ExpectedTitleofshirts = "DRESS SHIRTS";
            logger.info(shirts.getText());
            if (ActualTitleofshirts.equals(ExpectedTitleofshirts)) {
                test.pass("Successfully clicked on the mens of  " + ActualTitleofshirts + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofshirts + " " + "  but found" + " " + ActualTitleofshirts + " ");
                logger.info("Click failed");
            }

            //soft assertions mens of shirts
//          
//          softAssert.assertEquals(ActualTitleofshirts, ExpectedTitleofshirts, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofshirts, ExpectedTitleofshirts, "Page title does not match expected value");
            
            test.info("verify that mens of jackets");
            
            NM.clickMensMenubaritems(driver);
            logger.info("Howered mens menu");
            
            NM.ClickMensofJackets();
            logger.info("Clicked mens of jackets");
            Thread.sleep(5000L);
            
            //validate mens of mensjackets
            WebElement mensjackets = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofmensjackets = mensjackets.getText();
            String ExpectedTitleofmensjackets = "JACKETS & COATS";
            logger.info(mensjackets.getText());
            if (ActualTitleofmensjackets.equals(ExpectedTitleofmensjackets)) {
                test.pass("Successfully clicked on the mens of  " + ActualTitleofmensjackets + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofmensjackets + " " + "  but found" + " " + ActualTitleofmensjackets + " ");
                logger.info("Click failed");
            }
            
            //soft assertions mens of jackets
//          
//          softAssert.assertEquals(ActualTitleofmensjackets, ExpectedTitleofmensjackets, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofmensjackets, ExpectedTitleofmensjackets, "Page title does not match expected value");
            
            test.info("verify that mens of shortss");

            NM.clickMensMenubaritems(driver);
            logger.info("Howered mens menu");
            
            NM.ClickMensofShorts();
            logger.info("Clicked mens of shortss");
            Thread.sleep(5000L);
            
          //validate mens of shortss
            WebElement shortss = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofshortss = shortss.getText();
            String ExpectedTitleofshortss = "SHORTS";
            logger.info(shortss.getText());
            if (ActualTitleofshortss.equals(ExpectedTitleofshortss)) {
                test.pass("Successfully clicked on the mens of  " + ActualTitleofshortss + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofshortss + " " + "  but found" + " " + ActualTitleofshortss + " ");
                logger.info("Click failed");
            }
            
            //soft assertions mens of shortss
//          
//          softAssert.assertEquals(ActualTitleofshortss, ExpectedTitleofshortss, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofshortss, ExpectedTitleofshortss, "Page title does not match expected value");
            
            test.info("verify that mens of Ties");

            NM.clickMensMenubaritems(driver);
            logger.info("Howered mens menu");
            
            NM.ClickMensofties();
            logger.info("Clicked mens of Ties");
            Thread.sleep(5000L);
            
          //validate mens of Ties
            WebElement Ties = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofTies = Ties.getText();
            String ExpectedTitleofTies = "TIES";
            logger.info(Ties.getText());
            if (ActualTitleofTies.equals(ExpectedTitleofTies)) {
                test.pass("Successfully clicked on the mens of  " + ActualTitleofTies + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofTies + " " + "  but found" + " " + ActualTitleofTies + " ");
                logger.info("Click failed");
            }
            
            //soft assertions mens of Ties
//          
//          softAssert.assertEquals(ActualTitleofTies, ExpectedTitleofTies, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofTies, ExpectedTitleofTies, "Page title does not match expected value");
            
            test.info("verify that mens of gloves");

            NM.clickMensMenubaritems(driver);
            logger.info("Howered mens menu");
            
            NM.ClickMensofgloves();
            logger.info("Clicked mens of gloves");
            Thread.sleep(5000L);
            
          //validate mens of gloves
            WebElement gloves = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofgloves = gloves.getText();
            String ExpectedTitleofgloves = "GLOVES";
            logger.info(gloves.getText());
            if (ActualTitleofgloves.equals(ExpectedTitleofgloves)) {
                test.pass("Successfully clicked on the mens of  " + ActualTitleofgloves + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofgloves + " " + "  but found" + " " + ActualTitleofgloves + " ");
                logger.info("Click failed");
            }
            
            //soft assertions mens of gloves
//          
//          softAssert.assertEquals(ActualTitleofgloves, ExpectedTitleofgloves, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofgloves, ExpectedTitleofgloves, "Page title does not match expected value");
           
            test.info("verify that mens of luggage");

            NM.clickMensMenubaritems(driver);
            logger.info("Howered mens menu");
            
            NM.ClickMensofluggage();
            logger.info("Clicked mens of luggage");
            Thread.sleep(5000L);
            
          //validate mens of luggage
            WebElement luggage = driver.findElement(By.xpath("//h1[@class ='page-title']"));
            String ActualTitleofluggage = luggage.getText();
            String ExpectedTitleofluggage = "LUGGAGE";
            logger.info(luggage.getText());
            if (ActualTitleofluggage.equals(ExpectedTitleofluggage)) {
                test.pass("Successfully clicked on the mens of  " + ActualTitleofluggage + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofluggage + " " + "  but found" + " " + ActualTitleofluggage + " ");
                logger.info("Click failed");
            }
            
            //soft assertions mens of luggage
//          
//          softAssert.assertEquals(ActualTitleofluggage, ExpectedTitleofluggage, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofluggage, ExpectedTitleofluggage, "Page title does not match expected value");
            
            test.info("verify that electronics of cameras");
            
            NM.clickelectronicsMenu(driver);
            logger.info("Howered electronics menu");
            
            NM.Clickelectronicsofcameras();
            logger.info("Clicked electronics of cameras");
            Thread.sleep(5000L);
            
          //validate electronics of cameras
            WebElement cameras = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
            String ActualTitleofcameras = cameras.getText();
            String ExpectedTitleofcameras = "DIGITAL CAMERAS";
            logger.info(cameras.getText());
            if (ActualTitleofcameras.equals(ExpectedTitleofcameras)) {
                test.pass("Successfully clicked on the electronics of  " + ActualTitleofcameras + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofcameras + " " + "  but found" + " " + ActualTitleofcameras + " ");
                logger.info("Click failed");
            }
            
            //soft assertions electronics of cameras
//          
//          softAssert.assertEquals(ActualTitleofcameras, ExpectedTitleofcameras, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofcameras, ExpectedTitleofcameras, "Page title does not match expected value");
            
            test.info("verify that electronics of gaming");

            NM.clickelectronicsMenu(driver);
            logger.info("Howered electronics menu");
            
            NM.ClickelectronicsofGaming();
            logger.info("Clicked electronics of gaming");
            Thread.sleep(5000L);
            
          //validate electronics of gaming
            WebElement gaming = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
            String ActualTitleofgaming = gaming.getText();
            String ExpectedTitleofgaming = "GAMING";
            logger.info(gaming.getText());
            if (ActualTitleofgaming.equals(ExpectedTitleofgaming)) {
                test.pass("Successfully clicked on the electronics of  " + ActualTitleofgaming + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofgaming + " " + "  but found" + " " + ActualTitleofgaming + " ");
                logger.info("Click failed");
            }
            
            //soft assertions electronics of gaming
//          
//          softAssert.assertEquals(ActualTitleofgaming, ExpectedTitleofgaming, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofgaming, ExpectedTitleofgaming, "Page title does not match expected value");
            
            test.info("verify that electronics of gpsunits");

            NM.clickelectronicsMenu(driver);
            logger.info("Howered electronics menu");
            
            NM.ClickelectronicsofGpsUnits();
            logger.info("Clicked electronics of gpsunits");
            Thread.sleep(5000L);
            
          //validate electronics of gpsunits
            WebElement gpsunits = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
            String ActualTitleofgpsunits = gpsunits.getText();
            String ExpectedTitleofgpsunits = "GPS NAVIGATION";
            logger.info(gpsunits.getText());
            if (ActualTitleofgpsunits.equals(ExpectedTitleofgpsunits)) {
                test.pass("Successfully clicked on the electronics of  " + ActualTitleofgpsunits + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofgpsunits + " " + "  but found" + " " + ActualTitleofgpsunits + " ");
                logger.info("Click failed");
            }
            
            //soft assertions electronics of gpsunits
//          
//          softAssert.assertEquals(ActualTitleofgpsunits, ExpectedTitleofgpsunits, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofgpsunits, ExpectedTitleofgpsunits, "Page title does not match expected value");
            
            test.info("verify that electronics of mediaplayers");

            NM.clickelectronicsMenu(driver);
            logger.info("Howered electronics menu");
            
            NM.Clickelectronicsofmediaplayers();
            logger.info("Clicked electronics of mediaplayers");
            Thread.sleep(5000L);
            
          //validate electronics of mediaplayers
            WebElement mediaplayers = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
            String ActualTitleofmediaplayers = mediaplayers.getText();
            String ExpectedTitleofmediaplayers = "IPOD & MP3 PLAYERS";
            logger.info(mediaplayers.getText());
            if (ActualTitleofmediaplayers.equals(ExpectedTitleofmediaplayers)) {
                test.pass("Successfully clicked on the electronics of  " + ActualTitleofmediaplayers + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofmediaplayers + " " + "  but found" + " " + ActualTitleofmediaplayers + " ");
                logger.info("Click failed");
            }
            
            //soft assertions electronics of mediaplayers
//          
//          softAssert.assertEquals(ActualTitleofmediaplayers, ExpectedTitleofmediaplayers, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofmediaplayers, ExpectedTitleofmediaplayers, "Page title does not match expected value");
            
            test.info("verify that electronics of Televisions");

            NM.clickelectronicsMenu(driver);
            logger.info("Howered electronics menu");
            
            NM.ClickelectronicsofTelevisions(driver);
            logger.info("Clicked electronics of Televisions");
            Thread.sleep(5000L);
            
          //validate electronics of Televisions
            WebElement Televisions = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
            String ActualTitleofTelevisions = Televisions.getText();
            String ExpectedTitleofTelevisions = "TELEVISIONS";
            logger.info(Televisions.getText());
            if (ActualTitleofTelevisions.equals(ExpectedTitleofTelevisions)) {
                test.pass("Successfully clicked on the electronics of  " + ActualTitleofTelevisions + " ");
                logger.info("click Success Womens of Dresses");
            } else {
                test.fail("The page Title does not match expected " + ExpectedTitleofTelevisions + " " + "  but found" + " " + ActualTitleofTelevisions + " ");
                logger.info("Click failed");
            }
            
            //soft assertions electronics of Televisions
//          
//          softAssert.assertEquals(ActualTitleofTelevisions, ExpectedTitleofTelevisions, "Page title does not match expected value");
//          
//          //Hard assertions womens of tops
//          
//          Assert.assertEquals(ActualTitleofTelevisions, ExpectedTitleofTelevisions, "Page title does not match expected value");
            
            test.info("verify that Topsellers menu");

            NM.clickTopsellerMenu(driver);
            logger.info("Howered Topsellers menu");
            test.pass("successfully clicked on the top sellers");
            

        
        // Assert all the soft assertions
        //softAssert.assertAll();

    }
}