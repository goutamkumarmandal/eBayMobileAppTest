package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage {


	public  WelcomePage (AndroidDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,’home′)]")
	public WebElement homeButton;

	@AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
	public WebElement signinHomePage;

	@AndroidFindBy(id="com.ebay.mobile:id/button_classic")
	public WebElement loginViaEmailid;



}
