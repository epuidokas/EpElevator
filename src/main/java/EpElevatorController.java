public class EpElevatorController implements ElevatorController {

    Logger logger = new Logger();

    public EpElevatorController()
    {
        logger.log("EpElevatorController started.");
    }

    public void registerElevator(Elevator elevator)
    {
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
}
