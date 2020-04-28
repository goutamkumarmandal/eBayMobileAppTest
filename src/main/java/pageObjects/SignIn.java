package pageObjects;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignIn  {

	public  SignIn (AndroidDriver<AndroidElement>driver)
	{		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
	public WebElement signinHomePage;

	@AndroidFindBy(id="com.ebay.mobile:id/button_classic")
	public WebElement loginViaEmailid;

	@AndroidFindBy(id="com.ebay.mobile:id/home")
	public WebElement closeSignin;
	@AndroidFindBy(id="com.ebay.mobile:id/edit_text_username")
	private WebElement username;

	@AndroidFindBy(id="com.ebay.mobile:id/edit_text_password")
	private WebElement password;

	@AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
	public WebElement signInButton;

	public void signIn() throws IOException, InterruptedException
	{
		FileReader reader = new FileReader(System.getProperty("user.dir")+"\\TestAutomationFramework\\src\\main\\java\\eBayAndroid\\globalsettings.properties");
		Properties prop = new Properties();
		prop.load(reader);

		//Proceed to signin in home page
		signinHomePage.click();
		loginViaEmailid.click();

		//Enter User Details
		username.click();
		username.clear();
		username.sendKeys(prop.getProperty("emailid"));
		password.click();
		password.clear();
		username.sendKeys(prop.getProperty("passkey"));
		signInButton.click();	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
