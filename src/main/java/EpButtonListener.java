public class EpButtonListener implements ButtonListener {

    Logger logger;

    public EpButtonListener(Logger logger) {
        this.logger = logger;
    }

    public void onPush(Button button){
        logger.log("Button pushed!");
    }
}
