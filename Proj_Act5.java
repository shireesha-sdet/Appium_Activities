package appium_Act;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Proj_Act5 {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		  caps = new DesiredCapabilities();
		  caps.setCapability("deviceId", "");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("appPackage", "com.android.chrome");
	      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	      caps.setCapability("noReset", true);
	      
	      URL url = new URL("http://127.0.0.1:4723/wd/hub");
	      
	      driver = new AndroidDriver<MobileElement>(url, caps);
	      wait = new WebDriverWait(driver, 5);
	  }
	
	  @Test (priority=1)
	  public void loginForm() throws InterruptedException {
		  
		  driver.get("https://www.training-support.net/selenium");
		  Thread.sleep(3000);
		  
		  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).getChildByDescription(UiSelector().className(\"android.view.View\"), \"Login Form\")"));
		  driver.findElementByXPath("//android.view.View[@content-desc=\"Login Form Please sign in.\"]").click();
		  
	  }
	  @Test (priority=2)
	  public void validCred() throws InterruptedException {
		  //Test with valid username & password
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"username\")")).sendKeys("admin");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"password\")")).sendKeys("password");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log in\")")).click();

		 
		  String result = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"action-confirmation\")")).getText();
		  
		  Assert.assertEquals(result, "Welcome Back, admin");
	  }
	  @Test (priority=3)
	  public void invalidCred() throws InterruptedException {
		  
		  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(text(\"Log In\"))"));

		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"username\")")).sendKeys("user");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"password\")")).sendKeys("password");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log in\")")).click();

		  String result = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"action-confirmation\")")).getText();
		  
		  Assert.assertEquals(result, "Invalid Credentials");
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  //driver.close();
	  }

}
