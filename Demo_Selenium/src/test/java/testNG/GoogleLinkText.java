package testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilty.WebBrowser;

public class GoogleLinkText {

	WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite()
	{
		System.out.println("Before suite");
	}
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest()
	{
		System.out.println("Before Test");
	}
	
	@AfterSuite(alwaysRun = true)
	public void AfterSuite()
	{
		System.out.println("After suite");
	}
	
	@AfterTest(alwaysRun = true)
	public void AfterTest()
	{
		System.out.println("After test");
	}
	

	
	@Test(priority=0 , groups="pri1")
	public void imageSearch()
	{
		driver.findElement(By.linkText("Images")).click();
		//WebBrowser.verifyTitle(driver, "Google Images");
		assertEquals(driver.getTitle(), "Google Images");
	}
	@Test(priority=1 , groups={"pri1" , "ad"})
	public void advertize()
	{
		driver.findElement(By.linkText("Advertising")).click();
		WebBrowser.verifyTitle(driver, "Get More Customers With Easy Online Advertising | Google Ads");
	}
	@Test(priority=0 , groups={"pri2" })
	public void about()
	{
		driver.findElement(By.linkText("About")).click();
		//WebBrowser.verifyTitle(driver, "Google - About Google, Our Culture &amp; Company News");
		//assertTrue(driver.getTitle().contains("Google - About Google's"),"Title mismatch");	//false
		assertTrue(driver.getTitle().contains("Google - About Google"),"Title mismatch");	//True
	}
	
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass()
	{
		driver=WebBrowser.openBrowser("https://www.google.com/");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass()
	{
		driver.quit();
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod()
	{
		driver.navigate().back();
	}
	
    

}
