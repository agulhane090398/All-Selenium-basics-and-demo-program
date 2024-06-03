package testNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilty.WebBrowser;
import utilty.WebElementMethods;

public class EchoTest {
	WebDriver driver;
	
	@Parameters({"username","password" })
	@Test
	public void login(@Optional ("Test1")String username, @Optional ("Test2")String password)
	{
		WebElementMethods.enterText(driver, By.id("txtCustomerID"), username);
		WebElementMethods.enterText(driver, By.id("txtPassword"), password);
		WebElementMethods.clickButton(driver, By.id("Butsub"));
	}
	
	
	@Test(dataProvider = "getData")
	public void loginDDT(String username, String password)
	{
		//Link verification
		driver.findElement(By.id("txtCustomerID")).clear();
		WebElementMethods.enterText(driver, By.id("txtCustomerID"), username);
		WebElementMethods.enterText(driver, By.id("txtPassword"), password);
		WebElementMethods.clickButton(driver, By.id("Butsub"));
		assertEquals(driver.findElement(By.id("lblMsg")).getText(), "Invalid Username/Password");
	}
	
	@AfterClass
	public void closed()
	{
		driver.close();
	}
	
	@BeforeClass
	public void webpage()
	{
		driver=WebBrowser.openBrowser("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
	}
	
	
	//Returns dimensional array
	//1st dimension gives no of rows
	//2st dimension gives no of cols
	@DataProvider
	public Object[][] getData()
	{
		String[][] data=new String[3][2];
		data[0][0]="user01";
		data[0][1]="pass01";
		data[1][0]="user02";
		data[1][1]="pass02";
		data[2][0]="user03";
		data[2][1]="pass03";
		return data;
	}

}
