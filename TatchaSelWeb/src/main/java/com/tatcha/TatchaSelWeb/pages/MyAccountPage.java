package com.tatcha.TatchaSelWeb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class MyAccountPage extends TestBase {
	
	
	
	public String accountCreationAlert() {
		
		WebElement AccountConfirmation = driver.findElement(By.xpath("//*[@id=\"account-creation-success\"]/div[2]\n"));
		return AccountConfirmation.getAttribute("innerText").trim();

	}
	
	
	
}


