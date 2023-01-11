package tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class ReadAndWrite {
	
	  public static String readExcel(String sheet, String scenario, String Column) throws IOException{
		    
		  
		  
		  String excelPath="C:\\Users\\0045OI744\\eclipse-workspace\\TestingPractice\\src\\main\\resources\\testing.xlsx";
		  FileInputStream inputstream = new FileInputStream(excelPath);
		XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
		XSSFSheet s1=workbook.getSheet(sheet);
		
		int rows=s1.getLastRowNum();
		int column=s1.getRow(1).getLastCellNum();
		String Value = null;
		for (int r=0;r<=rows;r++) {
		XSSFRow row=s1.getRow(r);		
		XSSFCell cell=row.getCell(0);
		if(cell.getStringCellValue().equalsIgnoreCase(scenario)) 
		{
			
		for(int c=0;c<=column;c++) {
				XSSFCell columncell=s1.getRow(0).getCell(c);
				if(columncell.getStringCellValue().equalsIgnoreCase(Column)){
		Value=s1.getRow(r).getCell(c).getStringCellValue();	
				break;
				}
				}
		break;
			}
		}
		return Value;
	}
	

public static void writeExcel(String sheet, String scenario, String col, String data) throws IOException{
    
	  
	  
	  String excelPath="C:\\Users\\0045OI744\\eclipse-workspace\\TestingPractice\\src\\main\\resources\\testing.xlsx";
	  FileInputStream inputstream = new FileInputStream(excelPath);
	XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
	XSSFSheet s1=workbook.getSheet(sheet);
	
	int rows=s1.getLastRowNum();
	int column=s1.getRow(1).getLastCellNum();

	for (int r=0;r<=rows;r++) {
	XSSFRow row=s1.getRow(r);		
	XSSFCell cell=row.getCell(0);
	if(cell.getStringCellValue().equalsIgnoreCase(scenario)) 
	{
		
	for(int c=0;c<=column;c++) {
			XSSFCell columncell=s1.getRow(0).getCell(c);
			if(columncell.getStringCellValue().equalsIgnoreCase(col)){
	s1.getRow(r).getCell(c).setCellValue(data);
			break;
			}
			}
	break;
		}
	}
	 FileOutputStream outputstream = new FileOutputStream(excelPath);
	 workbook.write(outputstream);
	 outputstream.close();
}
}