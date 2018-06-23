package reports;

public interface iReporting {

    //creates the report object
    public abstract iReporting calculate(String year);

    public abstract void printReportToConsole();

    public abstract void saveToPDF();

    public abstract void saveToXLS();

}
