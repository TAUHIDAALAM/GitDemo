package org.testng_sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelpractice2own {

	public static void main(String[] args) throws IOException {

		File filepath = new File("C:\\Users\\WINDOW'S\\eclipse-workspace\\Sample\\Excelsheet\\shake.xlsx");

		FileInputStream filefetching = new FileInputStream(filepath);

		Workbook book = new XSSFWorkbook(filefetching);

		Sheet sheet = book.getSheet("Shake");

		int NumberOfRows = sheet.getPhysicalNumberOfRows();
		String Value ="";

		for (int i = 0; i < NumberOfRows; i++) {

			Row row = sheet.getRow(i);

			int NumberOfCells = row.getPhysicalNumberOfCells();

			for (int j = 0; j < NumberOfCells; j++) {

				Cell cell = row.getCell(j);

				int cellType = cell.getCellType();

				if (cellType == 1) {

					Value = cell.getStringCellValue();

				} else if (DateUtil.isCellDateFormatted(cell)) {

					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
					Value = simpleDateFormat.format(dateCellValue);

				}
				
				else {
					
					double numericCellValue = cell.getNumericCellValue();
					long l=(long)numericCellValue;
					Value = String.valueOf(l);
				} 
				
				System.out.println(Value);
			}

		}

	}
}
