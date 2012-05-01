import java.util.ArrayList;
import java.util.List;

public class EpElevatorControllerTest extends junit.framework.TestCase {
    public void setUp() throws Exception {

    }

    public void tearDown() throws Exception {

    }

    public void testElevatorManager() throws Exception {
        EpElevatorController epElevatorController = new EpElevatorController();

        // Register 2 elevators
        for (Integer i = 0; i < 2; i++) {
            epElevatorController.registerElevator(new PhysicalElevator());
        }

        // Register 20 buttons (10 floors)
        for (Integer i = 0; i < 20; i++) {
            epElevatorController.registerButton(new PhysicalButton());
        }

    }

    class PhysicalElevator implements Elevator {

        List<ElevatorListener> listeners = new ArrayList<ElevatorListener>();

        public void attachListener(ElevatorListener elevatorListener)
        {
            listeners.add(elevatorListener);
        }

        public Integer getLocation()
        {
            return 0;
        }

        public Integer getDirection()
        {
            return 0;
        }

        public boolean isDoorOpen()
        {
            return false;
        }

        public void setDestination(Integer floor)
        {

        }

        public void closeDoor()
        {

        }

        public void openDoor()
        {

        }
    }

    class PhysicalButton implements Button {

        List<ButtonListener> listeners = new ArrayList<ButtonListener>();

        public void attachListener(ButtonListener buttonListener)
        {
            listeners.add(buttonListener);
        }

        public Integer getLocation()
        {
            return 0;
        }

        public Integer getDirection()
        {
            return 0;
        }

        public boolean getState()
        {
            return false;
        }

    }
}
