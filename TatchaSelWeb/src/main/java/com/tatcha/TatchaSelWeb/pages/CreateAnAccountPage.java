package com.tatcha.TatchaSelWeb.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class CreateAnAccountPage extends TestBase {

	public void createAnAccount(String firstname, String lastname, String newemail, String password,
			String confirmpassword) {

		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_customer_firstname\"]\n")).sendKeys(firstname);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_customer_lastname\"]")).sendKeys(lastname);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#dwfrm_profile_customer_email")).sendKeys(newemail);
		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_login_password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_login_passwordconfirm\"]")).sendKeys(confirmpassword);
		driver.findElement(By.xpath("//*[@id=\"registerBtn\"]")).click();

	}

	public void clearFields() {
		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_customer_firstname\"]\n")).clear();

		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_customer_lastname\"]")).clear();

		driver.findElement(By.cssSelector("#dwfrm_profile_customer_email")).clear();
		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_login_password\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_login_passwordconfirm\"]")).clear();

	}

	public boolean isConfirmPwErrorDisplayed() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return driver.findElement(By.id("dwfrm_profile_login_passwordconfirm-error")).isDisplayed();
	}

	public boolean isPasswordErrorDisplayed() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return driver.findElement(By.id("dwfrm_profile_login_password-error")).isDisplayed();
	}

	public boolean isAlreadyRegUser() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement we = driver.findElement(By.linkText("Please login"));
		return we.isDisplayed();
	}

}