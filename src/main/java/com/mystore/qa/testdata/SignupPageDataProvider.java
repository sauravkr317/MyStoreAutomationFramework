package com.mystore.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SignupPageDataProvider {
	
	@DataProvider
	public Object[][] testDataProvider() throws IOException{
		File excelFile = new File(System.getProperty("user.dir")+"/Test Data/SignupPageTestData.xlsx");
		if(excelFile.exists()) {
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("sheet1");
			int totalRow = sheet.getLastRowNum();
			int totalCol = sheet.getRow(0).getLastCellNum();
			
			Object[][] data = new Object[totalRow][totalCol];
			for (int i=0; i<totalRow; i++) {
				XSSFRow row = sheet.getRow(i+1);
				for(int j=0; j<totalCol; j++) {
					data[i][j] = row.getCell(j).getStringCellValue();
				}
			}
			workbook.close();
			fis.close();
			return data;
		}else {
			System.out.println("File not present");
		}
		return null;
	}

}
