package by.it.prigozhanov.jd03_02;

import by.it.prigozhanov.jd03_02.crud.CarCRUD;
import by.it.prigozhanov.jd03_02.xml.generated.Car;
import by.it.prigozhanov.jd03_02.xml.generated.CarList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.math.BigInteger;
import java.sql.SQLException;

/**
 * Created by v-omf on 5/2/2017.
 *
 * @author v-omf
 */
public class TaskCfromXMLtoDB {

    public static void main(String[] args) throws SQLException {
        try {
            CarCRUD carCRUD = new CarCRUD();
            JAXBContext context = JAXBContext.newInstance(CarList.class);
            Unmarshaller u = context.createUnmarshaller();

            String path = "src/by/it/prigozhanov/jd03_02/xml/CarRental+XSD.xml";

            FileReader fileReader = new FileReader(new File(path));
            Object o = u.unmarshal(fileReader);
            CarList carList = (CarList) o;
            for (int i = 0; i < carList.getCar().size(); i++) {
                Car xmlCar = carList.getCar().get(i);
                String mark = xmlCar.getMark();
                String model = xmlCar.getModel();
                Integer hp = xmlCar.getHP();
                String location = xmlCar.getLocation();
                Integer luggageCapacity = xmlCar.getLuggageCapacity();
                carCRUD.create(new by.it.prigozhanov.jd03_02.beans.Car(0, mark, model, hp, location, luggageCapacity));
                System.out.println("Объект: " + carList.getCar().get(i) + " добавлен");
            }
            System.out.println("Объекты добавлены");



        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
