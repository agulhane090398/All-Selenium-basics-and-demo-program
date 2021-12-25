package utilty;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowser {

	public static WebDriver openBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void verifyTitle(WebDriver driver,String expectedTitle)
	{
		String title=driver.getTitle();
		if(title.equals(expectedTitle))
		{
			System.out.println("Images pass");
		}
		else
		{
			System.out.println("Images fail");
		}
	}
	
	public static void verifyTitleByAssert(WebDriver driver,String expectedTitle, String actualTitle)
	{
		assertEquals(expectedTitle, actualTitle);
	}

	
}
