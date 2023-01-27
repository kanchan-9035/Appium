package com.eCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utility.BaseTest;

import io.appium.java_client.AppiumBy;

public class TestCase1 extends BaseTest{
  @Test
  public void fillForm() throws InterruptedException {
	  
	  WebElement text=driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
	  text.click();
	  text.sendKeys("KP");
	  driver.hideKeyboard();
	  driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	  driver.findElement(AppiumBy.accessibilityId("android:id/text1")).click();
	  
	  //scroll untill Argentina is available
	  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	  
	  Thread.sleep(5000);
	 
  }
}
