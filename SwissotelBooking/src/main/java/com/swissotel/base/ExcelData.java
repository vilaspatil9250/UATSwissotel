package com.swissotel.base;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData extends BaseClass{
	XSSFWorkbook datawb;
	XSSFSheet datasheet;

	public ExcelData() throws Exception {
		// File file = new File("D:\\JAVA Programs\\Testdata.xlsx");
		File file = new File("./TestData/TestData.xlsx");
		FileInputStream datafile = new FileInputStream(file);
		datawb = new XSSFWorkbook(datafile);
		datasheet = datawb.getSheetAt(0);
	}

	public String fieldvalue(int rowno) {
		String inputvalue = datasheet.getRow(rowno).getCell(1).getStringCellValue();
		return inputvalue;
	}
	
	public String fieldvaluenum(int rowno) {
//		int inputnum = (int)datasheet.getRow(rowno).getCell(1).getNumericCellValue();
		String inputvalue = Integer.toString((int)datasheet.getRow(rowno).getCell(1).getNumericCellValue());
		return inputvalue;	
}
}
