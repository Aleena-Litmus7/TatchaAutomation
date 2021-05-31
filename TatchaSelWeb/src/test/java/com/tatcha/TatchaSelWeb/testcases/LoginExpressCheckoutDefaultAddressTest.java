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
    import com.tatcha.TatchaSelWeb.pages.ConfirmationPage;
    import com.tatcha.TatchaSelWeb.pages.LandingPage;
    import com.tatcha.TatchaSelWeb.pages.LoginPage;
    import com.tatcha.TatchaSelWeb.pages.MiniBagPage;
    import com.tatcha.TatchaSelWeb.pages.MyShoppingBag;
    import com.tatcha.TatchaSelWeb.pages.Review;
    import com.tatcha.TatchaSelWeb.pages.ShippingPage;
    import com.tatcha.TatchaSelWeb.util.TestUtil;

	public class LoginExpressCheckoutDefaultAddressTest extends TestBase {
		
		LandingPage landingpage;
		MiniBagPage  minibagpage;
		MyShoppingBag myshoppingbag;
		LoginPage loginPage;
		ShippingPage     shippingus;
        Review review;
    	ConfirmationPage orderconfirmation;

		TestUtil testUtil;
		
		
		
		@BeforeMethod
		public void setUp() {
			
			init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/LoginExpressCheckoutDefaultAddress.properties");
			testUtil = new TestUtil();
			landingpage = new LandingPage();
			loginPage = new LoginPage();
			minibagpage = new MiniBagPage();
			myshoppingbag = new MyShoppingBag();
			shippingus = new ShippingPage();
            review= new Review();
            orderconfirmation=new ConfirmationPage();
		}
	

		
		@Test
		public void loginExprsChekout() {
		
		try {

		//	landingpage.closeCookies();
			landingpage.addToCart();
			minibagpage.goToBag();
			myshoppingbag.goToShipping();
			shippingus.loginExprsCheckout();
			loginPage.enterLoginDetails(prop.getProperty("email"),prop.getProperty("password"));
			review.placeOrder();	
			orderconfirmation.getOrderConfirmation();
		//	myshoppingbag.checkboxAd() ;
			AssertJUnit.assertEquals(orderconfirmation.getOrderConfirmation(),prop.getProperty("confirmationmessage").toUpperCase());


		}catch(Exception exception){

			
			Assert.fail(exception.getMessage());

			
		}
	}
	
	
	
		@AfterMethod
		public void tearDown() {
			driver.quit();

		}	
		
	}

		

