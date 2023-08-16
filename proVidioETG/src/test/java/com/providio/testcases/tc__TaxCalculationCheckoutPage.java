package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class tc__TaxCalculationCheckoutPage extends baseClass{
	
	public void taxCalculation() throws InterruptedException {
	
	List<WebElement> totalNumberofProducts = driver.findElements(By.xpath("//div[contains(@class, 'pricing line-item-total-price-amount item-total')]"));
    int count = totalNumberofProducts.size();
    
    logger.info(count);
    
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

//    WebElement shippingDiscount = driver.findElement(By.xpath("//span[@class ='applied-promotion-discount']"));

//    String shipingValueText = shippingDiscount.getText();

//    String numericValue = shipingValueText.substring(1);

//    Float shippingDiscountValue = Float.parseFloat(numericValue);
 
//    logger.info(shippingDiscountValue);

    //# the below function purpose subtotal value
    
    //Name
    WebElement subTotal11 = driver.findElement(By.xpath("//span[contains(text(),'Subtotal')]"));
    String subTotal1name = subTotal11.getText();
    logger.info(subTotal1name+" :"+subTotalValue);
    //value
    WebElement subTotal1 = driver.findElement(By.xpath("//span[@class ='sub-total']")); 
    String subTotalText = subTotal1.getText();
    String subTotalnumericValue = subTotalText.substring(1).replace(",", "");
    subTotalValue = Float.parseFloat(subTotalnumericValue);

    //validation matching
    
    if (subTotalValue.equals(totalProductsValue)) {
        test.pass("Successfully verified the subTotalValue and Products total value");
        logger.info("Successfully verified the subTotalValue and Products total value");
    } else {
       test.fail( "The subTotalValue and Products total value does not match expected " + subTotalValue + " " + "  but found" + " " + totalProductsValue + " ");
        logger.info("The subTotalValue and Products total value does not match expected " + subTotalValue + " " + "  but found" + " " + totalProductsValue + " ");
    }

    //product discount value
    //#Below fucntion is to calculate the count of the number of productdiscounts are there because if 0 means not excuting the code greater one means excute
    List<WebElement> productDiscountNamesize = driver.findElements(By.xpath("//p[contains(text(),'Product Discount')]"));
    List<WebElement> checkout = driver.findElements(By.xpath("//a[contains(@class,'btn btn-primary btn')]"));
    int productDiscountNamesizecount = productDiscountNamesize.size();
    logger.info(productDiscountNamesizecount);

    if(productDiscountNamesizecount>0) {
    	 //productDiscountCost1
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

    List<WebElement> shippingCost = driver.findElements(By.xpath("//span[contains(text(),'Shipping')]"));
    int shippingCostvalidation = shippingCost.size();
    logger.info(shippingCostvalidation);
    
    if(shippingCostvalidation>0) {
    	
    //shippingCostvalue	
        Thread.sleep(5000);
        WebElement shippingCost1 = driver.findElement(By.xpath("//span[@class ='shipping-total-cost']"));
        String shippingCostText1 = shippingCost1.getText();
        String shippingCostnumericValue1 = shippingCostText1.substring(1).replace(",", "");
        shippingCostValue1 = Float.parseFloat(shippingCostnumericValue1);
        
     //Name
        WebElement shippingCostName = driver.findElement(By.xpath("//span[contains(text(),'Shipping')]"));    
        String shippingCostnameText = shippingCostName.getText();
        logger.info(shippingCostnameText+ " :"+shippingCostValue1);
        
        
        List<WebElement> shippingDiscountDetails = driver.findElements(By.xpath("//span[contains(text(),'Shipping Discount')]"));
        int shippingdiscountcount = shippingDiscountDetails.size();
        logger.info(shippingdiscountcount);

        
		        if(shippingdiscountcount>0) {
		        //shipping Discount value
		        
		        WebElement shippingCostDiscount = driver.findElement(By.xpath("//span[@class ='shipping-discount-total']"));
		        String shippingCostDiscountText = shippingCostDiscount.getText();
		        String shippingCostDiscountnumericValue = shippingCostDiscountText.replaceAll("[^\\d.]+", "");
		        shippingCostDiscountValue = Float.parseFloat(shippingCostDiscountnumericValue);
		        
		      //Name
		        WebElement shippingdiscountname = driver.findElement(By.xpath("//span[contains(text(),'Shipping Discount')]"));    
		        String shippingdiscountnameText = shippingdiscountname.getText();
		        logger.info(shippingdiscountnameText+ " :"+shippingCostDiscountValue);
		    	
		       }
     }    
    
    //salesTaxValue

    WebElement salesTax = driver.findElement(By.xpath("//span[@class ='tax-total']"));
    String salesTaxText = salesTax.getText();
    String salesTaxnumericValue = salesTaxText.substring(1).replace(",", "");
    salesTaxValue = Float.parseFloat(salesTaxnumericValue);
    
    //Name
    
    WebElement salesTaxname = driver.findElement(By.xpath("//span[contains(text(),'Sales Tax')]"));
    String salesTaxnameText = salesTaxname.getText();
    logger.info(salesTaxnameText+" :"+salesTaxValue);
     
    //validating the order discount is there or not
    
    List<WebElement> orderDiscountDetails = driver.findElements(By.xpath("//p[contains(text(),'Order Discount')]"));
    int orderDiscoutcount = orderDiscountDetails.size();
    logger.info(orderDiscoutcount);
    
    if(orderDiscoutcount>0) {
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

    WebElement estimatedTotal = driver.findElement(By.xpath("//span[@class ='grand-total-sum']"));
    String estimatedTotalText = estimatedTotal.getText();
    String estimatedTotalnumericValue = estimatedTotalText.substring(1).replace(",", "");
    Float estimatedTotalValue = Float.parseFloat(estimatedTotalnumericValue);  
    
   WebElement estimatedTotalTextName = driver.findElement(By.xpath(" //span[contains(text(),'Total')]"));
    String estimatedTotalTextname = estimatedTotalTextName.getText();
    logger.info(estimatedTotalTextname+" :"+estimatedTotalValue);

   //verification of the amount all
    Float actualEsimatedvalue = salesTaxValue + subTotalValue + shippingCostValue1 - orderDiscountValue -
    		productDiscountValue1 -shippingCostDiscountValue;//shippingCostDiscountValue, shippingCostValue
    logger.info(actualEsimatedvalue);

    if (actualEsimatedvalue.equals(estimatedTotalValue)) {
        test.pass("Successfully verified the Prices and Tax calculation");
        logger.info("Successfully verified the Prices and Tax calculation");
    } else {
       test.fail( "The Prices and Tax calculation does not match expected " + estimatedTotalValue + " " + "  but found" + " " + actualEsimatedvalue + " ");
        logger.info("The Prices and Tax calculation does not match expected " + estimatedTotalValue + " " + "  but found" + " " + actualEsimatedvalue + " ");
    }

    
}

	}
	

