package com.tatcha.TatchaSelWeb.pages;

import org.openqa.selenium.By;

import com.tatcha.TatchaSelWeb.base.TestBase;

public class LoginWithFBPage extends TestBase {
	
	public void loginFB() {
	
	
		driver.findElement(By.xpath("//*[@id=\"email_container\"]")).sendKeys(prop.getProperty("FBemail"));
		driver.findElement(By.xpath("//*[@id=\"pass\"]]")).sendKeys(prop.getProperty("FBpassword"));

	

}
}