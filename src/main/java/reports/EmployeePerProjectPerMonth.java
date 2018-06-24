package reports;

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
	// HashMap<String, HashMap<String, Integer>>;

	private String createKey(Project project, Task task) {
		return task.getDate().getMonth() + project.getName();
	}

	public void calculate(String employee, String year) {

		// obs³u¿enie pracownika
		// for po projejktach
		// for po taskach
		// if po pracownikach
		for (Project p : dataModel.getProjectList()) {
			for (Task t : p.getTaskList()) {
				if (t.getAsignee().getName().contains(employee)) {
					String key = createKey(p, t);
					if (model.containsKey(key)) {
						model.get(key).addHours(t.getTime());
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
		     System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
		}
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
