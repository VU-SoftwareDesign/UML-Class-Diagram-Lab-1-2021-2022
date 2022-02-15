package softwaredesign.projectManager;
import java.util.UUID;

final public class Skill {
    //Be sure to mention the difference between this and status. (particularly the enumeration)
    private final String name;
    private final UUID uuid;

    public Skill(String name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}