package reports;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import dataModel.MonthProjectHours;
import dataModel.Project;
import dataModel.Task;

public class EmployeePerProjectPerMonth extends iReporting implements iRaportPrinter {

	public EmployeePerProjectPerMonth() {
	}

	TreeMap<String, MonthProjectHours> model = new TreeMap<String, MonthProjectHours>();

	private String createKey(Project project, Task task) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(task.getDate());
		int month = cal.get(Calendar.MONTH);
		return month+1 + " " + project.getName();
	}

	public void calculate(String employee, String year) {

		for (Project p : dataModel.getProjectList()) {
			for (Task t : p.getTaskList()) {
				if (t.getAsignee().getName().contains(employee)) {
					String key = createKey(p, t);
					if (model.containsKey(key)) {
						MonthProjectHours month = model.get(key);
						month.addHours(t.getTime());
					} else {
						Calendar cal = Calendar.getInstance();
						cal.setTime(t.getDate());
						int month = cal.get(Calendar.MONTH);
						MonthProjectHours reportElement = new MonthProjectHours(month, p.getName(), t.getTime());
						model.put(key, reportElement);
	
					}

				}
			}
		}
	}

	@Override
		public void printReportToConsole () {
		for (Map.Entry<String, MonthProjectHours> entry : model.entrySet()) {
		     System.out.println("Miesiac: " + entry.getKey()  + ". Laczny czas pracy: " + entry.getValue().getHours());
		}
	}
	String getMonthName(int monthNumber) {
	    String[] months = new DateFormatSymbols().getMonths();
	    int n = monthNumber-1;
	    return (n >= 0 && n <= 11) ? months[n] : "wrong number";
	}

	@Override
	public void calculate(int year) {
		// TODO Auto-generated method stub

	}


	@Override
	public void saveToPDF() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveToXLS() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printRaport() {
		// TODO Auto-generated method stub
		
	}

}