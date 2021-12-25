package Excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilty.WebBrowser;
import utilty.WebElementMethods;

public class EchoTest {
	WebDriver driver;
	File f = new File("src\\test\\resources\\Test04.xlsx");
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	int rownum, colnum, rescol;
	static int startrow=1;

	@Test(dataProvider = "getData")
	public void loginDDT(String username, String password) throws IOException {
		rescol = colnum - 1;
		WebElementMethods.enterText(driver, By.id("txtCustomerID"), username);
		WebElementMethods.enterText(driver, By.id("txtPassword"), password);
		WebElementMethods.clickButton(driver, By.id("Butsub"));
		if (driver.findElement(By.id("lblMsg")).getText().equals("Invalid Username/Password")) {
			fos = new FileOutputStream(f);
			
			row = sheet.getRow(startrow);
			cell = row.getCell(rescol);
			cell.setCellValue("Pass");
			wb.write(fos);
			startrow++;
		} else {
			fos = new FileOutputStream(f);
			
			row = sheet.getRow(startrow);
			cell = row.getCell(rescol);
			cell.setCellValue("Fail");
			wb.write(fos);
			startrow++;
		}
	}

	@AfterMethod
	public void aftermethd() throws IOException {
		driver.findElement(By.id("txtCustomerID")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		
	}
	@AfterClass
	public void closed() throws IOException {
		driver.close();
		wb.close();
		fis.close();
		fos.close();
	}

	@BeforeClass
	public void webpage() {
		driver = WebBrowser.openBrowser("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
	}

	@DataProvider
	public String[][] getData() throws IOException {
		fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("DemoXLSheet");
		rownum = sheet.getPhysicalNumberOfRows();
		colnum = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[rownum - 1][colnum - 1];
		for (int i = 1; i < rownum; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colnum - 1; j++) {
				cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		
		
		return data;
	}
}
