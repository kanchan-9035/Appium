package com.Appium.StartAppium;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;

public class CustomizingAppiumstart {
	
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	  
  @Test
  public void launchApp()
  {
	 
  }
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
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

  @AfterMethod
  public void afterMethod() {

	  System.out.println(" close test");
  }

  @BeforeClass
  public void beforeClass() {
	 service=new AppiumServiceBuilder().
				withAppiumJS(new File("C:\\Users\\kanch\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723).build();

	  service.start();
	  System.out.println("Appium service started automatically");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("End of TestsuiteExecution");
	  driver.quit();
	  service.stop();
  }

}
