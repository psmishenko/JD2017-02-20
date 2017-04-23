package by.it.prigozhanov.jd02_10.TaskA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by v-omf on 4/23/2017.
 *
 * @author v-omf
 */
public class JsonToPojo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String pathToJsonFile = "src/by/it/prigozhanov/jd02_10/TaskA/CarList.json";
        try (BufferedReader br = new BufferedReader(new FileReader(pathToJsonFile))){
            while (br.ready()) {
                sb.append(br.readLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        CarList carList = gson.fromJson(sb.toString(), CarList.class);
        System.out.println(carList.toString());
    }
}
