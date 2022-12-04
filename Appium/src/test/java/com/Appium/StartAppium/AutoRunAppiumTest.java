package com.Appium.StartAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AutoRunAppiumTest {
  @Test
  public void autoStartAppium() throws MalformedURLException {
	  AppiumDriverLocalService service=new AppiumServiceBuilder().
			  					withAppiumJS(new File("C:\\Users\\kanch\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			  					.withIPAddress("127.0.0.1")
			  					.usingPort(4723).build();
	  
	  service.start();
	  System.out.println("Appium service started automatically");
	  
	  System.out.println("Now starting test on Emulator:-- setting its capabilities");
	  AndroidDriver driver;
	  URL appiumRunOn=new URL("http://127.0.0.1:4723");
	  
	  UiAutomator2Options option= new UiAutomator2Options();
	  option.setDeviceName("Pixcel4a");
	  option.setApp("C:\\Users\\kanch\\git\\appiumRepository\\Appium\\src\\test\\java\\apk\\ApiDemos-debug.apk");
	  
	  
	  System.out.println("Platform is"+option.getPlatformName());
	  System.out.println("Capabilities set");
	  
	  driver=new AndroidDriver(appiumRunOn, option);
	  driver.quit();
	  service.stop();
	  
	  
  }
}
