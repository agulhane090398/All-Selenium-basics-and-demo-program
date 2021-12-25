package pom.pageExtensions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class RediffReg {
	
	WebDriver rdriver;
	
	@FindBy(xpath = "//tbody/tr[3]/td[3]/input[1]")
	WebElement txtname;
	
	@FindBy(xpath="//tbody/tr[9]/td[3]/input[1]")
	WebElement txtpassword;
	
	@FindBy(xpath="//tbody/tr[24]/td[3]/input")
	List<WebElement> rbgender;
	
	@FindBy(xpath="//tbody/tr[1]/td[3]/select[1]")
	WebElement lstcountry;
	
	
	//Constructor
	public RediffReg(WebDriver rdriver)
	{
		PageFactory.initElements(rdriver, this);
	}
	
	//Methods
	public void regiter(String name, String email, String gender,String country)
	{
		txtname.sendKeys(name);
		txtpassword.sendKeys(email);
		for(WebElement rb:rbgender)
		{
			if(rb.getAttribute("value").equals(gender))
			{
				rb.click();
				break;
			}
		}
		
		Select ddcontry=new Select(lstcountry);
		List<WebElement> options=ddcontry.getOptions();
		for(WebElement op: options)
		{
			if(op.getText().equals(country))
			{
				ddcontry.selectByVisibleText(country);
				break;
			}
		}
	}

}
