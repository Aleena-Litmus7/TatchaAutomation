package com.tatcha.TatchaSelWeb.testcases;

import org.testng.annotations.Test;

import static org.testng.Assert.fail;

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
import com.tatcha.TatchaSelWeb.pages.ConfirmationPage;
import com.tatcha.TatchaSelWeb.pages.Review;
import com.tatcha.TatchaSelWeb.pages.ShippingPage;




/**
 *  Add to cart - Checkout as guest - Add international address 
 *  - Register and Place order
 */
public class GuestCheckoutInternationalAddressRegisterTest extends TestBase{
	LandingPage landingpage = new LandingPage();
	MiniBagPage  minibagpage = new MiniBagPage();
	MyShoppingBag myshoppingbag = new MyShoppingBag();
	ShippingPage   shippingintl = new ShippingPage();
	Payment payment = new Payment();
	Review review  = new Review();
	ConfirmationPage confirmationpage = new ConfirmationPage();
	
	
	
	
	@BeforeMethod
	public void setUp() {
		
		init("/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/GuestCheckoutInternationalAddressRegister.properties");
	}
	
	
	

	@Test
	public void indianAddress()  {
		
		
		try {
		landingpage.addToCart();
		minibagpage.goToBag();
		myshoppingbag.goToShipping();
		// Generate unique email ID using time stamp
		String randomName = "test" + System.currentTimeMillis();
		String randomEmail = randomName + "@test.com";

		shippingintl.guestIndian(randomEmail,prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("india_address1"),prop.getProperty("india_address2"),prop.getProperty("india_zipcode"),prop.getProperty("india_state"),prop.getProperty("india_city"),prop.getProperty("phone"));
		payment.getPayment(prop.getProperty("cardname"), prop.getProperty("cardnumber"), prop.getProperty("expiration"), prop.getProperty("cvv"));
		review.guestReview();
		confirmationpage.guestReg(prop.getProperty("newpassword"), prop.getProperty("confirmpassword"));
		
		
	}catch(Exception exception) {
Assert.fail(exception.getMessage());
}
	
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
	
}
	

}



