package dataModel;

import java.util.Date;

public class Task {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Employee getAsignee() {
        return asignee;
    }

    public void setAsignee(Employee asignee) {
        this.asignee = asignee;
    }

    String description;
    Date date;
    int time;
    Employee asignee;

}
