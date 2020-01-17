package br.com.rsinet.hub_TDD.projeto.utilitys;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWorkbook;
	private static XSSFCell cell;

	public static void setExcelFile(String path, String sheetName) throws Exception {
		
		try {
			FileInputStream file = new FileInputStream(path);
			excelWorkbook = new XSSFWorkbook(file);
			excelWSheet = excelWorkbook.getSheet(sheetName);

		} catch (Exception e) {
			throw (e);
		}

	}

	public static String getCellData(int rowNum, int colNum) {

		try {
			cell = excelWSheet.getRow(rowNum).getCell(colNum);

			String cellData = cell.getStringCellValue();

			return cellData;

		} catch (Exception e) {
			return "";
		}

	}


}
