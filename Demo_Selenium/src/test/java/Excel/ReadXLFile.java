package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLFile {

	public static void writeToExcel(File f) throws IOException
	{
		FileOutputStream fos=new FileOutputStream(f);
		
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("DemoXLSheet");
		for(int i=0;i<3;i++)
		{
			XSSFRow row=sheet.createRow(i);
			for(int j=0;j<3;j++)
			{
				XSSFCell cell=row.createCell(j);
				cell.setCellValue("test"+i+j);
					
			}	
		}
		wb.write(fos);
		wb.close();
		fos.close();
		
	}
	
	public static void readExcel(File f) throws IOException
	{
		FileInputStream fis=new FileInputStream(f);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("DemoXLSheet");
		for(Row row:sheet)
		{
			for(Cell cell:row)
			{
//				String value=cell.getStringCellValue();
//				System.out.println(value);
				
				printCellData(cell);
			}
		}
		
		wb.close();
		fis.close();
		
	}
	
	public static void printCellData(Cell cell) 
	{
		CellType type=cell.getCellType();
		
		switch(type)
		{
		case STRING:
			System.out.println(cell.getStringCellValue());
			break;
			
		case NUMERIC:
			System.out.println(cell.getNumericCellValue());
			break;
			
		case ERROR:
			System.out.println(cell.getErrorCellValue());
			break;
			
		case BOOLEAN:
			System.out.println(cell.getBooleanCellValue());
			break;
			
		case BLANK:
			System.out.println("Cell is blank");
			break;
			
		case FORMULA:
			System.out.println(cell.getCellFormula());
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f=new File("src\\test\\resources\\Test1.xlsx");
		
		//write
		writeToExcel(f);
		System.out.println("Write done");
		
		//Read
		readExcel(f);
		System.out.println("read done");
		
		//print cell
		

	}

}
