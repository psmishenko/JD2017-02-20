package by.it.ikavalenka.jd_14;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 24.03.2017.
 */
public class TaskA {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/ikavalenka/jd_14/";      //Или можно указать  полный путь к файлу (без root)
        String filename = path + "taskA.data";

        try (FileOutputStream fs = new FileOutputStream(filename); //need edit
             BufferedOutputStream bo = new BufferedOutputStream(fs);
             DataOutputStream dout = new DataOutputStream(bo)) {

            for (int i = 0; i < 20; i++) {
                int value =(int) (Math.random()*100);
                dout.writeInt(value);
            }
        }

         catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fi = new FileInputStream(filename);
             BufferedInputStream bi = new BufferedInputStream(fi);
             DataInputStream dinput = new DataInputStream(bi)) {
            List<Integer> values = new ArrayList<>();
//            for (int i = 0; i < 20; i++)


            int sum = 0;
            while (dinput.available() > 0) {
                int value = dinput.readInt();
                sum += value;
                values.add(value);
            }
            System.out.println(values);
            if (values.size() > 0) {
                System.out.printf("AVG=%f", (double) sum / values.size());// need edit
            } else
            {
    System.out.println("No data");
}


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}