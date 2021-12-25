package testNG;

import org.testng.annotations.Test;

import utilty.WebBrowser;
import utilty.WebElementMethods;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class MyFirstTest {
	WebDriver  driver;
	
	@Test(groups="pri1")
	  public void validlogin() {
		  String experror="Wrong username and password combination.";
		  
		  WebElementMethods.enterText(driver, By.id("login1"), "testuser");
		  WebElementMethods.enterText(driver, By.id("password"), "testuser");
		  WebElementMethods.clickButton1(driver, By.name("proceed"));
		  
		  System.out.println("Login Successful");
	  }
	
  @Test(groups={"pri1", "pri2"})
  public void invalidlogin() {
	  String experror="Wrong username and password combination.";
	  
	  WebElementMethods.enterText(driver, By.id("login1"), "testuser");
	  WebElementMethods.enterText(driver, By.id("password"), "testuser");
	  WebElementMethods.clickButton1(driver, By.name("proceed"));
	  
	  String acterror=driver.findElement(By.cssSelector("div#div_login_error")).getText();
	  assertEquals(acterror, experror);
  }
  
  @AfterMethod(alwaysRun = true)
  public void afterMethod()
  {
	  driver.findElement(By.id("login1")).clear();
	  driver.findElement(By.id("password")).clear();
  }
  
  
  @BeforeClass(alwaysRun = true)
  public void beforeClass() {
	  driver=WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  driver.close();
  }

}
