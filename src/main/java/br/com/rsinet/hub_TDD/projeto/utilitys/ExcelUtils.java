package br.com.rsinet.hub_TDD.projeto.utilitys;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWorkbook;
	private static XSSFCell cell;
//	private static XSSFRow row;

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

//	public static void SetCellData(String result, int rowNum, int colNum) throws Exception {
//
//		try {
//			row = excelWSheet.getRow(rowNum);
//
//			cell = row.getCell(colNum);
//
//			if (cell == null) {
//
//				cell = row.createCell(colNum);
//
//				cell.setCellValue(result);
//
//			} else {
//
//				cell.setCellValue(result);
//
//			}
//
//			FileOutputStream fileOut = new FileOutputStream(Constantes.path + Constantes.file);
//
//			excelWorkbook.write(fileOut);
//
//			fileOut.close();
//
//		} catch (Exception e) {
//
//			throw (e);
//
//		}
//
//	}

}
