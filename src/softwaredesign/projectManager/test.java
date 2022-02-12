package softwaredesign.projectManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test {
    String[] skillNames = {"Programming", "Driving", "Cooking", "Music"};
    String[] employeeNames = {"Bobby", "Sammy", "Pink man"};

    //Use string array to create and add skills to an arrayList.
    public List<Skill> createSkillList (String[] skillNames) {
        List<Skill> skills = new ArrayList<>();
        for (String skill : skillNames) {
            skills.add(new Skill(skill));
        }
        return skills;
    }

    public List<Employee> createEmployeeList (List<Skill> skills, String[] employeeNames) {
        List<Employee> employeesList = new ArrayList<>();
        for (String currentName : employeeNames) {
            employeesList.add(new Employee(currentName, 0d,  skills));
        }
        return employeesList;
    }

    List<Skill> skills = new ArrayList<>(createSkillList(skillNames));
    List<Employee> employees = new ArrayList<>(createEmployeeList(skills, employeeNames));

   @Test
   public void printAllEmployees() {
       for (Employee currentEmployee : employees) {
           currentEmployee.print();
       }
   }

   @Test
    public void printList () {
       for (Skill currentSkill: skills){
           System.out.println(currentSkill.getName());
       }
   }

}