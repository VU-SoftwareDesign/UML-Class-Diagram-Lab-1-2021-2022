package softwaredesign.projectManager;


public class Status {
    //Enumeration of all the status --> DONE
    //Changes made to task as a result. Check there for relevant changes
    private final Progress currentStatus;

    //To change status of Progress, you can only choose so from the enumeration below.
    enum Progress {
        READY {
            @Override
            public String toString() {
                return "Task ready to start";
            }
        },
        EXECUTING {
            @Override
            public String toString() {
                return "Task in Progress";
            }
        },
        FINISHED {
            @Override
            public String toString() {
                return "Task finished!";
            }
        }
    }

    public Status(Progress currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Status () {
        this.currentStatus = Progress.READY;
    }

    public void printStatus () {
        System.out.println(currentStatus);
    }
}
