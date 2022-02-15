package softwaredesign.projectManager;

import java.util.*;

//Each task has to be assigned to atleast one employee. Map is a good option here.
public class TaskList {
    //can use map to with uuid .

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
        List<Task> copiedTaskList = new ArrayList<>(this.tasks);
        copiedTaskList.add(task);
        return new TaskList(this.name, copiedTaskList);
    }

    public String getName() {
        return this.name;
    }

    public boolean contains(UUID taskId) {
        for (Task t : this.tasks) {
            if (t.getUuid().equals(taskId)) {
                return true;
            }
        }
        return false;
    }

    public TaskList replaceTask(UUID oldTaskId, Task newTask) {
        List<Task> copiedTaskList = new ArrayList<>(this.tasks);
        int index = 0;
        for (Task t : copiedTaskList) {
            if (t.getUuid().equals(oldTaskId)) {
                copiedTaskList.remove(t);
                copiedTaskList.add(index, newTask);
            }
            index++;
        }
        return new TaskList(this.name, copiedTaskList);
    }

    public TaskList removeTask(Task task) {
        List<Task> copiedTaskList = new ArrayList<>(tasks);
        for (Task currentTask : tasks) {
            if (currentTask == task) {
                copiedTaskList.remove(task);
            }
            else System.out.println("Task not found");
        }
        return new TaskList(this.name, copiedTaskList);
    }

    public UUID getUuid() {
        return this.uuid;
    }
//    @Override
//    public Iterator<Task> iterator() {
//        return Arrays.stream(tasks).iterator();
//    }
}
