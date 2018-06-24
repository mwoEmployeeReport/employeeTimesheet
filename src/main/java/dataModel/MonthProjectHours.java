package dataModel;

public class MonthProjectHours {
	public int month;
	public String project;
	public double hours;
	
	public MonthProjectHours(int month, String project, double hours) {
		this.month= month;
		this.project = project;
		this.hours = hours;
	}
	
	public void addHours(double hoursToAdd) {
		this.hours += hoursToAdd;
	}
}
