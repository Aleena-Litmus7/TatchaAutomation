package com.tatcha.TatchaSelWeb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class HomePage extends TestBase {

	public String getSalutation() {
		WebElement salutation = driver
				.findElement(By.xpath("//*[@id=\"navigation\"]/ul[4]/li[3]/div/ul/li/button[1]"));
		return salutation.getAttribute("innerText").trim();

	}

	//*[@id="navigation"]/ul[4]/li[3]/div/ul/li/button[1]
	
	
	//LOGOUT SUCCESS//
	
	
	
}

