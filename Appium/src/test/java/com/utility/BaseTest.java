package com.utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;

public class BaseTest {
	
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	
  @BeforeClass
  public void setUp() throws MalformedURLException {
	  
	  AppiumDriverLocalService service=new AppiumServiceBuilder().
				withAppiumJS(new File("C:\\Users\\kanch\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723).build();

	  service.start();
	  
	  System.out.println("Appium service started automatically");


	  System.out.println("Launching app Test started");
	  System.out.println("Now starting test on Emulator:-- setting its capabilities");
	 
	  URL appiumRunOn=new URL("http://127.0.0.1:4723");
	  
	  UiAutomator2Options option= new UiAutomator2Options();
	  option.setDeviceName("Pixcel4a");
	  //option.setApp("C:\\Users\\kanch\\git\\appiumRepository\\Appium\\src\\test\\java\\apk\\ApiDemos-debug.apk");
	  option.setApp("C:\\Users\\kanch\\git\\appiumRepository\\Appium\\src\\test\\java\\apk\\General-Store.apk");
	  
	  
	  System.out.println("Platform is"+option.getPlatformName());
	  System.out.println("Capabilities set");
	  
	  driver=new AndroidDriver(appiumRunOn, option);
	 
  }
  public void swipeTo(WebElement element, String direction) {
	  ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)element).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
  }
  public void rotateToLandscape() 
  {
	  
	  DeviceRotation landscape=new DeviceRotation(0, 0, 90);
	  driver.rotate(landscape);
  }
  public void longPressOn(WebElement element) {

	  ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
	  ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
  }
  
  public void pressBack() {
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
  }
  public void pressHome() {
	  driver.pressKey(new KeyEvent(AndroidKey.HOME));
  }
  

  @AfterClass
  public void tearDown() throws InterruptedException {
	  
	  System.out.println("End of TestsuiteExecution");
	  
	 // driver.quit();
	  //Thread.sleep(1000);
	  //service.stop();
	  
  }

}
