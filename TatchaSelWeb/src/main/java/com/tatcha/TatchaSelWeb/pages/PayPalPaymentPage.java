package com.tatcha.TatchaSelWeb.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class PayPalPaymentPage extends TestBase {

	public void paypalPaymentDetails(String email, String password) {

		// to find out how many windows are needed
		Set<String> windowNumber = driver.getWindowHandles();
		System.out.println(windowNumber + "windowNumber");
		Iterator<String> it = windowNumber.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys("tavinash+tatcha@gmail.com");
		driver.findElement(By.xpath("//*[@id='btnNext']")).click();
		driver.findElement(By.id("password")).sendKeys("admin@123");
		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("//*[@id='acceptAllButton']"))).click();	

	//	driver.findElement(By.xpath("//*[@id='acceptAllButton']")).click();

		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("//*[@id='acceptAllButton']"))).click();	
	
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			JavascriptExecutor js = (JavascriptExecutor)driver;
////			 // if the element is on top.
//			js.executeScript("scroll(0, 250)");

		}		
//		WebElement element = driver.findElement(By.id("payment-submit-btn"));
//
//		Actions actions = new Actions(driver);
//
//		actions.moveToElement(element).click().perform();
		WebElement element = driver.findElement(By.id("payment-submit-btn"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			JavascriptExecutor js = (JavascriptExecutor)driver;
////			 // if the element is on top.
//			js.executeScript("scroll(0, 250)");

		}	
		driver.switchTo().window(parentId);
		

	}
}

//id="payment-submit-btn"