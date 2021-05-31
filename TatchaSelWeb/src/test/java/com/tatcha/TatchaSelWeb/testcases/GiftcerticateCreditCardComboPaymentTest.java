package com.tatcha.TatchaSelWeb.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tatcha.TatchaSelWeb.base.TestBase;
import com.tatcha.TatchaSelWeb.pages.LandingPage;
import com.tatcha.TatchaSelWeb.pages.MiniBagPage;
import com.tatcha.TatchaSelWeb.pages.MyShoppingBag;
import com.tatcha.TatchaSelWeb.pages.Payment;
import com.tatcha.TatchaSelWeb.pages.Review;
import com.tatcha.TatchaSelWeb.pages.ShippingPage;
import com.tatcha.TatchaSelWeb.pages.ShopAllPage;




/**
 *  Add to cart - Checkout as guest - Add US address -
 * Place order (as guest)
 */
public class GiftcerticateCreditCardComboPaymentTest extends TestBase {

	
	LandingPage landingpage;
	MiniBagPage  minibagpage;
	MyShoppingBag myshoppingbag;
	ShippingPage     shippingus;
	Payment payment;
	Review review;
	ShopAllPage shopall;


@BeforeTest
public void setUp() {
	
	init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/GuestCheckoutUs.properties");
	landingpage = new LandingPage();
	minibagpage = new MiniBagPage();
	myshoppingbag = new MyShoppingBag();
	shippingus = new ShippingPage();
	payment = new Payment();
	review = new Review();
	shopall= new ShopAllPage();
	
}

@Test
public void giftCerticateCreditCardComboPayment() {

	landingpage.moveToShop();
	shopall.addToCart();
	minibagpage.goToBag();
	myshoppingbag.updateQuantity();
	myshoppingbag.goToShipping();
	shippingus.guestUS(prop.getProperty("email"), prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("country"), prop.getProperty("address1"),prop.getProperty("zipcode"),prop.getProperty("state"),prop.getProperty("city"),prop.getProperty("phone"));
	payment.redeemGiftCard(prop.getProperty("GiftCard"));
	payment.getPayment(prop.getProperty("cardname"), prop.getProperty("cardnumber"), prop.getProperty("expiration"), prop.getProperty("cvv"));
	review.placeOrder();

	
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
	
	
}
