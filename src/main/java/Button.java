public interface Button {
    public void attachListener(ButtonListener buttonListener);
    public Integer getDirection();
    public Integer getLocation();
    public boolean getState();
}
