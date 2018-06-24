package dataModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.io.FilenameFilter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ImportDataFromXlx {


    TimeSheetModel timeSheetModel;

    public TimeSheetModel getTimeSheetModel() {
        return timeSheetModel;
    }

    public void setTimeSheetModel(TimeSheetModel timeSheetModel) {
        this.timeSheetModel = timeSheetModel;
    }

    Project newProject;

    Employee employee = null;

    public void readDataFromFile(File passedFile, String assignee) throws IOException {
       timeSheetModel = new TimeSheetModel();
        FileInputStream inputStream = null;
        inputStream = new FileInputStream(passedFile);
        Workbook workbook = null;
        workbook = new HSSFWorkbook(inputStream);
        if (!timeSheetModel.isEmployeeExist(assignee)) {
            employee = new Employee();
            employee.setName(assignee);
        } else {
            employee = timeSheetModel.findEmployeByName(assignee);
        }
        Iterator<Sheet> sheetIterator = workbook.iterator();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            if (!timeSheetModel.isProjectExist(sheet.getSheetName())) {
                newProject = new Project();
                newProject.setName(sheet.getSheetName());
            } else {
                newProject = timeSheetModel.findProjectByName(sheet.getSheetName());
            }

            int FIRST_ROW_TO_GET = 1;

            for (int i = FIRST_ROW_TO_GET; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                } else {
                    Task task = new Task();

                    task.setDate(row.getCell(0).getDateCellValue());
                    task.setDescription(String.valueOf(row.getCell(1)));
                    Cell c = row.getCell(2);
                    if (c != null) {
                        task.setTime(row.getCell(2).getNumericCellValue());
                    }
                    task.setAsignee(employee);
                    newProject.addTask(task);
                }
            }
            timeSheetModel.addProject(newProject);

            workbook.close();
            inputStream.close();
        }

    }

    public void findAllFiles(File fileList) throws IOException {
        try {
            File[] files = fileList.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    findAllFiles(file);

                } else {
                    if (file.getName().endsWith(".xls")){
                        String employeName = file.getName().replace(".xls", "");
                        readDataFromFile(file.getAbsoluteFile(), employeName);
                    }
                    else {
                        System.out.println("Plik " +file+" ma rozszerzenie inne niż .xls, więc nie będzie brany przy generowaniu raportów.");
                    }

            }
            }
        } catch  (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void PrintAllProjects() {
        for (Project project : timeSheetModel.getProjectList()) {
            System.out.println();
            System.out.println(project.getName());

            System.out.println();
            for (Task task : project.getTaskList()) {
                System.out.println(task.getAsignee().getName() + " " + task.getDate() + " " + task.getDescription() + " " + task.getTime());
            }

        }
    }
}
