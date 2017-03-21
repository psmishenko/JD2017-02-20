package by.it.prigozhanov.jd01_08;

/**
 * Created by v-omf on 3/11/2017!
 */
public abstract class MilitaryShip implements Ship {
boolean isAnchorUp;
boolean isEngineOn;
boolean isCoolingSystemOn;
boolean isMoving;
private String name;



    public String getName() {
    return name;
}

    public void MilitaryShip(String name) {
        this.name = name;
        isAnchorUp = true;
        isCoolingSystemOn = false;
        isEngineOn = false;
        isMoving = false;
    }





}
