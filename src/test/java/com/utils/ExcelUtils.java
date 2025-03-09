package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileOutputStream fio;
	String path = "D:\\Projects_workspace\\TestNGDemoProj\\ExcelFiles\\testdata.xlsx";

	/*
	 * public static void main(String[] args) throws Exception { ExcelUtils utils =
	 * new ExcelUtils(); //utils.createXLSheet(); Object[][]
	 * data=utils.readXLData(); for (Object[] objects : data) {
	 * System.out.println(Arrays.toString(objects)); } }
	 */
	@DataProvider
	public Object[][] readXLData() throws Exception {
		File file=new File(path);
		FileInputStream fio = new FileInputStream(file);
		workbook = new XSSFWorkbook(fio);
		sheet =workbook.getSheetAt(0);
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfCols = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("noOfRows"+noOfRows+"\nnoOfCols"+noOfCols);
		Object[][] obj=new Object[noOfRows][noOfCols];
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfCols; j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		
		
		workbook.close();
		fio.close();
		
		
		return obj;
		
		
	}

	public void createXLSheet() throws Exception {
		String arr[] = { "Admin1", "password1", "Admin2", "password2" };
		File folder = new File(".\\ExcelFiles");
		boolean isFolderCreated = folder.mkdir();
		File xlfile = new File("./ExcelFiles/testdata.xlsx");
		if (isFolderCreated || folder.exists()) {
			fio = new FileOutputStream(xlfile);
			workbook = new XSSFWorkbook();
		} else {
			System.out.println("file not created-----------");
		}
		sheet = workbook.createSheet("LoginData");
		int k = 0;
		for (int i = 0; i < 2; i++) {
			row = sheet.createRow(i);
			for (int j = 0; j < 2; j++) {
				k++;
				row.createCell(j, CellType.STRING).setCellValue(arr[k - 1]);
				System.out.println(k - 1);
			}

		}
		workbook.write(fio);
		workbook.close();
		fio.close();

	}

}
