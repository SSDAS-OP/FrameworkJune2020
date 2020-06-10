package orangeHRM.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProvider {
   
	XSSFWorkbook wb;
	
	public ExcelProvider()
	{
		 try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/logins.xlsx")));
		} 
		 catch (FileNotFoundException e) 
		 {
			
		} 
		 catch (IOException e) 
		 {
			
		}
	}
	
	public int getRowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	
	public int getcolumnCount(String sheetName)
	{
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}
	
	
	public  String getcelldata(String sheetname,int row,int column)
	{
		XSSFCell cell=wb.getSheet(sheetname).getRow(row).getCell(column);
		String data=null;
		if(cell.getCellTypeEnum()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
		{
			data=String.valueOf((int)cell.getNumericCellValue());
		}
		else if(cell.getCellTypeEnum()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}
	
	
	
}
