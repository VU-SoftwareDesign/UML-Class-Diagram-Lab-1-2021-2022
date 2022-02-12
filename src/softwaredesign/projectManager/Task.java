package softwaredesign.projectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Task {
    private final Status status;
    private final String name;
    private final double estimatedTime;
    private static final UUID uuid = UUID.randomUUID();
    private final List<Employee> assignedEmployees;
    public Task (String name, double estimatedTime, List<Employee> assignedEmployees, Status status) {
        this.name = name;
        this.estimatedTime = estimatedTime;
        this.assignedEmployees = assignedEmployees;
        this.status = status;
    }

    public String getTaskName () {
        return name;
    }

    public Task setEstimatedTime (double estimatedTime) {
        return new Task(name, estimatedTime, assignedEmployees, status);
    }

    public double getEstimateTime () {
        return estimatedTime;
    }

    //setAssignedEmployee instead of assign employee
    public Task setAssignedEmployees (List<Employee> setAssignedEmployees) {
        return new Task(name , estimatedTime, setAssignedEmployees, status);
    }

    public List<Employee> getAssignedEmployees () {
        return assignedEmployees;
    }

    public Task assignEmployeeToTask (Employee employee) {
        List<Employee> copiedAssignedEmployees = new ArrayList<> (assignedEmployees);
        copiedAssignedEmployees.add(employee);
        return new Task(name , estimatedTime, copiedAssignedEmployees, status);
    }

    public Task setStatus (Status status) {
        return new Task (name, estimatedTime, assignedEmployees, status);
    }

    public Status getStatus () {
        return status;
    }

    public UUID getUuid() {
        return uuid;
    }
}
