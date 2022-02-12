package softwaredesign.projectManager;
import java.util.*;
import java.util.UUID;

public class Employee {

    private final String name;
    private final UUID uuid;
    private final double maxWorkHours;
    private final Skill[] skills;

    //Limit maxWorkHours to 40, add a boolean to ensure it does not top it.

    public Employee(String name, UUID uuid, double maxWorkHours, Skill[] skills) {
        this.name = name;
        this.uuid = uuid;
        this.maxWorkHours = maxWorkHours;
        this.skills = skills;
    }

    //Extra constructor
    public Employee(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.maxWorkHours = 0D;
    }

    public Employee setName(String newName) {
        return new Employee(newName, uuid, maxWorkHours, skills);
    }

    public String getName() {
        return name;
    }

    public Employee setHours(Double hours) {
        return new Employee(name, uuid, hours, skills);
    }

    public Double getHours() {
        return maxWorkHours;
    }

    public Employee setSkills(List<Skill> newSkills) {
        return new Employee(name, uuid, maxWorkHours, newSkills);
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public UUID getUuid() {
        return uuid;
    }

    //To do: Create a skillList class to handle all the skill related methods
    public Employee removeSkill(Skill skill) {
        Skill[] newSkills = new Skill[skills.length - 1];
        int newIndex = 0;
        for (Skill value : newSkills) {
            if (value != skill) {
                newSkills[newIndex] = value;
                newIndex++;
            }
        }
        return new Employee(name, uuid, maxWorkHours, newSkills);
    }

    public Employee addSkill(Skill skill) {
        Skill[] newSkills = Arrays.copyOf(skills, skills.length + 1);
        newSkills[newSkills.length - 1] = skill;

        return new Employee(name, uuid, maxWorkHours, newSkills);
    }

    public String print () {
        String messageToBePrinted = "Employee name:" + name + "\nHours worked: " + maxWorkHours;
        System.out.println(messageToBePrinted);
        return messageToBePrinted;
    }
}