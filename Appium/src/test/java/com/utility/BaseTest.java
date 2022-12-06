package com.utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;

public class BaseTest {
	
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
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

  @AfterClass
  public void afterClass() {
	  System.out.println("End of TestsuiteExecution");
	  driver.quit();
	  service.stop();
  }

}
