package by.it.prigozhanov.jd02_10.TaskA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-omf on 4/23/2017.
 *
 * @author v-omf
 */
public class PojoToJson {

    public static void main(String[] args) {

        String pathToJsonFile = "src/by/it/prigozhanov/jd02_10/TaskA/CarList.json";
        List<Car> cars = new ArrayList();
        StringBuilder sb = new StringBuilder();
        Car car;
        cars.add(new Car("Aston Maritn", 650, 4, 3, 2));
        cars.add(new Car("Porsche Panamera", 700, 4, 3, 4));
        cars.add(new Car("BMW M3 E92", 429, 2, 3, 4));
        CarList carList = new CarList(cars);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String text = gson.toJson(carList);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(pathToJsonFile))) {
            bf.write(text);
            System.out.println("JSON файл успешно создан!");
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }


    }

}
