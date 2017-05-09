package by.it.prigozhanov.jd03_02.test_crud;

import by.it.prigozhanov.jd03_02.beans.Car;
import by.it.prigozhanov.jd03_02.crud.CarCRUD;

import java.sql.SQLException;

/**
 * Created by v-omf on 5/1/2017.
 *
 * @author v-omf
 */
public class TestCar {
    public static void main(String[] args) throws SQLException {
        Car car = new Car(3,"Porsche","Panamera",750,"Minsk",3);
        System.out.println(car);
        CarCRUD carCRUD = new CarCRUD();
        if (carCRUD.create(car)) {
            System.out.println("CREATED: "+ car);
        }

        if (car!=null) {
            System.out.println("READ: " + carCRUD.read(car));
        }

        if (carCRUD.update(car)) {
            System.out.println("UPDATED: " + car);
        }

        if (carCRUD.delete(car)) {
            System.out.println("DELETED: " + car);
        }



    }
}
