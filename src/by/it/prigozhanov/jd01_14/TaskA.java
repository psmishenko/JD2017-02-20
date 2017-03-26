package by.it.prigozhanov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-omf on 3/24/2017!
 */
public class TaskA {
    public static void main(String[] args) {
        String root= System.getProperty("user.dir");
        String path = root + "/src/by/it/prigozhanov/jd01_14/";
        String filename = path+"taskA.data";
        try (FileOutputStream fs = new FileOutputStream(filename);
             BufferedOutputStream bo = new BufferedOutputStream(fs);
             DataOutputStream dout = new DataOutputStream(bo)) {
            for (int i = 0; i < 50; i++) {
                int value = (int) (Math.random()*100);
                dout.writeInt(value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fi = new FileInputStream(filename);
        BufferedInputStream bi = new BufferedInputStream(fi);
        DataInputStream din = new DataInputStream(bi)) {
            List<Integer> values = new ArrayList<>();
            double sum = 0;
            while (din.available() > 0) {
               Integer value = din.readInt();
               values.add(value);
               sum +=value;
            }
            System.out.println(values);
            if (values.size() != 0) {
                System.out.printf("Average=%f", sum/values.size());
            } else  System.out.println("No data");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
