package dataModel;

import java.util.ArrayList;
import java.util.List;

public class Project {
    List<Task> taskList;

    String name;

    public String getName() {
        return name;
    }
    public Project(){
        taskList = new ArrayList<>();
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);

    }
}
