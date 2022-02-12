package softwaredesign.projectManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Project {
    //Need to add a method to set status of projects :- Tracking projects: mark tasks as "ready to start" -"executing" - "finished".
    private final String name;

    private final TaskList[] taskLists;

    private final Employee[] employees;

    //Need for uuid? Multiple projects?

    public Project(String name, TaskList[] taskLists, Employee[] employees) {
        this.name = name;
        this.taskLists = taskLists;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        return new Project(name, taskLists, employees);
    }

    public TaskList[] getTaskLists() {
        return taskLists;
    }

    public Map<Task, TaskList> getAllTasks() {
        Map<Task, TaskList> taskMap = new HashMap<>();

        for (TaskList t : taskLists) {
            Iterator<Task> it = t.iterator();

            while (it.hasNext()) {
                taskMap.put(it.next(), t);
            }
        }

        return taskMap;
    }

    public Project setTaskList(TaskList[] taskLists) {
        return new Project(name, taskLists, employees);
    }

    public Project addTaskList(TaskList taskList) {
        TaskList[] newTaskLists = Arrays.copyOf(this.taskLists, this.taskLists.length + 1);
        newTaskLists[newTaskLists.length - 1] = taskList;
        return setTaskList(newTaskLists);
    }

    public Project addWorker(Employee worker) {
        Employee[] workers = Arrays.copyOf(this.employees, this.employees.length + 1);
        workers[workers.length - 1] = worker;
        return new Project(name, taskLists, workers);
    }

    public Project replaceTaskList(TaskList oldTaskList, TaskList newTaskList) {
        TaskList[] newTaskLists = taskLists.clone();
        for(int i = 0; i < taskLists.length; i++) {
            if(taskLists[i] == oldTaskList) {
                newTaskLists[i] = newTaskList;
                return setTaskList(newTaskLists);
            }
        }
        throw new IllegalStateException();
    }


    public Project moveTask(Task task, TaskList previousTaskList, TaskList currentTaskList) {
        TaskList oldTaskList = previousTaskList.removeTask(task);
        TaskList newTaskList = currentTaskList.addTask(task);

        return replaceTaskList(previousTaskList, oldTaskList).replaceTaskList(currentTaskList, newTaskList);
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
