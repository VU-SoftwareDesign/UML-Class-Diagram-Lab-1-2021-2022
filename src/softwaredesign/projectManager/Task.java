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
    private final List<Skill> requiredSkills;
    public Task (String name, double estimatedTime, List<Employee> assignedEmployees, Status currentStatus, List<Skill> requiredSkills) {
        this.name = name;
        this.estimatedTime = estimatedTime;
        this.assignedEmployees = assignedEmployees;
        this.status = currentStatus;
        this.requiredSkills = requiredSkills;
    }


    public String getTaskName () {
        return name;
    }

    public Task setEstimatedTime (double estimatedTime) {
        return new Task(name, estimatedTime, assignedEmployees, status, requiredSkills);
    }

    public double getEstimateTime () {
        return estimatedTime;
    }

    //setAssignedEmployee instead of assign employee
    public Task setAssignedEmployees (List<Employee> setAssignedEmployees) {
        return new Task(name , estimatedTime, setAssignedEmployees, status, requiredSkills);
    }

    public List<Employee> getAssignedEmployees () {
        return assignedEmployees;
    }

    public Task assignEmployeeToTask (Employee employee) {
        //Add a check to ensure employee has the skills to perform the task. If the employee does not have all the required skills,
        //Either reject adding the employee or print out the employee does not meet the requirements, and store it in a map of employee and missing skills
        //rasing an exception
        if (isAssigned(employee)) {
            //Need to throw exceptions here
            System.out.println("Employee already assigned");
            return new Task(this.name , estimatedTime, assignedEmployees, status, requiredSkills);
        }
        else {
            List<Employee> copiedAssignedEmployees = new ArrayList<>(assignedEmployees);
            copiedAssignedEmployees.add(employee);
            return new Task(name , estimatedTime, copiedAssignedEmployees, status, requiredSkills);
        }
    }

    //method to replace any of the given lists? like to replace the assigned employee list

    public List<Skill> getRequiredSkills () { return requiredSkills;}

    public Task addRequiredSkill (Skill skill) {
        List<Skill> copiedRequiredSkill = new ArrayList<> (requiredSkills);
        copiedRequiredSkill.add(skill);
        return new Task(name , estimatedTime, assignedEmployees, status, copiedRequiredSkill);
    }

    public Task setStatus (Status.Progress newStatus) {
        return new Task (name, estimatedTime, assignedEmployees, new Status(newStatus), requiredSkills);
    }

    public Status getStatus () {
        return this.status;
    }

    public void printStatus() {
        this.status.printStatus();
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean taskAssigned () {
        return assignedEmployees.size() >= 1;
    }

    public boolean isAssigned (Employee employee) {
        return this.assignedEmployees.contains(employee);
    }
}
