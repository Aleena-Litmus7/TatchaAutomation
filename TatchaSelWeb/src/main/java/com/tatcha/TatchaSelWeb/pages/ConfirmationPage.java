package com.tatcha.TatchaSelWeb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class ConfirmationPage extends TestBase{
	
	
	public void guestReg(String pass,String confirmpass) {
		

		driver.findElement(By.id("dwfrm_profile_login_password")).sendKeys(prop.getProperty("newpassword"));

		driver.findElement(By.id("dwfrm_profile_login_passwordconfirm")).sendKeys(prop.getProperty("confirmpassword"));

		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/div[3]/div[1]/div[2]/form/button[2]")).click();

		
	}
	
	
	public String getOrderConfirmation() {
		
		WebElement OrderConfirmation = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/div[1]/div[1]"));


		return OrderConfirmation.getAttribute("innerText").trim();
		
		
		
		
	}


}





