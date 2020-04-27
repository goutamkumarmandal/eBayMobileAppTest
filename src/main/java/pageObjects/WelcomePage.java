package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage {
	
	 
   // org.testng.log4testng.Logger logger = Logger.getLogger(WelcomePage.class);
    public WelcomePage (AndroidDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
    @AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,’home′)]")
    public WebElement HomeButton;

    @AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
    public WebElement SigninHomePage;

    @AndroidFindBy(id="com.ebay.mobile:id/button_classic")
    public WebElement LoginviaEmailid;
    
   

    @AndroidFindBy(id="com.ebay.mobile:id/edit_text_username")
    private WebElement username;

    @AndroidFindBy(id="com.ebay.mobile:id/edit_text_password")
    private WebElement password;

    @AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
    private WebElement SignInButton;
    
    @AndroidFindBy(id="com.ebay.mobile:id/home")
    public WebElement closesignin;
	
    public WebElement clickSignin()
    {
    	System.out.println("Click on Signin button in HomePage");
    	return SigninHomePage;
    }
    
    public WebElement LoginViaEmailid()
    {
    	System.out.println("Login via registered email id");
    	return LoginviaEmailid;
    }
    
    public WebElement EnterUserName() 
    {
    	System.out.println("Enter User email id");
    	return username;
    }
    
    public WebElement EnterPassword()
    {
    	System.out.println("Enter password");
    	return password;
    }
	
    public WebElement ClickSigninButton() 
    {
    	System.out.println("click on sigin button");
    	return SignInButton;
    }
	 public void waitForAppToLoadLogo(AndroidDriver<AndroidElement>driver)
	    {

	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.elementToBeClickable(SigninHomePage));
	        try {
	            Thread.sleep(10000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }


	    }

}
