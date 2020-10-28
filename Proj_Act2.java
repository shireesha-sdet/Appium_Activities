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
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Proj_Act2 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	  DesiredCapabilities caps = null;
	  
	
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		  caps = new DesiredCapabilities();
		  caps.setCapability("deviceId", "");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("appPackage", "com.google.android.keep");
	      caps.setCapability("appActivity", ".activities.BrowseActivity");
	      caps.setCapability("noReset", true);
	      
	      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	      driver = new AndroidDriver<MobileElement>(appServer, caps);
	      wait = new WebDriverWait(driver, 5);
	  }
		
	  @Test
	  public void myNotes() {
		 
		  //click add note
		  driver.findElementById("com.google.android.keep:id/new_note_button").click();
		  //enter note title
		  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("First Notes");
		  //enter note description
		  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Complete Appium project");
		  //save note
		  driver.findElementByAccessibilityId("Navigate up").click();
		 
		  
		  //capture the added note  
		  String noteTitle = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		  String noteDescription = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
		  
		  System.out.println(noteTitle);
		  System.out.println(noteDescription);
		  
		  Assert.assertEquals(noteTitle, "First Notes");
		  Assert.assertEquals(noteDescription, "Complete Appium project");
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
