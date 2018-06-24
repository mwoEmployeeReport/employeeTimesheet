package main.generator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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

        ArrayList<Object> emplyeeList = new ArrayList<>();
        emplyeeList.add("Jan_Kowalski");
        emplyeeList.add("Tomasz_Zdrajca");
        emplyeeList.add("Tomasz_Koniorczyk");
        emplyeeList.add("Tomasz_Obibok");
        emplyeeList.add("Tomasz_Koniorczyk");
        emplyeeList.add("Tomasz_Koniorczyk");

        ArrayList<String> taskList = new ArrayList<>();
        taskList.add("Wuzyta u klienta");
        taskList.add("Analiza Wymagan");
        taskList.add("Spisanie dokumentu wymagan");
        taskList.add("Prezentacja dla klienta");
        taskList.add("Spotkanie po prezentacji");
        taskList.add("Wyjscie na piwo");


        for (int i = 1; i<=numberEmployee; i++ ) {
        Workbook wb = new HSSFWorkbook();
            String employeeName = (String) emplyeeList.get((int) (Math.random()*6));
            try (OutputStream fileOut = new FileOutputStream(employeeName+ i + ".xls"))
            {
                Sheet sheet1 = wb.createSheet("Projekt1" );
                Sheet sheet2 = wb.createSheet("Projekt2");
                Sheet sheet3 = wb.createSheet("Projekt3");

                ArrayList<Row> createRowList= new ArrayList<>();
                createRowList.add(sheet1.createRow(0));
                createRowList.add(sheet2.createRow(0));
                createRowList.add(sheet3.createRow(0));

                for (Row row: createRowList) {
                    inputData(row);
                }

                Random luckyNumber = new Random();
                ArrayList<Sheet> createSheetList= new ArrayList<>();
                createSheetList.add(sheet1);
                createSheetList.add(sheet2);
                createSheetList.add(sheet3);

                for (Sheet sh: createSheetList) {
                    for (int k = 1; k < 10; k++) {
                        int dataHour = luckyNumber.nextInt(10) + 1;
                        Row row1 = sh.createRow(k);
                        Cell cell = row1.createCell(2);
                        cell.setCellValue(dataHour);
                        String taskName = taskList.get((int) (Math.random()*6));
                        cell = row1.createCell(1);
                        cell.setCellValue(taskName);
                    }
                }


                //randomHours(luckyNumber, createSheetList);

               /* for (Sheet sh: createSheetList) {
                    for (int n = 1; n < 10; n++) {
                        String taskName = taskList.get((int) (Math.random()*6));
                       // int dataHour = luckyNumber.nextInt(10) + 1;
                        Row row1 = sh.createRow(n);
                        Cell cell = row1.createCell(1);
                        cell.setCellValue(taskName);
                    }
                }*/



               wb.write(fileOut);
                fileOut.close();
                wb.close();
            }
        }
    }

   /* public static void randomHours(Random luckyNumber, ArrayList<Sheet> createSheetList) {
        for (Sheet sh: createSheetList) {
            for (int k = 1; k < 10; k++) {
                int dataHour = luckyNumber.nextInt(10) + 1;
                Row row1 = sh.createRow(k);
                Cell cell = row1.createCell(2);
                cell.setCellValue(dataHour);

            }
        }
    }*/

    private static void inputData(Row row){
        Cell cell1 = row.createCell(0);
        cell1 = row.createCell(0);
        cell1.setCellValue("Data");
        cell1 = row.createCell(1);
        cell1.setCellValue("Zadanie");
        cell1 = row.createCell(2);
        cell1.setCellValue("Czas [h]");

    }
}


