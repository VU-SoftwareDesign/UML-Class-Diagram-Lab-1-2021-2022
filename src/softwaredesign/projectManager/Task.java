package softwaredesign.projectManager;

import java.util.UUID;

public class Task {
    private final String name;
    private final Skill[] skills;
    private final double estimatedTime;
    private final Employee assignedEmployee;
    private static final UUID uuid = UUID.randomUUID();

    public Task (String name, Skill[] skills, double estimatedTime, Employee assignedEmployee) {
        this.name = name;
        this.skills = skills;
        this.estimatedTime = estimatedTime;
        this.assignedEmployee = assignedEmployee;
    }

    //Add a method to ensure it is assigned to atleast one employee.
    //Or perhaps keep track of all tasks, which one is assigned to which.

    public String getTaskName () {
        return name;
    }

    //Look into immutable lists and how to handle them
//    public Task addSkill (Skill skill) {
//        final List<Skill> updatesSkills = new ArrayList<>();
//        return new Task(name, , estimatedTime, assignedEmployee);
//    }

    public void printSkills () {
        System.out.println("Current skills:\n");
        for (Skill element : skills) {
            System.out.println(element.getName());
        }
    }

//    public Task removeSkill (Skill skill) {
//
//    }

    public Task setEstimatedTime (double estimatedTime) {
        return new Task(name, skills , estimatedTime, assignedEmployee);
    }

    public double getEstimateTime () {
        return estimatedTime;
    }

    //setAssignedEmployee instead of assign employee
    public Task setAssignedEmployee (Employee employee) {
        return new Task(name, skills , estimatedTime, employee);
    }

    public Employee getAssignedEmployee () {
        return assignedEmployee;
    }

    public UUID getUuid() {
        return uuid;
    }
}
