package reports;

import java.util.Calendar;
import java.util.Map;

import dataModel.Project;
import dataModel.Task;

public class EmployeeTotalHoursReport extends iReporting {

    public EmployeeTotalHoursReport() {
    }

    @Override
    public void calculate(int year) {
        for (Project p : dataModel.getProjectList()) {
            for (Task t : p.getTaskList()) {
                Calendar cal = Calendar.getInstance();
                cal.set(year, Calendar.JANUARY, 1, 1, 1, 1);
                int yearDate = cal.get(Calendar.YEAR);
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
            System.out.println("Employee: " + entry.getKey() + " Time worked: " + entry.getValue() + "\n");

        }

    }

    @Override
    public void saveToPDF() {

    }

    @Override
    public void saveToXLS() {

    }
}