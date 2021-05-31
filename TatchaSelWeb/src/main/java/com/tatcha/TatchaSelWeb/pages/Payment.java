package com.tatcha.TatchaSelWeb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class Payment extends TestBase {
	
	public void getPayment(String cardname,String cardnumber,String expiration,String cvv) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 4500)");
		driver.findElement(By.id("braintreeCardOwner")).sendKeys(cardname);
		driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-number")));
		driver.findElement(By.id("credit-card-number")).sendKeys(cardnumber);
		 driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-expirationDate")));
		driver.findElement(By.id("expiration")).sendKeys(expiration);
		 driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-cvv")));
		driver.findElement(By.id("cvv")).sendKeys(cvv);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id='dwfrm_billing']/div/button")).click();;
	}
	
	
	public void redeemGiftCard (String giftcard) {
		
		driver.findElement(By.xpath("//*[@id=\"checkout-gift-card-block\"]/div/a")).click();;

		driver.findElement(By.xpath("//*[@id=\"dwfrm_billing_giftCertCode\"]")).sendKeys(giftcard);;
		driver.findElement(By.xpath("//*[@id=\"add-giftcert\"]")).click();;
		

}


}
