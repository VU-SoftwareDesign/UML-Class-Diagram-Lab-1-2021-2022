package softwaredesign.projectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Task {
    private final String name;
    //Why are skills here?
    private final Skill[] skills;
    private final double estimatedTime;
    private static final UUID uuid = UUID.randomUUID();
    private final List<Employee> assignedEmployees;
    public Task (String name, Skill[] skills, double estimatedTime, List<Employee> assignedEmployees) {
        this.name = name;
        this.skills = skills;
        this.estimatedTime = estimatedTime;
        this.assignedEmployees = assignedEmployees;
    }

    public String getTaskName () {
        return name;
    }

    public void printSkills () {
        System.out.println("Current skills:\n");
        for (Skill element : skills) {
            System.out.println(element.getName());
        }
    }

    public Task setEstimatedTime (double estimatedTime) {
        return new Task(name, skills , estimatedTime, assignedEmployees);
    }

    public double getEstimateTime () {
        return estimatedTime;
    }

    //setAssignedEmployee instead of assign employee
    public Task setAssignedEmployee_s (List<Employee> newAssignedEmployee_s) {
        return new Task(name, skills , estimatedTime, newAssignedEmployee_s);
    }

    public List<Employee> getAssignedEmployee_s () {
        return assignedEmployees;
    }

    public Task assignEmployeeToTask (Employee employee) {
        List<Employee> copiedAssignedEmployees = new ArrayList<> (assignedEmployees);
        copiedAssignedEmployees.add(employee);
        return new Task(name, skills , estimatedTime, copiedAssignedEmployees);
    }

    public UUID getUuid() {
        return uuid;
    }
}
