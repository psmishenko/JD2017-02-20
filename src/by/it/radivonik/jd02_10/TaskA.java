package by.it.radivonik.jd02_10;

import by.it.radivonik.jd02_10.beans.*;
import by.it.radivonik.jd02_10.test.TestNaklads;
import com.google.gson.*;
import java.io.*;

/**
 * Created by Radivonik on 23.04.2017.
 */
public class TaskA {
    public <T> void run(Class<T> classBean, String filejson) {
        T bean = (T) TestNaklads.getTest();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().setPrettyPrinting().create();

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filejson))) {
            System.out.println("POJO->JSON (также см. файл: " + filejson + "):");
            String json = gson.toJson(bean);
            fileWriter.write(json);
            System.out.println("POJO:\n" + bean);
            System.out.println("JSON:\n" + json);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filejson))) {
            System.out.println("JSON->POJO:");
            bean = gson.fromJson(fileReader, classBean);
            System.out.println("POJO:\n" + bean);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
