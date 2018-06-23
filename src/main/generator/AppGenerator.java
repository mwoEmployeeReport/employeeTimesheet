package main.generator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class AppGenerator {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        createExel();
    }

    public static void createExel() throws IOException {

        Scanner read = new Scanner(System.in);
        System.out.println("Podaj Liczbe pracownikow do wygenerowania");
        int numberEmployee = 0;
        numberEmployee = read.nextInt();

        Workbook wb = new HSSFWorkbook();
        for (int i = 1; i<=numberEmployee; i++ ) {
            try (OutputStream fileOut = new FileOutputStream("Pracownik" + i + ".xls"))
            {
                Sheet sheet1 = wb.createSheet("Projekt" + i);
                //Sheet sheet2 = wb.createSheet("Projekt2");
                Row row = sheet1.createRow(0);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue("Data");
                Cell cell1 = row.createCell(1);
                cell1.setCellValue("Zadanie");
                Cell cell2 = row.createCell(2);
                cell2.setCellValue("Czas [h]");
                Row row1 = sheet1.createRow(1);

                Cell cell10 = row1.createCell(0);
                cell10.setCellValue("2018-05-01");

                Cell cell11 = row1.createCell(1);
                cell11.setCellValue("Zadanie1");

                Random generator = new Random();
                for (int h = 1; h < 10; h++) {
                    int j = generator.nextInt(10) + 1;
                    Row row2 = sheet1.createRow(h);
                    Cell cell12 = row2.createCell(2);
                    cell12.setCellValue(j);
                    wb.write(fileOut);
                }
                fileOut.close();
                wb.close();
            }
        }
    }
}


