package org.testng_sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.BaseClass;

public class Excelwrite extends BaseClass {

	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\WINDOW'S\\eclipse-workspace\\Sample\\Excelsheet\\writexcel.xlsx");

		Workbook w = new XSSFWorkbook();

		Sheet S = w.createSheet("Aalam");

		Row R = S.createRow(0);

		Cell C = R.createCell(0);
 
		C.setCellValue("Shake Mohammad");

		FileOutputStream fout = new FileOutputStream(f);

		w.write(fout);

		System.out.println("Done");

	}

}
