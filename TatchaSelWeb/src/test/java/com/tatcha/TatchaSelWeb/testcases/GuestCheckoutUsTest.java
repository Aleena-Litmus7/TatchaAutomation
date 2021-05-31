package com.tatcha.TatchaSelWeb.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tatcha.TatchaSelWeb.base.TestBase;
import com.tatcha.TatchaSelWeb.pages.LandingPage;
import com.tatcha.TatchaSelWeb.pages.MiniBagPage;
import com.tatcha.TatchaSelWeb.pages.MyShoppingBag;
import com.tatcha.TatchaSelWeb.pages.Payment;
import com.tatcha.TatchaSelWeb.pages.Review;
import com.tatcha.TatchaSelWeb.pages.ShippingPage;

/**
 * Add to cart - Checkout as guest - Add US address - Place order (as guest)
 */
public class GuestCheckoutUsTest extends TestBase {

	LandingPage landingpage;
	MiniBagPage minibagpage;
	MyShoppingBag myshoppingbag;
	ShippingPage shippingus;
	Payment payment;
	Review review;

	@BeforeTest
	public void setUp() {

		init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/GuestCheckoutUs.properties");
		landingpage = new LandingPage();
		minibagpage = new MiniBagPage();
		myshoppingbag = new MyShoppingBag();
		shippingus = new ShippingPage();
		payment = new Payment();
		review = new Review();

	}

	@Test
	public void usorder() {

		try {
			
			// landingpage.closeCookies();

			landingpage.addToCart();
			minibagpage.goToBag();
			myshoppingbag.goToShipping();
			// Generate unique email ID using time stamp
			String randomName = "test" + System.currentTimeMillis();
			String randomEmail = randomName + "@test.com";
			shippingus.guestUS(randomEmail, prop.getProperty("firstname"), prop.getProperty("lastname"),
					prop.getProperty("country"), prop.getProperty("address1"), prop.getProperty("zipcode"),
					prop.getProperty("state"), prop.getProperty("city"), prop.getProperty("phone"));
			payment.getPayment(prop.getProperty("cardname"), prop.getProperty("cardnumber"),
					prop.getProperty("expiration"), prop.getProperty("cvv"));
			review.placeOrder();

		} catch (Exception exception) {

			Assert.fail(exception.getMessage());

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
