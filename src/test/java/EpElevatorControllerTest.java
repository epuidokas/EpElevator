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
            epElevatorController.registerElevator(new PhysicalElevator(0, 0));
        }

        // Register 20 buttons (10 floors)
        for (Integer i = 0; i < 20; i++) {
            epElevatorController.registerButton(new PhysicalButton(i/2, i%2));
        }
    }

    class PhysicalElevator implements Elevator {

        List<ElevatorListener> listeners = new ArrayList<ElevatorListener>();

        private Integer location;

        // -1 = down, 0 = not moving, 1 = up
        private Integer direction;

        public PhysicalElevator(Integer location, Integer direction)
        {
            this.location = location;
            this.direction = direction;
        }

        public void attachListener(ElevatorListener elevatorListener)
        {
            listeners.add(elevatorListener);
        }

        public Integer getLocation()
        {
            return location;
        }

        public Integer getDirection()
        {
            return direction;
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

        private Integer location;

        // 0 = down, 1 = up
        private Integer direction;

        public PhysicalButton(Integer location, Integer direction)
        {
            this.location = location;
            this.direction = direction;
        }

        public void attachListener(ButtonListener buttonListener)
        {
            listeners.add(buttonListener);
        }

        public Integer getLocation()
        {
            return location;
        }

        public Integer getDirection()
        {
            return direction;
        }

        public boolean getState()
        {
            return false;
        }

    }
}
