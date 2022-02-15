package softwaredesign.projectManager;

final public class Skill {
    //Be sure to mention the difference between this and status. (particularly the enumeration)
    private final String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Skill setName(String newSkill) {return new Skill(newSkill);}
}