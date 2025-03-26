package com.mystore.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CheckoutPageDataProvider {
	
	@DataProvider
	public Object[][] testDataProvider2() throws IOException{
		File excelFile = new File(System.getProperty("user.dir")+"/Test Data/ShippingAddressTestData.xlsx");
		
		DataFormatter formatter = new DataFormatter();
		
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
					data[i][j] = formatter.formatCellValue(row.getCell(j));
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
