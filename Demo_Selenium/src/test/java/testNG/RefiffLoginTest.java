package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.pageExtensions.ReddifLogin;
import pom.pageExtensions.RediffReg;
import utilty.WebBrowser;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class RefiffLoginTest extends Browsers{


	ReddifLogin rlogin;
	RediffReg rreg;

	@Test
	public void tc01ValidLogin() {
		ReddifLogin rlogin=new ReddifLogin(driver);
		rlogin.login("admin", "admin");
		rlogin.clearData();
	}
	@Test
	public void tc02InValid() {
		ReddifLogin rlogin=new ReddifLogin(driver);
		rlogin.login("guest", "admin");
		assertEquals(rlogin.getError(), "Temporary Issue. Please try again later. [#5002]");
	}
	
	
	@Test
	public void tc03Register() {
		ReddifLogin rlogin=new ReddifLogin(driver);
		RediffReg rreg=new RediffReg(driver);
		rlogin.navigateToRegistration();
		rreg.regiter("aaa", "aa@gmail.com", "f", "India");

	}
	
	

//	@BeforeClass
//	public void beforeClass() {
//		driver =WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
//		rlogin = new ReddifLogin(driver);
//		rreg = new RediffReg(driver);
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.close();
//	}

}
