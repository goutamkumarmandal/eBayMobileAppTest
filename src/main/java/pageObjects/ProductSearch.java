package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductSearch  {
	static ExtentTest test;
	public  ProductSearch (AndroidDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
	public WebElement searchBox;

	@AndroidFindBy(xpath="//android.widget.Button[@text=’65 inch tv\r\n" + 
			"TV, Video & Home Audio Electronics′]")
	public WebElement resultSelection;

	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'add_on_item_selected']")
	public WebElement additionalSecurityPlan;

	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'textview_item_name']")
	public WebElement pnameCheckoutSCreen;

	public void prodSearch(String product) throws Exception
	{

		//Search for the product
		searchBox.click();
		searchBox.clear();
		searchBox.sendKeys(product);
		//select the product
		resultSelection.click();

		//Capture the product name from the screen and verify	
		String pname = pnameCheckoutSCreen.getText();
		if(pname.equalsIgnoreCase(product))
		{
			test.log(LogStatus.PASS, "Expected product");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong Product");
		}

	}
}












