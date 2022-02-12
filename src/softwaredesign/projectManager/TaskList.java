package softwaredesign.projectManager;

import java.util.*;

//this has to be singletonne.
//Each task has to be assigned to atleast one employee. Map is a good option here.
public class TaskList {

    private final String name;

    //Changed from list to task
    private final List<Task> tasks;

    private final UUID uuid;

    public TaskList(String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
        this.uuid = UUID.randomUUID();
    }

    public TaskList(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.tasks = new ArrayList<>();
    }

    public TaskList addTask(Task task) {
        List<Task> copiedTaskList = new ArrayList<>(tasks);
        copiedTaskList.add(task);
        return new TaskList(name, copiedTaskList);
    }

    public String getName() {
        return name;
    }

    public boolean contains(UUID taskId) {
        for (Task t : tasks) {
            if (t.getUuid().equals(taskId)) {
                return true;
            }
        }
        return false;
    }

    public TaskList replaceTask(UUID oldTaskId, Task newTask) {
        List<Task> copiedTaskList = new ArrayList<>(tasks);
        int index = 0;
        for (Task t : tasks) {
            if (t.getUuid().equals(oldTaskId)) {
                copiedTaskList.remove(t);
                copiedTaskList.add(index, newTask);
            }
            index++;
        }
        return new TaskList(name, copiedTaskList);
    }

    public TaskList removeTask(Task task) {
        List<Task> copiedTaskList = new ArrayList<>(tasks);
        int index = 0;
        for (Task currentTask : tasks) {
            if (currentTask == task) {
                copiedTaskList.remove(task);
            }
            index++;
        }

        return new TaskList(name, copiedTaskList);
    }

    public UUID getUuid() {
        return uuid;
    }
//    @Override
//    public Iterator<Task> iterator() {
//        return Arrays.stream(tasks).iterator();
//    }
}
