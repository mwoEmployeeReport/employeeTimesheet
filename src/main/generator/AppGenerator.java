package main.generator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class AppGenerator {

    Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
    Sheet sheet1 = wb.createSheet("new sheet");
    Sheet sheet2 = wb.createSheet("second sheet");
}
