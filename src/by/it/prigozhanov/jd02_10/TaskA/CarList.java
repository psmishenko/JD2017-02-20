package by.it.prigozhanov.jd02_10.TaskA;

import java.util.List;

/**
 * Created by v-omf on 4/23/2017.
 *
 * @author v-omf
 */
public class CarList {
    private List cars;

    public CarList() {}

    public CarList(List cars) {
        this.cars = cars;
    }

    public List getCars() {
        return cars;
    }

    public void setCars(List cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarList{" +
                "cars=" + cars +
                '}';
    }
}
