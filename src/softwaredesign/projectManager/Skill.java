package softwaredesign.projectManager;
import java.util.UUID;

final public class Skill {
    private final String name;
    private final UUID uuid;

    public Skill(String name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }
}