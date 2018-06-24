package reports;

import java.util.Map;

import dataModel.Project;
import dataModel.Task;

public class ProjectTotalHoursReport extends iReporting{

	public ProjectTotalHoursReport(){}
	
	
	@Override
    public void calculate(int year) 
	{
		double sumedTime= 0.0;
        for (Project p : dataModel.getProjectList()) 
        {
                for (Task t : p.getTaskList()) 
                {
                   if (t.getDate().getYear() == year) 
                   
                       sumedTime += t.getTime();
                   
               
                }
                System.out.println(p.getName() + " " + String.valueOf(sumedTime));
        }
        
    }

    public void printReportToConsole() 
    {
        for (Map.Entry entry : innerDataModel.entrySet()) 
        {
            System.out.println("Projekt: " + entry.getKey() + "Liczba godzin: " + entry.getValue() + "\n");
        }
    }

    public void saveToPDF() 
    {
        System.out.println("Jeszcze nie zaimplementowano.");
    }

    public void saveToXLS() 
    {
        System.out.println("Jeszcze nie zaimplementowano.");
    }
	
	
	
}
