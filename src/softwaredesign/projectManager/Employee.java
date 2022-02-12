package softwaredesign.projectManager;
import java.util.*;
import java.util.UUID;
import java.util.ArrayList; // import the ArrayList class

public class Employee {

    private final String name;
    private final UUID uuid;
    private final double workedHours;
    private final List<Skill> skills;

    //Limit maxWorkHours to 40, add a boolean to ensure it does not top it.

    public Employee(String name, double maxWorkHours, List<Skill> skills) {
        this.name = name;
        this.workedHours = maxWorkHours;
        this.skills = skills;
        this.uuid = UUID.randomUUID();
    }

    //Extra constructor
    public Employee(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.workedHours = 0D;
        this.skills = new ArrayList<>();
    }

    public Employee setName(String newName) {
        return new Employee(newName, workedHours, skills);
    }

    public String getName() {
        return name;
    }

    public Employee setHours(Double hours) {
        return new Employee(name, hours, skills);
    }

    public Double getHours() {
        return workedHours;
    }

    public Employee setSkills(List<Skill> newSkills) {
        return new Employee(name, workedHours, newSkills);
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Employee removeSkill(Skill skill) {
        List<Skill> updatedSkills = new ArrayList<> (skills);
        for (Skill currentSkill : updatedSkills) {
            if (currentSkill == skill) {
                updatedSkills.remove(skill);
            }
            //Use catch
            else System.out.println("Skill not found");
        }
        return new Employee(name, workedHours, updatedSkills);
    }

    public Employee addSkill(Skill skill) {
        List<Skill> updatedSkills = new ArrayList<> (skills);
        updatedSkills.add(skill);
        return new Employee(name, workedHours, updatedSkills);
    }

    public String print () {
        String messageToBePrinted = "Employee name:" + name + "\nHours worked: " + workedHours + "\nSkills: ";
        System.out.print(messageToBePrinted);

        for (Skill currentSkill : skills) {
            System.out.print(currentSkill.getName() + " ");
        }
        System.out.println("\n");
        return messageToBePrinted;
    }
}