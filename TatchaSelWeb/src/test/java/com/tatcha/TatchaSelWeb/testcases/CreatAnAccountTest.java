package com.tatcha.TatchaSelWeb.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tatcha.TatchaSelWeb.base.TestBase;
import com.tatcha.TatchaSelWeb.pages.CreateAnAccountPage;
import com.tatcha.TatchaSelWeb.pages.HomePage;
import com.tatcha.TatchaSelWeb.pages.LandingPage;
import com.tatcha.TatchaSelWeb.pages.LoginPage;
import com.tatcha.TatchaSelWeb.pages.MyAccountPage;
import com.tatcha.TatchaSelWeb.util.TestUtil;

public class CreatAnAccountTest extends TestBase {

	private LoginPage loginPage;
	private LandingPage landingPage;
	private CreateAnAccountPage createAnAccount;
	private MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {

		init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/createaccount.properties");
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		createAnAccount = new CreateAnAccountPage();
		myAccountPage = new MyAccountPage();
	}

	@Test
	public void createAccount() {

		try {
			landingPage.clickLogin();
			loginPage.createAccountClick();
			// Generate unique email ID using time stamp
			String randomName = "test" + System.currentTimeMillis();
			String randomEmail = randomName + "@test.com";
			createAnAccount.createAnAccount(randomName, prop.getProperty("lastname"), randomEmail,
					prop.getProperty("password"), prop.getProperty("confirmpassword"));
			AssertJUnit.assertEquals(myAccountPage.accountCreationAlert(),
					prop.getProperty("accountconfirmationalert"));
		} catch (Exception exception) {
			Assert.fail(exception.getMessage());
		}

	}
	
 	@Test
	public void checkAlreadyRegisteredUserError() {
		try {
			landingPage.clickLogin();
			loginPage.createAccountClick();
			createAnAccount.createAnAccount(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("newemail"),
					prop.getProperty("password"), prop.getProperty("confirmpassword"));
			assert createAnAccount.isAlreadyRegUser();
		} catch (Exception exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	@Test
	public void checkPasswordErrors() {
		try {
			landingPage.clickLogin();
			loginPage.createAccountClick();
			String randomName = "test" + System.currentTimeMillis();
			String randomEmail = randomName + "@test.com";
			createAnAccount.createAnAccount(randomName, prop.getProperty("lastname"), randomEmail,
					prop.getProperty("password"), prop.getProperty("wrong_confirm_pw"));
			assert createAnAccount.isConfirmPwErrorDisplayed();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			createAnAccount.clearFields();
			createAnAccount.createAnAccount(randomName, prop.getProperty("lastname"), randomEmail,
					prop.getProperty("invalidpw"), prop.getProperty("invalidpw"));
			assert createAnAccount.isPasswordErrorDisplayed();
		} catch (Exception exception) {
			Assert.fail(exception.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
