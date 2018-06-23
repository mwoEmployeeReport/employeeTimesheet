package reports;

public class EmployeeTotalHoursReport implements iReporting{

    EmployeeTotalHoursReport(){}

    EmployeeTotalHoursReport(String year){}

    public iReporting calculate(String data) {
        return new EmployeeTotalHoursReport(data);
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
