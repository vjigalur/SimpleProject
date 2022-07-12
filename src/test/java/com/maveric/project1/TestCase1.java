package com.maveric.project1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class TestCase1 {
	public static DesiredCapabilities cap;
	public static void main(String[] args) throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("app","C:\\Users\\vijaykumarj\\eclipse-workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");
		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.findElement(AppiumBy.accessibilityId("Search tab")).click();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"Science\")")).click();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("strategy", "-android uiautomator");
		map.put("selector", "UiSelector().textContains(\"Electrical engineering\").index(0)");

		driver.executeScript("mobile: scroll", map);
		driver.findElement(
				AppiumBy.androidUIAutomator("UiSelector().textContains(\"Electrical engineering\").index(0)")).click();

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("strategy", "-android uiautomator");
		map1.put("selector", "UiSelector().textContains(\"Lego robotics\")");

		driver.executeScript("mobile: scroll", map1);
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"Lego robotics\")")).click();

		driver.findElement(AppiumBy.xpath("(//*[@content-desc='Add Bookmark'])[2]")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		driver.findElement(AppiumBy.xpath("(//*[@content-desc='Add Bookmark'])[1]")).click();

		driver.findElement(AppiumBy.accessibilityId("Bookmarks tab")).click();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"Edit\")")).click();
		driver.findElement(AppiumBy.xpath("(//*[@content-desc='Select bookmark'])[2]")).click();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"Delete\")")).click();


	}

}
