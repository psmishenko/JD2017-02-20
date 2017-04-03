package by.it.vedom.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/vedom/jd01_14/";
        String fileName = path + "TaskA.data";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)) {

            for (int i = 0; i < 20; i++) {
                int value = (int)(Math.random()*100);
                dataOutputStream.write(value);
            }
        }
    catch (IOException e) {
            e.printStackTrace();
        }
        //после catch автоматическое закрытие close();
        //Восстановление данных
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {

            List<Integer> values = new ArrayList<>();
            int sum = 0;
            while (dataInputStream.available() > 0) {
                int value = dataInputStream.readInt();
                sum += value;
                values.add(value);
            }
            System.out.println(values);
            if (values.size() > 0) {
                System.out.printf("Average = %f", (double)sum/values.size());
            }
            else  System.out.println("No data.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
