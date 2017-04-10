package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static Map<String, List<String>> readDataFromExcel() {

		String filePath = System.getProperty("user.dir") + "/src/test/java/com/excelfiles/Automation_TestData.xlsx";

		Map<String, List<String>> excelData = new HashMap<String, List<String>>();
		List<String> sourceCities = new ArrayList<String>();
		List<String> destinationCities = new ArrayList<String>();

		try {

			// Set file path
			FileInputStream fis = new FileInputStream(new File(filePath));

			// Get the workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Get the sheet
			XSSFSheet sheet = workbook.getSheet("Cities");

			// Get rows which are filled with the data
			int rowCount = sheet.getPhysicalNumberOfRows();

			for (int i = 1; i < rowCount; i++) {

				XSSFRow row = sheet.getRow(i);

				sourceCities.add(String.valueOf(row.getCell(0)));
				destinationCities.add(String.valueOf(row.getCell(1)));

			}

			excelData.put("SourceCities", sourceCities);
			excelData.put("DestinationCities", destinationCities);

			System.out.println(excelData);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// Return excel data object
		return excelData;

	}

}
