package eBay.TestAutomationFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import eBay.TestAutomationFramework.WrapperClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.ProductSearch;
import pageObjects.WelcomePage;
import resources.Utilities;

public class EbayTest extends WrapperClass {

	private static AndroidDriver<AndroidElement> driver;
	static ExtentTest test;
	static ExtentReports report;
	@BeforeTest
	public void launchapp(String app) throws Exception
	{
		capabilities(app);
	}

	@Test(priority =0)
	public void signIn(String username, String password) throws IOException, InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		report = new ExtentReports(System.getProperty("user.dir")+"Target\\Results.html");
		test = report.startTest("Reports");
		WelcomePage wp = new WelcomePage(driver);
		if(driver.getTitle().equals("eBay"))
		{
		test.log(LogStatus.PASS, "App Launched");
		}
		else
		{
		test.log(LogStatus.FAIL, "App Launch Failed");
		}
		//Proceed to signin in home page

		wp.clickSignin().click();
		wp.LoginViaEmailid().click();

		wp.closesignin.click();
		wp.closesignin.click();

		//Close the alert window
		Alert alert = driver.switchTo().alert();
		alert.accept();

		//Enter User Details
		wp.EnterUserName().click();
		wp.EnterUserName().clear();
		wp.EnterUserName().sendKeys(username);


		wp.EnterPassword().click();
		wp.EnterPassword().clear();
		wp.EnterPassword().sendKeys(password);

		wp.ClickSigninButton().click();	
		if(wp.HomeButton.isDisplayed())
		{
		test.log(LogStatus.PASS, "Sign in is successful");
		}
		else
		{
		test.log(LogStatus.FAIL, "Sign in Failed");
		}
	}
	@Test
	public void addToBasket(String product)
	{
		
		//Search for the product
		ProductSearch ps = new ProductSearch(driver);
		System.out.println("Click on search box");
		ps.SearchBox.click();
		ps.SearchBox.clear();
		ps.SearchBox.sendKeys(product);

		if(ps.ResultSelection.isDisplayed())
		{
		test.log(LogStatus.PASS, "Product search is successful");
		}
		else
		{
		test.log(LogStatus.FAIL, "Product search Failed");
		}
		//select the product
		ps.ResultSelection.click();

		//Capture the product name from the screen and verify
		
		String pname = ps.PNameCheckoutSCreen.getText();
		if(pname.equalsIgnoreCase(product))
		{
			test.log(LogStatus.PASS, "Expected product");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong Product");
		}

		//Scroll the screen
		Utilities u=new Utilities(driver);
		u.scrolltoText("ADD TO CART");
		// Add the product to the cart
		ps.AddToCart.click();
		if(ps.PNameCheckoutSCreen.isDisplayed())
		{
		test.log(LogStatus.PASS, "Product added to basket");
		}
		else
		{
		test.log(LogStatus.FAIL, "Product not added to basket");
		}
		
	}	
	//Close the application
	@AfterTest
	public void quit()
	{
		closeApp();
	}
	
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
}
