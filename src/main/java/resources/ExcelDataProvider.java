package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	public String excelData(String productname,String username , String password ) throws Exception
	{

		File src = new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\DataSheet.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Ebay");
		XSSFRow row = null;
		row = sheet.getRow(0);

		int colCount = row.getLastCellNum();
		System.out.println("Column Count :- " + colCount);

		int rowCount = sheet.getLastRowNum() + 1;
		System.out.println("Row Count :- " + rowCount);

		for (int rNum = 1; rNum <= rowCount; ) 
		{
			for (int cNum = 0; cNum < colCount; cNum++) 
			{
		productname = sheet.getRow(rNum).getCell(cNum).getStringCellValue();
		System.out.println(productname);
				
			}
		}
		return productname;
	}

}


