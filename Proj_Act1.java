package appium_Act;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Proj_Act1 {
	
	 AppiumDriver<MobileElement> driver = null;
	    WebDriverWait wait;
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceID", " ");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
      caps.setCapability("noReset", true);
      
   // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 5);
  }
  
  @Test
  public void google_Task1() throws Exception
  {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Enter task1
	  MobileElement el = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	  el.click();
	  MobileElement newtask1 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  newtask1.sendKeys("Complete Activity with Google Tasks");
	  MobileElement savetask1 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	  savetask1.click();
	  //Enter task2
	  MobileElement el2 = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	  el2.click();
	  MobileElement newtask2 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  newtask2.sendKeys("Complete Activity with Google Keeps");
	  MobileElement savetask2 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	  savetask2.click();
	  
	  //Enter Task3 
	  MobileElement el3 = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	  el3.click();
	  MobileElement newtask3 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  newtask3.sendKeys("Complete the second Activity Google Keep");
	  MobileElement savetask3 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	  savetask3.click();
	  
	  String task1 = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).getChildByText(UiSelector().resourceId(\"com.google.android.apps.tasks:id/task_name\"),\"Complete Activity with Google Tasks\")")).getText();
		 
	  String task2 = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).getChildByText(UiSelector().resourceId(\"com.google.android.apps.tasks:id/task_name\"),\"Complete Activity with Google Keep\")")).getText();
	 
	  String task3 = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).getChildByText(UiSelector().resourceId(\"com.google.android.apps.tasks:id/task_name\"),\"Complete the second Activity Google Keep\")")).getText();
	  
	  System.out.println(task1);
	  System.out.println(task2);
	  System.out.println(task3);
	  
	  Assert.assertEquals(task1, "Complete Activity with Google Tasks");
	  Assert.assertEquals(task2, "Complete Activity with Google Keep");
	  Assert.assertEquals(task3, "Complete the second Activity Google Keep");

  }

  @AfterClass
  public void afterClass() {
  }

}
