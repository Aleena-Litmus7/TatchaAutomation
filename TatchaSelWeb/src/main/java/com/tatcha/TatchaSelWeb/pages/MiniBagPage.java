package com.tatcha.TatchaSelWeb.pages;

import org.openqa.selenium.By;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class MiniBagPage extends TestBase {

	
	
	
	public void goToBag() {
		
		driver.findElement(By.xpath("//*[@id=\"minibag-container-wrap\"]/div[2]/div[3]/div[2]/a")).click();

}
	
	public void goToBagGC() {

		driver.findElement(By.cssSelector("#minibag-container-wrap > div.checkout-section.text-center.pt-4 > div.pt-2 > a")).click();

		
}
}