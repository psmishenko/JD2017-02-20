package by.it.Zyryanov.jd01_08;


public abstract class CoupeCar implements ITransport {

    private boolean isMoving;
    private String getSpeed;
    private boolean isEngineWorking;
    private boolean isACWorking;
    private boolean isDoorsClosed;
    private boolean isSportModeOn;
    public String color;


    public CoupeCar() {
        this.isMoving = false;
        this.getSpeed = "0";
        this.isEngineWorking = false;
        this.isACWorking = false;
        this.isDoorsClosed = true;
        this.isSportModeOn = true;
    }

    public boolean isSportModeOn() {
        return isSportModeOn;
    }

    public void setSportModeOn(boolean sportModeOn) {
        isSportModeOn = sportModeOn;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public String getGetSpeed() {
        return getSpeed;
    }

    public void setGetSpeed(String getSpeed) {
        this.getSpeed = getSpeed;
    }

    public boolean isEngineWorking() {
        return isEngineWorking;
    }

    public void setEngineWorking(boolean engineWorking) {
        isEngineWorking = engineWorking;
    }

    public boolean isACWorking() {
        return isACWorking;
    }

    public void setACWorking(boolean ACWorking) {
        isACWorking = ACWorking;
    }

    public boolean isDoorsClosed() {
        return isDoorsClosed;
    }

    public void setDoorsClosed(boolean doorsClosed) {
        isDoorsClosed = doorsClosed;
    }

    @Override
    public void go() {
        isMoving = true;
    }

    @Override
    public void getSpeed() {
        if (isMoving) {
            System.out.println("\n Скорость 140 км/ч");
        } else {
            System.out.println("\n Скорость 0 км/ч");
        }
    }

    @Override
    public void startEngine() {
        isEngineWorking = true;
    }

    @Override
    public void stopEngine() {
        isEngineWorking = false;
        isMoving = false;
    }

    @Override
    public void turnACOn() {
        isACWorking = true;
    }

    @Override
    public void turnACOff() {
        isACWorking = false;
    }

    @Override
    public void lockDoors() {
        isDoorsClosed = true;
    }

    @Override
    public void unlockDoors() {
        isDoorsClosed = false;
    }

    abstract void showState();
}
