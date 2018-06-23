package reports;

import dataModel.EmployeeDataModel;
import java.util.HashMap;


public abstract class iReporting {

    EmployeeDataModel dataModel;
    HashMap<String, Integer> innerDataModel = new HashMap<String, Integer>();

    public void setDataModel(EmployeeDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public abstract void calculate(int year);

    public abstract void printReportToConsole();

    public abstract void saveToPDF();

    public abstract void saveToXLS();

}
