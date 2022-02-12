package softwaredesign.projectManager;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class test {
    String[] skillNames = {"Programming", "Driving", "Cooking", "Music"};
    String[] employeeNames = {"Bobby", "Sammy", "Pink man"};
    String[] tasks = {"Wash car", "Cook food", "Eat", "Sleep", "Build a rocket", "Get a million dollars", "Do a moon dance"};
    String[] status = {"Ready to start", "Executing", "Finished"};

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

    public List<Task> taskList (List<Status> statuses, List<Employee> employees, String[] tasksNames) {
        List<TaskList> taskList = new ArrayList<>();

        for (String currentTaskName : tasksNames) {
            List<Employee> assignedEmployees = new ArrayList<>();
            Collections.shuffle(employees);
            assignedEmployees.add(employees.get(0));
            taskList.add(new Task (currentTaskName, 0d, assignedEmployees, statuses));
        }
    }

    public List<Status> createStatus (String[] statuses) {
        List<Status> statusList = new ArrayList<>();
        for (String status : statuses) {
            statusList.add(new Status(status));
        }
        return statusList;
    }
    List<Status> statusess = new ArrayList<>(createStatus(status));
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

   @Test

}