package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductSearch {
	
	public ProductSearch (AndroidDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}



@AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
public WebElement SearchBox;

@AndroidFindBy(xpath="//android.widget.Button[@text=’65 inch tv\r\n" + 
		"TV, Video & Home Audio Electronics′]")
public WebElement ResultSelection;

@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'add_on_item_selected']")
public WebElement AdditionalSecurityPlan;

@AndroidFindBy(xpath="//android.widget.Button[@text=’ADD TO CART′]")
public WebElement AddToCart;

@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'textview_item_name']")
public WebElement PNameCheckoutSCreen;



}












