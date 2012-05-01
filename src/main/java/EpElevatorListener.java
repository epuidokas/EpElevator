public class EpElevatorListener implements ElevatorListener {

    Logger logger;

    public EpElevatorListener(Logger logger) {
        this.logger = logger;
    }

    public void onDirectionChange(Elevator elevator){
        logger.log("Elevator direction changed.");
    }

    public void onDoorOpen(Elevator elevator){
        logger.log("Elevator door opened.");
    }

    public void onDoorClose(Elevator elevator){
        logger.log("Elevator door closed.");
    }
}
