package testNG;

import org.testng.annotations.Test;

import utilty.WebBrowser;
import utilty.WebElementMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class AmazonDDT {
	WebDriver driver;
  
	@Test(dataProvider = "search")
  public void mobile(String search) {
	  WebElementMethods.enterText(driver, By.id("twotabsearchtextbox"), search);
	  WebElementMethods.clickButton(driver, By.id("nav-search-submit-button"));
  }
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.id("twotabsearchtextbox")).clear();
  }

  @BeforeClass
  public void beforeClass() {
	  driver=WebBrowser.openBrowser("https://www.amazon.com/");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
  
//Returns dimensional array
	//1st dimension gives no of rows
	//2st dimension gives no of cols
	@DataProvider
	public String[] search()
	{
		String[] data=new String[5];
		data[0]="Mobile";
		data[1]="Backcover";
		data[2]="Headphone";
		data[3]="shirt";
		data[4]="Laptop";
		
		return data;
	}

}
