package com.tatcha.TatchaSelWeb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class ShopAllPage extends TestBase{


	public void addToCart() {
		List<WebElement> items = driver.findElements (By.xpath ("//*[contains(text(),'Add to Bag -')]"));
		items.get(0).click();
	
}



}