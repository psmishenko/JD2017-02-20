package by.it.prigozhanov.jd01_08;

/**
 * Created by v-omf on 3/11/2017!
 */
public interface Ship {
    void anchorUp();
    void anchorDown();
    void engineOn();
    void engineOff();
    void coolingSystemOn();
    void coolingSystemOff();
    void move();
    void stop();
    void takeoffTheAirplane(int amountOfAirplanes);
}
