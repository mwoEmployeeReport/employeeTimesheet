package main.generator;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


public class AppGenerator {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        createExel();
    }

    public static void createExel() throws IOException {

        Scanner read = new Scanner(System.in);
        int numberEmployee = 0;
        int month = 1;
        int year = 2018;
        System.out.println("Podaj Liczbe pracownikow do wygenerowania");
        numberEmployee = read.nextInt();
        System.out.println("Podaj rok");
        year = read.nextInt();
        System.out.println("Podaj miesiac");
        month = read.nextInt();


        ArrayList<Calendar> dateList = new ArrayList<>();

        for (int m = 1; m<=10; m++){
            Calendar date = Calendar.getInstance();
            date.set(year,m,month);
            dateList.add(date);
        }


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
        CreationHelper createHelper = wb.getCreationHelper();
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("mm/dd/yyyy"));
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

                randomData(dateList, taskList, cellStyle, luckyNumber, createSheetList);

                wb.write(fileOut);
                fileOut.close();
                wb.close();
            }
        }
    }

    public static void randomData(ArrayList<Calendar> dateList, ArrayList<String> taskList, CellStyle cellStyle, Random luckyNumber, ArrayList<Sheet> createSheetList) {
        for (Sheet sh: createSheetList) {
            for (int k = 1; k < 21; k++) {
                int dataHour = luckyNumber.nextInt(10) + 1;
                Row row1 = sh.createRow(k);
                Cell cell = row1.createCell(2);
                cell.setCellValue(dataHour);
                String taskName = taskList.get((int) (Math.random()*6));
                cell = row1.createCell(1);
                cell.setCellValue(taskName);
                Calendar setDate = dateList.get((int) (Math.random() *10));
                cell = row1.createCell(0);
                cell.setCellValue(setDate);
                cell.setCellStyle(cellStyle);
                sh.autoSizeColumn(0);
                sh.autoSizeColumn(1);
                sh.autoSizeColumn(2);

            }
        }
    }


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


