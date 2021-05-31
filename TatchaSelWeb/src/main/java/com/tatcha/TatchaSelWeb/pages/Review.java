package com.tatcha.TatchaSelWeb.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class Review extends TestBase{
	
	public void placeOrder() {
		driver.findElement(By.xpath("//*[@id='reviewCollapse']/form/button")).click();
	}

	
	public void guestReview() {
		driver.findElement(By.id("internationalDutiesNotification")).click();
		driver.findElement(By.xpath("//*[@id='reviewCollapse']/form/button")).click();
	}
	
	public void editAddress() {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id='contact-section-heading']/a")).click();
	}

	
}
