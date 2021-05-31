package com.tatcha.TatchaSelWeb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class LandingPage extends TestBase {

	// LOGIN CLICK//
	public void clickLogin() {
		driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul[4]/li[3]/div/ul/li/button[1]/span")).click();
	}

	// ADD TO CART//

	public void addToCart() {
		driver.findElement(By.xpath("//*[@id=\"homepage\"]/div/div[3]/div/div/div/div/div[3]/div/div[3]/button"))
				.click();
	}

	public void moveToShop() {

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul[1]/li[1]/a"));
		action.moveToElement(we)
				.moveToElement(
						driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul[1]/li[1]/div[2]/div/div/div[1]/div/a")))
				.click().build().perform();

	}

	public void moveToExclusive() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul[1]/li[4]/a"));
		action.moveToElement(we)
				.moveToElement(
						driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul[1]/li[4]/div[2]/div/div[5]/a/img")))
				.click().build().perform();

	}

}