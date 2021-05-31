package com.tatcha.TatchaSelWeb.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class ShippingPage extends TestBase{

	public void guestUS(String email,String firstname,String lastname,String country,String address1,String zipcode,String state,String city,String phone) {
		driver.findElement(By.id("guestEmail")).sendKeys(email);;
		driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName")).sendKeys(firstname);;
		driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_lastName")).sendKeys(lastname);;
		Select dropdown1 = new Select(driver.findElement(By.id("country")));
		dropdown1.selectByVisibleText(country);
		driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).sendKeys(address1);;
		driver.findElement(By.className("enter-address-link")).click();

		driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_postal")).sendKeys(zipcode);;
		 Select dropdown2 = new Select(driver.findElement(By.id("state")));
		 dropdown2.selectByVisibleText(state);
		driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_city")).sendKeys(city);;
		driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_phone")).sendKeys(phone);;
		driver.findElement(By.xpath("//*[@id='dwfrm_singleshipping_shippingAddress']/div[2]/button")).click();;
	}
	
	
	
public void loginExprsCheckout() {
		
	
		webDriverWait
				.until(ExpectedConditions.elementToBeClickable(By.id("checkoutshippinglogin"))).click();
		//element.click();
}





public void guestIndian(String email,String firstname,String lastname,String address1,String address2,String zipcode,String state,String city,String phone) {
	
	
	driver.findElement(By.id("guestEmail")).sendKeys(email);
	driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName")).sendKeys(firstname);
	driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_lastName")).sendKeys(lastname);
	driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).sendKeys(address1);
	driver.findElement(By.className("enter-address-link")).click();
	driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address2")).sendKeys(address2);
	driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_postal")).sendKeys(zipcode);
	driver.findElement(By.id("stateText")).sendKeys(state);
	driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_city")).sendKeys(city);;
	driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_phone")).sendKeys(phone);;
	driver.findElement(By.xpath("//*[@id='dwfrm_singleshipping_shippingAddress']/div[2]/button")).click();;
}		



public void billingAddress(String country,String streetaddress1,String streetaddress2,String zipcode,String province,String city) {

	Select dropdown1 = new Select(driver.findElement(By.id("dwfrm_billing_billingAddress_addressFields_country")));
	dropdown1.selectByVisibleText(country);
	driver.findElement(By.id("dwfrm_billing_billingAddress_addressFields_address1")).sendKeys(streetaddress1);;
	driver.findElement(By.className("enter-billing-address-link")).click();
	driver.findElement(By.name("dwfrm_billing_billingAddress_addressFields_address2")).sendKeys(streetaddress2);;
	driver.findElement(By.id("dwfrm_billing_billingAddress_addressFields_postal")).sendKeys(zipcode);;
	 Select dropdown2 = new Select(driver.findElement(By.id("billingStateSelect")));
	 dropdown2.selectByVisibleText(province);
		driver.findElement(By.name("dwfrm_billing_billingAddress_addressFields_city")).sendKeys(city);;

}
}


