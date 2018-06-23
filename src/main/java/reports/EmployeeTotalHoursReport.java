package reports;

import dataModel.Project;
import dataModel.Task;

import java.util.HashMap;

public class EmployeeTotalHoursReport extends iReporting{

    EmployeeTotalHoursReport(){}

    @Override
    public void calculate(int year) {

        for (Project p : dataModel.getProjectList()) {
                for (Task t : p.getTaskList()) {
                   if (t.getDate().getYear() == year) {
                       innerDataModel.put(t.getAsignee().getName(), innerDataModel.getOrDefault(t.getAsignee().getName(), 0)+t.getTime());
                   }
                }
            }
    }

    public void printReportToConsole() {
        System.out.println("Not yet implemented.");
    }

    public void saveToPDF() {
        System.out.println("Not yet implemented.");
    }

    public void saveToXLS() {
        System.out.println("Not yet implemented.");
    }
}
