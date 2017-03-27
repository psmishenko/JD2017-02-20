package by.it.radivonik.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Radivonik on 24.03.2017.
 * Класс, реализующий задания Варианта A
 */
public class TaskA {
    public static void run() {
        String path = System.getProperty("user.dir") + "/src/by/it/radivonik/jd01_14";
        String filename = path + "/taskA.dat";

        // Запись данных в файл
        try (DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random() * 100);
                ds.writeInt(value);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение данных из файла
        try (DataInputStream ds = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)))){
            List<Integer> values = new ArrayList<>();
            double sum = 0;
            while (ds.available() > 0) {
                int val = ds.readInt();
                values.add(val);
                sum += val;
            }
            System.out.println(values);
            System.out.println("Среднее арифметическое: " + sum / values.size());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
