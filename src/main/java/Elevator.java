public interface Elevator {
    public void attachListener(ElevatorListener elevatorListener);
    public Integer getLocation();
    public Integer getDirection();
}
