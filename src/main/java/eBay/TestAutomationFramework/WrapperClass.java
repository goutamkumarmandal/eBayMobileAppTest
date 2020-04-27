package eBay.TestAutomationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class WrapperClass {
	
	public static AndroidDriver<AndroidElement>  driver;
	@BeforeTest
	//Start the emulator from batch file
	public static void StartEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\StartEmulator.bat");
		
	}
	
	public static  AndroidDriver<AndroidElement> capabilities(String appName) throws IOException
	{
			 	
		//read config properties from global settings
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\eBay\\TestAutomationFramework\\globalsettings.properties");
		Properties prop = new Properties();
		prop.load(fis);
		File appDir=new File("src");
		File app=new File(appDir,(String) prop.get(appName));
		
		//set desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		
		String testdevice = (String) prop.get("device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, testdevice);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		System.out.println("App Launched");
		return driver;
	}
	
	public static void getScreenshot(String s) throws IOException 
	{
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\target\\Results\\Screenshot\\"+s+".png"));
		
	}
	
	public void closeApp(){
		driver.close();
	}
	}
	