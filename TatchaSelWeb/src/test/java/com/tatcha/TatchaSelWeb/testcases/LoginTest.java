package com.tatcha.TatchaSelWeb.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tatcha.TatchaSelWeb.base.TestBase;
import com.tatcha.TatchaSelWeb.pages.HomePage;
import com.tatcha.TatchaSelWeb.pages.LandingPage;
import com.tatcha.TatchaSelWeb.pages.LoginPage;
import com.tatcha.TatchaSelWeb.util.TestUtil;

/**
 * Loginvalidation
 */

public class LoginTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	LandingPage landingPage;

	@BeforeMethod
	public void setUp() {

		init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/LoginTest.properties");
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		landingPage = new LandingPage();
	}

	
	

	@Test
	public void login() {

		try {
			// landingPage.closeCookies();
			landingPage.clickLogin();
			loginPage.enterLoginDetails(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(5000);
			AssertJUnit.assertEquals(homePage.getSalutation(), "Hi, " + prop.getProperty("welcome_name"));

		} catch (Exception exception) {

			Assert.fail(exception.getMessage());

		}
	}

	@Test
	public void emptyPasswrd() {

		try {
			// landingPage.closeCookies();
			landingPage.clickLogin();
			loginPage.enterLoginDetails(prop.getProperty("email"), "");
			Thread.sleep(5000);
			AssertJUnit.assertEquals(loginPage.emptyPasswrdAlert(), prop.getProperty("emptypasswrdalert"));

		} catch (Exception exception) {

			Assert.fail(exception.getMessage());
		}
	}

	@Test
	public void invalPasswrd() {

		try {
			// landingPage.closeCookies();
			landingPage.clickLogin();
			loginPage.enterLoginDetails(prop.getProperty("email"), "123");
			AssertJUnit.assertEquals(loginPage.invalPasswrdAlert(), prop.getProperty("invalidpasswrdalert"));

		} catch (Exception exception) {

			Assert.fail(exception.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
