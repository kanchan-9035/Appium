package com.Appium.StartAppium;



import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestBaseTest extends BaseTest{
  @Test
  public void test() {
	  
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
	  driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
	  
  }
}
