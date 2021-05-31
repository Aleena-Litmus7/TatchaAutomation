	
package com.tatcha.TatchaSelWeb.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
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
 *  Add to cart - Checkout as guest - Add international address
 *  - Place order (as guest)
 */

public class GuestCheckoutInternationalAddressTest extends TestBase{
	
	LandingPage landingpage = new LandingPage();
	MiniBagPage  minibagpage = new MiniBagPage();
	MyShoppingBag myshoppingbag = new MyShoppingBag();
	ShippingPage   shippingintl = new ShippingPage();
	Payment payment = new Payment();
	Review review  = new Review();
	


@BeforeMethod
public void setUp() {
	
	init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/GuestCheckoutInternationalAddressTest.properties");
}



@Test
public void indianAddress() {
	
	try {
	
	landingpage.addToCart();
	minibagpage.goToBag();
	myshoppingbag.goToShipping();
	// Generate unique email ID using time stamp
			String randomName = "test" + System.currentTimeMillis();
			String randomEmail = randomName + "@test.com";

	shippingintl.guestIndian(randomEmail,prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("address1"),prop.getProperty("address2"),prop.getProperty("zipcode"),prop.getProperty("state"),prop.getProperty("city"),prop.getProperty("phone"));
	payment.getPayment(prop.getProperty("cardname"), prop.getProperty("cardnumber"), prop.getProperty("expiration"), prop.getProperty("cvv"));
	review.guestReview();
	
	
	}catch(Exception exception){

		Assert.fail(exception.getMessage());

}
	
		
	
}	

@AfterMethod
public void tearDown() {
	driver.quit();
}
	
	
}





