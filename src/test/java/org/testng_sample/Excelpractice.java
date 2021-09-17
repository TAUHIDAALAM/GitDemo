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

public class Excelpractice {

	public static void main(String[] args) throws IOException {

		// 1. Give ur file location
		File f = new File("C:\\Users\\WINDOW'S\\eclipse-workspace\\Sample\\Excelsheet\\TestData.xlsx");

		// 2. Read a file
		FileInputStream fil = new FileInputStream(f);

		// 3. Get a workbook
		Workbook w = new XSSFWorkbook(fil);

		// 4. Get a sheet
		Sheet s = w.getSheet("Sheet1");

		// 5. Get a Row

		// 6. Get a cell

		int NumberOfRows = s.getPhysicalNumberOfRows();

		for (int i = 0; i < NumberOfRows; i++) {
			Row r = s.getRow(i);

			int NumberOfCells = r.getPhysicalNumberOfCells();

			for (int j = 0; j < NumberOfCells; j++) {
				Cell c = r.getCell(j);
				int type = c.getCellType();

				String value = "";

				if (type == 1) {

					value = c.getStringCellValue();
				}

				else if (DateUtil.isCellDateFormatted(c))

				{

					Date dateCellValue = c.getDateCellValue();
					SimpleDateFormat dat = new SimpleDateFormat("dd-MMM-yyyy");
					value = dat.format(dateCellValue);
				}

				else {

					double numericCellValue = c.getNumericCellValue();
					long l = (long) numericCellValue;
					value = String.valueOf(l);
				}
				System.out.println(value);

			}

		}

	}

}
