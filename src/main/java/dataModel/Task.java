package dataModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;

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

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
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
    double time;
    Employee asignee;

    public void setDate(String cellValue) {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

        try {
            setDate(format.parse(cellValue));
        } catch (ParseException e) {
            e.printStackTrace();

            }
    }


}
