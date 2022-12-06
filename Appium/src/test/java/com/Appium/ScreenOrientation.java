package com.Appium;

import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import com.Appium.StartAppium.BaseTest;

public class ScreenOrientation extends BaseTest {
  @Test
  public void screenTestLandscape() throws InterruptedException {
	  
	  DeviceRotation landscape=new DeviceRotation(0, 0, 90);
	  try {
		driver.rotate(landscape);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  Thread.sleep(2000);

  }
}
