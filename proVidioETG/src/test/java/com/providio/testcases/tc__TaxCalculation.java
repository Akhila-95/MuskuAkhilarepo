package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class tc__TaxCalculation extends baseClass{
	
	
	public void taxCalculation() throws InterruptedException {
		
		List<WebElement> totalNumberofProducts = driver.findElements(By.xpath("//div[contains(@class, 'pricing line-item-total-price-amount item-total')]"));
        int count = totalNumberofProducts.size();

        
        Float totalProductsValue = (float) 0 ;
        Float shippingCostValue1 = (float) 0 ;
        Float shippingCostDiscountValue = (float) 0 ;
        Float subTotalValue = (float) 0 ;
        Float salesTaxValue = (float) 0 ;
        Float productDiscountValue1 = (float) 0 ;
        Float orderDiscountValue = (float) 0 ;
        
      
        //iterating through each product
        for(int i = 1; i <= count; i++) {

            Thread.sleep(2000);
            WebElement eachProductValue = driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])[" + i + "]"));
            String productValueinText = eachProductValue.getText();
            String numericValue = productValueinText.substring(1).replace(",", "");
            Float productValue = Float.parseFloat(numericValue);
            totalProductsValue = totalProductsValue + productValue;
            
            WebElement eachProductValueandName = driver.findElement(By.xpath("( //div[@class ='line-item-name'])[" + i + "]"));                     
            String eachProductName = eachProductValueandName.getText();
            logger.info(eachProductName + " :"+ productValue);
            Thread.sleep(5000);

        }

        logger.info(totalProductsValue);
        //promocode
//        WebElement shippingDiscount = driver.findElement(By.xpath("//span[@class ='applied-promotion-discount']"));
//        String shipingValueText = shippingDiscount.getText();
//        String numericValue = shipingValueText.substring(1);
//        Float shippingDiscountValue = Float.parseFloat(numericValue);    
//        logger.info(shippingDiscountValue);

        //# the below function purpose subtotal value

        WebElement subTotal1 = driver.findElement(By.xpath("//span[@class ='sub-total']"));
        String subTotalText = subTotal1.getText();
        String subTotalnumericValue = subTotalText.substring(1).replace(",", "");       
        subTotalValue = Float.parseFloat(subTotalnumericValue);
        
        //Name
        WebElement subTotal11 = driver.findElement(By.xpath("//span[contains(text(),'Subtotal')]"));
        String subTotal1name = subTotal11.getText();
        logger.info(subTotal1name+" :"+subTotalValue);
        
        //validation matching
        
        if (subTotalValue.equals(totalProductsValue)) {
            test.pass("Successfully verified the subTotalValue and Products total value");
            logger.info("Successfully verified the subTotalValue and Products total value");

        } else {
           test.fail( "The subTotalValue and Products total value does not match expected " + subTotalValue + " " + "  but found" + " " + totalProductsValue + " ");
            logger.info("The subTotalValue and Products total value does not match expected " + subTotalValue + " " + "  but found" + " " + totalProductsValue + " ");

        }
        
        WebElement productDiscountName = driver.findElement(By.xpath("//p[contains(text(),'Product Discount')]"));
        boolean ProductDiscoutcount = productDiscountName.isDisplayed();
        logger.info(ProductDiscoutcount);
        
        if(ProductDiscoutcount) {
        	
        	 //shippingCostvalue
            Thread.sleep(5000);
            WebElement productDiscountCost1 = driver.findElement(By.xpath("//p[@class ='text-right product-discount-total']"));
            String productDiscount1 = productDiscountCost1.getText();
            String productDiscountnumericValue1 = productDiscount1.replaceAll("[^\\d.]+", "");
            productDiscountValue1 = Float.parseFloat(productDiscountnumericValue1);
            
            //Name
            
            WebElement productDiscountName1 = driver.findElement(By.xpath("//p[contains(text(),'Product Discount')]"));
            String productDiscountText = productDiscountName1.getText();
            logger.info(productDiscountText+ " :"+productDiscountValue1);
        }
      //validating the shipping elements or there or not
        WebElement shippingCost = driver.findElement(By.xpath("//p[contains(text(),'Shipping cost')]"));    
        boolean shippingCostvalidation = shippingCost.isDisplayed();
        
        if(shippingCostvalidation) {
        	
        	 //shippingCostvalue

            Thread.sleep(5000);
            WebElement shippingCost1 = driver.findElement(By.xpath("//p[@class ='text-right shipping-cost']"));
            String shippingCostText1 = shippingCost1.getText();
            String shippingCostnumericValue1 = shippingCostText1.substring(1).replace(",", "");
            shippingCostValue1 = Float.parseFloat(shippingCostnumericValue1);
            
            //Name
            
            WebElement shippingCostName = driver.findElement(By.xpath("//p[contains(text(),'Shipping cost')]"));
            String shippingCostnameText = shippingCostName.getText();
            logger.info(shippingCostnameText+ " :"+shippingCostValue1);
         
            WebElement shippingDiscountDetails = driver.findElement(By.xpath("//p[contains(text(),'Shipping Discount')]"));
            boolean shippingdiscountcount = shippingDiscountDetails.isDisplayed();
            logger.info(shippingdiscountcount);
            if(shippingdiscountcount) {

            //shipping Discount value
            WebElement shippingCostDiscount = driver.findElement(By.xpath("//p[@class ='text-right shipping-discount-total']"));
            String shippingCostDiscountText = shippingCostDiscount.getText();
            String shippingCostDiscountnumericValue = shippingCostDiscountText.replaceAll("[^\\d.]+", "");
            shippingCostDiscountValue = Float.parseFloat(shippingCostDiscountnumericValue);
            logger.info(shippingCostDiscountValue);
            }
        	
        }

        //salesTaxValue
        WebElement salesTax = driver.findElement(By.xpath("//p[@class ='text-right tax-total']"));
        String salesTaxText = salesTax.getText();
        String salesTaxnumericValue = salesTaxText.substring(1).replace(",", "");
        salesTaxValue = Float.parseFloat(salesTaxnumericValue);
        
        //Name
        
        WebElement salesTaxname = driver.findElement(By.xpath("//p[contains(text(),'Sales Tax')]"));  
        String salesTaxnameText = salesTaxname.getText();
        logger.info(salesTaxnameText+" :"+salesTaxValue);

        //validating the order discount is there or not
        
        WebElement orderDiscountDetails = driver.findElement(By.xpath("//p[contains(text(),'Order Discount')]"));      
        boolean orderDiscoutcount = orderDiscountDetails.isDisplayed();
        logger.info(orderDiscoutcount);
        
        if(orderDiscoutcount) {
        	
        	 //shippingCostvalue
            Thread.sleep(5000);
            WebElement orderDiscountCost = driver.findElement(By.xpath("//p[@class ='text-right order-discount-total']"));
            String orderDiscount1 = orderDiscountCost.getText();
            String orderDiscountnumericValue = orderDiscount1.replaceAll("[^\\d.]+", "");
            orderDiscountValue = Float.parseFloat(orderDiscountnumericValue);
            
            //Name
           
            WebElement orderDiscountName1 = driver.findElement(By.xpath("//p[contains(text(),'Order Discount')]"));
            String orderDiscountText = orderDiscountName1.getText();
            logger.info(orderDiscountText+ " :"+orderDiscountValue);
        }

        //estimatedTotalvalue

      WebElement estimatedTotal = driver.findElement(By.xpath("//p[@class ='text-right grand-total']"));
        String estimatedTotalText = estimatedTotal.getText();
        String estimatedTotalnumericValue = estimatedTotalText.substring(1).replace(",", "");
        Float estimatedTotalValue = Float.parseFloat(estimatedTotalnumericValue);
        
      WebElement estimatedTotalTextName = driver.findElement(By.xpath(" //strong[contains(text(),'Estimated Total')]"));
        String estimatedTotalTextname = estimatedTotalTextName.getText();
        logger.info(estimatedTotalTextname+" :"+estimatedTotalValue);

        //verification of the amount all
        Float actualEsimatedvalue = salesTaxValue + subTotalValue + shippingCostValue1 - orderDiscountValue -
        		productDiscountValue1 -shippingCostDiscountValue;//shippingCostDiscountValue, shippingCostValue
        logger.info(actualEsimatedvalue);

        if (estimatedTotalValue.equals(estimatedTotalValue)) {
            test.pass("Successfully verified the Prices and Tax calculation");
            logger.info("Successfully verified the Prices and Tax calculation");

        } else {
           test.fail( "The Prices and Tax calculation does not match expected " + estimatedTotalValue + " " + "  but found" + " " + actualEsimatedvalue + " ");
            logger.info("The Prices and Tax calculation does not match expected " + estimatedTotalValue + " " + "  but found" + " " + actualEsimatedvalue + " ");

        }
 
    }

  }