package reports;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import dataModel.TimeSheetModel;

public class EmployeeProjectPercentageReport extends iReporting {
    TimeSheetModel timeSheetModel;


    public EmployeeProjectPercentageReport(TimeSheetModel timeSheetModel){
       this.timeSheetModel=timeSheetModel;
    }


    //public void printData();





    @Override
    public void calculate(int year) {

    }

    @Override
    public void printReportToConsole() {

    }

    @Override
    public void saveToPDF() {

    }

    @Override
    public void saveToXLS() {

    }
}
