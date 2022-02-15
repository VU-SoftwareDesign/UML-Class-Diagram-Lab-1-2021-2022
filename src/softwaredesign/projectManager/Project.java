package softwaredesign.projectManager;

import java.util.*;

public class Project {
    //Use "this" for creating new instance of class in the parameters

    private final String name;
    private final UUID uuid;

    private final List<TaskList> taskLists;
    private final List<Employee> employees;

    public Project(String name, List<TaskList> taskLists, List<Employee> employees) {
        this.name = name;
        this.taskLists = taskLists;
        this.employees = employees;
        this.uuid = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        return new Project(name, this.taskLists, this.employees);
    }

    public List<TaskList> getTaskLists() {
        return this.taskLists;
    }

//    public Map<Task, TaskList> getAllTasks() {
//        Map<Task, TaskList> taskMap = new HashMap<>();
//
//        for (TaskList t : taskLists) {
//            Iterator<Task> it = t.iterator();
//
//            while (it.hasNext()) {
//                taskMap.put(it.next(), t);
//            }
//        }
//        return taskMap;

//    }

    public Project addTaskList(TaskList taskList) {
        List<TaskList> copiedTaskList = new ArrayList<>(taskLists);
        copiedTaskList.add(taskList);
        return new Project(this.name, copiedTaskList, this.employees);
    }

    public Project addWorker(Employee employee) {
        List<Employee> copiedEmployeeList = new ArrayList<>(employees);
        copiedEmployeeList.add(employee);
        return new Project(this.name, this.taskLists, copiedEmployeeList);
    }

    public Project replaceTaskList(TaskList oldTaskList, TaskList newTaskList) {
        int index = 0;
        List<TaskList> copiedTaskLists = this.taskLists;
        for (TaskList currentTL : copiedTaskLists) {
            if (currentTL == oldTaskList) {
                copiedTaskLists.remove(oldTaskList);
                copiedTaskLists.add(index, newTaskList);
            }
            //Use try catch here
            else System.out.println("Not found");
        }
        return new Project(this.name, copiedTaskLists, this.employees);
    }


    public Project moveTask(Task task, TaskList previousTaskList, TaskList currentTaskList) {
        TaskList oldTaskList = previousTaskList.removeTask(task);
        TaskList newTaskList = currentTaskList.addTask(task);
        return replaceTaskList(previousTaskList, oldTaskList).replaceTaskList(currentTaskList, newTaskList);
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public UUID getUUID () {
        return this.uuid;
    }
}
