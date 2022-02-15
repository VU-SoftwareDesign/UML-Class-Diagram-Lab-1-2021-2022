package softwaredesign.projectManager;

import java.util.*;

public class Project {
    //Use "this" for creating new instance of class in the parameters

    //Need to add a method to set status of projects :- Tracking projects: mark tasks as "ready to start" -"executing" - "finished".
    private final String name;

    private final List<TaskList> taskLists;
    private final List<Employee> employees;

    //Need for uuid? Multiple projects?

    public Project(String name, List<TaskList> taskLists, List<Employee> employees) {
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

    public List<TaskList> getTaskLists() {
        return taskLists;
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
        return new Project(name, copiedTaskList, employees);
    }

    public Project addWorker(Employee employee) {
        List<Employee> copiedEmployeeList = new ArrayList<>(employees);
        copiedEmployeeList.add(employee);
        return new Project(name, taskLists, copiedEmployeeList);
    }

    public Project replaceTaskList(TaskList oldTaskList, TaskList newTaskList) {
        int index = 0;
        List<TaskList> copiedTaskLists = taskLists;
        for (TaskList currentTL : taskLists) {
            if (currentTL == oldTaskList) {
                copiedTaskLists.remove(oldTaskList);
                copiedTaskLists.add(index, newTaskList);
            }
            //Use try catch here
            else System.out.println("Not found");
        }
        return new Project(name, copiedTaskLists, employees);
    }


    public Project moveTask(Task task, TaskList previousTaskList, TaskList currentTaskList) {
        TaskList oldTaskList = previousTaskList.removeTask(task);
        TaskList newTaskList = currentTaskList.addTask(task);
        return replaceTaskList(previousTaskList, oldTaskList).replaceTaskList(currentTaskList, newTaskList);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
