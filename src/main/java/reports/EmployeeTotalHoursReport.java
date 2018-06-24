package reports;

import dataModel.Project;
import dataModel.Task;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class EmployeeTotalHoursReport extends iReporting{

    public EmployeeTotalHoursReport(){}

    @Override
    public void calculate(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, Calendar.JANUARY, 1, 1, 1, 1);
        int yearDate = cal.get(Calendar.YEAR);
        for (Project p : dataModel.getProjectList()) {
            for (Task t : p.getTaskList()) {
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(t.getDate());
                int checkedYearDate = cal2.get(Calendar.YEAR);
                if (checkedYearDate == yearDate) {
                    innerDataModel.put(t.getAsignee().getName(), (int) (innerDataModel.getOrDefault(t.getAsignee().getName(), 0) + t.getTime()));

                }

            }
        }

    }


    public void printReportToConsole() {
        for (Map.Entry entry : innerDataModel.entrySet()) {
            System.out.println("Pracownik: " + entry.getKey() + "\nPrzepracowany czas: " + entry.getValue() + "\n========\n");
        }
    }

    public void saveToPDF() throws IOException {
        PDFGenerator.makePDF(innerDataModel,"Employee Total Hours Report.pdf");
    }

    public void saveToXLS() {
        System.out.println("Not yet implemented.");
    }
}
