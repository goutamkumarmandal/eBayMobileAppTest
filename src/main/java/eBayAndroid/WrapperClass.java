package eBayAndroid;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class WrapperClass {

	public static AndroidDriver<AndroidElement>  driver;
	static ExtentTest test;
	static ExtentReports report;
	@BeforeTest
	//Start the emulator from batch file
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestAutomationFramework\\src\\main\\java\\resources\\StartEmulator.bat");

	}

	public static  AndroidDriver<AndroidElement> capabilities(String appName) throws IOException
	{

		//read config properties from global settings
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"TestAutomationFramework\\src\\main\\java\\eBayAndroid\\globalsettings.properties");
		Properties prop = new Properties();
		prop.load(fis);
		File appDir=new File("src");
		File app=new File(appDir,(String) prop.get("TestApp"));
       
		//set desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();

		String testdevice = (String) prop.get("device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, testdevice);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}

	public static void getScreenshot(String s) throws IOException 
	{

		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"TestAutomationFramework\\target\\Results\\Screenshot\\"+s+".png"));

	}
	public static ExtentTest reports() {
		report = new ExtentReports(System.getProperty("user.dir")+"TestAutomationFramework\\Target\\Results.html");
		test = report.startTest("Reports");
		return test;
	}

	public void closeApp(){
		driver.close();
	}
	

	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}
}
