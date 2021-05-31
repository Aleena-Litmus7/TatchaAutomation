package com.tatcha.TatchaSelWeb.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class MyShoppingBag extends TestBase {

	
	WebElement checkoutButton=driver.findElement(By.name("dwfrm_cart_checkoutCart"));
	WebElement autoDeliverycheckBox=driver.findElement(By.name("dwfrm_smartorderrefill_hasSmartOrderRefill"));
	WebElement promoTextBox=driver.findElement(By.id("dwfrm_cart_couponCode"));
	WebElement promoApplyButton=driver.findElement(By.id("add-coupon"));
	WebElement qtyDropDown=driver.findElement(By.name("dwfrm_cart_shipments_i0_items_i0_quantity"));
	// GO TO SHIPPING BUTTON CLICK//

	public void goToShipping() {

		checkoutButton.click();
	}

	public void checkboxAd() {
		autoDeliverycheckBox.click();
	}

	public void applypromo() {
		promoTextBox.sendKeys("WELCOME20");
		promoApplyButton.click();

	}

	public void getSample() {
		driver.findElement(By.id("bonusModalLink")).click();
		driver.findElement(By.xpath("//*[@id='item-2213a6598f279fc3063631ed69']/div/div[2]/button")).click();

		driver.findElement(By.id("submit-sample-items")).click();
	}

	public void updateQuantity() {

		Select updateQuantity = new Select(qtyDropDown);
		updateQuantity.selectByVisibleText("5");
	}

	public void clickPayPal() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-otherpayment-button"))).click();	
	}

}
