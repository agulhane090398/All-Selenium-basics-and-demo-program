package grid;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoGrid {	
		public static  WebDriver driver;
		 
		public static void main(String[]  args) throws MalformedURLException {
	 
	 		String url = "https://www.google.com";
	 		String hub = "http://192.168.42.78:4444/wd/hub";
	 		DesiredCapabilities cap = new DesiredCapabilities();
	 		cap = DesiredCapabilities.chrome();
	 	//	cap = DesiredCapabilities.firefox();
	 		cap.setPlatform(Platform.WINDOWS);
	 		
	 		ChromeOptions options = new ChromeOptions();
	 		//FirefoxOptions  options = new FirefoxOptions();
	 		options.merge(cap);	 		
	 		URL add = new URL(hub);
	 		
	 		driver = new RemoteWebDriver(add, cap);	
	 		
	 		driver.get(url);
	 		driver.findElement(By.name("q")).sendKeys("grid");
	 		//driver.close();

	}

}