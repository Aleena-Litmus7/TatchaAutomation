package com.tatcha.TatchaSelWeb.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tatcha.TatchaSelWeb.base.TestBase;
import com.tatcha.TatchaSelWeb.pages.HomePage;
import com.tatcha.TatchaSelWeb.pages.LandingPage;
import com.tatcha.TatchaSelWeb.pages.LoginPage;
import com.tatcha.TatchaSelWeb.pages.LoginWithFBPage;
import com.tatcha.TatchaSelWeb.util.TestUtil;

public class LoginWithFB extends TestBase {

LoginPage loginPage;
HomePage homePage;
TestUtil testUtil;
LandingPage landingPage;
LoginWithFBPage loginwithfb;

@BeforeMethod	
public void setUp() {
	
	init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/LoginTest.properties");
	testUtil = new TestUtil();
	loginPage = new LoginPage();
	landingPage =new LandingPage();
	loginwithfb=new LoginWithFBPage();
}



@Test
public void login() {

	landingPage.clickLogin();
	loginPage.loginFBClick();
	loginwithfb.loginFB();
	
	
	
	
}
@AfterMethod
public void tearDown() {
	driver.quit();

}
}


