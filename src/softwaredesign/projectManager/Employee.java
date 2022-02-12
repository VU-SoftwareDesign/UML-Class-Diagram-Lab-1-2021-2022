package softwaredesign.projectManager;
import java.util.*;
import java.util.UUID;

public class Employee {
    
    private final String name;
    private final UUID uuid;
    private final double maxWorkHours;
    //Need to think about what skills are
//    private final Skill[] skills;

    public Employee (String name, UUID uuid, double maxWorkHours, Skill[] skills) {
        this.name = name;
        this.uuid = uuid;
        this.maxWorkHours = maxWorkHours;
//        this.skills = skills;
    }

    //Extra constructor
    public Employee (String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.maxWorkHours = 0D;
//        this.skills = new ArrayList<Skill>();
    }

    public Employee setName (String newName) {
        return new Employee (newName, uuid, maxWorkHours, skills);
    }

    public String getName () {
        return name;
    }

    public Employee setHours (Double hours) {
        return new Employee (name, uuid, hours, skills);
    }

    public Double getHours () {
        return maxWorkHours;
    }

    public Employee setSkills (List<Skill> newSkills) {
        return new Employee (name, uuid, maxWorkHours, newSkills);
    }

    public List<Skill> getSkills () {
        return skills;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String print () {
        String messageToBePrinted = "Employee name:" + name + "\nHours worked: " + maxWorkHours;
        System.out.println(messageToBePrinted);
        return messageToBePrinted;
    }
}