package com.tatcha.TatchaSelWeb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class ConfirmationPage extends TestBase{
	
     
	WebElement loginPassword = driver.findElement(By.id("dwfrm_profile_login_password"));
	WebElement loginConfirmPassword = driver.findElement(By.id("dwfrm_profile_login_passwordconfirm"));
   
	public void guestReg(String pass,String confirmpass) {
		

		loginPassword.sendKeys(prop.getProperty("reg_password"));
		loginConfirmPassword.sendKeys(prop.getProperty("reg_confirmpass"));
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/div[3]/div[1]/div[2]/form/button[2]")).click();

		
	}
	
	
	public String getOrderConfirmation() {
		
		WebElement OrderConfirmation = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/div[1]/div[1]"));
		return OrderConfirmation.getAttribute("innerText").trim();
		
		
		
		
	}


}





