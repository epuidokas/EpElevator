import java.util.ArrayList;
import java.util.List;

public class EpElevatorController implements ElevatorController {

    private Logger logger = new Logger();

    private List<ElevatorJob> jobs = new ArrayList<ElevatorJob>();

    private EpElevatorListener elevatorListener;
    private EpButtonListener buttonListener;

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
        logger.log("New elevator registered.");
    }

    public void registerButton(Button button)
    {
        button.attachListener(buttonListener);
        logger.log("New button registered.");
    }

    private void addJob(Integer priority, Integer location) {
        jobs.add(new ElevatorJob(priority, location));
    }
}
