package softwaredesign.projectManager;

import java.util.UUID;

public class Status {
    private final String status;

    public Status(String status) {
        this.status = status;
    }

    public Status setStatus(String newStatus) {
        return new Status(newStatus);
    }

    public String getStatus() {
        return status;
    }
}
