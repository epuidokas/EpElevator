public class ElevatorJob {

    private Integer priority = 0;
    private Integer location = 0;

    public ElevatorJob(Integer priority, Integer location) {
        this.priority = priority;
        this.location = location;
    }

    public Integer getPriority() {
        return priority;
    }
    public Integer getLocation() {
        return location;
    }
}
