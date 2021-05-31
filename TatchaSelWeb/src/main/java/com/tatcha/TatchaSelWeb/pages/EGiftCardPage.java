package com.tatcha.TatchaSelWeb.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class EGiftCardPage extends TestBase {

	/** Giftcard STEP1 Details */

	public void enterGiftCardDetails(String RecipientsFn, String SendersFn) {

		Select drpAmount = new Select(driver.findElement(By.name("giftCertAmount")));
		drpAmount.selectByVisibleText("$500");

		driver.findElement(By.id("recipientName")).sendKeys(RecipientsFn);
		driver.findElement(By.id("senderName")).sendKeys(SendersFn);

		driver.findElement(By.xpath("//*[@id=\"giftGertStep1Next\"]")).click();

	}

	/**
	 * Giftcard STEP2 Details
	 * 
	 * @throws
	 */

	public void addRecommendations() {
		driver.findElement(By.xpath("//*[@id=\"selections\"]/div[1]/a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("label-SB10049T")).click();
		waitForElementNotVisible(10, driver, "/html/body/div[3]");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id("giftGertStep2Next"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public static String waitForElementNotVisible(int timeOutInSeconds, WebDriver driver, String id) {
		if ((driver == null) || (id == null) || id.isEmpty()) {

			return "Wrong usage of WaitforElementNotVisible()";
		}
		try {
			(new WebDriverWait(driver, timeOutInSeconds))
					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(id)));
			return null;
		} catch (TimeoutException e) {
			return "Build your own errormessage...";
		}
	}

	/** Giftcard STEP3 Details */

	public void deliver(String rcpnEmail, String sendrEmail) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("recipientEmail")).sendKeys(rcpnEmail);
		driver.findElement(By.xpath("//*[@id=\"senderEmail\"]")).sendKeys(sendrEmail);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		WebElement element = driver.findElement(By.xpath("//*[@id=\"saveGiftCertData\"]"));
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", element);
//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"saveGiftCertData\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"minibag-container-wrap\"]/div[2]/div[2]/a")).click();

	}

	// balance error- This card has no sufficient balance
//	giftcert-error error-Gift Certificate "VZYCHTLTLARJFLQSx" could not be found.

}
