package reports;

import dataModel.TimeSheetModel;

import java.io.IOException;
import java.util.HashMap;


public abstract class iReporting {

    TimeSheetModel dataModel;
    public HashMap<String, Integer> innerDataModel = new HashMap<String, Integer>();

    public void setDataModel(TimeSheetModel dataModel) {
        this.dataModel = dataModel;
    }

    public abstract void calculate(int year);

    public abstract void printReportToConsole();

    public abstract void saveToPDF() throws IOException;

    public abstract void saveToXLS();

}
