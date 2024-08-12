package com.concast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility{
public String getDataFromExcel(String sheetName, int rowNum,int celNum )  throws Exception
{
	FileInputStream fis=new FileInputStream("./testScriptData/Excel with condition.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
	return data;
}
public int getRowcount(String sheetName) throws Throwable
{
	FileInputStream fis=new FileInputStream("./testScriptData/Excel with condition.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	int rowCount=wb.getSheet(sheetName).getLastRowNum();
	return rowCount;
	
}
public void setDataIntoEcel(String sheetName,int rowNum, int celNum, String data) throws Exception
{
	FileInputStream fis=new FileInputStream("./testScriptData/Excel with condition.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNum).getCell(celNum);
	FileOutputStream fos=new FileOutputStream("./testScriptData/Excel with condition.xlsx");
wb.write(fos);
wb.close();
}

}
