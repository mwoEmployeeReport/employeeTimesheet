package dataModel;

import reports.EmployeeTotalHoursReport;

import java.util.List;

public class TimeSheetModel {

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    List<Employee> employeeList;

    List<Project> projectList;

}
