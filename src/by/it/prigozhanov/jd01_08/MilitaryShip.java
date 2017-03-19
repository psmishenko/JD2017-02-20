package by.it.prigozhanov.jd01_08;

/**
 * Created by v-omf on 3/11/2017!
 */
public abstract class MilitaryShip implements Ship {
    private boolean isAnchorUp;
    private boolean isEngineOn;
    private boolean isCoolingSystemOn;
    private boolean isMoving;
    private String name;
    private int speed;

    public MilitaryShip(String name) {
        this.name = name;
        isAnchorUp = false;
        isCoolingSystemOn = false;
        isEngineOn = false;
        isMoving = false;
    }


    abstract void showState();

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public boolean isAnchorUp() {
        return isAnchorUp;
    }

    public void setAnchorUp(boolean anchorUp) {
        isAnchorUp = anchorUp;
    }

    public boolean isEngineOn() {
        return isEngineOn;
    }

    public void setEngineOn(boolean engineOn) {
        isEngineOn = engineOn;
    }

    public boolean isCoolingSystemOn() {
        return isCoolingSystemOn;
    }

    public void setCoolingSystemOn(boolean coolingSystemOn) {
        isCoolingSystemOn = coolingSystemOn;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    @Override
    public void anchorUp() {
        isAnchorUp = true;
    }

    @Override
    public void anchorDown() {
        isAnchorUp = false;
    }

    @Override
    public void engineOn() {
        isEngineOn = true;
    }

    @Override
    public void engineOff() {
        isEngineOn = false;
    }

    @Override
    public void coolingSystemOn() {
        isCoolingSystemOn = true;
    }

    @Override
    public void coolingSystemOff() {
        isCoolingSystemOn = false;
    }

    @Override
    public void move() {
        isMoving = true;
        speed = getSpeed();
    }

    @Override
    public void stop() {
        isMoving = false;
        speed = 0;
    }
}
