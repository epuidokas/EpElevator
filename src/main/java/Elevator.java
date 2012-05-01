public interface Elevator {
    public void attachListener(ElevatorListener elevatorListener);
    public Integer getLocation();
    public Integer getDirection();
    public boolean isDoorOpen();

    public void setDestination(Integer floor);
    public void closeDoor();
    public void openDoor();
}
