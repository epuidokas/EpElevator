public class EpElevator {
    private Elevator elevator;
    private boolean state = false;

    public EpElevator(Elevator elevator)
    {
        this.elevator = elevator;
    }

    public Integer getScore(ElevatorJob job) {

        // @TODO make score calculation much smarter
        Integer score = 0;

        // Increase score if elevator door is closed.
        if (!elevator.isDoorOpen()) {
            score++;
        }

        // Increase score if elevator isn't moving
        if (elevator.getDirection() == 0) {
            score = score + 5;
        }

        // Increase score if elevator is nearby job already
        score = score + (10 - Math.abs(elevator.getLocation() - job.getLocation()));

        return score;
    }

    public boolean isBusy()
    {
        return state;
    }

    public void handleJob(ElevatorJob job) {
        state = true;
        elevator.setDestination(job.getLocation());
    }
}
