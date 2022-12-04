package com.Appium.StartAppium;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import java.net.URL;

import org.testng.annotations.AfterClass;

public class BaseicTest {
  @Test
  public void startDriver() throws MalformedURLException {
	  
	  AndroidDriver driver;
	  URL appiumRunOn=new URL("http://127.0.0.1:4723");
	  
	  UiAutomator2Options option= new UiAutomator2Options();
	  option.setDeviceName("Pixcel4a");
	  option.setApp("C:\\Users\\kanch\\git\\appiumRepository\\Appium\\src\\test\\java\\apk\\ApiDemos-debug.apk");
	  
	  System.out.println("Platform is "+option.getPlatformName());
	  System.out.println("Capabilities set");
	  
	  driver=new AndroidDriver(appiumRunOn, option);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Startng the first test");
  }

  @AfterMethod
  public void afterMethod() {

	  System.out.println(" first end test");
  }

  @BeforeClass
  public void beforeClass() {

	  System.out.println("Startng execution of testsuite");
  }

  @AfterClass
  public void afterClass() {

	  System.out.println("End of execution if testsuite");
  }

}
