package testNG;

import org.testng.annotations.Test;

import pom.pageExtensions.ReddifLogin;
import pom.pageExtensions.RediffReg;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class RediffPOMTest extends Browsers {
	
	
	ReddifLogin rlogin;
	RediffReg rRegis;

	@Test
	public void tc03Register() {
		rlogin=new ReddifLogin(driver);
		rRegis=new RediffReg(driver);
		rlogin.navigateToRegistration();
		rRegis.regiter("aaa", "aa@gmail.com", "f", "India");

	}
//  @BeforeClass
//  public void beforeClass() {
////	  driver=WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
//	  rlogin=new ReddifLogin(driver);
//		rRegis=new RediffReg(driver);
//  }
//
//  @AfterClass
//  public void afterClass() {
//	  driver.close();
//  }

//  @BeforeTest
//  public void beforeTest() {
//  }
//
//  @AfterTest
//  public void afterTest() {
//  }

}
