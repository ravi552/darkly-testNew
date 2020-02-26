package com.darkly.lib.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class DataHandelsForExel {
	public static String getDataFromExcel(String fileName, String sheetName, int rowIndex, int cellndex) {
		String data= null;
		try {
			File file= new File("./test-data/"+fileName+".xlsx");
			FileInputStream fis = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellndex);
			data = c.toString();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public static void setDataToExcel(String fileName,String sheetName, int rowIndex, int cellndex, String data) {
		try {
			File file= new File("./test-data/"+fileName+".xlsx");
			FileInputStream fis = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.createRow(rowIndex);
			Cell c = r.createCell(cellndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String data = DataHandelsForExel.getDataFromExcel("data", "Sheet1", 0, 0);
		System.out.println(data);
		DataHandelsForExel.setDataToExcel("data", "Sheet1", 0, 2, "Instagram");
	}
}


