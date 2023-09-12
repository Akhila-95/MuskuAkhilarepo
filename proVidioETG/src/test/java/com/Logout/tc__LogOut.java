package com.Logout;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.logOut;
import com.providio.pageObjects.profilePage;
import com.providio.testcases.baseClass;

 

public class tc__LogOut extends baseClass {

    SoftAssert softAssert = new SoftAssert();

    @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void Logout() throws InterruptedException {
        if (isLoggedIn) {
            profilePage pp1 = new profilePage(driver);
            pp1.howeraccount(driver);
            logOut lo = new logOut(driver);
            logger.info("Hovered the myaccout");
            Thread.sleep(10000L);
            lo.clicklogout(driver);
            logger.info("clicked the logout button and successfully logged out");
            String expectedTitlelogout = "Sites-RefArch-Site";
            String actualTitlelogout = driver.getTitle();
            if (actualTitlelogout.equals(expectedTitlelogout)) {
                test.pass("Successfully clicked on the Logout button");
                logger.info("User logged out successfully");
            } else {
                test.fail("The page Title does not match expected " + expectedTitlelogout + " but found " + actualTitlelogout);
                logger.info("Click failed");
            }

 

            // Assert all the soft assertions
            softAssert.assertAll();
        } else {
            Assert.fail("User not logged in");
        }
    }
}

 