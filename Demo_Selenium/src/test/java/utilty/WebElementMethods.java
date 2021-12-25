package utilty;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebElementMethods {

//	TextBox
	public static void enterText(WebDriver driver, By locator, String text) {
		try {
			driver.findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			System.out.println("Element not Found");
		}

	}

//	click action
	public static void clickButton(WebDriver driver, By locator) {
		try {
			driver.findElement(locator).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element Button not Found");
		}

	}

	public static void clickButton1(WebDriver driver, By locator) {
		try {
			WebElement we = driver.findElement(locator);
			if (we.isEnabled()) {
				we.click();
			} else {
				System.out.println("Button is disable karke rakha hai");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element Button not Found");
		}

	}

//	Checkbox
	public static void selectCheckBox(WebDriver driver, By locator, String option) {
		List<WebElement> chkboxes = driver.findElements(locator);
		for (WebElement ch : chkboxes) {
			if (ch.getAttribute("value").equalsIgnoreCase(option)) {
				if (!ch.isSelected()) {
					ch.click();
					break;
				}
			}
		}
	}

//	Radio button
	public static void selectRadio(WebDriver driver, By locator, String option) {
		List<WebElement> radios = driver.findElements(locator);
		for (WebElement rb : radios) {
			if (rb.getAttribute("value").equalsIgnoreCase(option)) {
				rb.click();
				break;
			}
		}
	}

//	DropDown
	public static void selectByValue(WebDriver driver, By locator, String textValue) {
		boolean flag = false;
		Select dd = new Select(driver.findElement(locator));
		List<WebElement> options = dd.getOptions();
		for (WebElement option : options) {
			if (option.getAttribute("value").equals(textValue)) {
				flag = true;
				dd.selectByValue(textValue);
				break;
			}
		}
		if (flag == false) {
			System.out.println("Incorrect input option");
		}
	}

	public static void selectByVisibleText(WebDriver driver, By locator, String textValue) {
		boolean flag = false;
		Select dd = new Select(driver.findElement(locator));
		List<WebElement> options = dd.getOptions();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(textValue)) {
				flag = true;
				dd.selectByValue(textValue);
				break;
			}
		}
		if (flag == false) {
			System.out.println("Incorrect input option: " + textValue);
		}

	}

	public static void selectMenu(WebDriver driver, By menulocator, By sblocator, String items) {
		WebElement menu = driver.findElement(menulocator);
		Actions builder = new Actions(driver);

		builder.moveToElement(menu).perform();

		List<WebElement> submenus = driver.findElements(sblocator);
		for (WebElement sb : submenus) {
			if (sb.getText().trim().equalsIgnoreCase(items)) {
				sb.click();
				break;
			}
		}
	}

	public static void selectMenu(WebDriver driver, By menulocator, String menuitem, By sblocator, String sbitems) {
		List<WebElement> menus = driver.findElements(menulocator);
		Actions builder = new Actions(driver);
		for (WebElement menu : menus) {
			if (menu.getText().trim().equalsIgnoreCase(menuitem)) {
				
				builder.moveToElement(menu).perform();
			}

			List<WebElement> submenus = driver.findElements(sblocator);
			for (WebElement sb : submenus) {
				if (sb.getText().trim().equalsIgnoreCase(sbitems)) {
					sb.click();
					break;
				}
			}

		}
	}
}
