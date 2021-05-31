package com.tatcha.TatchaSelWeb.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class LoginPage extends TestBase {

	// VALIDATE EMPTY PASSWORD ALERT//

	public String emptyPasswrdAlert() {
		WebElement emptypasswrdalert = driver.findElement(By.id("dwfrm_login_password-error"));
		return emptypasswrdalert.getText();
	}

	// VALIDATE INVALID PASSWORD ALERT//

	public String invalPasswrdAlert() {

		WebElement element = webDriverWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-modal-error")));
		return element.getText();

	}

	public void enterLoginDetails(String email, String password) {

		driver.findElement(By.name("dwfrm_login_username")).sendKeys(email);
		driver.findElement(By.name("dwfrm_login_password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login-btn']")).click();

	}

	public void createAccountClick() {
		driver.findElement(By.linkText("Create An Account")).click();

	}

	public void loginFBClick() {
		driver.findElement(By.xpath("//*[@id=\"loginModal\"]/div/div/div[2]/div[4]/a")).click();

	}
}