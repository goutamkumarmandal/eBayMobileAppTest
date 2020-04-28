package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddToCart {
	
    public  AddToCart (AndroidDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	@AndroidFindBy(xpath="//android.widget.Button[@text=’ADD TO CART′]")
	public WebElement addToCart;

	@AndroidFindBy(xpath="//android.widget.Button[@text=’GO TO CART′]")
	public WebElement goToCart;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=’GO TO CheckoutT′]")
	public WebElement goToCheckout;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=’Confirm and Pay′]")
	public WebElement confirmPayment;

	public void addToCart()
	{
		addToCart.click();
			
	}
public void checkout() {
	
	goToCart.click();

	if(goToCheckout.isDisplayed())
	{
		goToCheckout.click();
	}
	else {
		System.out.println("Product not added to cart");
	}
}

}
