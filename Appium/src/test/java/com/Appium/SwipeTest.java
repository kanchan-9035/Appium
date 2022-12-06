package com.Appium;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Appium.StartAppium.BaseTest;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeTest extends BaseTest {
  @Test
  public void swipeTest() {
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
	 // check if scrollable element is availabe 
	 WebElement element= driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
	
	  Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
	 
	  //perform Swipe- left
	  
	 /* ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)element).getId(),
			    "direction", "left",
			    "percent", 0.75
			));*/
	  
	  swipeTo(element, "left");
	  //Check the first element shoule not be focusable
	  System.out.println("Scrolling is done");
	  Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("focusable"), "true");
	  
  }
  
  
}
