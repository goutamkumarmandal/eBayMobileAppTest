package eBayAndroid;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import eBayAndroid.WrapperClass;
import pageObjects.AddToCart;
import pageObjects.ProductSearch;
import pageObjects.SignIn;
import pageObjects.WelcomePage;

public class EbayTest extends WrapperClass {

	SignIn s=new SignIn(driver);
	WelcomePage wp = new WelcomePage(driver);
	AddToCart a=new AddToCart(driver);
	ProductSearch ps=new ProductSearch(driver);
	String product=null;
	@BeforeTest
	public void launchapp(String app) throws Exception
	{
		
		startEmulator();
		capabilities(app);
		if(driver.getTitle().equals("eBay"))
		{
		test.log(LogStatus.PASS, "App Launched");
		}
		else
		{
		test.log(LogStatus.FAIL, "App Launch Failed");
		}
	}

	@Test
	public void proceedToCheckout(String username,String password , String productname) throws Exception, InterruptedException {
			
		s.signIn();
		
		if(wp.homeButton.isDisplayed())
		{
			test.log(LogStatus.PASS, "SignIn is successful");
		}
		else
		{
			test.log(LogStatus.FAIL, "SignIn in Failed");
		}
		ps.prodSearch(productname);
			
		if(ps.resultSelection.isDisplayed())
		{
		test.log(LogStatus.PASS, "Product search is successful");
		}
		else
		{
		test.log(LogStatus.FAIL, "Product search Failed");
		}
		a.addToCart();
		
		if(a.goToCart.isDisplayed())
		{
		test.log(LogStatus.PASS, "Product added to cart");
		}
		else
		{
		test.log(LogStatus.FAIL, "Product not added to cart");
		}
		
		a.checkout();
		if(a.confirmPayment.isDisplayed())
		{
			test.log(LogStatus.PASS, "Checkout successful");
		}
		else
		{
			test.log(LogStatus.FAIL, "Checkout successful");
		}
		
	}
		
	//Close the application
	@AfterTest
	public void quit()
	{
		closeApp();
		endTest();
	}
	
}
