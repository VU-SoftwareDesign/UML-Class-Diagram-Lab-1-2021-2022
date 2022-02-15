package softwaredesign.projectManager;

import java.util.*;

//Each task has to be assigned to atleast one employee. Map is a good option here.
public class TaskList {
    //can use map to with uuid .

    private final String name;

    //Changed from list to task
    private final Map<UUID, Task> tasks;

    private final UUID uuid;

    public TaskList(String name, Map<UUID, Task> tasks) {
        this.name = name;
        this.tasks = tasks;
        this.uuid = UUID.randomUUID();
    }

    public TaskList(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.tasks = new HashMap<>();
    }

    public TaskList addTask(Task task) {
        Map<UUID, Task> copiedTaskList = new HashMap<>(this.tasks);
        copiedTaskList.put(UUID.randomUUID(), task);
        return new TaskList(this.name, copiedTaskList);
    }

    public String getName() {
        return this.name;
    }

    public boolean contains(UUID taskId) {
        return this.tasks.containsKey(taskId);
    }

    public TaskList replaceTask(UUID oldTaskId, Task newTask) {
        Map<UUID, Task> copiedTaskList = new HashMap<>(this.tasks);
        if (copiedTaskList.containsKey(oldTaskId)) {
            copiedTaskList.remove(oldTaskId);
            copiedTaskList.put(UUID.randomUUID(), newTask);
        }
        return new TaskList(this.name, copiedTaskList);
    }

    public TaskList removeTask(UUID oldTaskId) {
        Map<UUID, Task> copiedTaskList = new HashMap<>(this.tasks);
        if (copiedTaskList.containsKey(oldTaskId)) {
            copiedTaskList.remove(oldTaskId);
        }
        else {System.out.println("Task not found");}
        return new TaskList(this.name, copiedTaskList);
    }

    public UUID getUuid() {
        return this.uuid;
    }
}
