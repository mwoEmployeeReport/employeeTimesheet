package dataModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TimeSheetModel {

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Set<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(Set<Project> projectList) {
        this.projectList = projectList;
    }

    List<Employee> employeeList = new ArrayList<>();

    Set<Project> projectList =  new HashSet<Project>();

    public Project findProjectByName(String name) {
        for (Project project : projectList) {
            if (project.getName().equals(name)) {
                return project;
            }

        }
        return null;
    }

    public boolean isProjectExist(String name) {
        for (Project project : projectList) {
            if (project.getName().equals(name)) {
                return true;
            }

        }
        return false;
    }

    public void addProject(Project project) {

        projectList.add(project);

    }

    public Employee findEmployeByName(String name) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                return employee;
            }

        }
        return null;
    }

    public boolean isEmployeeExist(String name) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                return true;
            }

        }
        return false;
    }
}
