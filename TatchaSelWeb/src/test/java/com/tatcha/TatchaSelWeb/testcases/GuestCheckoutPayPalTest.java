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
import com.tatcha.TatchaSelWeb.pages.PayPalPaymentPage;
import com.tatcha.TatchaSelWeb.pages.Payment;
import com.tatcha.TatchaSelWeb.pages.Review;
import com.tatcha.TatchaSelWeb.pages.ShippingPage;

/**
 * Add to cart - Checkout as guest - Add US address - Place order (as guest)
 */
public class GuestCheckoutPayPalTest extends TestBase {

	LandingPage landingpage;
	MiniBagPage minibagpage;
	MyShoppingBag myshoppingbag;
	ShippingPage shippingus;
	Payment payment;
	Review review;
PayPalPaymentPage paypalpaymentpage;
	@BeforeTest
	public void setUp() {

		init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/GuestCheckoutUs.properties");
		landingpage = new LandingPage();
		minibagpage = new MiniBagPage();
		myshoppingbag = new MyShoppingBag();
		shippingus = new ShippingPage();
		payment = new Payment();
		review = new Review();
		paypalpaymentpage =new PayPalPaymentPage();
	}

	@Test
	public void usorder() {

		try {
			landingpage.addToCart();
			minibagpage.goToBag();
			myshoppingbag.clickPayPal();
			paypalpaymentpage.paypalPaymentDetails(prop.getProperty("email"),prop.getProperty("password"));
		//	payment.getPayment(prop.getProperty("cardname"), prop.getProperty("cardnumber"),
				//	prop.getProperty("expiration"), prop.getProperty("cvv"));
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
