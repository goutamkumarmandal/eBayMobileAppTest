package resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;  
import org.testng.annotations.Test;

import eBayAndroid.WrapperClass;
public class Listener implements ITestListener   
{  
@Override  
public void onTestStart(ITestResult result) {  
 
}  
  
@Override  
public void onTestSuccess(ITestResult result) {  
	String s=result.getName();
	try {
		WrapperClass.getScreenshot(s);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
System.out.println("Success of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onTestFailure(ITestResult result) {  
String s=result.getName();
try {
	WrapperClass.getScreenshot(s);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("Failure of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onTestSkipped(ITestResult result) {   
System.out.println("Skip of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
 
System.out.println("Failure of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onStart(ITestContext context) {  
 
}  
  
@Override  
public void onFinish(ITestContext context) {  

}  
}  