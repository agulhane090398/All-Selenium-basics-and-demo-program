package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import pom.pageExtensions.ReddifLogin;
import pom.pageExtensions.RediffReg;
import utilty.WebBrowser;

public class Browsers {
	
	public static WebDriver driver;
	ReddifLogin rlogin;
	RediffReg rreg;
//	@BeforeTest
//	public void beforeTest() {
//		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
//		driver=new ChromeDriver();
//		driver = WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
//		System.out.println("aniket");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//	}
//	
//	@AfterTest
//	public void afterTest() {
//		driver.close();
//	}
	
	@BeforeTest
	public void beforeClass() {
		driver =WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
		
	}

	@AfterTest
	public void afterClass() {
		driver.close();
	}

}
