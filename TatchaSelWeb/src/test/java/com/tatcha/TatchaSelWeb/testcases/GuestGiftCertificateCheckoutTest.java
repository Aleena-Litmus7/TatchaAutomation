package com.tatcha.TatchaSelWeb.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tatcha.TatchaSelWeb.base.TestBase;
import com.tatcha.TatchaSelWeb.pages.EGiftCardPage;
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
public class GuestGiftCertificateCheckoutTest extends TestBase{

	LandingPage landingpage;
	MiniBagPage  minibagpage;
	MyShoppingBag myshoppingbag;
	ShippingPage     shippingus;
	Payment payment;
	Review review;
	ShopAllPage shopall;
    EGiftCardPage egiftcard;

@BeforeTest
public void setUp() {
	
	init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/EGiftCard.properties");
	landingpage = new LandingPage();
	minibagpage = new MiniBagPage();
	myshoppingbag = new MyShoppingBag();
	shippingus = new ShippingPage();
	payment = new Payment();
	review = new Review();
	shopall= new ShopAllPage();
	egiftcard=new EGiftCardPage();
}
@Test


public void GuestGiftCertificateCheckout() {



	//	landingpage.closeCookies();,

	landingpage. moveToExclusive();
	egiftcard.enterGiftCardDetails((prop.getProperty("RecipientsFn")), prop.getProperty("SendersFn"));
	egiftcard.addRecommendations();
	driver.navigate().refresh();
	egiftcard.deliver((prop.getProperty("RecipientsEmail")), prop.getProperty("SendersEmail"));
	myshoppingbag.goToShipping();
	payment.getPayment(prop.getProperty("cardname"), prop.getProperty("cardnumber"), prop.getProperty("expiration"), prop.getProperty("cvv"));
	//shippingus.billingAddress(prop.getProperty("country"), prop.getProperty("streetaddress1"),prop.getProperty("streetaddress2"),prop.getProperty("zipcode"),prop.getProperty("province"),prop.getProperty("city"));
	review.placeOrder();
	
	
}

@AfterMethod
public void tearDown() {
	driver.quit();

}
}

	

