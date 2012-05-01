import java.util.*;

public class EpElevatorController implements ElevatorController {

    private Logger logger = new Logger();

    private static List<ElevatorJob> jobs = new ArrayList<ElevatorJob>();

    private EpElevatorListener elevatorListener;
    private EpButtonListener buttonListener;
    private static List<EpElevator> elevators = new ArrayList<EpElevator>();

    public EpElevatorController()
    {
        elevatorListener = new EpElevatorListener(logger);
        buttonListener = new EpButtonListener(logger);
        logger.log("EpElevatorController started.");
    }

    public void registerElevator(Elevator elevator)
    {
        // @TODO: improve initial job logic to distribute elevators across floors
        addJob(0, 0);
        elevator.attachListener(elevatorListener);
        elevators.add(new EpElevator(elevator));
        logger.log("New elevator registered on floor " + elevator.getLocation() + ".");
    }

    public void registerButton(Button button)
    {
        button.attachListener(buttonListener);
        logger.log("New " + button.getDirection() + " button registered on floor " + button.getLocation() + ".");
    }

    private void addJob(Integer priority, Integer location) {
        jobs.add(new ElevatorJob(priority, location));
    }

    public static void evaluateJobs() {

        // @TODO: Complete jobs calculating overall best score; not just in order of priority
        SortedMap<Integer, ElevatorJob> rankedJobs = new TreeMap<Integer, ElevatorJob>();
        for (ElevatorJob job : jobs) {
            rankedJobs.put(job.getPriority(), job);
        }

        for (Map.Entry<Integer,ElevatorJob> jobEntry : rankedJobs.entrySet()) {
            if (!elevators.isEmpty()) {
                ElevatorJob job = jobEntry.getValue();
                EpElevator bestElevator = null;
                Integer score = -1;

                for (EpElevator elevator : elevators) {
                    if (!elevator.isBusy() && elevator.getScore(job) > score) {
                        bestElevator = elevator;
                    }
                }

                if (bestElevator != null) {
                    bestElevator.handleJob(job);
                }
            }
        }
    }

}
