import java.util.ArrayList;
import java.util.List;

public class EpElevatorController implements ElevatorController {

    Logger logger = new Logger();

    List<ElevatorJob> jobs = new ArrayList<ElevatorJob>();

    public EpElevatorController()
    {

        logger.log("EpElevatorController started.");
    }

    public void registerElevator(Elevator elevator)
    {
        addJob(0, 0);
        logger.log("New elevator registered.");
    }

    public void registerButton(Button button)
    {
        logger.log("New button registered.");
    }

    public class Logger {
        public void log(String msg) {
            System.out.println(msg);
        }
    }

    private void addJob(Integer priority, Integer location) {
        jobs.add(new ElevatorJob(priority, location));
    }
}
