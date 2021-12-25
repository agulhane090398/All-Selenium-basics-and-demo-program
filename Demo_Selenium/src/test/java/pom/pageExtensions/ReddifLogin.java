package pom.pageExtensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReddifLogin {

	WebDriver rdriver;
	
	//variable declaration
	@FindBy(id="login1")
	WebElement txtusername;
	
	@FindBy(id="password")
	WebElement txtpassword;
	
	@FindBy(name="proceed")
	WebElement btnlogin;
	
	@FindBy(linkText="Create a new account")
	WebElement linkCreateAccount;
	
	@FindBy(css="div#div_login_error>b")
	WebElement lblerror;
	
	//Constructor
	public ReddifLogin(WebDriver rdriver)
	{
		PageFactory.initElements(rdriver, this);
	}
	
	//Methods
	public void login(String username, String password)
	{
		txtusername.sendKeys(username);
		txtpassword.sendKeys(password);
		btnlogin.click();
	}
	
	public String getError()
	{
		return lblerror.getText();
	}

	public void navigateToRegistration() 
	{
		linkCreateAccount.click();
	}

	public void clearData() {
		// TODO Auto-generated method stub
		txtusername.clear();
		txtpassword.clear();
	}

	
}
