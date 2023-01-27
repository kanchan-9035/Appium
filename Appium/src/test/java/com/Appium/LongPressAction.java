package com.Appium;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.utility.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class LongPressAction {
	
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	
	@BeforeMethod
	  public void setConfiguration() throws MalformedURLException {
		System.out.println("Launching app Test started");
		  System.out.println("Now starting test on Emulator:-- setting its capabilities");
		 
		  URL appiumRunOn=new URL("http://127.0.0.1:4723");
		  
		  UiAutomator2Options option= new UiAutomator2Options();
		  option.setDeviceName("Pixcel4a");
		  option.setApp("C:\\Users\\kanch\\git\\appiumRepository\\Appium\\src\\test\\java\\apk\\ApiDemos-debug.apk");
		  
		  
		  System.out.println("Platform is"+option.getPlatformName());
		  System.out.println("Capabilities set");
		  
		  driver=new AndroidDriver(appiumRunOn, option);
	  }
	
  @Test
  
  public void longPressGesture() throws InterruptedException {
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
	  driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
	  
	  WebElement element1=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	  
		
		  ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
		  ImmutableMap.of("elementId", ((RemoteWebElement) element1).getId()));
		 
	//  longPressGesture(element1);
	  Thread.sleep(1000);
	  String text=driver.findElement(AppiumBy.accessibilityId("android:id/title")).getText();
	  Assert.assertEquals(text,"Sample Menue");
	  assertTrue(driver.findElement(AppiumBy.accessibilityId("android:id/title")).isDisplayed());
	  
  }
  
  @AfterMethod
  public void tearDown() {
	  System.out.println("End of TestsuiteExecution");
	  driver.quit();
	  //service.stop();
}
}