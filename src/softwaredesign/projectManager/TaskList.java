package softwaredesign.projectManager;

import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

//this has to be singletonne
public class TaskList {

    private final String name;

    //Changed from list to task
    private final Task[] tasks;

    private final UUID  uuid;

    public TaskList(String name, Task... tasks) {
        this.name = name;
        this.tasks = tasks;
        this.uuid = UUID.randomUUID();
    }

    public TaskList(String name, UUID id, Task... tasks) {
        this.name = name;
        this.tasks = tasks;
        this.uuid = id;
    }

    public TaskList addTask(Task task) {
        Task[] newTasks = Arrays.copyOf(tasks, tasks.length + 1);
        newTasks[newTasks.length - 1] = task;

        return new TaskList(name, uuid, newTasks);
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
        Task[] newTasks = new Task[tasks.length];

        for (int index = 0; index < tasks.length; index++) {
            if (tasks[index].getUuid().equals(oldTaskId)) {
                newTasks[index] = newTask;
                break;
            }
        }

        return new TaskList(name, uuid, newTasks);
    }

    public TaskList removeTask(Task task) {
        Task[] newTasks = new Task[tasks.length - 1];
        int newIndex = 0;

        for (Task value : tasks) {
            if (value != task) {
                newTasks[newIndex] = value;
                newIndex++;
            }
        }

        return new TaskList(name, uuid, newTasks);
    }

    public UUID getUuid() {
        return uuid;
    }
//    @Override
    public Iterator<Task> iterator() {
        return Arrays.stream(tasks).iterator();
    }
}
