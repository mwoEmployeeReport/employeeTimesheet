package reports;

import dataModel.Project;
import dataModel.Task;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class EmployeeTotalHoursReport extends iReporting{

    public EmployeeTotalHoursReport(){}

    @Override
    public void calculate(int year) {
        Calendar calendar = Calendar.getInstance();
        for (Project p : dataModel.getProjectList()) {
                for (Task t : p.getTaskList()) {
                    calendar.setTime(t.getDate());
                   if (calendar.get(Calendar.YEAR) ==year) {
                       innerDataModel.put(t.getAsignee().getName(), (int) (innerDataModel.getOrDefault(t.getAsignee().getName(), 0)+t.getTime()));
                   }
                }
            }
    }

    public void printReportToConsole() {
        for (Map.Entry entry : innerDataModel.entrySet()) {
            System.out.println("Employee: " + entry.getKey() + "Time worked: " + entry.getValue() + "\n");
        }
    }

    public void saveToPDF() {
        System.out.println("Not yet implemented.");
    }

    public void saveToXLS() {
        System.out.println("Not yet implemented.");
    }
}
