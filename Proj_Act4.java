package appium_Act;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class Proj_Act4 {
	
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
	
	  @Test
	  public void toDoList() throws InterruptedException {
		  
		  driver.get("https://www.training-support.net/selenium");
		  Thread.sleep(3000);
		  
		  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).getChildByDescription(UiSelector().className(\"android.view.View\"), \"To-Do List\")"));
		  driver.findElementByXPath("//android.view.View[@content-desc=\"To-Do List Elements get added at run time\"]").click();
		  
		  Thread.sleep(2000);
		  
		  driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[3]/android.widget.TextView[contains(@text,'Clear List')]").click();
		  
		 
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"taskInput\")")).sendKeys("Add tasks to list");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Add Task\")")).click();
		 
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"taskInput\")")).sendKeys("Get number of tasks");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Add Task\")")).click();
		 
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"taskInput\")")).sendKeys("Clear the list");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Add Task\")")).click();
		  
		 
		  List<MobileElement> allTasks = driver.findElementsByXPath("//android.view.View/android.view.View[3]/android.view.View[2]/android.view.View");
				  
		  for (MobileElement x: allTasks) {
			  if (x.getText().equals("Add tasks to list")) {
				  System.out.println("Task 1: \"Add tasks to list\" has been added");
			  }
			  if (x.getText().equals("Get number of tasks")) {
				  System.out.println("Task 2: \"Get number of tasks\" has been added");
			  }
			  if (x.getText().equals("Clear the list")) {
				  System.out.println("Task 3: \"Clear the list\" has been added");
			  }
		  }
		  System.out.println("Total number of tasks added is: "+ allTasks.size());
		  
		  //strike all the added tasks
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Add tasks to list\")")).click();
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Get number of tasks\")")).click();
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Clear the list\")")).click();
		  
		  //clear the list
		  driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[3]/android.widget.TextView[contains(@text,'Clear List')]").click();
		  
		  //Check if the current task list is empty
		  List<MobileElement> allCurrentTasks = driver.findElementsByXPath("//android.view.View/android.view.View[3]/android.view.View[2]/android.view.View");
		  Assert.assertEquals(allCurrentTasks.size(), 0);
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  //driver.close();
	  }


}
