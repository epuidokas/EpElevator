public interface ElevatorListener {
    public void onDirectionChange(Elevator elevator);
    public void onDoorOpen(Elevator elevator);
    public void onDoorClose(Elevator elevator);
}
